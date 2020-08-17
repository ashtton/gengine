package me.gleeming.gengine.input;

import lombok.Getter;
import me.gleeming.gengine.loop.GameLoop;
import me.gleeming.gengine.math.Point;

import java.util.HashMap;

public class GengineInput {
    @Getter private static GengineInput instance;

    @Getter private final HashMap<String, Boolean> pressedHashMap = new HashMap<>();
    public GengineInput() {
        instance = this;
    }

    public boolean isPressed(Key key) { return pressedHashMap.get(key.getActualStroke().toLowerCase()) == null ? false : pressedHashMap.get(key.getActualStroke().toLowerCase()); }

    public Point getMouseLocation() {
        return new Point((int) GameLoop.getInstance().getMousePosition().getX(), (int) GameLoop.getInstance().getMousePosition().getY());
    }

    public enum Key {
        NUM1("1"), NUM2("2"), NUM3("3"), NUM4("4"), NUM5("5"), NUM6("6"), NUM7("7"), NUM8("8"), NUM9("9"), NUM10("10"), NUM0("0"), TAB, CAPS_LOCK, LEFT_SHIFT, RIGHT_SHIFT,
        LEFT_CNTRL, LEFT_ALT, RIGHT_ALT, RIGHT_CONTROL, ENTER, BACK_SLASH, FORWARD_SLASH, LEFT_BRACKET, RIGHT_BRACKET,
        LEFT_CURLY_BRACKET, RIGHT_CURLY_BRACKET, DOWN_SLASH, EQUALS, PLUS, UNDERSCORE, HYPHEN, INSERT, HOME, PAGE_DOWN,
        DELETE, END, PAGE_UP, PAUSE_BREAK, SCREEN_LOCK, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, A, B, C, D, E,
        F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, LEFT_CLICK("left_click"), RIGHT_CLICK("right_click"), MIDDLE_CLICK("middle_click"),
        MOUSE_FOUR("mouse_four"), MOUSE_FIVE("mouse_five"), MOUSE_SIX("mouse_six"), SPACE;

        @Getter private final String actualStroke;
        Key(String actualStroke) {
            if(actualStroke == null) this.actualStroke = this.name();
            else this.actualStroke = actualStroke;
        }

        Key() { this(null); }
    }
}
