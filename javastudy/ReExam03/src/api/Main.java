package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class Main {

	public static void main(String[] args) {
		
		
		// XML 파싱
		// API응답 (XML)   ->   XML 파일   ->  Document
		
		// JSON 파싱
		// API응답 (JSON)  -> JSONObject
		
		try {
		
			String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";      // 파라미터가 이미 존재함
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			//con.setRequestMethod("GET");    // 안적었어도 읽어들이기 가능
			//con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");    // 안적었어도 읽어들이기 가능
			
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			// 파싱 결과를 저장할 파일
			File file = new File("test.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			// StringBuilder에 저장된 응답(XML) 데이터를 JSON으로 변경하기
			JSONObject obj = XML.toJSONObject(sb.toString());
			JSONObject rss = obj.getJSONObject("rss");
			JSONObject channel = rss.getJSONObject("channel");
			
			//JSONObject channel = XML.toJSONObject(sb.toString())
			//						.getJSONObject("rss")
			//						.getJSONObject("channel");
			// 이방법으로 하기를 추천
					
			String link = channel.getString("link");
			String description = channel.getString("description");
			String generator = channel.getString("generator");
			String language = channel.getString("language");
			String title = channel.getString("title");
			String pubDate = channel.getString("pubDate");
			bw.write(pubDate+"\n");
			
			JSONObject item = channel.getJSONObject("item");
			String author = item.getString("author");
			String link2 = item.getString("link");
			String category = item.getString("category");
			bw.write(category + "\n");
			
			String title2 = item.getString("title");
			JSONObject description2 = item.getJSONObject("description");
			JSONObject body = description2.getJSONObject("body");
			JSONArray dataList = body.getJSONArray("data");
			for(int i = 0; i < dataList.length(); i++) {
				JSONObject data = dataList.getJSONObject(i);
				int sky = data.getInt("sky");
				int temp = data.getInt("temp");
				String wfKor = data.getString("wfKor");
				int wd = data.getInt("wd");
				int hour = data.getInt("hour");
				bw.write(hour + "시, "  + temp + "도, " + wfKor + "\n");
			}
			
			bw.close();
			br.close();
			con.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}    // 노란색들은 제출 안해도 됨
