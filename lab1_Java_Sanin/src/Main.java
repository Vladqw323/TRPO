import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<BeautifulBlooming> beautifulBloomings = new ArrayList<>();
        beautifulBloomings.add(new BeautifulBlooming("cactus", 100.5, 15, 5));
        beautifulBloomings.add(new BeautifulBlooming("spathiphyllum", 50.4, 25, 3));
        beautifulBloomings.add(new BeautifulBlooming("kalanchoe", 70.7, 20, 8));
        beautifulBloomings.add(new BeautifulBlooming("anthurium", 30.1, 2, 1));
        ArrayList<Succulents> succulents = new ArrayList<>();
        succulents.add(new Succulents("graptopetalum", 20.3, 4));
        succulents.add(new Succulents("pachyphytum", 17.8, 3));
        succulents.add(new Succulents("aichrizon", 13.1, 8));
        ArrayList<Ferns> ferns = new ArrayList<>();
        ferns.add(new Ferns("davallia", 10.6, 96));
        ferns.add(new Ferns("maidenhair", 9.8, 89));
        ferns.add(new Ferns("platicerium", 15.9, 100));

        for (int i = 0; i < beautifulBloomings.size(); i++) {
            System.out.println(beautifulBloomings.get(i).name + " " + beautifulBloomings.get(i).height + " " + beautifulBloomings.get(i).lifeTime + " " + beautifulBloomings.get(i).floweringTime);
        }

        System.out.println("-------------------------------------");

        ArrayList<Houseplants> houseplants = new ArrayList<>();
        houseplants.addAll(beautifulBloomings);
        houseplants.addAll(succulents);
        houseplants.addAll(ferns);

        for(int i = 0; i < houseplants.size(); i++){
            if (houseplants.get(i).lifeTime < 5)
                System.out.println(houseplants.get(i).name);
        }

        System.out.println("-------------------------------------");

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the value of the height");
        Double givenHeight = in.nextDouble();

        for(int i = 0; i < ferns.size(); i++){
            if (ferns.get(i).height > givenHeight)
                System.out.println(ferns.get(i).name);
        }
    }
}