
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
                
                for (int i = 0; i < model.getHotellist().get(markedIndex).getRooms().size(); i++){

                    if((model.getHotellist().get(markedIndex).getRooms().get(i).getName().equals(view.getTextField().getText()))){

                        model.getHotellist().get(markedIndex).getRooms().remove(i);

                    }

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

        for (int i = 0, j = 1; i < model.getHotellist().get(markedIndex).getReservationList().size(); i++){

            JLabel info = new JLabel(model.getHotellist().get(markedIndex).printRoomReservations(i));
            view.getMainFrame().add(info);

        }

    }

    private void printRoomReservationsGUI(int markedIndex, String key){

        for (int i = 0, j = 1; i < model.getHotellist().get(markedIndex).getReservationList().size(); i++){

            JLabel info = new JLabel(model.getHotellist().get(markedIndex).printRoomReservations(i));

        }

    }
}
