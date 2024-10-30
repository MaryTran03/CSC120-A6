/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int creams, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = creams;
        this.nCups = cups;

        System.out.println("You have built a cafe!");
    }
    
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        // Check if there is enough inventory. If not restock. 
        if (hasInventory(size, nSugarPackets, nCreams) == false){
            restock(size, nSugarPackets, nCreams, nCreams);
        }

        // Decrease the inventory
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups = this.nCups - 1;   
        System.out.println("Coffee sold!");
    }

    public boolean hasInventory(int size, int nSugarPackets, int nCreams){
        if(this.nCoffeeOunces >= size && 
            this.nSugarPackets >= nSugarPackets &&
            this.nCreams >= nCreams &&
            this.nCups >= 1){
            return true;
        } else {
            return false;
        }
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        if (this.nCoffeeOunces < nCoffeeOunces){
            this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces*3;
            System.out.println("Coffee restocked!");
        }
        if (this.nSugarPackets < nSugarPackets){
            this.nSugarPackets = this.nSugarPackets + nSugarPackets*3;
            System.out.println("Sugar restocked!");

        }
        if (this.nCups < nCups){
            this.nCups = this.nCups + nCups*3;
            System.out.println("Cups restocked!");

        }
        if (this.nCreams < nCreams){
            this.nCreams = this.nCreams + nCreams*3;
            System.out.println("Creams restocked!");
        }
    }
    public static void main(String[] args) {
        Cafe CC = new Cafe("Campus Center","100 Elm Street",2,30,10,10,30);
        CC.sellCoffee(12, 2, 2);
        CC.sellCoffee(16, 0, 2);
        CC.sellCoffee(18, 0, 2);

    }

}
