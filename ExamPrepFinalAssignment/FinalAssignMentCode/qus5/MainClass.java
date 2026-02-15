public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        int N = 8;          // number of cars
        int agents = 2;     // number of parking agents

        ParkingPool pool = new ParkingPool();

        // Start parking agents
        ParkingAgent[] agentThreads = new ParkingAgent[agents];
        for (int i = 0; i < agents; i++) {
            agentThreads[i] = new ParkingAgent(i + 1, pool);
            agentThreads[i].start();
        }

        // Simulate N cars arriving concurrently
        Thread[] carThreads = new Thread[N];
        for (int i = 0; i < N; i++) {
            final String carNo = "CAR" + (100 + i); // sample plate

            carThreads[i] = new Thread(() -> {
                System.out.println("Car " + carNo + " requested parking.");
                pool.addRequest(new RegistrarParking(carNo));
            });

            carThreads[i].start();
        }

        // wait all cars to finish requesting
        for (Thread t : carThreads) t.join();

        // close pool (no more cars)
        pool.closePool();

        // wait agents to finish
        for (ParkingAgent a : agentThreads) a.join();

        System.out.println("All cars parked. System closed.");
    }
}
