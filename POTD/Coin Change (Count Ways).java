class Solution {
   
    static int countRecur(int[] coins, int n, int sum, int[][] memo) {

     
        if (sum == 0) return 1;

        // 0 ways in the following two cases
        if (sum < 0 || n == 0) return 0;

        if (memo[n - 1][sum] != -1) return memo[n - 1][sum];

        return memo[n - 1][sum] = 
                countRecur(coins, n, sum - coins[n - 1], memo) + 
                countRecur(coins, n - 1, sum, memo);
    }

    static int count(int[] coins, int sum) {
        int[][] memo = new int[coins.length][sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return countRecur(coins, coins.length, sum, memo);
    }

}
