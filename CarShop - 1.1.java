import java.util.*;
import java.io.*;

public class CarShop {
	private String make;
	private String model;
	private int year;
	private int mileage;
	private double price;
	private float engine;
	private char grade;
	private int id=0;
	private int alphabeticalPos;
	private int pricePos;
	private static ArrayList<CarShop> carList = new ArrayList<>();
	
	//constructor
	public CarShop(String makeIn, String modelIn, int yearIn, int mileageIn, double priceIn, float engineIn, char gradeIn, int idIn)
	{
		//local attributes
		String[] makes = new String[carList.size()+1];
		double[] prices = new double[carList.size()+1];
		int counter;
		
		//set the main values for this object
		setMake(makeIn);
		setModel(modelIn);
		setYear(yearIn);
		setMileage(mileageIn);
		setPrice(priceIn);
		setEngine(engineIn);
		setGrade(gradeIn);
		setId(idIn);
		
		//create an array of the makes
		makes[0] = makeIn; // set this newly constructed object's make to position '0' in array
		counter =0;
		//now fill the rest of the array with the other makes
		for (CarShop item : carList)
		{				
			counter++;
			makes[counter]=item.getMake();
		}
		//Sort the makes array into alphabetical order
		mergeSortAlphabetical(makes);
		//cycle through makes array setting alphabetical position for carList objects
		for (CarShop item : carList)
		{
			for(int i=0;i<carList.size()+1;i++)
			{
				//set the newly constructed item's alphabeticalPos
				if (makeIn.compareToIgnoreCase(makes[i])==0)
				{
					alphabeticalPos=i;					
				}
				//set all the other's alphabetical positions
				else if(item.getMake().compareToIgnoreCase(makes[i])==0)
				{
					item.alphabeticalPos=i;					
				}
			}			
		 }
		//create an array of the prices
		prices[0] = priceIn; // set this newly constructed object's price to position '0' in array
		counter=0;
		//now fill the rest of the array with the other makes
		for (CarShop item : carList)
		{				
			counter++;
			prices[counter]=item.getPrice();
		}
		//Sort the prices array into numerical order
		mergeSortNumerical(prices);
		//cycle through prices array setting ascending order for carList objects
			for (CarShop item : carList)
			{
				for(int i=0;i<carList.size()+1;i++)
				{
					//set the newly constructed item's pricePos
					if (priceIn==prices[i])
					{
						pricePos=i;					
					}
					//set all the other's alphabetical positions
					else if(item.getPrice()==prices[i])
					{
						item.pricePos=i;					
					}
				}
		}
		
	}	
	
	//default constructor
	public CarShop()
	{
		
	}
	
	//merge sorting methods for alphabetical sorting
	public void mergeSortAlphabetical(String[] makesIn)
	{
	
		if (makesIn.length >= 2) {
            String[] left = new String[makesIn.length / 2];
            String[] right = new String[makesIn.length-makesIn.length / 2];

            for (int i = 0; i < left.length; i++)
            {
                left[i] = makesIn[i];
            }
            for (int i = 0; i < right.length; i++)
            {
                right[i] = makesIn[i + makesIn.length / 2];
            }
            
            mergeSortAlphabetical(left);
            mergeSortAlphabetical(right);
            mergeAlphabetical(makesIn, left, right);
		}   
	}
	
	public void mergeAlphabetical(String[] result, String[] left, String[] right) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length &&
                                 left[i1].compareToIgnoreCase(right[i2])<0)) {
                      result[i] = left[i1];
                      i1++;
                 } else {
                      result[i] = right[i2];
                      i2++;
                 }
            }
    }
	
	//merge sorting methods for numerical sorting
	public void mergeSortNumerical(double[] pricesIn)
	{
	
		if (pricesIn.length >= 2) {
            double[] left = new double[pricesIn.length / 2];
            double[] right = new double[pricesIn.length-pricesIn.length / 2];

            for (int i = 0; i < left.length; i++)
            {
                left[i] = pricesIn[i];
            }
            for (int i = 0; i < right.length; i++)
            {
                right[i] = pricesIn[i + pricesIn.length / 2];
            }
            
            mergeSortNumerical(left);
            mergeSortNumerical(right);
            mergeNumerical(pricesIn, left, right);
		}   
	}
	
	public void mergeNumerical(double[] result, double[] left, double[] right) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length &&
                                 left[i1]<right[i2])) {
                      result[i] = left[i1];
                      i1++;
                 } else {
                      result[i] = right[i2];
                      i2++;
                 }
            }
    }
	
	//geters
	public String getMake()
	{
		return make;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getMileage()
	{
		return mileage;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public float getEngine()
	{
		return engine;
	}
	
	public char getGrade()
	{
		return grade;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getAlphabeticalPos()
	{
		return alphabeticalPos;
	}
	
	public int getPricePos()
	{
		return pricePos;
	}
	
	//setters
	
	public void setMake(String makeIn)
	{
		make=makeIn;
	}
	
	public void setModel(String modelIn)
	{
		model=modelIn;
	}
	
	public void setYear(int yearIn)
	{
		year=yearIn;
	}
	
	public void setMileage(int mileageIn)
	{
		mileage=mileageIn;	
	}
	
	public void setPrice(double priceIn)
	{
		price=priceIn;
	}
	
	public void setEngine(float engineIn)
	{
		engine=engineIn;
	}
	
	public void setGrade(char gradeIn)
	{
		grade=gradeIn;	
	}
	
	public void setId(int idIn)
	{
		id=idIn;
	}
			
	public String getAllData()
	{
		return Integer.toString(getId())+ "\t"
				+getMake() + "\t"
				+getModel() + "\t"
				+Integer.toString(getYear()) + "\t"
				+Integer.toString(getMileage())+ "\t"
				+Float.toString(getEngine())
				+getGrade()+ "\t"
				+Double.toString(getPrice());
	}
	
	public void setCarData(){
		//gets the data from the user
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter vehicle manufacturer: ");
		make = sc.next(); //remember to update sc.next() to include spaces and check for errors
		System.out.print("Enter Vehicle model: ");
		model = sc.next();
		System.out.print("Enter vehicle year of manufacture: ");
		year = sc.nextInt();
		System.out.print("Enter vehicle mileage: ");
		mileage = sc.nextInt();
		System.out.print("Enter vehicle Engine Size: ");
		engine = sc.nextFloat();
		System.out.print("Enter vehicle grade: ");
		grade = sc.next().charAt(0);
		System.out.print("Enter vehicle price: ");
		price = sc.nextDouble();
		
		// increase the id number
		id++;
		carList.add(new CarShop(make, model, year, mileage, price, engine, grade, id));
	}
		
	public static void loadSampleData()
	{
		//(String makeIn, String modelIn, int yearIn, int mileageIn, double priceIn, float engineIn, char gradeIn, int idIn)
		carList.add(new CarShop("Honda", "Fit", 2013, 200500, 5550.5, 1.3f, 'A', 1));
		carList.add(new CarShop("Toyota", "Prius", 2012, 88000, 8450, 1.8f, 'A', 2));
		carList.add(new CarShop("Volkswagen", "Golf", 2016, 74550, 12500, 1.5f, 'B', 3));
		carList.add(new CarShop("Toyota", "Yaris", 2011, 110100, 6500.5, 1.0f, 'A', 4));
		carList.add(new CarShop("Toyota", "Prius", 2015, 52300, 9999.95, 1.8f, 'C', 5));
		carList.add(new CarShop("Volkswagen", "Polo", 2012, 140820, 3050.5, 1.2f, 'B', 6));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//variable to record user's choice
		String selection;
		//Create the reporting object
		CarShop entry = new CarShop();
		//Create a scanner object to receive the user input
		Scanner sc = new Scanner(System.in);
		
		//Clear the screen
		System.out.print("\033[H\033[2J");
		System.out.flush();	
				
		//run the menu until quit option slected
		do {
			//Display the menu
			System.out.println("Enter option number:\n "				
				+ "1. Load sample data\n"
				+ "2. Enter new data for a car\n"
				+ "3. List cars in the order entered\n"
				+ "4. List cars in alphabetical order by model\n"
				+ "5. List cars sorted by price (ascending)\n"
				+ "6. Show car with lowest mileage\n"
				+ "7. Show car with lowest price\n"
				+ "8. Show condition of a selected car (by ID)\n"
				+ "9. Show volume of stock grouped by manufacturer\n"
				+ "0. Quit");
			//Get the entry
			selection = sc.next();
			//if more than one character is entered, generate an error
			if(!selection.substring(1).equals(""))
			{
				selection="Esc"; //this will generate a default below
			}
				
			//Clear the screen
			System.out.print("\033[H\033[2J");
			System.out.flush();
			
			switch(selection)
			{
				case "1":{					
					//Load the sample data
					loadSampleData();
					break;
				}
				case "2":{
					//Generate the report for Kitchen checking for errors in the data on first part
					entry.setCarData();
					break;
				}
				case "3":{
					//Display cars in the order they came in
					for (CarShop item : carList)
					{
						System.out.println(item.getAllData());						
					}
					break;
				}
				case "4":{
					//List cars in Alphabetical order
					for(int i=0; i<carList.size(); i++)
					{
						for (CarShop item : carList)
						{
							if(item.getAlphabeticalPos()==i)
							{
								System.out.println(item.getAllData());
							}
						}
					}
					break;
				}
				case "5":{
					//List cars by order of price
					for(int i=0; i<carList.size(); i++)
					{
						for (CarShop item : carList)
						{
							if(item.getPricePos()==i)
							{
								System.out.println(item.getAllData());
							}
						}
					}		
					break;
				}
				case "6":{
					System.out.println("This option has not yet been implemented\n");
					break;
				}
				case "7":{
					System.out.println("This option has not yet been implemented\n");
					break;
				}
				case "8":{
					System.out.println("This option has not yet been implemented\n");
					break;
				}
				case "9":{
					System.out.println("This option has not yet been implemented\n");
					break;
				}
				case "0":{
					System.out.println("Program terminated\n");
					break;
				}
				default:{
					System.out.println("\n***Incorrect value entered!***\n");
				}
			}
		}
		while (!selection.equals("0"));		
			
	}

}
