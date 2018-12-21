package com.kerkeb.jrpg.classes;

import com.kerkeb.jrpg.player.Player;

public interface Action {

    void basicAttack(Player target);

    void specialAttack(Player target);

}
