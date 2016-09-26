package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReaderWriter {

    public String reader() {
        String s = "";
        try {
            Scanner scn = new Scanner(new File("C:\\Users\\kkami\\IdeaProjects\\RegularExpressions\\src\\main\\resources\\input.txt"));
            while (scn.hasNext()) {
                s += scn.nextLine();
            }
            scn.close();
        } catch (FileNotFoundException e) {
            System.out.println("404. File not found.");
        }
        return s;
    }

    public void writer(String s) {
        try {
            PrintWriter scn = new PrintWriter(new File("C:\\Users\\kkami\\IdeaProjects\\RegularExpressions\\src\\main\\resources\\output.txt"));
            scn.println(s);
            scn.close();
        } catch (FileNotFoundException e) {
            System.out.println();
        }

    }
}
