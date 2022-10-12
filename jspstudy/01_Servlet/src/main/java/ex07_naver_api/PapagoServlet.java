package ex07_naver_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PapagoServlet")
public class PapagoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트 아이디, 시크릿
		String clientId = "Rej7HZFR7ytYoaPiVPP_";
		String clientSecret = "sgC7aou44Z";
		
		// 요청 파라미터 (원본언어, 목적언어, 번역할 텍스트)
		String source = request.getParameter("source");
		String target = request.getParameter("target");
		String text = request.getParameter("text");
		
		// 번역할 텍스트
		try {
			text = URLEncoder.encode(text, "UTF-8");
		} catch(UnsupportedEncodingException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("번역할 텍스트 인코딩 실패");
			out.close();
		}
		
		// API 접속
		String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
		} catch(MalformedURLException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API URL이 잘못되었습니다.");
			out.close();
		} catch(IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 접속이 실패했습니다.");
			out.close();
		}
		
		// API 요청
		try {
			// 요청 헤더
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			// 요청 메소드
			con.setRequestMethod("POST");
			con.setDoOutput(true);		// con.setDoOutput(true) : 포스트 방식으로 보낼 데이터가 있다는 뜻
			// 포스트방식은 바디에 붙여서 보내준다. 파라미터 3개를 출력스트림을 사용하여 네이버로 보내주어야 한다.
			
			// 요청 파라미터 보내기
			String params = "source=" + source + "&target=" + target + "&text=" + text;
			OutputStream outputStream =  con.getOutputStream();    // outputStream은 스트링을 보내지 못하기 때문에 스트링을 바이트 배열로 바꾸어서 보내야한다
			outputStream.write(params.getBytes());
			outputStream.close();
			
		} catch(IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 요청이 실패했습니다");
			out.close();
		}
		
		//API 응답 스트림 생성 (정상 스트림, 에러 스트림)
		BufferedReader reader = null;
		try {
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK){
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
		} catch (IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 응답 스트림 생성이 실패했습니다");
			out.close();
		}
		
		// API 응답 (StringBuilder에 저장)
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 응답이 실패했습니다");
			out.close();
		}
		
		// client.html로 API 응답 결과 (StringBuilder) 보내기
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		out.close();

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
