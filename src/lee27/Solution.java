package lee27;

/**
 * leetcode 27. remove-element
 * description: https://leetcode.com/problems/remove-element/description/
 * solution: https://leetcode.com/problems/remove-element/solutions/4372553/easy-way/
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 2, 2};
        int len = s.removeElement(nums, 2);
        System.out.println(len);
        for (int i = 0; i < len; i++)
            System.out.print(nums[i] + " ");
    }
}