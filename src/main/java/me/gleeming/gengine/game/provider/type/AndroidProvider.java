package me.gleeming.gengine.game.provider.type;

import android.app.Activity;
import lombok.Getter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.camera.GengineCamera;
import me.gleeming.gengine.game.provider.GameProvider;
import me.gleeming.gengine.loop.types.AndroidGameLoop;

public class AndroidProvider implements GameProvider {
    public int getWidth() { return defaultActivity.getWindowManager().getDefaultDisplay().getWidth(); }
    public int getHeight() { return defaultActivity.getWindowManager().getDefaultDisplay().getHeight(); }

    @Getter private final Activity defaultActivity;
    public AndroidProvider(Activity defaultActivity) {
        this.defaultActivity = defaultActivity;
    }

    public static AndroidGameLoop getGameLoop() { return (AndroidGameLoop) Gengine.getInstance().getGameLoop(); }
//    public static GengineDesktopInput getInput() { return (GengineDesktopInput) Gengine.getInstance().getInput(); }
//    public static DesktopSoundEngine getSoundEngine() { return (DesktopSoundEngine) Gengine.getInstance().getSoundEngine(); }
    public static GengineCamera getCamera() { return Gengine.getInstance().getCamera(); }
}
