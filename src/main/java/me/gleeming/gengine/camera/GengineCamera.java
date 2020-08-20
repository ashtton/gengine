package me.gleeming.gengine.camera;

import lombok.Getter;
import lombok.Setter;
import me.gleeming.gengine.camera.effect.CameraEffect;

import java.util.ArrayList;
import java.util.List;

public class GengineCamera {
    @Getter @Setter private int x;
    @Getter @Setter private int y;

    @Getter private final List<CameraEffect> currentEffeects;
    public GengineCamera() {
        this.x = 0;
        this.y = 0;

        this.currentEffeects = new ArrayList<>();
    }

    public void applyEffect(CameraEffect effect) { effect.setCamera(this); currentEffeects.add(effect); }

    public void changePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
