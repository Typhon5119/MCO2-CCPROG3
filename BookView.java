import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class BookView {
    JFrame Bookframe;
    ArrayList<JButton> hotelButtons = new ArrayList<>();
    JTextField guestName, checkInField, checkOuTextField;
    JLabel guestnamLabel, checkinLabel, checkoutLabel;
    public BookView(){
        Bookframe = new JFrame();
        this.Bookframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.Bookframe.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.Bookframe.setSize(250, 1000);

        this.checkInField = new JTextField();
        this.checkInField.setColumns(10);

        this.checkOuTextField = new JTextField();
        this.checkOuTextField.setColumns(10);

        this.guestName = new JTextField();
        this.guestName.setColumns(10);
        
        this.checkinLabel = new JLabel("Check in dd/hh/mm");
        this.checkoutLabel = new JLabel("Check out dd/hh/mm");

        this.guestnamLabel = new JLabel("Guest name");

        this.Bookframe.setVisible(true);
    }
    public String getGuestName(){
        return guestName.getText();
    }
    public String getCheckIn(){
        return checkInField.getText();
    }
    public String getCheckOut(){
        return checkOuTextField.getText();
    }
    public void addTextFields(){
        this.Bookframe.add(guestnamLabel);
        this.Bookframe.add(guestName);
        this.Bookframe.add(checkinLabel);
        this.Bookframe.add(checkInField);
        this.Bookframe.add(checkoutLabel);
        this.Bookframe.add(checkOuTextField);
    }
    public void adALtoButton(ActionListener actionListener, JButton button){
        button.addActionListener(actionListener);
    }
    public void addbutton(JButton button2add){
        hotelButtons.add(button2add);
    }
    public ArrayList<JButton> getButtons(){
        return hotelButtons;
    }
    public void showButtons(){
        for (int i = 0; i < hotelButtons.size(); i++){
            this.Bookframe.add(hotelButtons.get(i));
        }
    }
}
