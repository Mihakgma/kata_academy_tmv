import java.util.*;


public class HousesMarker {
    // younger this age is a child
    static final int CHILDREN_BORDER_AGE = 18;
    // more this quality of children is a large family
    static final int CHILDREN_BORDER_NUMBER = 2;
    static HashMap<House, Set<Room>> filterHouses(List<House> houses) {
        HashMap<House, Set<Room>> markedHouses = new HashMap<>();
        for (House house: houses) {
            Set<Room> rooms = new HashSet<>();
            for (Room room: house.getRooms()) {
                int childrenNumber = 0;
                for (Humans human: room.getHumans()) {
                    if (human.getAge() < CHILDREN_BORDER_AGE) {
                        childrenNumber++;
                    }
                }
                if (childrenNumber > CHILDREN_BORDER_NUMBER) {
                    rooms.add(room);
                }
            }
            if(rooms != null) {
                markedHouses.put(house, rooms);
            }
        }
        return markedHouses;
    }
}
