class Solution {
    public int maxEvents(int[][] events) {
          int n = events.length;
          Arrays.sort(events, new Comparator<int[]>() {
              @Override
              public int compare(int[] o1, int[] o2) {
                  return o1[0] - o2[0];
              }
          });
  
          PriorityQueue<Integer> pq = new PriorityQueue<>();
          int res = 0;
          int currDay = 1;
          int i = 0;
          while (i < n || !pq.isEmpty()) {
              while (i < n && events[i][0] == currDay) {
                  pq.add(events[i][1]);
                  i++;
              }
  
              while (!pq.isEmpty() && pq.peek() < currDay) {
                  pq.remove();
              }
  
              if (!pq.isEmpty()) {
                  pq.remove();
                  res++;
              }
              currDay++;
          }
  
          return res;
      }
  }