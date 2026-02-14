// package ExamPrepFinalAssignment.FinalAssignMentCode.qus4;

import java.util.ArrayList;
import java.util.Collections;

public class kthSmallestElementUsingArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(7);
        list.add(10);
        list.add(4);
        list.add(3);
        list.add(20);
        list.add(15);

        int k=3;//3rd smallest element
        // for(int i=0;i<list.size();i++){
        //     System.out.println(list.get(i));
        // }
        Collections.sort(list); //sort ascending order in arraylist
        int kthSmallest=list.get(k-1);
        System.out.println(k+"-th smallest element is : "+kthSmallest);
    }
}
