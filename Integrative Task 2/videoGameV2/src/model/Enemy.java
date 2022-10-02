package model;

public class Enemy {
    private String id;
    private EnemyType type;
    private double scoreAddition;
    private double scoreSubstraction;
    private int[] position = {-1,-1};
    public Enemy(String id, int type, double scoreAddition, double scoreSubstraction) {
        this.id = id;
        this.type = EnemyType.values()[type];
        this.scoreAddition = scoreAddition;
        this.scoreSubstraction = scoreSubstraction;
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
    public double getScoreSubstraction() {
        return scoreSubstraction;
    }
    public void setScoreSubstraction(double scoreSubstraction) {
        this.scoreSubstraction = scoreSubstraction;
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
        + ", score substraction: " + this.scoreSubstraction;
        // + ", position: (" + this.position[0] + "," + this.position[1] + ")"
    }

}
