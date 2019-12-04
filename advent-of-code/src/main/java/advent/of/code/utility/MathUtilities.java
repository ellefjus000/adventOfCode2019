package advent.of.code.utility;

public final class MathUtilities {
	
	public int calculateManhattenDistance(Point p1, Point p2) {
		return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() + p2.getY());
	}
	
	public static int calculateManhattenDistanceFromOrigin(Point p1) {
		return Math.abs(p1.getX()) + Math.abs(p1.getY());
	}
	
}
