public class Main {
    public static void main(String[] args) {
        int[] array = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        printArray(array);
        reverseArray(array);
        printArray(array);
    }
    public static void reverseArray(int[] array) {
        //напишите тут ваш код
        int[] arrayTmp = array.clone();
        int index = 0;
         for (int i = arrayTmp.length-1; i >= 0; i--) {
             array[index] = arrayTmp[i];
             index++;
         }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}