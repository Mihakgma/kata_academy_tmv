public class Main {
//    public
    public static long cube(long digit) {
        return (long) Math.pow(digit, 3);
    }
    public static void main(String[] args) {
        long value = 3;
        System.out.println("The result of cubic pow for <" + value + "> is :");
        System.out.println(cube(value) );
    }
}