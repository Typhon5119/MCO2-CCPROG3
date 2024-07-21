import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HRScontroller {
    private HRSmodel model;
    private HRSview view;
    public HRScontroller(HRSmodel model, HRSview view){
        this.model = model;
        this.view = view;
        this.view.setactionListener1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String name = view.getHNameText();
                String nRooms = view.getnRooms();
                boolean res = model.addHotel(name, nRooms);
                if (res){
                    view.setsorf("Added");
                }
                else {
                    view.setsorf("Failed to add");
                }
            }
        });
        this.view.setactionListener2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                VHview vhview = new VHview(model); 
                
                System.out.println(model.getHotellist().get(0).getName());
            }
        });
        this.view.setactionListenerAd(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                VHadview vHadview = new VHadview();
                VHadController vHadController = new VHadController(vHadview, model);
            }
        });
        this.view.addComponents();
        

        }
}


