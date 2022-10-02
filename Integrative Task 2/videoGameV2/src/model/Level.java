package model;

public class Level {
    private int id;
    private double scoreLimit;
    private Difficulty difficulty;
    private Treasure[] treasures;
    private Enemy[] enemies;
    public Level(double scoreLimit) {
        this.scoreLimit = scoreLimit;
        this.treasures = new Treasure[50];
        this.enemies = new Enemy[25];
    }

    // GETTERS AND SETTERS

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getScoreLimit() {
        return scoreLimit;
    }
    public void setScoreLimit(double scoreLimit) {
        this.scoreLimit = scoreLimit;
    }
    public Difficulty getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    // SEARCH METHODS

    public Enemy searchEnemy(String id) {
        Enemy tmpEnemy = null;
        for(int i=0; i<enemies.length; i++) {
            if(enemies[i] != null && enemies[i].getId().equals(id)) tmpEnemy = enemies[i];
        }
        return tmpEnemy;
    }
    public Treasure searchTreasure(String name) {
        Treasure tmpTreasure = null;
        for(int i=0; i<treasures.length; i++) {
            if(treasures[i] != null && treasures[i].getName().equals(name)) tmpTreasure = treasures[i];
        }
        return tmpTreasure;
    }

    // SHOW METHODS

    public String showEnemies() {
        String enemyList = "";
        for(int i=0; i<enemies.length; i++) {
            if(enemies[i] != null) {
                if(i > 0) enemyList += ", ";
                enemyList += enemies[i].getId()  + "("+ enemies[i].getPosition()[0] +"," + enemies[i].getPosition()[1] +")";
            }
        }
        if(enemyList == "") {
            enemyList = "There is not any enemy yet";
        }
        return enemyList;
    }
    public String showTreasures() {
        String treasureList = "";
        for(int i=0; i<treasures.length; i++) {
            if(treasures[i] != null) {
                if(i > 0) treasureList += ", ";
                treasureList += treasures[i].getName() + "("+ treasures[i].getPosition()[0] +"," + treasures[i].getPosition()[1] +")";
            }
        }
        if(treasureList == "") {
            treasureList = "There is not any treasure yet";
        }
        return treasureList;
    }

    // ADD METHODS

    public boolean addEnemy(Enemy newEnemy, int[] position) {
        if(searchEnemy(newEnemy.getId()) != null) {
            return false;
        }
        for(int i=0; i<enemies.length; i++) {
            if(enemies[i] == null) {
                enemies[i] = newEnemy;
                enemies[i].setPosition(position);
                calculateNewDifficulty();
                return true;
            }
        }
        return false;
    }
    public boolean addTreasure(Treasure newTreasure, int[] position) {
        for(int i=0; i<treasures.length; i++) {
            if(treasures[i] == null) {
                treasures[i] = newTreasure;
                treasures[i].setPosition(position);
                calculateNewDifficulty();
                return true;
            }
        }
        return false;
    }

    // OTHERS

    public void calculateNewDifficulty() {
        int s = 0;
        
        for(int i=0; i<treasures.length; i++) {
            if(treasures[i] != null) {
                s += treasures[i].getScoreAddition();
            }
        }
        
        for(int i=0; i<enemies.length; i++) {
            if(enemies[i] != null) {
                s -= enemies[i].getScoreAddition();
            }
        }
        
        if(s > 0) {
            setDifficulty(Difficulty.EASY);
        } else if (s < 0) {
            setDifficulty(Difficulty.HARD);
        } else {
            setDifficulty(Difficulty.MEDIUM);
        }
    }
    public String toString() {
        return ""
        + "id: " + this.id
        + ", score limit: " + this.scoreLimit
        + ", difficulty: " + this.difficulty;
    }

    // COUNT
    public int countTreasureName(String treasureName) {
        int s = 0;
        for(int i=0; i<treasures.length; i++) {
            if(treasures[i] != null && treasures[i].getName().equals(treasureName)) s++;
        }
        return s;
    }
    public int countEnemyType(int enemyType) {
        int s = 0;
        for(int i=0; i<enemies.length; i++) {
            if(enemies[i] != null && enemies[i].getType() == EnemyType.values()[enemyType]) s++;
        }
        return s;
    }

    // MAX
    public Enemy mostValuableEnemy() {
        Enemy mostValuable = enemies[0];
        for(int i=1; i<enemies.length; i++) {
            if(enemies[i] != null && enemies[i].getScoreAddition() > mostValuable.getScoreAddition()) mostValuable = enemies[i];
        }
        return mostValuable;
    }
}
