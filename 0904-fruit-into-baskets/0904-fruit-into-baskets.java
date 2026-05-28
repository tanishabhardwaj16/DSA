class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer>map=new HashMap<>();
        int s=0;
        int e=0;
        int maxlen=0;
        for(e=0;e<fruits.length;e++){
            map.put(fruits[e],map.getOrDefault(fruits[e],0)+1);
            while(map.size()>2){
                map.put(fruits[s],map.get(fruits[s])-1);
                if(map.get(fruits[s])==0){
                    map.remove(fruits[s]);
                }
                s++;
            }
            maxlen=Math.max(maxlen,e-s+1);
        }
        return maxlen;
    }
}