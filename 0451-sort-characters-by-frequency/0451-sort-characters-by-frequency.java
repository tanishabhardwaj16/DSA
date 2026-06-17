class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        HashMap<Character,Integer>map=new HashMap<>();
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int value : map.values()){
            ans.add(value);
        }
        Collections.sort(ans);
        Collections.reverse(ans);
        StringBuilder sb=new StringBuilder();
        for(int val : ans){
            Character freqmatched=null;
            for(char key : map.keySet()){
                if(map.get(key)==val){
                    freqmatched=key;
                    break;
                }
            }
            if(freqmatched!=null){
                for(int i=0;i<val;i++){
                    sb.append(freqmatched);
                }
                map.remove(freqmatched);
            }
        }
        return sb.toString();
    }
}