
import java.util.ArrayList;

public class RoomList {

    ArrayList<Standard> Srooms = new ArrayList<>();
    ArrayList<Deluxe> Drooms = new ArrayList<>();
    ArrayList<Executive> Erooms = new ArrayList<>();

    public RoomList(ArrayList<Standard> Srooms, ArrayList<Deluxe> Drooms, ArrayList<Executive> Erooms){
        
        this.Srooms = Srooms;
        this.Drooms = Drooms;
        this.Erooms = Erooms;

    }

    public void setSrooms(ArrayList<Standard> Srooms){

        this.Srooms = Srooms;

    }

    public void setDrooms(ArrayList<Deluxe> Drooms){

        this.Drooms = Drooms;

    }

    public void setErooms(ArrayList<Executive> Erooms){

        this.Erooms = Erooms;

    }

    public ArrayList<Standard> getSrooms(){

        return this.Srooms;

    }

    public ArrayList<Deluxe> getDrooms(){

        return this.Drooms;

    }

    public ArrayList<Executive> getErooms(){

        return this.Erooms;

    }

    public int getSize(){

        return Srooms.size() + Drooms.size() + Erooms.size();

    }

}