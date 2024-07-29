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

        view.showButtons();
    }
}
