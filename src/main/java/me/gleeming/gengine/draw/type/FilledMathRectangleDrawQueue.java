package me.gleeming.gengine.draw.type;

import lombok.Getter;
import me.gleeming.gengine.draw.DrawQueue;
import me.gleeming.gengine.math.Rectangle;

import java.awt.*;


public class FilledMathRectangleDrawQueue implements DrawQueue {
    @Getter private final int x;
    @Getter private final int y;

    @Getter private final int width;
    @Getter private final int height;

    @Getter private final Color color;
    public FilledMathRectangleDrawQueue(Rectangle rectangle, Color color) {
        this.x = rectangle.getBottomLeftPoint().getX();
        this.y = rectangle.getBottomLeftPoint().getY();
        this.width = rectangle.getWidth();
        this.height = rectangle.getHeight();
        this.color = color;
    }

    public void draw(Graphics2D graphics2D, int x, int y) {
        graphics2D.setColor(color);
        graphics2D.fillRect(x, y, width, height);
    }
}
