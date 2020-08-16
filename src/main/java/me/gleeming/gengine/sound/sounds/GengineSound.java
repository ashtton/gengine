package me.gleeming.gengine.sound.sounds;

import lombok.Getter;
import lombok.Setter;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public abstract class GengineSound {
    @Getter @Setter private Clip clip;

    public GengineSound setVolume(float volume) { ((FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN)).setValue((float) (Math.log(volume) / Math.log(10.0) * 20.0)); return this; }
}
