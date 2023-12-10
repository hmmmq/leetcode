package lee29;
//29. Divide Two Integers
//description: https://leetcode.com/problems/divide-two-integers/description/
//solution: https://leetcode.com/problems/divide-two-integers/solutions/4379189/easy-and-efficient/

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(10, 3));
        System.out.println(s.divide(7, -3));
        System.out.println(s.divide(0, 1));
        System.out.println(s.divide(1, 1));
        System.out.println(s.divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        // mind the Interger.MIN_VALUE, once convert to positive, it will overflow, so use long before convert
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        int result = 0;
        while (dividendL >= divisorL) {
            int shift = 0;
            while (dividendL >= (divisorL << shift)) {
                shift++;
            }
            dividendL -= divisorL << (shift - 1);
            result += 1 << (shift - 1);
        }

        return isNegative ? -result : result;
    }
}