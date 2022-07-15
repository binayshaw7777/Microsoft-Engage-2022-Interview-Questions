package String;//Leetcode: https://leetcode.com/problems/simplify-path/

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
    }

    public static String simplifyPath(String path) {
        StringBuilder canonicalPath = new StringBuilder();

        Stack<String> pathItems = new Stack<>();
        String[] folders = path.split("/");

        for (int i = 0; i < folders.length; i++) {
            if (folders[i].equals(".") || folders[i].isEmpty()) {
                continue;
            } else if (folders[i].equals("..")) {
                if (!pathItems.isEmpty()) {
                    pathItems.pop();
                }
            } else {
                pathItems.push(folders[i]);
            }
        }


        for (String s : pathItems) {
            canonicalPath.append("/");
            canonicalPath.append(s);
        }

        return canonicalPath.length() > 0 ? canonicalPath.toString() : "/";
    }
}
