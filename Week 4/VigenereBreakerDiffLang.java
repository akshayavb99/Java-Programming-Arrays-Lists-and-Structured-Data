import java.io.*;
import java.util.*;
import edu.duke.*;
/**
 * Write a description of VigenereBreakerDiffLang here.
 * 
 * @author Akshaya Balaji 
 * @version July 30,2019
 */
public class VigenereBreakerDiffLang {
    
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
    };

   
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
        FileResource fr = new FileResource("VigenereTestData/athens_keyflute.txt");
        String message = fr.asString();
        int klength = "flute".length();
        int[] key = tryKeyLength(message, klength, 'e');  // [5, 11, 20, 19, 4]
    }
    
    /**
     * Put everything together, so that you can create a new VigenereBreaker in BlueJ, 
     * call this method on it, and crack the cipher used on a message.
     */
    public void breakVigenere() {
        HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>>();
        String[] dictionaries = new String[8];
        dictionaries[0] = "Danish";
        dictionaries[1] = "Dutch";
        dictionaries[2] = "English";
        dictionaries[3] = "French";
        dictionaries[4] = "German";
        dictionaries[5] = "Italian";
        dictionaries[6] = "Portuguese";
        dictionaries[7] = "Spanish";
        
        for (int i = 0; i < dictionaries.length; i++) {
            String languageName = dictionaries[i];
            FileResource dictFile = new FileResource("dictionaries/" + languageName);
            HashSet<String> dictionary = readDictionary(dictFile);
            languages.put(languageName, dictionary);
            System.out.println("Added Language: " + languageName);
        }
        
        FileResource fr = new FileResource();
        String message = fr.asString();
        breakForAllLangs(message, languages);
    }
    
    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> dictionaryWords = new HashSet<String>();
        for (String line : fr.lines()) {
            line = line.toLowerCase();
            dictionaryWords.add(line);
        }
        return dictionaryWords;
    }
    
    
    public int countWords(String message, HashSet<String> dictionary) {
        int realWords = 0;
        String[] words = message.split("\\W+");
        for (String word : words) {
            word = word.toLowerCase();
            if (dictionary.contains(word)) {
                realWords++;
            }
        }
        return realWords;
    }
    
   
    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        int maxRealWords = 0; 
        int finalKeyLength = 1;
        String decryptionWithMostRealWords = "";
        char mostCommonChar = mostCommonCharIn(dictionary);
        System.out.println("The most common character in the dictionary is " + mostCommonChar);
        for (int keylength = 1; keylength <= 100; keylength++) {
            int[] key = tryKeyLength(encrypted, keylength, mostCommonChar);
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int realWords = countWords(decrypted, dictionary);
            if (realWords > maxRealWords) {
                maxRealWords = realWords;
                decryptionWithMostRealWords = decrypted;
                finalKeyLength = keylength;
            }
        }
        
        System.out.println("Message contains " + maxRealWords + " valid words");
        System.out.println("Message decoded with keylength of " + finalKeyLength);
        return decryptionWithMostRealWords;
    }

    public char mostCommonCharIn(HashSet<String> dictionary) {
        HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();
        for (String word : dictionary) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!Character.isLetter(ch)) {
                    break;
                }
                // If charFreq HashMap contains char, 
                if (charFreq.containsKey(ch)) {
                    int freq = charFreq.get(ch);
                    charFreq.put(ch, freq + 1);
                } else {
                    charFreq.put(ch, 1);
                }
            }
        }
        // Find most common character in dictionary
        char mostCommonChar = ' ';
        int maxCount = 0;
        for (char ch : charFreq.keySet()) {
            int freq = charFreq.get(ch);
            if (Character.isSpaceChar(mostCommonChar)) {
                mostCommonChar = ch;
                maxCount = freq;
            } else {
                if (freq > maxCount) {
                    mostCommonChar = ch;
                    maxCount = freq;
                }
            }
        }
        return mostCommonChar;
    }
    
    public void breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages) {
        Scanner scan=new Scanner(System.in);
        for (String language : languages.keySet()) {
            // Get the language's mapped HashSet dictionary of words
            HashSet<String> dictionary = languages.get(language);
            System.out.println("Analyzing the text with " + language);
            // Call breakForLanguage with the message and the dictionary
            String decrypted = breakForLanguage(encrypted, dictionary);
            // Print the decrypted message
            System.out.println(decrypted);
            System.out.println("Do you want to continue?: 0 for no, 1 for yes");
            int choice=scan.nextInt();
            if (choice==0)
                break;
        }
    }
}
