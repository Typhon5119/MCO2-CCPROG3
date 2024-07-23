public class Deluxe extends Room{
    private double finalBPrice;
    public Deluxe(){
        super();
        finalBPrice = this.getBasePrice() * .20;
    }
    public double getFinalBP(){
        return this.finalBPrice;
    }
    
}
