class Solution {
    class pair{
        int val;
        int row;
        public pair(int val , int row){
            this.val = val;
            this.row = row;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int size = nums.size();
        List<pair> lst = new ArrayList<>();
        for(int i=0 ; i<size ; i++){
            for(int j=0 ; j<nums.get(i).size() ; j++){
                lst.add(new pair(nums.get(i).get(j) , i));
            }
        }
        lst.sort((p1 , p2) -> Integer.compare(p1.val , p2.val));
        HashMap<Integer , Integer> hm = new HashMap<>();
        int left = 0;
        int right = 0;
        int min = lst.get(0).val;
        int max = 1;
        int minRange = Integer.MAX_VALUE;
        int arr[] = {Integer.MAX_VALUE , Integer.MIN_VALUE};
        for(int i=0 ; i<lst.size() ; i++){
            max = lst.get(i).val;
            hm.put(lst.get(i).row , hm.getOrDefault(lst.get(i).row , 0)+1);
            while(hm.size() == size){
                min = lst.get(left).val;
                if( (max - min) < minRange ){
                    minRange = max - min;
                    arr[0] = min;
                    arr[1] = max;
                }
                int r = lst.get(left).row;
                int freq = hm.get(r);
                if(freq > 1){
                    hm.put(r , freq-1);
                }
                else{
                    hm.remove(r);
                }
                left++;
            }
        }
        return arr;
    }
}