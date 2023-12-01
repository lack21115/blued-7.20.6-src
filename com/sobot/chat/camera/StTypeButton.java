package com.sobot.chat.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/StTypeButton.class */
public class StTypeButton extends View {
    public static final int TYPE_CANCEL = 1;
    public static final int TYPE_CONFIRM = 2;
    private float button_radius;
    private int button_size;
    private int button_type;
    private float center_X;
    private float center_Y;
    private float index;
    private Paint mPaint;
    private Path path;
    private RectF rectF;
    private float strokeWidth;

    public StTypeButton(Context context) {
        super(context);
    }

    public StTypeButton(Context context, int i, int i2) {
        super(context);
        this.button_type = i;
        this.button_size = i2;
        float f = i2;
        float f2 = f / 2.0f;
        this.button_radius = f2;
        this.center_X = f2;
        this.center_Y = f2;
        this.mPaint = new Paint();
        this.path = new Path();
        this.strokeWidth = f / 50.0f;
        this.index = this.button_size / 12.0f;
        float f3 = this.center_X;
        float f4 = this.center_Y;
        float f5 = this.index;
        this.rectF = new RectF(f3, f4 - f5, (2.0f * f5) + f3, f4 + f5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.button_type == 1) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(-287515428);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(this.center_X, this.center_Y, this.button_radius, this.mPaint);
            this.mPaint.setColor(-16777216);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            Path path = this.path;
            float f = this.center_X;
            float f2 = this.index;
            path.moveTo(f - (f2 / 7.0f), this.center_Y + f2);
            Path path2 = this.path;
            float f3 = this.center_X;
            float f4 = this.index;
            path2.lineTo(f3 + f4, this.center_Y + f4);
            this.path.arcTo(this.rectF, 90.0f, -180.0f);
            Path path3 = this.path;
            float f5 = this.center_X;
            float f6 = this.index;
            path3.lineTo(f5 - f6, this.center_Y - f6);
            canvas.drawPath(this.path, this.mPaint);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.path.reset();
            Path path4 = this.path;
            float f7 = this.center_X;
            float f8 = this.index;
            path4.moveTo(f7 - f8, (float) (this.center_Y - (f8 * 1.5d)));
            Path path5 = this.path;
            float f9 = this.center_X;
            float f10 = this.index;
            path5.lineTo(f9 - f10, (float) (this.center_Y - (f10 / 2.3d)));
            Path path6 = this.path;
            double d = this.center_X;
            float f11 = this.index;
            path6.lineTo((float) (d - (f11 * 1.6d)), this.center_Y - f11);
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
        }
        if (this.button_type == 2) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(-1);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(this.center_X, this.center_Y, this.button_radius, this.mPaint);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(-16724992);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            this.path.moveTo(this.center_X - (this.button_size / 6.0f), this.center_Y);
            Path path7 = this.path;
            float f12 = this.center_X;
            int i = this.button_size;
            path7.lineTo(f12 - (i / 21.2f), this.center_Y + (i / 7.7f));
            Path path8 = this.path;
            float f13 = this.center_X;
            int i2 = this.button_size;
            path8.lineTo(f13 + (i2 / 4.0f), this.center_Y - (i2 / 8.5f));
            Path path9 = this.path;
            float f14 = this.center_X;
            int i3 = this.button_size;
            path9.lineTo(f14 - (i3 / 21.2f), this.center_Y + (i3 / 9.4f));
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.button_size;
        setMeasuredDimension(i3, i3);
    }
}
