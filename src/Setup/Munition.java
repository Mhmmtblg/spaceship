package Setup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Munition {


    private int coordinateX;
    private int coordinateY;
    private int movementSizeX;
    private int movementSizeY = 1;

    Munition() {
        this.coordinateX = 0;
        this.coordinateY = 15;

    }


    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }




}
