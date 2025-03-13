

class Solution {
    // Function to return max value that can be put in knapsack of capacity.
   static int knapsackRec(int W, int[] val, int[] wt, int n, int[][] memo) {

        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // Check if we have previously calculated the same subproblem
        if (memo[n][W] != -1)
            return memo[n][W];

        int pick = 0;

        // Pick nth item if it does not exceed the capacity of knapsack
        if (wt[n - 1] <= W)
            pick = val[n - 1] + knapsackRec(W - wt[n - 1], val, wt, n - 1, memo);

        // Don't pick the nth item
        int notPick = knapsackRec(W, val, wt, n - 1, memo);

        // Store the result in memo[n][W] and return it
        return memo[n][W] = Math.max(pick, notPick);
    }

    static int knapsack(int W, int[] val, int[] wt) {
        int n = val.length;

        // Memoization table to store the results
        int[][] memo = new int[n + 1][W + 1];

        // Initialize memoization table with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++)
                memo[i][j] = -1;
        }

        return knapsackRec(W, val, wt, n, memo);
    }
}
