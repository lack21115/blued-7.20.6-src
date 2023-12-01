package com.blued.android.module.live_china.view.battlepass;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.live_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/battlepass/BattlePassLevelProgressItemView.class */
public final class BattlePassLevelProgressItemView extends View {
    private int a;
    private int b;
    private float c;
    private float d;
    private int e;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BattlePassLevelProgressItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
        this.b = 100;
        if (Build.VERSION.SDK_INT >= 23) {
            this.g = context.getColor(R.color.syc_dark_ffef5f);
            this.h = context.getColor(R.color.syc_dark_BFA674);
            this.i = context.getColor(R.color.syc_dark_7654D4);
            this.j = context.getColor(R.color.syc_dark_9C78FF);
        }
    }

    private final void a(Canvas canvas, Paint paint) {
        float f = this.d;
        float f2 = 2;
        float f3 = f / f2;
        float f4 = f / f2;
        float f5 = this.c - (f / f2);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setColor(this.j);
        paint.setStrokeWidth(this.d);
        canvas.drawLine(f3, f4, f5, f4, paint);
        paint.setColor(this.i);
        paint.setStrokeWidth(this.d - (this.f * f2));
        canvas.drawLine(f3, f4, f5, f4, paint);
    }

    private final void b(Canvas canvas, Paint paint) {
        int i;
        float f = this.d;
        if (f > 0.0f) {
            float f2 = this.c;
            if (f2 <= 0.0f || (i = this.a) <= 0) {
                return;
            }
            float f3 = i / this.b;
            float f4 = 2;
            float f5 = f / f4;
            int i2 = this.e;
            float f6 = f5 - i2;
            float f7 = f / f4;
            float f8 = f6 + (((f2 + i2) - f) * f3);
            if (f3 < 1.0f) {
                paint.setStrokeCap(Paint.Cap.ROUND);
            }
            paint.setColor(this.h);
            paint.setStrokeWidth(this.d);
            canvas.drawLine(f6, f7, f8, f7, paint);
            paint.setColor(this.g);
            paint.setStrokeWidth(this.d - (this.f * f4));
            canvas.drawLine(f6, f7, f8, f7, paint);
        }
    }

    private final Paint getPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        return paint;
    }

    public final int getForwardExtend() {
        return this.e;
    }

    public final int getProgress() {
        return this.a;
    }

    public final int getProgressMax() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.e(canvas, "canvas");
        super.onDraw(canvas);
        Paint paint = getPaint();
        a(canvas, paint);
        b(canvas, paint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.d = measuredHeight;
        this.f = (measuredHeight / 10) * 2;
    }

    public final void setForwardExtend(int i) {
        this.e = i;
    }

    public final void setProgress(int i) {
        int i2;
        if (i < 0) {
            i2 = 0;
        } else {
            int i3 = this.b;
            i2 = i;
            if (i > i3) {
                i2 = i3;
            }
        }
        if (i2 != this.a) {
            this.a = i2;
            invalidate();
        }
    }

    public final void setProgressMax(int i) {
        this.b = i;
        invalidate();
    }
}
