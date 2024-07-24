public class Deluxe extends Standard{
    private double finalPrice;
    public Deluxe(){
        super();
        finalPrice = this.getBasePrice() + (this.getBasePrice() * .20);
    }
    public double getFinalBP(){
        return this.finalPrice;
    }

    
}
