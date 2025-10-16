package bnmt.example;

public class CatchGenericExceptionExample {
    public static void main(String[] args) {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.err.println("Error: The string is null and cannot be dereferenced.");
            e.printStackTrace(); // In ra chi tiết lỗi
        }
    }
}
