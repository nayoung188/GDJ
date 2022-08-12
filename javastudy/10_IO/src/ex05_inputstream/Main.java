package ex05_inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

	public static void m1() {
		
		File file = new File("C:\\storage", "b1.bin");
		FileInputStream fis = null;
		
		try {
			
			// 바이트 입력 스트림 생성
			fis = new FileInputStream(file);
			
			// 입력 데이터 단위
			// 1. 1개 : int
			// 2. 여러 개 : byte[]
			
			// 모든 정보를 StringBuilder에 저장한 뒤 확인
			StringBuilder sb = new StringBuilder();
			byte[] b = new byte[5];      // 5바이트씩 읽기 위해서 준비
			int readByte = 0;
			
			// int read(byte[] b) 메소드 
			// 읽은 내용은 byte배열 b에 저장
			// 읽은 바이트 수를 반환
			// 읽은 내용이 없으면 -1 반환
			
			while ((readByte = fis.read(b)) != -1 ) {
				sb.append(new String(b, 0, readByte));
			}
			
			// 문자를 바이트 스트림으로 읽었기 때문에
			// 문제가 발생
			System.out.println(sb.toString());
			
			
		} catch( IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
		
	public static void m2() {

		
		// ☆중요
		
			
		
		
	}
	
	public static void m3() {

		
		
		
		
	}
	
	

	public static void m4() {
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		m2();
	}

}
