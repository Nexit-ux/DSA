class Solution {
    public int gcd(int a , int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int max = nums[0];
        int prefix[] = new int[nums.length];
        for(int i=0 ; i<nums.length ; i++){
            max = Math.max(max , nums[i]);
            prefix[i] = gcd(max , nums[i]);
        }
        Arrays.sort(prefix);
        long sum = 0;
        int p1 = 0 , p2 = prefix.length-1;
        while(p1 < p2){
            sum += gcd(prefix[p1] , prefix[p2]);
            p1++;
            p2--;
        }
        return sum;
    }
}