package com.opos.mobad.interstitial.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/a/l.class */
public class l extends com.opos.cmn.e.a.a.d {

    /* renamed from: c  reason: collision with root package name */
    private float f26242c;

    public l(Context context, float f) {
        super(context);
        this.f26242c = f;
    }

    @Override // com.opos.cmn.e.a.a.d
    public void a(Canvas canvas, int i, int i2) {
        float f = i;
        float f2 = i2;
        RectF rectF = new RectF(0.0f, 0.0f, f, f2 - this.f26242c);
        float f3 = this.f26242c;
        canvas.drawRoundRect(rectF, f3, f3, this.f24755a);
        canvas.drawRect(new RectF(0.0f, f2 - (this.f26242c * 2.0f), f, f2), this.f24755a);
    }
}
