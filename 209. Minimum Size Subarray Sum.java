// O(n), 一头进，一头出
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        int j = 0;
        int sum = 0;
        
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

// O(nlgn)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 1;
        int end = nums.length;
        int min = 0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (windowExists(s, nums, mid)) {
                end = mid;
                min = mid;
            } else {
                start = mid + 1;
            }
        }
        if (windowExists(s, nums, min)) {
            return min;
        } 
        if (windowExists(s, nums, start)) {
            return start;
        }
        return 0;
    }
    
    private boolean windowExists(int s, int[] nums, int size) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (i >= size) {
                sum -= nums[i - size];
            }
            sum += nums[i];
            if (sum >= s) {
                return true;
            }
        }
        return false;
    }
}
