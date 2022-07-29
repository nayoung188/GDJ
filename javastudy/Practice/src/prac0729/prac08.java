package prac0729;

public class prac08 {

	public static void main(String[] args) {
		
		
		Watch watch = new Watch(16,15,30);
		
		
		watch.addHour(1);
		watch.addMinute(5);
		watch.addSecond(1);
		
		watch.see();
		

	}

}
