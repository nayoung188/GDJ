package com.gdu.app12.util;

import java.security.MessageDigest;
import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {
	
	// 크로스 사이트 스크립팅 방지
	public String preventXSS(String str) {
		str = str.replace("<", "&lt;");
		str = str.replace(">", "&gt;");
		str = str.replace("\"", "&quot;");
		str = str.replace("\'", "&#x27;");
		return str;
	}
	
	// SHA-256 암호화
	// 1. 입력 값을 256비트(32바이트) 암호화 처리하는 알고리즘
	// 2. 암호화는 가능하지만 복호화는 불가능
	// 3. 1바이트를 2글자로 표현하면 총 64글자(DB에 저장될 때 크기) 공간이 필요
	// 4. 모든 입력이 64글자 암호화 처리
	// 5. java.security 패키지 기능
	public String sha256(String str) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes());
		} catch(Exception e) {
			e.printStackTrace();
		}
		byte[] b = md.digest();			// 배열b : 문자열 str이 암호화된 32바이트 크기의 배열
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < b.length; i++) {
			sb.append(String.format("%2X", b[i]));	// 16진수 두글자로 바꾼다 라는 뜻 /  %2X : 자리 16진수 (0~F) . %2x : 2자리 16진수 (0~f)
		}
		return sb.toString();
	}
	
	// 인증코드 만들기
	// 1. 보안을 위해서 Math.random() 내지는 Random 클래스 사용을 지양한다.
	// 2. SecureRandom 클래스를 대신 사용한다.
	
	private SecureRandom secureRandom = new SecureRandom();
	
	public String getAuthCode(int length) {
		
		/*
			문자 			아스키코드			생성
			'0'				48					48부터 10개 중 하나의 난수 ('0' ~ '9')
			'A'				65					65부터 26개	중 하나의 난수 ('A' ~ 'Z')
			'a'				97					97부터 26개 중 하나의 난수 ('a' ~ 'z')
		*/
		// 대문자와 숫자의 조합
		StringBuilder sb = new StringBuilder();
		for(int cnt = 0; cnt < length; cnt++) {		// length만큼 반복
			if(secureRandom.nextDouble() < 0.5) {	// 50%확률
				sb.append((char)(secureRandom.nextInt(10) + '0') );     // secureRandom.nextInt(10) : 0부터 9사이 숫자 중 하나
			} else {
				sb.append((char)(secureRandom.nextInt(26) + 'A') );
			}
		}
		
		return sb.toString();
	}
	
	

}
