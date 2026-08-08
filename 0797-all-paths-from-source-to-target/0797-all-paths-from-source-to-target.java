class Solution {
    public void dfs(int[][] graph , int curr , int des ,  List<Integer> lst , List<List<Integer>> ans){
        lst.add(curr);
        if(curr == des){
            ans.add(new ArrayList<>(lst));
        }
        for(int i=0 ; i<graph[curr].length ; i++){
            int next = graph[curr][i];
            dfs(graph , next , des , lst , ans);
        }
        lst.remove(lst.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int des = graph.length-1;
        dfs(graph , 0 , des , new ArrayList<>() , ans);
        return ans;
    }
}