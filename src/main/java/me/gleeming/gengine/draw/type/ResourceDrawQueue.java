package me.gleeming.gengine.draw.type;

import lombok.Getter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.color.GengineColor;
import me.gleeming.gengine.draw.DrawQueue;
import me.gleeming.gengine.draw.type.android.*;
import me.gleeming.gengine.draw.type.desktop.*;
import me.gleeming.gengine.game.provider.type.AndroidProvider;
import me.gleeming.gengine.game.provider.type.DesktopProvider;
import me.gleeming.gengine.resource.Resource;

public class ResourceDrawQueue implements DrawQueue {
    @Getter private final Resource resource;

    @Getter private final int x;
    @Getter private final int y;
    @Getter private final int width;
    @Getter private final int height;

    @Getter private GengineColor color;
    public ResourceDrawQueue(Resource resource, int x, int y, int width, int height) {
        this.resource = resource;

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public ResourceDrawQueue setColor(GengineColor color) { this.color = color; return this; }

    public void draw(int x, int y) {
        if(Gengine.getInstance().getGameProvider() instanceof DesktopProvider) new CreateImageDesktop(color, x, y, width, height, resource);
        else if(Gengine.getInstance().getGameProvider() instanceof AndroidProvider) new CreateImageAndroid(x, y, resource, color);
    }
}
