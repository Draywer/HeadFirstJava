package ru.idcore.sinksite;

public class ShipPositionForDraw {
    private int x;
    private int y;
    private boolean aBoolean;

    public ShipPositionForDraw(int x, int y, boolean aBoolean) {
        this.x = x;
        this.y = y;
        this.aBoolean = aBoolean;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }


}
