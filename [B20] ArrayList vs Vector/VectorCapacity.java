import java.util.Vector;

public class VectorCapacity {

    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<>();

        System.out.println("Initial Capacity: " + vector.capacity());

        // Add elements more than initial capacity
        for (int i = 1; i <= 11; i++) {
            vector.add(i);
        }

        System.out.println("Capacity after exceeding initial size: " + vector.capacity());
    }
}
