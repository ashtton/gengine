package me.gleeming.gengine.camera;

import lombok.Getter;
import lombok.Setter;

public class GengineCamera {
    @Getter @Setter private int x;
    @Getter @Setter private int y;
    public GengineCamera() {
        this.x = 0;
        this.y = 0;
    }

    public void changePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
