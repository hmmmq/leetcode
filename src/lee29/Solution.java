package lee29;
//29. Divide Two Integers
//description: https://leetcode.com/problems/divide-two-integers/description/
//solution: https://leetcode.com/problems/divide-two-integers/solutions/4379189/easy-and-efficient/

public class Solution {
    public int divide(int dividend, int divisor) {
        // corner case
        if (dividend == 0) return 0;

        // mind the overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        // determine the sign of the result
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        // convert to long to avoid overflow
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        int result = 0;
        while (dividendL >= divisorL) {
            int shift = 0;

            // find the largest shift that make divisorL * 2^shift <= dividendL
            long divisorl_double = divisorL << shift;
            while (dividendL >= divisorl_double) {
                shift++; // continously double the divisorL
                divisorl_double = divisorL << shift;
            }
            //maximum doubled value that less than dividendL
            divisorl_double = divisorL << (shift - 1);

            // dividendL minus the maximum doubled value
            dividendL -= divisorl_double;

            // since maximum doubled value is less than dividendL,
            // and maximum doubled value is get from divisorL * 2^(shift - 1)
            // so the quotient is at least 2^(shift - 1)
            int quotient = 1 << (shift - 1); // 2^(shift - 1)
            result += quotient; // update the result
         }

        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(10, 3));
    }
}
