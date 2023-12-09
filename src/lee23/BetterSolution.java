package lee23;

class BetterSolution {

    public ListNode mergeHelper(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {

                curr.next = l1;

                l1 = l1.next;

            } else {

                curr.next = l2;

                l2 = l2.next;
            }

            curr = curr.next;
        }

        if (l1 != null) {

            curr.next = l1;

        } else {

            curr.next = l2;

        }

        return dummy.next;

    }

    public ListNode mergeKLists(ListNode[] lists) {

        // Corner case
        // more concise by using ternary operator
        if (lists.length < 2) {
            return lists.length == 0 ? null : lists[0];
        }

        int interval = 1;

        while (interval < lists.length) {

            for (int i = 0; i < lists.length - interval; i += interval * 2) {
                lists[i] = mergeHelper(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
}