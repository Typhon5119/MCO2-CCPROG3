
/**
 * Represents a room in a hotel
 */
public class Standard {
    /**
     * name of room
     */
    private String name;
    /**
     * base price of room per night
     */
    private float basePrice;
    
    /**
     * room constructor
     */
    public Standard(){

        this.basePrice = (float) 1299;

    }
    /**
     * room constructor
     * @param name room name
     */
    public Standard(String name){

        this.name = name;
        this.basePrice = (float) 1299;

    }
    
    
    /**
     * changes the name of the room
     * @param name new name of the room
     */
    public void setName(String name){

        this.name = name;

    }
    /**
     * changes base price
     * @param basePrice new base price
     */
    public void setBasePrice(float basePrice){

        this.basePrice = (float) basePrice;

    }

    
    /**
     * returns the name of the room
     * @return name of the room
     */
    public String getName(){

        return this.name;

    }
    /**
     * returns the base price of the room
     * @return base price of room
     */
    public float getBasePrice(){

        return this.basePrice;

    }

}
