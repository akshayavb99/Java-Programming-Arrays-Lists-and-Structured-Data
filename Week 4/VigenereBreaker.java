import edu.duke.*;
import java.io.*;
import java.util.*;
/**
 * Write a description of VignereBreaker here.
 * 
 * @author Akshaya Balaji 
 * @version July 30,2019
 */
public class VigenereBreaker {

    public String sliceString(String message, int whichSlice, int totalSlices) {
        String sliced = "";
        for (int i = whichSlice; i < message.length(); i += totalSlices) {
            char letter = message.charAt(i);
            sliced += letter;
        }
        return sliced;
    }
    
    public void testSliceString() {
        System.out.println(sliceString("abcdefghijklm", 0, 3).equals("adgjm"));
        System.out.println(sliceString("abcdefghijklm", 1, 3).equals("behk"));
        System.out.println(sliceString("abcdefghijklm", 2, 3).equals("cfil"));
        System.out.println(sliceString("abcdefghijklm", 0, 4).equals("aeim"));
        System.out.println(sliceString("abcdefghijklm", 1, 4).equals("bfj"));
        System.out.println(sliceString("abcdefghijklm", 2, 4).equals("cgk"));
        System.out.println(sliceString("abcdefghijklm", 3, 4).equals("dhl"));
        System.out.println(sliceString("abcdefghijklm", 0, 5).equals("afk"));
        System.out.println(sliceString("abcdefghijklm", 1, 5).equals("bgl"));
        System.out.println(sliceString("abcdefghijklm", 2, 5).equals("chm"));
        System.out.println(sliceString("abcdefghijklm", 3, 5).equals("di"));
        System.out.println(sliceString("abcdefghijklm", 4, 5).equals("ej"));
    }

    
    public int[] tryKeyLength(String encrypted, int len, char mostCommon) {
        int[] key = new int[len];
        for (int i = 0; i < len; i++) {
            String sliced = sliceString(encrypted, i, len);
            CaesarCracker cc = new CaesarCracker(mostCommon);
            key[i] = cc.getKey(sliced);
        }
        return key;
    }
    
    public void testTryKeyLength() {
        FileResource fr = new FileResource("athens_keyflute.txt");
        String message = fr.asString();
        int len = "flute".length();
        int[] key = tryKeyLength(message, len, 'e'); 
    }
    
    
    public void breakVigenere() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int[] key = tryKeyLength(message, 4, 'e');
        VigenereCipher vc = new VigenereCipher(key);
        String decrypted = vc.decrypt(message);
        for (int i:key)
        {
            System.out.println(i+",");
        }
        //System.out.println(decrypted);
    }

}
