package me.gleeming.gengine.draw;

import java.awt.*;

public interface DrawQueue {
    void draw(Graphics2D graphics2D, int x, int y);

    int getX();
    int getY();

    int getWidth();
    int getHeight();
}
