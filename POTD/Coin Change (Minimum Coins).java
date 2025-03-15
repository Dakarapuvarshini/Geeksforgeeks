static int minCoinsRecur(int i, int sum, int[] coins, int[][] memo) {

        // base case
        if (sum == 0) return 0;
        if (sum < 0 || i == coins.length) return Integer.MAX_VALUE;
        
        if (memo[i][sum] != -1) return memo[i][sum];
        
        int take = Integer.MAX_VALUE;
        
        // take a coin only if its value
        // is greater than 0.
        if (coins[i] > 0) {
            take = minCoinsRecur(i, sum - coins[i], coins, memo);
            if (take != Integer.MAX_VALUE) take++;
        }
        // not take the coin 
        int noTake = minCoinsRecur(i + 1, sum, coins, memo);
        
        return memo[i][sum] = Math.min(take, noTake);
    }

    static int minCoins(int[] coins, int sum) {
        int[][] memo = new int[coins.length][sum + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        int ans = minCoinsRecur(0, sum, coins, memo);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
