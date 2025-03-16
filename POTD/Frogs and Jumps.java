class GfG {
    static int minCostRec(int n, int[] height) {
        
        if (n == 1)
            return 0;

        if (n == 2)
            return Math.abs(height[n - 1] - height[n - 2]);
        
        return Math.min(minCostRec(n - 1, height) 
                            + Math.abs(height[n - 1] - height[n - 2]),
                        minCostRec(n - 2, height) 
                            + Math.abs(height[n - 1] - height[n - 3]));
    }

    static int minCost(int[] height) {
        int n = height.length;
        return minCostRec(n, height);
    }
