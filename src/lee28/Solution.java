package lee28;

/**
 * leetcode 28 查找子串
 * KMP算法
 * 1.构建next数组
 * 2.匹配
 * 3.返回结果
 * 时间复杂度O(m+n)
 * 空间复杂度O(n)
 */
class Solution {

    /**
     * 构建next数组步骤
     * 1.初始化next[0]=0
     * 2.初始化i=1,j=0
     * 3.如果needle[i]==needle[j],则next[i]=j+1,i++,j++
     * 4.如果needle[i]!=needle[j],则回溯j=next[j-1]
     * 5.如果j==0,则next[i]=0,i++
     * 6.重复3-5
     * 7.返回next数组
     * @param needleStr 子串
     * @return next数组
     */
    public int[] buildNext(String needleStr) {

        int[] next = new int[needleStr.length()];
        int j = 0;
        int i = 1;
        char[] needle = needleStr.toCharArray();

        while (i < needle.length) {

            if (needle[i] == needle[j]) {

                next[i++] = ++j;

            } else {

                if (j == 0) {

                    next[i++] = 0;

                } else {
                    // 回溯
                    j = next[j - 1];
                }

            }
        }
        return next;

    }

    /**
     * KMP算法
     * 1.初始化i=0,j=0
     * 2.如果haystack[i]==needle[j],则i++,j++
     * 3.如果haystack[i]!=needle[j],则回溯j=next[j-1]
     * 4.如果j==0,则i++
     * 5.重复2-4
     * 6.返回结果
     * @param haystackStr 母串
     * @param needleStr 子串
     * @return 子串在母串中的位置
     */
    public int strStr(String haystackStr, String needleStr) {

        int i = 0;
        int j = 0;
        int n = needleStr.length();
        int m = haystackStr.length();
        int[] next = buildNext(needleStr);
        char[] haystack = haystackStr.toCharArray();
        char[] needle = needleStr.toCharArray();

        while (i < m) {

            if (haystack[i] == needle[j]) {

                i++;
                j++;

            } else {

                if (j > 0) {
                    // 回溯
                    j = next[j - 1];

                } else {
                    i++;
                }
            }

            if (j == n) {
                return i - n;
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("hello", "ll"));
    }
}