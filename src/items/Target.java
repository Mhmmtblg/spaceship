package items;

public class Target {
    private boolean isIntersected;
    private int coordinateX;
    private int coordinateY;
    private int movementSizeX = 2;
    private int movementSizeY = 1;


    public Target() {
        this.coordinateX = 0;
        this.coordinateY = 0;
        this.isIntersected = false;
    }

    public boolean isIntersected() {
        return isIntersected;
    }

    public void setIntersected(boolean intersected) {
        isIntersected = intersected;
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
