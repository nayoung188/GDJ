package quiz01_library;

public class Main {
	
	public static void main(String[] args) {
		
		/*Book[] books -> List{<Book> books
		 * Library.java
		 * addBook()  -  Full Check 없어짐
		 * removeBook()  -  Empty Check 필요함 ( 예외처리로 변경 )
		 *   removeBookBuIndex()  -   인덱스 정보를 이용해서 제거 
		 *   removeBookByObject()  -  객체(Book) 정보를 이용해서 제거
		 * findBook() - Empty Check 필요함 ( 예외처리로 변경 )
		 * printAllBooks()  -  Empty Check 필요함 ( 예외처리로 변경 )
		 * 
		 * 추가
		 * modifyBook()   -     책 제목을 입력 받아서 일치하는 책의 정보를 변경
		 */
		
		
		
		
		Library library = new Library();
		library.manage();
		
		Book book1 = new Book ( 1, "어린왕자", "생텍쥐페리");
		Book book2 = new Book ( 1, "어린왕자", "생텍쥐페리");
		
		System.out.println(book1.equals(book2));
		
	}
	
}
