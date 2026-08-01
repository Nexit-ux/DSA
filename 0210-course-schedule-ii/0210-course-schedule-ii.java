class Solution {
    public int[] findOrder(int n , int[][] pre) {
        int arr[] = new int[n];
        int ans[] = new int[n];
        // if(pre.length == 0) return arr;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0 ; i<pre.length ; i++){
            int x = pre[i][0];
            int y = pre[i][1];
            graph.get(y).add(x);
            arr[x]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] == 0) q.add(i);
        }
        int idx=0;
        while(!q.isEmpty()){
            int curr = q.remove();
            ans[idx++] = curr;
            for(int i=0 ; i<graph.get(curr).size() ; i++){
                int d = graph.get(curr).get(i);
                arr[d]--;
                if(arr[d] == 0) q.add(d);
            }
        }
        if(idx != n) return new int[0];
        return ans;
    }
}