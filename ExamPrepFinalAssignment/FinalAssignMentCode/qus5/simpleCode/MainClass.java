import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ParkingAgent extends Thread {
    private BlockingQueue<String> pool;
    private int id;

    public ParkingAgent(int id, BlockingQueue<String> pool) {
        this.id = id;
        this.pool = pool;
    }

    public void run() {
        try {
            while (true) {
                String car = pool.take(); // waits if empty
                if (car.equals("STOP")) break;

                System.out.println("Agent " + id + " parked car " + car + ".");
                Thread.sleep(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class MainClass {
    public static void main(String[] args) throws Exception {

        BlockingQueue<String> pool = new LinkedBlockingQueue<>();

        // Start 2 agents
        ParkingAgent a1 = new ParkingAgent(1, pool);
        ParkingAgent a2 = new ParkingAgent(2, pool);

        a1.start();
        a2.start();

        // Simulate cars arriving
        String[] cars = {"ABC123", "XYZ456", "CAR789"};

        for (String car : cars) {
            System.out.println("Car " + car + " requested parking.");
            pool.put(car);
        }

        // Stop agents
        pool.put("STOP");
        pool.put("STOP");
    }
}
