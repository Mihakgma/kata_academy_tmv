import java.util.ArrayList;

/**
 * @author Mikhail Tabakaev
 * Java Version required - 17.
 * printLargeFamilies() method looks like doesn't work properly...need to fix it(!!!)
 *
 * An error occerred (from output): - Fixed +
 * Printing large families:
 * Exception in thread "main" java.lang.NullPointerException:
 * Cannot invoke "java.util.Set.add(Object)" because "rooms" is null
 * 	at HousesMarker.filterHouses(HousesMarker.java:23)
 * 	at FamilyFinder.printLargeFamilies(FamilyFinder.java:16)
 * 	at Main.main(Main.java:14)
 * */
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ArrayList<House> houses = (ArrayList<House>) menu.start();
//        System.out.println("Printing all list:");
//        FamilyFinder.printFamilies(houses);
//        System.out.println("Printing large families:");
        FamilyFinder.printLargeFamilies(houses);
    }
}
