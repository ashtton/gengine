package me.gleeming.gengine.resource;

import lombok.Getter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.game.provider.type.DesktopProvider;
import me.gleeming.gengine.resource.type.DesktopResource;

public class Resource {
    @Getter private final String path;

    @Getter private DesktopResource desktopResource;
    public Resource(String path, boolean abs) {
        this.path = path;

        if(!abs) if(Gengine.getInstance().getGameProvider() instanceof DesktopProvider) desktopResource = new DesktopResource(path);
    }

    public Resource(String path) { this(path, false); }

    public Resource flipVertically() { return this; }
    public Resource flipHorizontally() { return this; }

    public Resource rotate(int degrees) { return this; }
    public Resource rotateCounterclockwise(int degrees) { return rotate(degrees); }
    public Resource rotateCounterClockwise(int degrees) { return rotate(-degrees); }
}
