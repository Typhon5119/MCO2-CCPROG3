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
                String nDRooms = view.getnDrooms();
                String nERooms = view.getnErooms();
                boolean res = model.addHotel(name, nRooms, nDRooms, nERooms);
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
        this.view.setactionListener3(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Manage");
            }
        });
        this.view.setactionListener4(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                BookView bookView = new BookView();
                BookController bookController = new BookController(bookView, model);
            }
        });
        this.view.setactionListener5(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                DPAchoose dpaView = new DPAchoose();
                DPAcontroller dpAcontroller = new DPAcontroller(dpaView, model);
            }
        });
        this.view.setALvHad2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                AvailRoomsView availRoomsView = new AvailRoomsView();
                AvailRoomsCntr availRoomsCntr = new AvailRoomsCntr(availRoomsView, model);
            }
        });
        this.view.addComponents();
        

        }
}


