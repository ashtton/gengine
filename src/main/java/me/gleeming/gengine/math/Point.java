package me.gleeming.gengine.math;

import lombok.Getter;
import lombok.Setter;

public class Point {
    @Getter @Setter private int x;
    @Getter @Setter private int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
