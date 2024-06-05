import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    protected final int TRIES =4;
    protected final int minValue = 0;
    protected final int maxValue = 10;
    protected final int maxNumber = 1000;
    protected final int maxAge = 141;
    protected final int defaultAnswer = -1;
    public List<House> start() {
        int housesNumber = inputDialogue("Введите количество домов:", maxValue);
        ArrayList<House> houses = new ArrayList<House>();
        for (int i = 0; i < housesNumber; i++) {
            int houseDigit = inputDialogue("Введите номер дома:", maxNumber, houses, true);
            House house = new House(houseDigit);
            houses.add(house);
            int roomsNumber = inputDialogue("Введите количество квартир в доме:", maxValue);
            for (int j = 0; j < roomsNumber; j++) {
                int roomDigit = inputDialogue("Введите номер квартиры:", maxNumber, house.getRooms());
                Room room = new Room(roomDigit);
                house.appendRoom(room);
                // etc... 
                // addRoom && addHuman methods in House && Room classes +
                // add hashCode() + equals() methods in House && Room classes +
                // add check if the inputted house or flat number has already been reserved for current house (?!) +
                // override toString() method for House && Room && Humans classes +
                // printFamilies() method looks like doesnt work properly...need to fix it(?!)
            }
        }
        return houses;
    }
    static void print(Object object) {
        System.out.println(object);
    }
    protected int inputDialogue(String text, int maxDigitValue) {
        Scanner scanner = new Scanner(System.in);
        boolean needInput = true;
        int i = 0;
        int answer = defaultAnswer;
        while (i < TRIES && needInput) {
            i++;
            print(text);
            try {
                answer = scanner.nextInt();
            } catch (InputMismatchException e){
                print(e);
                scanner.nextLine();
                answer = defaultAnswer;
            }
            if (minValue <= answer && answer <= maxDigitValue) {
                needInput = false;
            }
        }
        if (needInput) {
            print("All <" +TRIES + "> tries have been expired...");
            print("Please, rerun application.");
            throw new RuntimeException();
        }
        scanner = null;
        return answer;
    }

    protected int inputDialogue(String text,
                                int maxDigitValue,
                                ArrayList<House> collection,
                                boolean isHouse) {
        Scanner scanner = new Scanner(System.in);
        boolean needInput = true;
        int i = 0;
        int answer = defaultAnswer;
        while (i < TRIES && needInput) {
            i++;
            print(text);
            try {
                answer = scanner.nextInt();
            } catch (InputMismatchException e){
                print(e);
                scanner.nextLine();
                answer = defaultAnswer;
            }
            if (minValue <= answer && answer <= maxDigitValue) {
                needInput = false;
            }
            if(collection.contains(new House(answer))) {
                needInput = true;
                print("Ранее уже был введен дом с номером: <" + answer + ">");
                print("Пожалуйста, укажите другой номер дома!");
            }
        }
        if (needInput) {
            print("All <" +TRIES + "> tries have been expired...");
            print("Please, rerun application.");
            throw new RuntimeException();
        }
        scanner = null;
        return answer;
    }

    protected int inputDialogue(String text,
                                int maxDigitValue,
                                ArrayList<Room> collection) {
        Scanner scanner = new Scanner(System.in);
        boolean needInput = true;
        int i = 0;
        int answer = defaultAnswer;
        while (i < TRIES && needInput) {
            i++;
            print(text);
            try {
                answer = scanner.nextInt();
            } catch (InputMismatchException e){
                print(e);
                scanner.nextLine();
                answer = defaultAnswer;
            }
            if (minValue <= answer && answer <= maxDigitValue) {
                needInput = false;
            }
            if(collection.contains(new Room(answer))) {
                needInput = true;
                print("Для текущего дома уже был введена квартира с номером: <" + answer + ">");
                print("Пожалуйста, укажите другой номер квартиры!");
            }
        }
        if (needInput) {
            print("All <" +TRIES + "> tries have been expired...");
            print("Please, rerun application.");
            throw new RuntimeException();
        }
        scanner = null;
        return answer;
    }
}
