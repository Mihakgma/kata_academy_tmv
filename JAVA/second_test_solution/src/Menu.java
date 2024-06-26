import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * This class provides getting info about houses, rooms in them and peoples lived there
 * During input data realized next checks:
 * - natural digits for houses & rooms quantities & theirs numbers  (min-max values);
 * - the same for age;
 * - check data before Human class object create
 * - almost all input data check
 * - etc...
 *
 * Attention!!!
 * This class contains 4 versions of the same method startDialogue()
 * Overloaded for getting different types of objects and information
 * and overloaded by variables types, their quantity and order
 * In one of them there is a GOTO equivalent realized through continue to a label...
 * I'm really sorry didn't find more proper way to process an error occurrence...
 * */
public class Menu {
    protected final int TRIES =4;
    protected final int MIN_VALUE = 1;
    protected final int MAX_VALUE = 10;
    protected final int MAX_NUMBER = 1000;
    protected final int MAX_AGE = 141;
    protected final int DEFAULT_ANSWER = -1;
    protected final String INPUT_ERROR_WARNING = "Ошибка ввода. Пожалуйста, нажмите Enter!";
    /**
     * @return List of houses (House) which contain rooms (Room) in which live people (Humans)
     * */
    public List<House> start() {
        int housesNumber = startDialogue("Введите количество домов:", MAX_VALUE);
        ArrayList<House> houses = new ArrayList<House>();
        for (int i = 0; i < housesNumber; i++) {
            int houseDigit = startDialogue("Введите номер дома:", MAX_NUMBER, houses, true);
            House house = new House(houseDigit);
            houses.add(house);
            int roomsNumber = startDialogue("Введите количество квартир в доме:", MAX_VALUE);
            for (int j = 0; j < roomsNumber; j++) {
                int roomDigit = startDialogue("Введите номер квартиры:", MAX_NUMBER, house.getRooms());
                Room room = new Room(roomDigit);
                house.appendRoom(room);
                int personsNumber = startDialogue("Введите количество человек", MAX_VALUE);
                for (int k = 0; k < personsNumber; k++) {
                    String outText = "Введите имя, фамилию и возраст человека, разделение должно быть через пробел";
                    outText += " (например, Иван Иванов 20)";
                    room.appendHuman(startDialogue(outText, room.getHumans()));
                }
                // etc... +
                // addRoom && addHuman methods in House && Room classes +
                // add hashCode() + equals() methods in House && Room classes +
                // add hashCode() + equals() methods in Humans class +
                // add check if the inputted house or flat number has already been reserved for current house (!) +
                // override toString() method for House && Room && Humans classes +
            }
        }
        return houses;
    }
    static void print(Object object) {
        System.out.println(object);
    }

    protected int startDialogue(String text, int maxDigitValue) {
        Scanner scanner = new Scanner(System.in);
        boolean needInput = true;
        int i = 0;
        int answer = DEFAULT_ANSWER;
        while (i < TRIES && needInput) {
            i++;
            print(text);
            try {
                answer = scanner.nextInt();
            } catch (InputMismatchException e){
                print(e);
                print(INPUT_ERROR_WARNING);
                scanner.nextLine();
                answer = DEFAULT_ANSWER;
            }
            if (MIN_VALUE <= answer && answer <= maxDigitValue) {
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
    /**
    * Attention!!! This method contains GOTO realization by
     * continue to a label "errorOccurred:"
     * after an error occurrences during user's input process
    * */
    protected Humans startDialogue(String text,
                                   List<Humans> collection) {
        Humans blankHuman = new Humans("", "", 0);
        Humans human = new Humans("", "", 0);
        Scanner scanner = new Scanner(System.in);
        boolean needInput = true;
        int i = 0;
        String answer = "";
        errorOccurred:
        while (i < TRIES && needInput) {
            i++;
            print(text);
            try {
                answer = scanner.nextLine();
                String[] humanInfo = answer.split(" ");
                for (int j = 0; j < 3; j++) {
                    switch (j){
                        case 0: human.setName(humanInfo[j]);
                        break;
                        case 1: human.setLastName(humanInfo[j]);
                        break;
                        case 2: human.setAge(Integer.parseInt(humanInfo[j]));
                        break;
                    }
                }
            } catch (InputMismatchException e){
                print(e);
                print("Ошибка ввода.");
                scanner.nextLine();

            } catch (NumberFormatException e) {
                print(e);
                String warningWrongAge = "Требуется ввести возраст (положительное число в интервале";
                warningWrongAge += " от <" + MIN_VALUE + "> и до <" + MAX_AGE + "> включительно";
                print(warningWrongAge);
                print(INPUT_ERROR_WARNING);
                scanner.nextLine();
                continue errorOccurred;
            } catch (ArrayIndexOutOfBoundsException e) {
                print(e);
                print(INPUT_ERROR_WARNING);
                scanner.nextLine();
                continue errorOccurred;
            }
            if (MIN_VALUE <= human.getAge() &&
                    human.getAge() <= MAX_AGE &&
                    human != blankHuman) {
                needInput = false;
            }
            if(collection.contains(human)) {
                needInput = true;
                print("В данной квартире уже проживает человек с:");
                print("Именем <" + human.getName() + ">, " + "Фамилией <" +
                        human.getLastName() + "> " + "и возрастом <"  + human.getAge() + ">");
                print("Пожалуйста, укажите другие ФИ и возраст человека!");
            }
        }
        if (needInput) {
            print("All <" + TRIES + "> tries have been expired...");
            print("Please, rerun application.");
            throw new RuntimeException();
        }
        scanner = null;
        return human;
    }

    protected int startDialogue(String text,
                                int maxDigitValue,
                                ArrayList<House> collection,
                                boolean isHouse) {
        Scanner scanner = new Scanner(System.in);
        boolean needInput = true;
        int i = 0;
        int answer = DEFAULT_ANSWER;
        while (i < TRIES && needInput) {
            i++;
            print(text);
            try {
                answer = scanner.nextInt();
            } catch (InputMismatchException e){
                print(e);
                scanner.nextLine();
                answer = DEFAULT_ANSWER;
            }
            if (MIN_VALUE <= answer && answer <= maxDigitValue) {
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

    protected int startDialogue(String text,
                                int maxDigitValue,
                                ArrayList<Room> collection) {
        Scanner scanner = new Scanner(System.in);
        boolean needInput = true;
        int i = 0;
        int answer = DEFAULT_ANSWER;
        while (i < TRIES && needInput) {
            i++;
            print(text);
            try {
                answer = scanner.nextInt();
            } catch (InputMismatchException e){
                print(e);
                scanner.nextLine();
                answer = DEFAULT_ANSWER;
            }
            if (MIN_VALUE <= answer && answer <= maxDigitValue) {
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
