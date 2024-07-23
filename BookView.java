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
    private JFrame Bookframe;
    private ArrayList<JButton> hotelButtons = new ArrayList<>();
    private JButton s, d, e;
    private JTextField guestName, checkInField, checkOuTextField, pCodeField;
    private JLabel guestnamLabel, checkinLabel, checkoutLabel, pCodeLabel;
    public BookView(){
        Bookframe = new JFrame();
        this.Bookframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.Bookframe.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.Bookframe.setSize(250, 1000);

        this.checkInField = new JTextField();
        this.checkInField.setColumns(10);
        s = new JButton("Standard"); 
        d = new JButton("Deluxe"); 
        e = new JButton("Executive");
        s.setPreferredSize(new Dimension(220, 30));
        d.setPreferredSize(new Dimension(220, 30));
        e.setPreferredSize(new Dimension(220, 30));
        
        this.checkOuTextField = new JTextField();
        this.checkOuTextField.setColumns(10);

        this.guestName = new JTextField();
        this.guestName.setColumns(10);
        
        this.checkinLabel = new JLabel("Check in dd/hh/mm");
        this.checkoutLabel = new JLabel("Check out dd/hh/mm");

        this.guestnamLabel = new JLabel("Guest name");

        this.pCodeLabel = new JLabel("Promo Code");

        this.pCodeField = new JTextField();
        this.pCodeField.setColumns(10);

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
    public String getPCode(){
        return pCodeField.getText();
    }
    public void addTextFields(){
        this.Bookframe.add(guestnamLabel);
        this.Bookframe.add(guestName);
        this.Bookframe.add(checkinLabel);
        this.Bookframe.add(checkInField);
        this.Bookframe.add(checkoutLabel);
        this.Bookframe.add(checkOuTextField);
        this.Bookframe.add(pCodeLabel);
        this.Bookframe.add(pCodeField);
        this.Bookframe.add(s);
        this.Bookframe.add(d);
        this.Bookframe.add(e);
    }
    public void adALtoButton(ActionListener actionListener, JButton button){
        button.addActionListener(actionListener);
    }
    public void addbutton(JButton button2add){
        hotelButtons.add(button2add);
    }
    public JButton getS(){
        return this.s;
    }
    public JButton getD(){
        return this.d;
    }
    public JButton getE(){
        return this.e;
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
