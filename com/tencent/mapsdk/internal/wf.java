package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/wf.class */
public class wf implements View.OnTouchListener {
    private static final double A = 0.1d;
    private static final double B = 0.5d;
    private static final int C = 0;
    private static final int D = 1;
    private static final int E = 2;
    private static final int F = 4;
    private static final int G = 8;
    private static final float H = (float) Math.cos(0.0017453292780017621d);
    private static final int I = 10;
    private static final int J = 120;
    private static final int K = 50;
    private static final int t = 255;
    private static final int u = 5;
    private static final int v = 6;
    private static final double w = 2.5d;
    private static final double x = 0.5d;
    private static final double y = 0.003d;
    private static final double z = 0.001d;

    /* renamed from: a  reason: collision with root package name */
    private boolean f24400a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private long f24401c;
    private int d = 0;
    private final PointF e = new PointF();
    private final PointF f = new PointF();
    private final PointF g = new PointF();
    private final PointF h = new PointF();
    private final PointF i = new PointF();
    private final PointF j = new PointF();
    private final PointF k = new PointF();
    private long l = 0;
    private final GestureDetector m;
    private final xf n;
    private final e1 o;
    private final WeakReference<gj> p;
    private final b q;
    private Method r;
    private Method s;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/wf$b.class */
    public class b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        private PointF f24402a;
        private boolean b;

        private b() {
            this.f24402a = new PointF();
            this.b = true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.b = true;
                wf.this.m.setIsLongpressEnabled(false);
                this.f24402a.set(motionEvent.getX(), motionEvent.getY());
                wf.this.n.c(x, y);
                return true;
            } else if (action == 1) {
                if (this.b) {
                    wf.this.n.onDoubleTap(x, y);
                }
                this.f24402a.set(0.0f, 0.0f);
                wf.this.m.setIsLongpressEnabled(true);
                wf.this.n.a(x, y);
                return true;
            } else if (action != 2) {
                return true;
            } else {
                PointF pointF = this.f24402a;
                float f = pointF.x;
                float f2 = pointF.y;
                if (Math.abs(x - f) > 10.0f || Math.abs(y - f2) > 10.0f) {
                    this.b = false;
                    wf.this.n.d(x, y);
                }
                wf.this.m.setIsLongpressEnabled(true);
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            wf.this.n.onFling(f, f2);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (wf.this.f24400a) {
                return;
            }
            wf.this.n.onLongPress(motionEvent.getX(), motionEvent.getY());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (wf.this.p != null && wf.this.p.get() != null && ((gj) wf.this.p.get()).Y()) {
                double sqrt = Math.sqrt((f * f) + (f2 * f2));
                if (motionEvent != null && (motionEvent.getX() < 0.0f || motionEvent.getY() < 0.0f)) {
                    return true;
                }
                if ((motionEvent2 != null && (motionEvent2.getX() < 0.0f || motionEvent2.getY() < 0.0f)) || sqrt > 50.0d) {
                    return true;
                }
            }
            wf.this.n.onScroll(-f, -f2);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            wf.this.n.onSingleTap(motionEvent.getX(), motionEvent.getY());
            return true;
        }
    }

    public wf(gj gjVar) {
        b bVar = new b();
        this.q = bVar;
        this.p = new WeakReference<>(gjVar);
        GestureDetector gestureDetector = new GestureDetector(gjVar.getContext(), bVar);
        this.m = gestureDetector;
        this.n = new xf();
        this.o = gjVar.getMapContext();
        gestureDetector.setOnDoubleTapListener(bVar);
    }

    private void a(PointF pointF, PointF pointF2, MotionEvent motionEvent) {
        try {
            float x2 = motionEvent.getX(0);
            float x3 = motionEvent.getX(1);
            float y2 = motionEvent.getY(0);
            float y3 = motionEvent.getY(1);
            pointF.set(x2, y2);
            pointF2.set(x3, y3);
        } catch (Exception e) {
        }
    }

    private boolean a() {
        PointF a2 = xa.a(this.h, this.g, this.f, this.e);
        if (a2 == null) {
            return false;
        }
        return a(a2.x, a2.y);
    }

    private boolean a(float f, float f2) {
        e1 e1Var;
        e1 e1Var2;
        e1 e1Var3 = this.o;
        int width = e1Var3 == null ? 0 : e1Var3.e().width() / 2;
        e1 e1Var4 = this.o;
        int height = e1Var4 == null ? 0 : e1Var4.e().height() / 2;
        float f3 = 0.0f;
        float width2 = this.o == null ? 0.0f : e1Var.e().width() / 3.0f;
        if (this.o != null) {
            f3 = e1Var2.e().height() / 3.0f;
        }
        boolean z2 = false;
        if (Math.abs(f - width) < width2) {
            z2 = false;
            if (Math.abs(f2 - height) < f3) {
                z2 = true;
            }
        }
        return z2;
    }

    private boolean b() {
        PointF pointF = this.g;
        float f = pointF.x;
        PointF pointF2 = this.h;
        double d = f - pointF2.x;
        double d2 = pointF.y - pointF2.y;
        return (d * d) + (d2 * d2) > 2500.0d;
    }

    private boolean b(float f, float f2) {
        return a(f, f2);
    }

    private void c() {
        double d;
        e1 e1Var;
        PointF pointF = this.e;
        float f = pointF.x;
        PointF pointF2 = this.g;
        float f2 = f - pointF2.x;
        float f3 = pointF.y - pointF2.y;
        PointF pointF3 = this.f;
        float f4 = pointF3.x;
        PointF pointF4 = this.h;
        float f5 = f4 - pointF4.x;
        float f6 = pointF3.y - pointF4.y;
        boolean z2 = ((double) Math.abs(f3)) > ((double) Math.abs(f2)) * 1.5d && ((double) Math.abs(f6)) > ((double) Math.abs(f5)) * 1.5d;
        boolean z3 = ((double) Math.abs(f3)) > ((double) Math.abs(f2)) * 1.5d && ((double) Math.abs(f6)) > ((double) Math.abs(f5)) * 1.5d;
        boolean z4 = ((double) Math.abs(f2)) > ((double) Math.abs(f3)) * 1.5d && ((double) Math.abs(f5)) > ((double) Math.abs(f6)) * 1.5d;
        boolean z5 = ((double) Math.abs(f2)) > ((double) Math.abs(f3)) * 1.5d && ((double) Math.abs(f5)) > ((double) Math.abs(f6)) * 1.5d;
        int i = ((f2 * f5) > 0.0f ? 1 : ((f2 * f5) == 0.0f ? 0 : -1));
        boolean z6 = i > 0;
        int i2 = ((f3 * f6) > 0.0f ? 1 : ((f3 * f6) == 0.0f ? 0 : -1));
        boolean z7 = i2 > 0;
        int i3 = this.d;
        boolean z8 = ((i3 & 8) == 0 && (i3 & 1) == 0 && (i3 & 4) == 0) ? false : true;
        double d2 = 0.5d;
        double d3 = z8 ? 0.1d : 0.5d;
        double max = Math.max(i > 0 ? Math.abs(f2 + f5) : Math.max(Math.abs(f2), Math.abs(f5)), i2 > 0 ? Math.abs(f3 + f6) : Math.max(Math.abs(f3), Math.abs(f6)));
        boolean z9 = max > d3;
        boolean z10 = z9 && z6 && (z4 || z5) && this.p.get().O();
        boolean z11 = z9 && z7 && (z2 || z3) && this.p.get().f();
        PointF pointF5 = this.h;
        float f7 = pointF5.x;
        PointF pointF6 = this.g;
        double d4 = f7 - pointF6.x;
        double d5 = pointF5.y - pointF6.y;
        PointF pointF7 = this.f;
        float f8 = pointF7.x;
        PointF pointF8 = this.e;
        double d6 = f8 - pointF8.x;
        double d7 = pointF7.y - pointF8.y;
        double sqrt = Math.sqrt((d4 * d4) + (d5 * d5));
        double sqrt2 = Math.sqrt((d6 * d6) + (d7 * d7));
        double d8 = sqrt * sqrt2;
        double d9 = ((d4 * d6) + (d5 * d7)) / d8;
        double acos = (Math.acos(d9) * 180.0d) / 3.141592653589793d;
        double d10 = acos;
        if ((d4 * d7) - (d5 * d6) < 0.0d) {
            d10 = -acos;
        }
        boolean z12 = Math.abs(d9) < ((double) H);
        if ((this.d & 2) == 0) {
            d2 = 2.5d;
        }
        double abs = Math.abs(d10);
        boolean z13 = d8 > 0.0d && z12 && Math.abs(d10) > d2 && this.p.get().M();
        double d11 = sqrt2 / sqrt;
        double d12 = z8 ? 0.001d : 0.003d;
        double abs2 = Math.abs(d11 - 1.0d);
        boolean z14 = sqrt > 0.0d && abs2 > d12 && this.p.get().G();
        ra.g(ma.t).a("trace-gesture", "began:" + z9 + ":" + z14 + ":" + z13, "value:" + max + ":" + abs2 + ":" + abs);
        if (z13) {
            z9 = false;
        }
        if (z11) {
            z10 = false;
            z13 = false;
            z14 = false;
        }
        ra.g(ma.t).a("beganMove:" + z9, "vertical:" + z7, "horizontal:" + z6, "verticalMove:" + z11, "horizontalMove:" + z10);
        ra.g(ma.t).a("beganRotate:" + z13, "cosValue : " + d9, "cosAngle : " + z12, "angle:" + d10, "rotateJudge : " + d2);
        ra.g(ma.t).a("beganScale:" + z14, "d1:" + sqrt, "scale - 1 = " + Math.abs(d), "scaleJudge : " + d12);
        if (z9) {
            if (z10) {
                this.d |= 8;
                ra.g(ma.t).a("MT_INTENT_MOVE");
                this.n.onScroll((f2 + f5) / 2.0f, (f3 + f6) / 2.0f);
            }
            if (z11) {
                this.d |= 1;
                ra.g(ma.t).a("MT_INTENT_MOVE_VERTICAL");
                PointF pointF9 = this.g;
                PointF pointF10 = this.e;
                pointF9.set(pointF10.x, pointF10.y);
                PointF pointF11 = this.h;
                PointF pointF12 = this.f;
                pointF11.set(pointF12.x, pointF12.y);
                this.n.b(Math.abs(f3) > Math.abs(f6) ? f3 : f6);
            }
        }
        if (z13) {
            this.d |= 2;
            ra.g(ma.t).a("MT_INTENT_ROTATE");
            if (z6 && !this.p.get().O()) {
                PointF pointF13 = this.g;
                PointF pointF14 = this.e;
                pointF13.set(pointF14.x, pointF14.y);
                PointF pointF15 = this.h;
                PointF pointF16 = this.f;
                pointF15.set(pointF16.x, pointF16.y);
                ra.g(ma.t).a("NO_HORIZONAL_ROTATE");
                return;
            } else if (a()) {
                e1 e1Var2 = this.o;
                this.k.set(e1Var2 == null ? 0 : e1Var2.e().width() / 2, this.o == null ? 0 : e1Var.e().height() / 2);
                xf xfVar = this.n;
                PointF pointF17 = this.k;
                xfVar.a(pointF17, pointF17, (float) d10);
            } else {
                PointF pointF18 = this.i;
                PointF pointF19 = this.g;
                float f9 = pointF19.x;
                PointF pointF20 = this.h;
                pointF18.set((f9 + pointF20.x) / 2.0f, (pointF19.y + pointF20.y) / 2.0f);
                PointF pointF21 = this.j;
                PointF pointF22 = this.e;
                float f10 = pointF22.x;
                PointF pointF23 = this.f;
                pointF21.set((f10 + pointF23.x) / 2.0f, (pointF22.y + pointF23.y) / 2.0f);
                this.n.a(this.i, this.j, (float) d10);
            }
        }
        if (z14) {
            this.d |= 4;
            ra.g(ma.t).a("MT_INTENT_SCALE");
            if (z6 && !this.p.get().O()) {
                PointF pointF24 = this.g;
                PointF pointF25 = this.e;
                pointF24.set(pointF25.x, pointF25.y);
                PointF pointF26 = this.h;
                PointF pointF27 = this.f;
                pointF26.set(pointF27.x, pointF27.y);
                ra.g(ma.t).a("NO_HORIZONAL_SCALE");
                return;
            }
            PointF pointF28 = this.i;
            PointF pointF29 = this.g;
            float f11 = pointF29.x;
            PointF pointF30 = this.h;
            pointF28.set((f11 + pointF30.x) / 2.0f, (pointF29.y + pointF30.y) / 2.0f);
            PointF pointF31 = this.j;
            PointF pointF32 = this.e;
            float f12 = pointF32.x;
            PointF pointF33 = this.f;
            pointF31.set((f12 + pointF33.x) / 2.0f, (pointF32.y + pointF33.y) / 2.0f);
            this.n.a(this.i, this.j, sqrt, sqrt2);
        }
        PointF pointF34 = this.g;
        PointF pointF35 = this.e;
        pointF34.set(pointF35.x, pointF35.y);
        PointF pointF36 = this.h;
        PointF pointF37 = this.f;
        pointF36.set(pointF37.x, pointF37.y);
    }

    public void a(w4 w4Var) {
        synchronized (this.n) {
            this.n.a(w4Var);
        }
    }

    public void b(w4 w4Var) {
        synchronized (this.n) {
            this.n.b(w4Var);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 5) {
                            this.l = System.currentTimeMillis();
                            this.d = 0;
                            this.f24400a = true;
                            this.f24401c = System.currentTimeMillis();
                            this.b = false;
                            a(this.g, this.h, motionEvent);
                            this.n.b();
                            return true;
                        } else if (action == 6 && !this.b) {
                            this.b = true;
                            this.n.d();
                            return true;
                        }
                    }
                } else if (this.f24400a && !this.b) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f24401c < 8) {
                        return true;
                    }
                    this.f24401c = currentTimeMillis;
                    a(this.e, this.f, motionEvent);
                    c();
                    return true;
                } else {
                    this.n.b(motionEvent.getX(), motionEvent.getY());
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - this.l;
            if (this.d == 0 && currentTimeMillis2 > 0 && currentTimeMillis2 < 200 && b()) {
                this.n.a();
            }
            this.n.onUp(motionEvent.getX(), motionEvent.getY());
        } else {
            this.l = 0L;
            this.f24400a = false;
            this.n.onDown(motionEvent.getX(), motionEvent.getY());
        }
        if (this.f24400a) {
            return true;
        }
        this.m.onTouchEvent(motionEvent);
        return true;
    }
}
