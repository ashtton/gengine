package me.gleeming.gengine.font;

import android.graphics.Typeface;
import lombok.Getter;
import lombok.Setter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.game.provider.type.AndroidProvider;

import java.awt.*;

public abstract class GengineFont {
    @Getter private Font awtFont;
    @Getter @Setter private String path;
    public void setFont(Font awtFont) {
        this.awtFont = awtFont;
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(awtFont);
    }

    public GengineFont setSize(int size) { awtFont = awtFont.deriveFont(Font.PLAIN, size); return this; }

    public Typeface toAndroidFont() {
        return Typeface.createFromAsset(((AndroidProvider) Gengine.getInstance().getGameProvider()).getDefaultActivity().getAssets(), path);
    }
}
