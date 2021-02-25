package SecondTry;
import java.util.ArrayList;

public class Car {
	private int streetNumber;
	private ArrayList<String> streets = new ArrayList<>();
	
	
	public Car(int streetNumber, ArrayList<String> streets) {
		
		this.streetNumber = streetNumber;
		this.streets = streets;
	}


	public int getStreetNumber() {
		return streetNumber;
	}


	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}


	public ArrayList<String> getStreets() {
		return streets;
	}


	public void setStreets(ArrayList<String> streets) {
		this.streets = streets;
	}
	
	@Override
	public String toString()
	{
		String output = " has " + streetNumber + ": ";
		
		for(String street : streets)
		{
			output += street + " ";
		}
		
		return output;
	}
	
	
	
}
