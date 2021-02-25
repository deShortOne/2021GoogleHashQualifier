package SecondTry;

import java.util.HashMap;

public class InterSection {
	public int totalCounter;
	public HashMap<String, Street> streetsIn = new HashMap<>();
	
	@Override
	public String toString()
	{
		String output = "";
		
		for(HashMap.Entry<String,Street> entry : streetsIn.entrySet())
		{
			output += entry.getValue().getStreetName() + " ";
		}
		
		return output;
	}
	
	public void calculateTotalCounter()
	{
		for(HashMap.Entry<String,Street> entry : streetsIn.entrySet())
		{
			totalCounter += entry.getValue().counter;
		}
	}
	
	public void separateGreenLight(int ScheduleTime)
	{
		for(HashMap.Entry<String,Street> entry : streetsIn.entrySet())
		{
			
			int greenLight = (int)Math.floor(((double)entry.getValue().counter / (double)totalCounter) * ScheduleTime) * 2;
			if(greenLight == 0)
			{
				greenLight = 1;
			}
			
			entry.getValue().greenLightTime = greenLight;
		}
	}
	
	public String generateOutput()
	{
		String output = "";
		output +=streetsIn.size() + "\n";
		for(HashMap.Entry<String,Street> entry : streetsIn.entrySet())
		{
			output += entry.getKey() + " " + entry.getValue().greenLightTime + "\n"; 
		}
		
		return output;
	}
}
