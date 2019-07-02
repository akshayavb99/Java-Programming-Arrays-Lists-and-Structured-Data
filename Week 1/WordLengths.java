import edu.duke.*;
import java.io.*;
import java.util.*;

/**
 * Write a description of WordLength here.
 * 
 * @Akshaya Balaji (your name) 
 * @June 23,2019 (a version number or a date)
 */
public class WordLengths {
    
    //This method should read in the words from resource and count the number of words of each length for all the words in resource, storing these counts in the array counts.
    public static void countWordLengths (FileResource resource, int[] count)
    {
        for (String w:resource.words())
        {
            boolean check1=Character.isLetter(w.charAt(0));
            boolean check2=Character.isLetter(w.charAt(w.length()-1));
            int l=-1;
            if ((check1==true) && (check2==true))
            {
                l=w.length();
            }
            else if ((check1==false) && (check2==true))
            {
                l=w.length()-1;              
            }
            else if ((check1==true) && (check2==false))
            {
                l=w.length()-1; 
            }
            else if ((check1==false) && (check2==false))
            {
                l=w.length()-2;
            }
            if (l>0)
            {
                count[l-1]+=1;
            }
            
        }        
        
        for (int i=0;i<count.length;i++)
        {
            System.out.println("Number of words of length "+(i+1)+": "+count[i]);
        }
        System.out.println(" ");
    }
    
    public static void testCountWordsLength()
    {
        int count[]=new int[29];
        FileResource fr = new FileResource();
        countWordLengths(fr, count);
    }
    
    public static void main(String args[])
    {
        testCountWordsLength();
    }

}
