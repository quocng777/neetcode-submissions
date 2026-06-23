class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Pass 1: Interleave clones — A -> A' -> B -> B' -> ...
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Pass 2: Set random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next; // A'.random = A.random.next (the clone)
            curr = curr.next.next;
        }

        // Pass 3: Separate the two lists
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        curr = head;
        while (curr != null) {
            copyCurr.next = curr.next;   // extract clone
            curr.next = curr.next.next;  // restore original
            copyCurr = copyCurr.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}