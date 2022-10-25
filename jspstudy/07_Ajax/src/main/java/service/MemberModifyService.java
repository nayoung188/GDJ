package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Member;
import repository.MemberDao;

public class MemberModifyService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String grade = request.getParameter("grade");
		String address = request.getParameter("address");
		
		// DB로 보낼 Member member 생성
		Member member = Member.builder()
				.id(id)
				.name(name)
				.gender(gender)
				.grade(grade)
				.address(address)
				.build();
		
		// 수정 결과
		int result = 0;
		
		try {			// 수정의 성공 실패 여부는 예외처리와 관련
			// 수정
			result = MemberDao.getInstance().updateMember(member);
			
			// 성공 응답 데이터 타입 : JSON
			response.setContentType("application/json; charset=UTF-8");
			
			// 응답 데이터
			/*
			  		수정 성공 응답 데이터
			  		{"isSuccess" : true}
			  		
			  		수정 실패 응답 데이터
			  		{"isSuccess" : false}  
			 */
			JSONObject obj = new JSONObject();
			obj.put("isSuccess", result > 0);
			
			
			// 응답 ($.ajax의 success 프로퍼티로 전달)
			PrintWriter out = response.getWriter();
			out.println(obj.toString());
			out.close();
			
		} catch(Exception e) {
			// 예외 발생 시 응답 (unique 위반, not null 위반, 칼럼 크기 위반 등)
			
			
			// 응답 데이터 형식 : 일반 텍스트
			response.setContentType("text/plain; charset=UTF-8");
			
			//응답 ($.ajax의 error 프로퍼티로 전달)
			PrintWriter out = response.getWriter();
			out.println("회원 정보가 수정되지 않았습니다.\n입력 정보를 확인하세요");
			out.close();
		}

	}

}
