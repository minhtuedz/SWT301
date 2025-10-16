package bnmt.example;


public final class AppConstants {
    private AppConstants() {} // Ngăn tạo đối tượng

    public static final int MAX_USERS = 100;
}

public class InterfaceFieldModificationExample {
    public static void main(String[] args) {
        System.out.println("Maximum allowed users: " + AppConstants.MAX_USERS);
        // AppConstants.MAX_USERS = 200; //  Không thể thay đổi vì là final
    }
}
