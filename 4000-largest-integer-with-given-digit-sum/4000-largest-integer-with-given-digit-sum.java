class Solution {
    public int largestInteger(int n, int s) {
        if(s == 0) return 0;
        if(s > n*9) return -1;

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n ; i++){
            int x = Math.min(9 , s);
            sb.append(x);
            s = s-x;
        }
        return Integer.parseInt(sb.toString());
    }
}