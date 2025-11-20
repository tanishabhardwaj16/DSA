class Twitter {
    private static int timestamp=0;
    class Tweet{
        int id;
        int time;
        Tweet next;
        Tweet(int id,int time){
            this.id=id;
            this.time=time;
            this.next=null;
        }
    }
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer,Tweet> tweets;
    public Twitter() {
        followMap=new HashMap<>();
        tweets=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        followMap.putIfAbsent(userId, new HashSet<>());
        Tweet newT=new Tweet(tweetId,timestamp++);
        newT.next=tweets.get(userId);
        tweets.put(userId,newT);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result=new ArrayList<>();
        if(!followMap.containsKey(userId)) return result;
        PriorityQueue<Tweet> maxheap=new PriorityQueue<>((a,b)->b.time-a.time);
        if(tweets.containsKey(userId)){
            maxheap.offer(tweets.get(userId));
        }
        for(int followee : followMap.get(userId)){
            if(tweets.containsKey(followee)){
                maxheap.offer(tweets.get(followee));
            }
        }
        while(!maxheap.isEmpty() && result.size()<10){
            Tweet t= maxheap.poll();
            result.add(t.id);
            if(t.next != null) maxheap.offer(t.next);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        followMap.putIfAbsent(followerId,new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */