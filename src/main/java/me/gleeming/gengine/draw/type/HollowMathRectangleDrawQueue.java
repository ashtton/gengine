package me.gleeming.gengine.draw.type;

import lombok.Getter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.color.GengineColor;
import me.gleeming.gengine.draw.DrawQueue;
import me.gleeming.gengine.draw.type.android.*;
import me.gleeming.gengine.draw.type.desktop.*;
import me.gleeming.gengine.game.provider.type.AndroidProvider;
import me.gleeming.gengine.game.provider.type.DesktopProvider;
import me.gleeming.gengine.math.Rectangle;


public class HollowMathRectangleDrawQueue implements DrawQueue {
    @Getter private final int x;
    @Getter private final int y;

    @Getter private final int width;
    @Getter private final int height;

    @Getter private final GengineColor color;
    public HollowMathRectangleDrawQueue(Rectangle rectangle, GengineColor color) {
        this.x = rectangle.getBottomLeftPoint().getX();
        this.y = rectangle.getBottomLeftPoint().getY();
        this.width = rectangle.getWidth();
        this.height = rectangle.getHeight();
        this.color = color;
    }

    public void draw(int x, int y) {
        if(Gengine.getInstance().getGameProvider() instanceof DesktopProvider) new CreateRectangleDesktop(x, y, width, height, color, false);
        else if(Gengine.getInstance().getGameProvider() instanceof AndroidProvider) new CreateRectangleAndroid(x, y, width, height, color, false);
    }
}
