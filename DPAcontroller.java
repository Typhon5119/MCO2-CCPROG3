import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DPAcontroller {
    DPAchoose dpaView;
    HRSmodel model;
    public DPAcontroller(DPAchoose dpaView, HRSmodel model){
        this.dpaView = dpaView;
        this.model = model;
        for (int i = 0; i < model.getHotellist().size(); i++){
            dpaView.addButton(new JButton(model.getHotellist().get(i).getName()));
        }
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                    String day = dpaView.getDay();
                    String percent = dpaView.getPercent();
                    String hotelName = dpaView.getHname((JButton) e.getSource());
                    int dayint = 1;
                    int pint = 2;
                    
                         
                         for (int i = 0; i < model.getHotellist().size(); i++){
                            if (hotelName.equals(model.getHotellist().get(i).getName())){
                                
                                model.getHotellist().get(i).addPriceAdj(dayint, pint);
                                System.out.println(dayint);
                            }
                        }
                        dpaView.closeframe();
                    
                    
                    
                    
                
                
                
                
            }
        };
        dpaView.addComponents();
        dpaView.addAL(a);
        
        dpaView.showButtons();
    }
    


}
