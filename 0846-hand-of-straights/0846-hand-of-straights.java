class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int card : hand){
            freq.put(card,freq.getOrDefault(card,0)+1);
        }
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        minheap.addAll(freq.keySet());
        while(!minheap.isEmpty()){
            int first=minheap.peek();
            for(int i=0;i<groupSize;i++){
            int curr=first+i;
            if(!freq.containsKey(curr)){
                return false;
            }
            freq.put(curr,freq.get(curr)-1);
            if(freq.get(curr)==0){
                freq.remove(curr);
            if(minheap.peek()==curr){
                minheap.poll();
            }else{
                minheap.remove(curr);
            }
            }
          }
        }
        return true;
    }
}