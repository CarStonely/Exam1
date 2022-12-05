package assignment6;


import java.util.Scanner;
import java.util.Arrays;


/**
 * @author Carson Johnson
 * Program is meant to search through a 2D array for a corresponding user input and manipulate that array
 * 
 */


public class Assignment6_1 {
  
  
//Declaring a 2D array to hold the seat prices
  static int[][] seatPrice=
  {  
    {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
    {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
    {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
    {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
    {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
    {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
    {20, 20, 30, 30, 40, 40, 30, 30, 20, 20},
    {20, 40, 50, 50, 50, 50, 50, 50, 40, 20},
    {80, 50, 50, 80, 80, 80, 80, 50, 50, 30}
    
  };
  
 
  /**
 * Method that prints out entire 2D array
 */
static void seatRoster()
  {
   System.out.println("These are the seats still avaliable. (Seats under a 0 are no longer avaliable)");
   System.out.println(Arrays.deepToString(seatPrice).replace("], ", "]\n"));
  }
  
  
  /**
 * Method is used to get users input and validate that input 
 * @return - returns -1 if user enters Q, Returns the user input as an int if it's valid and returns 0 if value isn't valid
 */
static int readPrice()
  {
  String price;
  Scanner sc = new Scanner(System.in);
  System.out.println("");
  System.out.print("Please pick a price or press Q to quit: ");
  
  price = sc.next(); // Getting user input
  if(price.equalsIgnoreCase("Q")) //User input to end program
  {
   System.out.println("Thank you for using the program, Exiting now.");
   return -1; //return -1 if user inputs Q
  }
  else if(price.matches("10|20|30|40|50|80"))  //Using RegEx to compare user input to multiple values 
  {
   return Integer.parseInt(price);  //Converts string to INT if user input is valid 
  }
  else
  {
   System.out.println("Please pick a valid price. Valid prices are $10, $20, $30, $50, and $80"); //Output if user enters non valid price
   return 0;  //return 0 if input is invalid
  }
  }
  
  
 /**
 * Method is used to select a seat from the 2D array
 * @param price - gets the parameter price from the method readPrice to compare to the values in the 2d array 
 * @return - Returns the seat's index in the 2D array 
 */
static int seatVal(int price)
  {
   System.out.println("Checking for seat avalability......");
   /*
    * Nested for loop to iterate the entire array to search for price matching user input
    */
   
   for(int i = 0; i < 9; i++)  
   {
    for (int j = 0; j < 10; j++)
    {
     if(price == seatPrice[i][j])
       {
      seatPrice[i][j] = 0; // setting value in seatPrice array to 0 after it's selected
      return (i*10)+(j+1) ; //returning the seat if it's found within the 2D array
    }
   }
  }
   return -1; //returning -1 if value isn't found in 2D array
  }
  
  
  /**
   * Method is used to print out the confirmed seat or whether if the seat is not available 
 * @param seatNum - gotten from the Method seatVal and prints out seat number if seatVal didn't return -1 
 */
static void printSeat(int seatNum)
  {
   if(seatNum == -1)  //Prints seat not available if seatVal returns -1 
   {
    System.out.println("There is no seat avaliable at this price.");
    System.out.println("");
   }
   else //Prints out seat number if seat if received from method seatVal 
   {
    System.out.println("Your seat is confimred. Your seat number is: " + seatNum);
    System.out.println("");    
   }
  }
  
  
  /**
 * @param args
 * Main Method
 */
public static void main(String args[])
  {
   //Initializing price and seatNum variables
    int price;
    int seatNum;
    
    while(true) //Infinite While loop
    {
      price = readPrice(); //running readPrice method
      
      if(price == -1) //Ends program if method readPrice returns a -1 (user entered a "q") 
      {
        break;
      }
      else if(price == 0) //Infinite While loop continues if readPrice returns 0 (user input a non valid price) 
      {
      }
      else // Output if user enters a valid price for a seat
      { 
        seatNum = seatVal(price); //Calls seatMethod value is readPrice doesn't return 0 or -1 
        printSeat(seatNum); //calling printSeat method 
        seatRoster();  //calls seatRoster method that prints 2D array with remaining seat values
      }
    }
  }
}
  