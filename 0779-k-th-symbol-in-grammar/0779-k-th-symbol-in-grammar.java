class Solution {
    public int kthGrammar(int n, int k) {
        return solve(n,k);
    }
    public int solve(double n,double k){
        if(n==1 && k==1) return 0;
        double len=Math.pow(2,n-1);
        double mid=len/2;
        if(k<=mid){
            return solve(n-1,k);
        }else{
            return 1-solve(n-1,k-mid); //for inversion
        }
    }
}