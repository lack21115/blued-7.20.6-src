package com.amap.api.col.p0003sl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* renamed from: com.amap.api.col.3sl.aq  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/aq.class */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4746a;
    private final a b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4747c;
    private MotionEvent d;
    private MotionEvent e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private long q;
    private final float r;
    private float s;
    private float t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private int z = 0;
    private int A = 0;

    /* renamed from: com.amap.api.col.3sl.aq$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/aq$a.class */
    public interface a {
        boolean a(aq aqVar);

        boolean b(aq aqVar);

        void c(aq aqVar);
    }

    public aq(Context context, a aVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4746a = context;
        this.b = aVar;
        this.r = viewConfiguration.getScaledEdgeSlop();
    }

    private static float a(MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        if (i == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i) + (motionEvent.getRawX() - motionEvent.getX());
    }

    private int a(MotionEvent motionEvent, int i, int i2) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= pointerCount) {
                return -1;
            }
            if (i4 != i2 && i4 != findPointerIndex) {
                float f = this.r;
                float f2 = this.s;
                float f3 = this.t;
                float a2 = a(motionEvent, i4);
                float b = b(motionEvent, i4);
                if (a2 >= f && b >= f && a2 <= f2 && b <= f3) {
                    return i4;
                }
            }
            i3 = i4 + 1;
        }
    }

    private static float b(MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        if (i == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i) + (motionEvent.getRawY() - motionEvent.getY());
    }

    private void b(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.e = MotionEvent.obtain(motionEvent);
        this.l = -1.0f;
        this.m = -1.0f;
        this.n = -1.0f;
        MotionEvent motionEvent3 = this.d;
        int findPointerIndex = motionEvent3.findPointerIndex(this.w);
        int findPointerIndex2 = motionEvent3.findPointerIndex(this.x);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.w);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.x);
        if (findPointerIndex < 0 || findPointerIndex2 < 0 || findPointerIndex3 < 0 || findPointerIndex4 < 0) {
            this.v = true;
            if (this.f4747c) {
                this.b.c(this);
                return;
            }
            return;
        }
        float x = motionEvent3.getX(findPointerIndex);
        float y = motionEvent3.getY(findPointerIndex);
        float x2 = motionEvent3.getX(findPointerIndex2);
        float y2 = motionEvent3.getY(findPointerIndex2);
        float x3 = motionEvent.getX(findPointerIndex3);
        float y3 = motionEvent.getY(findPointerIndex3);
        float x4 = motionEvent.getX(findPointerIndex4);
        float y4 = motionEvent.getY(findPointerIndex4);
        float f = x4 - x3;
        float f2 = y4 - y3;
        this.h = x2 - x;
        this.i = y2 - y;
        this.j = f;
        this.k = f2;
        this.f = x3 + (f * 0.5f);
        this.g = y3 + (f2 * 0.5f);
        this.q = motionEvent.getEventTime() - motionEvent3.getEventTime();
        this.o = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
        this.p = motionEvent3.getPressure(findPointerIndex) + motionEvent3.getPressure(findPointerIndex2);
    }

    private void j() {
        MotionEvent motionEvent = this.d;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.d = null;
        }
        MotionEvent motionEvent2 = this.e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.e = null;
        }
        this.u = false;
        this.f4747c = false;
        this.w = -1;
        this.x = -1;
        this.v = false;
    }

    private float k() {
        if (this.l == -1.0f) {
            float f = this.j;
            float f2 = this.k;
            this.l = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.l;
    }

    private float l() {
        if (this.m == -1.0f) {
            float f = this.h;
            float f2 = this.i;
            this.m = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.m;
    }

    public final MotionEvent a() {
        return this.e;
    }

    public final void a(int i, int i2) {
        this.z = i;
        this.A = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x01e9, code lost:
        if (r0 == r0) goto L107;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 1887
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.aq.a(android.view.MotionEvent):boolean");
    }

    public final float b() {
        return this.f;
    }

    public final float c() {
        return this.g;
    }

    public final float d() {
        return this.j;
    }

    public final float e() {
        return this.k;
    }

    public final float f() {
        return this.h;
    }

    public final float g() {
        return this.i;
    }

    public final float h() {
        if (this.n == -1.0f) {
            this.n = k() / l();
        }
        return this.n;
    }

    public final long i() {
        return this.q;
    }
}
