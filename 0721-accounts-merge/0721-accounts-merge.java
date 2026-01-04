class Solution {
    class DSU{
        int[] parent;
        DSU(int n){
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        boolean union(int x,int y){
            int px=find(x);
            int py=find(y);
            if(px==py)return false;
            if(px!=py) parent[py]=px;
            return true;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> emailid=new HashMap<>();
        Map<String,String> emailname=new HashMap<>();
        int id=0;
        for(List<String>acc : accounts){
            String name=acc.get(0);
            for(int i=1;i<acc.size();i++){
                String email=acc.get(i);
                if(!emailid.containsKey(email)){
                    emailid.put(email,id++);
                    emailname.put(email,name);
                }
            }
        }
        DSU dsu=new DSU(id);
        for(List<String>acc : accounts){
            int firstemail=emailid.get(acc.get(1));
            for(int i=2;i<acc.size();i++){
                dsu.union(firstemail,emailid.get(acc.get(i)));
            }
        }
        Map<Integer,List<String>>groups=new HashMap<>();
        for(String email:emailid.keySet()){
            int root=dsu.find(emailid.get(email));
            groups.computeIfAbsent(root,x->new ArrayList<>()).add(email);
        }
        List<List<String>>result=new ArrayList<>();
        for(List<String>emails:groups.values()){
            Collections.sort(emails);
            List<String>merged=new ArrayList<>();
                merged.add(emailname.get(emails.get(0)));
                merged.addAll(emails);
                result.add(merged);
        }
        return result;
    }
}