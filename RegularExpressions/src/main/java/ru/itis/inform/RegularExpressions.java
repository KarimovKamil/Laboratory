package ru.itis.inform;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    private String string;
    private Pattern pattern;
    private Matcher matcher;

    public RegularExpressions(String s) {
        string = s;
    }

    public void setString(String string) {
        this.string = string;
    }

    public boolean checkText() {
        pattern = Pattern.compile("([\\s]{4}[А-Я][а-я]*([,]?[\\s](([а-я]+)|([0-9)]+)))*[.?!])" +
                "(([\\s]|[\\s]{4})[А-Я][а-я]*([,]?[\\s](([а-я]+)|([0-9)]+)))*[.?!])*");
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public void replace(String sFrom, String sTo) {
        ReaderWriter rw = new ReaderWriter();
        pattern = Pattern.compile(sFrom);
        matcher = pattern.matcher(string);
        rw.writer(matcher.replaceAll(sTo));
    }

    public int numberOfOccurrences (String s) {
        pattern = Pattern.compile(s);
        matcher = pattern.matcher(string);
        int count = 0;
        while(matcher.find())
            count++;
        return count;
    }
}
