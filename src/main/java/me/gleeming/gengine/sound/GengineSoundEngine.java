package me.gleeming.gengine.sound;

import lombok.Getter;
import me.gleeming.gengine.sound.sounds.GengineSound;

import javax.sound.sampled.Clip;

public class GengineSoundEngine {
    @Getter private static GengineSoundEngine instance;

    @Getter private GengineSound currentMusic;
    public GengineSoundEngine() {
        instance = this;
    }

    public void changeMainMusic(GengineSound music) {
        if(currentMusic != null) currentMusic.getClip().stop();

        this.currentMusic = music;
        this.currentMusic.getClip().loop(Clip.LOOP_CONTINUOUSLY);
        this.currentMusic.getClip().start();
    }

    public void playSoundEffect(GengineSound soundEffect) { soundEffect.getClip().start(); }
}
