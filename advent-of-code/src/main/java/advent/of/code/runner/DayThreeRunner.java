package advent.of.code.runner;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import advent.of.code.FuelManagementSystem;

public class DayThreeRunner {
	
	private static final String FILE_NAME = "src/main/resources/dayThreeInput.csv";

	public static void main(String[] args) throws Exception {		

		FuelManagementSystem fms = new FuelManagementSystem(rawWireDataReader());
		int distanceToNearestIntersection = fms.calculateDistanceToNearestIntersection();
		System.out.println("Distance to nearest intersection: " + distanceToNearestIntersection);
		
	}
	
	public static List<List<String>> rawWireDataReader() throws IOException, CsvException {
		
		List<List<String>> allWireDirections = new ArrayList<>();
		
		try (FileReader fs = new FileReader (new File(FILE_NAME))) {
		      CSVReader reader = new CSVReader(fs);
		      List<String[]> wireDataRows = reader.readAll();
		      reader.close();
		      
		      for(String[] wireDataRow : wireDataRows) {
		    	  List<String> wireDirections = Arrays.asList(wireDataRow);
		    	  allWireDirections.add(wireDirections);
		      }
		      
		      return allWireDirections;
		}	       
	    
	}

}