package me.gleeming.gengine.game.provider.type;

import lombok.Getter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.camera.GengineCamera;
import me.gleeming.gengine.game.provider.GameProvider;
import me.gleeming.gengine.input.type.GengineDesktopInput;
import me.gleeming.gengine.loop.types.DesktopGameLoop;
import me.gleeming.gengine.resource.Resource;
import me.gleeming.gengine.sound.desktop.DesktopSoundEngine;

public class DesktopProvider implements GameProvider {
    @Getter private final String windowName;
    @Getter private final Resource windowImage;
    @Getter private final int width;
    @Getter private final int height;
    public DesktopProvider(String windowName, Resource windowImage, int width, int height) {
        this.windowName = windowName;
        this.windowImage = windowImage;
        this.width = width;
        this.height = height;
    }

    public DesktopProvider(String windowName, int width, int height) { this(windowName, null, width, height); }

    public static DesktopGameLoop getGameLoop() { return (DesktopGameLoop) Gengine.getInstance().getGameLoop(); }
    public static GengineDesktopInput getInput() { return (GengineDesktopInput) Gengine.getInstance().getInput(); }
    public static DesktopSoundEngine getSoundEngine() { return (DesktopSoundEngine) Gengine.getInstance().getSoundEngine(); }
    public static GengineCamera getCamera() { return Gengine.getInstance().getCamera(); }
}
