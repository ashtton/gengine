package me.gleeming.gengine.resource;

import lombok.Getter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.resource.type.DesktopResource;

public class Resource {
    @Getter private final String path;

    @Getter private DesktopResource desktopResource;
    public Resource(String path) {
        this.path = path;

        if(Gengine.getInstance().getGameProvider() instanceof DesktopResource) desktopResource = new DesktopResource(path);
    }

    public Resource flipVertically() { return this; }
    public Resource flipHorizontally() { return this; }

    public Resource rotate(int degrees) { return this; }
    public Resource rotateCounterclockwise(int degrees) { return rotate(degrees); }
    public Resource rotateCounterClockwise(int degrees) { return rotate(-degrees); }
}
