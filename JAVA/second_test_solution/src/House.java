import java.util.ArrayList;
import java.util.List;


public class House {
    protected int number;
    protected List<Room> rooms;
    public House(int number) {
        this.number = number;
        this.rooms = new ArrayList<>();
    }
    public List<Room> getRooms() {
        return rooms;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public void appendRoom(Room room) {
        this.rooms.add(room);
    }
    @Override
    public String toString() {
        return String.format("Дом #%d", getNumber());
    }
}
