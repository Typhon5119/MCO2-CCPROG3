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
 * View component of the date price modifier feature
 */
public class DPAchoose {
    private JFrame DPAframe;
    private JLabel day, percentage, failed2ad;
    private JTextField dayTextField, percentTextField;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JTextArea textArea = new JTextArea(20, 20);
    private JScrollPane scrollPane;
    private JPanel panel;
    /**
     * Constructor
     */
    public DPAchoose(){
        this.DPAframe = new JFrame();
        this.DPAframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.DPAframe.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.day = new JLabel();
        this.day.setText("day             ");
        // this.day.setPreferredSize(new Dimension(500, 500));
        // this.textArea.setPreferredSize(new Dimension(220, 140));
        this.textArea.setEditable(false);
        this.failed2ad = new JLabel();
        this.failed2ad.setVisible(false);

        this.dayTextField = new JTextField();
        this.dayTextField.setColumns(10);
        this.percentage = new JLabel("price rate   ");
        this.percentTextField = new JTextField();
        this.percentTextField.setColumns(10);
        this.scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.DPAframe.setSize(250, 1000);
        this.DPAframe.setVisible(true);
    }
    /**
     * Adds components of the frame
     */
    public void addComponents(){
        this.DPAframe.add(day);
        this.DPAframe.add(dayTextField);
        this.DPAframe.add(percentage);
        this.DPAframe.add(percentTextField);
        this.DPAframe.add(failed2ad);
        this.DPAframe.add(scrollPane);
        
    }
    /**
     * updates the text area
     * @param info the text to be updated into
     */
    public void updateTextArea(String info){
        this.textArea.setText(info);
    }
    /**
     * function for invalid input
     */
    public void failed(){
        this.failed2ad.setText("Invalid input");
        this.failed2ad.setVisible(true);
    }
    /**
     * gets the days
     * @return day from the day text field
     */
    public String getDay(){
        return this.dayTextField.getText();
    }
    /**
     * getter for the percent text field
     * @return the user input for the rate
     */
    public String getPercent(){
        return this.percentTextField.getText();
    }
    /**
     * adds buttons
     * @param addButton the button to be added
     */
    public void addButton(JButton addButton){
        buttons.add(addButton);
    }
    /**
     * getter for the hotel name
     * @param button the hotel button
     * @return the hotel name
     */
    public String getHname(JButton button){
        return button.getText();
    }
        
    /**
     * adds action listenders to the buttons
     * @param a action listener for the button
     */
    public void addAL(ActionListener a){
        for (int i = 0; i < buttons.size(); i++){
            buttons.get(i).addActionListener(a);
        }
    }
    /**
     * adds the components to the frame
     */
    public void showButtons(){
        for (int i = 0; i < buttons.size(); i++){
            this.panel.add(buttons.get(i));
            
        }
        JScrollPane scroll = new JScrollPane(panel);
        scroll.setPreferredSize(new Dimension(225, 200));
        this.DPAframe.add(scroll);
    }
    /**
     * closes the frame
     */
    public void closeframe(){
        this.DPAframe.dispose();
    }
    // public void unmarkAll(){
    //     for (int i = 0; i < buttons.size(); i++){
    //         this.buttons.get(i).setBackground(new JButton().getBackground());
    //     }
    // }
    // public void mark(JButton button){
    //     button.setBackground(Color.green);
    // }
}
