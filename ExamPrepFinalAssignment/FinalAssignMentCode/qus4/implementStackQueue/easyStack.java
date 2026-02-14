// package ExamPrepFinalAssignment.FinalAssignMentCode.qus4.implementStackQueue;

import java.util.PriorityQueue;

public class easyStack {
    static int counter=0;
    public static void main(String[] args) {
        PriorityQueue <int[]> stack=new PriorityQueue<>((a,b) ->b[1]-a[1]);

        //push
       
        stack.add(new int[]{10,counter++});
        stack.add(new int[]{20,counter++});
        stack.add(new int[]{30,counter++});
        stack.add(new int[]{40,counter++});


        //pop
        System.out.println(stack.poll()[0]); //40
        System.out.println(stack.poll()[0]); //30
        System.out.println(stack.poll()[0]); //20
        System.out.println(stack.poll()[0]); //10
    }
}
