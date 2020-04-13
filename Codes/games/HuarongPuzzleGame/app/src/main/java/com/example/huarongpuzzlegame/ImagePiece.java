package com.example.huarongpuzzlegame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class ImagePiece {
    private boolean valid;
    private int index;
    private Bitmap bitmap;

    void onDraw(Canvas canvas, int x, int y) {
        Paint paint = new Paint();
        paint.setStrokeWidth((float) 5);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.drawRect(x, y, x + bitmap.getWidth(), y + bitmap.getHeight(), paint);
    }

    int getIndex() {
        return index;
    }

    void setIndex(int index) {
        this.index = index;
    }

    Bitmap getBitmap() {
        return bitmap;
    }

    void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public boolean isValid() {
        return valid;
    }

    void setValid(boolean valid) {
        this.valid = valid;
    }
}
