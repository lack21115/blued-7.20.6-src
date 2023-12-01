package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.widget.TextView;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/pc.class */
public class pc extends TextView {
    private int g;
    private float h;
    private boolean i;

    public pc(Context context) {
        super(context);
        setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        getPaint().setFakeBoldText(true);
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.i) {
            return;
        }
        super.invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h <= 0.0f) {
            super.onDraw(canvas);
            return;
        }
        this.i = true;
        int currentTextColor = getCurrentTextColor();
        TextPaint paint = getPaint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.h);
        setTextColor(this.g);
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(0.0f);
        setTextColor(currentTextColor);
        super.onDraw(canvas);
        setTextColor(currentTextColor);
        this.i = false;
    }

    public void setStrokeColor(int i) {
        this.g = i;
    }

    public void setStrokeWidth(float f) {
        this.h = f;
    }
}
