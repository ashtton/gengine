package me.gleeming.gengine.screen.menu.text.entry;

import lombok.Getter;
import lombok.Setter;
import me.gleeming.gengine.font.GengineFont;
import me.gleeming.gengine.math.Rectangle;

public class TextEntry {
    @Getter private String name;
    @Getter private String displayText;

    @Getter @Setter private GengineFont font;
    @Getter @Setter private String text;

    @Getter private int x;
    @Getter private int y;
    @Getter private int width;
    @Getter private int height;
    public TextEntry(String name, String displayText, int x, int y, int width, int height, GengineFont font) {
        this.name = name;
        this.displayText = displayText;

        this.font = font;
        this.text = "";

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public TextEntry(String name, String displayText, int x, int y, int width, int height) { this(name, displayText, x, y, width, height, null); }
}
