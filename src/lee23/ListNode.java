package lee23;


/**
 * 23. 合并K个排序链表
 * leecode: https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 题解：https://leetcode.com/problems/merge-k-sorted-lists/solutions/4363296/easy-and-efficient-way/
 * 时间复杂度：Nlogk (N: 所有元素的个数，k: 链表的个数)
 * 空间复杂度：O(1)
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private String listToString(ListNode list) {
        StringBuilder sb = new StringBuilder();
        while (list != null) {
            sb.append(list.val).append(" -> ");
            list = list.next;
        }
        sb.append("null");
        return sb.toString();
    }

    // Helper function to merge two sorted lists and print the merging process
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }


        return dummyHead.next;
    }

    // Main function to merge k sorted lists
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        } else if (n == 1) {
            return lists[0];
        }

        // Merge lists in pairs until there is only one list left
        int interval = 1;
        System.out.println("create interval: " + interval);
        while (interval < n) { // in a loop until there is only one list left
            System.out.println();
            // merge list i with list i + interval. The interval is doubled after each iteration.
            // i+interval must be less than n, otherwise there is no list to merge with
            for (int i = 0; i < n - interval; i += interval * 2) {// increase i by interval * 2 each time
                String indent = "  ".repeat(interval);
                System.out.println(indent + "Interval: " + interval);
                System.out.println(indent + "Merge Lists: i: " + i + " and (i + interval): " + (i + interval));
                System.out.println(indent + "List "+ i + ": " + listToString(lists[i]));
                System.out.println(indent + "List "+ (i + interval) + ": " + listToString(lists[i + interval]));
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]); // merge list i with list i + interval
                System.out.println(indent + "Merged list: " + listToString(lists[i]));
                System.out.println(indent + "Interval: " + interval);
                System.out.println(indent + "we have merged two lists, list " + i + " and list " + (i + interval) +" to the list "+ i);
                System.out.println(indent + "need to jump to next pair of lists:"+ " "+ (i + interval * 2) + " and "+ (i + interval * 2 + interval));
                System.out.println(indent + "so increase i by interval * 2 each time, i = " + i + " + " + interval + " * 2 = " + (i + interval * 2));
                System.out.println();
            }
            System.out.println("double the interval: " + interval + " * 2 = " + (interval * 2));
            interval *= 2;// double the interval
        }

        return lists[0];// return the final list
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] lists = new ListNode[6];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));
        lists[3] = new ListNode(3, new ListNode(7));
        lists[4] = new ListNode(4, new ListNode(8));
        lists[5] = new ListNode(5, new ListNode(9));
        solution.mergeKLists(lists);
    }
}
