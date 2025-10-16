package bnmt.example;

interface Drawable {
    void draw();
}

interface Resizable {
    void resize();
}

class Square implements Drawable, Resizable {
    public void draw() {
        System.out.println("Drawing square");
    }

    public void resize() {
        System.out.println("Resizing square");
    }
}

public class Main {
    public static void main(String[] args) {
        Drawable d = new Square();
        d.draw();

        Resizable r = new Square();
        r.resize();
    }
}
