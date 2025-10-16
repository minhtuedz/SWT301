package bnmt.example;

public class UnreachableCodeExample {
    public static int getNumber() {
        System.out.println("Preparing to return number...");
        return 42;
    }

    public static void main(String[] args) {
        System.out.println(getNumber());
    }
}
