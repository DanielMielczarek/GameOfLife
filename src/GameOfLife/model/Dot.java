package GameOfLife.model;

public class Dot {

    private int xPosition;
    private int yPosition;
    private boolean isALive;

    Dot(int xPosition, int yPosition, boolean isALive) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.isALive = isALive;
    }
    public boolean isALive() {
        return isALive;
    }

    public void setALive(boolean ALive) {
        isALive = ALive;
    }
}


