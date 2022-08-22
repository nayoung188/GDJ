package api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class Accident {
     
    public static void main(String[] args) {
    	
    	File file = new File("accident.txt");
    	
    	StringBuilder sb = new StringBuilder();
    	
    	try(BufferedReader br = new BufferedReader(new FileReader(file))) {
    		String line = null;
    		while((line = br.readLine()) != null) {
    			sb.append(line);
    		}
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    	JSONObject obj = new JSONObject(file);
    	JSONObject response = obj.getJSONObject("response");
		JSONObject body = response.getJSONObject("body");
		JSONObject items = body.getJSONObject("items");
		JSONArray item = items.getJSONArray("item");
		
		for (int i = 0; i < item.length(); i++){
			JSONObject element = item.getJSONObject(i);
			System.out.println("발생일자 " + element.getString("occrrncDt") + element.getString("occrrncDayCd") + "요일, " + "사망자수 " + element.getInt("dthDnvCnt") + "명, " + "부상자수 " + element.getInt("injpsnCnt") + "명");
		}
    	
    
	}	
    
    
}

