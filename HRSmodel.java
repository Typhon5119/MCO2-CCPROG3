import java.util.ArrayList;

public class HRSmodel {
    private ArrayList<Hotel> hotelList = new ArrayList<>();
    public HRSmodel(){

    }
    public boolean addHotel(String hotelNameInput, String nRooms, String nDrooms, String nErooms){
        if (nRooms.equals("")){
            nRooms = "0";
        }
        if (nDrooms.equals("")){
            nDrooms = "0";
        }
        if (nErooms.equals("")){
            nErooms = "0";
        }
        int totRooms = Integer.parseInt(nRooms) + Integer.parseInt(nDrooms) + Integer.parseInt(nErooms);
        boolean res = false;
        try{
        if (totRooms >= 0 && totRooms <= 50){
            ArrayList <Room> rooms = new ArrayList<>();
            // name should be unique
            boolean isNameUnique = true;
                for (int k = 0; k < hotelList.size(); k++){
                    if (hotelList.get(k).getName().equals(hotelNameInput)){
                        isNameUnique = false;
                    }
                }
            //--
            if (isNameUnique){
                for (int i = 0; i < Integer.parseInt(nRooms); i++){

                    Room room = new Room();
                    rooms.add(room);
                    room = null;

                }
                for (int j = 0; j < Integer.parseInt(nDrooms); j++){
                    Room room = new Deluxe();
                    rooms.add(room);
                    room = null;
                }
                for (int k = 0; k < Integer.parseInt(nErooms); k++){
                    Room room = new Executive();
                    rooms.add(room);
                    room = null;
                }


                Hotel tempHotel = new Hotel(hotelNameInput, rooms);
                tempHotel.setRoomsNameAuto();
                hotelList.add(tempHotel);
                res = true;
                
            }
            else {
                System.out.println("Input a unique name");
            }
        } else {
            System.out.println("Amount of rooms not allowed.");
            hotelNameInput = null;
        }
        }
        catch(Exception e){
            System.out.println("error");
        }
        return res;
    }
    public ArrayList<Hotel> getHotellist(){
        return hotelList;
    }


}

