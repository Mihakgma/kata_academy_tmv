public class Main {
    public static void main(String[] args) {
    int[] firstArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] secondArray = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    int firstArrayLen = firstArray.length;
    int secondArrayLen = secondArray.length;
    int[] resultArray = new int[firstArrayLen + secondArrayLen];
    int counter = 0;

        //напишите тут ваш код
        for (int i = 0; i < resultArray.length; i++) {
            if (i < firstArrayLen) {
                resultArray[i] = firstArray[i];
            } else {
                resultArray[i] = secondArray[counter];
                counter ++;
            }
            System.out.print(resultArray[i] + ", ");
        }
    }
}
