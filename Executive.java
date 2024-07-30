public class Executive extends Room{
    private double finalBPrice;
    public Executive(){
        super();
        finalBPrice = this.getBasePrice() + (this.getBasePrice() * .35);
        this.basePrice = finalBPrice;
    }
    public double getFinalBP(){
        return this.finalBPrice;
    }
}
    