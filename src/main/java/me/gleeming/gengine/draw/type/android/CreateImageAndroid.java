package me.gleeming.gengine.draw.type.android;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import me.gleeming.gengine.color.GengineColor;
import me.gleeming.gengine.loop.types.AndroidGameLoop;
import me.gleeming.gengine.resource.Resource;

public class CreateImageAndroid {
    public CreateImageAndroid(int x, int y, Resource resource, GengineColor color) {
        Canvas canvas = AndroidGameLoop.getDrawTo();
        Paint paint = new Paint();

        if(color == null) paint.setColor(Color.argb((int) color.getAlpha(), color.getRed(), color.getGreen(), color.getBlue()));
        //todo
//        canvas.drawBitmap(resource.toBitmap(), x, y, null);
    }
}
