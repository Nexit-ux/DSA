class Solution {
    public void sortColors(int[] nums) {
        int first = 0;
        int move = 0;
        int last = nums.length-1;
        while(move <= last){
            if(nums[move] == 0){
                nums[move] = nums[first];
                nums[first] = 0;
                move++;
                first++;
            }
            else if(nums[move] == 2){
                nums[move] = nums[last];
                nums[last] = 2;
                last--;
            }
            else{
                move++;
            }
        }
    }
}