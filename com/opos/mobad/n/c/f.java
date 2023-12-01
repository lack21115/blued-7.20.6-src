package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/f.class */
public class f extends i {

    /* renamed from: c  reason: collision with root package name */
    private float f12922c;

    public f(Context context, float f) {
        super(context);
        this.f12922c = f;
    }

    @Override // com.opos.mobad.n.c.i
    protected void a(Canvas canvas, int i, int i2) {
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f = this.f12922c;
        canvas.drawRoundRect(rectF, f, f, this.f12925a);
    }
}
