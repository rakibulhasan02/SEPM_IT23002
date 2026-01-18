import java.util.ArrayList;

public class ArrayListGrowth {

    public static void main(String[] args) {

        // Default initial capacity of ArrayList = 10
        ArrayList<Integer> list = new ArrayList<>();

        // Adding elements beyond initial capacity
        for (int i = 1; i <= 11; i++) {
            list.add(i);
        }

        // Size is accessible, capacity is internal
        System.out.println("ArrayList Size: " + list.size());

        /*
         Internally ArrayList grows using the formula:
         newCapacity = oldCapacity + (oldCapacity / 2)

         Example:
         oldCapacity = 10
         newCapacity = 10 + (10 / 2) = 15

         So ArrayList increases by 50%
        */
    }
}
