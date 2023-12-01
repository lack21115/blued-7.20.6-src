package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/* renamed from: com.amap.api.col.3sl.ec  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ec.class */
public final class ec extends View {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4881a = Color.argb(255, 235, 235, 235);
    public static final int b = Color.argb(255, 21, 21, 21);

    /* renamed from: c  reason: collision with root package name */
    private Paint f4882c;

    public ec(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f4882c = paint;
        paint.setAntiAlias(true);
        this.f4882c.setColor(f4881a);
    }

    public final void a() {
        setVisibility(8);
    }

    public final void a(int i) {
        Paint paint = this.f4882c;
        if (paint != null) {
            paint.setColor(i);
            try {
                postInvalidate();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f4882c);
    }
}
