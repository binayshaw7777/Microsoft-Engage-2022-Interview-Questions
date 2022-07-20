package String;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {
    public static void main(String[] args) {
        String st = "deeedbbcccbdaa";
        int size = 3;
        System.out.println(removeDuplicates1(st, size)); //Doesn't works in all cases
        System.out.println(removeDuplicates2(st, size)); //Accepted
        System.out.println(removeDuplicates3(st, size)); //Recursion (Works in Java) (TLE in C++) (Not tested in other languages)
    }
    private static String removeDuplicates1(String st, int size) {
        Stack<Character> main = new Stack<>();

        for(char c: st.toCharArray()){
            Stack<Character> temp = new Stack<>();
            temp.push(c);

            while(!main.isEmpty() && main.peek()==c){
                temp.push(main.pop());
            }

            if(temp.size()!=size){
                while(!temp.isEmpty()){
                    main.push(temp.pop());
                }
            }
        }

        StringBuilder sb= new StringBuilder();

        while(!main.isEmpty()){
            sb.append(main.pop());
        }

        return sb.reverse().toString();
    }
    public static String removeDuplicates2(String s, int k) {
        Stack<int[]> main = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!main.isEmpty() && main.peek()[0] == c)
                main.peek()[1]++;
            else
                main.push(new int[]{c, 1});

            if (main.peek()[1] == k)
                main.pop();

        }

        StringBuilder sb = new StringBuilder();

        while (!main.isEmpty()) {
            int[] top = main.pop();

            while (top[1]-- > 0)
                sb.append((char) top[0]);
        }

        return sb.reverse().toString();
    }

    private static String removeDuplicates3(String st, int size) {
        int count = 1;
        for(int i=1;i<st.length();i++){
            if(st.charAt(i)==st.charAt(i-1)){
                count++;
            }
            else{
                count=1;
            }

            if(count==size){
                String reduced = st.substring(0,i-size+1) + st.substring(i+1);
                return removeDuplicates3(reduced,size);
            }
        }

        return st;
    }

}
