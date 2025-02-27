class Solution:
    def findDuplicates(self, arr): 
        # code here
          d={}
          for i in arr:
                if i not in d:
                  d[i]=1
                else:
                   d[i]+=1
          c=[]
          for i in d.keys():
              if d[i]!=1:
                  c.append(i)
          if len(c)==0:
              return []
          return sorted(c)



#{ 
 # Driver Code Starts
# Initial Template for Python 3

t = int(input())  # number of test cases
for _ in range(t):
    arr = list(map(int, input().split()))  # input array
    s = Solution().findDuplicates(arr)  # find the duplicates
    # Sort the result in ascending order
    s.sort()
    # Output formatting
    if s:
        print(" ".join(map(str, s)))  # Print duplicates in ascending order
    else:
        print("[]")  # Print empty list if no duplicates are found
    print("~")

# } Driver Code Ends