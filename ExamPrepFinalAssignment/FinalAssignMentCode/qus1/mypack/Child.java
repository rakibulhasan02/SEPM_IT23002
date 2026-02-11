package qus1.mypack;

// package mypack;

class Child extends Parent {
    void show() {
        System.out.println("Accessing number: " + number);
        display();
    }

    public static void main(String[] args) {
        Child obj = new Child();
        obj.show();
    }
}