class GFG 
{
static void dfs(Vector<Integer> graph[], 
                   int node, int dist[],
                   boolean vis[], int c)
{
    if (vis[node])
    {
        return;
    }
    vis[node] = true;
    dist[node] = c;
 
    for (int i = 0; i < graph[node].size(); i++) 
    {
      
        if (!vis[graph[node].get(i)]) 
        {
            dfs(graph, graph[node].get(i),
                        dist, vis, c + 1);
        }
    }
}
