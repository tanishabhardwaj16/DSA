class StockSpanner {
    Stack<int[]>s;
    int idx;
    public StockSpanner() {
        s=new Stack<>();
        idx=-1;
    }
    
    public int next(int price) {
        idx++;
        while(!s.isEmpty() && s.peek()[0]<=price){
            s.pop();
        }
        int pge=s.isEmpty() ? -1 : s.peek()[1];
        s.push(new int[]{price,idx});
        return idx-pge;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */