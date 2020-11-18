import java.util.Random;

public class VehicleGenerator {
	private Random randomGenerator;
	
	public VehicleGenerator() {
		randomGenerator = new Random();
	}
	
	public Vehicle createVehicle() {
		double randNum = randomGenerator.nextDouble();
		if (randNum <= 0.3) {
			return new Bus();
		}
		if (randNum <= 0.7) {
			return new Car();
		} else {
			return new Bicycle();
		}
	}
}
