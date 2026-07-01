class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frequentMap = new HashMap<>();
        for (char task : tasks) {
            frequentMap.put(task, frequentMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Pair<Character, Integer>> maxHeap =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> entry : frequentMap.entrySet()) {
            maxHeap.offer(new Pair<>(entry.getKey(), entry.getValue()));
        }

        Queue<Pair<Pair<Character, Integer>, Integer>> cooldownQueue = new LinkedList<>();

        int curTime = 0;
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            if (!cooldownQueue.isEmpty()) {
                Pair<Pair<Character, Integer>, Integer> candidate = cooldownQueue.peek();
                if (candidate.getValue() == curTime) {
                    cooldownQueue.poll();
                    maxHeap.offer(candidate.getKey());
                }
            }

            Pair<Character, Integer> peek = maxHeap.poll();
            if (peek != null && peek.getValue() > 1) {
                cooldownQueue.offer(new Pair<>(
                    new Pair<>(peek.getKey(), peek.getValue() - 1),
                    curTime + n + 1
                ));
            }

            curTime++;
        }

        return curTime;
    }
}