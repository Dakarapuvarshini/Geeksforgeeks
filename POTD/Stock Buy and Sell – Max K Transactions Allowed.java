static int maxProfitUtil(int i, int k, int buy,
                             int[][][] memo, int[] prices)
    {

        // Base case: no transactions or end of list
        if (k <= 0 || i >= prices.length)
            return 0;

        if (memo[i][k][buy] != -1)
            return memo[i][k][buy];

        int result = 0, profit = 0;

        // If we are in a 'buy' state
        if (buy == 1) {

            // Buy at current price or skip
            profit
                = maxProfitUtil(i + 1, k, 0, memo, prices)
                  - prices[i];
            result = Math.max(result, profit);
        }
        else {

            // Sell at current price
            profit = prices[i]
                     + maxProfitUtil(i + 1, k - 1, 1, memo,
                                     prices);
            result = Math.max(result, profit);
        }

        // Skip current price
        profit = maxProfitUtil(i + 1, k, buy, memo, prices);
        result = Math.max(result, profit);

        memo[i][k][buy] = result;
        return result;
    }

    // Function to return max profit with k transactions
    static int maxProfit(int[] prices, int k)
    {
        int n = prices.length;

        // Initialize memoization array
        int[][][] memo = new int[n][k + 1][2];
        for (int[][] arr2D : memo)
            for (int[] arr1D : arr2D)
                Arrays.fill(arr1D, -1);

        // Start from first price in 'buy' state
        return maxProfitUtil(0, k, 1, memo, prices);
    }
