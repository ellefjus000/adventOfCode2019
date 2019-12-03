package advent.of.code;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class DayTwoRunner {
	
	private static final String FILE_NAME = "src/main/resources/dayTwoInput.csv";

	public static void main(String[] args) throws IOException, CsvException {		
		//read file
		List<Integer> intialIntProgram = csvReader();
		
		IntCodeComputer computer1 = new IntCodeComputer(new ArrayList<>(intialIntProgram));
		computer1.executeProgramPart1();
		System.out.println(computer1.getIntCodeProgram());
		
		IntCodeComputer computer2 = new IntCodeComputer(new ArrayList<>(intialIntProgram));
		computer2.executeProgramPart2(19690720);
		System.out.println(computer2.getIntCodeProgram());
		
	}
	
	public static List<Integer> csvReader() throws IOException, CsvException {
		
		List<Integer> initialIntCodeProgram = new ArrayList<>();
		
		try (FileReader fs = new FileReader (new File(FILE_NAME))) {
		      CSVReader reader = new CSVReader(fs);
		      List<String[]> allRows = reader.readAll();
		      reader.close();
		      
		      for(String[] row : allRows) {
		    	  for(String item : row) {
		    		  initialIntCodeProgram.add(Integer.parseInt(item));
		    	  }
		      }
		      
		      return initialIntCodeProgram;
		}	       
	    
	}

}