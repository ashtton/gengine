package me.gleeming.gengine.camera;

import lombok.Getter;
import lombok.Setter;

public class GengineCamera {
    @Getter private static GengineCamera instance;

    @Getter @Setter private int x;
    @Getter @Setter private int y;
    public GengineCamera() {
        instance = this;

        this.x = 0;
        this.y = 0;
    }

    public void changePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
