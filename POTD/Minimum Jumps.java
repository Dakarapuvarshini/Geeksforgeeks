class Solution {
     static int minJumpsRecur(int i, int[] arr, int[] memo) {
        if (i == arr.length - 1)
            return 0;
        if (memo[i] != -1) return memo[i];
        int ans = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
            int val = minJumpsRecur(j, arr, memo);
            if (val != Integer.MAX_VALUE)
                ans = Math.min(ans, 1 + val);
        }
        return memo[i] = ans;
    }

    static int minJumps(int[] arr) {

        int[] memo = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            memo[i] = -1;
        }

        int ans = minJumpsRecur(0, arr, memo);

        if (ans == Integer.MAX_VALUE)
            return -1;

        return ans;
    }

}
