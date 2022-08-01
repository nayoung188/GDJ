package ques01_coffee; 
 
 
 public class Americano extends Espresso { 
 
 
 	private String type; 
 
 
 	public Americano(String origin, int water, String type) { 
 		super(origin, water); 
		this.type = type; 
 	} 
 	 
	@Override 
 	public void info() { 
 		super.info(); 
 		System.out.println(type + " 아메리카노"); 
 	} 
 	 
 } 
