package me.gleeming.gengine.sound.desktop.sounds.type;

import me.gleeming.gengine.sound.desktop.sounds.GengineSound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class WAVGengineSound extends GengineSound {
    public WAVGengineSound(String path) {
        try {
            AudioInputStream input = AudioSystem.getAudioInputStream(this.getClass().getResource(path.startsWith("/") ? path : "/" + path));
            Clip clip = AudioSystem.getClip();
            clip.open(input);
            setClip(clip);
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("[Gengine] Error while attempting to load sound effect from '" + path + "'");
        }
    }

}
