/* 
 * 
 * Write a method countWords that takes as a parameter a String.
 * This String will contain a sequence of words separated by spaces with no punctuation.
 * Your method should count the number of times each of these words appears in the String
 * and return another String with that information in the format "<word> <count>\n".
 * Each word's count should appear on its own line in the return value such that 
 * when the return is printed the counts are each on separate lines.
 * The values should be sequenced in the same order they were found in the original String.
 * Words capitalized differently should still be counted as the same as one another.
 * 
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {
    // Implement your countWords method here!
    @SuppressWarnings("unchecked")
    public static String countWords(String words) {
        @SuppressWarnings("rawtypes")
        LinkedHashMap map = new LinkedHashMap<String, Integer>();
        String[] wordsArray = words.split(" ");
        for (String word : wordsArray) {
            System.out.println(word);
            if (map.containsKey(word.toLowerCase())) {
                map.put(word.toLowerCase(), (int) map.get(word.toLowerCase()) + 1);
            } else {
                map.put(word.toLowerCase(), 1);
            }
        }
        String result = "";
        for (Object key : map.keySet()) {
            result += key + " " + map.get(key) + "\n";
        }
        return result;

    }

    // Without a LinkedHashMap. A bit more complicated (and less efficient)
    public static String countWordsNoLHM(String words) {
        // Same as countWords - without a LinkedHashMap
        String[] wordsArrOld = words.split(" ");
        ArrayList<String> wordsList = new ArrayList<String>();
        ArrayList<Integer> countList = new ArrayList<Integer>();
        String[] wordsArr = new String[wordsArrOld.length];
        for (int i = 0; i < wordsArrOld.length; i++) {
            wordsArr[i] = wordsArrOld[i].toLowerCase();
        }
        boolean isWordFound = false;
        for (String word : wordsArr) {
            for (String word2 : wordsList) {
                if (word.equals(word2)) {
                    isWordFound = true;
                    break;
                }
            }
            if (!isWordFound) {
                wordsList.add(word);
                countList.add(1);
            } else {
                // System.out.println(wordsList.indexOf(word));
                // System.out.println(countList.get(wordsList.indexOf(word)));
                countList.set(wordsList.indexOf(word), countList.get(wordsList.indexOf(word)) + 1);
            }
            isWordFound = false;
        }
        // System.out.println(wordsList);
        // System.out.println(countList);
        String result = "";
        for (int i = 0; i < wordsList.size(); i++) {
            result += wordsList.get(i) + " " + countList.get(i) + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        String myString = "hello how hello how are hello how are you hello";
        System.out.println(countWords(myString));
    }
}