/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, List<Node>> map = new HashMap();
        Map<Node, Node> cloneMap = new HashMap();
        Node dumpNode = new Node(0);
        Node curNode = dumpNode;
        while(head != null) {
            Node cloneNode = new Node(head.val);
            cloneMap.put(head, cloneNode);
            if (map.containsKey(head)) {
                List<Node> list = map.get(head);
                for (Node source : list) {
                    source.random = cloneNode;
                }
            }
            if (head.random != null) {
                if (cloneMap.containsKey(head.random)) {
                    cloneNode.random = cloneMap.get(head.random);
                } else {
                    List<Node> list = map.getOrDefault(head.random, new ArrayList());
                    list.add(cloneNode);
                    map.put(head.random, list);
                }
            }
            curNode.next = cloneNode;
            curNode = cloneNode;
            head = head.next;
        }

        return dumpNode.next;
    }
}
