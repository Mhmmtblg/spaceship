package items;

import java.util.ArrayList;
import java.util.List;

public class GameUtils {

    private int level;

    private int gameTime;


    public GameUtils() {

        this.level = 1;

        this.gameTime = 0;
    }


    public void setLevel(int level) {
        this.level = level;
    }


    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime() {
        this.gameTime +=1;
    }




}
