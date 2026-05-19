class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        int[] indegree=new int[numCourses];
        int[] ans=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p : prerequisites){
            int u=p[0];
            int v=p[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        int index=0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.poll();
            ans[index++]=node;
            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0) q.add(nei);
            }
        }
        return index==numCourses ? ans : new int[]{};
    }
}