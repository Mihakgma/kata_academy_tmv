public class Main {
    public static void main(String[] args) {
        signIn("Misha");
        signIn("user");
        System.out.println("Hello world!");
    }
    public static void signIn(String username){
        //напишите тут ваш код
        if(username == "user"){
            return;
        }
        System.out.println("Добро пожаловать " + username);
        System.out.println("Очень скучали по Вам, " + username);
    }
}