class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0;
        long max = 0;
        long sum = 0;

        for (int i = 0; i < differences.length; i++) {
            sum += differences[i];
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        return (int) Math.max(0, upper - lower - (max - min) + 1);
        
    }
}