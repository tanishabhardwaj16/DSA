class Solution {
    boolean isSafe(int[][] board,int row,int col,int N){
        for(int i=0;i<col;i++){
            if(board[row][i]==1) return false;
        }
        for(int i=row,j=col;i>=0 && j>=0 ;i--,j--){
            if(board[i][j]==1) return false;
        }
        for(int i=row,j=col;i<N && j>=0 ;i++,j--){
            if(board[i][j]==1) return false;
        }
        return true;
    }
    boolean solve(int[][] board,int col,int N,List<List<String>>sol){
        if(col==N){
            ArrayList<String>temp=new ArrayList<>();
            for(int i=0;i<N;i++){
                StringBuilder row=new StringBuilder();
                for(int j=0;j<N;j++){
                    if(board[i][j]==1) row.append('Q');
                    else row.append('.');
                }
                temp.add(row.toString());
            }
            sol.add(temp);
            return true;
        }
        boolean found=false;
        for(int i=0;i<N;i++){
            if(isSafe(board,i,col,N)){
                board[i][col]=1;
                found=solve(board,col+1,N,sol) || found;
                board[i][col]=0;
            }
        }
        return found;
    }
    public List<List<String>> solveNQueens(int N) {
        int[][] board=new int[N][N];
        List<List<String>> sol=new ArrayList<>();
        solve(board,0,N,sol);
        return sol;
    }
}