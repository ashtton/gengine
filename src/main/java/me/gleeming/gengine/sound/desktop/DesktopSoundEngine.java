package me.gleeming.gengine.sound.desktop;

import lombok.Getter;
import me.gleeming.gengine.sound.GengineSoundEngine;
import me.gleeming.gengine.sound.desktop.sounds.GengineSound;

import javax.sound.sampled.Clip;

public class DesktopSoundEngine implements GengineSoundEngine {
    @Getter private GengineSound currentMusic;

    public void changeMainMusic(GengineSound music) {
        if(currentMusic != null) currentMusic.getClip().stop();

        this.currentMusic = music;
        this.currentMusic.getClip().loop(Clip.LOOP_CONTINUOUSLY);
        this.currentMusic.getClip().start();
    }

    public void playSoundEffect(GengineSound soundEffect) { soundEffect.getClip().start(); }
}
