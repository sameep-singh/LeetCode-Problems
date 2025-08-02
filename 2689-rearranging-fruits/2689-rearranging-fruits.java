import java.util.*;
class Solution {
    public long minCost(int[] b1, int[] b2) {
        Map<Integer, Integer> m = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int x : b1) { m.put(x, m.getOrDefault(x, 0) + 1); min = Math.min(min, x); }
        for (int x : b2) { m.put(x, m.getOrDefault(x, 0) - 1); min = Math.min(min, x); }

        List<Integer> l = new ArrayList<>();
        for (var e : m.entrySet()) {
            if (e.getValue() % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(e.getValue()) / 2; i++) l.add(e.getKey());
        }

        Collections.sort(l);
        long res = 0;
        for (int i = 0; i < l.size() / 2; i++) res += Math.min(l.get(i), 2L * min);
        return res;
    }
}
