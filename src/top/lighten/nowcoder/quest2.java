package top.lighten.nowcoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class quest2 {
    static class Solution {
        char[] chars;
        ArrayList<Character> charList = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        public Solution(char[] chars) {
            this.chars = chars;
        }

        public List<String> solve() {
            dfs(0);
            return result;
        }

        public void dfs(int index) {
            if (index >= chars.length) {
                result.add(charList.toString());
                return;
            }
            char c = chars[index];
            for (int i = 0; i < charList.size() + 1; i++) {
                if (i - 1 > 0 && charList.get(i-1) == c) {
                    continue;
                }
                charList.add(i, c);
                dfs(index + 1);
                charList.remove(i);
            }
        }
    }


    public static void main(String[] args) {

        Solution solution = new Solution(new char[]{'a', 'b', 'a'});
        System.out.println(solution.solve());

    }
}
