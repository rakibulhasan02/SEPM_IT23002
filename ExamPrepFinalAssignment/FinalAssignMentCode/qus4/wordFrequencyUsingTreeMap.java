// package ExamPrepFinalAssignment.FinalAssignMentCode.qus4;

import java.util.TreeMap;

public class wordFrequencyUsingTreeMap {
    public static void main(String[] args) {
        String text="java is easy and java is powerful";

        // create treeMap
        TreeMap <String,Integer> wordCount=new TreeMap<>();

        // split text into words
        String[] words=text.split(" ");

        for(String word:words){
            System.out.println(word); //java is easy and java is powerful
            if(wordCount.containsKey(word)){
                wordCount.put(word,wordCount.get(word)+1);
            }
            else{
                wordCount.put(word,1);
            }
        }
        // System.out.println(words);

        System.out.println(wordCount);
    }
}
