package main.java.Stack;

import java.awt.*;
import java.util.Objects;
import java.util.Stack;

class Solution {

    String left = "{[(";
    String right = "}])";

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        // 当为左括号时  入栈   右括号时  出栈
        String[] strs = s.trim().split("");
        for (String str : strs) {
            if (Objects.equals(str,"")) continue;

            if(left.contains(str)) {
                stack.push(str);
            }else if (right.contains(str)) {
                if (stack.isEmpty()) {
                    return false;
                }
                String ls = stack.pop();

                switch (str) {
                    case "}":
                        if (!Objects.equals(ls, "{")) return false;
                        break;
                    case "]":
                        if (!Objects.equals(ls, "[")) return false;
                        break;
                    case ")":
                        if (!Objects.equals(ls, "(")) return false;
                        break;
                }
            }
        }

        if (!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid(""));
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
    }
}