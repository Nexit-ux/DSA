class Solution {
    class pair{
        int p1;
        int p2;
        public pair(int p1 , int p2){
            this.p1 = p1;
            this.p2 = p2;
        }
    }
    public pair winner(int arr[] , int i , int j , int turn){
        if(i > j) return new pair(0,0);
        pair left = winner(arr , i+1 , j , turn+1);
        pair right = winner(arr , i , j-1 , turn+1);
        if(turn % 2 == 0){
            if((left.p1 + arr[i]) >= (right.p1 + arr[j])) return new pair(left.p1+arr[i] , left.p2);
            else return new pair(right.p1+arr[j] , right.p2);
        }
        else{
            if((left.p2 + arr[i]) >= (right.p2 + arr[j])) return new pair(left.p1 , left.p2+arr[i]);
            else return new pair(right.p1 , right.p2+arr[j]);
        }
    }
    public boolean predictTheWinner(int[] nums) {
        int i=0 , j = nums.length-1;
        pair ans = winner(nums , i , j , 0);
        if(ans.p1 >= ans.p2) return true;
        return false; 
    }
}