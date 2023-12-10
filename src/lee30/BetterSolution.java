package lee30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * description: https://leetcode.com/problems/substring-with-concatenation-of-all-words/solutions/4387757/fastest-best-solution-beats-100/
 */
class BetterSolution {
    public static void main(String[] args) {
        BetterSolution s = new BetterSolution();
        String[] words = {"foo", "bar"};
        System.out.println(s.findSubstring("barfoothefoobarman", words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        return new java.util.AbstractList<Integer>() {
            private List<Integer> res;

            @Override
            public Integer get(int index) {
                if (res == null) {
                    res = findSubstringInternal(s, words);
                    System.gc();
                }

                return res.get(index);
            }

            @Override
            public int size() {
                if (res == null) {
                    res = findSubstringInternal(s, words);
                    System.gc();
                }
                return res.size();
            }
        };
    }

    public List<Integer> findSubstringInternal(String s, String[] words) {
        var m = words.length;
        var n = words[0].length();
        var chars = s.toCharArray();
        var map = new HashMap<String, Integer>();
        var result = new ArrayList<Integer>();
        var limit = s.length() - m * n;

        if (limit < 0)
            return result;

        for (var word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (var i = 0; i <= limit; i++) {

            var windowMap = new HashMap<String, Integer>();

            for (var j = 0; j < m; j++) {

                var temp = new String(chars, i + j * n, n);

                var exp_count = map.getOrDefault(temp, 0);

                if (exp_count == 0)
                    break;

                var curr_count = windowMap.getOrDefault(temp, 0) + 1;

                if (curr_count > exp_count)
                    break;

                windowMap.put(temp, curr_count);

            }

            if (windowMap.equals(map))
                result.add(i);

        }

        return result;
    }
}