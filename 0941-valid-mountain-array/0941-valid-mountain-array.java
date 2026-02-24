class Solution {
    public boolean validMountainArray(int[] arr) {
        int n=arr.length;
        if(n<3)return false;
        int s=0;
        int e=n-1;
        int mid=s+(e-s)/2;
        while(s<e){
            if(arr[mid]<=arr[mid+1]){
                s=mid+1;
            }else{
                e=mid;
            }
            mid=s+(e-s)/2;
        }
        int peak=s;
        if(peak==n-1 || peak==0)return false;
        for(int i=0;i<peak;i++){
            if(arr[i]>=arr[i+1]){
                return false;
            }
        }
        for(int i=peak;i<n-1;i++){
            if(arr[i]<=arr[i+1]){
                return false;
            }
        }
        return true;
    }
}