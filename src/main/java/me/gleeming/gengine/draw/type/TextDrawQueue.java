package me.gleeming.gengine.draw.type;

import lombok.Getter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.color.GengineColor;

import me.gleeming.gengine.draw.DrawQueue;
import me.gleeming.gengine.draw.type.android.*;
import me.gleeming.gengine.draw.type.desktop.*;
import me.gleeming.gengine.font.GengineFont;
import me.gleeming.gengine.game.provider.type.AndroidProvider;
import me.gleeming.gengine.game.provider.type.DesktopProvider;

public class TextDrawQueue implements DrawQueue {
    @Getter private final String string;

    @Getter private final int x;
    @Getter private final int y;

    @Getter private GengineFont font;
    @Getter private GengineColor color;
    public TextDrawQueue(String string, int x, int y, GengineFont font) {
        this.string = string;
        this.x = x;
        this.y = y;
        this.font = font;
    }

    public TextDrawQueue(String string, int x, int y) {
        this.string = string;
        this.x = x;
        this.y = y;
    }

    public void draw(int x, int y) {
        if(Gengine.getInstance().getGameProvider() instanceof DesktopProvider) new CreateTextDesktop(string, x, y, color, font);
        else if(Gengine.getInstance().getGameProvider() instanceof AndroidProvider) new CreateTextAndroid(string, x, y, color, font);
    }

    public TextDrawQueue setColor(GengineColor color) { this.color = color; return this; }
    @Getter private final int width = 0;
    @Getter private final int height = 0;
}
