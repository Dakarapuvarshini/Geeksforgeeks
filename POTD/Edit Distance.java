class Solution {
    static int editDistRec(String s1, String s2, int m, int n, int[][] memo) {
      
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;

        // If value is memoized
        if (memo[m][n] != -1) return memo[m][n];

        // If last characters of two strings are same, nothing
        // much to do. Get the count for
        // remaining strings.
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) 
            return memo[m][n] = editDistRec(s1, s2, m - 1, n - 1, memo);

        // If last characters are not same, consider all three
        // operations on last character of first string,
        // recursively compute minimum cost for all three
        // operations and take minimum of three values.
        return memo[m][n] = 1 + Math.min(
            editDistRec(s1, s2, m, n - 1, memo),  
            Math.min(editDistRec(s1, s2, m - 1, n, memo),   
                     editDistRec(s1, s2, m - 1, n - 1, memo))
        );
    }

    // Wrapper function to initiate the recursive calculation
    static int editDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return editDistRec(s1, s2, m, n, memo);
    }

}
