package lee24;

/**
 * 24. 两两交换链表中的节点
 * leecode: https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * 题解：https://leetcode.com/problems/swap-nodes-in-pairs/solutions/4363400/easy-and-fast-solution/
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solution.swapPairs(head);
    }

    private String listToString(ListNode list) {
        StringBuilder sb = new StringBuilder();
        while (list != null) {
            sb.append(list.val).append(" -> ");
            list = list.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head; // 如果链表为空或只有一个节点，无需交换，直接返回
        }

        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode prev = dummy;

        ListNode current = head;

        System.out.println("0: create prev node -> dummy " + prev.val +
                "\n  create current node -> head " + current.val);

        while (current != null && current.next != null) {

            System.out.println("\nnew round：" + listToString(dummy.next) + " prev :" + prev.val + "  current:" + current.val);
            System.out.println("1：create nextNode:" + current.next.val);

            ListNode nextNode = current.next;

            if (nextNode.next != null)
                System.out.println("2：current " + current.val + " -->" + "nextNode.next " + nextNode.next.val);
            else
                System.out.println("2：current " + current.val + " -->" + "nextNode.next null");

            current.next = nextNode.next;

            System.out.println(listToString(dummy.next));
            System.out.println("3：nextNode " + nextNode.val + " -->current " + current.val);

            nextNode.next = current;

            System.out.println(listToString(dummy.next));
            System.out.println("4：prev " + prev.val + " --> nextNode " + nextNode.val);

            prev.next = nextNode;

            System.out.println(listToString(dummy.next));
            System.out.println("5：prev " + prev.val + " -> " + current.val);

            prev = current;

            if (current.next != null)
                System.out.println("6：current " + current.val + " -> " + current.next.val);
            else
                System.out.println("6：current " + current.val + " -> null");

            current = current.next;


        }

        System.out.println("Finally：" + listToString(dummy.next));

        return dummy.next;
    }
}