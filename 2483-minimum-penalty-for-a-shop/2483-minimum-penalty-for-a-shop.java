class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int minhr=0;
        int[] prefix=new int[n+1];
        int[] suffix=new int[n+1];
        int[] ans=new int[n+1];
        prefix[0]=0;
        suffix[n]=0;
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+(customers.charAt(i-1)=='N' ? 1 : 0);
        }
        for(int i=n-1;i>=0;i--){
            suffix[i]=suffix[i+1]+(customers.charAt(i)=='Y' ? 1 : 0);
        }
        for(int i=0;i<=n;i++){
            ans[i]=prefix[i]+suffix[i];
        }
        for(int i=1;i<=n;i++){
            if(ans[i]<ans[minhr]){
                minhr=i;
            }
        }
        return minhr;
    }
}