package ru.itis.inform;

import java.util.Stack;

public class ReversePolishNotation {

    public String convertToPRN(String s) {
        Stack<Character> stack = new Stack<Character>();
        String out = "";
        for (int i = 0; i < s.length(); i++) {
            if (isNumber(s.charAt(i))) {
                String number = "" + s.charAt(i);
                while (i < s.length() - 1 && isNumber(s.charAt(i + 1))) {
                    number += s.charAt(i + 1);
                    i++;
                }
                out += number + " ";
            } else if (s.charAt(i) == '(' || s.charAt(i) == '^') {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    out += stack.pop() + " ";
                }
                stack.pop();
            } else if (!stack.isEmpty() && priority(s.charAt(i)) > priority(stack.peek())) {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) != ' ') {
                while (!stack.isEmpty() && priority(s.charAt(i)) <= priority(stack.peek())) {
                    out += stack.pop() + " ";
                }
                stack.add(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            out += stack.pop() + " ";
        }
        return out;
    }

    public int calculateRPN(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (isNumber(s.charAt(i))) {
                int number = (int) s.charAt(i) - 48;
                while (isNumber(s.charAt(i + 1))) {
                    number = number*10 + (int) s.charAt(i + 1) - 48;
                    i++;
                }
                stack.add(number);
            } else if (s.charAt(i) == '^') {
                int a1 = stack.pop();
                int a2 = stack.pop();
                int number = a2;
                for (int j = 1; j < a1; j++) {
                    a2 *= number;
                }
                stack.add(a2);
            } else if (s.charAt(i) == '+') {
                int a1 = stack.pop();
                int a2 = stack.pop();
                stack.add(a1 + a2);
            } else if (s.charAt(i) == '-') {
                int a1 = stack.pop();
                int a2 = stack.pop();
                stack.add(a2 - a1);
            } else if (s.charAt(i) == '*') {
                int a1 = stack.pop();
                int a2 = stack.pop();
                stack.add(a1 * a2);
            } else if (s.charAt(i) == '/') {
                int a1 = stack.pop();
                int a2 = stack.pop();
                stack.add(a2 / a1);
            }
        }
        return stack.pop();
    }


    private int priority(Character token) {
        switch (token) {
            case '(' :
                return 1;
            case '+' :
            case '-' :
                return 2;
            case '*' :
            case '/' :
                return 3;
            case '^' :
                return 4;
        }
        return 0;
    }

    private boolean isNumber(Character c) {
        return (int)c > 47 && (int)c < 58;
    }

}
