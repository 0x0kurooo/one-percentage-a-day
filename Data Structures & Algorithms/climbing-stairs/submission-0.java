class Solution {
    public int climbStairs(int n) {
        // We can go with bottom up solution
        // Create an array with n slot 
        // Then the last slot is the ways to step to the top 
        // Then we sum up the ways can get their by going back 1 or 2 step 
        /*
        Dry run it
        n=2 [2 1]
        n=3 [3 2 1]
        n=4 [4 2 2 1]
        */

        if (n <= 2) return n;

        int[] ways = new int[n];

        ways[n-1] = 1;
        ways[n-2] = 2;

        for (int i = n - 3; i >= 0; i --) {
            ways[i] = ways[i+1] + ways[i+2];
        }

        return ways[0];
    }
}
