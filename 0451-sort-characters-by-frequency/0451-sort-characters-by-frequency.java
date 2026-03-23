class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int value : map.values()) {
            ans.add(value);
        }
        Collections.sort(ans);
        Collections.reverse(ans);
        StringBuilder sb = new StringBuilder();
        for (int val : ans) {
            Character freqMatched = null;
            for (char key : map.keySet()) {
                if (map.get(key) == val) {
                    freqMatched = key;
                    break;
                }
            }
            if (freqMatched != null) {
                for (int i = 0; i < val; i++) {
                    sb.append(freqMatched);
                }
                map.remove(freqMatched);
            }
        }
        return sb.toString();
    }
}