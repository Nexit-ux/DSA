class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0 ; i<nums.length-2 ; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;     
            int target = nums[i];
            int left = i+1 , right = nums.length-1;
            while(left < right){
                if((target + nums[left] + nums[right]) == 0){
                    List<Integer> lst = new ArrayList<>();
                    lst.addAll(Arrays.asList(target , nums[left] , nums[right]));
                    ans.add(lst);
                    while(left < right && nums[left+1] == nums[left]) left++;
                    while(right > left && nums[right-1] == nums[right]) right--;
                    left++;
                    right--;
                }
                else if((nums[left] + nums[right] + target) < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return ans;
    }
}