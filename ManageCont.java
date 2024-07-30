
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;


public class ManageCont {
    HRSmodel model;
    ManageView view;
    public ManageCont(ManageView view, HRSmodel model){
        this.view = view;
        this.model = model;
        for (int i = 0; i < model.getHotellist().size(); i++){
            view.addButton( new JButton(model.getHotellist().get(i).getName()));
        }

        view.addAL2buttons(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                view.unmarkAll();
                view.mark( (JButton)  e.getSource());
            }
        });

        view.addAL1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int markedIndex = view.getMarked();

                model.getHotellist().get(markedIndex).setName(view.getTextField().getText());
                view.getButtons().get(markedIndex).setText(view.getTextField().getText());
            }
        });

        view.addAL2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                int markedIndex = view.getMarked();
                Room tempRoom = new Room(view.getTextField().getText());

                model.getHotellist().get(markedIndex).addRoom(tempRoom);

                if(view.getTextField().getText().equals("")){

                    model.getHotellist().get(markedIndex).setRoomsNameAuto();

                }
                
            }

        });

        view.addAL3(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                int markedIndex = view.getMarked();
                
                if(view.getTextField().getText().equals("")){

                    printRoomsGUI(markedIndex);

                } else {

                    model.getHotellist().get(markedIndex).getRooms().get(Integer.parseInt(view.getTextField().getText()));

                }

            }

        });

        view.addAL4(new ActionListener(){
            @Override

            public void actionPerformed(ActionEvent e){

                int markedIndex = view.getMarked();

                model.getHotellist().get(markedIndex).setRoomsPrice(Integer.parseInt(view.getTextField().getText()));
            }

        });

        view.addAL5(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                int markedIndex = view.getMarked();

                if (view.getTextField().getText().equals("")){
                    printRoomReservationsGUI(markedIndex);
                } else {
                    model.getHotellist().get(markedIndex).getReservationList().remove(Integer.parseInt(view.getTextField().getText()));
                }
            }

        });

        view.addAL6(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                int markedIndex = view.getMarked();

                model.getHotellist().remove(markedIndex);

            }

        });


        view.showButtons();
    }

    private void printRoomReservationsGUI(int markedIndex){
            String info = "";
            for (int i = 0, j = 1; i < model.getHotellist().get(markedIndex).getReservationList().size(); i++){
                info += Integer.toString(i + 1) + ". ";
                info +=  model.getHotellist().get(markedIndex).getReservationList().get(i).getGuestName() + ":" + "\n";
                info += "Room name: " +  model.getHotellist().get(markedIndex).getReservationList().get(i).getRoom().getName() + "\n";
                info += model.getHotellist().get(markedIndex).getReservationList().get(i).getCheckIn() + "-";
                info += model.getHotellist().get(markedIndex).getReservationList().get(i).getCheckOut() + "\n";
    
            }
    
            view.setTfield(info);
    
            
        }

    private void printRoomReservationsGUI(int markedIndex, String key){

        for (int i = 0, j = 1; i < model.getHotellist().get(markedIndex).getReservationList().size(); i++){

            JLabel info = new JLabel(model.getHotellist().get(markedIndex).printRoomReservations(i));

        }

    }

    private void printRoomsGUI(int markedIndex){

        String info = "";

        for(int i = 0; i < model.getHotellist().get(markedIndex).getRooms().size(); i++){

            info += Integer.toString(i) + ". ";
            info += model.getHotellist().get(markedIndex).getRooms().get(i).getName() + "\n";

        }

        view.setTfield(info);

    }


}
