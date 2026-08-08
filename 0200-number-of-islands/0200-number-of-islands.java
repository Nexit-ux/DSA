class Solution {
    public void dfs(char[][] grid , int r , int c , int m , int n){
        char x = '2';
        grid[r][c] = x;
        int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1'){
                dfs(grid , nr , nc , m , n);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == '1'){
                    dfs(grid , i , j , m , n);
                    count++;
                }
            }
        }
        return count;
    }
}