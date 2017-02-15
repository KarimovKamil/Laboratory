package ru.itis.inform.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.itis.inform.interfaces.Armor;
import ru.itis.inform.interfaces.Warrior;
import ru.itis.inform.interfaces.Weapon;

/**
 * Created by Kamil Karimov on 14.02.2017.
 */
@Component
public class Knight implements Warrior {

    @Autowired
    Armor armor;
    @Qualifier("lance")
    @Autowired
    Weapon weapon;

    public Knight() {
    }

    public Knight(Armor armor, Weapon weapon) {
        this.armor = armor;
        this.weapon = weapon;
    }

    public void attack() {
        System.out.println("⚔ " + weapon.getDamage());
    }

    public void defend() {
        System.out.println("\uD83D\uDEE1 " + armor.getDurability());
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
