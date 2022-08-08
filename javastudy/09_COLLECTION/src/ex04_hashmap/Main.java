package ex04_hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	
	public static void m1() {
	
		// Map 생성
		// Map <Key,Value>
		
		Map<String, String> dictionary = new HashMap<String, String>();
	
		
		// 추가
		// 새로운 key값을 사용하면 추가
		dictionary.put("apple", "사과");     // put(Key, Value)   사과라는 value를 꺼내려면 apple이라는 key값이 필요
		dictionary.put("banana", "바나나");
		dictionary.put("tomato", "토마토");
		dictionary.put("mango", "망고");
		dictionary.put("melon", "멜론");
	
		
		// 수정
		// 기존의 Key값을 사용하면 수정
		dictionary.put("melon", "메론");
		
		
		// 삭제
		// 삭제할 요소의 key를 전달하면 삭제됨
		// 삭제된 value가 반환됨
		String removeItem = dictionary.remove("tomato");
		System.out.println(removeItem);       // 토마토
		
		
		// 값(Value)의 확인
		System.out.println(dictionary.get("apple"));      // 사과
		System.out.println(dictionary.get("peach"));      // null     
		  
		
		// 확인
		
		System.out.println(dictionary);
		
	}
	
	public static void m2() {
		
		// Value를 String으로 관리하기
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("title", "어린왕자");
		map1.put("author", "생텍쥐베리");
		map1.put("price", 10000 +"");
		System.out.println(map1);
		
				
		// Value를 Object로 관리하기  주로 사용됨
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("title", "홍길동전");
		map2.put("author", "허균");
		map2.put("price", 20000);
		System.out.println(map2);
		
	}
	
	public static void m3() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("title", "소나기");
		map.put("author", "황순원");
		map.put("price", 20000);
		
		// Entry 단위로 순회 (for)
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());			
		}
		
		
		// Key를 이용한 순회 (for)
		for(String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		
	}
	
	public static void m4() {
		
		// 연습
		// title, author, price 정보를 가진 임의의 Map 3개를 만들고,
		// 생성된 Map 3개를 ArrayList에 저장한 뒤
		// ArrayList에 저장된 Map 3개를 for문으로 순회하시오.
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		
		map1.put("title", "소나기");
		map1.put("author", "황순원");
		map1.put("price", 10000);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		
		map2.put("title", "어린왕자");
		map2.put("author", "생텍쥐베리");
		map2.put("price", 10000);
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		
		map3.put("title", "홍길동전");
		map3.put("author", "허균");
		map3.put("price", 30000);
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		for(Map<String, Object> map : list) {   // List의 for문
			for(Map.Entry<String, Object> entry : map.entrySet()) {   // Map의 for문
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
			System.out.println();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		m4();
	}

}
