package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.View;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ag.class */
public class ag extends View {
    public zf g;

    public ag(Context context) {
        super(context);
        zf zfVar = new zf();
        this.g = zfVar;
        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(zfVar);
        } else {
            setBackground(zfVar);
        }
        this.g.a(getResources().getDisplayMetrics().density * 1.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.g.setBounds(0, 0, i3 - i, i4 - i2);
    }

    public void setActivate(boolean z) {
        zf zfVar = this.g;
        if (zfVar == null) {
            return;
        }
        zfVar.a(z);
        postInvalidate();
    }

    public void setArrowStrokeWidth(float f) {
        zf zfVar = this.g;
        if (zfVar == null) {
            return;
        }
        zfVar.a(f);
        postInvalidate();
    }

    public void setDarkStyle(boolean z) {
        this.g.b(z);
        invalidate();
    }
}
