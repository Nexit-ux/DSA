class Solution {
    static int arr[] = {1,2,3,4,5,6,7,8,9};
    static List<Integer> lst = new ArrayList<>();
    static{
        for(int i=2 ; i<10 ; i++){
            int left = 0;
            int right = i-1;
            while(right < 9){
                StringBuilder sb = new StringBuilder();
                for(int j=left ; j<= right ; j++){
                    sb.append(arr[j]);
                }
                lst.add(Integer.parseInt(sb.toString()));
                left++;
                right++;
            }
        }
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0 ; i<lst.size() ; i++){
            int value = lst.get(i);
            if(value > high) break;
            if(low <= value && value <= high){
                ans.add(value);
            }
        }
        return ans;
    }
}