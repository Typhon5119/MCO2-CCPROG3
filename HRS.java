import java.util.ArrayList;
import java.util.Scanner;

/**
 * hotel reservation system Sidney Branch
 */
public class HRS {
    /**
     * main method
     * @param args command line
     */
    public static void main(String[] args) {
        
        int i;
        int sure;
        String menuInput, viewHotelInput;
        // String tempString;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Hotel> hotelList = new ArrayList<>();
        // gui
        HRSmodel model = new HRSmodel();
        HRSview view = new HRSview();
        HRScontroller controller = new HRScontroller(model, view);
        //---------

        do{
            System.out.println("============================");
            System.out.println("Hotel Reservation System");
            System.out.println("============================");
            System.out.printf("\n");
            System.out.println("1. Create Hotel");
            System.out.println("2. View Hotel");
            System.out.println("3. Manage Hotel");
            System.out.println("4. Simulate Booking");
            System.out.println("5. Exit Application");
            System.out.println("============================");
            System.out.println("");
            System.out.println("");

            menuInput = scanner.nextLine();

            if (Integer.parseInt(menuInput) == 1){
                System.out.print("Enter hotel name:");
                String hotelNameInput = scanner.nextLine();
                System.out.print("Enter number of rooms: ");
                String nRooms = scanner.nextLine();
                if (Integer.parseInt(nRooms) >= 0 && Integer.parseInt(nRooms) <= 50){
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
                        for (i = 0; i < Integer.parseInt(nRooms); i++){
    
                            Room room = new Room();
                            rooms.add(room);
                            room = null;
    
                        }
    
    
                        Hotel tempHotel = new Hotel(hotelNameInput, rooms);
                        tempHotel.setRoomsNameAuto();
                        hotelList.add(tempHotel);
                        rooms = null;
                        hotelNameInput = null;
                        tempHotel = null;
                    }
                    else {
                        System.out.println("Input a unique name");
                    }
                } else {
                    System.out.println("Amount of rooms not allowed.");
                    hotelNameInput = null;
                }
                

            } else if (Integer.parseInt(menuInput) == 2){
                if (!hotelList.isEmpty()){

                    System.out.println("============================");
                    for (i = 0; i < hotelList.size(); i++){

                        System.out.println(Integer.toString(i + 1) + ". " + hotelList.get(i).getName());

                    }

                    System.out.print("Select a Hotel (input number): ");
                    viewHotelInput = scanner.nextLine();
                    int viewHotelInt;
                    hotelList.get(Integer.parseInt(viewHotelInput) - 1).displayHotel();

                    do{
                        System.out.println();
                        System.out.println("1. View number of available and booked rooms");
                        System.out.println("2. View room information");
                        System.out.println("3. View reservation information");
                        System.out.println("4. Go back to Main Menu");

                        String viewHotelInput2 = scanner.nextLine();
                        viewHotelInt = Integer.parseInt(viewHotelInput2);
                        int viewHotelInputInt = Integer.parseInt(viewHotelInput) - 1;

                        if (viewHotelInt == 1){

                            System.out.println("Enter date(dd/hh/mm):");
                            String viewAvailableRoomsDate = scanner.nextLine();


                            System.out.println(hotelList.get(viewHotelInputInt).getAvailableRooms(viewAvailableRoomsDate) + " Room/s Available");
                            System.out.println(hotelList.get(viewHotelInputInt).getBookedRooms(viewAvailableRoomsDate) + " Room/s Booked");

                        } else
                        if (viewHotelInt == 2){

                        /*  for (i = 0; i < hotelList.get(viewHotelInputInt).getReservationList().size(); i++){
                                System.out.print(i + 1 + ". ");
                                System.out.println(hotelList.get(viewHotelInputInt).getReservationList().get(i).getGuestName() + ":");
                                System.out.println("Room name: " + hotelList.get(viewHotelInputInt).getReservationList().get(i).getRoom().getName());
                                System.out.println("Check in date: " + hotelList.get(viewHotelInputInt).getReservationList().get(i).getCheckIn());
                                System.out.println("Check out date: " + hotelList.get(viewHotelInputInt).getReservationList().get(i).getCheckOut());
                                System.out.println("Cost per night: " + hotelList.get(viewHotelInputInt).getReservationList().get(i).getCostPerNight());
                                System.out.println("Total Cost: " + hotelList.get(viewHotelInputInt).getReservationList().get(i).getTotalCost());
                                System.out.println("");
                            } */

                            for (i = 0; i < hotelList.get(viewHotelInputInt).getRooms().size(); i++){

                                System.out.println((i + 1) + ". " + hotelList.get(viewHotelInputInt).getRooms().get(i).getName());

                            }
                            System.out.println("");
                            System.out.println("Choose a room:");
                            String roomInfo = scanner.nextLine();
                            int roomInfoInt = Integer.parseInt(roomInfo) - 1;

                            System.out.println(hotelList.get(viewHotelInputInt).getRooms().get(roomInfoInt).getName());
                            System.out.println("Price per night: " + hotelList.get(viewHotelInputInt).getRooms().get(roomInfoInt).getBasePrice());
                            System.out.println("Reserved on: ");
                            hotelList.get(viewHotelInputInt).printRoomReservations(roomInfoInt);


                        } else
                        if (viewHotelInt == 3) {

                            for (i = 0; i < hotelList.get(viewHotelInputInt).getReservationList().size(); i++){

                                System.out.println((i + 1) + ". " + hotelList.get(viewHotelInputInt).getReservationList().get(i).getRoom().getName());
                                System.out.println(hotelList.get(viewHotelInputInt).getReservationList().get(i).getCheckIn() + " - " + hotelList.get(viewHotelInputInt).getReservationList().get(i).getCheckOut());

                            }
                            System.out.print("choose a reservation to view (input number): ");
                            String reservationInfo = scanner.nextLine();
                            int reservationInfoInt = Integer.parseInt(reservationInfo) - 1;


                            System.out.print((reservationInfoInt + 1) + ". ");
                            System.out.println(hotelList.get(viewHotelInputInt).getReservationList().get(reservationInfoInt).getGuestName() + ":");
                            System.out.println("Room name: " + hotelList.get(viewHotelInputInt).getReservationList().get(reservationInfoInt).getRoom().getName());
                            System.out.println("Check in date: " + hotelList.get(viewHotelInputInt).getReservationList().get(reservationInfoInt).getCheckIn());
                            System.out.println("Check out date: " + hotelList.get(viewHotelInputInt).getReservationList().get(reservationInfoInt).getCheckOut());
                            System.out.println("Cost per night: " + hotelList.get(viewHotelInputInt).getReservationList().get(reservationInfoInt).getCostPerNight());
                            System.out.println("Total Cost: " + hotelList.get(viewHotelInputInt).getReservationList().get(reservationInfoInt).getTotalCost());
                            System.out.println("");

                        } else if (viewHotelInt != 4){
                            System.out.println("Not a valid input");

                        }
                    } while(viewHotelInt != 4);

                    

                } else {
                    System.out.println("No hotels to display");
                }

            } else if(Integer.parseInt(menuInput) == 3){
                if (!hotelList.isEmpty()){
                    
                    
                    for (i = 0; i < hotelList.size(); i++){
                        System.out.println(Integer.toString(i + 1) + ". " + hotelList.get(i).getName());
                    }
                    System.out.print("Choose a Hotel to configure (input the number): ");
                    int userIn = Integer.parseInt(scanner.nextLine());
                    userIn -= 1;
                    int userConfigOption;
                    if (!(userIn > hotelList.size() - 1 || userIn < 0)){
                        do{
                            hotelList.get(userIn).displayHotel();
                            System.out.println("1. Change name");
                            System.out.println("2. Add room");
                            System.out.println("3. Remove room");
                            System.out.println("4. Update base price");
                            System.out.println("5. Remove reservation");
                            System.out.println("6. Remove hotel");
                            System.out.println("7. Go to Main Menu");
                            System.out.print("What action do you want to take? ");
                            userConfigOption = Integer.parseInt(scanner.nextLine());
                            // user picks 1
                            if (userConfigOption == 1){

                                System.out.print("New name: ");
                                String userNewName = scanner.nextLine();
                                System.out.println("Are you sure? input 1 to confirm ");
                                sure = Integer.parseInt(scanner.nextLine());
                                if (sure == 1){
                                    boolean isUnique = true;
                                    for (int k = 0; k < hotelList.size(); k++){
                                        if (hotelList.get(k).getName().equals(userNewName)){
                                            isUnique = false;
                                        }
                                    }
                                    if (isUnique){
                                        hotelList.get(userIn).setName(userNewName);
                                    }
                                    else {
                                        System.out.println("Invalid name");
                                    }
                                }
                                else{
                                    System.out.println("canceled");
                                }
                            }
                            // user picks 2
                            else if (userConfigOption == 2){
                                System.out.print("How many rooms to add? ");
                                int rooms2add = Integer.parseInt(scanner.nextLine());

                                System.out.println("Are you sure? input 1 to confirm ");
                                sure = Integer.parseInt(scanner.nextLine());
                                if (sure == 1){
                                    for (int j = 0; j < rooms2add; j++){
                                        Room tempRoom = new Room(".");
                                        hotelList.get(userIn).addRoom(tempRoom);
                                    }
                                    
                                    System.out.println("Rooms added");
                                    hotelList.get(userIn).setRoomsNameAuto();
                                }
                                else{
                                    System.out.println("Rooms not added");
                                }
                            }
                            else if (userConfigOption == 3){
                                hotelList.get(userIn).displayRooms();
                                System.out.print("Which room do you want to delete? (type room number)");
                                int roomdel = Integer.parseInt(scanner.nextLine());

                                System.out.println("Are you sure? input 1 to confirm ");
                                sure = Integer.parseInt(scanner.nextLine());
                                if (sure == 1){
                                    boolean hasReservation = false;
                                    for (int j = 0; j < hotelList.get(userIn).getReservationList().size(); j++){
                                        if (hotelList.get(userIn).getReservationList().get(j).getRoom().getName().equals("Room " + roomdel)){
                                            hasReservation = true;
                                        }
                                    }
                                    if (hasReservation){
                                        System.out.println("cannot remove room");
                                    }
                                    else{
                                        hotelList.get(userIn).deleteRoom(roomdel - 1);
                                        System.out.println("Room removed");
                                        hotelList.get(userIn).setRoomsNameAuto();
                                    }
                                }
                                else {
                                    System.out.println("canceled");
                                }
                            }
                            else if (userConfigOption == 4){
                                System.out.println("Are you sure? input 1 to confirm ");
                                sure = Integer.parseInt(scanner.nextLine());
                                if (sure == 1){
                                    if (hotelList.get(userIn).getReservationList().size() == 0){
                                        System.out.print("New base price greater than or equal to 100: ");
                                        int newBp = Integer.parseInt(scanner.nextLine());
                                        if (newBp >= 100)
                                            hotelList.get(userIn).setRoomsPrice(newBp);
                                        else 
                                            System.out.println("Invalid input");
                                    }
                                    else {
                                        System.out.println("There are reservations in the hotel");
                                    }
                                }
                                else{
                                    System.out.println("canceled");
                                }
                            }
                            else if (userConfigOption == 5){
                                for (int j = 0; j < hotelList.get(userIn).getReservationList().size(); j++){
                                    System.out.println((j+1) + ". " + hotelList.get(userIn).getReservationList().get(j).getGuestName() + ":");
                                    // System.out.println(hotelList.get(userIn).getReservationList().get(i));
                                    System.out.println("Check in date: " + hotelList.get(userIn).getReservationList().get(j).getCheckIn());
                                    System.out.println("Check out date: " + hotelList.get(userIn).getReservationList().get(j).getCheckOut());
                                    System.out.println("Cost per night: " + hotelList.get(userIn).getReservationList().get(j).getCostPerNight());
                                    System.out.println("Total Cost: " + hotelList.get(userIn).getReservationList().get(j).getTotalCost());
                                }
                                System.out.print("Choose reservation to remove: ");
                                int resToRemove = Integer.parseInt(scanner.nextLine());

                                System.out.println("Are you sure? input 1 to confirm ");
                                sure = Integer.parseInt(scanner.nextLine());
                                if (sure == 1){
                                    hotelList.get(userIn).getReservationList().remove(resToRemove - 1);
                                    System.out.println("reservation removed");
                                }
                                else{
                                    System.out.println("reservation not removed");
                                }
                                
                            }
                            else if (userConfigOption == 6){
                                
                                System.out.println("Are you sure? input 1 to confirm ");
                                sure = Integer.parseInt(scanner.nextLine());
                                if (sure == 1){

                                    hotelList.remove(userIn);
                                    System.out.println("hotel removed");
                                }
                                else{
                                    System.out.println("hotel not removed");
                                }
                                
                            }
                        } while (userConfigOption != 7 && (!(userIn > hotelList.size() - 1 || userIn < 0)));
                        
                    }
                    else {
                        System.out.println("invalid input");
                    }
                
                }
                else {
                    System.out.println("No hotels to configure");
                }

            } else if(Integer.parseInt(menuInput) == 4){
                if (hotelList.size() != 0){
                    System.out.print("Guest name: ");
                    String guestName = scanner.nextLine();


                    System.out.println("Select a hotel to book (type the hotel name): ");
                    for (i = 0; i < hotelList.size(); i++){

                        System.out.println(hotelList.get(i).getName());

                    }
                    String bookHotelName = scanner.nextLine();

                    int length;
                    int length2;
                    String[] arr1;
                    String[] arr2;
                    int indexOfHotel = -1;
                    boolean hotelIsPresent = false;
                    //------- booking
                    
                    for (int l = 0; l < hotelList.size(); l++){
                        if (hotelList.get(l).getName().equals(bookHotelName)){
                            hotelIsPresent = true;
                            indexOfHotel = l;
                            break;
                        }
                    }
                    if (hotelIsPresent){
                        System.out.println("Check in date dd/hh/mm (day/hour/minute): ");
                        String checkIn = scanner.nextLine();
                        arr1 = checkIn.split("/");
                        
                        System.out.println("Check out date dd/hh/mm (day/hour/minute): ");
                        String checkOut = scanner.nextLine();
                        arr2 = checkOut.split("/");
                        length = arr1.length;
                        length2 = arr2.length;
                    
                    
                        
                        
                        if (length != 3 || length2 != 3 || !(Integer.valueOf(arr1[0]) <= 30 && Integer.valueOf(arr1[0]) >= 1) 
                        || !(Integer.valueOf(arr2[0]) <= 31 && Integer.valueOf(arr2[0]) >= 2)){
                            System.out.println("Invalid booking");
                        }
                        else if (HRS.isBefore(checkIn, checkOut) == false){
                            System.out.println("invalid booking");
                        }
                        else {
                            System.out.println(hotelList.get(indexOfHotel).findRoom(checkIn, checkOut, guestName)); 
                        }
                    }
                    
                }
                else {
                    System.out.println("No hotels to book");
                }

            }

        
        } while (Integer.parseInt(menuInput) != 5);

        scanner.close();
    }

    // private boolean inBetween(int num, int lowerB, int upperB){
    //     if (num < upperB && num > lowerB){
    //         return true;
    //     }
    //     else {
    //         return false;
    //     }
    // }
    /*
     * return true if date1 is before date2
     */
    /**
     * finds if date 1 is before date 2
     * @param date1 first date
     * @param date2 second date
     * @return true or false 
     */
    private static boolean isBefore(String date1, String date2){
        String[] arr1;
        String[] arr2;
        arr1 = date1.split("/");
        arr2 = date2.split("/");
        if (Integer.parseInt(arr1[0]) < Integer.parseInt(arr2[0]))
            return true;
        if (Integer.parseInt(arr1[0]) == Integer.parseInt(arr2[0])){
            if (Integer.parseInt(arr1[1]) < Integer.parseInt(arr2[1])){
                return true;
            }
            if (Integer.parseInt(arr1[1]) == Integer.parseInt(arr2[1])){
                if (Integer.parseInt(arr1[2]) < Integer.parseInt(arr2[2])){
                    return true;
                }
            }
        }
        return false;
    }

    
}
