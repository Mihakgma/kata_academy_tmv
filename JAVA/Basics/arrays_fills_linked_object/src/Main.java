public class Main {
    public static void fill(int[][] data, int value)
    {
        for (int i = 0; i < data.length; i++)
        {
            // This method fills all arrays values with parameter value

            for (int j = 0; j < data[i].length; j++)
                data[i][j] = value;
        }
    }

    public static void main(String[] args) {
        int[][] months = {{31, 28}, {31, 30, 31}, {30, 31, 31}};
        fill (months, 8);

        for (int i = 0; i < months.length; i++)
        {
            for (int j = 0; j < months[i].length; j++)
                System.out.print(months[i][j]+" ");
        }
        System.out.println("");
    }
}
