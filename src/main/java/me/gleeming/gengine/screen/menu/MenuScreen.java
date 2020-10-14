package me.gleeming.gengine.screen.menu;

import lombok.Getter;
import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.animation.Animation;
import me.gleeming.gengine.draw.DrawQueue;
import me.gleeming.gengine.draw.type.ResourceDrawQueue;
import me.gleeming.gengine.resource.type.DesktopResource;
import me.gleeming.gengine.screen.GengineScreen;
import me.gleeming.gengine.screen.menu.button.Button;
import me.gleeming.gengine.screen.menu.text.TextController;
import me.gleeming.gengine.screen.menu.text.entry.TextEntry;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuScreen extends GengineScreen {
    @Getter private final Animation backgroundAnimation;
    @Getter private final List<Button> buttons = new ArrayList<>();
    @Getter private final List<TextController> textControllers = new ArrayList<>();

    private final List<DrawQueue> drawQueues = new ArrayList<>();
    public MenuScreen(Animation backgroundAnimation) {
        this.backgroundAnimation = backgroundAnimation;
    }
    public MenuScreen(DesktopResource backgroundImage) { this(new Animation(1, backgroundImage)); }

    public void draw(DrawQueue queue) { this.drawQueues.add(queue); }

    public void addButton(Button button) { this.buttons.add(button); }
    public void addTextController(TextController controller) { this.textControllers.add(controller); addButton(controller.getSubmitButton()); }

    public List<DrawQueue> draw(List<DrawQueue> queued) {
        queued.add(new ResourceDrawQueue(backgroundAnimation.getCurrentFrame(), 0, 0, Gengine.getInstance().getGameProvider().getWidth(), Gengine.getInstance().getGameProvider().getHeight()));
        queued.addAll(drawQueues);
        for (Button button : buttons) queued.add(new ResourceDrawQueue((button.isHovering() ? button.getHoveredResource() : button.getResource()), button.getX(), button.getY(), button.getWidth(), button.getHeight()));

        return queued;
    }
}
