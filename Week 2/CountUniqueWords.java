import java.io.*;
import java.util.*;
import edu.duke.*;
/**
 * Write a description of CountUniqueWords here.
 * 
 * @Akshaya Balaji (your name) 
 * @July 15,2019 (a version number or a date)
 */
public class CountUniqueWords {
    
    StorageResource myWords;
    
    public CountUniqueWords()
    {
        myWords = new StorageResource();        
    }
    
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
                if (!myWords.contains(word.toLowerCase()))
                    myWords.add(word.toLowerCase());
            }
        }
        else
        {
            FileResource resource = new FileResource(source);
            for(String word:resource.words())
            {
                if (!myWords.contains(word.toLowerCase()))
                    myWords.add(word.toLowerCase());
            }
        }
    }
    
    public static void main(String args[])
    {
        CountUniqueWords obj = new CountUniqueWords();
    }

}
