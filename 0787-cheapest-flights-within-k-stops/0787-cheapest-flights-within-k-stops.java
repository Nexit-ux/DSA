class Solution {
    class edge{
        int s;
        int d;
        int c;
        public edge(int s , int d , int c){
            this.s = s;
            this.d = d;
            this.c = c;
        }
    }
    class info{
        int s;
        int w;
        int i;
        public info(int s , int w , int i){
            this.s = s;
            this.w = w;
            this.i = i;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<edge>> graph = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0 ; i<flights.length ; i++){
            int s = flights[i][0];
            int d = flights[i][1];
            int c = flights[i][2];
            graph.get(s).add(new edge(s , d , c));
        }
        int dist[] = new int[n];
        for(int i=0 ; i<n ; i++){
            if(i != src) dist[i] = Integer.MAX_VALUE;
        }
        Queue<info> q = new LinkedList<>();
        q.add(new info(src , 0 , 0));
        while(!q.isEmpty()){
            info curr = q.remove();
            if(curr.i > k) break;
            for(int i=0 ; i<graph.get(curr.s).size() ; i++){
                edge e = graph.get(curr.s).get(i);
                int u = e.s;
                int wt = e.c;
                int v = e.d;
                if((curr.w + wt) < dist[v]){
                    dist[v] = curr.w + wt;
                    q.add(new info(v , dist[v] , curr.i+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        else return dist[dst];
    }
}