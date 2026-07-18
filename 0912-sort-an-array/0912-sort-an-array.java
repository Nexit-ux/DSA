class Solution {
    public void hepify(int arr[] , int n , int idx){
        int left = 2*idx+1;
        int right = 2*idx+2;
        int maxIdx = idx;

        if(left < n && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < n && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != idx){
            int temp = arr[idx];
            arr[idx] = arr[maxIdx];
            arr[maxIdx] = temp;
            hepify(arr , n , maxIdx);
        }
    }
    public void HeapSort(int nums[]){
        int n = nums.length;
        for(int i=n/2 ; i>=0 ; i--){
            hepify(nums , n , i);
        }

        for(int i=n-1 ; i>=0 ; i--){
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            hepify(nums , i , 0);
        }
    }
    public int[] sortArray(int[] nums) {
        HeapSort(nums);
        return nums;
    }
}