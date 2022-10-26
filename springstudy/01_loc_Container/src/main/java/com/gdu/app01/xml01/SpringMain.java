package com.gdu.app01.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		// 기존 개발자 (기존방식)
		// 개발자가 Bean을 만들었다.
		// Calculator calculator = new Calculator();
		
		// 새로운 프레임워크
		// 프레임워크가 만든 Bean을 가져다 쓴다.
		
		// XML에 저장된 Bean 가져오는 클래스
		// GenericXmlApplicationContext
		// ClassPathXmlApplicationContext
		// GenericXmlApplicationContext는 AbstractApplicationContext의 자식이기 때문에
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml01/appCtx.xml");  // 만든 xml의 경로를 전달  제네릭엑스엠엘대신 ClassPathXmlApplicationContext 써도 돌아감
		Calculator calculator = ctx.getBean("calc", Calculator.class);
		calculator.add(5, 2);
		calculator.sub(5, 2);
		calculator.mul(5, 2);
		calculator.div(5, 2);
		
		Student student = ctx.getBean("haksang", Student.class);		// 캐스팅 하기 싫어서 이 방식 사용, Student student = (Student)ctx.getBea("haksang") 와 같다
		System.out.println(student.getName());
		System.out.println(student.getSchool());
		student.getCalculator().add(7, 3);
		student.getCalculator().sub(7, 3);
		student.getCalculator().mul(7, 3);
		student.getCalculator().div(7, 3);
		
		
		
		ctx.close();		// 생략가능
	}

}
