package String;//Leetcode: https://leetcode.com/problems/group-anagrams/

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] st = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(st);
        System.out.println(list);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String st = new String(c);
            if (!map.containsKey(st))
                map.put(st, new ArrayList<>());
            map.get(st).add(s);
        }

        return new ArrayList<>(map.values());
    }

}
