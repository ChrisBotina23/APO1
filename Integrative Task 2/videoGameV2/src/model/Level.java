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
    public String toString() {
        return ""
        + "id: " + this.id
        + ", score limit: " + this.scoreLimit
        + ", difficulty: " + this.difficulty;
    }

    // SEARCH METHODS
    /**
    * <pre>
    *<strong>Description:</strong> the method search and returns a enemy by his id
    *<strong>pre:</strong> enemys <strong>Enemy[]</strong> must be initialized
    *@param id <strong>String</strong> enemy id
    *@return matchedenemy <strong>Enemy</strong>
    * </pre> the enemy that has the same id as given
    */
    public Enemy searchEnemy(String id) {
        Enemy tmpEnemy = null;
        for(int i=0; i<enemies.length; i++) {
            if(enemies[i] != null && enemies[i].getId().equals(id)) tmpEnemy = enemies[i];
        }
        return tmpEnemy;
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method search and returns a treasure by his id
    *<strong>pre:</strong> treasures <strong>Treasure[]</strong> must be initialized
    *@param name <strong>String</strong> treasure id
    *@return matchedtreasure <strong>Treasure</strong> the treasure that has the same name as given
    * </pre>
    */
    public Treasure searchTreasure(String name) {
        Treasure tmpTreasure = null;
        for(int i=0; i<treasures.length; i++) {
            if(treasures[i] != null && treasures[i].getName().equals(name)) tmpTreasure = treasures[i];
        }
        return tmpTreasure;
    }

    // SHOW METHODS
    /**
    * <pre>
    *<strong>Description:</strong> the method prints a readable list of enemies.
    *<strong>pre:</strong> enemies <strong>Enemy[]</strong> must be initialized
    *@return enemyList <strong>String</strong> readable list of enemies of the game
    * </pre>
    */
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
    /**
    * <pre>
    *<strong>Description:</strong> the method prints a readable list of treasures.
    *<strong>pre:</strong> treasures <strong>Treasure[]</strong> must be initialized
    *@return treasureList <strong>String</strong> readable list of treasures of the game
    * </pre>
    */
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
    /**
    * <pre>
    *<strong>Description:</strong> This method adds the new enemyto the enemy list of the level.
    *<strong>pre:</strong> enemies <strong>Enemy[]</strong> must be initialized
    *<strong>pos</strong> enemies <strong>Enemy[]</strong> is modified with the new enemy added.
    *@param newEnemy <strong>Enemy</strong> the new enemy created previously
    *@param position <strong>int[]</strong> the new position generated randomly
    *@return success <strong>boolean</strong> Whether the operation succeded or not
    * </pre>
    */
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
    /**
    * <pre>
    *<strong>Description:</strong> This method creates a treasure and adds it to the treasure list of the game.
    *<strong>pre:</strong> treasures <strong>Treasure[]</strong> must be initialized
    *<strong>pos</strong> treasures <strong>Treasure[]</strong> is modified with the new treasure added.
    *@param newTreasure <strong>Treasure</strong> the new enemy created previously
    *@param position <strong>int[]</strong> the new position generated randomly
    *@return success <strong>boolean</strong> Whether the operation succeded or not
    * </pre>
    */
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

    /**
    * <pre>
    *<strong>Description:</strong> calculates the difficulty of the level based on the score addition of the treasures and enemies.
    *<strong>pre:</strong> treasures <strong>Treasure[]</strong> must be initialized
    *<strong>pre:</strong> enemeies <strong>Enemy[]</strong> must be initialized
    *@return void
    * </pre>
    */
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

    // COUNT
    /**
    * <pre>
    *<strong>Description:</strong> the method counts the number of treasures of the level that have the given name.
    *<strong>pre:</strong> treasures <strong>Treasure[]</strong> must be initialized
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *@param treasureName <strong>String</strong> name of the treasure to count
    *@return <strong>int</strong> the number of treasures that have the same name as given
    * </pre>
    */
    public int countTreasureName(String treasureName) {
        int s = 0;
        for(int i=0; i<treasures.length; i++) {
            if(treasures[i] != null && treasures[i].getName().equals(treasureName)) s++;
        }
        return s;
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method counts the number of enemies of the level that have the given type.
    *<strong>pre:</strong> enemies <strong>Enemy[]</strong> must be initialized
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *@param enemyType <strong>int</strong> name of the enemy to count
    *@return <strong>int</strong> the number of enemies that have the same id as given
    * </pre>
    */
    public int countEnemyType(int enemyType) {
        int s = 0;
        for(int i=0; i<enemies.length; i++) {
            if(enemies[i] != null && enemies[i].getType() == EnemyType.values()[enemyType]) s++;
        }
        return s;
    }

    // MAX

    /**
    * <pre>
    *<strong>Description:</strong> the method gets the enemy of the list that has the greatest score addition.
    *<strong>pre:</strong> enemies <strong>Enemy[]</strong> must be initialized
    *@return mostValuable <strong>Enemy</strong> the enemy that has the greatest score addition in the level
    * </pre>
    */
    public Enemy mostValuableEnemy() {
        Enemy mostValuable = enemies[0];
        for(int i=1; i<enemies.length; i++) {
            if(enemies[i] != null && enemies[i].getScoreAddition() > mostValuable.getScoreAddition()) mostValuable = enemies[i];
        }
        return mostValuable;
    }
}
