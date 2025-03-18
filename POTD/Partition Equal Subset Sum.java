class Solution {
  
   static boolean isSubsetSum(int n, int[] arr,
                               int sum, int[][] memo) {
        // base cases
        if (sum == 0) 
            return true;
        if (n == 0) 
            return false;

        if (memo[n - 1][sum] != -1) 
            return memo[n - 1][sum] == 1;

        // If element is greater than sum, then ignore it
        if (arr[n - 1] > sum) 
            return isSubsetSum(n - 1, arr, sum, memo);

        // Check if sum can be obtained by any of the following
        // (a) including the current element
        // (b) excluding the current element
        memo[n - 1][sum] = (isSubsetSum(n - 1, arr, sum, memo) || 
        isSubsetSum(n - 1, arr, sum - arr[n - 1], memo)) ? 1 : 0;
        return memo[n - 1][sum] == 1;
    }

    static boolean equalPartition(int[] arr) {
      
        // Calculate sum of the elements in array
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // If sum is odd, there cannot be two 
        // subsets with equal sum
        if (sum % 2 != 0) 
            return false;

        int[][] memo = new int[arr.length][sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Find if there is subset with sum equal 
        // to half of total sum
        return isSubsetSum(arr.length, arr, sum / 2, memo);
    }

 

  
}
