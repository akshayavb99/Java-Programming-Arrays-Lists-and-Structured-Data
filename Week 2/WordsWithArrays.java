import java.io.*;
import java.util.*;
import edu.duke.*;
/**
 * Program to find the number of unique words in a file using arrays
 * 
 * @Akshaya Balaji (your name) 
 * @July 16,2019 (a version number or a date)
 */
public class WordsWithArrays {
    
    StorageResource myWords;  
    
    public WordsWithArrays()
    {
        myWords = new StorageResource();
    }
    
    public void readWords()
    {
        myWords.clear();
        FileResource resource = new FileResource();
        for(String word:resource.words())
        {
                myWords.add(word.toLowerCase());
        }
    }
    
    
    public boolean contains(String[] list, String word, int num)
    {
        for (int i=0;i<num;i++)
        {
            if (list[i].equals(word))
            {
                return true;
            }
        }
        return false;
    }
    
    public int numberOfUniqueWords()
    {
        int numStored=0;
        String[] words = new String[myWords.size()];
        for(String s : myWords.data())
        {
            if(! contains(words,s,numStored))
            {
                words[numStored]=s;
                numStored++;
            }
        }
        return numStored;
    }
    
    public void tester()
    {
        readWords();
        System.out.println("Number of words read: "+myWords.size());
        int unique=numberOfUniqueWords();
        System.out.println("Number of unique words: "+unique);
    }
    
    public static void main(String args[])
    {
        WordsWithArrays obj = new WordsWithArrays();
        obj.tester();
    }

}
