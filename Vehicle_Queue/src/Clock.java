import java.util.LinkedList;
import java.util.List;

public class Clock {
	private int currentTime = 0;
	private int endOfTime;
	private Simulation time;
	private List<ClockObserver> observers;
	
	public Clock(int endOfTime) {
		this.endOfTime = endOfTime;
		this.observers = new LinkedList<ClockObserver>();
	}
	
	public void addObserver(ClockObserver observer) {
		this.observers.add(observer);
	}
	
	public void removeObserver(ClockObserver observer) {
		this.observers.remove(observer);
	}
	
	public int getCurrentTime() {
		return this.currentTime;
	}
	
	public void run() {
		currentTime = 0;
		while (currentTime < endOfTime) {
			currentTime ++;
			this.tick(currentTime);
		}
	}
	
	private void tick(int currentTime) {
		for (ClockObserver observer : observers) {
			observer.tick(currentTime);
		}
	}
}
