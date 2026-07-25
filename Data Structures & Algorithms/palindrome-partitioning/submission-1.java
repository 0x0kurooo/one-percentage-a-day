class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(String s, int start, List<String> partitions) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(partitions));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                partitions.add(s.substring(start, end + 1));
                backtrack(s, end + 1, partitions);
                partitions.removeLast();
            }
        }        
    }

    public boolean isPalindrome(String s, int left, int right) {
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
