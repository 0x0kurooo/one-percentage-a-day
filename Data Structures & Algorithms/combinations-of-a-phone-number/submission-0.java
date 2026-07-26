class Solution {
    Map<Character, List<Character>> charMap = Map.of(
        '2', List.of('a', 'b', 'c'),
        '3', List.of('d', 'e', 'f'),
        '4', List.of('g', 'h', 'i'),
        '5', List.of('j', 'k', 'l'),
        '6', List.of('m', 'n', 'o'),
        '7', List.of('p', 'q', 'r', 's'),
        '8', List.of('t', 'u', 'v'),
        '9', List.of('w', 'x', 'y', 'z')
    );

    List<String> res = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    public void backtrack(String digits, int idx, StringBuilder path) {
        if (idx >= digits.length()) {
            res.add(path.toString());
            return;
        }

        char currDigit = digits.charAt(idx);
        List<Character> characters = charMap.get(currDigit);
        for (Character c : characters) {
            path.append(c);
            backtrack(digits, idx + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
