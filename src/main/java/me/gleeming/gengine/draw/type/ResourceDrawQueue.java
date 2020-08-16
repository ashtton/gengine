package me.gleeming.gengine.draw.type;

import lombok.Getter;
import lombok.Setter;
import me.gleeming.gengine.draw.DrawQueue;
import me.gleeming.gengine.resource.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ResourceDrawQueue implements DrawQueue {
    @Getter private final BufferedImage bufferedImage;

    @Getter private final int x;
    @Getter private final int y;
    @Getter private final int width;
    @Getter private final int height;

    @Getter private Color color;
    @Getter private float xScale;
    @Getter private float yScale;
    public ResourceDrawQueue(Resource resource, int x, int y, int width, int height) {
        this.bufferedImage = resource.getBufferedImage();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public ResourceDrawQueue setColor(Color color) { this.color = color; return this; }

//    public ResourceDrawQueue setScale(float xScale, float yScale) { this.xScale = xScale; this.yScale = yScale; return this; }
//    public ResourceDrawQueue setScale(float scale) { this.xScale = scale; this.yScale = scale; return this; }

    public void draw(Graphics2D graphics2D, int x, int y) {
        if(color != null) graphics2D.setColor(color);
        if(xScale != 0 || yScale != 0) graphics2D.scale(xScale, yScale);

        graphics2D.drawImage(bufferedImage, x, y, width, height, null);

        if(xScale != 0 || yScale != 0) graphics2D.scale(-xScale, -yScale);
    }
}
