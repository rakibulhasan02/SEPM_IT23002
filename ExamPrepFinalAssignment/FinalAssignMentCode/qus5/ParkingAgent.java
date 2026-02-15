public class ParkingAgent extends Thread {
    private final int agentId;
    private final ParkingPool pool;

    public ParkingAgent(int agentId, ParkingPool pool) {
        this.agentId = agentId;
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            while (true) {
                RegistrarParking req = pool.takeRequest();
                if (req == null) break; // pool closed and no requests

                // simulate parking time
                Thread.sleep(200);

                System.out.println("Agent " + agentId + " parked car " + req.getCarNumber() + ".");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
