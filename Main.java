package SecondTry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
	
	public static int simulationDuration;
	public static int intersectionNumber;
	public static int streetNumber;
	public static int carNumber;
	public static int bonus;
	
	public static HashMap<Integer, InterSection> intersections = new HashMap<>();
	public static HashMap<String, Street> streets = new HashMap<>();
	public static HashMap<Integer, Car> cars = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFile();
		
		//printer();
		
		sumUpIntersections();
		
		/*System.out.println(intersections.get(1).streetsIn.get("rue-d-amsterdam").counter);
		System.out.println(intersections.get(1).streetsIn.get("rue-d-amsterdam"));
		System.out.println(streets.get("rue-d-amsterdam").counter);
		
		System.out.println(intersections.get(1).totalCounter);
		
		System.out.println();*/
		
		//intersections.get(1).separateGreenLight(10);
		//System.out.println(intersections.get(1).generateOutput());
		
		//write to a file
		
		String output = writeDownOutput();
		
		System.out.println(output);
		
		writeToFile(output);
	}

	public static void readFile()
	{
		try
		{
			File inputFile = new File("c.txt");
			Scanner fileReader = new Scanner(inputFile);
			
			// assign parameters to variables from the first line
			String parametersLine = fileReader.nextLine();
			
			String[] parameters = parametersLine.split(" ");
			
			simulationDuration = Integer.parseInt(parameters[0]);
			intersectionNumber = Integer.parseInt(parameters[1]);
			streetNumber = Integer.parseInt(parameters[2]);
			carNumber = Integer.parseInt(parameters[3]);
			bonus = Integer.parseInt(parameters[4]);
			
			//create intersections
			for(int i = 0; i<intersectionNumber; i++)
			{
				intersections.put(i, new InterSection());
			}
			
			
			//reading streets
			for(int i = 0; i < streetNumber; i++)
			{
				String line = fileReader.nextLine();
				String[] attributes = line.split(" ");
				
				Street newStreet = new Street(
						Integer.parseInt(attributes[0]),
						Integer.parseInt(attributes[1]),
						attributes[2],
						Integer.parseInt(attributes[3])
						);
				
				streets.put(attributes[2], newStreet);
				
				//if street is not connected with intersection add it
				if(!intersections.get(Integer.parseInt(attributes[1])).streetsIn.containsKey(attributes[3]))
				{
					intersections.get(Integer.parseInt(attributes[1])).streetsIn.put(attributes[2], newStreet);
				}
			}
			
			
			int i = 0;
			// reading cars
			while(fileReader.hasNextLine())
			{
				String line = fileReader.nextLine();
				String[] attributes = line.split(" ");
				
				ArrayList<String> streetsOfCar = new ArrayList<>();
				
				for(int k = 1; k < attributes.length; k++)
				{
					streetsOfCar.add(attributes[k]);
					
					//increase counter of used streets
					streets.get(attributes[k]).counter++;
				}
				
				/////////////////// put length instead of 1
				cars.put(i, new Car(Integer.parseInt(attributes[0]), streetsOfCar));
				i++;
				
				
				// for every included string add 
			}
			
			
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error! Probably the file was not found");
			e.printStackTrace();
		}
	}
	
	public static void printer()
	{
		//print params, routes and cars

		System.out.println("duration of simulation: " + simulationDuration);
		System.out.println("intersection Number: " + intersectionNumber);
		System.out.println("number of streets: " + streetNumber);
		System.out.println("number of cars: " + carNumber);
		System.out.println("bonus for finished: " + bonus);
		
		
		//couple of routes
		System.out.println("Route of key " + "rue-de-londres" + ": " + streets.get("rue-de-londres"));
		System.out.println("Route of key " + "rue-d-amsterdam" + ": " + streets.get("rue-d-amsterdam"));
		System.out.println("Route of key " + "rue-d-athenes" + ": " + streets.get("rue-d-athenes"));
		System.out.println("Route of key " + "rue-de-rome" + ": " + streets.get("rue-de-rome"));
		System.out.println("Route of key " + "rue-de-moscou" + ": " + streets.get("rue-de-moscou"));
		
		//couple of cars
		System.out.println("Car of length " + 0 + " " + cars.get(0));
		System.out.println("Car of length " + 1 + " " + cars.get(1));
		
		
	}
	
	public static void sumUpIntersections()
	{
		for(HashMap.Entry<Integer, InterSection> entry : intersections.entrySet())
		{
			entry.getValue().calculateTotalCounter();
			entry.getValue().separateGreenLight(simulationDuration/2);
		}
	}
	
	public static String writeDownOutput()
	{
		String output = "" + intersectionNumber + "\n";
		for(HashMap.Entry<Integer, InterSection> entry : intersections.entrySet())
		{
			String intersectionOutput = entry.getKey() + "\n";
			intersectionOutput += entry.getValue().generateOutput();
			
			output += intersectionOutput;
		}
		
		return output;
	}
	
	public static void writeToFile(String output)
	{
		try
		{
			File outputFile = new File("OUTPUTc.txt");
			if(outputFile.createNewFile())
			{
				System.out.println("New file was created");
			} else
			{
				System.out.println("File already existed, the submission have been overwritten.");
			}
			
			PrintWriter outputWriter = new PrintWriter(outputFile);
			
			outputWriter.print(output);
			
			
			/*for(Vehicle vehicle : vehicles)
			{
				outputWriter.print(vehicle.getRouteQuantity()); //pass there a number of rides taken by the car
				for(Route route : vehicle.getRouteList())
				{
					outputWriter.print(" " + route.getPos());
				}
				outputWriter.print("\n");
			}*/
			
			
			outputWriter.close();
		} catch(IOException e)
		{
			System.out.println("Error occured during printing the solution");
			e.printStackTrace();
		}
	}
}
