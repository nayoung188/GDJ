package com.gdu.app05.service;

import java.net.HttpURLConnection;
import java.net.URL;

public class MovieServiceImpl implements MovieService {

	@Override
	public String getBoxOffice(String targetDt) {
		
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
		String key = "237ebe8709d5796d5cf9a4a39354d0a9";
		
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return targetDt;
	}

}
