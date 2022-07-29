package prac0729;

public class Watch {
	
	
	private int hour;
	private int minute;
	private int second;
	
	public Watch ( int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public void addHour (int hour) {
		if(hour < 0)
			return;
		this.hour += hour;
		this.hour %= 24;
	}

	public void addMinute (int minute) {
		if(minute < 0)
			return;
		this.minute += minute;
		addHour(this.second / 60);
		this.minute %= 60;
	}
	public void addSecond(int second) {
		if(second < 0)
			return;
		this.second += second;
		addMinute(this.minute / 60);
		this.second %= 60;
	}
	
	public void see() {
		System.out.println(hour + "시" + minute + "분" + second + "초");
	}
	
	

}
