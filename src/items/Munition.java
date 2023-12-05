package items;

public class Munition {

    private boolean isIntersected;
    private int coordinateX;
    private int coordinateY;
    private int movementSizeY = 2;

    public Munition(int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
        this.isIntersected=false;

    }
    public boolean isIntersected() {
        return isIntersected;
    }

    public void setIntersected(boolean intersected) {
        isIntersected = intersected;
    }

    public boolean isMissed() {
        return (this.coordinateY < 0);
    }

    public void moveMunition() {
        this.coordinateY -= movementSizeY;

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
