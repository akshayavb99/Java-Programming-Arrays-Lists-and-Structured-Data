import java.io.*;
import java.util.*;
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    
    public static String encrypted_str(String str,int key)
    {
        String encryp="";
        str=str.toUpperCase();
        String orig_str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String new_str=orig_str.substring(key)+orig_str.substring(0,key);
        System.out.println(new_str);
        for (int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);
            if (c==' ')
            {
                encryp=encryp+" ";
            }
            else
            {
                int index = orig_str.indexOf(c);
                encryp=encryp+new_str.charAt(index);
            }
            
        }
        return encryp;
    }
    
    public static String encrypted_sb(StringBuilder sb, int key)
    {
        String orig_str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String new_str=orig_str.substring(key)+orig_str.substring(0,key);
        for (int i=0;i<(sb.toString()).length();i++)
        {
            char c = sb.charAt(i);
            if (c!=' ')
            {
                int index=orig_str.indexOf(c);
                sb.setCharAt(i,new_str.charAt(index));
            }
            
        }
        return sb.toString();
    }
    
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string to be encrypted: ");
        String str=scan.nextLine();
        //scan.nextLine();
        System.out.println("Enter the key: ");
        int key=scan.nextInt();
        StringBuilder sb = new StringBuilder(str);
        //String encryp_str=encrypted_str(str,key);
        String encryp_str=encrypted_sb(sb,key);
        System.out.println("The encrypted string is: "+encryp_str);
    }

}
