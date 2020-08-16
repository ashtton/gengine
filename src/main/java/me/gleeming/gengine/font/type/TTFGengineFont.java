package me.gleeming.gengine.font.type;

import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.font.GengineFont;

import java.awt.*;

public class TTFGengineFont extends GengineFont {
    public TTFGengineFont(String path) {
        try {
            setFont(Font.createFont(Font.TRUETYPE_FONT, Gengine.getInstance().getClass().getResourceAsStream(path.startsWith("/") ? path : "/" + path)));
        } catch(Exception ex) { ex.printStackTrace(); System.out.println("[Gengine] Error while loading font from '" + path + "'"); }
    }
}
