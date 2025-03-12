class Solution {
    public int minCostClimbingStairs(int[] cost) {
      

        int prevPrevStepCost = 0, prevStepCost = 0;
    

        for (int i = 2; i <= cost.length; ++i) {
            
            int currentStepCost = Math.min(prevStepCost + cost[i - 1], prevPrevStepCost + cost[i - 2]);
        
            prevPrevStepCost = prevStepCost;
            prevStepCost = currentStepCost;
        }
    
       
        return prevStepCost;
    }
};
