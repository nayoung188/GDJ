package prac0729;

import java.util.Scanner;

public class Player {

	
	private String name;
	private Scanner sc;
	
	public Player(String name) {
		this.name = name;
		if ( sc == null ) {
			sc = new Scanner(System.in);
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double turn() {
		System.out.println(name + "님 시작하려면 <Enter>를 누르세요!");
		sc.nextLine();
		long begin = System.currentTimeMillis();
		sc.nextLine();
		long end = System.currentTimeMillis();
		
		return ( end - begin ) * 0.001;
		
	}

	
	
	
	
}
