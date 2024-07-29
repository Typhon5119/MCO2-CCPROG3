
/**
 * Represents a room in a hotel
 */
public class Room {
    /**
     * name of room
     */
    private String name;
    /**
     * base price of room per night
     */
    protected double basePrice;
    
    /**
     * room constructor
     */
    public Room(){

        this.basePrice = (float) 1299;

    }
    /**
     * room constructor
     * @param name room name
     */
    public Room(String name){

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
    public double getBasePrice(){

        return this.basePrice;

    }

    public double getTrueBaseP(){
        double BP;
        if (this instanceof Deluxe){   
            BP = basePrice / (1 + .20); 
        }
        else if (this instanceof Executive){   
            BP = basePrice / (1 + .35);
        }
        else{
            BP = basePrice;
        }
        return BP;
    }

}
