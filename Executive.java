public class Executive extends Standard{
    private double finalBPrice;
    public Executive(){
        super();
        finalBPrice = this.getBasePrice() + (this.getBasePrice() * .35);
    }
    public double getFinalBP(){
        return this.finalBPrice;
    }
}
    