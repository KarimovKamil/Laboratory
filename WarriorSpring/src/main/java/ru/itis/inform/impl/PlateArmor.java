package ru.itis.inform.impl;

import org.springframework.stereotype.Component;
import ru.itis.inform.interfaces.Armor;

/**
 * Created by Kamil Karimov on 14.02.2017.
 */
@Component
public class PlateArmor implements Armor {
    private int durability = 30;

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
