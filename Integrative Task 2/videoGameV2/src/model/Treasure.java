package model;

public class Treasure {
    private String name;
    private String pictureUrl;
    private double scoreAddition;
    private int[] position = {-1,-1};
    public Treasure(String name, String pictureUrl, double scoreAddition) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.scoreAddition = scoreAddition;
    }
    
    // GETTERS AND SETTERS

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPictureUrl() {
        return pictureUrl;
    }
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    public double getScoreAddition() {
        return scoreAddition;
    }
    public void setScoreAddition(double scoreAddition) {
        this.scoreAddition = scoreAddition;
    }
    public int[] getPosition() {
        return position;
    }
    public void setPosition(int[] position) {
        this.position = position;
    }
    public String toString() {
        return ""
        + "name: " + this.name 
        + ", picture: " + this.pictureUrl 
        + ", score addition: " + this.scoreAddition;
        // + ", position: (" + this.position[0] + "," + this.position[1] + ")"
    }
}
