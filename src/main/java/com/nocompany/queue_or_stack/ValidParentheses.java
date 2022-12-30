package com.nocompany.queue_or_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String input = "()[]{}";

        boolean result = isValid(input);

        System.out.println("Result: " + result);
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char aChar : chars) {
            if (mappings.containsKey(aChar) && stack.isEmpty()) {
                return false;
            }

            if (stack.isEmpty()) {
                stack.push(aChar);
                continue;
            }

            Character previous = stack.peek();
            if (mappings.get(aChar) != null && mappings.get(aChar).equals(previous)) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }

        return stack.isEmpty();
    }

    public boolean isValidOfficial(String s) {

        Map<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
