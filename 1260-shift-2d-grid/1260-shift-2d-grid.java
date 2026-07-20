class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m*n;
        if(k > size) k %= size;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                list.add(grid[i][j]);
            }
        }
        while(k-- > 0){
            list.addFirst(list.removeLast());
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0 ; i<m ; i++){
            List<Integer> lst = new ArrayList<>();
            for(int j=0 ; j<n ; j++){
                lst.add(list.removeFirst());
            }
            ans.add(lst);
        }
        return ans;
    }
}