package com.gdu.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;



public class ApiSearchBook {
	
	public static void main(String[] args) {
		
		String clientId ="0Sq0xorLLf7u2feWMPS6";
		String clientSecret="jVLtZulxdG";
		
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("검색어를 입력하세요 ▷ ");
			String search = sc.next();
			
			String apiURL = "https://openapi.naver.com/v1/search/book?query=" + URLEncoder.encode(search, "UTF-8") ;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.addRequestProperty("X-Naver-Client-Id", clientId);
			con.addRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			BufferedReader br = null;
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			sc.close();
			con.disconnect();
			
			JSONObject obj = new JSONObject(sb.toString());
			JSONArray items = obj.getJSONArray("items");
			System.out.println(items);
			
			File dir =  new File("C://download");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			File file = new File(dir, search + ".html");
			PrintWriter out = new PrintWriter(file);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>시험시험시험</title>");
			out.println("</head>");			
			out.println("<body>");
			for(int i = 0; i < obj.length(); i++) {
				JSONObject book = items.getJSONObject(i);
				String title = book.getString("title");
				String link = book.getString("link");
				String image = book.getString("image");
				out.println("<a href='" + link + "'>" + title + "</a>" );
				out.println("<br>");
				out.println("<img src=\"" + image + "\" height=200px;>");	
				out.println("<hr>");
				out.println("<br>");
			}
			out.println("</body>");
			out.println("</html>");
			out.close();
			
			System.out.println();
		} catch(Exception e) {
			e.getMessage();
			try {
				Date date = new Date(System.currentTimeMillis());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd a h:mm:ss");
				String errorTime = sdf.format(date);
				
				File dir = new File("C://download/log");
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				File file = new File(dir, "error_log.txt");
				PrintWriter out = new PrintWriter(file);
				out.println("예외메시지    " + e.getMessage());
				out.println("예외발생시간    " + errorTime);
				out.close();
			} catch(Exception e2) {
				e2.getMessage();
			}
		}

	}
}
