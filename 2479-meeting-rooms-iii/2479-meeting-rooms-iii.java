class Solution {
    public int mostBooked(int n, int[][] meetings) {
         Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        long[] endTime = new long[n];
        int[] cnt = new int[n];

        for (int[] meet : meetings) {
            int starttime = meet[0];
            int endtime = meet[1];
            int duration = endtime - starttime;

            int room = -1;
            for (int i = 0; i < n; i++) {
                if (endTime[i] <= starttime) {
                    room = i;
                    break;
                }
            }
            if (room != -1) {
                endTime[room] = starttime + duration;
                cnt[room]++;
            } else {
                long minEndTime = Long.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    if (endTime[i] < minEndTime) {
                        minEndTime = endTime[i];
                        room = i;
                    }
                }

                endTime[room] += duration;
                cnt[room]++;
            }
        }

        int MaxCnt = 0, idx = -1;
        for (int i = 0; i < n; i++) {
            if (cnt[i] > MaxCnt) {
                MaxCnt = cnt[i];
                idx = i;
            }
        }
        return idx;
        
    }
}