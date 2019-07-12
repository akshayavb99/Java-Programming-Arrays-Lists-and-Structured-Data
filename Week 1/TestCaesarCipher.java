import java.io.*;
import java.util.*;
import edu.duke.*;
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @Akshaya Balaji (your name) 
 * @July 09,2019 (a version number or a date)
 */
public class TestCaesarCipher {
    
    
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
    
    public void breakCaesarCipher(String input)
    {
        System.out.println("Finding the key first when considering e to be most commonly occuring character....");
        int maxidx=findKey(input);
        int dkey=maxidx-4; //Encryption Key
        if (dkey>0)
        {
            dkey=26-dkey;
        }
        else
        {
            dkey=-dkey;
        }
        
        /*int maxindex=findKey(input);
        int dkey=maxindex-4;
        if (maxindex<4)
        {
            dkey=26-(4-maxindex);
        }*/
        CaesarCipherEncapsulation obj = new CaesarCipherEncapsulation(dkey);
        System.out.println("Key for decryption: "+ dkey);
        String decrypted=obj.encrypt(input);
        System.out.println("Decrypting....");
        System.out.println("Decrypted String is: "+decrypted);
    }
    
    public void simpleTests()
    {
        FileResource fr = new FileResource();
        String input=fr.asString();
        //Scanner scan = new Scanner(System.in);
        //String input=scan.nextLine();
        /*CaesarCipherEncapsulation obj = new CaesarCipherEncapsulation(18);
        String encrypted=obj.encrypt(input);
        System.out.println("Encrypted String is: "+encrypted);
        System.out.println("Decrypted String is: "+obj.decrypt(encrypted));
        System.out.println(" ");*/
        TestCaesarCipher obj1 = new TestCaesarCipher();
        obj1.breakCaesarCipher(input);
        //scan.close();
    }

}
