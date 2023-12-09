package lee25;

/**
 * leetcode 25. K 个一组翻转链表
 * leetcode: https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * 题解：https://leetcode.com/problems/reverse-nodes-in-k-group/solutions/4372113/java-easy-and-simple-way/
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
        System.out.println("Before：" + solution.listToString(head));
        ListNode newHead = solution.reverseKGroup(head, 2, 0);
        System.out.println("After：" + solution.listToString(newHead));
    }

    // Helper function to print a linked list
    private String listToString(ListNode list) {
        StringBuilder sb = new StringBuilder();
        while (list != null) {
            sb.append(list.val).append(" -> ");
            list = list.next;
        }
        sb.append("null");
        return sb.toString();
    }

    // Helper function to print a node
    private String nodeToString(ListNode node) {
        if (node == null)
            return "null";
        else
            return String.valueOf(node.val);
    }

    public ListNode reverseKGroup(ListNode head, int k, int indent) {

        String indentStr = "    ".repeat(indent);
        System.out.println(indentStr + "reverseKGroup(" + nodeToString(head) + ", " + k + ", " + indent + ")");

        ListNode current = head;

        int count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        // if count < k, then we don't need to reverse the list
        if (count < k) {

            System.out.println(indentStr +
                    "but count < k, so we don't need to reverse the second list start with head:" + nodeToString(head));

            return head;
        }

        // reverse the first k nodes of the list and get the reversed list's head
        System.out.println(indentStr +
                "now process the (second) list start with head:" +
                nodeToString(head));
        System.out.println(indentStr +
                "current un-reversed linked list: " +
                listToString(head));
        System.out.println(indentStr +
                "now reverse the first " + k + " nodes");

        // 递归调用, 函数返回的是反转后的链表的头结点(1级)
        ListNode newHead = reverseLinkedList(head, k);

        System.out.println(indentStr +
                "current reversed linked list: " +
                listToString(newHead));
        System.out.println(indentStr +
                "we cut the list into two parts:");
        System.out.println(indentStr +
                "first list start with newHead: " +
                listToString(newHead) +
                "  " +
                "another list start with current: " +
                listToString(current));
        System.out.println(indentStr +
                "newHead:" +
                nodeToString(newHead) +
                "  head:" + nodeToString(head) +
                "  current:" + nodeToString(current));

        // head is now pointing to the kth node of reversed list
        // current is now pointing to the (k+1)th node of reversed list
        // newHead is now pointing to the head of the reversed list
        // recursively call for the rest of the list and link the two together
        // update the current as head of the next reversed list
        System.out.println(indentStr +
                "now we link the two parts together:");
        System.out.println(indentStr +
                "head is now pointing to the end node of first part of reversed list, so we " +
                "set " +
                nodeToString(head) + ".next" +
                " = reverseKGroup(" + nodeToString(current) + ", " + k + ", " + (indent + 1) + ")");

        // 递归调用, 函数返回的是反转后的链表的头结点(2级)
        // head则指向了反转后的链表的尾结点(1级)
        head.next = reverseKGroup(current, k, indent + 1);

        System.out.println(indentStr +
                "after link the two parts together:" +
                listToString(newHead));
        System.out.println(indentStr + "return the linked list with newHead:" + listToString(newHead));

        return newHead;
    }

    // Helper function to reverse a linked list
    private ListNode reverseLinkedList(ListNode head, int k) {

        // 涉及到链表的反转. 不同于两两交换, prev得设成null,
        // 因为反转后的链表的尾结点的next指针应该指向null
        ListNode prev = null;

        ListNode current = head; // current总是从head开始

        // 反转k个节点
        while (k > 0) {

            ListNode next = current.next;

            current.next = prev;

            // 链表的反转不同于链表的交换, next.next 指针不需要指向current

            prev = current;
            current = next;

            k--;

        }

        // 返回反转后的链表的头结点
        return prev;

    }

}