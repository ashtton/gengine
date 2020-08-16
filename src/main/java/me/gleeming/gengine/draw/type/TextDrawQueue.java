package me.gleeming.gengine.draw.type;

import lombok.Getter;
import me.gleeming.gengine.draw.DrawQueue;
import me.gleeming.gengine.font.GengineFont;
import me.gleeming.gengine.font.type.AWTGengineFont;
import me.gleeming.gengine.loop.GameLoop;

import java.awt.*;

public class TextDrawQueue implements DrawQueue {
    @Getter private final String string;

    @Getter private final int x;
    @Getter private final int y;

    @Getter private final GengineFont font;
    @Getter private Color color;
    public TextDrawQueue(String string, int x, int y, GengineFont font) {
        this.string = string;
        this.x = x;
        this.y = y;
        this.font = font;
    }

    public TextDrawQueue(String string, int x, int y, int size) {
        this.string = string;
        this.x = x;
        this.y = y;
        this.font = new AWTGengineFont(GameLoop.getInstance().getFont().deriveFont(Font.PLAIN, size));
    }


    public void draw(Graphics2D graphics2D, int x, int y) {
        if(font != null) graphics2D.setFont(font.getAwtFont());
        if(color != null) graphics2D.setColor(color);

        graphics2D.drawString(string, x, y);
    }

    public TextDrawQueue setColor(Color color) { this.color = color; return this; }
    @Getter private final int width = 0;
    @Getter private final int height = 0;
}
