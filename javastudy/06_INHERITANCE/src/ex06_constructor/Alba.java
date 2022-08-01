package ex06_constructor;

public class Alba extends Student{
	
	
	private String company;
	
	public Alba(String name, String school, String company) {
		super(name, school);
		this.company = company;
	}

	public String getAlba() {
		return company;
	}

	public void setAlba(String alba) {
		this.company = company;
	}
	
	
	

}
