//=============================================================================
// PROGRAMMER: Dante Cook
// PANTHER ID: 5686335
//
// CLASS: COP2210
// SECTION: U04-U06
// SEMESTER: Fall 2020
// CLASSTIME: T/TH 5:00-6:15 pm
//
// Project: Project 2
// DUE: 11/08/20
//
// CERTIFICATION:  I understand FIU’s academic policies, and I certify that this
//                 work is my  own and that none of it is the work of any 
//                 other person.
//=============================================================================


package app;
import food.Apple;
import food.Sandwich;
import machine.Register;
import transactions.Payment;

public class Controller {

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println("COP2210 - Project 2");
        System.out.println("Dante Cook");
        System.out.println("PID: 5686335");
        System.out.println("SECTION: U04-U06");
        System.out.println("===============================================");
        System.out.println("\n");
        
        Register register = new Register("Manager", 15, 20, 10, 20, 50);
        
        register.cashInfo("Manager");
        register.cashInfo("Staff");

        Apple apple = new Apple("Granny Smith", 1.51, 140, 0.47);

        apple.displayInfo();


        Payment applePayment1 = new Payment(10, 0, 0, 0, 47);

        applePayment1.displayInfo();

        
        register.cashInfo("Manager");      
        register.buyApple(apple, applePayment1);

        Apple macintosh = new Apple("Macintosh", 1.70, 150, 0.56);

        macintosh.displayInfo();


        Payment applePayment2 = new Payment(0, 2, 0, 0, 0);

    	applePayment2.displayInfo();
    	
    	
        register.cashInfo("Manager");       
        register.buyApple(macintosh, applePayment2);

    	Sandwich sandwich = new Sandwich(true, true, true);

    	sandwich.displayInfo();


    	Payment sandwichPayment1 = new Payment(5, 2, 1, 1, 2);

    	sandwichPayment1.displayInfo();
    	  	
        register.cashInfo("Manager");      
        register.buySandwich(sandwich, sandwichPayment1);

    	boolean meat = true;
    	boolean cheese = true;
    	boolean veggies = true;
    	System.out.println("");
     
    	for (int i = 0; i < 8; i++) {
    		if (i < 3) {
    			meat = true;
    		}
    		else {
    			meat = false;
    		}
    		
    		if (i == 0 || i == 1 || i == 4 || i == 5) {
    			cheese = true;
    		}
    		else {
    			cheese = false;
    		}
    		
    		if (i == 0 || i == 2 || i == 4 || i == 6) {
    			veggies = true;
    		}
    		else {
    			veggies = false;
    		}
    		
        	Sandwich sandwichCombo = new Sandwich(meat, cheese, veggies);
            System.out.println("===============================================");
            sandwichCombo.displayInfo();
            Payment sandwichPayment2 = new Payment(10, 0, 0, 0, 0);
            sandwichPayment2.displayInfo();
            register.cashInfo("Manager");
            register.buySandwich(sandwichCombo, sandwichPayment2);
            System.out.println("===============================================");
            System.out.println("");
    	}
    	
    }

}