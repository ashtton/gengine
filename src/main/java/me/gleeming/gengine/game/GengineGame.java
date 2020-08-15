package me.gleeming.gengine.game;

import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.resource.Resource;

public abstract class GengineGame {
    public GengineGame(String windowName, Resource windowImage, int width, int height) {
        if(Gengine.getInstance() != null) {
            System.out.println("[Gengine] A game is already running under this application!");
            return;
        }

        new Gengine(windowName, windowImage, width, height);
    }

    public GengineGame(String windowName, int width, int height) { this(windowName, null, width, height); }
}
