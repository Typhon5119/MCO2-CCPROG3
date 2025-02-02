import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * View for HRS window
 */
public class HRSview {
    private JFrame mainFrame;
    private JButton addHotel, viewHotel, viewHotelAd, viewHad2;
    private JButton ManageHotel, Book, DPadj;
    private JLabel title, s_or_f, HnameLabel, nRoomsLabel, nDRoomsLabel, nERoomsLabel;
    private JTextField HName, nRooms, guestName, nDRoomsTextF, nERoomsTextF;
    /**
     * Constructor for HRSview
     */
    public HRSview(){
        this.mainFrame = new JFrame("HRS");

        this.nDRoomsLabel = new JLabel("Deluxe Rooms");
        this.nERoomsLabel = new JLabel("Executive Rooms");

        this.viewHad2 = new JButton("Available Rooms (Based on date)");
        this.viewHad2.setPreferredSize(new Dimension(220, 30));

        this.nDRoomsTextF = new JTextField();
        this.nDRoomsTextF.setColumns(5);

        this.nERoomsTextF = new JTextField();
        this.nERoomsTextF.setColumns(5);

		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.mainFrame.setSize(250, 1000);
        this.title = new JLabel();
        this.title.setText("Hotel Reservation System");

        this.HnameLabel = new JLabel("Hotel Name");

        this.HName = new JTextField();
        this.HName.setColumns(10);

        this.nRoomsLabel = new JLabel("Standard rooms");
        this.nRooms = new JTextField();
        this.nRooms.setColumns(5);

        this.title.setPreferredSize(new Dimension(220, 30));
        this.addHotel = new JButton("Create Hotel");
        this.addHotel.setPreferredSize(new Dimension(220, 30));

        this.s_or_f = new JLabel();
        this.s_or_f.setPreferredSize(new Dimension(220, 30));
        

        this.viewHotel = new JButton("View hotel");
        this.viewHotel.setPreferredSize(new Dimension(220, 30));

        this.viewHotelAd = new JButton("View hotel (Advanced)");
        this.viewHotelAd.setPreferredSize(new Dimension(220, 30));

        this.ManageHotel = new JButton("Manage hotel");
        this.ManageHotel.setPreferredSize(new Dimension(220, 30));

        this.Book = new JButton("Book");
        this.Book.setPreferredSize(new Dimension(220, 30));

        this.guestName = new JTextField();
        this.guestName.setColumns(10);
        
        this.DPadj = new JButton("Date Price Modifier");
        this.DPadj.setPreferredSize(new Dimension(220, 30));

        // this.mainFrame.add(title);
        
        this.mainFrame.setVisible(true);
    }
    /**
     * adds components to the frame
     */
    public void addComponents(){
        this.mainFrame.add(HnameLabel);
        this.mainFrame.add(HName);
        this.mainFrame.add(nRoomsLabel);
        this.mainFrame.add(nRooms);
        this.mainFrame.add(nDRoomsLabel);
        this.mainFrame.add(nDRoomsTextF);
        this.mainFrame.add(nERoomsLabel);
        this.mainFrame.add(nERoomsTextF);
        this.mainFrame.add(addHotel);
        this.mainFrame.add(s_or_f);
        this.mainFrame.add(viewHotel);
        this.mainFrame.add(viewHotelAd);
        this.mainFrame.add(viewHad2);
        this.mainFrame.add(ManageHotel);
        this.mainFrame.add(Book);
        this.mainFrame.add(DPadj);
    }
    /**
     * setter for label if hotel creation is successful or not
     * @param text text that will be set to s_or_f
     */
    public void setsorf(String text){
        this.s_or_f.setText(text);
    }

    /**
     * gets the hotel name
     * @return hotel name
     */
    public String getHNameText(){
        return this.HName.getText();
    }
    /**
     * gets the number of standard rooms
     * @return number of standard rooms
     */
    public String getnRooms(){
        return this.nRooms.getText();
    }
    /**
     * gets the number of deluxe rooms
     * @return number of deluxe rooms
     */
    public String getnDrooms(){
        return this.nDRoomsTextF.getText();
    }
    /**
     * gets the number of executive rooms
     * @return number of executive rooms
     */
    public String getnErooms(){
        return this.nERoomsTextF.getText();
    }
    /**
     * adds actions listener to View Hotel Advanced button
     * @param actionListener the action listener
     */
    public void setactionListenerAd(ActionListener actionListener){
        this.viewHotelAd.addActionListener(actionListener);
    }
    /**
     * adds actions listener to Add Hotel button
     * @param actionListener the action listener
     */
    public void setactionListener1(ActionListener actionListener){
        this.addHotel.addActionListener(actionListener);
    }
    /**
     * adds actions listener to View Hotel button
     * @param actionListener the action listener
     */
    public void setactionListener2(ActionListener actionListener){
        this.viewHotel.addActionListener(actionListener);
    }
    /**
     * adds actions listener to Manage Hotel button
     * @param actionListener the action listener
     */
    public void setactionListener3(ActionListener actionListener){
        this.ManageHotel.addActionListener(actionListener);
    }
    /**
     * adds actions listener to Booking button
     * @param actionListener the action listener
     */
    public void setactionListener4(ActionListener actionListener){
        this.Book.addActionListener(actionListener);
    }
    /**
     * adds actions listener to date price modifier button
     * @param actionListener the action listener
     */
    public void setactionListener5(ActionListener actionListener){
        this.DPadj.addActionListener(actionListener);
    }
    /**
     * adds actions listener to View Hotel Advanced 2 button
     * @param a the action listener
     */
    public void setALvHad2(ActionListener a){
        this.viewHad2.addActionListener(a);
    }

}
