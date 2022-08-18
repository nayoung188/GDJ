package ex01_file;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Main {
	
	
	public static void m1() {
		
		// File 클래스
		// 1. 패키지 : java.io
		// 2. 파일 및 디렉터리 관리
		// 3. 생성방법
		//	1) new File(경로, 파일)
		//	2) new File(파일)
		// 4. 윈도우의 경로 구분 방법 : 백슬래시 (\)
		// 5. 리눅스의 경로 구분 방법 : 슬래시 (/)
		
		
		// 폴더 ( 디렉터리 ) 만들기
		File dir = new File ("C:\\storage");

		// 존재하지 않으면 만들겠다.
		if(dir.exists() == false) {      // if(!dir.exist())  
			dir.mkdirs();          // 폴더가 하나일땐 dir, 여러개일땐 dirs
		}
		
		// 존재하면 삭제하겠다.
		else {
			//dir.delete();      // 지금 지운다.
			//dir.deleteOnExit();     // JVM이 종료되면 지운다.
		}
	
	}

	public static void m2() {
		
		File file = new File("C:\\storage", "my.txt");
		
		try {
			if (file.exists()  == false) {
				file.createNewFile();    
			}
			else {
				file.delete();
			}
	
		} catch(IOException e) {
			// 개발할 때 넣는 catch블록 코드
			e.printStackTrace();
		}
	}

	public static void m3() {
		
		File file = new File("C:\\storage","my.txt");
		System.out.println("파일명 : " + file.getName());
		System.out.println("경로 : " + file.getParent());
		System.out.println("전체경로(경로 + 파일명) : " + file.getPath());
		
		System.out.println("디렉터리인가? " + file.isDirectory());
		System.out.println("파일인가? " + file.isFile());
		
		long lastModifiedDate = file.lastModified();               // 타임스탬프로 반환한다
		System.out.println("수정한 날짜 : " + lastModifiedDate);		
		
		String lastModified = new SimpleDateFormat("a hh:mm yyyy-MM-dd").format(lastModifiedDate);
		System.out.println("수정한 날짜 : " + lastModified);
		
		long size = file.length();     // 바이트 단위
		System.out.println("파일크기 : " + size + "byte");
	}
	
	public static void m4() {
		
		File dir = new File ("C:\\GDJ");
		File[] list = dir.listFiles();      // 디렉터리 내부의 모든 파일/디렉터리를  File 객체로 가져옴
		
		 for(int i = 0; i < list.length; i++) {
			 System.out.println(list[i].getName());
		 }
		
	}
	
	public static void m5() {
		
		// 플랫폼마다 다른 경로 구분자 지원
		File file =  new File("C:" + File.separator + "storage" + File.separator + "my.txt");
		System.out.println(file.getName());
		
	}
	
	
	public static void q1() {
		
		File dir = new File("C:\\GDJ");
		File[] list = dir.listFiles();
		
		int dirCnt = 0;
		int fileCnt = 0;
		long totalSize = 0;

		for (File file : list) {
			if(file.isHidden()) {
				continue;
			}
			String lastModified = new SimpleDateFormat("yyyy-MM-dd a hh:mm").format(file.lastModified());
			String directory = "";
			String size = "";
			if(file.isDirectory()) {
				directory = "<DIR>";
				size = "     ";
				dirCnt++;
			} else {
				directory = "     ";
				size = new DecimalFormat("#,##0").format(file.length()) + "";
				fileCnt++;
				totalSize += Long.parseLong(size.replace(",", ""));
			}
			String name = file.getName();
			System.out.println(lastModified + " " + directory + " " + size + " " + name);
		}
		System.out.println(dirCnt + " 개 디렉터리");
		System.out.println(fileCnt + " 개 파일 " + new DecimalFormat("#,##0").format(totalSize) + "바이트");
		
	}
	
	public static void q2() {
		
		// C:\storage 디렉터리 삭제하기
		// 디렉터리가 비어 있어야 삭제할 수 있으므로 내부 파일을 먼저 삭제
		String sep = File.separator;
		
		File file = new File("C:" + sep + "storage", "my.txt");
		if(file.exists()) {
			file.delete();
		}
		
		File dir = new File("C:" + sep + "storage");
		
		if(dir.exists()) {
			dir.delete();
		}
	}
	
	public static void main(String[] args) {
		q1();
	}

}
