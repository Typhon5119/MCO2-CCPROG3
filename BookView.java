import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * View for the booking feature
 */
public class BookView {
    private JFrame Bookframe;
    private ArrayList<JButton> hotelButtons = new ArrayList<>();
    private JButton s, d, e;
    private JTextField guestName, checkInField, checkOuTextField, pCodeField;
    private JLabel guestnamLabel, checkinLabel, checkoutLabel, pCodeLabel;
    private JPanel panel;
    public BookView(){
        Bookframe = new JFrame();
        this.Bookframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.Bookframe.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.Bookframe.setSize(250, 600);

        this.checkInField = new JTextField();
        this.checkInField.setColumns(10);
        s = new JButton("Standard"); 
        d = new JButton("Deluxe"); 
        e = new JButton("Executive");
        s.setPreferredSize(new Dimension(220, 30));
        s.setBackground(Color.GREEN);
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

        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.Bookframe.setVisible(true);
    }
    /**
     * getter for guest name
     * @return name of guest
     */
    public String getGuestName(){
        return guestName.getText();
    }
    /**
     * getter for check in
     * @return check in
     */
    public String getCheckIn(){
        return checkInField.getText();
    }
    /**
     * getter for check out
     * @return check out
     */
    public String getCheckOut(){
        return checkOuTextField.getText();
    }
    /**
     * getter for promo code
     * @return promo code
     */
    public String getPCode(){
        return pCodeField.getText();
    }
    /**
     * function to add the text fields
     */
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
    /**
     * adds action listener to button
     * @param actionListener the action listener
     * @param button the button
     */
    public void adALtoButton(ActionListener actionListener, JButton button){
        button.addActionListener(actionListener);
    }
    /**
     * adds button
     * @param button2add button to be added
     */
    public void addbutton(JButton button2add){
        hotelButtons.add(button2add);
    }
    /**
     * getter
     * @return the standard room button
     */
    public JButton getS(){
        return this.s;
    }
    /**
     * getter
     * @return the deluxe room button
     */
    public JButton getD(){
        return this.d;
    }
    /**
     * getter
     * @return the executive room button
     */
    public JButton getE(){
        return this.e;
    }
    /**
     * getter
     * @return the arraylist of buttons
     */
    public ArrayList<JButton> getButtons(){
        return hotelButtons;
    }
    /**
     * shows buttons
     */
    public void showButtons(){
        for (int i = 0; i < hotelButtons.size(); i++){
            this.panel.add(hotelButtons.get(i));
        }
        JScrollPane scroll = new JScrollPane(panel);
        scroll.setPreferredSize(new Dimension(225, 200));
        this.Bookframe.add(scroll);
    }
    /**
     * changes standard button color to green
     */
    public void markS(){
        this.s.setBackground(Color.GREEN);
    }
    /**
     * changes deluxe button color to green
     */
    public void markD(){
        this.d.setBackground(Color.GREEN);
    }
    /**
     * changes executive button color to green
     */
    public void markE(){
        this.e.setBackground(Color.GREEN);
    }
    /**
     * changes back standard button
     */
    public void unMkS(){
        this.s.setBackground(new JButton().getBackground());
    }
    /**
     * changes back deluxe button
     */
    public void unMkD(){
        this.d.setBackground(new JButton().getBackground());
    }
    /**
     * changes back executive button
     */
    public void unMkE(){
        this.e.setBackground(new JButton().getBackground());
    }
}
