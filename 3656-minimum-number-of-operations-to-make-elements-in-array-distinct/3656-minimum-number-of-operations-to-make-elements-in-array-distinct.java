

class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        
        int ops = 0;
        while (true) {
            Set<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;
            
            for (int num : list) {
                if (!seen.add(num)) {
                    hasDuplicate = true;
                    break;
                }
            }

            if (!hasDuplicate) break;

            int toRemove = Math.min(3, list.size());
            for (int i = 0; i < toRemove; i++) {
                list.remove(0);
            }
            ops++;
        }

        return ops;
    }
}
