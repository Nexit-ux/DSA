class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prod = 1;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = nums[0];
        for(int i=1 ; i<n ; i++){
            left[i] = left[i-1] * nums[i];
        }
        right[n-1] = nums[n-1];
        for(int i=n-2 ; i>=0 ; i--){
            right[i] = right[i+1] * nums[i];
        }
        for(int i=0 ; i<n ; i++){
            int x = 1 , y = 1;
            if(i != 0) x = left[i-1];
            if(i != n-1) y = right[i+1];
            nums[i] = x*y;
        }
        return nums;
    }
}