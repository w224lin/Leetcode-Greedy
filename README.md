# Leetcode-Greedy
Some classic algorithm problem on Leet code about Greedy question. Keep updated.

## Medium

Some medium leet code greedy question.

### Question. 134. Gas Station

- 134.[Gas Station](https://leetcode.cn/problems/gas-station/)

Solution in O(n).

```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        int i = 0;
        while (i < n){
            int sum = 0;
            int cnt = 0;
            while (cnt < n){
                int j = (i + cnt) % n;
                sum += gas[j];
                sum -= cost[j];
                if (sum < 0){
                    break;
                }
                ++cnt;
            }
            if (cnt == n){
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
