class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long x = 0;
        while(n > 0){
            int rem = (int)n%10;
            if(rem != 0){
                sum += rem;
                x = x*10 + rem;
            }
            n = n/10;
        }
        long temp = 0;
        while(x > 0){
            int rem = (int)x%10;
            temp = temp*10 + rem;
            x = x/10;
        }
        long res = sum*temp;
        return res;
    }
}