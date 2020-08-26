package me.gleeming.gengine;

import android.view.Window;
import android.view.WindowManager;
import lombok.Getter;
import me.gleeming.gengine.camera.GengineCamera;
import me.gleeming.gengine.game.provider.GameProvider;
import me.gleeming.gengine.game.provider.type.AndroidProvider;
import me.gleeming.gengine.game.provider.type.DesktopProvider;
import me.gleeming.gengine.input.GengineInput;
import me.gleeming.gengine.input.type.GengineDesktopInput;
import me.gleeming.gengine.loop.GameLoop;
import me.gleeming.gengine.loop.types.AndroidGameLoop;
import me.gleeming.gengine.loop.types.DesktopGameLoop;
import me.gleeming.gengine.screen.GengineScreen;
import me.gleeming.gengine.sound.GengineSoundEngine;
import me.gleeming.gengine.sound.desktop.DesktopSoundEngine;

public class Gengine {
    @Getter private static Gengine instance;
    @Getter private final GameProvider gameProvider;

    @Getter private GameLoop gameLoop;
    @Getter private GengineSoundEngine soundEngine;
    @Getter private GengineCamera camera;
    @Getter private GengineInput input;

    @Getter private GengineScreen currentScreen;
    public Gengine(GameProvider gameProvider) {
        instance = this;

        this.gameProvider = gameProvider;

        if(gameProvider instanceof DesktopProvider) initDesktop((DesktopProvider) gameProvider);
        if(gameProvider instanceof AndroidProvider) initAndroid((AndroidProvider) gameProvider);
    }

    public void initAndroid(AndroidProvider provider) {
        AndroidGameLoop loop = new AndroidGameLoop();

        gameLoop = loop;
        soundEngine = null;
        camera = new GengineCamera();
        input = null;

        provider.getDefaultActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        provider.getDefaultActivity().requestWindowFeature(Window.FEATURE_NO_TITLE);

        provider.getDefaultActivity().setContentView(loop);
    }

    public void initDesktop(DesktopProvider provider) {
        gameLoop = new DesktopGameLoop(provider.getWidth(), provider.getHeight(), provider.getWindowImage(), provider.getWindowName());
        soundEngine = new DesktopSoundEngine();
        camera = new GengineCamera();
        input = new GengineDesktopInput();
    }

    public void changeScreen(GengineScreen screen) { this.currentScreen = screen; }
}
