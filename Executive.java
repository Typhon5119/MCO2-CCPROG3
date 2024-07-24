public class Executive extends Standard{
    private double finalPrice;
    public Executive(){
        super();
        finalPrice = this.getBasePrice() + (this.getBasePrice() * .35);
    }

    public void adjustRoomPrice(){

        finalPrice = this.getBasePrice() + (this.getBasePrice() * .20);

    }

    public double getFinalBP(){
        return this.finalPrice;
    }
}
    