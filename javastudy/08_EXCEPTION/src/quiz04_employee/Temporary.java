package quiz04_employee;

public class Temporary extends Employee{
	
	private double hourPay;
	private int workTimes;
	
	public Temporary(int empNo, String name) {
		super(empNo, name);

	}

	public double getHourPay() {
		return hourPay;
	}

	public void setHourPay(double hourpay) {
		this.hourPay = hourpay;
	}

	public int getWorkTimes() {
		return workTimes;
	}

	public void setWorkTimes(int workTimes) {
		this.workTimes = workTimes;
	}

	@Override
	public String toString() {
		return super.toString() + " , hourpay=" + hourPay + ", workTimes=" + workTimes + "]";
	}
	
	@Override
	public int getPay() {
		return (int)(hourPay * workTimes);
	}
	

	
}
