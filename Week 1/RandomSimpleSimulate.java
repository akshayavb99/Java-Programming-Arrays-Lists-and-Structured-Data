import java.io.*;
import java.util.*;
/**
 * Write a description of RandomSimpleSimulate here.
 * 
 * @Akshaya Balaji (your name) 
 * @June 23,2019 (a version number or a date)
 */
public class RandomSimpleSimulate {
    
    public static void simpleSimulate(int times)
    {
        Random rand = new Random();
        int count[]=new int[11];
        double prob[]=new double[11];
        for (int i=0;i<times;i++)
        {
            int throw1=rand.nextInt(6)+1;
            int throw2=rand.nextInt(6)+1;
            System.out.println("Throw 1: "+throw1);
            System.out.println("Throw 2:"+throw2);
            System.out.println(" ");
            count[throw1+throw2-2]+=1;
        }
        
        for (int i=0;i<11;i++)
        {
            prob[i]=count[i]/(double)times;
        }
        
        for (int i=0;i<11;i++)
        {
            System.out.println("Number of occurences of "+(i+2)+": "+count[i]);
            System.out.println("Probability of occurence of "+(i+2)+": "+prob[i]);
            System.out.println(" ");
        }
    }
    
    public static void main(String args[])
    {
        
    }

}
