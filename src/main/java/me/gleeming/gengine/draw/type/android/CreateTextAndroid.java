package me.gleeming.gengine.draw.type.android;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import me.gleeming.gengine.color.GengineColor;
import me.gleeming.gengine.font.GengineFont;
import me.gleeming.gengine.loop.types.AndroidGameLoop;

public class CreateTextAndroid {
    public CreateTextAndroid(String string, int x, int y, GengineColor color, GengineFont font) {
        Canvas canvas = AndroidGameLoop.getDrawTo();
        Paint paint = new Paint();

        if(color != null) paint.setColor(Color.argb((int) color.getAlpha(), color.getRed(), color.getGreen(), color.getBlue()));
        if(font != null) paint.setTypeface(font.toAndroidFont());

        canvas.drawText(string, x, y, paint);
    }
}
