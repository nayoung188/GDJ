package com.gdu.app01.java02;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
	private List<Integer> scores;
	private Set<String> award;
	private Map<String, String> contact;
	
	
	public List<Integer> getScores() {
		return scores;
	}
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	public Set<String> getAward() {
		return award;
	}
	public void setAward(Set<String> award) {
		this.award = award;
	}
	public Map<String, String> getContact() {
		return contact;
	}
	public void setContact(Map<String, String> contact) {
		this.contact = contact;
	}
	
	
}
