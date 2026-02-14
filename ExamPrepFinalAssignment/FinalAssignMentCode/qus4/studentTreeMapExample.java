import java.util.TreeMap;


class Student {
    private String name;
    private int age;
    private String department;
    public Student(String name,int age,String department){
        this.name=name;
        this.age=age;
        this.department=department;
    }
    public void display(){
        System.out.println("Name : "+name+" , Age: "+age+" , department: "+department);
    }
    
}
public class studentTreeMapExample {

    public static void main(String[] args) {
        //create treeMap
        TreeMap<Integer,Student> students=new TreeMap<>();

        //adding students(ID-->Student object)
        students.put(102, new Student("Rakibul", 22, "Ict"));
        students.put(101, new Student("Hasan", 23, "Cse"));
        students.put(105, new Student("Naiem", 25, "BMB"));

        //Display students (sorted by ID automatically)
        for(Integer id:students.keySet()){
            System.out.print("Student id: "+id+"--> ");
            students.get(id).display();
        }


    }
}