import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class ManageView {
    private JFrame ManageFrame;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JPanel panel;
    private JButton changeName, addRoom, removeRoom, updBP, rResrvation, rHotel;

    public ManageView(){
        this.ManageFrame = new JFrame("Manage Hotels");
        this.ManageFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.ManageFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.ManageFrame.setSize(250, 1000);

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


        this.ManageFrame.setVisible(true);
    }
    public void addButton(JButton button){
        buttons.add(button);
    }
    public void showButtons(){
        for (int i = 0; i < buttons.size(); i++){
            panel.add(buttons.get(i));
        }
        JScrollPane scroll = new JScrollPane(panel);
        scroll.setPreferredSize(new Dimension(225, 200));
        this.ManageFrame.add(scroll);

        this.ManageFrame.add(changeName);
        this.ManageFrame.add(addRoom);
        this.ManageFrame.add(removeRoom);
        this.ManageFrame.add(updBP);
        this.ManageFrame.add(rResrvation);
        this.ManageFrame.add(rHotel);
    }
}
