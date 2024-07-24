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
    private RoomList rooms;
    /**
     * list of reservations in a hotel
     */
    private ArrayList<Reservation> reservationList = new ArrayList<>();

    /**
     * hotel constructor that creates a new hotel object
     * @param name name of hotel
     * @param rooms rooms of hotel
     */
    public Hotel(String name, RoomList rooms){

        this.name = name;
        this.rooms = rooms;

    }
    /**
     * adds a room to the hotel
     * @param room room to add
     */
    public void addRoom(Standard room, int typeOfRoom){

        if (rooms.getSize() < 50){

            switch(typeOfRoom){

                case 1: rooms.Srooms.add(room);
                break;
                case 2: rooms.Drooms.add((Deluxe) room);
                break;
                case 3: rooms.Erooms.add((Executive)room);
                break;

            }

        } else {

            System.out.println("MAXIMUM NUMBER OF ROOMS REACHED FOR THIS HOTEL.");
            System.out.println("PLEASE REMOVE A ROOM OR CREATE A NEW HOTEL ENTRY.");

        }
    }
    /**
     * deletes a room from the hotel
     * @param index index of room to delete
     */
    public void deleteRoom(int index, int typeOfRoom){


        if (rooms.getSize() > 1){

            switch(typeOfRoom){

                case 1: this.rooms.Srooms.remove(index);
                break;
                case 2: this.rooms.Drooms.remove(index);
                break;
                case 3: this.rooms.Erooms.remove(index);
                break;

            }

        } else {
            
            System.out.println("THIS HOTEL HAS ONLY ONE ROOM");

        }
    }
    /**
     * automatically sets the room names
     */
    public void setRoomsNameAuto(){

        for (int i = 0; i < this.rooms.Srooms.size(); i++){

            this.rooms.Srooms.get(i).setName("Standard Room " + Integer.toString(i + 1));

        }

        for (int i = 0; i < this.rooms.Drooms.size(); i++){

            this.rooms.Drooms.get(i).setName("Deluxe Room " + Integer.toString(i + 1));

        }

        for (int i = 0; i < this.rooms.Erooms.size(); i++){

            this.rooms.Erooms.get(i).setName("Executive Room " + Integer.toString(i + 1));

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

        for(int i = 0; i < this.rooms.Srooms.size(); i++){

            this.rooms.Srooms.get(i).setBasePrice(basePrice);

        }

        for(int i = 0; i < this.rooms.Drooms.size(); i++){

            this.rooms.Drooms.get(i).setBasePrice(basePrice);
            this.rooms.Drooms.get(i).adjustRoomPrice();

        }

        for(int i = 0; i < this.rooms.Erooms.size(); i++){

            this.rooms.Erooms.get(i).setBasePrice(basePrice);
            this.rooms.Drooms.get(i).adjustRoomPrice();

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
        hotelinfoString += "Base Price: " + Float.toString(this.rooms.Srooms.get(0).getBasePrice()) + "\n";
        hotelinfoString += Integer.toString(this.rooms.getSize()) + " Rooms" + "\n";

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
        for (int i = 0; i < rooms.Srooms.size(); i++){
            System.out.println(rooms.Srooms.get(i).getName());
        }
        for (int i = 0; i < rooms.Drooms.size(); i++) {
            System.out.println(rooms.Drooms.get(i).getName());
        }
        for (int i = 0; i < rooms.Erooms.size(); i++) {
            System.out.println(rooms.Erooms.get(i).getName());
        }
    }
    /**
     * returns the rooms of the hotel
     * @return the rooms of the hotel
     */
    public RoomList getRooms(){

        return this.rooms;

    }
    /**
     * gets the number rooms available to book based on a date
     * @param date date to check
     * @return number of rooms available
     */
    public int getAvailableRooms(String date){

        ArrayList <Reservation> tempReservations = new ArrayList<>(this.reservationList);

        ArrayList <Standard> tempRooms = new ArrayList<>(this.rooms.Srooms);
        tempRooms.addAll(rooms.Drooms);
        tempRooms.addAll(rooms.Erooms);
        


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

      
            }

        }
        return tempRooms.size();

    }
    /**
     * returns the number of booked rooms based of a date
     * @param date date to check
     * @return number of booked rooms
     */
    public int getBookedRooms(String date){

        return this.rooms.getSize() - this.getAvailableRooms(date);

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

        ArrayList <Standard> tempRooms = new ArrayList<>(rooms.Srooms);
        tempRooms.addAll(rooms.Drooms);
        tempRooms.addAll(rooms.Erooms); 

        for (int i = 0; i < this.reservationList.size(); i++){

            if (tempRooms.get(index).getName().equals(this.reservationList.get(i).getRoom().getName())){

                System.out.println(this.reservationList.get(i).getCheckIn() + " - " + this.reservationList.get(i).getCheckOut());

            }

        }

    }

}
