package advent.of.code;

import com.opencsv.bean.CsvBindByName;

public class Module {
	
	@CsvBindByName(column = "Mass", required = true)
	private int mass;
	
	public Module(int mass) {
		this.mass = mass;
	}
	
	public Module() {
		this.mass = 0;
	}
	
	public int calculateRequiredFuel() {
		return (mass/3) - 2;
	}
	
	public int calculateTotalRequiredFuel() {
		int initalFuelNeeded = calculateRequiredFuel();
		int additionalFuelNeeded = recursiveFuelNeeds(initalFuelNeeded);
		return initalFuelNeeded + additionalFuelNeeded;
	}
	
	private int recursiveFuelNeeds(int fuel) {
		int additionalFuelRequired = fuel / 3 - 2;
		if(additionalFuelRequired <= 0) {
			return 0;
		} else {
			return additionalFuelRequired + recursiveFuelNeeds(additionalFuelRequired);
		}
	}
}
