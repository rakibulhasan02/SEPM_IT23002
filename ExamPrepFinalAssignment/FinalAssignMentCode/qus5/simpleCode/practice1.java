// package qus5.simpleCode;


// package qus5.simpleCode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

 class ParkingAgent1 extends Thread {
    private BlockingQueue<String> pool;
    private int id;
    public ParkingAgent1(int id,BlockingQueue pool){
        this.id=id;
        this.pool=pool;
    }

    public void run(){
        try{
            while (true) {
                String car=pool.take(); //waits id empty
                if(car.equals("STOP")) break;
                System.out.println("Agent "+id+" parked car "+car);
                Thread.sleep(200);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
public class practice1 {
    public static void main(String[] args) throws Exception{
        BlockingQueue <String> pool=new LinkedBlockingQueue<>();

        //start 2 agents
        ParkingAgent1 a1=new ParkingAgent1(1, pool);
        ParkingAgent1 a2=new ParkingAgent1(2, pool);

        a1.start();
        a2.start();

        //simulate cars arriving
        String[] cars={"ABC123","XYZ456","CAR789"};
        for(String car:cars){
            System.out.println("Car "+car+" requested parking");
            pool.put(car);
        }
        //stop agents
        pool.put("STOP");
        pool.put("STOP");
    }
}
