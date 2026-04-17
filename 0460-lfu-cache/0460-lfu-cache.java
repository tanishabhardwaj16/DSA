class LFUCache {
    class Node{
        int key,value,freq;
        Node prev,next;
        Node(int k,int v){
            key=k;
            value=v;
            freq=1;
        }
    }
    class DLL{
        Node head,tail;
        int size;
        DLL(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
            size=0;
        }
        void insert(Node node){
            Node next=head.next;
            head.next=node;
            node.prev=head;
            node.next=next;
            next.prev=node;
            size++;
        }
        void remove(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
            size--;
        }
        Node removeLast(){
            if(size>0){
                Node node=tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }
    int capacity,minfreq;
    Map<Integer,Node> keymap;
    Map<Integer,DLL> freqmap;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        keymap=new HashMap<>();
        freqmap=new HashMap<>();
        minfreq=0;
    }
    
    public int get(int key) {
        if(!keymap.containsKey(key)) return -1;
        Node node=keymap.get(key);
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        if(keymap.containsKey(key)){
            Node node=keymap.get(key);
            node.value=value;
            update(node);
        }else {
            if (keymap.size() == capacity) {
                DLL list = freqmap.get(minfreq);
                Node lru = list.removeLast();
                keymap.remove(lru.key);
            }
            Node node = new Node(key, value);
            keymap.put(key, node);
            freqmap.computeIfAbsent(1, k -> new DLL()).insert(node);
            minfreq = 1;
        }
    }
    private void update(Node node) {
        int freq = node.freq;
        DLL list = freqmap.get(freq);
        list.remove(node);
        if (freq == minfreq && list.size == 0) {
            minfreq++;
        }
        node.freq++;
        freqmap.computeIfAbsent(node.freq, k -> new DLL()).insert(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */