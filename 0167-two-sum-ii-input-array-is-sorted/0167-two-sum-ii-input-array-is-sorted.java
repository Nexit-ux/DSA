class Solution {
    public int[] twoSum(int[] nums, int target) {
        int x = -1;
        int y = -1;
        int left = 0 , right = nums.length-1;
        while(left < right){
            int val = nums[left] + nums[right];
            if( val == target){
                x = left;
                y = right;
                break;
            }
            if(val > target){
                right--;
            }
            else{
                left++;
            }
        }
        int ans[] = {x+1 , y+1};
        return ans;
    }
}