class Solution:
    def findSum(self,A,N): 
        #code here
        min1 = min(A)
        max1 = max(A)
        return max1+min1


#{ 
 # Driver Code Starts
#Initial Template for Python 3



t=int(input())
for _ in range(0,t):
    n=int(input())
    a=list(map(int,input().split()))
    ob = Solution()
    print(ob.findSum(a,n))
    print("~")
# } Driver Code Ends