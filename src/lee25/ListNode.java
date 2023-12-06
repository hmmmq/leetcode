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
    public ListNode reverseKGroup(ListNode head, int k, int indent) {
        String indentStr = "    ".repeat(indent);
        System.out.println(indentStr + "reverseKGroup with head: " + listToString(head));
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
            return head;
        }

        // reverse the first k nodes of the list and get the reversed list's head
        System.out.println(indentStr + "reverse the first k nodes of the list and get the reversed list's head");
        ListNode newHead = reverseLinkedList(head, k);
        System.out.println(indentStr + listToString(newHead));
        // head is now pointing to the kth node of reversed list
        // current is now pointing to the (k+1)th node of reversed list
        // newHead is now pointing to the head of the reversed list
        // recursively call for the rest of the list and link the two together
        // update the current as head of the next reversed list
        System.out.println(indentStr + "recursively call for the rest of the list and link the two together");
        head.next = reverseKGroup(current, k, indent + 1);
        System.out.println(indentStr + "head.next is now pointing to the (k+1)th node of reversed list");
        System.out.println(indentStr + "listToString(head.next) " + listToString(head.next));

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