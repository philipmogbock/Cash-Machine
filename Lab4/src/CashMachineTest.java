//package cst8110;

public class CashMachineTest{

	public static void main( String[] args){

		CashMachine cashMachine = new CashMachine( 0.15);

		System.out.println("Welcome to CashMachine!");
		
		do{
			cashMachine.printMenu();
		}while( cashMachine.processMenu());//while true aka when user input is 1 or 2 

		System.out.println();
		System.out.println("GoodBye!!");
	}
}
