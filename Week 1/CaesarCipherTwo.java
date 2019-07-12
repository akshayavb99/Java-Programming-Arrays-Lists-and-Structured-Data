import java.io.*;
import java.util.*;
import edu.duke.*;
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @Akshaya Balaji (your name) 
 * @July 10,2019 (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1, int key2)
    {
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedAlphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);
        mainKey1=key1;
        mainKey2=key2;
    }
    
    
    
    public String encrypt(String input)
    {
        StringBuilder sb=new StringBuilder(input);        
        for (int i=0;i<input.length();i++)
        {
            char c = sb.charAt(i);
            //System.out.println("Original Alphabet: "+c);
            if (i%2==0)
            {
                if (Character.isAlphabetic(c))
                {
                    if (Character.isUpperCase(c))
                    {
                        int index = alphabet.indexOf(c);
                        //System.out.println("Index: "+index);
                        sb.setCharAt(i,shiftedAlphabet1.charAt(index));
                        //System.out.println("Character shifted to: "+shiftedAlphabet1.charAt(index));
                        //System.out.println(" ");
                    }
                    else
                    {
                        int index = alphabet.indexOf(Character.toUpperCase(c));
                        //System.out.println("Index: "+index);
                        sb.setCharAt(i,Character.toLowerCase(shiftedAlphabet1.charAt(index)));
                        //System.out.println("Character shifted to: "+Character.toLowerCase(shiftedAlphabet1.charAt(index)));
                        //System.out.println(" ");
                    }
                
            }
                
            }
            else
            {
                if (Character.isAlphabetic(c))
                {
                    if (Character.isUpperCase(c))
                    {
                        int index = alphabet.indexOf(c);
                        //System.out.println("Index: "+index);
                        sb.setCharAt(i,shiftedAlphabet2.charAt(index));
                        //System.out.println("Character shifted to: "+shiftedAlphabet2.charAt(index));
                        //System.out.println(" ");
                    }
                    else
                    {
                        int index = alphabet.indexOf(Character.toUpperCase(c));
                        //System.out.println("Index: "+index);
                        sb.setCharAt(i,Character.toLowerCase(shiftedAlphabet2.charAt(index)));
                        //System.out.println("Character shifted to: "+Character.toLowerCase(shiftedAlphabet1.charAt(index)));
                        //System.out.println(" ");
                    }
            }
        }
    }
    
    //System.out.println("Encrypted String is: "+sb.toString());
    System.out.println(" ");
    return sb.toString();
    
    }
    
    public String decrypt(String encrypted)
    {
        String decrypted="";        
        int dkey1=mainKey1-4; //Encryption Key 1
        if (dkey1>0)
        {
            dkey1=26-dkey1;
        }
        else
        {
            dkey1=-dkey1;
        }
        
        int dkey2=mainKey2-4; //Encryption Key 2
        if (dkey2>0)
        {
            dkey2=26-dkey2;
        }
        else
        {
            dkey2=-dkey2;
        }
        System.out.println("Keys for decryption are: "+dkey1+" "+dkey2);
        CaesarCipherTwo obj = new CaesarCipherTwo(dkey1,dkey2);
        decrypted=obj.encrypt(encrypted);
        System.out.println("Decrypted String is: "+decrypted);
        System.out.println("");
        return decrypted;
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
        CaesarCipherTwo obj1 = new CaesarCipherTwo(23,2);
        obj1.decrypt(input);
        //scan.close();
    }
    
    
    
    

}
