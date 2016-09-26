package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        ReaderWriter rw = new ReaderWriter();
        RegularExpressions re = new RegularExpressions(rw.reader());
        System.out.println(re.checkText());
    }
}
