package me.gleeming.gengine.game;

import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.resource.type.DesktopResource;

public abstract class Gengine3DGame {
    public Gengine3DGame(String windowName, DesktopResource windowImage, int width, int height) {
        if(Gengine.getInstance() != null) {
            System.out.println("[Gengine] A game is already running under this application!");
            return;
        }

        System.out.println("[Gengine] Gengine 3D support will be coming in 2024");
        System.exit(2024);
    }

    public Gengine3DGame(String windowName, int width, int height) { this(windowName, null, width, height); }
}
