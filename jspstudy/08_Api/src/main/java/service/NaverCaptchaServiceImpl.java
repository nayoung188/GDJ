package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


public class NaverCaptchaServiceImpl implements NaverCaptchaService {

	// field
	private final String CLIENT_ID ="Rej7HZFR7ytYoaPiVPP_";
	private final String CLIENT_SECRET	 ="sgC7aou44Z";
	
	@Override
	public String getCaptchaKey(HttpServletRequest request, HttpServletResponse response) {
		
		// code=0 : "키 발급", code=1 : "사용자 입력값 검증"
		String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=0";
		
		// 반환할 key 값 (네이버 API가 제공하는 캡차키)
		String key = null;
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			// apiURL 접속
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			
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
		

	}

	@Override
	public boolean validateUserInput(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

}
