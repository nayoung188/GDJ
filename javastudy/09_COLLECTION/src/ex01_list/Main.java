package ex01_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void m1() {
		
		// 생성
		// 1. 제네릭 (Generic) 기반
		// 2. 생성할 때 데이터타입을 결정 (구체화)		
		
		List<String> list = new ArrayList<String>();    // <E> -> 제네릭, 데이터타입 기입
		
		
		// 요소 추가
		// 1. 인덱스 지정이 없으면 순서대로 저장
		// 2. 인덱스 지정도 가능
		
		list.add("월");
		list.add("화");
		list.add(0, "일");
		
		
		// 요소 제거
		// 1. boolean remove(Object obj) : obj 제거, 성공하면 true 반환
		// 2. Object remove(int index) : index 위치의 요소 제거. 제거한 요소 반환
		boolean result = list.remove("일");
		System.out.println(result);
		String removeItem = list.remove(0);
		System.out.println(removeItem);
		
		
		// 요소 수정
		list.set(0, "일");
		
	
		// 리스트 확인
		
		System.out.println(list);		
	}
	
	public static void m2() {
		
		// 리스트 초기화
		// 1. 배열을 리스트로 변환
		// 2. 고정된 크기를 가짐 (길이가 고정되어 추가, 삭제 불가)
		
		List<String> list = Arrays.asList("일", "월", "화", "수");     // asList(String...a) -> String이 여러개 들어갈 수 있다. 갯수는 정해지지 않음
		
		
		// 리스트 길이
		
		int size = list.size();
		System.out.println(size);
		
		
		
		// 개별 요소
		
		String element1 = list.get(0);
		String element2 = list.get(1);
		String element3 = list.get(2);
		String element4 = list.get(3);
		System.out.println(element1);
		System.out.println(element2);
		System.out.println(element3);
		System.out.println(element4);
		
		
		// for문 순회
		// size() 메소드 호출을 한 번만 진행
		
		
		/*
		// 기존 배열
		String[] arr = {"일", "월", "화", "수"};
		for (int i = 0 ; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		for(int i = 0; i <list.size(); i++) {    // list의 사이즈 메소드를 여러번 호출하게 됨.  성능이 떨어지게 됨
			System.out.println(list.get(i));
		}
		
		*/
		
		// 개선
		for(int i = 0, length = list.size(); i < length; i++) {     // 메소드를 한번만 호출
			System.out.println(list.get(i));
		}
		
		
		// 향상 for문 순회
		for(String element : list) {
			System.out.println(element);
		}
	}
	
	public static void m3() {
		
		// 제네릭
		// 1. 참조 타입만 사용 가능
		// 2. 기본 타입이 필요한 경우 기본 타입의 Wrapper Class를 사용
		// List<int> X   -->  List<Integer> O
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		
		
		// 비어 있는 리스트인가?
		boolean result = list.isEmpty();
		System.out.println(result);
		
		
		// 특정 요소를 포함하고 있는가?
		if (list.contains(4)) {
			System.out.println("4를 포함한다");
		} else {
			System.out.println("4를 포함하지 않는다");
		}
		
		
	}

	
	public static void main(String[] args) {
			
		m3();

	}

}
