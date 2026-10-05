class Solution {
    public int findDuplicate(int[] nums) {
        int[] visited = new int[nums.length + 1];
        for (int num : nums) {
            if (visited[num] > 0) {
                return num;
            }
            visited[num] ++;
        }

        return nums.length + 1;
    }
}
