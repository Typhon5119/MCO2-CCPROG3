import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class VHadview {
    
    private JFrame adViewFrame;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JTextArea textArea;
    public VHadview(){
        
        adViewFrame = new JFrame();
        this.adViewFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.adViewFrame.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.adViewFrame.setSize(700, 700);

        this.textArea = new JTextArea(30, 50);

        
        // this.adViewFrame.add(textArea);
        // for (int i = 0; i < buttons.size(); i++){
        //     this.adViewFrame.add(buttons.get(i));
        // }
        this.adViewFrame.setVisible(true);
    }

    
    public void addbutton(JButton button2add){
        buttons.add(button2add);
    }
    public void showButtons(){
        for (int i = 0; i < buttons.size(); i++){
            this.adViewFrame.add(buttons.get(i));
        }
    }
    public void addTextArea(){
        this.adViewFrame.add(textArea);
    }
}
