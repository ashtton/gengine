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

    @Getter @Setter private Color color;
    public ResourceDrawQueue(Resource resource, int x, int y, int width, int height) {
        this.bufferedImage = resource.getBufferedImage();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics2D graphics2D, int x, int y) {
        if(color != null) graphics2D.setColor(color);
        graphics2D.drawImage(bufferedImage, x, y, width, height, null);
    }
}
