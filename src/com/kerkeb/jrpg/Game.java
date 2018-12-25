package com.kerkeb.jrpg;

import com.kerkeb.jrpg.classes.Mage;
import com.kerkeb.jrpg.classes.Thief;
import com.kerkeb.jrpg.classes.Warrior;
import com.kerkeb.jrpg.player.*;

import java.util.HashMap;
import java.util.Scanner;

public class Game {

    boolean gameOver = false;

    public Player createCharacter(HashMap character) {
        int classType = (int) character.get("class");
        int level = (int) character.get("level");
        int strength = (int) character.get("strength");
        int agility = (int) character.get("agility");
        int intel = (int) character.get("intel");

        try {
            switch (classType) {
                case 1:
                    Player warrior = new Warrior( level, strength, agility, intel );
                    return warrior;
                case 2:
                    Player thief = new Thief( level, strength, agility, intel );
                    return thief;
                case 3:
                    Player mage = new Mage( level, strength, agility, intel );
                    return mage;
                default:
                    throw new IllegalClassException();
            }
        } catch (IllegalClassException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Prompt the player to build his Character.
     * @return a HashMap containing the characteristic chosen by the
     * player for his Character.
     */
    public HashMap buildCharacter() {
        HashMap<String, Integer> playerHash = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int playerChoice;
        int characteristicPoint = -1;
        boolean validAnswer = false;

        System.out.println("Choose a class: 1 - Warrior | 2 - Thief | 3 - Mage");

        while (!validAnswer) {
            try {
                switch (playerChoice = sc.nextInt()) {
                    case 1:
                        playerHash.put( "class", 1 );
                        validAnswer = true;
                        break;
                    case 2:
                        playerHash.put( "class", 2 );
                        validAnswer = true;
                        break;
                    case 3:
                        playerHash.put( "class", 3 );
                        validAnswer = true;
                        break;
                    default:
                        throw new IllegalClassException();
                }
            } catch (IllegalClassException e) {
                System.err.println(e.getMessage());
            }
        }

        System.out.println("Great, now let's build your character");
        System.out.println("Set your character level between 1 - 100");
        playerChoice = getCharacteristic(characteristicPoint);
        playerHash.put("level", playerChoice);
        System.out.println("Your character is level " + playerChoice);
        System.out.println("Keep in mind that the sum of your characteristic can't be more than " + playerChoice);
        characteristicPoint = playerChoice;

        System.out.println("Set your character Strength between 1 - 100");
        playerChoice = getCharacteristic(characteristicPoint);
        playerHash.put("strength", playerChoice);
        characteristicPoint -= playerChoice;
        System.out.println("You have " + characteristicPoint + " points left");

        System.out.println("Set your character Agility between 1 - 100");
        playerChoice = getCharacteristic(characteristicPoint);
        playerHash.put("agility", playerChoice);
        characteristicPoint -= playerChoice;
        System.out.println("You have " + characteristicPoint + " points left");

        System.out.println("Set your character Intelligence between 1 - 100");
        playerChoice = getCharacteristic(characteristicPoint);
        playerHash.put("intel", playerChoice);
        characteristicPoint -= playerChoice;
        System.out.println("You have " + characteristicPoint + " points left");

        return playerHash;
    }

    public int getCharacteristic(int characteristicPoint) {
        boolean validAnswer = false;
        Scanner sc = new Scanner(System.in);
        int playerChoice = 0;

        if (characteristicPoint == -1) {
            while (!validAnswer) {
                try {
                    playerChoice = sc.nextInt();
                    if (playerChoice >= 1 && playerChoice <= 100) {
                        validAnswer = true;
                        break;
                    } else {
                        throw new IllegalLevelException();
                    }
                } catch (IllegalLevelException e) {
                    System.err.println(e.getMessage());
                }
            }
        } else {

            while (!validAnswer) {
                try {
                    playerChoice = sc.nextInt();
                    if (playerChoice >= 0 && playerChoice <= characteristicPoint) {
                        validAnswer = true;
                        break;
                    } else {
                        throw new IllegalCharacteristicException();
                    }
                } catch (IllegalCharacteristicException e) {
                    System.err.println( e.getMessage() );
                }
            }
        }
        return playerChoice;
    }

    public void start() {
        Player player1;
        Player player2;

        HashMap<String, String> player1Actions = new HashMap<>();
        HashMap<String, String> player2Actions = new HashMap<>();

        HashMap<String, Integer> player1Hash = new HashMap<>();
        HashMap<String, Integer> player2Hash = new HashMap<>();

        System.out.println(welcome());

        System.out.println("Player 1 - Build your character");
        player1Hash = buildCharacter();
        System.out.println("Player 2 - Build your character!");
        player2Hash = buildCharacter();

        player1 = createCharacter( player1Hash );
        player1Actions = getActions( (int) player1Hash.get("class") );
        player2 = createCharacter( player2Hash );
        player2Actions = getActions( (int) player2Hash.get("class") );


        while(!gameOver) {
            System.out.println("Turn -> Player 1");
            runGame( player1, player1Actions, player2 );
            if (gameOver) { break; }
            System.out.println("Turn -> Player 2");
            runGame( player2, player2Actions, player1 );
        }
    }

    /**
     * runGame prompt the player for action and execute them
     * @param player Player prompted for action
     * @param playerActions Hash containing strings describing the player Actions
     * @param opponent Target of the Actions
     */
    public void runGame(Player player, HashMap playerActions, Player opponent) {
        Scanner sc = new Scanner(System.in);
        int playerChoice;
        boolean turnPlayed = false;

        System.out.println("HP: " + player.getHealth());
        System.out.println(playerActions.get("selectAction"));
        while (!turnPlayed) {
            try {
                switch (playerChoice = sc.nextInt()) {
                    case 1:
                        System.out.println( playerActions.get( "basicAttack" ) );
                        player.basicAttack( opponent );
                        turnPlayed = true;
                        break;
                    case 2:
                        System.out.println( playerActions.get( "specialAttack" ) );
                        player.specialAttack( opponent );
                        turnPlayed = true;
                        break;
                    default:
                        throw (new IllegalActionException());
                }
            } catch (IllegalActionException e) {
                System.err.println( e.getMessage() );
            }
        }
        if (player.isDead || opponent.isDead) {
            stop();
        }
    }

    /**
     * getActions retrieves the class of the character and return a Hash
     * containing strings describing his actions
     * @param classType class fo the character
     * @return hash containing strings with the character actions
     */
    public HashMap getActions(int classType) {
        HashMap<String, String> actionsHash = new HashMap<>();
        boolean validClass = false;

        while (!validClass) {
            try {
                switch (classType) {
                    case 1:
                        actionsHash.put( "selectAction", "Warrior, select an action : 1 - Sword attack | 2 - Beast mode" );
                        actionsHash.put( "basicAttack", "You pull out a Peanut butter covered knife and stab your allergic opponent." );
                        actionsHash.put( "specialAttack", "You step on a Lego and lose some health which puts you in Beast mode. You proceed to slap the opponent as hard as you can with a full Peanut butter jar." );
                        validClass = true;
                        return actionsHash;
                    case 2:
                        actionsHash.put( "selectAction", "Thief, select an action : 1 - Arrow shot | 2 - Focus" );
                        actionsHash.put( "basicAttack", "You shoot your arrow in the hopes and dreams of your opponent, causing emotional damage." );
                        actionsHash.put( "specialAttack", "You realize that you're doing pretty good at life and that you are a nice and interesting person. Which makes you more confident but also deadlier" );
                        validClass = true;
                        return actionsHash;
                    case 3:
                        actionsHash.put( "selectAction", "Mage, select an action : 1 - Fire ball | 2 - Heal" );
                        actionsHash.put( "basicAttack", "You  pull out a spray deodorant and a lighter, dealing fire damage to the opponent." );
                        actionsHash.put( "specialAttack", "You pull out some questionable powder and snort some, which appears to give you an instant boost in energy." );
                        validClass = true;
                        return actionsHash;
                    default:
                        throw (new IllegalClassException());
                }
            } catch (IllegalClassException e) {
                System.err.println( e.getMessage() );
            }
        }
        return null;
    }

    /**
     * Sets gameOver to true, therefore stopping the game.
     */
    public void stop() {
        System.out.println("Game Over! Thanks for playing");
        System.out.println("Feel free to take a look at the code behind this masterpiece of a game");
        System.out.println("Advices and PR are very welcome.");
        this.gameOver = true;
    }

    /**
     * Display welcome message when a new game is started
     */
    public String welcome() {
        String welcome = "Welcome to JRPG";
        return (welcome);
    }


}
