import java.util.HashMap;
import java.util.Map;
/**
 * James Hering
 * Algorithms I
 * 3 December 2023
 * 
 * A program which takes a string pattern as its input, and returns true if
 * string S is a 'Full match',
 * meaning there exists a bijection between a letter in pattern and a word in S
 * that isn't empty.
 * 
 */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) 
        return false;
        // Create a map to store matching patterns and words
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            // If the map contains the pattern, check if the word matches
            if (map.containsKey(c) && !map.get(c).equals(word) || 
            !map.containsKey(c) && map.containsValue(word)) {
                return false;
            } else {
                // If the map doesn't contain the pattern, add it
                map.put(c, word);
            }
        }
        return true;
    }
}

