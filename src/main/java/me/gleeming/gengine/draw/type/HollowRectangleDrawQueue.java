package me.gleeming.gengine.draw.type;

import lombok.Getter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.color.GengineColor;
import me.gleeming.gengine.draw.DrawQueue;
import me.gleeming.gengine.draw.type.android.*;
import me.gleeming.gengine.draw.type.desktop.*;
import me.gleeming.gengine.game.provider.type.AndroidProvider;
import me.gleeming.gengine.game.provider.type.DesktopProvider;

public class HollowRectangleDrawQueue implements DrawQueue {
    @Getter private final int x;
    @Getter private final int y;

    @Getter private final int width;
    @Getter private final int height;

    @Getter private final GengineColor color;
    public HollowRectangleDrawQueue(int x, int y, int width, int height, GengineColor color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(int x, int y) {
        if(Gengine.getInstance().getGameProvider() instanceof DesktopProvider) new CreateRectangleDesktop(x, y, width, height, color, true);
        else if(Gengine.getInstance().getGameProvider() instanceof AndroidProvider) new CreateRectangleAndroid(x, y, width, height, color, true);
    }
}
