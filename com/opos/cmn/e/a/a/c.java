package com.opos.cmn.e.a.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/a/c.class */
public class c extends d {

    /* renamed from: c  reason: collision with root package name */
    private float f11066c;

    public c(Context context, float f) {
        super(context);
        this.f11066c = f;
    }

    @Override // com.opos.cmn.e.a.a.d
    protected void a(Canvas canvas, int i, int i2) {
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f = this.f11066c;
        canvas.drawRoundRect(rectF, f, f, this.f11067a);
    }
}
