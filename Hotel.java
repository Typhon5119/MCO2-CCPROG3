import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Represents a hotel
 */
public class Hotel{
    /**
     * name of hotel
     */
    private String name;
    /**
     * rooms of the hotel
     */
    private ArrayList<Room> rooms = new ArrayList<>();
    // private ArrayList<Deluxe> Drooms = new ArrayList<>();
    // private ArrayList<Executive> Erooms = new ArrayList<>();
    /**
     * list of reservations in a hotel
     */
    private ArrayList<Reservation> reservationList = new ArrayList<>();

    /**
     * hotel constructor that creates a new hotel object
     * @param name name of hotel
     * @param rooms rooms of hotel
     */
    public Hotel(String name, ArrayList<Room> rooms){

        this.name = name;
        this.rooms = rooms;

    }
    /**
     * adds a room to the hotel
     * @param room room to add
     */
    public void addRoom(Room room){

        if (rooms.size() < 50){

            rooms.add(room);

        } else {

            System.out.println("MAXIMUM NUMBER OF ROOMS REACHED FOR THIS HOTEL.");
            System.out.println("PLEASE REMOVE A ROOM OR CREATE A NEW HOTEL ENTRY.");

        }
    }
    /**
     * deletes a room from the hotel
     * @param index index of room to delete
     */
    public void deleteRoom(int index){
        if (rooms.size() > 1){

            rooms.remove(index);

        } else {
            
            System.out.println("THIS HOTEL HAS ONLY ONE ROOM");

        }
    }
    /**
     * automatically sets the room names
     */
    public void setRoomsNameAuto(){

        for (int i = 0; i < this.rooms.size(); i++){

            this.rooms.get(i).setName("Room " + Integer.toString(i + 1));

        }

    }
    /**
     * finds a room to reserve and reserves in the correct room
     * @param startDate guests date of check in
     * @param endDate guests date of check out
     * @param guestName name of guest booking
     * @return name of room assigned to guest
     */
    public String findRoom(String startDate, String endDate, String guestName, String pCode){
        int j;
        for (int i = 0; i < rooms.size(); i++){
            for (j = 0; j < reservationList.size(); j++){
                if (reservationList.get(j).getRoom().getName().equals(rooms.get(i).getName())){
                    String[] startArr = reservationList.get(j).getCheckIn().split("/");
                    String[] endArr = reservationList.get(j).getCheckOut().split("/");
                    String[] dateArr = startDate.split("/");
                    String[] date2Arr = endDate.split("/");
                    if (startDate.equals(reservationList.get(j).getCheckIn()) || 
                        endDate.equals(reservationList.get(j).getCheckIn()) ||
                        startDate.equals(reservationList.get(j).getCheckOut()) || 
                        endDate.equals(reservationList.get(j).getCheckOut())){
                            break;
                        }
                    if (Integer.parseInt(dateArr[0]) == Integer.parseInt(startArr[0]) && 
                    Integer.parseInt(date2Arr[0]) == Integer.parseInt(endArr[0])){
                        break;
                    }

                    if (Integer.parseInt(dateArr[0]) > Integer.parseInt(startArr[0]) &&
                        Integer.parseInt(dateArr[0]) < Integer.parseInt(endArr[0]) || 
                        Integer.parseInt(date2Arr[0]) > Integer.parseInt(startArr[0]) &&
                        Integer.parseInt(date2Arr[0]) < Integer.parseInt(endArr[0])){
                        break;
                    }
                    else if ((Integer.parseInt(dateArr[0]) <= Integer.parseInt(startArr[0]) &&
                        Integer.parseInt(dateArr[0]) <= Integer.parseInt(endArr[0])) && 
                        (Integer.parseInt(date2Arr[0]) >= Integer.parseInt(startArr[0]) &&
                        Integer.parseInt(date2Arr[0]) >= Integer.parseInt(endArr[0]))){
                        break;
                    }
                    else if (Integer.parseInt(date2Arr[0]) == Integer.parseInt(startArr[0])){
                        if (Integer.parseInt(date2Arr[1]) > Integer.parseInt(startArr[1])){
                            break;
                        }
                        else if (Integer.parseInt(date2Arr[1]) == Integer.parseInt(startArr[1])){
                            if (Integer.parseInt(date2Arr[2]) > Integer.parseInt(startArr[2])){
                                break;
                            }
                        }
                    }
                    else if (Integer.parseInt(dateArr[0]) == Integer.parseInt(endArr[0])){
                        if (Integer.parseInt(dateArr[1]) < Integer.parseInt(endArr[1])){
                            break;
                        }
                        else if (Integer.parseInt(dateArr[1]) == Integer.parseInt(endArr[1])){
                            if (Integer.parseInt(dateArr[2]) < Integer.parseInt(endArr[2])){
                                break;
                            }
                        }
                    }
                }
            }
            if (j == reservationList.size()){
                Reservation temp = new Reservation(guestName, startDate, endDate, rooms.get(i));
                if (pCode.equals("I_WORK_HERE")){
                    
                    double newCost = temp.getTotalCost() * .90;
                    temp.setTotalCost(newCost);
                }
                if (pCode.equals("STAY4-GET1")){
                    if (temp.getLengthOfStay() + 1 >= 5)
                        temp.setTotalCost(temp.getTotalCost() - temp.getCostPerNight());
                }
                
                reservationList.add(temp);
                return rooms.get(i).getName();
            }
        }
        return "Cannot find room";
    }

    /**
     * changes base price of all rooms
     * @param basePrice new base price
     */
    public void setRoomsPrice(float basePrice){

        for(int i = 0; i < this.rooms.size(); i++){

            this.rooms.get(i).setBasePrice(basePrice);

        }

    }
    /**
     * returns the name of the hotel
     * @return name
     */
    public String getName(){

        return this.name;

    }
    /**
     * changes the name of the hotel
     * @param newName new name
     */
    public void setName(String newName){
        this.name = newName;
    }
    /**
     * returns the list of reservations in a hotel
     * @return list of reservations
     */
    public ArrayList<Reservation> getReservationList(){
        return reservationList;
    }


    /**
     * displays the hotel information
     */
    public String displayHotel(){
        String hotelinfoString = "";
        hotelinfoString += this.name + ":" + "\n";
        hotelinfoString += "Base Price: " + Float.toString(this.rooms.get(0).getBasePrice()) + "\n";
        hotelinfoString += Integer.toString(this.rooms.size()) + " Rooms" + "\n";

        float totalEarnings = 0;

        for (int i = 0; i < this.reservationList.size(); i++){

            totalEarnings += this.reservationList.get(i).getTotalCost();

        }

        hotelinfoString += "Total earnings for the month: " + Float.toString(totalEarnings) + "\n\n";
       /* for (int i = 0; i < reservationList.size(); i++){
            System.out.println(reservationList.get(i).getGuestName() + ":");
            System.out.println(reservationList.get(i).getRoom().getName());
            System.out.println(reservationList.get(i).getCheckIn());
            System.out.println(reservationList.get(i).getCheckOut());
            System.out.println(reservationList.get(i).getCostPerNight());
            System.out.println(reservationList.get(i).getTotalCost());
        } */
        return hotelinfoString;

    }
    /**
     * displays the name of the rooms of the hotel
     */
    public void displayRooms(){
        for (int i = 0; i < rooms.size(); i++){
            System.out.println(rooms.get(i).getName());
        }
    }
    /**
     * returns the rooms of the hotel
     * @return the rooms of the hotel
     */
    public ArrayList<Room> getRooms(){

        return this.rooms;

    }
    /**
     * gets the number rooms available to book based on a date
     * @param date date to check
     * @return number of rooms available
     */
    public int getAvailableRooms(String date){

        ArrayList <Reservation> tempReservations = new ArrayList<>(this.reservationList);

        ArrayList <Room> tempRooms = new ArrayList<>(this.rooms);

        for (int i = 0; i < tempReservations.size(); i++){
            
            String reservationCheckIn = tempReservations.get(i).getCheckIn();
            String reservationCheckOut = tempReservations.get(i).getCheckOut();

            if(date.compareTo(reservationCheckIn) >= 0 && date.compareTo(reservationCheckOut) <= 0){


                for (int j = 0; j < tempRooms.size(); j++){

                    if(tempReservations.get(i).getRoom().getName().equals(tempRooms.get(j).getName())){

                        tempRooms.remove(j);
                        j--;

                    }

                }

//                tempReservations.remove(i);
//                i--;

            }

        }

   /*      for (int i = 0; i < tempReservations.size(); i++){

            tempRooms.add(tempReservations.get(i).getRoom());

        }
        
        for (int i = 0; i < tempRooms.size(); i++){

            for (int j = i + 1; j < tempRooms.size(); i++){

                if (tempRooms.get(i).getName().equals(tempRooms.get(j).getName())){

                    tempRooms.remove(j);

                }

            }

        } */

        return tempRooms.size();

    }
    /**
     * returns the number of booked rooms based of a date
     * @param date date to check
     * @return number of booked rooms
     */
    public int getBookedRooms(String date){

        return this.rooms.size() - this.getAvailableRooms(date);

    }

  /*  public void printRoomAvailability(int index){

        ArrayList<Reservation> tempReservation = new ArrayList<>();

        for (int i = 0; i < this.reservationList.size(); i++){

            if (this.rooms.get(index).getName().equals(this.reservationList.get(i).getRoom().getName())){

                tempReservation.add(this.reservationList.get(i));

            }

        }



    } */
    /**
     * displays the reservations of a room
     * @param index index of room in rooms
     */
    public void printRoomReservations(int index){

        for (int i = 0; i < this.reservationList.size(); i++){

            if (this.rooms.get(index).getName().equals(this.reservationList.get(i).getRoom().getName())){

                System.out.println(this.reservationList.get(i).getCheckIn() + " - " + this.reservationList.get(i).getCheckOut());

            }

        }

    }

}
