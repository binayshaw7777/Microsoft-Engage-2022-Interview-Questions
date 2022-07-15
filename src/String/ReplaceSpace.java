package String;//GFG: https://www.geeksforgeeks.org/urlify-a-given-string-replace-spaces-with-%20/
//Leetcode Discussion: https://leetcode.com/discuss/general-discussion/651658/understanding-urlify-code-from-cracking-the-code-interview-book

public class ReplaceSpace {
    public static void main(String[] args) {
        String url = "Sales Force Technologies";

        //Simplest way! Inbuilt function
        String newUrlString1 = url.replaceAll("\\s", "%20"); //Use "\\s" instead of " "
        System.out.println(newUrlString1);

        //Using StringBuilder
        String newUrlString2 = sbUrl(url);
        System.out.println(newUrlString2);
    }

    private static String sbUrl(String url) {
        StringBuilder sb = new StringBuilder();

        for (char c : url.toCharArray()) {
            if (c != ' ')
                sb.append(c);
            else
                sb.append("%20");
        }

        return sb.toString();
    }
}
