import java.util.HashMap;

public class EmployeeHashMapExample {
    public static void main(String[] args) {
        //create hashmap
        HashMap<Integer,String> employees=new HashMap<>();

        //adding employees data (id-->department)

        employees.put(101,"HR");
        employees.put(102,"IT");//do not store because hashMap can be stored last key
        employees.put(103,"Finance");
        employees.put(102,"Marketing");

        //display all entires
        for(Integer id:employees.keySet()){
            System.out.println("Employee Id: "+id+", Deparment: "+employees.get(id));
        }
    }
}
