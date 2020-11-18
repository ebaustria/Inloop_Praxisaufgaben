import java.util.LinkedList;
import java.util.List;

public class VehicleQueue implements ClockObserver {
	private double entryDelay;
	private double exitDelay;
	private int trafficLightRate;
	private boolean greenLight = false;
	private VehicleGenerator generator;
	private List<Vehicle> queue;
	private double entryTime;
	private double exitTime;
	
	public VehicleQueue(double entryDelay, double exitDelay, int trafficLightRate,
			VehicleGenerator generator) {
		queue = new LinkedList<Vehicle>();
		this.entryDelay = entryDelay;
		this.exitDelay = exitDelay;
		this.trafficLightRate = trafficLightRate;
		this.generator = generator;
		entryTime = 0;
		exitTime = 0;
	}
	
	public void enter() {
		Vehicle newVehicle = generator.createVehicle();
		queue.add(newVehicle);
	}
	
	public void leave() {
		//if (greenLight) {
		//}
		if (queue.size() > 0) {
			queue.remove(queue.size() - 1);
		}
	}
	
	public double getLength() {
		double length = 0;
		for (Vehicle vehicle : queue) {
			length += vehicle.getLength();
		}
		return length;
	}
	
	public int getSize() {
		return queue.size();
	}
	
	@Override
	public void tick(int currentTime) {
		//double entryTime;

		if (currentTime % trafficLightRate == 0) {
			if (greenLight == false) {
				greenLight = true;
			} else {
				greenLight = false;
			}
		}
		
		while ()
		
		if (greenLight) {
		}
		/*
		if (greenLight) {
			for (double i = exitTime; i < currentTime; i += exitDelay) {
				if (i + exitDelay < currentTime) {
					leave();
					exitTime = i + exitDelay;
				}
			}
		} else {
			exitTime = currentTime;
		}
		
		System.out.println("current time: " + currentTime);
		
		for (double i = entryTime; i <= currentTime; i = i + entryDelay) {
			if (i + entryDelay <= currentTime) {
				enter();
				entryTime = currentTime;
			}
		}
		
		System.out.println("exit delay: " + exitDelay);
		System.out.println("entry time: " + entryTime);
		System.out.println("exit time: " + exitTime);
		System.out.println("queue size: " + queue.size());
		*/
	}

}
