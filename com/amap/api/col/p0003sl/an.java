package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.view.MotionEvent;

/* renamed from: com.amap.api.col.3sl.an  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/an.class */
public abstract class an {
    protected final Context e;
    protected boolean f;
    protected MotionEvent g;
    protected MotionEvent h;
    protected float i;
    protected float j;
    protected long k;
    protected int l = 0;
    protected int m = 0;

    public an(Context context) {
        this.e = context;
    }

    public static PointF b(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pointerCount) {
                float f3 = pointerCount;
                return new PointF(f / f3, f2 / f3);
            }
            f += motionEvent.getX(i2);
            f2 += motionEvent.getY(i2);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        MotionEvent motionEvent = this.g;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.g = null;
        }
        MotionEvent motionEvent2 = this.h;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.h = null;
        }
        this.f = false;
    }

    public final void a(int i, int i2) {
        this.l = i;
        this.m = i2;
    }

    protected abstract void a(int i, MotionEvent motionEvent);

    protected abstract void a(int i, MotionEvent motionEvent, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.g;
        MotionEvent motionEvent3 = this.h;
        if (motionEvent3 != null) {
            motionEvent3.recycle();
            this.h = null;
        }
        this.h = MotionEvent.obtain(motionEvent);
        this.k = motionEvent.getEventTime() - motionEvent2.getEventTime();
        if (Build.VERSION.SDK_INT >= 8) {
            this.i = motionEvent.getPressure(motionEvent.getActionIndex());
            this.j = motionEvent2.getPressure(motionEvent2.getActionIndex());
            return;
        }
        this.i = motionEvent.getPressure(0);
        this.j = motionEvent2.getPressure(0);
    }

    public final long b() {
        return this.k;
    }

    public final boolean b(MotionEvent motionEvent, int i, int i2) {
        int action = motionEvent.getAction() & 255;
        if (this.f) {
            a(action, motionEvent);
            return true;
        }
        a(action, motionEvent, i, i2);
        return true;
    }

    public final MotionEvent c() {
        return this.h;
    }
}
