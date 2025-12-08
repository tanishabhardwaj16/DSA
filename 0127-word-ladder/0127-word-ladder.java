class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>set=new HashSet<>(wordList);
        Set<String>visited=new HashSet<>();
        Queue<String>q=new LinkedList<>();
        if(!set.contains(endWord)) return 0;
        q.add(beginWord);
        visited.add(beginWord);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size--> 0){
                String word=q.poll();
                if(word.equals(endWord)) return level;
                char[] arr=word.toCharArray();
                for(int i=0;i<arr.length;i++){
                    char original=arr[i];
                    for(char ch='a' ; ch<='z'; ch++){
                        if(ch==original)continue;
                        arr[i]=ch;
                        String newWord=new String(arr);
                        if(set.contains(newWord) && !visited.contains(newWord)){
                            visited.add(newWord);
                            q.add(newWord);
                        }
                    }
                    arr[i]=original;
                }
            }
            level++;
        }
        return 0;
    }
}