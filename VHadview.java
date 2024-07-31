import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * View component for the view hotel advanced feature
 */
public class VHadview {
    
    private JFrame adViewFrame;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JTextArea textArea;
    private JScrollPane scroll, scroll2;
    private JPanel panel;
    /**
     * Constructor
     */
    public VHadview(){
        
        adViewFrame = new JFrame();
        this.adViewFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.adViewFrame.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.adViewFrame.setSize(465, 700);

        this.textArea = new JTextArea(20, 48);
        this.scroll = new JScrollPane(textArea);
        
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // this.panel.setPreferredSize(new Dimension(350, 200));

        
        
        this.adViewFrame.setVisible(true);
    }
    /**
     * Adds actions listener to a butotn
     * @param a the action listener
     * @param button the button
     */
    public void adALtoButton(ActionListener a, JButton button){
        button.addActionListener(a);
    }
    /**
     * 
     * adds button
     * @param button2add the button
     */
    public void addbutton(JButton button2add){
        buttons.add(button2add);
    }
    /**
     * assembles the frame
     */
    public void showButtons(){
        for (int i = 0; i < buttons.size(); i++){
            this.panel.add(buttons.get(i));
        }
        this.scroll2 = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll2.setPreferredSize(new Dimension(435, 200));
        this.adViewFrame.add(scroll2);
    }
    /**
     * adds the text area
     */
    public void addTextArea(){
        this.adViewFrame.add(scroll);
    }
    /**
     * sets the text area
     * @param text text to be set
     */
    public void setTextArea(String text){
        this.textArea.setText(text);
    }
}
