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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * 
 * View for the feature of the hotel that checks for available rooms at a given date
 */
public class AvailRoomsView {
    private JFrame aFrame;
    private ArrayList<JButton> hotelButtons = new ArrayList<>();
    private JTextArea textArea;
    private JTextField textField;
    private JLabel date;
    private JPanel panel;
    private JScrollPane scroll;
    /**
     * constructor for AvailRoomsView
     */
    public AvailRoomsView(){
        aFrame = new JFrame();
        this.aFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.aFrame.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.aFrame.setSize(250, 600);
        this.textArea = new JTextArea(15, 25);
        this.date = new JLabel("Date to check");
        this.textField = new JTextField();
        this.textField.setColumns(10);
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.aFrame.setVisible(true);
    }

    /**
     * adds action listener to a button
     * @param a the action listener
     * @param button the button
     */
    public void addAl2button(ActionListener a, JButton button){
        button.addActionListener(a);
    }
    /**
     * adds a button
     * @param button
     */
    public void adHotelButton(JButton button){
        hotelButtons.add(button);
    }

    /**
     * makes the buttons visible
     */
    public void showButtons(){
        this.aFrame.add(date);
        this.aFrame.add(textField);
        this.aFrame.add(textArea);
        for (int i = 0; i < hotelButtons.size(); i++){
            this.panel.add(hotelButtons.get(i));
        }
        this.scroll = new JScrollPane(panel);
        scroll.setPreferredSize(new Dimension(225, 200));
        this.aFrame.add(scroll);

    }
    /**
     * gets date from the text field
     * @return date
     */
    public String getDate(){
        return this.textField.getText();
    }
    /**
     * sets the text of the text area
     * @param info text to be set
     */
    public void setTextArea(String info){
        this.textArea.setText(info);
    }

}
