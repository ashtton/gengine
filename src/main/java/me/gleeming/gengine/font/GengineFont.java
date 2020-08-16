package me.gleeming.gengine.font;

import lombok.Getter;

import java.awt.*;

public abstract class GengineFont {
    @Getter private Font awtFont;
    public void setFont(Font awtFont) {
        this.awtFont = awtFont;
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(awtFont);
    }

    public GengineFont setSize(int size) { awtFont = awtFont.deriveFont(Font.PLAIN, size); return this; }
}
