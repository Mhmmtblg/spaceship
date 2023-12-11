package items;

public class GameUtils {
    private int gamePoint;
    private int level;
    private int usedMunition;
    private int gameTime;

    public GameUtils() {

        this.gamePoint = 0;
        this.level = 1;
        this.usedMunition = 0;
        this.gameTime = 0;
    }

    public int getGamePoint() {
        return gamePoint;
    }

    public void setGamePoint(int gamePoint) {
        this.gamePoint = gamePoint;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getUsedMunition() {
        return usedMunition;
    }

    public void setUsedMunition(int usedMunition) {
        this.usedMunition = usedMunition;
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
    }


}
