class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, "", new ArrayList<>());
        return result;
    }

    public void backtrack(String s, int idx, String path, List<String> partitions) {
        if (idx >= s.length()) {
            int len = 0;
            for (String substring: partitions) {
                if (!isPalindrome(substring)) return;
                len += substring.length();
            }

            if (len != s.length()) return;
            result.add(new ArrayList<>(partitions));
            return;
        }
        
        // Init state
        // - partitions: [] -> []
        // - path: "" -> "a"

        // We have 2 choices: use this char and continue find the partition left
        // path -> "aa"
        String current = String.valueOf(s.charAt(idx));
        path = path + current;
        backtrack(s, idx + 1, path, partitions);
        
        // Or continue without partitioning
        // - partitions: [] -> ["a"]
        partitions.add(path);
        backtrack(s, idx + 1, "", partitions);
        partitions.removeLast();
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }

        return true;
    }
}
