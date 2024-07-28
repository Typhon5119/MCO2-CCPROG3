import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
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
public class AvailRoomsView {
    private JFrame aFrame;
    private ArrayList<JButton> hotelButtons = new ArrayList<>();
    private JTextArea textArea;
    private JTextField textField;
    private JLabel date;
    private JPanel panel;
    private JScrollPane scroll;
    public AvailRoomsView(){
        aFrame = new JFrame();
        this.aFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.aFrame.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.aFrame.setSize(250, 600);
        this.textArea = new JTextArea(15, 25);
        this.date = new JLabel("Date to check");
        this.textField = new JTextField();
        this.textField.setColumns(10);
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.aFrame.setVisible(true);
    }
    public void addAl2button(ActionListener a, JButton button){
        button.addActionListener(a);
    }
    public void adHotelButton(JButton button){
        hotelButtons.add(button);
    }
    public void showButtons(){
        this.aFrame.add(date);
        this.aFrame.add(textField);
        this.aFrame.add(textArea);
        for (int i = 0; i < hotelButtons.size(); i++){
            this.panel.add(hotelButtons.get(i));
        }
        this.scroll = new JScrollPane(panel);
        scroll.setPreferredSize(new Dimension(225, 200));
        this.aFrame.add(scroll);

    }
    public String getDate(){
        return this.textField.getText();
    }
    public void setTextArea(String info){
        this.textArea.setText(info);
    }

}
