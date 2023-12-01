package com.tencent.mapsdk.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/bg.class */
public class bg extends Drawable {
    private static final int b = -12028419;

    /* renamed from: a  reason: collision with root package name */
    private Paint f37328a;

    public bg() {
        Paint paint = new Paint();
        this.f37328a = paint;
        paint.setAntiAlias(true);
        if (mi.f37650c.equals(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE)) {
            this.f37328a.setColor(-16531104);
        } else {
            this.f37328a.setColor(b);
        }
    }

    public void a(int i) {
        this.f37328a.setColor(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawCircle(getBounds().width() / 2.0f, getBounds().height() / 2.0f, getBounds().width() / 2.0f, this.f37328a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f37328a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f37328a.setColorFilter(colorFilter);
    }
}
