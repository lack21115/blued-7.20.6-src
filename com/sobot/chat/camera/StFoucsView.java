package com.sobot.chat.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.sobot.chat.camera.util.ScreenUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/StFoucsView.class */
public class StFoucsView extends View {
    private int center_x;
    private int center_y;
    private int length;
    private Paint mPaint;
    private int size;

    public StFoucsView(Context context) {
        this(context, null);
    }

    public StFoucsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StFoucsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.size = ScreenUtils.getScreenWidth(context) / 3;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setColor(-300503530);
        this.mPaint.setStrokeWidth(4.0f);
        this.mPaint.setStyle(Paint.Style.STROKE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        super.onDraw(canvas);
        float f = this.center_x - this.length;
        int i3 = this.center_y;
        canvas.drawRect(f, i3 - i2, i + i2, i3 + i2, this.mPaint);
        canvas.drawLine(2.0f, getHeight() / 2, this.size / 10, getHeight() / 2, this.mPaint);
        canvas.drawLine(getWidth() - 2, getHeight() / 2, getWidth() - (this.size / 10), getHeight() / 2, this.mPaint);
        canvas.drawLine(getWidth() / 2, 2.0f, getWidth() / 2, this.size / 10, this.mPaint);
        canvas.drawLine(getWidth() / 2, getHeight() - 2, getWidth() / 2, getHeight() - (this.size / 10), this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.size;
        this.center_x = (int) (i3 / 2.0d);
        this.center_y = (int) (i3 / 2.0d);
        this.length = ((int) (i3 / 2.0d)) - 2;
        setMeasuredDimension(i3, i3);
    }
}
