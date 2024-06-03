public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Person person1 = new Person();
        person1.name = "Михалик";
        person1.age = 32;
        person1.sayHello();
        Person person2 = new Person();
        person2.name = "Вовик";
        person2.age = 12;
        person2.isMale = true;
        person2.sayHello();
        person2.speak();
        person2.yearsToRetirement();
    }
}

class Person{
    String name;
    int age;
    boolean isMale;

    int yearsToRetirement(){
        int retirementAge;
        if (isMale) {
            retirementAge = 65;
        } else retirementAge = 60;
        int years = retirementAge - age;
        System.out.println("До пенсии: "+years+" лет.");
        return years;
    }
    void speak(){
        for (int i = 0; i<3; i++){
            System.out.println("Меня зовут "+name+", мне "+age+" лет.");
        }
    }
    void sayHello(){
        System.out.println("Привет! Меня зовут "+name+". А тебя?");
    }
}
