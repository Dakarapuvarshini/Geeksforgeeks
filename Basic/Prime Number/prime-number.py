#User function Template for python3
import math
class Solution:
    def isPrime(self, N):
        # code here
        if N<=1:
            return 0
        c = 0
        for i in range(2,int(math.sqrt(N))+1):
            if N%i == 0:
                c+=1
        if c>=1:
            return 0
        else:
            return 1


#{ 
 # Driver Code Starts
# Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())  # Read number of test cases
    for _ in range(t):
        n = int(input())  # Read the number to check primality

        ob = Solution()
        # Using Python's conditional expression for true/false
        print("true" if ob.isPrime(n) else
              "false")  # Print "true" if prime, else "false"
        print("~")

# } Driver Code Ends