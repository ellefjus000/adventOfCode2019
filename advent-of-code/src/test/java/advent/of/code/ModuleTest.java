package advent.of.code;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModuleTest {

	@Test
	public void testFuelRequirementOne() {
		//GIVEN
		Module module = new Module(12);
		//THEN
		assertEquals(2, module.calculateRequiredFuel());
	}
	
	@Test
	public void testFuelRequirementTwo() {
		//GIVEN
		Module module = new Module(14);
		//THEN
		assertEquals(2, module.calculateRequiredFuel());
	}
	
	@Test
	public void testFuelRequirementThree() {
		//GIVEN
		Module module = new Module(1969);
		//THEN
		assertEquals(654, module.calculateRequiredFuel());
	}
	
	@Test
	public void testFuelRequirementFour() {
		//GIVEN
		Module module = new Module(100756);
		//THEN
		assertEquals(33583, module.calculateRequiredFuel());
	}
	
	/*PART II*/
	
	@Test
	public void testTotalFuelRequirementOne() {
		//GIVEN
		Module module = new Module(14);
		//THEN
		assertEquals(2, module.calculateTotalRequiredFuel());
	}
	
	@Test
	public void testTotalFuelRequirementTwo() {
		//GIVEN
		Module module = new Module(1969);
		//THEN
		assertEquals(966, module.calculateTotalRequiredFuel());
	}
	
	@Test
	public void testTotalFuelRequirementThree() {
		//GIVEN
		Module module = new Module(100756);
		//THEN
		assertEquals(50346, module.calculateTotalRequiredFuel());
	}

}
