/**
 * Represents a reservation in a hotel
 */
public class Reservation {
    /**
     * name of guest
     */
    private final String guestName;
    /**
     * check in date
     */
    private final String checkIn;
    /**
     * check out date
     */
    private final String checkOut;
    /**
     * room of reservation
     */
    private final Room room;

    /**
     * total cost of reservation
     */
    private double totalCost;

    /**
     * Reservation constructor
     * @param guestName name of guest
     * @param checkIn check in date
     * @param checkOut check out date
     * @param room room to be used
     */
    public Reservation(String guestName, String checkIn, String checkOut, Room room){

        this.guestName = guestName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
        totalCost = this.getCostPerNight() * this.getLengthOfStay();

    }
    /**
     * returns the guest name
     * @return the guest name
     */
    public String getGuestName(){

        return this.guestName;

    }

    /**
     * returns the check in date
     * @return check in date
     */
    public String getCheckIn(){

        return this.checkIn;

    }
    
    /**
     * returns the check out date
     * @return check out date
     */
    public String getCheckOut(){

        return this.checkOut;

    }

    /**
     * returns the room
     * @return room
     */
    public Room getRoom(){

        return this.room;

    }

    /**
     * returns the base price (the cost per night) of the room
     * @return base price of room
     */
    public float getCostPerNight(){

        return this.room.getBasePrice();

    }
    
    /**
     * returns the length of stay in days
     * @return length of stay
     */
    private float getLengthOfStay(){
        String[] arr1 = this.checkIn.split("/");
        String[] arr2 = this.checkOut.split("/");

        return Integer.parseInt(arr2[0]) - Integer.parseInt(arr1[0]);

    }

    /**
     * returns the total cost
     * @return total cost
     */
    public double getTotalCost(){

        return totalCost;

    }

    public void setTotalCost(double newCost){
        this.totalCost = newCost;
    }

}
