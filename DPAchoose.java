import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class DPAchoose {
    JFrame DPAframe;
    JLabel day, percentage;
    JTextField dayTextField, percentTextField;
    ArrayList<JButton> buttons = new ArrayList<>();
    public DPAchoose(){
        this.DPAframe = new JFrame();
        this.DPAframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.DPAframe.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.day = new JLabel();
        this.day.setText("day             ");
        // this.day.setPreferredSize(new Dimension(500, 500));
        
        this.dayTextField = new JTextField();
        this.dayTextField.setColumns(10);
        this.percentage = new JLabel("price rate   ");
        this.percentTextField = new JTextField();
        this.percentTextField.setColumns(10);

		this.DPAframe.setSize(250, 1000);
        this.DPAframe.setVisible(true);
    }
    public void addComponents(){
        this.DPAframe.add(day);
        this.DPAframe.add(dayTextField);
        this.DPAframe.add(percentage);
        this.DPAframe.add(percentTextField);
    }
    public String getDay(){
        return this.day.getText();
    }
    public String getPercent(){
        return this.percentage.getText();
    }
    public void addButton(JButton addButton){
        buttons.add(addButton);
    }
    public String getHname(JButton button){
        return button.getText();
    }
        
    
    public void addAL(ActionListener a){
        for (int i = 0; i < buttons.size(); i++){
            buttons.get(i).addActionListener(a);
        }
    }
    public void showButtons(){
        for (int i = 0; i < buttons.size(); i++){
            this.DPAframe.add(buttons.get(i));
        }
    }
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
