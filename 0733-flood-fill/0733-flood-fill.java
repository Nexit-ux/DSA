class Solution {
    public void dfs(int[][] image , boolean vis[][] ,  int r , int c , int color , int x){
        vis[r][c] = true;
        image[r][c] = color;
        int m = image.length;
        int n = image[0].length;
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == x && !vis[nr][nc]){
                dfs(image , vis , nr , nc , color , x);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int x = image[sr][sc];
        boolean vis[][] = new boolean[image.length][image[0].length];
        dfs(image , vis , sr , sc , color , x);
        return image;
    }
}