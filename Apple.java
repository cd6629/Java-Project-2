package food;


public class Apple {

    String type;

    double weight;

    double pricePreUnitWeight;
    
    double price;

    public Apple(String type, double pricePreUnitWeight, double weightInGrams, double price) {
    	
    	weight = 0.00220 * weightInGrams;

        this.type = type;

        this.pricePreUnitWeight = pricePreUnitWeight;
        
        this.price = price;

    }

    public String getType() {

        return type;

    }

    public double getWeight() {

        return weight;

    }

    public double getPricePreUnitWeight() {

        return pricePreUnitWeight;

    }

    public void setPricePreUnitWeight(double pricePreUnitWeight, String personal) {

        this.pricePreUnitWeight = pricePreUnitWeight;

    }
    
    public double price() {
    	double price = weight * pricePreUnitWeight;
        return price;
    }

    public void displayInfo() {

        System.out.println("==========================================");
        System.out.println("Apple Info");
        System.out.println("==========================================");
        System.out.printf("Type:\t\t\t %-15s\n", type);
        System.out.printf("Weight:\t\t\t %-6.4f lbs\n", weight);
        System.out.printf("Price Per Unit:\t\t %-10.2f\n", pricePreUnitWeight);
        System.out.printf("Price:\t\t\t %-10.2f\n", price);

    }



}