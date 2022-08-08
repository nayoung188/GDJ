package quiz01_library;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Library {
	
	private Scanner sc;
	private List<Book> books;

	public Library() {
		sc = new Scanner(System.in);
		books = new ArrayList<Book>();
	}
	
	private void addBook() {
		System.out.println("책 등록");
		System.out.println("책 번호 입력 >>> ");
		int bookNo = sc.nextInt();
		System.out.println("제목 입력 >>> ");
		String title = sc.next();
		System.out.println("저자 입력 >>> ");
		String author = sc.next();	
		Book book = new Book(bookNo, title, author);
		books.add(book);	
	
	}
	
	private void removeBookByIndex() {
		// Book remove(int index) 메소드 이용 ( 인덱스 정보 전달, 제거된 정보 반환 )
		
		if (books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		
		System.out.println("===책삭제===");
		System.out.print("삭제할 책의 번호 >>> ");
		int bookNo = sc.nextInt();
		for(int i = 0, length = books.size(); i < length; i++) {
			if(books.get(i).getBookNo() == bookNo) {
				Book removeBook = books.remove(i);
				System.out.println(removeBook + " 책을 삭제했습니다.");
				return;
			}
		}
		
		throw new RuntimeException("책 번호가 " + bookNo + "인 책이 없습니다.");
	}
	
	private void removeBookByObject() {
		// boolean remove(Object obj)  ( book을 전달하면 삭제 )
		if (books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		
		System.out.println("책 번호 입력 >>> ");
		int bookNo = sc.nextInt();
		System.out.println("제목 입력 >>> ");
		String title = sc.next();
		System.out.println("저자 입력 >>> ");
		String author = sc.next();	
		Book book = new Book(bookNo, title, author);
		if (books.remove(book)) {
			System.out.println(book + " 책을 삭제했습니다.");
		}
		
		throw new RuntimeException(book + "인 책이 없습니다.");
	}
	
	public void findBook() {
		
		if (books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		
		System.out.println("===책조회===");
		System.out.print("조회할 책제목 입력 >>> ");
		String title = sc.next();
		for( int i = 0, length = books.size(); i < length; i++) {
			if(books.get(i).getTitle().equals(title)) {
				System.out.println(books.get(i));
				return;
			}
		}
		
		throw new RuntimeException("제목이 " + title + "인 책이 없습니다.");
	}
	
	public void printAllBooks() {
		if (books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		System.out.println("===전체조회===");
		for( Book book : books) {
			System.out.println(book);
		}
	}
	
	public void manage() {
		
		while(true) {
			
			try {
				System.out.print("1.추가 2.삭제 3.조회 4.전체목록 0.프로그램종료 >>> ");
				int choice = sc.nextInt();
				sc.nextLine();     
				switch(choice) {
				case 1 : addBook(); break;
				case 2 : removeBookByIndex(); break;   // removeBookByObject() 가능
				case 3 : findBook(); break;
				case 4 : printAllBooks(); break;
				case 0 : System.out.println("Library 프로그램을 종료합니다. 감사합니다."); 
					return;     
				default : System.out.println("알 수 없는 명령입니다. 다시 시도하세요."); 
				}		
				
			} catch(InputMismatchException e) {
				sc.next();
				System.out.println("명령은 정수입니다.");
			} catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
}
