class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int[] freq = new int[100001];
        int uniqueCount = 0;
        for (int num : nums) {
            if (freq[num] == 0) {
                uniqueCount++;
            }
            freq[num]++;
        }

        int left = 0, right = 0, count = 0;
        int[] windowFreq = new int[100001];
        int windowUniqueCount = 0;

        while (right < n) {
          
            if (windowFreq[nums[right]] == 0) {
                windowUniqueCount++;
            }
            windowFreq[nums[right]]++;
            right++;

            
            while (windowUniqueCount == uniqueCount) {
                count += n - right + 1; 
                windowFreq[nums[left]]--;
                if (windowFreq[nums[left]] == 0) {
                    windowUniqueCount--;
                }
                left++;
            }
        }

        return count;

        
    }
}