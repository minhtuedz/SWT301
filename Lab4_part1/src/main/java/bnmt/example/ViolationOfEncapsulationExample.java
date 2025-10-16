package bnmt.example;

class User {
    private String name;
    private int age;

    // Constructor
    public User(String name, int age) {
        setName(name);
        setAge(age);
    }

    // Getter và Setter có kiểm tra dữ liệu
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.err.println("Invalid name!");
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.err.println("Invalid age!");
        } else {
            this.age = age;
        }
    }

    // Phương thức hiển thị thông tin
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("Alice", 25);
        user.display();

        // Thử cập nhật sai để thấy validation hoạt động
        user.setAge(-5);
        user.display();
    }
}
