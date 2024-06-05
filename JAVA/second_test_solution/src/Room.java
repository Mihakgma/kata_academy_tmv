import java.util.ArrayList;
import java.util.List;

public class Room {
    protected int number;
    protected List<Humans> humans;
    public Room(int number) {
        this.number = number;
        this.humans = new ArrayList<>();
    }
    public List<Humans> getHumans() {
        return humans;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public void appendHuman(Humans human) {
        this.humans.add(human);
    }
    @Override
    public String toString() {
        return String.format("Квартира #%d:", getNumber());
    }
}
