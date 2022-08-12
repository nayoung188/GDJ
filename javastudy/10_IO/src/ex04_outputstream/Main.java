package ex04_outputstream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void m1() {
		
		
		File file = new File("C:\\storage","b1.bin");
		FileOutputStream fos = null;
		
		try {

			// C:\\storage\\b1.bin 파일과 연결되는 바이트 출력 스트림 생성
			fos = new FileOutputStream(file);
			
			// 출력할 데이터
			// 1. 1개 : int
			// 2. 여러 개 : byte[]
			
			// 출력할 데이터
			int c = 'A';
			String str = "pple Mango 맛있다.";
			byte[] b = str.getBytes(StandardCharsets.UTF_8);   // str.getBytes("UTF-8")
			
			// 출력
			fos.write(c);
			fos.write(b);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
		
	public static void m2() {
		
		// 출력 속도 향상을 위한 BufferedOutputStream
		
		File file = new File("C:\\storage","b2.bin");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {			
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);			
			String str = "안녕하세요 반갑습니다.";
			byte[] b = str.getBytes("UTF-8");		
			bos.write(b);			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if ( bos != null) bos.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}				
	}
	
	public static void m3() {
		
		// 변수를 그대로 출력하는 DataOutputStream    보조스트림이므로 메인스트림이 있어야 함
		
		File file = new File("C:\\storage","b3.dat");
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			
			// 출력할 변수
			String name = "에밀리";
			int age = 30;
			double height = 165.5;
			
			// 출력
			dos.writeUTF(name);
			dos.writeInt(age);
			dos.writeDouble(height);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if ( dos != null) dos.close();
			} catch ( IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void m4() {
		
		// 객체를 그대로 출력하는 ObjectOutputStream    -> 보조스트림
		
		File file = new File("C:\\storage","b4.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			
			// 1. User를 3개 저장한 ArrayList
			List<User> users = Arrays.asList(
					new User(1, "kim", 30),
					new User(2, "lee", 40),
					new User(3, "choi", 50)
			);			
			
			// 2. User 1개
			User user = new User(4, "min", 60);			
			
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(users);
			oos.writeObject(user);
			
		} catch ( IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	 	
		
	}
	
	public static void main(String[] args) {
		m4();
	}

}
