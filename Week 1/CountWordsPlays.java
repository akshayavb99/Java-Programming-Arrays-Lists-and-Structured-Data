import edu.duke.*;
import java.io.*;
import java.util.*;
/**
 * Write a description of CountWordsPlays here.
 * 
 * @Akshaya Balaji (your name) 
 * @June 23, 2019 (a version number or a date)
 */
public class CountWordsPlays {
    
    public static void commonWords(FileResource fr, String[] words)
    {
        int i=0;
        for (String w:fr.words())
        {
            words[i]=w;
            i=i+1;
        }
        
        /*for (i=0;i<words.length;i++)
        {
            System.out.println((i+1)+"th word: "+words[i]);
        }*/
        
    }
    
    public static void countWords(FileResource fr,String[] words,int[] count)
    {
        for (String w: fr.words())
        {
            String check=w;
            int index=-1;
            P: for (int i=0;i<words.length;i++)
            {
                if (check.equalsIgnoreCase(words[i]))
                {
                    index=i;
                    break P;
                }
            }
            if (index!=-1)
            {
                count[index]+=1;
            }
            
        }
    }
    
    public static void main(String args[])
    {
        int count[]=new int[20];
        FileResource rf = new FileResource("D:\\Java Online Course 2 Duke Uni\\Week 1\\Week1Pgms\\common.txt");
        String words[]=new String[20];
        commonWords(rf,words);
        
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            countWords(fr,words,count);
            System.out.println(f.getName()+" is done!");
            
        }
        System.out.println(" ");
        for (int i=0;i<20;i++)
        {
            System.out.println(words[i]+": "+count[i]);
        }
    }

}
