public class Main {
    public static void main(String[] args) {
        int[] array = {15,64,9,51,42};
        printSqrt(array);

//        System.out.println("Hello world!");
    }
    public static void printSqrt(int[] array) {
        String elementSqrtStr = "Корень квадратный для числа ";
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            double elementSqrt = Math.sqrt(element);
            System.out.println(elementSqrtStr + element + " равен " + elementSqrt);
        }
    }
}