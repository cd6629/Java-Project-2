package machine;
import food.Apple;
import food.Sandwich;
import transactions.Payment;


public class Register {

	private static int registerCounter = 0;
	private static final String REGISTERCODE = "US-FL-032020-";
	private static final double DOLLARVALUE = 1.00;
	private static final double QUARTERVALUE = 0.25;
	private static final double DIMEVALUE = 0.10;
	private static final double NICKELVALUE = 0.05;
	private static final double PENNYVALUE = 0.01;
	String registerId;
	int numberOfOneDollarBills;
	int numberOfQuarters;
	int numberOfDimes;
	int numberOfNickels;
	int numberOfPennies;
	double currentTotal;
	
	public Register(String registerID,
			int numberOfOneDollarBills,
			int numberOfQuarters,
			int numberOfDimes,
			int numberOfNickels, 
			int numberOfPennies) {
		
		registerCounter++;	
		registerID = REGISTERCODE + registerCounter;
		currentTotal = 0.0;
		this.numberOfOneDollarBills = numberOfOneDollarBills;
		this.numberOfQuarters = numberOfQuarters;
		this.numberOfDimes = numberOfDimes;
		this.numberOfNickels = numberOfNickels;
		this.numberOfPennies = numberOfPennies;
	}

	private double cashValue(){
		double total = numberOfOneDollarBills * DOLLARVALUE +
		numberOfQuarters * QUARTERVALUE +
		numberOfDimes * DIMEVALUE +
		numberOfNickels * NICKELVALUE +
		numberOfPennies * PENNYVALUE;
		return total;
	}
	public void cashInfo(String personal) {
		if(personal.equals("Manager")) {
			//System.out.println(cashValue);
		
	
			System.out.println("==========================================");
			System.out.println("Register Cash Info");
			System.out.println("==========================================");
			System.out.println("Access Level:\t\t Valid");
			System.out.printf("Cash in the Register:\t $%-15.2f\n", cashValue());
			System.out.printf("Dollars:\t\t %-15d\n", numberOfOneDollarBills);
			System.out.printf("Quarters:\t\t %-15d\n", numberOfQuarters);
			System.out.printf("Dimes:\t\t\t %-15d\n", numberOfDimes);
			System.out.printf("Nickels:\t\t %-15d\n", numberOfNickels);
			System.out.printf("Pennies:\t\t %-15d\n", numberOfPennies); }
				
			else { 			//if (personal != "Manager")
	
				System.out.println("==========================================");
				System.out.println("Register Cash Info");
				System.out.println("==========================================");
				System.out.println("Access Level:\t\t Not Valid by " + personal);
				System.out.println("");

			}
		}

	public void buyApple(Apple apple, Payment payment){
		
		
		System.out.println("==========================================");
		System.out.println("Register Buy Apple");
		System.out.println("==========================================");
		System.out.printf("Apple Price:\t\t $%-15.2f\n" , apple.price() );
		System.out.printf("Payment:\t\t $%-15.2f\n" , payment.paymentValue() );

		if (payment.paymentValue() < apple.price()) {
			
			double shortAmount = apple.price() - payment.paymentValue();
			System.out.println("");
			System.out.println("Sorry but you do not have enough money to buy the Apple");
			System.out.printf("You need:\t\t $%-15.2f\n",shortAmount);
			System.out.println("==========================================");
			System.out.println("\n");
	
		}
		
		else if (payment.paymentValue() > apple.price()) {
			System.out.printf("Apple Price:\t\t $%-15.2f\n" , apple.price());
			System.out.printf("Payment:\t\t $%-15.2f\n" , payment.paymentValue()) ;
			giveChange(apple.price(), payment);
		}	
		
		else {
			System.out.println("Exact payment amount, no change needed");
		}	

	}
	
	public void buySandwich(Sandwich sandwich, Payment payment){
		System.out.println("==========================================");
		System.out.println("Register Buy Sandwich");
		System.out.println("==========================================");

	// backwards
		if (payment.paymentValue() > sandwich.getPrice()) {
			
			System.out.printf("Sandwich Price:\t\t $%-15.2f\n" , sandwich.getPrice());
			System.out.printf("Payment:\t\t $%-15.2f\n" , payment.paymentValue()) ;
			giveChange(sandwich.getPrice(), payment);
		}
		
		else if (payment.paymentValue() < sandwich.getPrice()) {
			
			double shortAmount = sandwich.getPrice() - payment.paymentValue();
			System.out.printf("Sandwich Price:\t\t $%-15.2f\n" , sandwich.getPrice() );
			System.out.printf("Payment:\t\t $%-15.2f\n" , payment.paymentValue() );
			System.out.println("");
			System.out.println("Sorry but you do not have enough money to buy the Sandwich");
			System.out.printf("You need:\t\t $%-15.2f\n", shortAmount);
			System.out.println("==========================================");
			System.out.println("\n");
	
		}
		
		else {
			System.out.println("Exact payment amount, no change needed");

		}	

	}
	
	private void giveChange(double price, Payment payment) {

		numberOfOneDollarBills += payment.getNumberOfOneDollarBills();
		numberOfQuarters += payment.getNumberOfQuarters();
		numberOfDimes += payment.getNumberOfDimes();
		numberOfNickels += payment.getNumberOfNickels();
		numberOfPennies += payment.getNumberOfPennies();
		
		double neededChange = payment.paymentValue() - price;
		int neededChangeWhole = (int)Math.round(neededChange * 100);
		System.out.printf("Change:\t\t\t $%-15.2f\n", neededChange);
		
		int changeDollars = neededChangeWhole / 100;
		neededChangeWhole -= changeDollars * 100;
		
		int changeQuarters = neededChangeWhole / 25;
		neededChangeWhole -= changeQuarters * 25;
		
		int changeDimes = neededChangeWhole / 10;
		neededChangeWhole -= changeDimes * 10;
		
		int changeNickels = neededChangeWhole / 5;
		neededChangeWhole -= changeNickels * 5;
		
		int changePennies = neededChangeWhole / 1;
		neededChangeWhole -= changePennies * 1;

		numberOfOneDollarBills -= changeDollars;
		numberOfQuarters -= changeQuarters;
		numberOfDimes -= changeDimes;
		numberOfNickels -= changeNickels;
		numberOfPennies -= changePennies;

		System.out.printf("Dollars:\t\t %-15d\n", changeDollars);
		System.out.printf("Quaters:\t\t %-15d\n", changeQuarters);
		System.out.printf("Dimes:\t\t\t %-15d\n", changeDimes);
		System.out.printf("Nickels:\t\t %-15d\n", changeNickels);
		System.out.printf("Pennies:\t\t %-15d\n", changePennies);

	}
}


