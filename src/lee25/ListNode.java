package lee25;

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

/**
 * leetcode 25. K 个一组翻转链表
 * leetcode: https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * 题解：https://leetcode.com/problems/reverse-nodes-in-k-group/solutions/4372113/java-easy-and-simple-way/
 */
class Solution {
    private String listToString(ListNode list){
        StringBuilder sb = new StringBuilder();
        while (list != null){
            sb.append(list.val).append(" -> ");
            list = list.next;
        }
        sb.append("null");
        return sb.toString();
    }
    private String nodeToString(ListNode node){
        if (node == null)
            return "null";
        else
            return String.valueOf(node.val);
    }
    public ListNode reverseKGroup(ListNode head, int k, int indent) {
        String indentStr = "    ".repeat(indent);
        System.out.println(indentStr + "reverseKGroup(" + nodeToString(head) + ", " + k + ", " + indent + ")");
        //create current node and initialize it to the head of the list
        ListNode current = head;

        //count the number of nodes in the list
        int count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        // if count < k, then we don't need to reverse the list
        if (count < k) {
            System.out.println(indentStr +
                    "but count < k, so we don't need to reverse the second list start with head:"+nodeToString(head));
            return head;
        }

        // reverse the first k nodes of the list and get the reversed list's head
        System.out.println(indentStr +
                "now process the (second) list start with head:"+
                nodeToString(head));
        System.out.println(indentStr +
                "current un-reversed linked list: "+
                listToString(head));
        System.out.println(indentStr +
                "now reverse the first " + k + " nodes");
        ListNode newHead = reverseLinkedList(head, k);
        System.out.println(indentStr +
                "current reversed linked list: "+
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
                "set "+
                nodeToString(head)+".next"+
                " = reverseKGroup("+nodeToString(current)+", "+k+", "+(indent + 1)+")");

        head.next = reverseKGroup(current, k, indent + 1);

        System.out.println(indentStr +
                "after link the two parts together:"+
                listToString(newHead));
        System.out.println(indentStr + "return the linked list with newHead:" + listToString(newHead));

        return newHead;
    }

    // Helper function to reverse a linked list
    private ListNode reverseLinkedList(ListNode head, int k) {

        ListNode prev = null;
        ListNode current = head;

        while (k > 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            k--;
        }

        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println("Before：" + solution.listToString(head));
        ListNode newHead = solution.reverseKGroup(head, 2,0);
        System.out.println("After：" + solution.listToString(newHead));
    }

}