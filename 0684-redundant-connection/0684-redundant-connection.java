class Solution {
    int n;
    int arr[];
    int rank[];

    public void init(int n){
        this.n = n;
        arr = new int[n+1];
        rank = new int[n+1];
        for(int i=0 ; i<n ; i++){
            arr[i] = i;
        }
    }
    public void union(int a , int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            arr[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA] < rank[parB]){
            arr[parA] = parB;
        }
        else{
            arr[parB] = parA;
        }
    }
    public int find(int x){
        if(arr[x] == x) return x;
        return find(arr[x]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        init(n);
        int arr[] = new int[2];
        for(int i=0 ; i<n ; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            if(find(a) == find(b)){
                arr[0] = a;
                arr[1] = b;
            }
            else{
                union(a , b);
            }
        }
        return arr;
    }
}