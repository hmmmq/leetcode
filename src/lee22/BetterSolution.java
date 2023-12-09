package lee22;

import java.util.ArrayList;
import java.util.List;

/**
 * description: https://leetcode.com/problems/generate-parentheses/solutions/4382240/improved-solution/
 */
class BetterSolution {
    public List<String> generateParenthesis(int n) {

        var result = new ArrayList<String>();
        generateParenthesisHelper(new StringBuilder(), 0, 0, n, result);
        return result;

    }

    private void generateParenthesisHelper(StringBuilder current_string_builder, int open, int close, int n, List<String> result) {

        if(current_string_builder.length() == 2 * n){

            result.add(current_string_builder.toString());
            return;

        }

        if(open < n){

            generateParenthesisHelper(current_string_builder.append('('), open+1, close, n, result);
            current_string_builder.deleteCharAt(current_string_builder.length()-1);

        }

        if(close < open){

            generateParenthesisHelper(current_string_builder.append(')'), open, close+1, n, result);
            current_string_builder.deleteCharAt(current_string_builder.length()-1);

        }
    }
}