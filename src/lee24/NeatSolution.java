package lee24;

/**
 * 简化了变量命名,去掉了不必要的打印
 */
class NeatSolution {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        var dummy = new ListNode(0);
        var prev = dummy;
        var curr = head;
        while (curr != null && curr.next != null) {
            var next = curr.next;
            curr.next = next.next;
            next.next = curr;
            prev.next = next;
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}