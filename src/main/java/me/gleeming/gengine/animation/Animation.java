package me.gleeming.gengine.animation;

import lombok.Getter;
import me.gleeming.gengine.resource.Resource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Animation {
    @Getter private final int fps;
    @Getter private final List<Resource> resources;
    @Getter private Resource currentFrame;

    private Iterator<Resource> resourceIterator;
    public Animation(int fps, Resource... resources) {
        this.fps = fps;
        this.resources = Arrays.asList(resources);
        this.resourceIterator = this.resources.iterator();

        start();
    }

    private void start() {
        new Thread() {
            public void run() {
                while(true) {
                    if(!resourceIterator.hasNext()) resourceIterator = resources.iterator();

                   currentFrame = resourceIterator.next();

                   try { Thread.sleep(1000 / fps); } catch(Exception ex) { ex.printStackTrace(); }
                }
            }
        }.start();
    }

}
