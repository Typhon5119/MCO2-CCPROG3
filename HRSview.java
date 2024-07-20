import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HRSview {
    private JFrame mainFrame;
    private JButton addHotel, viewHotel, viewHotelAd;
    private JButton ManageHotel, Book;
    private JLabel title, s_or_f;
    private JTextField HName, nRooms;
    public HRSview(){
        this.mainFrame = new JFrame("My Simple GUI");

		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.mainFrame.setSize(250, 1000);
        this.title = new JLabel();
        this.title.setText("Hotel Reservation System");

        this.HName = new JTextField();
        this.HName.setColumns(10);
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
        

        // this.mainFrame.add(title);
        this.mainFrame.add(HName);
        this.mainFrame.add(nRooms);
        this.mainFrame.add(addHotel);
        this.mainFrame.add(s_or_f);
        this.mainFrame.add(viewHotel);
        this.mainFrame.add(viewHotelAd);
        this.mainFrame.add(ManageHotel);
        this.mainFrame.add(Book);
        this.mainFrame.setVisible(true);
    }
    public void setsorf(String text){
        this.s_or_f.setText(text);
    }
    public String getHNameText(){
        return this.HName.getText();
    }
    public String getnRooms(){
        return this.nRooms.getText();
    }
    public void setactionListenerAd(ActionListener actionListener){
        this.viewHotelAd.addActionListener(actionListener);
    }
    public void setactionListener1(ActionListener actionListener){
        this.addHotel.addActionListener(actionListener);
    }
    public void setactionListener2(ActionListener actionListener){
        this.viewHotel.addActionListener(actionListener);
    }
    public void setactionListener3(ActionListener actionListener){
        this.ManageHotel.addActionListener(actionListener);
    }
    public void setactionListener4(ActionListener actionListener){
        this.Book.addActionListener(actionListener);
    }
}
