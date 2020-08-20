package me.gleeming.gengine.game;

import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.game.provider.GameProvider;

public abstract class Gengine2DGame {
    public Gengine2DGame(GameProvider provider) {
        if(Gengine.getInstance() != null) {
            System.out.println("[Gengine] A game is already running under this application!");
            return;
        }

        new Gengine(provider);
    }
}
