package Setup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpaceShip {
    private int level;
    private int coordinateX;
    private int coordinateY;

    private int movementSizeX = 20;
    private int movementSizeY = 5;

    private static String defaultBildPath = "bild/";
    private BufferedImage spaceShipImage;

    SpaceShip() {
        this.level = 1;
        this.coordinateX = 0;
        this.coordinateY = 440;
        assignSpaceShipImage();


    }


    public void assignSpaceShipImage() {
        try {
            this.spaceShipImage = ImageIO.read(new File(defaultBildPath + this.level + "_spacecraft.png"));
        } catch (IOException e) {
            Logger.getLogger(SpaceShip.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public BufferedImage getSpaceShipImage() {
        return spaceShipImage;
    }


    public int getCoordinateX() {
        return coordinateX;
    }


    public int getCoordinateY() {
        return coordinateY;
    }


    public int getImageWidth() {

        return spaceShipImage.getWidth() / 6;
    }

    public int getImageHeight() {
        return spaceShipImage.getHeight() / 6;
    }

    public void moveShipLeft() {
        if (this.coordinateX <= -25) {
            this.coordinateX =-25;
        }else{
            this.coordinateX -= movementSizeX;
        }

    }

    public void moveShipRight() {
        if (this.coordinateX >= 750) {
            this.coordinateX =750;
        }else{
            this.coordinateX += movementSizeX;
        }

    }
    public void moveShipUp() {
        if (this.coordinateY <= 350) {
            this.coordinateY = 350;
        }else{
            this.coordinateY -= movementSizeY;
        }

    }
    public void moveShipDown() {
        if (this.coordinateY >= 440) {
            this.coordinateY = 440;
        }else{
            this.coordinateY += movementSizeY;
        }

    }


}
