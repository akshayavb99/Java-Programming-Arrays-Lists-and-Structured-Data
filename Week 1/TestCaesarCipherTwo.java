import java.io.*;
import java.util.*;
import edu.duke.*;
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @Akshaya Balaji (your name) 
 * @July 11,2019 (a version number or a date)
 */
public class TestCaesarCipherTwo {
    
    public String halfOfString(String message,int start)
    {
        StringBuilder sb = new StringBuilder("");
        for (int i=start;i<message.length();i=i+2)
        {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }
    
    public int findKey(String str)
    {
        int[] count = new int[26];
        int maxcount=-1;
        for (int i=0;i<26;i++)
        {
            count[i]=0;
        }
        for (int i=0;i<str.length();i++)
        {
            char c=Character.toLowerCase(str.charAt(i));
            if (Character.isAlphabetic(c))
            {
                int index=(int)c-97;
                count[index]++;
            }
        }
        char cmax=' ';
        int maxindex=-1;
        for (int i=97;i<123;i++)
        {
            //System.out.println((char)i+": "+count[i-97]);
            if (maxcount<count[i-97])
            {
                maxcount=count[i-97];
                cmax=(char)i;
                maxindex=i-97;
            }
                
        }
        System.out.println("Character with maximum count is: "+cmax+" and the count value is: "+maxcount);
        System.out.println("Index is at: "+maxindex);
        System.out.println(" ");
        return maxindex;
    }
    
    public void simpleTests()
    {
        FileResource fr = new FileResource();
        String input=fr.asString();
        CaesarCipherTwo obj = new CaesarCipherTwo(17,3);
        String encrypted=obj.encrypt(input);
        System.out.println(encrypted);
        System.out.println(" ");
        System.out.println(obj.decrypt(encrypted));
    }

}
