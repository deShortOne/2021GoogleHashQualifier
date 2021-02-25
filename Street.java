package SecondTry;

public class Street {
	private int startIntersection;
	private int endIntersection;
	private String streetName;
	private int routeTime;
	
	public int greenLightTime;
	
	public int counter = 0;
	
	public Street(int startIntersection, int endIntersection, String streetName, int routeTime) {
		this.startIntersection = startIntersection;
		this.endIntersection = endIntersection;
		this.streetName = streetName;
		this.routeTime = routeTime;
		
		
	}
	
	public int getStartIntersection() {
		return startIntersection;
	}
	public void setStartIntersection(int startIntersection) {
		this.startIntersection = startIntersection;
	}
	public int getEndIntersection() {
		return endIntersection;
	}
	public void setEndIntersection(int endIntersection) {
		this.endIntersection = endIntersection;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public int getRouteTime() {
		return routeTime;
	}
	public void setRouteTime(int routeTime) {
		this.routeTime = routeTime;
	}
	
	@Override
	public String toString()
	{
		String format = String.format("Starts at %d, ends at %d, its name: %s and time to travel is %d.",
				this.startIntersection, this.endIntersection, this.streetName, this.routeTime);
		return format;
	}
	
}
