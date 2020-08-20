package me.gleeming.gengine.draw.type.desktop;

import me.gleeming.gengine.color.GengineColor;
import me.gleeming.gengine.font.GengineFont;
import me.gleeming.gengine.loop.types.DesktopGameLoop;

import java.awt.*;

public class CreateTextDesktop {
    public CreateTextDesktop(String string, int x, int y, GengineColor color, GengineFont font) {
        Graphics2D graphics2D = DesktopGameLoop.getDrawTo();

        if(font != null) graphics2D.setFont(font.getAwtFont());
        if(color != null) graphics2D.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue()));

        graphics2D.drawString(string, x, y);
    }
}
