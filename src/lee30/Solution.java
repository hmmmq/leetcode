package lee30;

import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 * description: https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 * solution:https://leetcode.com/problems/substring-with-concatenation-of-all-words/solutions/4379597/easy-solution/
 */
class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        var m = words.length;
        var n = words[0].length();
        var result = new ArrayList<Integer>();

        // check if the length of s is less than m * n
        if (s.length() < m * n)
            return result;

        // build the hashmap
        var map = new HashMap<String, Integer>();
        for (var word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // traverse all the possible start index
        for (var i = 0; i <= s.length() - m * n; i++) {
            // traverse the window with size n
            // build a hashmap for the window
            var windowMap = new HashMap<String, Integer>();
            // count represents the number of satisfied words
            for (var j = 0; j < m; j++) {
                // extract a word from the window
                var temp = s.substring(i + j * n, i + j * n + n);
                // add the word to the window hashmap
                windowMap.put(temp, windowMap.getOrDefault(temp, 0) + 1);
            }
            // check if the current window is what we want
            if (windowMap.equals(map))
                result.add(i);
        }

        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"foo", "bar"};
        System.out.println(s.findSubstring("barfoothefoobarman", words));
    }


}