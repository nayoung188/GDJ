package com.gdu.app13.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.app13.domain.RetireUserDTO;
import com.gdu.app13.domain.UserDTO;
import com.gdu.app13.mapper.UserMapper;
import com.gdu.app13.util.SecurityUtil;

@PropertySource(value = {"classpath:email.properties"})
@Service
public class UserServiceImpl implements UserService {
	
	// 이메일을 보내는 사용자 정보
	@Value(value = "${mail.username}")
	private String username;  // 본인 지메일 주소
	
	@Value(value="${mail.password}")
	private String password;  // 발급 받은 앱 비밀번호
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SecurityUtil securityUtil;

	@Override
	public Map<String, Object> isReduceId(String id) {
		
		// selectUserByMap 추가 부분
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		// selectUserByMap 수정 부분
		// result.put("isUser", userMapper.selectUserById(id) != null);			// null이 아니면 true => 조회되면 true
		result.put("isUser", userMapper.selectUserByMap(map) != null);
		
		result.put("isRetireUser", userMapper.selectRetireUserById(id) != null);
		return result;
	}
	
	@Override
	public Map<String, Object> isReduceEmail(String email) {
		
		// selectUserByMap 추가 부분	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		// selectUserByMap 수정 부분
		// result.put("isUser", userMapper.selectUserByEmail(email) != null);
		
		result.put("isUser", userMapper.selectUserByMap(map) != null);
		return result;
	}
	
	
	@Override		// 인증코드 발송
	public Map<String, Object> sendAuthCode(String email) {

		// 인증코드 만들기
		// String authCode = securityUtil.generateRandomString(6);		// 디펜던시로 만들어주는것 (스프링이 해줌)
		String authCode = securityUtil.getAuthCode(6);		// 수동으로 만든것
		System.out.println("발송된 인증코드 : " + authCode);
		
		// 이메일 전송을 위한 필수 속성을 properties 객체로 생성
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");			// 구글 메일로 보냄 (보내는 메일은 구글메일만 가능)
		properties.put("mail.smtp.port", "587");					// 구글 메일로 보내는 포트 번호
		properties.put("mail.smtp.auth", "true");					// 인증된 메일
		properties.put("mail.smtp.starttls.enable","true");			// TLS 허용
		
		/*
			이메일 보내기 API 사용을 위한 사전 작업
			
			1. 구글 로그인
			2. Google계정 - 보안
				1) 2단계 인증 	- 사용
				2) 앱 비밀번호
					(1) 앱 선택   : 기타
					(2) 기기 선택 : Windows 컴퓨터
					(3) 생성 버튼 : 16자리 앱 비밀번호를 생성해 줌 (이 비밀번호를 이메일 보낼 때 사용) 
		*/
		
		// 사용자 정보를 javax.mail.Session에 저장
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		// 이메일 작성 및 전송
		try {
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(username, "인증코드관리자"));		// 보내는 사람
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));			// setRecipients 는 여러사람에게 보낼때 사용  // 받는사람
			message.setSubject("[Application] 인증 요청 메일입니다.");				// 제목
			message.setContent("인증번호는 <strong>" + authCode + "</strong>입니다.", "text/html; charset=UTF-8");		// 내용
			
			Transport.send(message);		// 이메일 전송
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// join.jsp로 반환할 데이터
		// 생성한 인증코드를 보내줘야 함
		// 그래야 사용자가 입력한 인증코드와 비교를 할 수 있음
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("authCode", authCode);
		return result;
	}
	
	@Transactional			// INSERT, UPDATE, DELETE 중 2개 이상이 호출되는 서비스에서 필요함
	@Override
	public void join(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String birthyear = request.getParameter("birthyear");
		String birthmonth = request.getParameter("birthmonth");
		String birthdate = request.getParameter("birthdate");
		String postcode = request.getParameter("postcode");
		String roadAddress = request.getParameter("roadAddress");
		String jibunAddress = request.getParameter("jibunAddress");
		String detailAddress = request.getParameter("detailAddress");
		String extraAddress = request.getParameter("extraAddress");
		String location = request.getParameter("location");
		String promotion = request.getParameter("promotion");
		
		// 일부 파라미터는 DB에 넣을 수 있도록 가공
		pw = securityUtil.sha256(pw);
		name = securityUtil.preventXSS(name);
		String birthday = birthmonth + birthdate;
		detailAddress = securityUtil.preventXSS(detailAddress);
		int agreeCode = 0;		// 필수 동의
		if(!location.isEmpty() && promotion.isEmpty()) {
			agreeCode = 1; 		// 필수 + 위치
		} else if(location.isEmpty() && !promotion.isEmpty()) {
			agreeCode = 2;		// 필수 + 마케팅
		} else if ( !location.isEmpty() && !promotion.isEmpty()) {
			agreeCode = 3;		// 필수 + 위치 + 프로모션
		}
		
		// DB로 보낼 UserDTO 만들기
		UserDTO user = UserDTO.builder()
					  .id(id)
					  .pw(pw)
					  .name(name)
					  .gender(gender)
					  .email(email)
					  .mobile(mobile)
					  .birthyear(birthyear)
					  .birthday(birthday)
					  .postcode(postcode)
					  .roadAddress(roadAddress)
					  .jibunAddress(jibunAddress)
					  .detailAddress(detailAddress)
					  .extraAddress(extraAddress)
					  .agreeCode(agreeCode)
					  .build();
		// 회원가입처리
		int result = userMapper.insertUser(user);
		
		// 응답
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(result > 0) {
				
				// selectUserByMap 추가 부분
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", id);
				
				// selectUserByMap 수정 부분
				// request.getSession().setAttribute("loginUser", userMapper.selectUserById(id));
				
				// 로그인 처리를 위해서 session에 로그인 된 사용자 정보를 올려둠
				request.getSession().setAttribute("loginUser", userMapper.selectUserByMap(map));
				
				// 로그인 기록 남기기
				int updateResult = userMapper.updateAccessLog(id);
				if(updateResult == 0) {
					userMapper.insertAccessLog(id);
				}
				
				out.println("<script>");
				out.println("alert('회원 가입되었습니다.');");
				out.println("location.href='" + request.getContextPath() + "';");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('회원 가입에 실패했습니다.');");
				out.println("history.go(-2);");
				out.println("</script>");
			}
			out.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	@Transactional			// INSERT, UPDATE, DELETE 중 2개 이상이 호출되는 서비스에서 필요함
	@Override
	public void retire(HttpServletRequest request, HttpServletResponse response) {
		
		// 탈퇴할 회원의 userNo, id, joinDate는 session의 loginUser에 저장되어 있다.
		HttpSession session = request.getSession();
		UserDTO loginUser = (UserDTO)session.getAttribute("loginUser");
		
		// 탈퇴할 회원 RetireUserDTO 생성
		RetireUserDTO retireUser = RetireUserDTO.builder()
								  .userNo(loginUser.getUserNo())
								  .id(loginUser.getId())
								  .joinDate(loginUser.getJoinDate())
								  .build();
		
		// 탈퇴처리
		int deleteResult = userMapper.deleteUser(loginUser.getUserNo());
		int insertResult = userMapper.insertRetireUser(retireUser);
		
		// 응답
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(deleteResult > 0 && insertResult > 0) {
				
				// session 초기화 (로그인 사용자 loginUser 삭제를 위해서)  ★★★ 암기하기
				session.invalidate();
				
				out.println("<script>");
				out.println("alert('회원 탈퇴되었습니다.');");
				out.println("location.href='" + request.getContextPath() + "';");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('회원 탈퇴에 실패했습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
			out.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) {   // 자기 스스로 이동할수있는 코드가 있기 떄문에 반환타입을 void로 함
		
		// 파라미터
		String url = request.getParameter("url");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// pw는 DB에 저장된 데이터와 동일한 형태로 가공 (암호화)
		pw = securityUtil.sha256(pw);
		
		// DB로 보낼 UserDTO 생성 (Map으로 대체된 부분)
		//UserDTO user = UserDTO.builder()
		//				.id(id)
		//				.pw(pw)
		//				.build();
		
		// selectUserByMap 추가 부분
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		
		// selectUserByMap 수정 부분
		// UserDTO loginUser = userMapper.selectUserByIdPw(user);
					  
		// id, pw가 일치하는 회원을 DB에서 조회하기
		UserDTO loginUser = userMapper.selectUserByMap(map);
		
		// id, pw가 일치하는 회원이 있다 : 로그인 기록 남기기 + session에 loginUser 저장하기
		if(loginUser != null) {			
			
			// 로그인 기록 남기기
			int updateResult = userMapper.updateAccessLog(id);
			if(updateResult == 0) {
				userMapper.insertAccessLog(id);
			}		
			// 로그인 처리를 위해서 session에 로그인 된 사용자 정보를 올려둠
			request.getSession().setAttribute("loginUser", loginUser);
			
			// 이동 (로그인페이지 이전 페이지로 돌아가기)
			try {
				response.sendRedirect(url);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		// id, pw가 일치하는 회원이 없다 : 로그인 페이지로 돌려 보내기
		else {		
			// 응답
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('일치하는 회원 정보가 없습니다..');");
				out.println("location.href='" + request.getContextPath() + "';");
				out.println("</script>");
				out.close();			
			} catch(Exception e) {
				e.printStackTrace();
			}	
		}
	}

	
	
	
	
	
	
	
	
	
}
