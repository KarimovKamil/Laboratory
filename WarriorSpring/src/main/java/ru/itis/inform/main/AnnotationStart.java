package ru.itis.inform.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ru.itis.inform.AppConfig;
import ru.itis.inform.interfaces.Warrior;

/**
 * Created by Kamil Karimov on 15.02.2017.
 */
public class AnnotationStart {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Warrior warrior = (Warrior) context.getBean("knight");
        warrior.attack();
        warrior.attack();
        warrior.defend();
    }
}
