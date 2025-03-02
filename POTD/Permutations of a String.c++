class Solution
{
	public:
		vector<string>find_permutation(string S)
		{
		    set<string> ans;
		    int n = S.size();
		    vector<bool> vis(n, 0);
		    
		    function<void(int, string)> traverse = [&](int p, string current) {
		        if(p == n){
		            ans.insert(current);
		            return;
		        }  
		        
		        for(int i = 0; i < n; i++){
		            if(!vis[i]){
		                vis[i] = 1;
		                current += S[i];
		                traverse(p + 1, current);
		                current.pop_back();
		                vis[i] = 0;
		            }
		        }
		    };
		    
		    traverse(0, "");
		    
		    vector<string> toreturn;
		    for(auto i : ans)
		        toreturn.push_back(i);
		    
		    return toreturn;
		}
};
