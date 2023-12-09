package lee27;

/**
 * another solution: use two pointers method
 */
class Solution2 {
    public int removeElement(int[] nums, int val) {

        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {

            if (nums[fast] == val) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }
}