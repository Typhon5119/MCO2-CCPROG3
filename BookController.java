import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BookController {
    private BookView bv;
    private HRSmodel hrSmodel;
    private int selectedRoomType = 0;
    public BookController(BookView bv, HRSmodel hv){
        this.bv = bv;
        this.hrSmodel = hv;
        
        bv.addTextFields();
        
        

        for (int i = 0; i < hrSmodel.getHotellist().size(); i++){
            bv.addbutton(new JButton(hrSmodel.getHotellist().get(i).getName()));
            
        }
        for (int i = 0; i < hrSmodel.getHotellist().size(); i++){
            final int j = i;
            bv.adALtoButton(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    if (hrSmodel.getHotellist().size() != 0){
                       
                        String guestName = bv.getGuestName();
                        String bookHotelName = hrSmodel.getHotellist().get(j).getName();
                        String pCode = bv.getPCode();
    
                        int length;
                        int length2;
                        String[] arr1;
                        String[] arr2;
                        int indexOfHotel = -1;
                        boolean hotelIsPresent = false;
                        //------- booking
                        
                        for (int l = 0; l < hrSmodel.getHotellist().size(); l++){
                            if (hrSmodel.getHotellist().get(l).getName().equals(bookHotelName)){
                                hotelIsPresent = true;
                                indexOfHotel = l;
                                break;
                            }
                        }
                        if (hotelIsPresent){
                            
                            String checkIn = bv.getCheckIn();
                            arr1 = checkIn.split("/");
                            
                            
                            String checkOut = bv.getCheckOut();
                            arr2 = checkOut.split("/");
                            length = arr1.length;
                            length2 = arr2.length;
                        
                        
                            
                            
                            if (length != 3 || length2 != 3 || !(Integer.valueOf(arr1[0]) <= 30 && Integer.valueOf(arr1[0]) >= 1) 
                            || !(Integer.valueOf(arr2[0]) <= 31 && Integer.valueOf(arr2[0]) >= 2)){
                                System.out.println("Invalid booking");
                            }
                            else if (BookController.isBefore(checkIn, checkOut) == false){
                                System.out.println("invalid booking");
                            }
                            else {
                                System.out.println(hrSmodel.getHotellist().get(indexOfHotel).findRoom(checkIn, checkOut, guestName, pCode));

                            }
                        }
                        
                    }
                    else {
                        System.out.println("No hotels to book");
                    }
                    
                }
            }, bv.getButtons().get(i));
        }
        
        bv.showButtons();

        // for (int i = 0; i < hrSmodel.getHotellist().size(); i++){
        //     JButton temp = new JButton(hrSmodel.getHotellist().get(i).getName());
        //     final int j = i; 
        //     bv.adALtoButton(new ActionListener() {
                
        //     }, temp);
        //     bv.addbutton(temp);
        // }
    }
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
