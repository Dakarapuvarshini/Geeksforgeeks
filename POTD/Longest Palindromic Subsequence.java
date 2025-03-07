class solution{

static int lps(String s, int low, int high, int[][] memo) {

        // Base case
        if (low > high) return 0;

        // If there is only 1 character
        if (low == high)
            return 1;

        // If the value is already calculated
        if (memo[low][high] != -1) 
            return memo[low][high];

        // If the first and last characters match
        if (s.charAt(low) == s.charAt(high))
            return memo[low][high] = 
                    lps(s, low + 1, high - 1, memo) + 2;

        // If the first and last characters do not match
        return memo[low][high] = 
                Math.max(lps(s, low, high - 1, memo), 
                         lps(s, low + 1, high, memo));
    }

    static int longestPalinSubseq(String s) {

        // create memoization table
        int n = s.length();
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return lps(s, 0, n - 1, memo);
    }
}
