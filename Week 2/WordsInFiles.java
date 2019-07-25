import java.io.*;
import java.util.*;
import edu.duke.*;

/**
 * Write a description of WordsInFiles here.
 * 
 * @Akshaya Balaji (your name) 
 * @July 24,2019 (a version number or a date)
 */
public class WordsInFiles {
    
    private HashMap<String,ArrayList<String>> wordsCount;
    private ArrayList<String> maxwords;
    public WordsInFiles()
    {
        wordsCount=new HashMap<String,ArrayList<String>>();
        maxwords=new ArrayList<String>();
    }
    
    private void addWordsFromFile(File f)
    {
        FileResource fr = new FileResource(f);
        for (String word: fr.words())
        {
            if (wordsCount.containsKey(word))
            {
                ArrayList<String> arr=wordsCount.get(word);
                arr.add(f.getName());
                wordsCount.put(word,arr);
            }
            else
            {
                ArrayList<String> arr=new ArrayList<String>();
                arr.add(f.getName());
                wordsCount.put(word,arr);
            }
        }
    }
    
    public void buildWordFileMap()
    {
        wordsCount.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f:dr.selectedFiles())
        {
            addWordsFromFile(f);
        }
    }
    
    public int maxNumber()
    {
        int maxcount=0;
        for (String word:wordsCount.keySet())
        {
            ArrayList<String> arr=wordsCount.get(word);
            int arr_size=arr.size();
            if (maxcount<arr_size)
            {
                maxcount=arr_size;
            }
        }
        maxcount=4;
        for (String word:wordsCount.keySet())
        {
            ArrayList<String> arr=wordsCount.get(word);
            int arr_size=arr.size();
            if (maxcount==arr_size)
            {
                maxwords.add(word);
            }
        }
        
        return maxcount;
    }
    
    public ArrayList<String> wordsInNumFiles(int number)
    {
        ArrayList<String> words_arr=new ArrayList<String>();
        for (String word:wordsCount.keySet())
        {
            ArrayList<String> arr=wordsCount.get(word);
            int arr_size=arr.size();
            if (arr_size==number)
            {
                words_arr.add(word);
            }
        }
        return words_arr;
    }
    
    public void printFilesIn(String word)
    {
        ArrayList<String> arr=wordsCount.get(word);
        System.out.print("Files in which "+word+" is present: ");
        for (String s:arr)
        {
            System.out.print(s+", ");            
        }
        System.out.println(" ");
    }
    
    public void tester()
    {
        buildWordFileMap();
        int maxnum=maxNumber();
        //System.out.println("Maximum number of files any word is in: "+maxNumber());
        /*for (String s:maxwords)
        {
            //System.out.print("Files in which "+s+" is present: ");
            printFilesIn(s);
        }*/
        printFilesIn("tree");
        System.out.println ("Number of words in "+maxnum+" of files is: "+wordsInNumFiles(maxnum).size());
    }

}
