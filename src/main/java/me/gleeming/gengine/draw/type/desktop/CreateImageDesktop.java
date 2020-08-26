package me.gleeming.gengine.draw.type.desktop;

import me.gleeming.gengine.color.GengineColor;
import me.gleeming.gengine.loop.types.DesktopGameLoop;
import me.gleeming.gengine.resource.Resource;
import me.gleeming.gengine.resource.type.DesktopResource;

import java.awt.*;

public class CreateImageDesktop {
    public CreateImageDesktop(GengineColor color, int x, int y, int width, int height, Resource resource) {
        Graphics2D graphics2D = DesktopGameLoop.getDrawTo();

        if(color != null) graphics2D.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue()));

        graphics2D.drawImage((resource.getDesktopResource()).toBufferedImage(), x, y, width, height, null);
    }
}
