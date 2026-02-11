interface  Animal1 {
    void eat1();
}
interface Machine1{
    void start1();
}

class RobotDog1 implements Animal1,Machine1{
    public void eat1(){
        System.out.println("She is currenlty eating");
    }
    public void start1(){
        System.out.println("The machine is running");
    }

}
public class tmpInterface {
    public static void main(String[] args) {
        RobotDog1 r=new RobotDog1();
        r.eat1();
        r.start1();
        

    }
}
