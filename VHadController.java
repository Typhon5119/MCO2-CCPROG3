import javax.swing.JButton;

public class VHadController {
    VHadview vHadview;
    HRSmodel hrSmodel;
    public VHadController(VHadview vHadview, HRSmodel hrSmodel){
        this.vHadview = vHadview;
        this.hrSmodel = hrSmodel;

        for (int i = 0; i < hrSmodel.getHotellist().size(); i++){
            vHadview.addbutton(new JButton(hrSmodel.getHotellist().get(i).getName()));
        }
        
        vHadview.addTextArea();
        vHadview.showButtons();
    }
}
