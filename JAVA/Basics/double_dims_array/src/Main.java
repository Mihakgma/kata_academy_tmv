import java.util.Scanner;


public class Main {
    public static int[][] multiArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        multiArray = new int[n][];
        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            multiArray[i] = new int[size];
        }
        System.out.println(multiArray);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < multiArray[i].length; j++) {
                System.out.print("[] ");
            }
            System.out.println();
        }
    }
}
