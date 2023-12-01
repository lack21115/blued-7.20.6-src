package com.scwang.smartrefresh.layout.internal;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/internal/PaintDrawable.class */
public abstract class PaintDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    protected Paint f14307a;

    /* JADX INFO: Access modifiers changed from: protected */
    public PaintDrawable() {
        Paint paint = new Paint();
        this.f14307a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f14307a.setAntiAlias(true);
        this.f14307a.setColor(-5592406);
    }

    public void a(int i) {
        this.f14307a.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f14307a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f14307a.setColorFilter(colorFilter);
    }
}
