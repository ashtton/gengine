package me.gleeming.gengine;

import lombok.Getter;
import lombok.Setter;
import me.gleeming.gengine.camera.GengineCamera;
import me.gleeming.gengine.input.GengineInput;
import me.gleeming.gengine.loop.GameLoop;
import me.gleeming.gengine.resource.Resource;
import me.gleeming.gengine.screen.GengineScreen;

public class Gengine {
    @Getter private static Gengine instance;

    @Getter private final String windowName;
    @Getter private final Resource windowImage;

    @Getter private final int width;
    @Getter private final int height;

    @Getter @Setter private GengineScreen currentScreen;
    public Gengine(String windowName, Resource windowImage, int width, int height) {
        instance = this;

        this.windowName = windowName;
        this.windowImage = windowImage;

        this.width = width;
        this.height = height;

        new GengineInput();
        new GengineCamera();
        new GameLoop();
    }
}
