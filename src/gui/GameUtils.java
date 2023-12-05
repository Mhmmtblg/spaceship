package gui;

public class GameUtils {
    public GameUtils() {
        this.gamePoint = 0;
        this.usedMunition = 0;
        this.gameTime = 0;
    }

    private int gamePoint;
    private int usedMunition;
    private int gameTime;


    public void setPointToHitTarget() {
        this.gamePoint += 100;
    }
    public void setPointToHitObstacle() {
        this.gamePoint += 50;
    }

    public int getUsedMunition() {
        return usedMunition;
    }

    public void setUsedMunition() {
        this.usedMunition +=1;
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime() {
        this.gameTime +=1;
    }



}
