package com.soft.blued.customview.rangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/rangebar/ConnectingLine.class */
class ConnectingLine {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f28620a;
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final float f28621c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectingLine(Context context, float f, float f2, int i) {
        this.b = TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
        Paint paint = new Paint();
        this.f28620a = paint;
        paint.setColor(i);
        this.f28620a.setStrokeWidth(this.b);
        this.f28620a.setAntiAlias(true);
        this.f28621c = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas, Thumb thumb, Thumb thumb2) {
        canvas.drawLine(thumb.b(), this.f28621c, thumb2.b(), this.f28621c, this.f28620a);
    }
}
