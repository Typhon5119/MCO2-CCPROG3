/**
 * Object for Executive Room
 */

public class Executive extends Room{
    private double finalBPrice;
    /**
     * Constructor
     */
    public Executive(){
        super();
        finalBPrice = this.getBasePrice() + (this.getBasePrice() * .35);
        this.basePrice = finalBPrice;
    }
    /**
     * function for getting the final price
     * @return final price
     */
    public double getFinalBP(){
        return this.finalBPrice;
    }
}
    