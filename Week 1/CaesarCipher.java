import java.io.*;
import java.util.*;
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    
    public static String encrypt(String str,int key)
    {
        String encryp="";
        //str=str.toUpperCase();
        String orig_str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String orig_str_2="abcdefghijklmnopqrstuvwxyz";
        String new_str=orig_str.substring(key)+orig_str.substring(0,key);
        String new_str_2=orig_str_2.substring(key)+orig_str_2.substring(0,key);
        System.out.println(new_str);
        System.out.println(new_str_2);
        System.out.println("");
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
    
    public static String encrypted_sb(StringBuilder sb, int key)
    {
        String orig_str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String orig_str_2="abcdefghijklmnopqrstuvwxyz";
        String new_str=orig_str.substring(key)+orig_str.substring(0,key);
        String new_str_2=orig_str_2.substring(key)+orig_str_2.substring(0,key);
        
        for (int i=0;i<(sb.toString()).length();i++)
        {
            char c = sb.charAt(i);
            if (c!=' ' && Character.isAlphabetic(c))
            {
                if (Character.isLowerCase(c))
                {
                    int index = orig_str_2.indexOf(c);
                    sb.setCharAt(i,new_str_2.charAt(index));
                }
                else
                {
                  int index = orig_str.indexOf(c);
                  sb.setCharAt(i,new_str.charAt(index));
                }
                
            }
            System.out.println("Latest string is: "+sb.toString());
            
        }
        return sb.toString();
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
                if (c!=' ' && Character.isAlphabetic(c))
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
                
            }
            else
            {
                if (c!=' ' && Character.isAlphabetic(c))
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
        }
    }
    return sb.toString();
}
  
  public static int findKey (String str)
  {
      int count[]=new int[26];
      int max=-1;
      String alpha="abcdefghijklmnopqrstuvwxyz";
      str=str.toLowerCase();
      
      for (int i=0;i<str.length();i++)
      {
          int c=(int)str.charAt(i);
          inner: for (int j=97;j<123;j++)
          {
              if (c==j)
              {
                  count[j-97]+=1;
                  break inner;
                }
            }
        }
        
      for (int i=0;i<count.length;i++)
      {
          //System.out.println(alpha.charAt(i)+": "+count[i]);
          if (max<count[i])
            max=i;
          }
        
      return max;
      
    }
    
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string to be encrypted: ");
        String str=scan.nextLine();
        //scan.nextLine();
        //System.out.println("Enter the key: ");
        //int key=scan.nextInt();
        int key=findKey(str);
        StringBuilder sb = new StringBuilder(str);
        //String encryp_str=encrypted_str(str,key);
        //String encryp_str=encryptTwoKeys(str,8,21);
        System.out.println("The key is: "+key);
        String encryp_str=encrypted_sb(sb,key);
        System.out.println("The encrypted string is: "+encryp_str);
    }

}
