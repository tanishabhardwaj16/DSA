class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>>rev=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        List<Integer>ans=new ArrayList<>();
        boolean[] safe=new boolean[n];
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            rev.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int child:graph[i]){
                rev.get(child).add(i);
                indegree[i]++;
            }
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.poll();
            safe[node]=true;
            for(int parent:rev.get(node)){
                indegree[parent]--;
                if(indegree[parent]==0)q.add(parent);
            }
        }
        for(int i=0;i<n;i++){
            if(safe[i]) ans.add(i);
        }
        return ans;
    }
}