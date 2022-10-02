package model;
import java.util.Random;

public class VideoGameController {
    static Random rnd = new Random();
    private Player[] players;
    private Treasure[] treasures;
    private Level[] levels;
    private Enemy[] enemies;
    private int[] resolution;
    private static final int[][] resolutions = {{640,480},{960,540},{1280,720},{1920,1080},{2560,1440},{3840,2160},{7680,4320}};
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
        this.resolution = this.resolutions[resolution-1];
    }

    // SHOW METHODS
    /**
     * <pre>
    *<strong>Description:</strong> the method prints a readable list of players.
    *<strong>pre:</strong> players <strong>Player[]</strong> must be initialized
    *@return playerList <strong>String</strong>
    * </pre>
    */
    public String showPlayers() {
        String playerList = "";
        for(int i=0; i<players.length; i++) {
            if(players[i] != null) playerList += "\n" + players[i].toString();
        }
        return playerList;
    } 
    /**
     * <pre>
    *<strong>Description:</strong> the method prints a readable list of levels.
    *<strong>pre:</strong> levels <strong>Level[]</strong> must be initialized
    *@return levelList <strong>String</strong>
    * </pre>
    */
    public String showLevels() {
        String levelList = "";
        for(int i=0; i<levels.length; i++) {
            if(levels[i] != null) levelList += "\n" + levels[i].toString();
        }
        return levelList;
    }
    /**
     * <pre>
    *<strong>Description:</strong> the method prints a readable list of enemies.
    *<strong>pre:</strong> enemies <strong>Enemy[]</strong> must be initialized
    *@return enemyList <strong>String</strong>
    * </pre>
    */
    public String showEnemies() {
        String enemyList = "";
        for(int i=0; i<enemies.length; i++) {
            if(enemies[i] != null) enemyList += "\n" + enemies[i].toString();
        }
        return enemyList;
    }
    /**
     * <pre>
    *<strong>Description:</strong> the method prints a readable list of treasures.
    *<strong>pre:</strong> treasures <strong>Treasure[]</strong> must be initialized
    *@return treasureList <strong>String</strong>
    * </pre>
    */
    public String showTreasures() {
        String treasureList = "";
        for(int i=0; i<treasures.length; i++) {
            if(treasures[i] != null) treasureList += "\n" + treasures[i].toString();
        }
        return treasureList;
    }

    // SHOW ENUMS

    /**
    * <pre>
    *<strong>Description:</strong> the method prints a readable list of resolutions.
    *@return resolutionList <strong>String</strong>
    * </pre>
    */
    public String showResolutions() {
        String resolutionList = "";
        Resolution[] resolutions = Resolution.values();
        for(int i=0; i<resolutions.length; i++) {
            resolutionList += "\n" + (i+1) + ". " + resolutions[i] + " (" + this.resolutions[i][0] + "x" + this.resolutions[i][1] + ")";
        }
        return resolutionList;
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method prints a readable list of enemy types.
    *@return enemyType <strong>String</strong>
    * </pre>
    */
    public String showEnemyTypes() {
        String typeList = "";
        EnemyType[] types = EnemyType.values();
        for(int i=0; i<types.length; i++) {
            typeList += (i+1) + ". " + types[i] + ", ";
        }
        return typeList;
    }
    /**
    * <pre>
    *<strong>Description:</strong> the method prints a readable list of the menu options.
    *@return optionList <strong>String</strong>
    * </pre>
    */
    public String showMenuOptions() {
        String optionList = "";
        MenuOption[] options = MenuOption.values();
        for(int i=0; i<options.length; i++) {
            optionList += i + ". " + options[i] + "  |  ";
        }
        return optionList;
    }

    // SEARCH METHODS
    
    public Player searchPlayer(String id) {
        Player tmpPlayer = null;
        for(int i=0; i<players.length; i++) {
            if(players[i] != null && players[i].getId().equals(id)) tmpPlayer = players[i];
        }
        return tmpPlayer;
    }
    public Level searchLevel(int id) {
        Level tmpLevel = null;
        for(int i=0; i<levels.length; i++) {
            if(levels[i] != null && levels[i].getId() == id) tmpLevel = levels[i];
        }
        return tmpLevel;
    }
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

    // ADD METHODS

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
    public boolean addEnemy(String id, int type, double scoreAddition, double scoreSubstraction) {
        Enemy newEnemy = new Enemy(id, type, scoreAddition, scoreSubstraction);
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

    public int[] generatePosition() {
        int[] newPosition = {-1,-1};
        do {
            newPosition[0] = rnd.nextInt(getResolution()[0]);
            newPosition[1] = rnd.nextInt(getResolution()[1]);
        } while(isPositionTaken(newPosition));
        return newPosition;
    }
    public boolean isPositionTaken(int[] position) {
        for(int i=0; i<takenPositions.length; i++) {
            if(takenPositions[i] != null && takenPositions[i] == position) {
                return true;
            }
        }
        return false;
    }

    // ADD TO OBJECT METHODS

    public boolean addEnemyToLevel(String enemyName, int levelId) {
        Enemy tmpEnemy = searchEnemy(enemyName);
        Level tmpLevel = searchLevel(levelId);
        if(tmpEnemy == null || tmpLevel == null) { 
            return false;
        }
        if(tmpLevel.addEnemy(tmpEnemy, generatePosition())) return true;
        return false;
    }
    public boolean addTreasureToLevel(String treasureName, int levelId) {
        Treasure templateTreasure = searchTreasure(treasureName);
        Treasure tmpTreasure = new Treasure(templateTreasure.getName(), templateTreasure.getPictureUrl(), templateTreasure.getScoreAddition());
        Level tmpLevel = searchLevel(levelId);
        if(tmpTreasure == null || tmpLevel == null) {
            return false;
        }
        if(tmpLevel.addTreasure(tmpTreasure, generatePosition())) return true;
        return false;
    }
    
    // SHOW OBJECT METHODS

    public String showLevelObjects(int id) {
        String objectList = "";
        Level tmpLevel = searchLevel(id);
        objectList += "\nLevel " + id + " (" + tmpLevel.getDifficulty() + ")";
        objectList += "\nEnemies: " + tmpLevel.showEnemies();
        objectList += "\nTreasures: " + tmpLevel.showTreasures();
        return objectList;
    }

    // MODIFY STATISTICS METHODS

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
    public int countTreasureName(String treasureName) {
        int s = 0;
        for(int i=0; i<levels.length; i++) {
            s += levels[i].countTreasureName(treasureName);
        }
        return s;
    }
    public int countEnemyType(int enemyType) {
        int s = 0;
        for(int i=0; i<levels.length; i++) {
            s += levels[i].countEnemyType(enemyType);
        }
        return s;
    }
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
    public String mostValuableEnemy() {
        if(showEnemies().equals("")) return "\nAdd an enemy first";

        Enemy mostValuable = null;
        double max = -1;
        int level = -1;
        for(int i=0; i<levels.length; i++) {
            if(levels[i].mostValuableEnemy() != null && levels[i].mostValuableEnemy().getScoreAddition() > max) {
                mostValuable = levels[i].mostValuableEnemy();
                max = mostValuable.getScoreAddition();
                level = levels[i].getId();
            }
        }
        if(max == -1) {
            return "\nThere are not enemies assigned to a level yet";
        } else {
            return "\nThe most valuable enemy is " + mostValuable.getId() + " of type " + mostValuable.getType() + " on level " + level;
        }
    }
    public int countEnemyConsonants() {
        int s = 0;
        for(int i=0; i<enemies.length; i++) {
            if(enemies[i] != null) {
                
                String enemyNameTmp = enemies[i].getId();
                for(int j=0; j<enemyNameTmp.length(); j++) {
                    char tmpChar = Character.toLowerCase(enemyNameTmp.charAt(j));
                    if(tmpChar != 'a' && tmpChar != 'e' && tmpChar != 'i' && tmpChar != 'o' && tmpChar != 'u') s++;
                }
            }
        }
        return "\n The number of consonants in enemy names is " + s;
    }
    
    // TOP
    public String playerTop(int topLimit) {
        if(countRealPlayers(players) < 5) {
            return "\nThere are not enough players";
        }
        String topList = "";
        Player[] playerTop = new Player[countRealPlayers(players)];
        for(int i=0; i<playerTop.length; i++) {
            System.out.println(getTopPlayer(playerTop));
            playerTop[i] = getTopPlayer(playerTop);
        }

        topList += "\nPlayer Top 5: ";
        for(int i=0; i<playerTop.length &&  i<5; i++) {
            if(playerTop[i] != null) {
                topList += "\n" + (i+1) + ". name: " + playerTop[i].getName() + ", score: " + playerTop[i].getScore();
            }
        }
        return topList;
    }
    public Player getTopPlayer(Player[] topPlayers) {
        double maxScore = -1;
        Player topPlayer = null;
        for(int i=0; i<players.length; i++) {
            if(players[i] != null && !isPlayerInTop(players[i], topPlayers)) {
                if(players[i].getScore() >= maxScore) {
                    topPlayer = players[i];
                    maxScore = topPlayer.getScore();
                }
            }
        }
        return topPlayer;
    }
    public int countRealPlayers(Player[] players) {
        for(int i=0; i<players.length; i++) {
            if(players[i] == null) {
                return i;
            }
        }
        return players.length;
    }
    public boolean isPlayerInTop(Player tmpPlayer, Player[] topPlayers) {
        for(int i=0; i<topPlayers.length; i++) {
            if(topPlayers[i] != null && topPlayers[i] == tmpPlayer) {
                return true;
            }
        }
        return false;
    }
}
