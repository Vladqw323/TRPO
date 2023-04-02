import java.util.ArrayList;

public class Repos_lab5 {
    private ArrayList<Houseplants> _houseplants;
    public Repos_lab5(ArrayList<Houseplants> houseplants){
        _houseplants = houseplants;
    }
    public void addPlant(String namePlant, double height, int lifeTime){
        _houseplants.add(new Houseplants(namePlant, height, lifeTime));
    }
    public void deletePlant(String namePlant){
        for (int i = 0; i < _houseplants.size(); i++) {
            if(_houseplants.get(i).name == namePlant)
            _houseplants.remove(i);
        }
    }
    public void changePlant(String namePlant, String newNamePlant){
        for (Houseplants houseplant : _houseplants) {
            if (houseplant.name == namePlant)
                houseplant.name = newNamePlant;
        }
    }
}
