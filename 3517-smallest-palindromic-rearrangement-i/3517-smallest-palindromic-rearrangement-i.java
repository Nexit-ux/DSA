class Solution {
    public String LexoHalf(String str , int half){
        int freq[] = new int[26];
        for(int i=0 ; i<str.length() ; i++){
            char x = str.charAt(i);
            freq[x - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        if(half == 1){
            for(int i=0 ; i<freq.length ; i++){
                if(freq[i] > 0){
                    int count = freq[i];
                    while(count-- > 0){
                        sb.append((char)(i+97));
                    }
                }
            }
        }
        else{
            for(int i=freq.length-1 ; i>= 0 ; i--){
                if(freq[i] > 0){
                    int count = freq[i];
                    while(count-- > 0){
                        sb.append((char)(i+97));
                    }
                }
            }
        }
        return sb.toString();
    }
    public String smallestPalindrome(String s) {
        if(s.length() == 1) return s;
        int mid = s.length()/2;
        String ans = "";
        if(s.length() % 2 != 0){
            char x = s.charAt(mid);
            ans += LexoHalf(s.substring(0 , mid) , 1);
            ans += x;
            ans += LexoHalf(s.substring(mid+1 , s.length()) , 2);
            return ans;
        }
        ans += LexoHalf(s.substring(0 , mid) , 1);
        ans += LexoHalf(s.substring(mid , s.length()) , 2);
        return ans;
    }
}