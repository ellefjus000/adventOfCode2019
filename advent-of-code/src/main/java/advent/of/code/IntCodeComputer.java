package advent.of.code;

import java.util.ArrayList;
import java.util.List;

public class IntCodeComputer {
	
	private static final int OP_CODE_ADD = 1;
	private static final int OP_CODE_MULTIPLY = 2;
	private static final int OP_CODE_HALT = 99;
	
	private List<Integer> intCodeProgram;
	private List<Integer> originalCodeProgram;
	
	public IntCodeComputer(List<Integer> intCodeProgram) {
		this.intCodeProgram = new ArrayList<>(intCodeProgram);
		this.originalCodeProgram = new ArrayList<>(intCodeProgram);
	}
	
	private void setTo1202ProgramAlarmState(int noun, int verb) {
		this.intCodeProgram.set(1,noun);
		this.intCodeProgram.set(2,verb);
	}
	
	protected void runIntCodeProgram() {
		int currentPosition = 0;
		boolean halt = false;
		
		while(!halt) {
			
			int opCode = this.intCodeProgram.get(currentPosition);
			
			switch (opCode){
				case OP_CODE_ADD:
					performOpCodeAdd(this.intCodeProgram.get(currentPosition + 1), this.intCodeProgram.get(currentPosition + 2), this.intCodeProgram.get(currentPosition + 3));
					break;
				case OP_CODE_MULTIPLY:
					performOpCodeMultiply(this.intCodeProgram.get(currentPosition + 1), this.intCodeProgram.get(currentPosition + 2), this.intCodeProgram.get(currentPosition + 3));
					break;
				case OP_CODE_HALT:
					halt = true;
					break;
				default:
					halt = true;
					System.out.println("Unexpected OpCode:" + this.intCodeProgram.get(currentPosition) + " Current Position: " + currentPosition);		
			}
			
			currentPosition += 4;			
		}
	}
	
	public void executeProgramPart1() {
		setTo1202ProgramAlarmState(12,2);
		runIntCodeProgram();
	}
	
	public void executeProgramPart2(int desiredValue) {
		for(int noun = 0; noun < 100; noun++) {
			for(int verb = 0; verb < 100; verb++) {
				setTo1202ProgramAlarmState(noun, verb);
				runIntCodeProgram();
				if(this.intCodeProgram.get(0) == desiredValue) {
					System.out.println("Answer: " + (100 * noun + verb));
					return;
				}
				resetIntCodeProgram();
			}
		}
	}

	public List<Integer> getIntCodeProgram() {
		return new ArrayList<>(intCodeProgram);
	}
	
	private void performOpCodeAdd(int addendOneIndex, int addendTwoIndex, int resultIndex) {
		int result = this.intCodeProgram.get(addendOneIndex) + this.intCodeProgram.get(addendTwoIndex);
		this.intCodeProgram.set(resultIndex, result);
	}
	
	private void performOpCodeMultiply(int multiplicandIndex, int multiplierIndex, int resultIndex) {
		int result = this.intCodeProgram.get(multiplicandIndex) * this.intCodeProgram.get(multiplierIndex);
		this.intCodeProgram.set(resultIndex, result);
	}
	
	private void resetIntCodeProgram() {
		this.intCodeProgram = new ArrayList<> (this.originalCodeProgram);
	}

}