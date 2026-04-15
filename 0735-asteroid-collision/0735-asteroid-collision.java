class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer>s=new Stack<>();
        for(int a : asteroids){
            if(a>0){
                s.push(a);
            }else{
                while(!s.isEmpty() && s.peek()>0 && s.peek()<-a){
                    s.pop();
                   
                }
                if(s.isEmpty() || s.peek()<0){
                    s.push(a);
                }
                if(!s.isEmpty() && s.peek()==-a){
                    s.pop();
                }
            }          
        }
        int[] res=new int[s.size()];
        for(int i=s.size()-1;i>=0;i--){
            res[i]=s.pop();
        }
        return res;
    }
}