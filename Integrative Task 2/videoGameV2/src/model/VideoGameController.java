package model;
import java.util.Random;

public class VideoGameController {
    static Random rnd = new Random();
    private Player[] players;
    private Treasure[] treasures;
    private Level[] levels;
    private Enemy[] enemies;
    private int[] resolution;
    private static final int[][] RESOLUTIONS = {{640,480},{960,540},{1280,720},{1920,1080},{2560,1440},{3840,2160},{7680,4320}};
    private int[][] takenPositions;
    public VideoGameController() {
        this.players = new Player[20];
        this.levels = new Level[10];
        this.treasures = new Treasure[500];
        this.enemies = new Enemy[250];
        this.resolution = new int[2];
        this.takenPositions = new int[750][2];
    }

    // GETTERS AND SETTERS

    public int[] getResolution() {
        return resolution;
    }
    public void setResolution(int resolution) {
        this.resolution = this.RESOLUTIONS[resolution-1];
    }

    // SHOW METHODS
    /**
    * <pre>
    *<strong>Description:</strong> the method prints a readable list of players.
    *<strong>pre:</strong> players <strong>Player[]</strong> must be initialized
    *@return playerList <strong>String</strong> readable list of players
    * </pre>
    */
    public String showPlayers() {
        StringBuilder playerList = new StringBuilder();
        for (Player player : players) {
            if (player != null) playerList.append("\n").append(player);
        }
        return playerList.toString();
    } 
    /**
    * <pre>
    *<strong>Description:</strong> the method prints a readable list of levels.
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *@return levelList <strong>String</strong> readable list of levels
    * </pre>
    */
    public String showLevels() {
        StringBuilder levelList = new StringBuilder();
        for (Level level : levels) {
            if (level != null) levelList.append("\n").append(level);
        }
        return levelList.toString();
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method prints a readable list of enemies.
    *<strong>pre:</strong> enemies <strong>Enemy[]</strong> must be initialized
    *@return enemyList <strong>String</strong> readable list of enemies
    * </pre>
    */
    public String showEnemies() {
        StringBuilder enemyList = new StringBuilder();
        for (Enemy enemy : enemies) {
            if (enemy != null) enemyList.append("\n").append(enemy);
        }
        return enemyList.toString();
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method prints a readable list of treasures.
    *<strong>pre:</strong> treasures <strong>Treasure[]</strong> must be initialized
    *@return treasureList <strong>String</strong> readable list of treasures
    * </pre>
    */
    public String showTreasures() {
        StringBuilder treasureList = new StringBuilder();
        for (Treasure treasure : treasures) {
            if (treasure != null) treasureList.append("\n").append(treasure);
        }
        return treasureList.toString();
    }

    // SHOW ENUMS

    /**
    * <pre>
    *<strong>Description:</strong> the method prints a readable list of resolutions.
    *@return resolutionList <strong>String</strong> readable list of resolutions
    * </pre>
    */
    public String showResolutions() {
        StringBuilder resolutionList = new StringBuilder();
        Resolution[] resolutions = Resolution.values();
        for(int i=0; i<resolutions.length; i++) {
            resolutionList.append("\n").append(i + 1).append(". ").append(resolutions[i]).append(" (").append(this.RESOLUTIONS[i][0]).append("x").append(this.RESOLUTIONS[i][1]).append(")");
        }
        return resolutionList.toString();
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method prints a readable list of enemy types.
    *@return enemyType <strong>String</strong> readable list of enemy types
    * </pre>
    */
    public String showEnemyTypes() {
        StringBuilder typeList = new StringBuilder();
        EnemyType[] types = EnemyType.values();
        for(int i=0; i<types.length; i++) {
            typeList.append(i + 1).append(". ").append(types[i]).append(", ");
        }
        return typeList.toString();
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method prints a readable list of the menu options.
    *@return optionList <strong>String</strong> readable list of menu options
    * </pre>
    */
    public String showMenuOptions() {
        StringBuilder optionList = new StringBuilder();
        MenuOption[] options = MenuOption.values();
        for(int i=0; i<options.length; i++) {
            optionList.append(i).append(". ").append(options[i]).append("  |  ");
        }
        return optionList.toString();
    }

    // SEARCH METHODS
    /**
    * <pre>
    *<strong>Description:</strong> the method search and returns a player by his id
    *<strong>pre:</strong> players <strong>Player[]</strong> must be initialized
    *@param id <strong>String</strong> player id
    *@return matchedPlayer <strong>Player</strong> found player
    * </pre>
    */
    public Player searchPlayer(String id) {
        Player tmpPlayer = null;
        for (Player player : players) {
            if (player != null && player.getId().equals(id)) tmpPlayer = player;
        }
        return tmpPlayer;
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method search and returns a level by his id
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *@param id <strong>int</strong> level id
    *@return matchedLevel <strong>Level</strong> found level
    * </pre>
    */
    public Level searchLevel(int id) {
        Level tmpLevel = null;
        for (Level level : levels) {
            if (level != null && level.getId() == id) tmpLevel = level;
        }
        return tmpLevel;
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method search and returns a enemy by his id
    *<strong>pre:</strong> enemies <strong>Enemy[]</strong> must be initialized
    *@param id <strong>String</strong> enemy id
    *@return matchedEnemy <strong>Enemy</strong> found enemy
    * </pre>
    */
    public Enemy searchEnemy(String id) {
        Enemy tmpEnemy = null;
        for (Enemy enemy : enemies) {
            if (enemy != null && enemy.getId().equals(id)) tmpEnemy = enemy;
        }
        return tmpEnemy;
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method search and returns a treasure by his id
    *<strong>pre:</strong> treasures <strong>Treasure[]</strong> must be initialized
    *@param name <strong>String</strong> treasure id
    *@return matchedTreasure <strong>Treasure</strong> found treasure
    * </pre>
    */
    public Treasure searchTreasure(String name) {
        Treasure tmpTreasure = null;
        for (Treasure treasure : treasures) {
            if (treasure != null && treasure.getName().equals(name)) tmpTreasure = treasure;
        }
        return tmpTreasure;
    }

    // ADD METHODS
    /**
    * <pre>
    *<strong>Description:</strong> This method creates a player and adds it to the player list of the game.
    *<strong>pre:</strong> players <strong>Player[]</strong> must be initialized
    *<strong>pos</strong> players <strong>Player[]</strong> is modified with the new player added.
    *@param id <strong>String</strong> player identifier that cannot repeat
    *@param name <strong>String</strong> player name
    *@return success <strong>boolean</strong> Whether the operation succeeded or not
    * </pre>
    */
    public boolean addPlayer(String id, String name) {
        Player newPlayer = new Player(id, name);
        if(searchPlayer(id) != null) {
            return false;
        }
        for(int i=0; i<players.length; i++) {
            if(players[i] == null) {
                players[i] = newPlayer;
                return true;
            }
        }
        return false;
    }
    /**
    * <pre>
    *<strong>Description:</strong> This method creates a level and adds it to the level list of the game.
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *<strong>pos</strong> levels <strong>Level[]</strong> is modified with the new level added.
    *@param scoreLimit <strong>double</strong> score needed to pass to the next level
    *@return success <strong>boolean</strong> Whether the operation succeeded or not
    * </pre>
    */
    public boolean addLevel(double scoreLimit) {
        Level newLevel = new Level(scoreLimit);
        for(int i=0; i<levels.length; i++) {
            if(levels[i] == null) {
                newLevel.setId(i+1);
                levels[i] = newLevel;
                return true;
            }
        }
        return false;
    }
    /**
    * <pre>
    *<strong>Description:</strong> This method creates a enemy and adds it to the enemy list of the game.
    *<strong>pre:</strong> enemies <strong>Enemy[]</strong> must be initialized
    *<strong>pos</strong> enemies <strong>Enemy[]</strong> is modified with the new enemy added.
    *@param id <strong>String</strong> enemy identifier that cannot be repeated in a level
    *@param type <strong>int</strong> index of the enemy types
    *@param scoreAddition <strong>double</strong> score that sums to the player if it is defeated
    *@param scoreSubtraction <strong>double</strong> score that subtracts to the player when player loses
    *@return success <strong>boolean</strong> Whether the operation succeeded or not
    * </pre>
    */
    public boolean addEnemy(String id, int type, double scoreAddition, double scoreSubtraction) {
        Enemy newEnemy = new Enemy(id, type, scoreAddition, scoreSubtraction);
        if(searchEnemy(id) != null) {
            return false;
        }
        for(int i=0; i<enemies.length; i++) {
            if(enemies[i] == null) {
                enemies[i] = newEnemy;
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
    *@param name <strong>String</strong> treasure name, it can repeat in a level many times
    *@param pictureUrl <strong>String</strong> url of the treasure picture
    *@param scoreAddition <strong>double</strong> score that sums to the player if it is found
    *@return success <strong>boolean</strong> Whether the operation succeeded or not
    * </pre>
    */
    public boolean addTreasure(String name, String pictureUrl, double scoreAddition) {
        Treasure newTreasure = new Treasure(name, pictureUrl, scoreAddition);
        if(searchTreasure(name) != null) {
            return false;
        }
        for(int i=0; i<treasures.length; i++) {
            if(treasures[i] == null) {
                treasures[i] = newTreasure;
                return true;
            }
        }
        return false;
    }

    // POSITIONS AND RESOLUTION
    /**
    * <pre>
    *<strong>Description:</strong> the method generates a random position based on the resolution of the game.
    *<strong>pre:</strong> takenPositions <strong>int[][]</strong> must be initialized
    *<strong>pos</strong> takenPositions <strong>int[][]</strong> will be modified with the new position
    *@return newPosition <strong>int[]</strong> the new position that is not repeated
    * </pre>
    */
    public int[] generatePosition() {
        int[] newPosition = {-1,-1};
        do {
            newPosition[0] = rnd.nextInt(getResolution()[0]);
            newPosition[1] = rnd.nextInt(getResolution()[1]);
        } while(isPositionTaken(newPosition));
        return newPosition;
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method checks if a given position is taken in the game.
    *<strong>pre:</strong> takenPositions <strong>int[][]</strong> must be initialized
    *@param position <strong>int[]</strong> the position generated by the game
    *@return success <strong>boolean</strong> Whether the position is taken or not
    * </pre>
    */
    public boolean isPositionTaken(int[] position) {
        for (int[] takenPosition : takenPositions) {
            if (takenPosition != null && takenPosition == position) {
                return true;
            }
        }
        return false;
    }

    // ADD TO OBJECT METHODS
    /**
    * <pre>
    *<strong>Description:</strong> the method adds a an enemy to a level.
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *<strong>pre:</strong> enemies <strong>Enemy[]</strong> must be initialized
    *<strong>pos</strong> levels <strong>Level[]</strong> will be modified with a new enemy added
    *@param enemyName <strong>String</strong> name of the enemy
    *@param levelId <strong>int</strong> level identifier
    *@return success <strong>boolean</strong> Whether the operation succeeded or not
    * </pre>
    */
    public boolean addEnemyToLevel(String enemyName, int levelId) {
        Enemy tmpEnemy = searchEnemy(enemyName);
        Level tmpLevel = searchLevel(levelId);
        if(tmpEnemy == null || tmpLevel == null) { 
            return false;
        }
        return tmpLevel.addEnemy(tmpEnemy, generatePosition());
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method adds a an treasure to a level.
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *<strong>pre:</strong> treasures <strong>Treasure[]</strong> must be initialized
    *<strong>pos</strong> levels <strong>Level[]</strong> will be modified with a new treasure added
    *@param treasureName <strong>String</strong> name of the treasure
    *@param levelId <strong>int</strong> level identifier
    *@return success <strong>boolean</strong> Whether the operation succeeded or not
    * </pre>
    */
    public boolean addTreasureToLevel(String treasureName, int levelId) {
        Treasure templateTreasure = searchTreasure(treasureName);
        Treasure tmpTreasure = new Treasure(templateTreasure.getName(), templateTreasure.getPictureUrl(), templateTreasure.getScoreAddition());
        Level tmpLevel = searchLevel(levelId);
        if(tmpTreasure == null || tmpLevel == null) {
            return false;
        }
        int[] newPosition = generatePosition();
        if(tmpLevel.addTreasure(tmpTreasure, newPosition)) {
            for(int[] position : takenPositions) {
                if(position == null) position = newPosition;
            }
            return true;
        }
        return false;
    }
    
    // SHOW OBJECT METHODS
    /**
    * <pre>
    *<strong>Description:</strong> the method prints a readable list of treasures and enemies of the given level.
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *@param id <strong>int</strong> level identifier
    *@return objectList <strong>String</strong> readable list of level objects
    * </pre>
    */
    public String showLevelObjects(int id) {
        String objectList = "";
        Level tmpLevel = searchLevel(id);
        objectList += "\nLevel " + id + " (" + tmpLevel.getDifficulty() + ")";
        objectList += "\nEnemies: " + tmpLevel.showEnemies();
        objectList += "\nTreasures: " + tmpLevel.showTreasures();
        return objectList;
    }

    // MODIFY STATISTICS METHODS
    /**
    * <pre>
    *<strong>Description:</strong> the method change the score of a user only if the new score is greater than the previous one.
    *<strong>pre:</strong> players <strong>Player[]</strong> must be initialized
    *<strong>pos</strong> players <strong>Player[]</strong> player score of the selected player will be modified
    *@param playerId <strong>String</strong> player identifier
    *@param newScore <strong>double</strong> new score given by the user
    *@return success <strong>boolean</strong> Whether the operation succeeded or not
    * </pre>
    */
    public boolean modifyPlayerScore(String playerId, double newScore) {
        Player tmpPlayer = searchPlayer(playerId);
        if(tmpPlayer == null) {
            return false;
        } else if(tmpPlayer.getScore() >= newScore) {
            return false;
        }
        tmpPlayer.setScore(newScore);
        return true;
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method increases the level of a user only if user score is enough to do it, else will return the score necessary to increase the level.
    *<strong>pre:</strong> players <strong>Player[]</strong> must be initialized
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *<strong>pos</strong> players <strong>Player[]</strong> player level of the selected player will be increased
    *@param playerId <strong>String</strong> player identifier
    *@param levelId <strong>double</strong> the level that the user want tot get the new player to
    *@return <strong>double</strong> It is -1 if the player is not found, 0 if the user level can be increased or a positive number that indicates how many points does the user need to pass
    * </pre>
    */
    public double increasePlayerLevel(String playerId, int levelId) {
        Player tmpPlayer = searchPlayer(playerId);
        Level tmpLevel = searchLevel(levelId-1);

        if(tmpPlayer == null || tmpLevel == null) {
            return -1;
        } else if (tmpPlayer.getLevel() >= levelId) {
            return -1;
        }

        if(tmpLevel.getScoreLimit() - tmpPlayer.getScore() <= 0) {
            return 0;
        } else {
            return tmpLevel.getScoreLimit();
        }
    }
    
    // COUNT METHODS
    /**
    * <pre>
    *<strong>Description:</strong> the method counts the number of treasures of the game that have the given name.
    *<strong>pre:</strong> treasures <strong>Treasure[]</strong> must be initialized
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *@param treasureName <strong>String</strong> name of the treasure to count
    *@return <strong>int</strong> The number of occurrences
    * </pre>
    */
    public int countTreasureName(String treasureName) {
        int s = 0;
        for (Level level : levels) {
            s += level.countTreasureName(treasureName);
        }
        return s;
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method counts the number of enemies of the game that have the given type.
    *<strong>pre:</strong> enemies <strong>Enemy[]</strong> must be initialized
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *@param enemyType <strong>int</strong> name of the enemy to count
    *@return <strong>int</strong> The number of occurrences
    * </pre>
    */
    public int countEnemyType(int enemyType) {
        int s = 0;
        for (Level level : levels) {
            s += level.countEnemyType(enemyType);
        }
        return s;
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method gets the most repeated treasure of the game.
    *<strong>pre:</strong> treasures <strong>Treasure[]</strong> must be initialized
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *@return <strong>String</strong> The name of the most repeated treasure and its score addition
    * </pre>
    */
    public String mostRepeatedTreasure() {
        if(showTreasures().equals("")) {
            return "\nThere are not treasures yet";
        }
        Treasure mostRepeated = treasures[0];
        int max = countTreasureName(mostRepeated.getName());
        for(int i=1; i<treasures.length; i++) {
            if(treasures[i] != null && countTreasureName(treasures[i].getName()) > max) {
                mostRepeated = treasures[i];
                max = countTreasureName(mostRepeated.getName());
            }
        }
        if(max == 0) {
            return "\nThere are not treasures assigned to levels";
        } else {
            return "\nThe most repeated treasure is " + mostRepeated.getName() + " with " + max + " elements";
        }
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method gets the most repeated type of enemy of the game.
    *<strong>pre:</strong> enemies <strong>Enemy[]</strong> must be initialized
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *@return <strong>String</strong> The name of the most valuable enemy and its score addition
    * </pre>
    */
    public String mostValuableEnemy() {
        if(showEnemies().equals("")) return "\nAdd an enemy first";

        Enemy mostValuable = null;
        double max = -1;
        int level = -1;
        for (Level value : levels) {
            if (value.mostValuableEnemy() != null && value.mostValuableEnemy().getScoreAddition() > max) {
                mostValuable = value.mostValuableEnemy();
                max = mostValuable.getScoreAddition();
                level = value.getId();
            }
        }
        if(max == -1) {
            return "\nThere are not enemies assigned to a level yet";
        } else {
            return "\nThe most valuable enemy is " + mostValuable.getId() + " of type " + mostValuable.getType() + " on level " + level;
        }
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method counts the number of consonants that are in the name of the enemies of the game.
    *<strong>pre:</strong> enemies <strong>Enemy[]</strong> must be initialized
    *@return <strong>int</strong> The number of consonants of the names of enemies of the whole game
    * </pre>
    */
    public String countEnemyConsonants() {
        int s = 0;
        for (Enemy enemy : enemies) {
            if (enemy != null) {

                String enemyNameTmp = enemy.getId();
                for (int j = 0; j < enemyNameTmp.length(); j++) {
                    char tmpChar = Character.toLowerCase(enemyNameTmp.charAt(j));
                    if (tmpChar != 'a' && tmpChar != 'e' && tmpChar != 'i' && tmpChar != 'o' && tmpChar != 'u') s++;
                }
            }
        }
        return "\n The number of consonants in enemy names is " + s;
    }
    
    // TOP
    /**
    * <pre>
    *<strong>Description:</strong> the method shows a readable list of players top based on their score.
    *<strong>pre:</strong> players <strong>Player[]</strong> must be initialized
    *@param topLimit <strong>int</strong> The number of positions to print
    *@return topList <strong>String</strong> The list of players top
    * </pre>
    */
    public String playerTop(int topLimit) {
        if(countRealPlayers(players) < 5) {
            return "\nThere are not enough players";
        }
        StringBuilder topList = new StringBuilder();
        Player[] playerTop = new Player[countRealPlayers(players)]; // player top
        for(int i=0; i<playerTop.length; i++) {
            System.out.println(getTopPlayer(playerTop));
            playerTop[i] = getTopPlayer(playerTop);
        }

        topList.append("\nPlayer Top 5: ");
        for(int i=0; i<playerTop.length &&  i<5; i++) {
            if(playerTop[i] != null) {
                topList.append("\n").append(i + 1).append(". name: ").append(playerTop[i].getName()).append(", score: ").append(playerTop[i].getScore());
            }
        }
        return topList.toString();
    }
    /**
     * <pre>
    *<strong>Description:</strong> the method gets the next player to be included in the top.
    *<strong>pre:</strong> players <strong>Player[]</strong> must be initialized
    *@param topPlayers <strong>Player[]</strong> Current players top list
    *@return topPlayer <strong>Player</strong> The next player on the top
    * </pre>
    */
    public Player getTopPlayer(Player[] topPlayers) {
        double maxScore = -1;
        Player topPlayer = null;
        for (Player player : players) {
            if (player != null && !isPlayerInTop(player, topPlayers)) {
                if (player.getScore() >= maxScore) {
                    topPlayer = player;
                    maxScore = topPlayer.getScore();
                }
            }
        }
        return topPlayer;
    }
    /**
     * <pre>
    *<strong>Description:</strong> the method counts the number of elements of a list that are not null.
    *<strong>pre:</strong> players <strong>Player[]</strong> must be initialized
    *@param players <strong>Player[]</strong> The list of all players in the game
    *@return <strong>int</strong> The number of defined players of the player list
    * </pre>
    */
    public int countRealPlayers(Player[] players) {
        for(int i=0; i<players.length; i++) {
            if(players[i] == null) {
                return i;
            }
        }
        return players.length;
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method returns whether the given player id is in the top list of players or not.
    *@param tmpPlayer <strong>Player</strong> Player to locate in the list
    *@param topPlayers <strong>Player[]</strong> current list of top players
    *@return <strong>boolean</strong> whether the given player is in the list or not
    * </pre>
    */
    public boolean isPlayerInTop(Player tmpPlayer, Player[] topPlayers) {
        for (Player topPlayer : topPlayers) {
            if (topPlayer != null && topPlayer == tmpPlayer) {
                return true;
            }
        }
        return false;
    }
}
