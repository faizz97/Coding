package adhoc;

/*
 * PROBLEM:
 * Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.
 *		1. The amount of petrol that every petrol pump has.
 *		2. Distance from that petrol pump to the next petrol pump.
 *	Calculate the first point from where a truck will be able to complete the circle (The truck will stop at each petrol pump and it has infinite capacity).
 * */

/* https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/ */

public class PetrolPump {
	public static void main(String args[]) {
		new PetrolPump();
	}
	public PetrolPump() {
		begin();
	}
	void begin() {
		Pump input[] = { new Pump(6, 4), new Pump(3, 6), new Pump(7, 3) };
		System.out.println("Start: " + getTour(input));
	}
	int getTour(Pump input[]) {
		int n = input.length, start = 0, end = 1, petrol = input[start].petrol - input[start].distance;
		
		while (start != end || petrol < 0) {
			while (start != end && petrol < 0) {
				petrol -= input[start].petrol - input[start].distance;
				start = (start + 1) % n;
				if (start == 0)
					return -1;
			}
			petrol += input[end].petrol - input[end].distance;
			end = (end + 1) % n;
		}
		
		return start;
	}
	class Pump {
		int petrol, distance;
		public Pump(int petrol, int distance) {
			this.distance = distance;
			this.petrol = petrol;
		}
	}
}
