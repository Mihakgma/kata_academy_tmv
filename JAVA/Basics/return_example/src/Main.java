public class Main {
    public static void fill(int[] data, int from, int to, int value)
    {
        if (from < 0 || to > data.length){
            System.out.println("Parameters are out of limits!");
            System.out.println("Array has not been filled with: <" + value + ">");
            return;
        }

        for (int i = from; i < to; i++)
        {
            data[i] = value;
        }
    }

    public static void main(String[] args) {
        int[] months = {1, 2, 3, 4, 5, 6, 7, 8 ,9, 10, 11, 12};
        fill(months, -2, 10, 8);
        for (int i = 0; i < months.length; i++) {
            System.out.println(months[i]);
        }
//        System.out.println("Hello world!");
    }
}
