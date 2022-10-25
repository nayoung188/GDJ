package service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;


public class NaverCaptchaServiceReset implements NaverCaptchaService {

	// field
	private final String CLIENT_ID ="Rej7HZFR7ytYoaPiVPP_";
	private final String CLIENT_SECRET	 ="sgC7aou44Z";
	
	@Override
	public String getCaptchaKey() {
		
		// code=0 : "키 발급", code=1 : "사용자 입력값 검증"
		String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=0";
		
		// 반환할 key 값 (네이버 API가 제공하는 캡차키)
		String key = null;
		
		try {
			// apiURL 접속
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			// 요청 메소드 (HTTP 메소드)
			con.setRequestMethod("GET");		// 대문자로 작성할 것

			// 요청 헤더 : 클라이언트 아이디, 클라이언트 시크릿
			con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
			con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
			
			// 입력 스트림 선택 및 생성 (네이버 API서버의 정보를 읽기 위함)
			BufferedReader reader = null;
			if(con.getResponseCode() == 200) {		// 200 : HttpURLConnection.HTTP_OK
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			// 네이버 API서버가 보낸 데이터 저장
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			// 네이버 API서버가 보낸 데이터 확인 및 반환
			JSONObject obj = new JSONObject(sb.toString());
			key = obj.getString("key");
			
			// 자원 반납
			reader.close();
			con.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return key;
	}

	@Override
	public void getCaptchaImage(HttpServletRequest request, String key) {
		
		String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
		
		try {
			// apiURL 접속
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			// 요청 메소드 (HTTP 메소드)
			con.setRequestMethod("GET");		// 대문자로 작성할 것

			// 요청 헤더 : 클라이언트 아이디, 클라이언트 시크릿
			con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
			con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
			
			// 입력 스트림 선택 및 생성 (네이버 API서버의 정보를 읽기 위함)
			// 이미지는 바이트기반의 스트림으로 받아와야 정상 처리 가능
			
			// 응답이 성공하면 이미지(JPG)가 응답
			if(con.getResponseCode() == 200) {		// 200 : HttpURLConnection.HTTP_OK
				// 저장할 캡쳐이미지 경로
				String dirname = "ncaptcha";
				String realPath = request.getServletContext().getRealPath(dirname);
				File dir = new File(realPath);
				if(dir.exists() == false ) {
					dir.mkdirs();
				}
				// 저장할 캡챠 이름 (이름이 똑같으면 안되기 때문에 타임스탬프사용)
				String filename = System.currentTimeMillis() + ".jpg";
				// 캡챠이미지 객체 생성
				File file = new File(dir, filename);
				// 네이버 API로부터 정보를 읽어서 (in) 서버경로에 저장(out)
				BufferedInputStream in = new BufferedInputStream(con.getInputStream());			// 입력받은 in, 파일을 보내기위한 out이 필요
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
				// 저장 (다운로드)
				byte[]b = new byte[1024];
				int readByte = 0;
				while((readByte = in.read(b)) != -1) {
					out.write(b, 0, readByte);    // b배열에 저장된 0번 인덱스 부터 readByte만큼
				}
				// login.jsp 로 전달할 데이터(캡챠이미지 경로 + 파일명)
				request.setAttribute("dirname", dirname);
				request.setAttribute("filename", filename);
				
				// 자원 반납
				out.close();
				in.close();
				
				
			} 
			// 응답이 실패하면 텍스트 형식으로 응답
			 else {
				 BufferedReader reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				StringBuilder sb = new StringBuilder();
				String line;
				while((line = reader.readLine()) != null) {
					sb.append(line);
				}
				System.out.println("<<응답 실패 사유>>");
				System.out.println(sb.toString());
				reader.close();
			}
			
			
			
			// 자원 반납
			con.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean validateUserInput(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

}
