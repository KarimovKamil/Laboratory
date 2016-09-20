package ru.itis.inform;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.equals("1")) {
            s = "3 + 4 * 4 / (1 - 5)^2";
        }
        s = rpn.convertToPRN(s);
        System.out.println(s);
        int n = rpn.calculateRPN(s);
        System.out.println(n);
    }
}
