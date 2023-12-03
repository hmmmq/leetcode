package lee22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * leecode: https://leetcode.com/problems/generate-parentheses/description/
 * 题解：https://leetcode.com/problems/generate-parentheses/solutions/4355549/java-detail-solution-chinese/
 * 题目描述：
 *    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *    For example, given n = 3, a solution set is:
 *    [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 *    Given n = 2, a solution set is:
 *    [ "(())", "()()" ]
 *    Given n = 1, a solution set is:
 *    [ "()" ]
 *    Given n = 0, a solution set is:
 *    [ ]
 * 思路：
 *   1. 递归
 * 时间复杂度：
 *  1. O(2^n)
 * 空间复杂度：
 *  1. O(n*2^n)
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(result, "", 0, 0, n, 0);
        return result;
    }

    private void generateParenthesisHelper(List<String> result, String current, int open, int close, int n, int depth) {
        // 创建缩进字符串
        String indent = "       ".repeat(depth);

        // 打印带有缩进的信息
        System.out.println(indent + "Current: " + current + ", Open: " + open + ", Close: " + close);

        if (current.length() == 2 * n) {
            result.add(current);
            System.out.println(indent + "return");
            return;
        }

        if (open < n) {
            System.out.println(indent + "open move");
            System.out.println(indent + "|");
            generateParenthesisHelper(result, current + "(", open + 1, close, n, depth + 1);
            System.out.println(indent + "|");
            System.out.println(indent + "open back");
            System.out.println(indent + "Current: " + current + ", Open: " + open + ", Close: " + close);

        }

        if (close < open) {
            System.out.println(indent + "close move");
            System.out.println(indent + "|");
            generateParenthesisHelper(result, current + ")", open, close + 1, n, depth + 1);
            System.out.println(indent + "|");
            System.out.println(indent + "close back");
            System.out.println(indent + "Current: " + current + ", Open: " + open + ", Close: " + close);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(2);
        System.out.println(strings);
    }
}
