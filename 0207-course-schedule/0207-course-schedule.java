class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p : prerequisites){
            int u=p[0];
            int v=p[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        int count=0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0) q.add(nei);
            }
        }
        return count==numCourses;
    }
}