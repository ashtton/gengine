package me.gleeming.gengine.loop.types;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import lombok.Getter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.camera.effect.CameraEffect;
import me.gleeming.gengine.draw.DrawQueue;
import me.gleeming.gengine.game.provider.type.AndroidProvider;
import me.gleeming.gengine.loop.GameLoop;

import java.util.ArrayList;

public class AndroidGameLoop extends SurfaceView implements GameLoop, SurfaceHolder.Callback {
    @Getter private static Canvas drawTo;

    private SurfaceHolder surfaceHolder;
    public AndroidGameLoop() {
        super(((AndroidProvider) Gengine.getInstance().getGameProvider()).getDefaultActivity());

        getHolder().addCallback(this);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;

        new Thread() {
            public void run() {
                while (true) {
                    update();
                    try {
                        Thread.sleep(17);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void update() {
        this.paint();

        for (CameraEffect cameraEffect : new ArrayList<>(Gengine.getInstance().getCamera().getCurrentEffeects())) cameraEffect.update();
    }

    public void paint() {
        if(Gengine.getInstance() == null || Gengine.getInstance().getCurrentScreen() == null) return;
        Log.d("nerd", "paint");

        Canvas canvas = surfaceHolder.lockCanvas();

        for (DrawQueue queue : Gengine.getInstance().getCurrentScreen().draw(new ArrayList<>())) {
            int cameraX = AndroidProvider.getCamera().getX();
            int cameraY = AndroidProvider.getCamera().getY();

            int gameWidth = Gengine.getInstance().getGameProvider().getWidth();
            int gameHeight = Gengine.getInstance().getGameProvider().getHeight();

            drawTo = canvas;

            if(queue.getX() + queue.getWidth() >= cameraX && cameraX + gameWidth >= queue.getX() - queue.getWidth() && queue.getY() + queue.getHeight() >= cameraY && cameraY + gameHeight >= queue.getY()) {
                queue.draw(queue.getX() + cameraX, queue.getY() + cameraY);
            }
        }

        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) { }
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) { }
}
