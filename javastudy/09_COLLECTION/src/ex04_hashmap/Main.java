package ex04_hashmap;

import java.util.HashMap;
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
	public static void main(String[] args) {
		m2();
	}

}
