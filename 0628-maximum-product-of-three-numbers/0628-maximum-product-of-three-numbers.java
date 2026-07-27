class Solution {
    public int maximumProduct(int[] nums) {
        if(nums.length == 3) return nums[0]*nums[1]*nums[2];
        int fmin = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        int fmax = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        int tmax = Integer.MIN_VALUE;
        for(int i=0 ; i<nums.length ; i++){
            int x = nums[i];
            if(x < fmin){
                smin = fmin;
                fmin = x;
            }
            else if(x < smin){
                smin = x;
            }

            if(x > fmax){
                tmax = smax;
                smax = fmax;
                fmax = x;
            }
            else if(x > smax){
                tmax = smax;
                smax = x;
            }
            else if(x > tmax){
                tmax = x;
            }
        }
        return Math.max(fmin*smin*fmax , fmax*smax*tmax);
    }
}