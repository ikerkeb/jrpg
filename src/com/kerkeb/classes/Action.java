package com.kerkeb.classes;

import com.kerkeb.player.Player;

public interface Action {

    int basicAttack(Player target);

    int specialAttack(Player target);

}
