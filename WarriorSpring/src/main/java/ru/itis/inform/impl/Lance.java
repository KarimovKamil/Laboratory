package ru.itis.inform.impl;

import org.springframework.stereotype.Component;
import ru.itis.inform.interfaces.Weapon;

/**
 * Created by Kamil Karimov on 15.02.2017.
 */
@Component
public class Lance implements Weapon {
    private int damage = 45;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
