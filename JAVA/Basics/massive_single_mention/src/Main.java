public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        float [] arr = new float[] {12.33f, 433.56f, 31.1f, 77.55f};
        int arr_len = arr.length;
        for (int i = 0; i < arr_len; i++) {
            System.out.println("Element with index " + i + " is " + arr[i]);
        }
    }
}