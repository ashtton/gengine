package me.gleeming.gengine.camera.effect;

import me.gleeming.gengine.camera.GengineCamera;

public interface CameraEffect {
    void setCamera(GengineCamera camera);
    void update();
}
