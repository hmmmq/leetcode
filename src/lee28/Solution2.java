package lee28;

class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.strStr("hello", "ll"));
    }

    public int strStr(String haystack, String needle) {
        // use existing api
        return haystack.indexOf(needle);
    }
}