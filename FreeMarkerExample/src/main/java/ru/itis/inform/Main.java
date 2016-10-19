package ru.itis.inform;

import freemarker.template.Configuration;
import freemarker.template.Template;


import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        try {
            System.out.println(new File("dfdsf").getAbsolutePath());
            Template template = cfg.getTemplate("src\\main\\java\\ru\\itis\\inform\\helloworld.ftl");

            Map<String, Object> data = new HashMap<String, Object>();
            data.put("message", "Hello World!!!");

            List<String> countries = new ArrayList<String>();
            countries.add("Russia");
            countries.add("USA");
            countries.add("Germany");
            countries.add("Italy");

            data.put("countries", countries);

            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();

            Writer file = new FileWriter(new File("FTL_helloworld.txt"));
            template.process(data, file);
            file.flush();
            file.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }
}
