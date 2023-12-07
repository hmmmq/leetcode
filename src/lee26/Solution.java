package lee26;

public class Solution {
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
