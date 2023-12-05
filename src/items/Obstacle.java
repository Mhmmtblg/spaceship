package items;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Obstacle {

    private boolean isIntersected;
    private int coordinateX;
    private int coordinateY;
    private final int movementSizeY = 1;
    private static String defaultBildPath = "bild/";
    private BufferedImage obstacleImage;

    public Obstacle() {
        this.coordinateX = generateCoordinateX();
        this.coordinateY = -20;
        this.isIntersected= false;
        assignMoonImage();
    }

    public boolean isIntersected() {
        return isIntersected;
    }

    public void setIntersected(boolean intersected) {
        isIntersected = intersected;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public BufferedImage getObstacleImage() {
        return obstacleImage;
    }

    private int generateCoordinateX() {

        return new Random().nextInt(750);
    }


    public void moveObstacle() {
        this.coordinateY += movementSizeY;
    }


    public void assignMoonImage() {
        try {
            this.obstacleImage = ImageIO.read(new File(defaultBildPath + "obstacle.png"));
        } catch (IOException e) {
            Logger.getLogger(Obstacle.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public int getImageWidth() {

        return obstacleImage.getWidth() / 9;
    }

    public int getImageHeight() {
        return obstacleImage.getHeight() / 9;
    }
    public boolean isPassed() {
        return (this.coordinateY > 570);
    }

}
