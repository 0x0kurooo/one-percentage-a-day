class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        minCost[0] = cost[0];
        minCost[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            minCost[i] = Math.min(cost[i] + minCost[i - 1], cost[i] + minCost[i - 2]);
        }

        return Math.min(minCost[cost.length - 1], minCost[cost.length - 2]);
    }
}
