import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class House {
    protected int number;
    protected List<Room> rooms;
    public House(int number) {
        this.number = number;
        this.rooms = new ArrayList<>();
    }
    public ArrayList<Room> getRooms() {
        return (ArrayList<Room>)rooms;
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
    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        House other = (House) obj;
        return Objects.equals(getNumber(), other.getNumber());
    }
}
