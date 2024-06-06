import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * This class provides getting info about houses, rooms in them and peoples lived there
 * During input data realized next checks:
 * - natural digits for houses & rooms quantities & theirs numbers  (min-max values);
 * - the same for age;
 *
 * Attention!!!
 * This class contains 4 versions of the same method inputDialogue()
 * Overloaded for getting different types of objects and information
 * and overloaded by variables types, their quantity and order
 * In one of them there is a GOTO equivalent realized through continue to a label...
 * I'm really sorry didn't find more proper way to process an error occurrence...
 * */
public class Menu {
    protected final int TRIES =4;
    protected final int minValue = 0;
    protected final int maxValue = 10;
    protected final int maxNumber = 1000;
    protected final int maxAge = 141;
    protected final int defaultAnswer = -1;
    protected final String inputErrorWarning = "Ошибка ввода. Пожалуйста, нажмите Enter!";
    /**
     * @return List of houses (House) which contain rooms (Room) in which live people (Humans)
     * */
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
                int personsNumber = inputDialogue("Введите количество человек", maxValue);
                for (int k = 0; k < personsNumber; k++) {
                    String outText = "Введите имя, фамилию и возраст человека, разделение должно быть через пробел";
                    outText += " (например, Иван Иванов 20)";
                    room.appendHuman(inputDialogue(outText, room.getHumans()));
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
                print(inputErrorWarning);
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
    /**
    * Attention!!! This method contains GOTO realization by
     * continue to a label "errorOccurred:"
     * after an error occurrences during user's input process
    * */
    protected Humans inputDialogue(String text,
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
                warningWrongAge += " от <" + minValue + "> и до <" + maxAge + "> включительно";
                print(warningWrongAge);
                print(inputErrorWarning);
                scanner.nextLine();
                continue errorOccurred;
            } catch (ArrayIndexOutOfBoundsException e) {
                print(e);
                print(inputErrorWarning);
                scanner.nextLine();
                continue errorOccurred;
            }
            if (minValue <= human.getAge() &&
                    human.getAge() <= maxAge &&
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
