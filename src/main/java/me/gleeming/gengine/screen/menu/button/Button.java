package me.gleeming.gengine.screen.menu.button;

import lombok.Getter;
import lombok.Setter;
import me.gleeming.gengine.math.Rectangle;
import me.gleeming.gengine.resource.Resource;

import java.util.ArrayList;
import java.util.List;

public class Button {
    @Getter private final Resource resource;
    @Getter private final Resource hoveredResource;

    @Getter private final int x;
    @Getter private final int y;

    @Getter private final int width;
    @Getter private final int height;

    @Getter private final List<Listener> listeners = new ArrayList<>();
    @Getter @Setter private boolean hovering;
    public Button(Resource resource, Resource hoveredResource, int x, int y, int width, int height) {
        this.resource = resource;
        this.hoveredResource = hoveredResource;

        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
    }

    public Button(Resource resource, int x, int y, int width, int height) { this(resource, resource, x, y, width, height); }
    public Button addListener(Listener listener) { listeners.add(listener); return this; }
    public Rectangle getRectangle() { return new Rectangle(x, y, width, height); }

    public static abstract class Listener { public abstract void buttonClick();}
}
