

public class VHcont {
    private HRSmodel hrSmodel;
    private VHview viewFrame;

    public VHcont(HRSmodel hrSmodel, VHview viewFrame){
        this.hrSmodel = hrSmodel;
        this.viewFrame = viewFrame;
        String text = "";
        
            
            for (int i = 0; i < hrSmodel.getHotellist().size(); i++){
                text += hrSmodel.getHotellist().get(i).displayHotel();
            }
        if (hrSmodel.getHotellist().size() == 0)
            text += "There may be no hotels. ";
        

        viewFrame.addComponent(text);
    }


}
