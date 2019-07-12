import java.io.*;
import java.util.*;
/**
 * Write a description of CaesarCipherEncapsulation here.
 * 
 * @Akshaya Balaji (your name) 
 * @July 09,2019 (a version number or a date)
 */
public class CaesarCipherEncapsulation {
    
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipherEncapsulation(int key)
    {
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        //System.out.println(shiftedAlphabet);
        mainKey=key;
    }
    
    public String encrypt(String input)
    {
        StringBuilder sb=new StringBuilder(input);
        
        for (int i=0;i<sb.length();i++)
        {
            char c = sb.charAt(i);
            if (Character.isAlphabetic(c)==true)
            {
                 if (Character.isUpperCase(c))
                {
                    int index = alphabet.indexOf(c);
                    //System.out.println(index);
                    //System.out.println(c);
                    sb.setCharAt(i,shiftedAlphabet.charAt(index));
                }
                else
                {
                  int index = alphabet.indexOf(Character.toUpperCase(c));
                  sb.setCharAt(i,Character.toLowerCase(shiftedAlphabet.charAt(index)));  
                }
            }            
        }
        
        /*for (int i=0;i<sb.length();i++)
        {
            char c=sb.charAt(i);
            int idx=alphabet.indexOf(c);
            System.out.println(idx);
            if (idx!=-1)
            {
                if (Character.isAlphabetic(c))
                {
                    if (Character.isUpperCase(c))
                    {
                        c=shiftedAlphabet.charAt(idx);
                    }
                    else
                    {
                        c=Character.toLowerCase(shiftedAlphabet.charAt(idx));
                    }
                }
                else
                {
                }
                c=shiftedAlphabet.charAt(idx);
                System.out.println(c);
                sb.setCharAt(i,c);
            }
        }*/
        return sb.toString();
    }
    
    public String decrypt(String encrypted)
    {
        int dkey=mainKey-4;
        if (mainKey<4)
        {
            dkey=26-(4-mainKey);
        }
        CaesarCipherEncapsulation decryptobj=new CaesarCipherEncapsulation(26-mainKey);
        return decryptobj.encrypt(encrypted);
    }
    
    public static void main(String args[])
    {
        Scanner scan  = new Scanner(System.in);
        System.out.println("Enter the key: ");
        int key=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the string: ");
        String input=scan.nextLine();
        
        CaesarCipherEncapsulation obj = new CaesarCipherEncapsulation(key);
        System.out.println(obj.decrypt(input));
        scan.close();
        }

}
