interface Animal {
    void eat();
    
}

interface Machine {
    void start();
}

class RobotDog implements Animal, Machine {

    public void eat() {
        System.out.println("RobotDog charging energy");
    }

    public void start() {
        System.out.println("RobotDog starting system");
    }
}

public class TestInterface {
    public static void main(String[] args) {
        RobotDog r = new RobotDog();
        r.eat();
        r.start();
    }
}
