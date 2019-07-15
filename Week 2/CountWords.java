import java.io.*;
import java.util.*;
import edu.duke.*;
/**
 * Write a description of CountWords here.
 * 
 * @Akshaya Balaji (your name) 
 * @July 15,2019 (a version number or a date)
 */
public class CountWords {
    
    StorageResource myWords;
    
    //Initialisation with constructor
    public CountWords()
    {
        myWords=new StorageResource();
    }
    
    //getCount() - returns the total number of words stored in the StorageResource myWords
    public int getCount()
    {
        return myWords.size();
    }
    
    public void readWords(String source)
    {
        myWords.clear();
        if (source.startsWith("http"))
        {
            URLResource resource=new URLResource(source);
            for(String word:resource.words())
            {
                myWords.add(word.toLowerCase());
            }
        }
        else
        {
            FileResource resource = new FileResource(source);
            for(String word:resource.words())
            {
                myWords.add(word.toLowerCase());
            }
        }
    }
    
    public static void main(String args[])
    {
        CountWords obj = new CountWords();
    }

}
