package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import prac03.Movie;



public class ApiMain {

	public static void main(String[] args) {
	
		String serviceKey = "aJcw6UfRa/b1KW7wJ0vYvM4xyNFeo9R08KH7EI7DVz6mzQsRueWfsu1e1yZfAKD5KSkw6aspN8JWFHPuHBGHLQ==";
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			
			urlBuilder.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&searchYear=2021");
			urlBuilder.append("&siDo=1100");
			urlBuilder.append("&guGun=1125");
			urlBuilder.append("&type=json");			
			urlBuilder.append("&numOfRows=20");
			urlBuilder.append("&pageNo=1");
	
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
		String apiURL = urlBuilder.toString();
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
		}catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		}catch(IOException e) {
			System.out.println("API 주소 접속 실패");
		}
		
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			
		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}
		
		String response = sb.toString();
		
		/*
		File file = new File("C:\\storage","accident.txt");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		con.disconnect();
		
		File file =  new File("C:\\storage","accident.txt");
		List<Accident> Accs = new ArrayList<Accident>();
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			NodeList accidentList = doc.getElementsByTagName("accident");
			
			for( int i = 0; i < accidentList.getLength(); i++) {
				Element accident = (Element)accidentList.item(i);			
				String occrrncDt = accident.getElementsByTagName("occrrncDt").item(0).getTextContent();
				String occrrncDayCd = accident.getElementsByTagName("occrrncDayCd").item(0).getTextContent();
				String dthDnvCnt = accident.getElementsByTagName("dthDnvCnt").item(0).getTextContent();
				String injpsnCnt = accident.getElementsByTagName("injpsnCnt").item(0).getTextContent();
				
				Accident acc = Accident.builder();
				.occrrncDt(occrrncDt)
				.occrrncDayCd(occrrncDayCd)
				.dthDnvCnt(dthDnvCnt)
				.injpsnCnt(injpsnCnt)
				.build();
				
				acc.add(Accs);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(Accident acc : Accs) {
			System.out.println(Accs);
		}

		
		
		
		
	}
	
	
	
	

}
