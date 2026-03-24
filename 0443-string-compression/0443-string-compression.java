class Solution {
    public int compress(char[] chars) {
        int i=0;
        int index=0;
        int n=chars.length;
        while(i<n){
            int count=0;
            char curr=chars[i];
            while(i<n && chars[i]==curr){
                i++;
                count++;
            }
            chars[index++]=curr;
            if(count>1){
                String s=String.valueOf(count);
                for(char ch : s.toCharArray()){
                    chars[index++]=ch;
                }
            }
        }
        return index;
    }
}