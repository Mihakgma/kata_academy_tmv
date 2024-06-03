public class Main {
    public static int[][] result = new int[77][];

    public static void main(String[] args) {
        for (int i = 0; i < result.length; i++) {
            result[i] = new int[i + 1];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = i + j;
                System.out.print(result[i][j] + "_");
            }
            System.out.println();
        }
        System.out.println("Hello, triangle!");
    }
}