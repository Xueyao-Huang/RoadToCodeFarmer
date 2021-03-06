class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        backtrack(s, res, new ArrayList<String>(), 0);
        return res;
    }
    private void backtrack(String s, List<List<String>> res, ArrayList<String> temp, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(temp));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                backtrack(s, res, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

// way better, 先构建一个lookup table，isPalindrome[i][j]
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        backtrack(s, res, new ArrayList<>(), 0, isPalindrome);
        return res;
    }
    
    private void backtrack(String s, List<List<String>> res, List<String> temp, int start, boolean[][] isPalindrome) {
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome[start][i]) {
                temp.add(s.substring(start, i + 1));
                backtrack(s, res, temp, i + 1, isPalindrome);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
