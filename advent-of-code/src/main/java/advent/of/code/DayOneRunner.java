package advent.of.code;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class DayOneRunner {
	
	private static final String FILE_NAME = "src/main/resources/dayOneInput.csv";

	public static void main(String[] args) throws IOException {		
		//read file
		List<Module> modules = csvReader();
		
		int totalPart1 = modules.stream().filter(o -> o.calculateRequiredFuel() > 10).mapToInt(Module::calculateRequiredFuel).sum();
		int totalPart2 = modules.stream().filter(o -> o.calculateTotalRequiredFuel() > 10).mapToInt(Module::calculateTotalRequiredFuel).sum();

		
		System.out.println("Total Fuel Resources (Part 1): " + totalPart1);
		System.out.println("Total Fuel Resources (Part 2): " + totalPart2);
	}
	
	public static List<Module> csvReader() throws IOException {
        		
		try (FileReader fs = new FileReader (new File(FILE_NAME))) {
			return new CsvToBeanBuilder<Module>(fs).withType(Module.class).build().parse();
		}

	}

}