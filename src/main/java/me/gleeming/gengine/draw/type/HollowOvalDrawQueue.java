package me.gleeming.gengine.draw.type;

import lombok.Getter;
import me.gleeming.gengine.draw.DrawQueue;

import java.awt.*;

public class HollowOvalDrawQueue implements DrawQueue {
    @Getter private final int x;
    @Getter private final int y;

    @Getter private final int width;
    @Getter private final int height;

    @Getter private final Color color;
    public HollowOvalDrawQueue(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics2D graphics2D, int x, int y) {
        graphics2D.setColor(color);
        graphics2D.drawOval(x, y, width, height);
    }
}
