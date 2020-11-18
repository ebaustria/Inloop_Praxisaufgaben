
public class Time {
	private int hour;
	private int minute;
	
	public Time(int hour, int minute) {
		if (hour < 0 || hour > 23) {
			throw new IllegalArgumentException("The hour argument must be between 0 and 23");
		}
		if (minute < 0 || minute > 59) {
			throw new IllegalArgumentException("The minute argument must be between 0 and 59");
		}
		this.hour = hour;
		this.minute = minute;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
}
