package me.gleeming.gengine.math;

import lombok.Getter;

public class Rectangle {
    @Getter private final int width;
    @Getter private final int height;

    @Getter private Point bottomLeftPoint;
    @Getter private Point bottomRightPoint;
    @Getter private Point topLeftPoint;
    @Getter private Point topRightPoint;
    public Rectangle(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;

        changePosition(x, y);
    }

    public void changePosition(int x, int y) {
        this.bottomLeftPoint = new Point(x, y);
        this.bottomRightPoint = new Point(x + width, y);
        this.topLeftPoint = new Point(x, y + height);
        this.topRightPoint = new Point(x + width, y + height);
    }

    public boolean colliding(Rectangle rectangle) {
        if(inside(rectangle.getBottomLeftPoint())) return true;
        else if(inside(rectangle.getBottomRightPoint())) return true;
        else if(inside(rectangle.getTopLeftPoint())) return true;
        else if(inside(rectangle.getTopRightPoint())) return true;
        else return false;
    }

    public boolean inside(Point point) {
        int otherX = point.getX();
        int otherY = point.getY();

        return otherX >= topLeftPoint.getX() && otherX <= bottomRightPoint.getX() && otherY >= bottomLeftPoint.getY() && otherY <= topRightPoint.getY();
    }
}
