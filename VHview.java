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
    // private HRSmodel hrSmodel;
    private JFrame viewFrame;
   
    private JTextArea viewArea;
    public VHview(){
        
        // this.hrSmodel = hrSmodel;
        this.viewFrame = new JFrame("Hotels");
        this.viewFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.viewFrame.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        
        this.viewArea = new JTextArea(30, 50);
        
        
        
        
        this.viewFrame.setSize(500, 600);
        
        

        
        
        
        viewArea.setWrapStyleWord(true);
        
        
        this.viewFrame.setVisible(true);
    }

    public void addComponent(String text){
        JScrollPane scrollPane = new JScrollPane(viewArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.viewArea.setText(text);
        this.viewFrame.add(scrollPane);
        this.viewArea.setEditable(false);
    }
    
}
