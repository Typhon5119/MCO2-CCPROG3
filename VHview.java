import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * View component for the View Hotel window
 */
public class VHview {
    // private HRSmodel hrSmodel;
    private JFrame viewFrame;
   
    private JTextArea viewArea;
    /**
     * Constructor
     */
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
    /**
     * Adds components of the frame
     * @param text text to be added onto the text area
     */
    public void addComponent(String text){
        JScrollPane scrollPane = new JScrollPane(viewArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.viewArea.setText(text);
        this.viewFrame.add(scrollPane);
        this.viewArea.setEditable(false);
    }
    
}
