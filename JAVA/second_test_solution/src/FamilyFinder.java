import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Large family is a family that has more than 2 children
 * Child is a person with age younger than 18 years old
* */
public class FamilyFinder {
    /**
     * This method prints house number, flat number, last name & children's names
     * which lives in the current flat
     * @param houses - list of saved houses
     */
    static public void printLargeFamilies(List<House> houses) {
        HashMap<House, Set<Room>> housesMap = HousesMarker.filterHouses(houses);
        printFamilies(housesMap);
    }

    /**
     * @deprecated The newest version of the method (renamed properly)
     * @see FamilyFinder#printLargeFamilies
     * @param houses
     */
    static void printLargeFamiles(List<House> houses) {
        print("");
    }
    static public void printFamilies(List<House> houses) {
//        print("Starting printing List");
        for (House house: houses) {
//            print(house);
            print(String.format("Дом #%d", house.getNumber()));
            for (Room room: house.getRooms()) {
                print(String.format("Квартира #%d:", room.getNumber()));
                for (Humans human: room.getHumans()) {
                    print(human.getName() + " " + human.getLastName());
                }
            }
        }
    }
    static public void printFamilies(HashMap<House, Set<Room>> houses) {
//        System.out.println("Printing " + houses);
        for (House house: houses.keySet()) {
            print(String.format("Дом #%d", house.getNumber()));
            Set<Room> rooms = houses.get(house);
            for (Room room: rooms) {
                print(String.format("Квартира #%d:", room.getNumber()));
                for (Humans human: room.getHumans()) {
                    print(human.getName() + " " + human.getLastName());
                }
            }
        }
    }
    static void print(Object object) {
        System.out.println(object);
    }
}
