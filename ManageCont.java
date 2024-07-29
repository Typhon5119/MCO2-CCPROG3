import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ManageCont {
    HRSmodel model;
    ManageView view;
    public ManageCont(ManageView view, HRSmodel model){
        this.view = view;
        this.model = model;
        for (int i = 0; i < model.getHotellist().size(); i++){
            view.addButton( new JButton(model.getHotellist().get(i).getName()));
        }

        view.addAL2buttons(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                view.unmarkAll();
                view.mark( (JButton)  e.getSource());
            }
        });

        view.addAL1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });

        view.showButtons();
    }
}
