package lee28;

/**
 * leetcode 28 查找子串
 * KMP算法
 * 1.构建next数组
 * 2.匹配
 */
class Solution {
    public int[] buildNext(String needleStr){

        int[] next = new int[needleStr.length()];
        int j = 0;
        int i = 1;
        char[] needle = needleStr.toCharArray();

        while( i < needle.length){

            if(needle[i] == needle[j]){

                next[i++] = ++j;

            }else{

                if(j==0){

                    next[i++]=0;

                }else{
                    j = next[j-1];
                }

            }
        }
        return next;

    }
    public int strStr(String haystackStr, String needleStr) {

        int i = 0;
        int j = 0;
        int n = needleStr.length();
        int m = haystackStr.length();
        int[] next = buildNext(needleStr);
        char[] haystack = haystackStr.toCharArray();
        char[] needle = needleStr.toCharArray();

        while( i < m ){

            if(haystack[i] == needle[j]){

                i++;
                j++;

            }else{

                if(j>0){

                    j = next[j-1];

                }else{
                    i++;
                }
            }

            if(j==n){
                return i-n;
            }

        }


        return -1;


    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("hello","ll"));
    }
}