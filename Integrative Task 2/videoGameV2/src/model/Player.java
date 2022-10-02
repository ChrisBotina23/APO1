package model;

public class Player {
    private String id;
    private String name;
    private double score;
    private int lives;
    private int level;
    
    public Player(String id, String name) {
        this.id = id;
        this.name = name;
        this.score = 10;
        this.lives = 5;
        this.level = 1;       
    }
    
    // GETTERS AND SETTERS
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public int getLives() {
        return lives;
    }
    public void setLives(int lives) {
        this.lives = lives;
    }

    public String toString() {
        return ""
        + "id: " + this.id
        + ", name: " + this.name
        + ", score: " + this.score
        + ", lives: " + this.lives;

    }
}
