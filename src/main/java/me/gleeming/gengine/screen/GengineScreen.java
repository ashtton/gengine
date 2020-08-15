package me.gleeming.gengine.screen;

import me.gleeming.gengine.draw.DrawQueue;

import java.util.List;

public abstract class GengineScreen {
    public abstract List<DrawQueue> draw(List<DrawQueue> queued);
}
