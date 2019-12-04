package advent.of.code;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import advent.of.code.utility.Point;

public class Wire {
	
	private Set<Point> pointsTouched;
	private Point latestPoint;
	private List<String> rawData;
	
	private static final String UP = "U";
	private static final String DOWN = "D";
	private static final String LEFT = "L";
	private static final String RIGHT = "R";
	
	
	public Wire(List<String> rawData) {
		this.rawData = rawData;
		this.pointsTouched = new HashSet<>();
		this.latestPoint = new Point();
	}
	
	public void processWireData() throws Exception {
		for(String instruction : rawData) {
			String direction = instruction.substring(0, 1);
			String amount = instruction.substring(1);
			moveWire(direction,amount);
		}
	}
	
	
	public void moveWire(String direction, String amount) throws Exception {
		
		Point endPoint = null;
		
		switch(direction) {
			case UP:
				endPoint = new Point(latestPoint.getX(), latestPoint.getY() + Integer.parseInt(amount));
				break;
			case DOWN:
				endPoint = new Point(latestPoint.getX(), latestPoint.getY() - Integer.parseInt(amount));
				break;
			case LEFT:
				endPoint = new Point(latestPoint.getX() - Integer.parseInt(amount) , latestPoint.getY());
				break;
			case RIGHT:
				endPoint = new Point(latestPoint.getX() + Integer.parseInt(amount) , latestPoint.getY());
				break;
			default:
				throw new Exception();
		}
		
		while(!this.latestPoint.equals(endPoint)) {
			
			switch(direction) {
				case UP:
					this.latestPoint.setY(this.latestPoint.getY() + 1);
					pointsTouched.add(new Point(this.latestPoint));
					break;
				case DOWN:
					this.latestPoint.setY(this.latestPoint.getY() - 1);
					pointsTouched.add(new Point(this.latestPoint));
					break;
				case LEFT:
					this.latestPoint.setX(this.latestPoint.getX() - 1);
					pointsTouched.add(new Point(this.latestPoint));
					break;
				case RIGHT:
					this.latestPoint.setX(this.latestPoint.getX() + 1);
					pointsTouched.add(new Point(this.latestPoint));
					break;
				default:
					throw new Exception();
			}
			
		}
		
		pointsTouched.add(new Point(endPoint));
		this.latestPoint = endPoint;
		
	}
	
	public Set<Point> getPointsTouched() {
		return this.pointsTouched;
	}

}
