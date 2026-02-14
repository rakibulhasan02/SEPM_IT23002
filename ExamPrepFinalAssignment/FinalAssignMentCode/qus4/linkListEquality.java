import java.util.LinkedList;

public class linkListEquality {
    public static void main(String[] args) {
        //create linkList
        LinkedList<Integer> list1=new LinkedList<>();
        LinkedList<Integer> list2=new LinkedList<>();

        //add element
        list1.add(10);
        list1.add(20);
        list1.add(30); 

        list2.add(10);
        list2.add(20);
        list2.add(30);

        //check equality
        if(list1.equals(list2)){
            System.out.println("Both link list are equal");
        }
        else System.out.println("Both link list are not equal");
    }
}
