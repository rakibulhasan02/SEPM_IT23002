import java.util.LinkedList;
import java.util.Queue;

public class ParkingPool {
    private final Queue<RegistrarParking> queue = new LinkedList<>();
    private boolean open = true; // pool open/close control

    // Car requests parking
    public synchronized void addRequest(RegistrarParking request) {
        queue.add(request);
        notifyAll(); // wake up agents waiting
    }

    // Agent takes a car to park (blocks if empty)
    public synchronized RegistrarParking takeRequest() throws InterruptedException {
        while (queue.isEmpty() && open) {
            wait();
        }
        // if closed and empty -> stop
        if (queue.isEmpty() && !open) return null;

        return queue.poll();
    }

    // When no more cars will arrive
    public synchronized void closePool() {
        open = false;
        notifyAll();
    }
}
