package advent.of.code;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class IntCodeComputerTest {

	@Test
	public void testIntCodeProgramOne() {
		//Given
		List<Integer> expectedFinalState = new ArrayList<>(Arrays.asList(2,0,0,0,99));
		List<Integer> initialIntCodeProgram = new ArrayList<>(Arrays.asList(1,0,0,0,99));
		
		IntCodeComputer computer = new IntCodeComputer(initialIntCodeProgram);
		
		//When
		computer.runIntCodeProgram();
		
		//Then
		assertArrayEquals(expectedFinalState.toArray(), computer.getIntCodeProgram().toArray());
	}
	
	@Test
	public void testIntCodeProgramTwo() {
		//Given
		List<Integer> expectedFinalState = new ArrayList<>(Arrays.asList(2,3,0,6,99));
		List<Integer> initialIntCodeProgram = new ArrayList<>(Arrays.asList(2,3,0,3,99));
		
		IntCodeComputer computer = new IntCodeComputer(initialIntCodeProgram);
		
		//When
		computer.runIntCodeProgram();
		
		//Then
		assertArrayEquals(expectedFinalState.toArray(), computer.getIntCodeProgram().toArray());
	}
	
	@Test
	public void testIntCodeProgramThree() {
		//Given
		List<Integer> expectedFinalState = new ArrayList<>(Arrays.asList(2,4,4,5,99,9801));
		List<Integer> initialIntCodeProgram = new ArrayList<>(Arrays.asList(2,4,4,5,99,0));
		
		IntCodeComputer computer = new IntCodeComputer(initialIntCodeProgram);
		
		//When
		computer.runIntCodeProgram();
		
		//Then
		assertArrayEquals(expectedFinalState.toArray(), computer.getIntCodeProgram().toArray());
	}
	
	@Test
	public void testIntCodeProgramFour() {
		//Given
		List<Integer> expectedFinalState = new ArrayList<>(Arrays.asList(30,1,1,4,2,5,6,0,99));
		List<Integer> initialIntCodeProgram = new ArrayList<>(Arrays.asList(1,1,1,4,99,5,6,0,99));
		
		IntCodeComputer computer = new IntCodeComputer(initialIntCodeProgram);
		
		//When
		computer.runIntCodeProgram();
		
		//Then
		assertArrayEquals(expectedFinalState.toArray(), computer.getIntCodeProgram().toArray());
	}

}
