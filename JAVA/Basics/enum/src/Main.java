public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//         enum-ы (enumeration) или перечисления в Джаве.
        Animal animal = Animal.CAT;
        System.out.println(animal.getTranslation());
        System.out.println(animal);
//        switch (animal) {
//            case CAT:
//                System.out.println("It's a cat!");
//                break;
//            case DOG:
//                System.out.println("It's a dog!");
//                break;
//            case FROG:
//                System.out.println("It's a frog!");
//                break;
//        }

        Season season = Season.SUMMER;
        System.out.println(season.getTemperature());
//        System.out.println("variable class is: "+season.getClass());
//        switch (season) {
//            case SUMMER:
//                System.out.println("It's warm outside.");
//                break;
//            case WINTER:
//                System.out.println("It's cold outside.");
//                break;
    }
}