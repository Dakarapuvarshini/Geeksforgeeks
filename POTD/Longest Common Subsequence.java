  static int lcsRec(String s1, String s2, int m, int n,
                   int[][] memo) {
        // Base Case
        if (m == 0 || n == 0)
            return 0;

        // Already exists in the memo table
        if (memo[m][n] != -1)
            return memo[m][n];

        // Match
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n]
                = 1 + lcsRec(s1, s2, m - 1, n - 1, memo);
        }

        // Do not match
        return memo[m][n]
            = Math.max(lcsRec(s1, s2, m, n - 1, memo),
                       lcsRec(s1, s2, m - 1, n, memo));
    }
    static int lcs(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m + 1][n + 1];

        // Initialize the memo table with -1
        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return lcsRec(s1, s2, m, n, memo);
    } 
