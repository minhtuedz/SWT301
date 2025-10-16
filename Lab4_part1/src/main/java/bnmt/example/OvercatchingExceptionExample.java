package bnmt.example;

public class OvercatchingExceptionExample {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            System.out.println(arr[10]); // lỗi ở đây
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Tried to access an invalid array index.");
            e.printStackTrace();
        }
    }
}
