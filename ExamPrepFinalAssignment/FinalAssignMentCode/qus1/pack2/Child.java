package qus1.pack2;

import qus1.pack1.Parent;

public class Child extends Parent {

    void show() {
        // Accessible because Child is subclass
        System.out.println("Accessing number: " + number);
        display();
    }

    public static void main(String[] args) {
        Child obj = new Child();
        obj.show();
    }
}