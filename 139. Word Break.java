// 1
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int len = s.length();
        boolean[] res = new boolean[len + 1];
        Set<String> set = new HashSet<>(wordDict);
        res[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && set.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[len];
    }
}

// 2
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int len = s.length();
        boolean[] res = new boolean[len + 1];
        // ArrayList.contains() 的时间复杂度是O(n)， HashSet.contains() 的时间复杂度是O(1).
        // 如果有大量的检查是否包含操作，最好转换成O(1)的操作。
        Set<String> set = new HashSet<>();
        int min = 0;
        int max = 0;
        for (String str : wordDict) {
            set.add(str);
            min = Math.min(min, str.length());
            max = Math.max(max, str.length());
        }
        res[0] = true;
        for (int i = min; i <= len; i++) {
            // 这种方法j的意思是待检查str的长度
            for (int j = min; j <= max && j <= i; j++) {
                if (res[i - j] && set.contains(s.substring(i - j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[len];
    }
}
