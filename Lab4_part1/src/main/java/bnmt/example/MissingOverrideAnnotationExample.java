package bnmt.example;

class Animal {
    void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal d = new Dog();

        a.speak(); // Gọi phương thức của Animal
        d.speak(); // Gọi phương thức override của Dog
    }
}
