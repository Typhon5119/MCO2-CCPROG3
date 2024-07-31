
/**
 * 
 * Controller for view hotel
 */
public class VHcont {
    private HRSmodel hrSmodel;
    private VHview viewFrame;

    /**
     * Constructor
     * @param hrSmodel the model for HRS
     * @param viewFrame the view object
     */
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
