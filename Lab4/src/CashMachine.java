/*
 * This program stores information on purchases made and prints out a receipt
 */


import java.util.Scanner;
public class CashMachine {
	//variable declarations 
	private Scanner consoleInput=new Scanner(System.in);
	private int itemCount;
	private double tax;
	private double sum;
	private String receipt;
	//extra
	
	
	
	//constructor
	public CashMachine(double tax) {
		this.tax=tax;
		this.itemCount=0;
		this.sum=0;
		this.receipt="";//instantiate the receipt variable into an empty string
		
		
		
		
	}
	
	//methods
	
	//method #1-this method takes in a string argument prints it and also returns user's input
	private String getOneStringInput(String word) {
		System.out.print(word);
		String new_word= consoleInput.next();//use next() instead of nextLine() because you're useing print and not println()
		return new_word;
		
	}
	//method #2-this method takes in a double argument prints it and also returns user's input
	private double getOneDoubleInput(String word1) {
		System.out.print(word1);
		double new_word1=consoleInput.nextDouble();
		return new_word1;
		
	}
	//method #3-this method returns the itemCount aka the number of items
	private int getItemCount() {
		itemCount++;
		return itemCount;
	}
	
	//method #4-this method returns the tax taking the sum(before tax) into account
	private double calculateTax() {
		return tax*sum;
	}
	
	//method #5- this method returns the sum plus the tax...so the real total after tax
	private double calculateTaxPlusSum() {
		
		return sum+ calculateTax();
	}
	//method #6-this method gets users input 1,2 or 3 and assigns it to a decision
	public boolean processMenu() {
		double num=getOneDoubleInput("Action>> ");
		if (num==1) {
			purchaseItem();//if user chooses 1, go to purchaseItem method
			
		}
		else if (num==2) {
			printReceipt();//if user chooses 2, go to printReceipt method
		}
		else  {
		return false;//if user chooses 3, return false, this ends the function
			
		}
		return true;//true is returned for inputs 1 and 2, ending the function
	}
	
	//method 7 this method gets the item name and price from user, stores them
	//increments the item count, adds the given price to the sum and adds given values to the 
	//receipt
	private void purchaseItem() {
		String itemName=getOneStringInput("item name (no spaces) >> ");
		//String itemName=consoleInput.nextLine();//why do i need this here??
		
		double itemPrice=getOneDoubleInput("item price>> ");
		getItemCount();//call on this method to increment the item count
		sum+=itemPrice;
		receipt+= String.format("%-15s$%.2f%n", itemName,itemPrice); //assigning new entries to receipt   
	}
	
	//method 8 
	//this method prints out the user options
	public void printMenu() {
		System.out.println("\n1) Purchase Item");
		System.out.println("2) Print Receipt");
		System.out.println("3) Quit");
		System.out.println();
		
	}
	
	//this method prints out the receipt which includes 
	public void printReceipt() {
		System.out.println();
		if (itemCount==0) {
			System.out.println("\nEmpty!!\n");
		}
		else {
			System.out.printf("Receipt for %s item(s):\n",itemCount);
			System.out.println(receipt);
			double totalPlusTax=calculateTaxPlusSum();
			
			//printing using justification
			System.out.printf("%-15s$%.2f%n","Tax:",tax);
			System.out.printf("%-15s$%.2f%n","Total:",totalPlusTax);
			
			
			/*
			//printing using tabs for spacing
			System.out.printf("Tax:\t\t$%.2f\n",calculateTax());
			System.out.printf("Total:\t\t$%.2f",totalPlusTax);
			
			
			 // printing using justification
			System.out.printf("%-15s$%.2f%n","Tax:",tax);
			System.out.printf("%-15s$%.2f%n","Total:",totalPlusTax);
			*/
			/*
			System.out.println("Apple\t\t$1.10");
			System.out.println("Orange\t\t$2.20");
			System.out.println("Grape\t\t$3.30");
			
			System.out.println();
			System.out.println();
			System.out.println("Tax:\t\t$0.99");
			System.out.println("Total:\t\t$7.59");
			*/
		}
	}
	

}
