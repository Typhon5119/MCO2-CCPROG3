public class Executive extends Room{
    private double finalBPrice;
    public Executive(){
        super();
        finalBPrice = this.getBasePrice() * .35;
    }
    public double getFinalBP(){
        return this.finalBPrice;
    }
}
    