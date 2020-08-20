package me.gleeming.gengine.camera.effect.type;

import lombok.Getter;
import lombok.Setter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.camera.GengineCamera;
import me.gleeming.gengine.camera.effect.CameraEffect;

import java.util.Date;
import java.util.Random;

public class CameraShake implements CameraEffect {
    @Getter @Setter private GengineCamera camera;

    @Getter private final Date lastsTo;
    @Getter private final float length;
    @Getter private final float power;

    private float currentTime;
    public CameraShake(float length, float power) {
        this.lastsTo = new Date((long) (System.currentTimeMillis() + (1000 * length)));
        this.length = length;
        this.power = power;
        this.currentTime = 0;
    }

    public void update() {
        if(camera == null) return;

        if (!(new Date(System.currentTimeMillis()).after(lastsTo))) {
            Random random = new Random();
            float currentPower = power * ((length - currentTime) / length);

            camera.changePosition(
                    (int) ((random.nextFloat() - 0.5f) * 2 * currentPower),
                    (int) ((random.nextFloat() - 0.5f) * 2 * currentPower));

//            currentTime += Gengine.getInstance().getGameLoop().getDeltaTime();
        } else camera.getCurrentEffeects().remove(this);
    }
}
