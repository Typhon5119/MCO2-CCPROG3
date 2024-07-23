import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;

public class VHadController {
    VHadview vHadview;
    HRSmodel hrSmodel;
    public VHadController(VHadview vHadview, HRSmodel hrSmodel){
        this.vHadview = vHadview;
        this.hrSmodel = hrSmodel;
        
        for (int i = 0; i < hrSmodel.getHotellist().size(); i++){
            JButton temp = new JButton(hrSmodel.getHotellist().get(i).getName());
            final int j = i;
            vHadview.adALtoButton(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    
                    String info = "";
                    for (int k = 0; k <  hrSmodel.getHotellist().get(j).getReservationList().size(); k++){
                        String formattedD = String.format("%.2f", hrSmodel.getHotellist().get(j).getReservationList().get(k).getTotalCost());
                        info +=  hrSmodel.getHotellist().get(j).getReservationList().get(k).getGuestName() + ":" + "\n";
                        info += "Room name: " +  hrSmodel.getHotellist().get(j).getReservationList().get(k).getRoom().getName() + "\n";
                        info += "Check in date: " +  hrSmodel.getHotellist().get(j).getReservationList().get(k).getCheckIn() + "\n";
                        info += "Check out date: " +  hrSmodel.getHotellist().get(j).getReservationList().get(k).getCheckOut() + "\n";
                        info += "Cost per night: " +  hrSmodel.getHotellist().get(j).getReservationList().get(k).getCostPerNight() + "\n";
                        info += "Total Cost: " +  formattedD + "\n\n";
                    }
                    for (int m = 0; m < hrSmodel.getHotellist().get(j).getRooms().size(); m++){
                        System.out.println(hrSmodel.getHotellist().get(j).getRooms().get(m).getName());
                        System.out.println("Price per night: " + hrSmodel.getHotellist().get(j).getRooms().get(m).getBasePrice());
                        System.out.println("Reserved on: ");
                        hrSmodel.getHotellist().get(j).printRoomReservations(m);
                    }
                    if (hrSmodel.getHotellist().get(j).getReservationList().size() == 0){
                        info += "no reservations";
                    }
                    vHadview.setTextArea(info);
                }
            }, temp);
            vHadview.addbutton(temp);
        }
        
        vHadview.addTextArea();
        vHadview.showButtons();
    }
}
