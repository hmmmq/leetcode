package lee26;
/*
  leetcode 26. remove-duplicates-from-sorted-array
  description: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
  solution: https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/3839850/easy-and-efficient-approach/
 */
public class Solution {
    /**
     * Remove Duplicates from Sorted Array
     * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     */
    public int removeDuplicates(int[] nums) {
        // check the length of nums
        int len = nums.length;
        // if the length is less than 1, return the length
        if (len <= 1)
            return len;
        // use two pointers to traverse the array
        // i is the slow pointer, j is the fast pointer
        int i = 0, j = 1;
        // traverse the array
        while (j < len) {
            // if nums[i] equals nums[j], move j to the next
            if (nums[i] == nums[j])
                j++;
            else
                // if nums[i] does not equal nums[j],
                // move i to the next and assign nums[j] to nums[i]
                // to make sure nums[0] to nums[i] is unique
                nums[++i] = nums[j++];
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 2, 2};
        int len = s.removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++)
            System.out.print(nums[i] + " ");
    }
}
