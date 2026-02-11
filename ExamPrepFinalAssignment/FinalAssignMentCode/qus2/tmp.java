abstract class Innertmp {

    void rakibuk(){
        System.out.println("This is Rakibul Hasan");
    }
    abstract void sound();
}

abstract class Innertmp_1 {

    abstract void Animal();
}
// class cat extends Innertmp,Innertmp_1{
class cat extends Innertmp{
    void sound(){
        System.out.println("Maw");
    }
    void Animal1(){
        System.out.println("This is animal");
    }
}
public class tmp {
    public static void main(String[] args) {
        cat c=new cat();
        c.rakibuk(); 
        c.Animal1();
    }
}
