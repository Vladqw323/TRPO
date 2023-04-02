import java.util.ArrayList;

public class Repos_lab5 {
    private ArrayList<Houseplants> houseplants;
    public Repos_lab5(ArrayList<Houseplants> houseplants){
        this.houseplants = houseplants;
    }
    public void addPlant(String namePlant, double height, int lifeTime){
        houseplants.add(new Houseplants(namePlant, height, lifeTime));
    }
    public void deletePlant(int index){
            houseplants.remove(index);
    }
    public void changePlant(String namePlant, String newNamePlant, int index){
        /*for (Houseplants houseplant : _houseplants) {
            if (houseplant.name == namePlant)
                houseplant.name = newNamePlant;
        }*/
        houseplants.get(index).name = newNamePlant;
    }

    public ArrayList<Houseplants> getArray()
    {
        return houseplants;
    }
}
