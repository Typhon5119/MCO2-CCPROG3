import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * View component of the manage hotel feature
 */
public class ManageView {
    private JFrame ManageFrame;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JPanel panel;
    private JButton changeName, addRoom, removeRoom, updBP, rResrvation, rHotel;
    private JTextField newName;
    private JTextArea textArea= new JTextArea();
    

    /**
     * Constructor
     */
    public ManageView(){
        this.ManageFrame = new JFrame("Manage Hotels");
        this.ManageFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.ManageFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.ManageFrame.setSize(250, 1000);

        this.newName = new JTextField();
        this.newName.setColumns(10);

        this.changeName = new JButton("Change name");
        this.changeName.setPreferredSize(new Dimension(220, 30));

        this.addRoom = new JButton("Add room");
        this.addRoom.setPreferredSize(new Dimension(220, 30));

        this.removeRoom = new JButton("Remove room");
        this.removeRoom.setPreferredSize(new Dimension(220, 30));

        this.updBP = new JButton("Update Base Price");
        this.updBP.setPreferredSize(new Dimension(220, 30));

        this.rResrvation = new JButton("Remove reservation");
        this.rResrvation.setPreferredSize(new Dimension(220, 30));


        this.rHotel = new JButton("Remove hotel");
        this.rHotel.setPreferredSize(new Dimension(220, 30));

        
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.textArea = new JTextArea(10, 25);


        this.ManageFrame.setVisible(true);
    }
    /**
     * adds buttons
     * @param button button to be added
     */
    public void addButton(JButton button){
        buttons.add(button);
    }
    public void showButtons(){
        for (int i = 0; i < buttons.size(); i++){
            panel.add(buttons.get(i));
        }
        JScrollPane scroll = new JScrollPane(panel);
        scroll.setPreferredSize(new Dimension(225, 200));

        JScrollPane scroll2 = new JScrollPane(textArea);
        
        this.ManageFrame.add(scroll);
        this.ManageFrame.add(newName);
        this.ManageFrame.add(changeName);
        this.ManageFrame.add(addRoom);
        this.ManageFrame.add(removeRoom);
        this.ManageFrame.add(updBP);
        this.ManageFrame.add(rResrvation);
        this.ManageFrame.add(rHotel);
        this.ManageFrame.add(scroll2);
    }
    /**
     * marks the button
     * @param button button to be marked
     */
    public void mark(JButton button){
        button.setBackground(Color.GREEN);
    }

    /**
     * unmarks all buttons
     */
    public void unmarkAll(){
        for (int i = 0; i < buttons.size(); i++){
            buttons.get(i).setBackground(new JButton().getBackground());
        }
    }

    /**
     * gets the button that is marked
     * @return the index of the button that is marked
     */
    public int getMarked(){
        for (int i = 0; i < buttons.size(); i++){
            if (buttons.get(i).getBackground() == Color.GREEN){
                return i;
            }
        }
        return -1;
    }
    /**
     * adds action listeners to the hotel buttons
     * @param a the action listener
     */

    public void addAL2buttons(ActionListener a){
        for (int i = 0; i < buttons.size(); i++){
            buttons.get(i).addActionListener(a);
        }
    }
    /**
     * adds action listener to the change name button
     * @param a the action listener
     */

    public void addAL1(ActionListener a){
        this.changeName.addActionListener(a);
    }

    /**
     * adds action listener to the add room button
     * @param a the action listener
     * @param l the mouse adapter 
     */
    public void addAL2(ActionListener a, MouseAdapter l){
        this.addRoom.addActionListener(a);
        this.addRoom.addMouseListener(l);
    }

    /**
     * adds action listener to the remove room button
     * @param a the action listener
     */
    public void addAL3(ActionListener a){
        this.removeRoom.addActionListener(a);
    }

    /**
     * adds action listener to the update base price button
     * @param a the action listener
     */
    public void addAL4(ActionListener a){
        this.updBP.addActionListener(a);
    }

    /**
     * adds action listener to the remove reservation button
     * @param a the action listener
     */
    public void addAL5(ActionListener a){
        this.rResrvation.addActionListener(a);
    }

    /**
     * adds action listener to the remove hotel button
     * @param a the action listener
     */
    public void addAL6(ActionListener a){
        this.rHotel.addActionListener(a);
    }
    /**
     * getter for text field
     * @return text field
     */
    public JTextField getTextField(){

        return this.newName;

    }

    /**
     * getter for buttons
     * @return buttons
     */
    public ArrayList<JButton> getButtons(){

        return this.buttons;

    }

    /**
     * setter for text area
     * @param info text to be set
     */
    public void setTfield(String info){
        this.textArea.setText(info);
    }

   
}
