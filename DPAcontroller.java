import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * 
 * Controller for the date price modifier feature
 */

public class DPAcontroller {
    DPAchoose dpaView;
    HRSmodel model;
    public DPAcontroller(DPAchoose dpaView, HRSmodel model){
        this.dpaView = dpaView;
        this.model = model;
        for (int i = 0; i < model.getHotellist().size(); i++){
            JButton temp = new JButton(model.getHotellist().get(i).getName());
            temp.setMinimumSize(new Dimension(170, 30));
            dpaView.addButton(temp);
        }
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String day = dpaView.getDay(); // get day from dpaview
                    String percent = dpaView.getPercent(); // get percentage
                    String hotelName = dpaView.getHname((JButton) e.getSource()); // get hotel name from the button pressed
                    int dayint = Integer.parseInt(day.trim()); // convert to int
                    int pint = Integer.parseInt(percent.trim()); // convert to int
                    if (pint >= 50 && pint <= 150){ // between 50 and 150 percent
                         for (int i = 0; i < model.getHotellist().size(); i++){ // find hotel
                            if (hotelName.equals(model.getHotellist().get(i).getName())){
                                
                                model.getHotellist().get(i).addPriceAdj(dayint, pint); // add to price adjustment arrays in hotel class
                                
                            }
                        }
                        // dpaView.closeframe();
                        String info = "";
                        for (int j = 0; j < model.getHotellist().size(); j++){
                            if (model.getHotellist().get(j).getpriceAdjdays().size() > 0){
                                info += model.getHotellist().get(j).getName() + "\nmodification/s: \n";
                                info += model.getHotellist().get(j).getModifications() + "\n";
                            }
                        }
                        dpaView.updateTextArea(info);
                    }
                    else{
                        dpaView.failed();
                    }
                }
                catch (Exception a){
                    dpaView.failed();
                }
                        
                    
                    
                    
                    
                
                
                
                
            }
        };
        String info = "";
        
        for (int j = 0; j < model.getHotellist().size(); j++){
            if (model.getHotellist().get(j).getpriceAdjdays().size() > 0){
                info += model.getHotellist().get(j).getName() + "\nmodification/s: \n";
                info += model.getHotellist().get(j).getModifications() + "\n";
            }
        }
        dpaView.updateTextArea(info);
        dpaView.addComponents();
        dpaView.addAL(a);
        
        dpaView.showButtons();
    }
    


}
