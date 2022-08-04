package ex02_try_catch;

import java.io.File;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	
	public static void m1() {
		try {
			String[] hobbies = new String[3];
			hobbies[1] = "swimming";
			hobbies[2] = "running";
			for(String hobby : hobbies) {
				System.out.println(hobby.substring(0, 2));
			}
		} catch(Exception e) {      // RuntimeException, NullPointerException 가능
			System.out.println("NullPointerException 발생");
		}
	}
	
	public static void m2() {
		try {
			String input = "20,21,,22,23,24,25";
			/*
			String[] ages = input.split(",");
			
			for (int i = 0; i < ages.length; i++) {
				System.out.println(Integer.parseInt(ages[i]));
			*/
			String[] inputs = input.split(",");
			int[] ages = new int[inputs.length];
			for (int i = 0; i < ages.length; i++) {
				ages[i] = Integer.parseInt(inputs[i]);
				System.out.println("변환값 : " + ages[i]);
			}
		} catch(NumberFormatException e) {          // RuntimeException, Exception 가능 /  여러개의 catch 블락 생성 가능, catch블락의 순서대로 진행
			System.out.println("NumberFormatException 발생");
		} catch(Exception e) {
			System.out.println("Exception 발생");     // 다중 catch 블록 생성 시 자식 먼저 진행 하고 부모는 나중에해야 오류 안뜸
		}
	}

	public static void m3() {
		// 어떤 예외가 발생하는지 확인해서
		// try - catch문 넣기 ( Exception, RuntimeException은 사용하지 않기)
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("정수1 >>> ");
			int a = sc.nextInt();
			System.out.println("정수2 >>> ");
			int b = sc.nextInt();
			System.out.println(a + "+" + b + "=" + (a + b));
			System.out.println(a + "-" + b + "=" + (a - b));
			System.out.println(a + "*" + b + "=" + (a * b));
			System.out.println(a + "/" + b + "=" + (a / b));
			System.out.println(a + "%" + b + "=" + (a % b));
			sc.close();
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException 발생");
		} catch (InputMismatchException e ) {
			System.out.println("InputMismatchException 발생");
		}
	}
	
	public static void m4() {
		try {
			File file = new File("C:\\sample.txt");
			FileReader fr = new FileReader(file);    // try-catch문이 없으면 실행이 불가능한 Checked Exception
		} catch( Exception e) {
			
		}
	}

	public static void main(String[] args) {
		m4();

	}

}
