class Solution {
    class pair{
        int i;
        int j;
        public pair(int i , int j){
            this.i = i;
            this.j = j;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<pair> q = new LinkedList<>();
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(mat[i][j] == 0){
                    q.add(new pair(i,j));
                    mat[i][j] = 0;
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            pair curr = q.remove();
            int r = curr.i;
            int c = curr.j;
            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1){
                    mat[nr][nc] = mat[r][c] + 1;
                    q.add(new pair(nr , nc));
                }
            }
        }
        return mat;
    }
}