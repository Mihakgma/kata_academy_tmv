import java.util.ArrayList;

/**
 * @author Mikhail Tabakaev
 * Java Version required - 17.
 * printLargeFamilies() method looks like doesn't work properly...need to fix it(!!!)
 * */
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ArrayList<House> houses = (ArrayList<House>) menu.start();
        System.out.println("Printing all list:");
        FamilyFinder.printFamilies(houses);
        System.out.println("Printing large families:");
        FamilyFinder.printLargeFamilies(houses);
    }
}
