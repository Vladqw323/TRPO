import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //В main только инициализаци    и, какие-то запуски, никакого кода
        work();
    }

    public static void work(){
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

        //Цикл for с индексом i требовал вывод beautifulBloomings.get(i).name, теперь же с циклом foreach всё проще
        for (BeautifulBlooming beautifulBlooming : beautifulBloomings) {
            System.out.println(beautifulBlooming.name + " " + beautifulBlooming.height + " " + beautifulBlooming.lifeTime + " " + beautifulBlooming.floweringTime);
        }

        printline();

        ArrayList<Houseplants> houseplants = new ArrayList<>();
        houseplants.addAll(beautifulBloomings);
        houseplants.addAll(succulents);
        houseplants.addAll(ferns);
        //Цикл for изменён на цикл foreach для простоты
        for (Houseplants houseplant : houseplants) {
            if (houseplant.lifeTime < 5)
                System.out.println(houseplant.name);
        }

        printline();

        Repos_lab5 reposLab5 = new Repos_lab5(houseplants);

        reposLab5.deletePlant("davallia");
        for(Houseplants plant : houseplants){
            System.out.println(plant.name + " " + plant.height + " " + plant.lifeTime);
        }

        printline();

        reposLab5.changePlant("aichrizon", "changedPlant");
        for(Houseplants plant : houseplants){
            System.out.println(plant.name + " " + plant.height + " " + plant.lifeTime);
        }

        printline();

        reposLab5.addPlant("newAddedPlant", 20, 10);
        for(Houseplants plant : houseplants){
            System.out.println(plant.name + " " + plant.height + " " + plant.lifeTime);
        }

        printline();

        Scanner in = new Scanner(System.in);
        System.out.println("Пожалуйста введите значение высоты:");
        //Пока значение не будет корректным, то есть типа double, будет отрабатывать цикл (обработка исключений)
        while (!in.hasNextDouble()) {
            System.out.println("Пожалуйста, введите корректное значение:");
            in.next();
        }
        double givenHeight = in.nextDouble();

        //Цикл for с индексом i требовал вывод ferns.get(i).name, теперь же с циклом foreach всё проще
        for (Ferns fern : ferns) {
            if (fern.height > givenHeight)
                System.out.println(fern.name);
        }
    }

    public static void printline(){
        //Метод для красоты кода
        System.out.println("-------------------------------------");
    }
}