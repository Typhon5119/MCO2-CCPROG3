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
public class VHview {
    private HRSmodel hrSmodel;
    private JFrame viewFrame;
    private ArrayList<JButton> buttons = new ArrayList<>();
   
    private JTextArea viewArea;
    public VHview(HRSmodel hrSmodel){
        
        this.hrSmodel = hrSmodel;
        this.viewFrame = new JFrame("Hotels");
        this.viewFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.viewFrame.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        
        this.viewArea = new JTextArea(30, 50);
        
        // this.viewArea.setMinimumSize(new Dimension(500, 500));
        String text = "";
        for (int i = 0; i < hrSmodel.getHotellist().size(); i++){
            text += hrSmodel.getHotellist().get(i).displayHotel();
        }
        JScrollPane scrollPane = new JScrollPane(viewArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        viewArea.setText(text);
        
        this.viewFrame.setSize(500, 600);
        
        this.viewArea.setEditable(false);

        
        
        
        viewArea.setWrapStyleWord(true);
        this.viewFrame.add(scrollPane);
        
        this.viewFrame.setVisible(true);
    }
    
}
