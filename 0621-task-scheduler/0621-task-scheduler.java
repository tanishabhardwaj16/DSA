class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char c: tasks){
            freq[c - 'A']++;
        }
        Arrays.sort(freq);
        int maxfreq=freq[25];
        int maxCount=1;
        for(int i=24;i>=0;i--){
            if(freq[i]==maxfreq){
                maxCount++;
            }else{
                break;
            }
        }
        int result=(maxfreq-1)*(n+1)+maxCount;
        return Math.max(result,tasks.length);
    }
}