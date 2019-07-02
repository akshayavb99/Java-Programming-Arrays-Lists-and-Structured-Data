import java.io.*;
import java.util.*;
import edu.duke.*;
/**
 * Write a description of DecryptCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DecryptCipher {
    
    public static int countFreq(String str)
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
    public static String encrypt(String str,int key)
    {
        String encryp="";
        //str=str.toUpperCase();
        String orig_str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String orig_str_2="abcdefghijklmnopqrstuvwxyz";
        String new_str=orig_str.substring(key)+orig_str.substring(0,key);
        String new_str_2=orig_str_2.substring(key)+orig_str_2.substring(0,key);
        //System.out.println(new_str);
        //System.out.println(new_str_2);
        //System.out.println("");
        for (int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)==false)
            {
                encryp=encryp+c;
            }
            else
            {
                if (Character.isLowerCase(c))
                {
                    int index = orig_str_2.indexOf(c);
                    encryp=encryp+new_str_2.charAt(index);
                }
                else
                {
                  int index = orig_str.indexOf(c);
                  encryp=encryp+new_str.charAt(index);  
                }
                
            }
            
        }
        return encryp;
    }
    
    public static String encryptTwoKeys(String input, int key1, int key2)
    {
        String orig_str_cap="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String orig_str_low="abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb=new StringBuilder(input);
        
        String new_str_cap_1=orig_str_cap.substring(key1)+orig_str_cap.substring(0,key1);
        String new_str_low_1=orig_str_low.substring(key1)+orig_str_low.substring(0,key1);
        
        String new_str_cap_2=orig_str_cap.substring(key2)+orig_str_cap.substring(0,key2);
        String new_str_low_2=orig_str_low.substring(key2)+orig_str_low.substring(0,key2);
        
        for (int i=0;i<input.length();i++)
        {
            char c = sb.charAt(i);
            if (i%2==0)
            {
                if (Character.isAlphabetic(c))
                {
                    if (Character.isLowerCase(c))
                    {
                        int index = orig_str_low.indexOf(c);
                        sb.setCharAt(i,new_str_low_1.charAt(index));
                    }
                    else
                    {
                        int index = orig_str_cap.indexOf(c);
                        sb.setCharAt(i,new_str_cap_1.charAt(index));
                    }
                
                }
                else
                {
                    sb.setCharAt(i,c);
                }
                
            }
            else
            {
                if (Character.isAlphabetic(c))
                {
                    if (Character.isLowerCase(c))
                    {
                        int index = orig_str_low.indexOf(c);
                        sb.setCharAt(i,new_str_low_2.charAt(index));
                    }
                    else
                    {
                        int index = orig_str_cap.indexOf(c);
                        sb.setCharAt(i,new_str_cap_2.charAt(index));
                    }
                }
                else
                {
                    sb.setCharAt(i,c);
                }
        }
    }
    return sb.toString();
}
    
    public static void eyeballCipher(String encrypted)
    {
        String decrypted="";
        for (int k=1;k<26;k++)
        {
            decrypted=encrypt(encrypted,k);
            System.out.println("Iteration for key "+k+": "+decrypted);
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static String decrypt(String encrypted)
    {
        int maxindex=countFreq(encrypted);
        int dkey=maxindex-4;
        if (maxindex<4)
        {
            dkey=26-(4-maxindex);
        }
        return encrypt(encrypted,26-dkey);
    }
    
    public static String halfOfString(String message,int start)
    {
        StringBuilder sb = new StringBuilder("");
        for (int i=start;i<message.length();i=i+2)
        {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }
    
    public static String decryptTwoKeys(String encrypted)
    {
        String decrypted="";
        String firstchar=halfOfString(encrypted,0);
        String secchar=halfOfString(encrypted,1);
        int firstkey=countFreq(firstchar);
        int seckey=countFreq(secchar);
        
        int dkey1=firstkey-4;
        if (firstkey<4)
        {
            dkey1=26-(4-firstkey);
        }
        
        int dkey2=seckey-4;
        if (seckey<4)
        {
            dkey2=26-(4-seckey);
        }
        System.out.println("Keys for decryption are: "+dkey1+" "+dkey2);
        decrypted=encryptTwoKeys(encrypted,26-dkey1,26-dkey2);
        System.out.println("");
        return decrypted;
    }
    
    public static void testDecrypt()
    {
        FileResource fr = new FileResource();
        for (String txt:fr.lines())
        {
            System.out.println("String to be decrypted: "+txt);
            System.out.println("Decrypted String is: "+decryptTwoKeys(txt));
        }
    }
    
    public static void testEncrypt()
    {
        FileResource fr = new FileResource();
        for (String txt:fr.lines())
        {
            System.out.println("String to be encrypted is: "+txt);
            System.out.println("Counting the occurences of each letter in text");
            int maxindex=countFreq(txt);
            String encrypted=encrypt(txt,maxindex);
            System.out.println("Encrypted String is: "+encrypted);
            System.out.println("Assuming letter e is most commonly occuring letter in English,");
            System.out.println("Decrypted String is: "+decrypt(encrypted));
        }
        
    }

    public static void main(String args[])
    {
        
        /*Scanner scan = new Scanner(System.in);
        String input=scan.nextLine();*/
        /*System.out.println("Counting the occurences of each letter in text");
        int maxindex=countFreq(input);
        String encrypted=encrypt(input,maxindex);
        System.out.println("Encrypted String is: "+encrypted);
        System.out.println("Assuming letter e is most commonly occuring letter in English,");
        System.out.println("Decrypted String is: "+decrypt(encrypted));*/
    }
}
