package Setup;

public class Target {

    private int coordinateX;
    private int coordinateY;
    private int movementSizeX = 2;
    private int movementSizeY = 1;


    public Target() {
        this.coordinateX = 0;
        this.coordinateY = 0;

    }

    public void moveTarget() {
        this.coordinateX += movementSizeX;
        if (coordinateX >= 765) {
            movementSizeX = -movementSizeX;
        }
        if (coordinateX <= 0) {
            movementSizeX = -movementSizeX;
        }

        this.coordinateY += movementSizeY;
        if (coordinateY >= 50) {
            movementSizeY = -movementSizeY;
        }
        if (coordinateY <= 0) {
            movementSizeY = -movementSizeY;
        }


    }

    public int getCoordinateX() {
        return coordinateX;
    }


    public int getCoordinateY() {
        return coordinateY;
    }


}
