class Solution {
    static boolean dfs(List<List<Integer>> graph , int curr , boolean vis[] , boolean st[] , int n){
        vis[curr] = true;
        st[curr] = true;
        for(int i=0 ; i<graph.get(curr).size() ; i++){
            int x = graph.get(curr).get(i);
            if(vis[x]){
                if(st[x]){
                    return true;
                }
            }
            else{
                if(dfs(graph , x , vis , st , n)) return true;
            }
        }
        st[curr] = false;
        return false;
    }
    public boolean canFinish(int n , int[][] pre) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0 ; i<pre.length ; i++){
            int x = pre[i][1];
            int y = pre[i][0];
            graph.get(x).add(y);
        }

        boolean vis[] = new boolean[graph.size()];
        boolean st[] = new boolean[graph.size()];

        for(int i=0 ; i<graph.size() ; i++){
            if(!vis[i]){
                if(dfs(graph , i , vis , st , n)){
                    return false;
                }
            }
        }
        return true;
    }
}