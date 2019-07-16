import java.io.*;
import java.util.*;
import edu.duke.*;
/**
 * Write a description of WordFrequencies here.
 * 
 * @Akshaya Balaji (your name) 
 * @July 16,2019 (a version number or a date)
 */
public class WordFrequencies {
    
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies()
    {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique()
    {
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for (String s : fr.words())
        {
            s=s.toLowerCase();
            int index=myWords.indexOf(s);
            if (index==-1)
            {
                myWords.add(s);
                myFreqs.add(1);
            }
            else
            {
                int val=myFreqs.get(index);
                myFreqs.set(index,val+1);
            }
        }
    }
    
    public int findIndexOfMax()
    {
        int maxidx=-1;
        int maxval=0;
        for (int i=0;i<myFreqs.size();i++)
        {
            int val=myFreqs.get(i);
            if(maxval<val)
            {
                maxval=val;
                //System.out.println("Index value changed from "+maxidx+" to "+val);
                //System.out.println(" ");
                maxidx=i;
            }
        }
        System.out.println("Word with maximum count: "+myWords.get(maxidx));
        System.out.println("Count of maximum occuring word: "+maxidx);
        return maxidx;
        
    }
    
    public void tester()
    {
        findUnique();
        System.out.println("No. of unique words: "+myWords.size());
        for (int i=0;i<myWords.size();i++)
        {
            System.out.println(myWords.get(i)+" : "+myFreqs.get(i));
        }
        System.out.println(" ");
        findIndexOfMax();
    }
      
    
    public static void main(String args[])
    {
        WordFrequencies obj = new WordFrequencies();
        obj.tester();
    }
    
    

}
