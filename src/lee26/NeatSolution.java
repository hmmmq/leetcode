package lee26;

class NeatSolution {
    public int removeDuplicates(int[] nums) {
        // since nums.length is at least 1, we don't need to check it
        int slow = 0;
        int fast = 0;

        // you can also use for loop alternatively
        while (fast < nums.length) {

            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                nums[++slow] = nums[fast++];
            }
        }

        return slow + 1;

    }
}