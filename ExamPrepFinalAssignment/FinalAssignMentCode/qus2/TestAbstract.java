abstract class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }

    abstract void sound();
}

abstract class Machine {
    abstract void start();
}

// ❌ This is NOT allowed in Java
// class RobotDog extends Animal, Machine { }

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

public class TestAbstract {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.sound();
    }
}
