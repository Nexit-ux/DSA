class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> lst = new ArrayList<>();
        Arrays.sort(nums);
        int idx = 0;
        for(int i=nums[0] ; i <= nums[nums.length-1] ; i++){
            if(nums[idx] != i){
                lst.add(i);
            }else{
                idx++;
            }
        }
        return lst;
    }
}