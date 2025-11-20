class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> minheap=new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int num : freq.keySet()){
            minheap.offer(new int[]{num,freq.get(num)});
            if(minheap.size()>k)minheap.poll();
        }
        int[] result=new int[k];
        int i=0;
        while(!minheap.isEmpty()){
            result[i++]=minheap.poll()[0];
        }
        return result;
    }
}