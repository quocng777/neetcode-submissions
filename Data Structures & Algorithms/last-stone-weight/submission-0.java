class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int weight : stones) queue.offer(weight);

        while (queue.size() > 1) {
            int stone1 = queue.poll();
            int stone2 = queue.poll();

            if (stone1 != stone2) {
                queue.offer(Math.abs(stone1 - stone2));
            }
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }
}
