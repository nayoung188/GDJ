package com.gdu.app01.xml08;

public class BMICalculator {
	
	//field
	private Calculator calc;
	private double height;
	private double weight;
	private double bmi;
	private String health;
	
	//constructor
	public BMICalculator(Calculator clac, double height, double weight) {
		super();
		this.calc = clac;
		this.height = height;
		this.weight = weight;
		this.bmi = calc.div(weight, calc.div(calc.mul(height, height), 10000));
		health = (bmi < 20) ? "저체중" : (bmi < 25) ? "정상" : (bmi < 30) ? "과체중" : "비만";
	}
	
	
	// info()메솓
	public void info() {
		System.out.println("BMI : " + bmi);
		System.out.println("Health : " + health);
	}
	
	
}
