package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* renamed from: com.amap.api.col.3sl.am  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/am.class */
public abstract class am extends an {

    /* renamed from: a  reason: collision with root package name */
    protected float f4742a;
    protected float b;

    /* renamed from: c  reason: collision with root package name */
    protected float f4743c;
    protected float d;
    private final float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;

    public am(Context context) {
        super(context);
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = 0.0f;
        this.n = ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    private static float a(MotionEvent motionEvent, int i) {
        float f = i;
        float x = motionEvent.getX();
        float rawX = motionEvent.getRawX();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getX(1) + ((f + x) - rawX);
        }
        return 0.0f;
    }

    private static float b(MotionEvent motionEvent, int i) {
        float f = i;
        float y = motionEvent.getY();
        float rawY = motionEvent.getRawY();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getY(1) + ((f + y) - rawY);
        }
        return 0.0f;
    }

    public final PointF a(int i) {
        return i == 0 ? new PointF(this.s, this.t) : new PointF(this.u, this.v);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.an
    public void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.g;
        int pointerCount = this.g.getPointerCount();
        int pointerCount2 = motionEvent.getPointerCount();
        if (pointerCount2 == 2 && pointerCount2 == pointerCount) {
            this.q = -1.0f;
            this.r = -1.0f;
            float x = motionEvent2.getX(0);
            float y = motionEvent2.getY(0);
            float x2 = motionEvent2.getX(1);
            float y2 = motionEvent2.getY(1);
            this.f4742a = x2 - x;
            this.b = y2 - y;
            float x3 = motionEvent.getX(0);
            float y3 = motionEvent.getY(0);
            float x4 = motionEvent.getX(1);
            float y4 = motionEvent.getY(1);
            this.f4743c = x4 - x3;
            this.d = y4 - y3;
            this.s = x3 - x;
            this.t = y3 - y;
            this.u = x4 - x2;
            this.v = y4 - y2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(MotionEvent motionEvent, int i, int i2) {
        if (this.l == 0 || this.m == 0) {
            DisplayMetrics displayMetrics = this.e.getResources().getDisplayMetrics();
            this.o = displayMetrics.widthPixels - this.n;
            this.p = displayMetrics.heightPixels - this.n;
        } else {
            this.o = this.l - this.n;
            this.p = this.m - this.n;
        }
        float f = this.n;
        float f2 = this.o;
        float f3 = this.p;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float a2 = a(motionEvent, i);
        float b = b(motionEvent, i2);
        boolean z = rawX < f || rawY < f || rawX > f2 || rawY > f3;
        boolean z2 = a2 < f || b < f || a2 > f2 || b > f3;
        return (z && z2) || z || z2;
    }
}
