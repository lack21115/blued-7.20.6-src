package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/h.class */
public class h extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private float f12924a;

    public h(Context context) {
        this(context, null);
    }

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12924a = 0.0f;
        setWillNotDraw(false);
    }

    public void a() {
        setLayerType(1, null);
    }

    public void a(float f) {
        this.f12924a = f;
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int save = canvas.save();
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        Path path = new Path();
        float f = this.f12924a;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.clipPath(path);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }
}
