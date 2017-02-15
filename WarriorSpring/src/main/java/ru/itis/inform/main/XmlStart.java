package ru.itis.inform.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.inform.interfaces.Warrior;

public class XmlStart {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");

        Warrior warrior = (Warrior) context.getBean("knight");
        warrior.attack();
        warrior.attack();
        warrior.defend();
    }
}
