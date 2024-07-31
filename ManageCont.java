
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Controller for manage hotel feature
 */
public class ManageCont {
    HRSmodel model;
    ManageView view;
    /**
     * Constructor for the ManageCont
     * @param view the view object
     * @param model the model object
     */
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

                boolean isNameUnique = true;
                for (int k = 0; k < model.getHotellist().size(); k++){
                    if (model.getHotellist().get(k).getName().equals(view.getTextField().getText())){
                        isNameUnique = false;
                    }
                }
            //--
                if (isNameUnique){
                    model.getHotellist().get(markedIndex).setName(view.getTextField().getText());
                    view.getButtons().get(markedIndex).setText(view.getTextField().getText());
                } else {

                    view.getTextField().setText("Name is not unique");

                }
            }
        });

        view.addAL2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                int markedIndex = view.getMarked();
                int sAmount, dAmount, eAmount;
                sAmount = Integer.parseInt(view.getTextField().getText().substring(0, 2));
                dAmount = Integer.parseInt(view.getTextField().getText().substring(3, 5));
                eAmount = Integer.parseInt(view.getTextField().getText().substring(6, 8));

                for(int i = 0; i < sAmount; i++){

                    Room tempStandard = new Room();
                    model.getHotellist().get(markedIndex).addRoom(tempStandard);
                    tempStandard = null;

                }
                for (int i = 0; i < dAmount; i++){

                    Room tempDeluxe = new Deluxe();
                    model.getHotellist().get(markedIndex).addRoom(tempDeluxe);
                    tempDeluxe = null;

                }
                for (int i = 0; i < eAmount; i++){

                    Room tempExecutive = new Executive();
                    model.getHotellist().get(markedIndex).addRoom(tempExecutive);
                    tempExecutive = null;

                }

                model.getHotellist().get(markedIndex).setRoomsNameAuto();
                view.getTextField().setText("");
                
            }

        }, new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){

                if(view.getTextField().getText().equals("")){
                    view.getTextField().setText("SS/DD/EE");
                }

            }

            @Override
            public void mouseExited(MouseEvent e){

                if(view.getTextField().getText().equals("SS/DD/EE")){
                    view.getTextField().setText("");
                }
            }

        });

        view.addAL3(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                int markedIndex = view.getMarked();
                boolean hasReservation = false;

                for(int i = 0; i < model.getHotellist().get(markedIndex).getReservationList().size(); i++){

                    if (model.getHotellist().get(markedIndex).getReservationList().get(i).getRoom().getName().equals(model.getHotellist().get(markedIndex).getRooms().get(Integer.parseInt(view.getTextField().getText())).getName())){

                        hasReservation = true;

                    }

                }
                
                if(view.getTextField().getText().equals("")){

                    printRoomsGUI(markedIndex);

                } else if (!hasReservation){

                    model.getHotellist().get(markedIndex).getRooms().remove(Integer.parseInt(view.getTextField().getText()));

                } else {

                    view.getTextField().setText("Room chosen has a reservation");

                }

                model.getHotellist().get(markedIndex).setRoomsNameAuto();

            }

        });

        view.addAL4(new ActionListener(){
            @Override

            public void actionPerformed(ActionEvent e){

                int markedIndex = view.getMarked();
                
                if (Integer.parseInt(view.getTextField().getText()) >= 100){
                    model.getHotellist().get(markedIndex).setRoomsPrice(Integer.parseInt(view.getTextField().getText()));
                } else {
                    view.getTextField().setText("Price requirement not met");
                }
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
    /**
     * prints list of reservations for the chosen hotel
     * @param markedIndex index of chosen hotel
     */

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

    /**
     * prints list of rooms for the chosen hotel
     * @param markedIndex index of chosen hotel
     */    
    private void printRoomsGUI(int markedIndex){

        String info = "";

        for(int i = 0; i < model.getHotellist().get(markedIndex).getRooms().size(); i++){

            info += Integer.toString(i + 1) + ". ";
            info += model.getHotellist().get(markedIndex).getRooms().get(i).getName() + "\n";

        }

        view.setTfield(info);

    }


}
