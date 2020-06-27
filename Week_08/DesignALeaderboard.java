package leecode.week08;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignALeaderboard {
    class Leaderboard {
        private Map<Integer, Integer> map = new HashMap<>();

        public Leaderboard() {

        }

        public void addScore(int playerId, int score) {
            map.put(playerId, map.getOrDefault(playerId, 0) + score);
        }

        public int top(int K) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                queue.offer(entry.getValue());
            }
            int sum = 0;
            while (!queue.isEmpty() && K-- > 0) sum += queue.poll();
            return sum;
        }

        public void reset(int playerId) {
            map.remove(playerId);
        }
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);

*/