package ex03_hash;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
	/*
		
		Book book1 = new Book();
		System.out.println(book1.hashCode());     // 410495873 - book1 객체의 참조값

		Book book2 = new Book();
		System.out.println(book2.hashCode());     // 811587677 - book2 객체의 참조값
		  
		
		System.out.println(book1.equals(book2));
	
	} */

		
		Book book1 = new Book(1,"어린왕자");
		Book book2 = new Book(2,"홍길동전");
		Book book3 = new Book(3,"소나기");
		Book book4 = new Book(3,"소나기");
		
		System.out.println(book3.hashCode());
		System.out.println(book4.hashCode());
		
		
		Set<Book> books = new HashSet<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);     // 중복 저장 시도 (정상 동작하려면 Book 클래스에 hashCode(), equals() 메소드를 오버라이드 해야 함)
		
		for(Book book : books) {
			System.out.println(book);
		}
		
	}		

}
