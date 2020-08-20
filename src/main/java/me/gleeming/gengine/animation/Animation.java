package me.gleeming.gengine.animation;

import lombok.Getter;
import lombok.Setter;
import me.gleeming.gengine.resource.type.DesktopResource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Animation {
    @Getter private final int fps;
    @Getter private final List<DesktopResource> resources;
    @Getter @Setter private boolean paused;

    private long lastRequest;
    private DesktopResource currentFrame;
    private Iterator<DesktopResource> resourceIterator;
    public Animation(int fps, DesktopResource... resources) {
        this.fps = fps;
        this.resources = Arrays.asList(resources);
        this.resourceIterator = this.resources.iterator();

        start();
    }

    public DesktopResource getCurrentFrame() {
        this.lastRequest = System.currentTimeMillis();
        return currentFrame;
    }

    private void start() {
        new Thread() {
            public void run() {
                while (true) {
                    if (System.currentTimeMillis() - lastRequest > 1000) {
                        if (!paused) resourceIterator = resources.iterator();
                        paused = true;
                    } else {
                        if (!resourceIterator.hasNext()) resourceIterator = resources.iterator();

                        currentFrame = resourceIterator.next();

                        try {
                            Thread.sleep(1000 / fps);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }

}
