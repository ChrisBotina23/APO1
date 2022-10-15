package model;

public class Enemy {
    private String id;
    private EnemyType type;
    private double scoreAddition;
    private double scoreSubtraction;
    private int[] position = {-1,-1};
    public Enemy(String id, int type, double scoreAddition, double scoreSubtraction) {
        this.id = id;
        this.type = EnemyType.values()[type];
        this.scoreAddition = scoreAddition;
        this.scoreSubtraction = scoreSubtraction;
    }

    // GETTERS AND SETTERS

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public EnemyType getType() {
        return type;
    }
    public void setType(EnemyType type) {
        this.type = type;
    }
    public double getScoreAddition() {
        return scoreAddition;
    }
    public void setScoreAddition(double scoreAddition) {
        this.scoreAddition = scoreAddition;
    }
    public double getScoreSubtraction() {
        return scoreSubtraction;
    }
    public void setScoreSubtraction(double scoreSubtraction) {
        this.scoreSubtraction = scoreSubtraction;
    }
    public int[] getPosition() {
        return position;
    }
    public void setPosition(int[] position) {
        this.position = position;
    }
    public String toString() {
        return ""
        + "name: " + this.id 
        + ", type: " + this.type 
        + ", score addition: " + this.scoreAddition
        + ", score subtraction: " + this.scoreSubtraction;
        // + ", position: (" + this.position[0] + "," + this.position[1] + ")"
    }

}
