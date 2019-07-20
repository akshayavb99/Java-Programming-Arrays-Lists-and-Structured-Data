import java.io.*;
import java.util.*;
import edu.duke.*;
/**
 * Write a description of CharactersInPlay here.
 * 
 * @Akshaya Balaji (your name) 
 * @July 20,2019 (a version number or a date)
 */
public class CharactersInPlay {
    
    private ArrayList<String> charNames;
    private ArrayList<Integer> charCount;
    
    public CharactersInPlay()
    {
        charNames=new ArrayList<String>();
        charCount=new ArrayList<Integer>();
    }
    
    public void update(String person)
    {
        if (!charNames.contains(person))
        {
            charNames.add(person);
            charCount.add(1);
        }
        else
        {
            int idx=charNames.indexOf(person);
            int val=charCount.get(idx);
            charCount.set(idx,val+1);
        }
    }
    
    public void findAllCharacters()
    {
        FileResource fr = new FileResource();
        for (String line : fr.lines())
        {
            int index=line.indexOf(".");
            if (index!=-1)
            {
                String l=line.substring(0,index);
                //System.out.println(l);
                update(l);
            }            
        }
        
    }
    
    public void charactersWithNumParts2(int num1,int num2)
    {
        for (int i=0;i<charNames.size();i++)
        {
            int val=charCount.get(i);
            if (val>=num1 && val<=num2)
            {
                System.out.println(charNames.get(i)+" : "+val);
            }
        }
        
    }
    
    public void tester()
    {
        findAllCharacters();
        /*for (int i=0;i<charNames.size();i++)
        {
            int val=charCount.get(i);
            if (val>=2)
            {
                System.out.println(charNames.get(i)+" : "+val);
            }
        }*/
        charactersWithNumParts2(10,15);
    }

}
