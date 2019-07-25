import java.io.*;
import java.util.*;
import edu.duke.*;
/**
 * Write a description of WordFreqsHashMao here.
 * 
 * @Akshaya Balaji (your name) 
 * @July 23,2019 (a version number or a date)
 */
public class WordFrequenciesMap {
    
    private HashMap<String,Integer> myMaps; 
    private int totalCount;
    public WordFrequenciesMap()
    {
        myMaps = new HashMap<String,Integer>();
        totalCount=0;
    }
    
    public void countWordsMap()
    {
        FileResource resource = new FileResource();        
        for(String w:resource.words())
        {
            w=w.toLowerCase();
            totalCount++;
            if(!myMaps.containsKey(w))
            {
                myMaps.put(w,1);
            }
            else
            {
                myMaps.put(w,myMaps.get(w)+1);
            }
        }
    }
    
    public void printWords()
    {
        for(String s:myMaps.keySet())
        {
            System.out.println(myMaps.get(s)+"\t"+s);
        }
        System.out.println("Total number of words: "+ totalCount);
    }
    
    public static void main(String args[])
    {
        WordFrequenciesMap obj = new WordFrequenciesMap();
        obj.countWordsMap();
        obj.printWords();
        obj.totalCount=0;
        obj.myMaps.clear();
        
    }
    

}
