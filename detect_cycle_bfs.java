class Node{
    int first;
    int second;
    
    public Node(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[])
    {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s,-1));
        vis[s]=true;
        
        while(!q.isEmpty())
        {
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();
            
            for(Integer it : adj.get(node))
            
            {
                if(vis[it]==false)
                {
                    q.add(new Node(it,node));
                    vis[it]=true;
                }
                else if(par!=it) return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis [] = new boolean[V+1];
        Arrays.fill(vis,false);
        for(int i=0;i<V;i++)
        {
            if(vis[i] == false)
            {
                if(checkForCycle(adj, i, vis))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
