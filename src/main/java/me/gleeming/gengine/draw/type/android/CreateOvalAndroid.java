package me.gleeming.gengine.draw.type.android;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import me.gleeming.gengine.color.GengineColor;
import me.gleeming.gengine.loop.types.AndroidGameLoop;

public class CreateOvalAndroid {
    public CreateOvalAndroid(int x, int y, int width, int height, GengineColor color, boolean filled) {
        Canvas drawTo = AndroidGameLoop.getDrawTo();
        Paint paint = new Paint();

        if(color != null) paint.setColor(Color.argb((int) color.getAlpha(), color.getRed(), color.getGreen(), color.getBlue()));

        drawTo.drawOval(new RectF(x, y, width, height), paint);
    }
}
