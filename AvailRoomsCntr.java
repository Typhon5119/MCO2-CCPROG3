import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AvailRoomsCntr {
    private AvailRoomsView view;
    private HRSmodel model;
    public AvailRoomsCntr(AvailRoomsView view, HRSmodel model){
        for (int i = 0; i < model.getHotellist().size(); i++){
            JButton temp = new JButton(model.getHotellist().get(i).getName());
            final int j = i;
            view.addAl2button(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    String date = view.getDate();
                    String info = "";
                    if (isValidDate(date)){
                        info += model.getHotellist().get(j).getAvailableRooms(date) + " Room/s Available" + "\n";
                        info += model.getHotellist().get(j).getBookedRooms(date) + " Room/s Booked" + "\n";
                        
                    }
                    else{
                        info += "Invalid input date";

                    }
                    view.setTextArea(info);
                }
            }, temp);
            view.adHotelButton(temp);
        }
        view.showButtons();

    }
    private boolean isValidDate(String date){
        String[] arr = date.split("/");
        try{
            if ((Integer.parseInt(arr[0]) > 0 && Integer.parseInt(arr[0]) <= 31) && 
                (Integer.parseInt(arr[1]) >= 0 && Integer.parseInt(arr[1]) <= 60) &&
                (Integer.parseInt(arr[2]) >= 0 && Integer.parseInt(arr[2]) <= 60)){
                    return true;
                }
            else{
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }
}
