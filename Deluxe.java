/**
 * Object for Deluxe Room
 */

public class Deluxe extends Room{
    private double finalPrice;
    /**
     * Constructor
     */
    public Deluxe(){
        super();
        finalPrice = this.getBasePrice() + (this.getBasePrice() * .20);
        this.basePrice = finalPrice;
    }
    /**
     * gets the final price
     * @return final price
     */
    public double getFinalBP(){
        return this.finalPrice;
    }

    
}
