package lee25;

class NeatSolution {

    public ListNode reverseHelper(ListNode head, int k) {

        ListNode prev = null;

        var current = head;

        while (k > 0) {

            var next = current.next;

            current.next = prev;

            prev = current;

            current = next;

            k--;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        //count the length of list;
        var count = 0;
        var current = head;

        //! must add count<k for following reversion of list.
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count < k) {
            // no need to swap
            return head;
        }

        //reverse first k node
        var new_head = reverseHelper(head, k);

        // suppose 1st mean shallower layer, 2nd mean deeper layer;
        // the reverseKGroup return 1st node of 2nd layer
        // head now is the kth node of 1st layer, so head.next should be 2nd layer's head;
        // indeed, current is (k+1)th node of 1st layer, but it is also 1st node of 2nd layer;
        // so we need to reverseKGroup(current,k);
        head.next = reverseKGroup(current, k);

        return new_head;

    }
}