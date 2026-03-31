class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            n=-n;
            return 1/solve(x,n);
        }
        return solve(x,n);
    }
    public double solve(double x,int n){
        if(n==0) return 1;
        double half=solve(x,n/2);
        if(n%2==0){
            return half*half;
        }
        else{
            return x*half*half;
        }
    }
}