package main;

import controller.ContactController;

public class Main {

	public static void main(String[] args) {
		
		
		// Controller -> Service -> DAO 순서로 처리됨
		
		new ContactController().play();
		

	}

}
