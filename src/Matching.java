

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

// in Eclipse you must paste in the entire file extention you would like to use
///Users/Jared/Documents/workspace/jbs-pa6/src/makemodel.txt
///Users/Jared/Documents/workspace/jbs-pa6/src/cars.txt

/** Jared Dunn
 * JBS2011
 * PA6 Java
 * Here is my matching game
 * 1) starts by reading in a file of a list of makes and models puts into 2 arrayLists. then shuffles them
 * 2) reads in a file of "cars" makes and models into one object
 * 3)matches the two strings of the makes and models against the appropriate Cars.
 * 4)once it they are correctly matched it deletes the string and replaces it with null once the entire array is null the game ends
 * 5)
 *
 */

public class Matching {

public static ArrayList<String>makes;
public static ArrayList<String>models;
public static ArrayList<Car> cars;

	public static void main (String[] arrrrgs){
		
		
		Scanner input = new Scanner(System.in);
		Scanner scanFile = getFile(input);
	    fileCheck(scanFile);
	    makes = makeStringArray(scanFile);
	    Collections.shuffle( makes);
		models = makeStringArray(scanFile);
	    Collections.shuffle(models);
		;
		Scanner scanFile2 = getFile(input);
		fileCheck(scanFile2);
		cars = makeCarArray(scanFile2);
		System.out.println(makes);
		System.out.println(models);
		System.out.println(cars);
		boolean done = false;
		while (!done){
			System.out.print("Enter a card from the first deck to check from 1-9");
			int m = input.nextInt();
			System.out.print("Enter a card from the second deck to check from 1-9");
			int md = input.nextInt();
			nullTest(m, makes);
			nullTest(md, models);
			compare(m,md);
			done = nullArrayTest();
		}
		System.out.println("congratulations you won!! WINNER WINNER CHICKEN DINNER");
		}
	
	// here is my compare method that checks whether the makes and models match any cars in the arraylist
	public static void compare(int m, int md){
		m = m-1;
		md = md-1;
		String make = makes.get(m);
		System.out.println(make);
		String model = models.get(md);
		System.out.println(model);
		Car mixed = new Car(make, model);
		System.out.println(mixed);
		boolean match = false;
		for(int i = 0; i< cars.size(); i++){
			if (mixed.toString().equals(cars.get(i).toString())){
				System.out.println("match!");
			    makes.set(m,null);
				models.set(md,null);
				match = true;
				break;
			}	
		}
		if (!match){
			System.out.println("no Match try again");
		}
		}
		
		
	

	public static void nullTest(int m, ArrayList<String> mm){
		if(mm.get(m)== null){
			System.out.println("No Card");
		}
	}
	public static boolean nullArrayTest(){
		int count = 0;
		for( int i =0; i<makes.size(); i++){
			if(makes.get(i) != null){
				count++;
			}
		}
		if (count>0){
			return false;
		}
		else{
			return true;
		}
	}
	
	// this section is all inputing data from files into arrays
	public static ArrayList<Car> makeCarArray(Scanner scanFile){
		ArrayList<Car> array = inputCar(scanFile);
		return array;
		
	}
	public static ArrayList<String> makeStringArray(Scanner scanFile){
		ArrayList<String> array = inputCars(scanFile);
		return array;
	}
	
	// this method just checks to make sure the scanner found the correct file
	public static void fileCheck(Scanner scanFile){
		if(scanFile == null)
		{
			System.out.println("an error has occured");
		}
		else
		{
			System.out.println("Found File");
		}
	}
	
	//this scanner gets the file
	public static Scanner getFile(Scanner input) 
	{	
		String say = "please enter the file name you would like you use";
		Scanner scanFile = null;
		while(scanFile == null) 
		{
			System.out.println(say);
			String fileN = input.nextLine();
			if (fileN.equals("quit")) 
			{ 
				break; 
			}
			try
			{
				System.out.println(fileN);
				scanFile = new Scanner(new File(fileN));
			} 
			catch(FileNotFoundException e) 
			{
				System.out.println("File not found");
			}
		}
		return scanFile;
	}
	
	// this method reads all the names off the file and creates the array list of the data
	public static ArrayList<String> inputCars(Scanner scanFile)
	{
		int count = 0;
		ArrayList<String> carNames = new ArrayList<String>();
		String name;
		while(count!=1)
		{	
			name = scanFile.next();
			if (name.equals("END"))
			{
				break;
			}
			else
			{
			  carNames.add(name);
			}
		   		    
		}
		return carNames;
	}
	
	// thos metod is very similar it creates an array list of cars.
	public static ArrayList<Car> inputCar(Scanner scanFile)
	{
		int count = 0;
		ArrayList<Car> carNames = new ArrayList<Car>();
		String name;
		while(count!=1)
		{	
			name = scanFile.next();
			if (name.equals("END"))
			{
				break;
			}
			else
			{
			  Car Ferrari = new Car(name,scanFile.next());
			  carNames.add(Ferrari);
			}
		   		    
		}
		return carNames;
	}

}
