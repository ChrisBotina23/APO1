package ui;
import java.util.Scanner;

import javax.security.auth.kerberos.KerberosCredMessage;

import model.VideoGameController;

public class VideoGameManager {
    static Scanner sc;
    static VideoGameController vgc;
    public static void main(String[] args) {
        init();
        showMenu();
    }
    public static void init() {
        sc = new Scanner(System.in);
        vgc = new VideoGameController();
        for(int i=0; i<10; i++) {
            vgc.addLevel((i+1)*100);
        }
    }
    
    // MENU

    public static void showMenu() {
        System.out.println("\nWelcome");
        System.out.println("\nAllowed resolutions: " + vgc.showResolutions());
        System.out.print("Resolution: ");
        int resolution = sc.nextInt();
        vgc.setResolution(resolution);

        boolean pass = false;
        int operation = -1;
        while(!pass) {
            System.out.println("\nSelect the operation: ");
            System.out.println(vgc.showMenuOptions());
            System.out.print("Option: ");
            operation = sc.nextInt();
            switch(operation) {
                case 0:
                    pass = true;
                    break;
                case 1:
                    registerPlayer();
                    break;
                case 2:
                    registerTreasure();
                    break;
                case 3:
                    registerEnemy();
                    break;
                case 4:
                    registerEnemyToLevel();
                    break;
                case 5:
                    registerTreasureToLevel();
                    break;
                case 6:
                    modifyPlayerScore();
                    break;
                case 7:
                    increasePlayerLevel();
                    break;
                case 8:
                    printLevelObjects();
                    break;
                case 9:
                    countTreasureName();
                    break;
                case 10:
                    countEnemyType();
                    break;
                case 11:
                    mostRepeatedTreasure();
                    break;
                case 12:
                    mostValuableEnemy();
                    break;
                case 13:
                    countEnemyConsonants();
                    break;
                case 14:
                    printPlayerTopFive();
                    break;
                default:
                    System.out.println("\nSelect a valid operation");
                    break;
            }

        }
    }

    // MENU OPTIONS

    public static void registerPlayer() {
        sc.nextLine();
        System.out.print("Enter the id: ");
        String id = sc.nextLine();

        System.out.print("Enter the name: ");
        String name = sc.nextLine();

        if(vgc.addPlayer(id, name)) {
            System.out.println("\nPlayer added successfully");
            System.out.println(vgc.showPlayers());
        } else {
            System.out.println("\nError adding player");
        }
    }
    public static void registerTreasure() {
        sc.nextLine();
        System.out.print("Enter the name: ");
        String name = sc.nextLine();

        System.out.print("Enter the picture url: ");
        String pictureUrl = sc.nextLine();

        System.out.print("Enter the score addition: ");
        double scoreAddition = sc.nextDouble();

        if(vgc.addTreasure(name, pictureUrl, scoreAddition)) {
            System.out.println("\nTreasure added successfully");
            System.out.println("\nAll treasures: " + vgc.showTreasures());
        } else {
            System.out.println("\nError adding treasure");
        }

    }
    public static void registerEnemy() {
        sc.nextLine();
        System.out.print("Enter the id: ");
        String id = sc.nextLine();

        System.out.println("Allowed types: " + vgc.showEnemyTypes());
        System.out.print("Enter the Type: ");
        int type = sc.nextInt();

        System.out.print("Enter the score addition and substraction (space separated): ");
        double scoreAddition = sc.nextDouble();
        double scoreSubstraction = sc.nextDouble();

        if(vgc.addEnemy(id, type-1, scoreAddition, scoreSubstraction)) {
            System.out.println("\nEnemy added successfully");
            System.out.println("\nAll enemies: " + vgc.showEnemies());
        } else {
            System.out.println("\nError adding enemy");
        }

    }
    public static void registerEnemyToLevel() {
        if(vgc.showEnemies().equals("")) {
            System.out.println("\nAdd an enemy first");
            return;
        }
    
        sc.nextLine();
        System.out.println("\nEnemies: " + vgc.showEnemies());
        System.out.print("Enter the enemy id: ");
        String enemyId = sc.nextLine();
        
        System.out.print("Enter the level id (1-10): ");
        int levelId = sc.nextInt();

        if(vgc.addEnemyToLevel(enemyId, levelId)) {
            System.out.println("\nEnemy added successfully");
            System.out.println(vgc.showLevelObjects(levelId));
        } else { 
            System.out.println("\nError adding enemy");
        }
    }
    public static void registerTreasureToLevel() {
        if(vgc.showTreasures().equals("")) {
            System.out.println("\nAdd a treasure first");
            return;
        }

        sc.nextLine();
        System.out.println("\nTreasures: " + vgc.showTreasures());
        System.out.print("Enter the treasure id: ");
        String treasureId = sc.nextLine();

        System.out.print("Enter the level id (1-10): ");
        int levelId = sc.nextInt();
        
        System.out.print("Enter how many " + treasureId + " do you want to add: ");
        int amountOfTreasures = sc.nextInt();
        for(int i=1; i<amountOfTreasures; i++) {
            if(i == amountOfTreasures-1 && vgc.addTreasureToLevel(treasureId, levelId)) {
                System.out.println("\nAll " + (i+1) + " treasures added successfully");
            }
            if(!vgc.addTreasureToLevel(treasureId, levelId)) {
                System.out.println("\nOnly " + i + "  were added");
                break;
            }
        }
        System.out.println(vgc.showLevelObjects(levelId));

    }
    public static void modifyPlayerScore() {
        if(vgc.showPlayers().equals("")) {
            System.out.println("\nAdd a player first");
            return;
        }

        System.out.println("\nPlayers: " + vgc.showPlayers());
        System.out.print("Enter the player ID: ");
        sc.nextLine();
        String playerId = sc.nextLine();

        System.out.print("Enter the new score: ");
        double newScore = sc.nextDouble();

        if(vgc.modifyPlayerScore(playerId, newScore)) {
            System.out.println("\nScore updated successfully to " + newScore);

        } else {
            System.out.println("\nError modifying score");
        }

    }
    public static void increasePlayerLevel() {
        if(vgc.showPlayers().equals("")) {
            System.out.println("\nAdd a player first");
            return;
        }

        System.out.println("\nPlayers: " + vgc.showPlayers());
        System.out.print("Enter the player ID: ");
        sc.nextLine();
        String playerId = sc.nextLine();

        System.out.print("Enter the level you want to get into: ");
        int levelId = sc.nextInt();

        double scoreDifference = vgc.increasePlayerLevel(playerId, levelId);
        if(scoreDifference == 0) {
            System.out.println("\nPlayer level successfully increased to  " + levelId);

        } else if(scoreDifference > 0) {
            System.out.println("\nYou need at least " + scoreDifference + " points to get to level " + levelId);
        } else {
            System.out.println("\nError increasing the level");
        }
    }
    public static void printLevelObjects() {
        System.out.print("Enter the level ID: ");
        int levelId = sc.nextInt();
        if(vgc.searchLevel(levelId) == null) {
            System.out.println("\nThere is not level " + levelId);
            return;
        }
        System.out.println(vgc.showLevelObjects(levelId));
    }
    public static void countTreasureName() {
        sc.nextLine();
        System.out.println("\nTreasures: " + vgc.showTreasures());
        System.out.print("Enter the treasure name: ");
        String treasureName = sc.nextLine();
        System.out.println("\nThere are " + vgc.countTreasureName(treasureName) + " " + treasureName);
    }
    public static void countEnemyType() {
        System.out.println("\nEnemy types: " + vgc.showEnemyTypes());
        System.out.print("Enemy type: ");
        int enemyType = sc.nextInt();
        System.out.println("\nThere are " + vgc.countEnemyType(enemyType-1) + " enemies of the given type");
    }
    public static void mostRepeatedTreasure() {
        System.out.println(vgc.mostRepeatedTreasure());
    }
    public static void mostValuableEnemy() {
        System.out.println(vgc.mostValuableEnemy());
    }
    public static void countEnemyConsonants() {
        System.out.println(vgc.countEnemyConsonants());
    }
    public static void printPlayerTopFive() {
        System.out.println(vgc.playerTop(5));
    }
}
