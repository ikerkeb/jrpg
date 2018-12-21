package com.kerkeb.jrpg;

import com.kerkeb.jrpg.classes.Warrior;
import com.kerkeb.jrpg.player.Player;

public class Main {

    public static void main() {
        Player player = new Warrior(100,80,20,0);

        System.out.println(player.getLevel());
    }

}
