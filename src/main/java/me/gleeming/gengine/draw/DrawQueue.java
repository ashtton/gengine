package me.gleeming.gengine.draw;

public interface DrawQueue {
    void draw(int x, int y);

    int getX();
    int getY();

    int getWidth();
    int getHeight();
}
