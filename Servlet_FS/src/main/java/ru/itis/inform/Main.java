package ru.itis.inform;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter directory:");
        String directory = sc.nextLine();
        List<String> list;
        FilesSeeker fs = new FilesSeeker();
        if (directory.equals("example")) {
            list = fs.findFile("C:\\Users\\kkami\\IdeaProjects", ".xml", new ArrayList<String>());
        } else {
            System.out.println("Enter mask of file name:");
            String mask = sc.nextLine();
            list = fs.findFile(directory, mask, new ArrayList<String>());
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}