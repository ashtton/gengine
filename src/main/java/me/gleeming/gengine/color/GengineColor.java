package me.gleeming.gengine.color;

import lombok.Getter;
import lombok.Setter;

public class GengineColor {
    @Getter @Setter private float alpha;
    @Getter private final int red;
    @Getter private final int blue;
    @Getter private final int green;
    public GengineColor(int red, int blue, int green) {
        this(1, red, blue, green);
    }

    public GengineColor(int alpha, int red, int blue, int green) {
        this.alpha = alpha;
        this.red = red;
        this.blue = blue;
        this.green = green;
    }
}
