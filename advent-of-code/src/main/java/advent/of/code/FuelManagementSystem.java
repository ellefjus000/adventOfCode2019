package advent.of.code;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import com.google.common.collect.Sets;

import advent.of.code.utility.Point;

public class FuelManagementSystem {
	
	private List<List<String>> rawWireData;
	private Wire wireOne;
	private Wire wireTwo;
	private Set<Point> intersections;
	
	public FuelManagementSystem(List<List<String>> rawWireData) {
		this.rawWireData = rawWireData;
		this.wireOne = new Wire(rawWireData.get(0));
		this.wireTwo = new Wire(rawWireData.get(1));
	}
	
	public int calculateDistanceToNearestIntersection() throws Exception {
		
		processRawData();
		determineIntersections();
		
		return getNearestPoint().getDistanceFromOrigin();
	
	}
	
	private void processRawData() throws Exception {
		wireOne.processWireData();
		wireTwo.processWireData();
	}
	
	private void determineIntersections() {
		intersections = Sets.intersection(wireOne.getPointsTouched(), wireTwo.getPointsTouched());
	}
	
	
	private Point getNearestPoint() {
		return intersections
				.stream()
				.min(Comparator.comparing(Point::getDistanceFromOrigin))
				.orElseThrow(NoSuchElementException::new);
	}

}
