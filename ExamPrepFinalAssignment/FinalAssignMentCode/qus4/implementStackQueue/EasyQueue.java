// package ExamPrepFinalAssignment.FinalAssignMentCode.qus4.implementStackQueue.java;

import java.util.PriorityQueue;

public class EasyQueue {
    static int counter=0;
    public static void main(String[] args) {
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b) ->a[1]-b[1]);//FIFO
         
        // enqueue
        queue.add(new int[]{10,counter++});
        queue.add(new int[]{20,counter++});
        queue.add(new int[]{30,counter++});
        queue.add(new int[]{40,counter++});


        //dequeue
        System.out.println(queue.poll()[0]); //10
        System.out.println(queue.poll()[0]); //20
        System.out.println(queue.poll()[0]); //30
        System.out.println(queue.poll()[0]); //40
        // System.out.println(queue.poll()[0]);

    }
}
