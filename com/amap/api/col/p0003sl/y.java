package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.col.p0003sl.ao;
import com.amap.api.col.p0003sl.ap;
import com.amap.api.col.p0003sl.ar;
import com.amap.api.col.p0003sl.as;
import com.amap.api.maps.model.AMapGestureListener;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;

/* renamed from: com.amap.api.col.3sl.y  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/y.class */
public final class y {
    IAMapDelegate a;
    Context b;
    GestureDetector c;
    public AMapGestureListener d;
    private ar e;
    private ap f;
    private ao g;
    private as h;
    private int r;
    private int s;
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private boolean o = false;
    private boolean p = false;
    private boolean q = true;
    private Handler t = new Handler(Looper.getMainLooper());

    /* renamed from: com.amap.api.col.3sl.y$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/y$a.class */
    final class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
        float a;
        long b;
        private int d;
        private EAMapPlatformGestureInfo e;

        private a() {
            this.d = 0;
            this.a = 0.0f;
            this.e = new EAMapPlatformGestureInfo();
            this.b = 0L;
        }

        /* synthetic */ a(y yVar, byte b) {
            this();
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            y.this.c.setIsLongpressEnabled(false);
            this.d = motionEvent.getPointerCount();
            if (y.this.d != null) {
                y.this.d.onDoubleTap(motionEvent.getX(), motionEvent.getY());
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (this.d < motionEvent.getPointerCount()) {
                this.d = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            boolean z = true;
            if (this.d == 1) {
                try {
                    if (!y.this.a.getUiSettings().isZoomGesturesEnabled()) {
                        return false;
                    }
                } catch (Throwable th) {
                    iw.c(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                    th.printStackTrace();
                }
                if (action == 0) {
                    this.e.mGestureState = 1;
                    this.e.mGestureType = 9;
                    this.e.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                    int engineIDWithGestureInfo = y.this.a.getEngineIDWithGestureInfo(this.e);
                    this.a = motionEvent.getY();
                    y.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                    this.b = SystemClock.uptimeMillis();
                    return true;
                } else if (action != 2) {
                    this.e.mGestureState = 3;
                    this.e.mGestureType = 9;
                    this.e.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                    int engineIDWithGestureInfo2 = y.this.a.getEngineIDWithGestureInfo(this.e);
                    y.this.c.setIsLongpressEnabled(true);
                    y.this.a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
                    if (action != 1) {
                        y.this.o = false;
                        return true;
                    }
                    y.this.a.setGestureStatus(engineIDWithGestureInfo2, 3);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    long j = this.b;
                    if (!y.this.o || uptimeMillis - j < 200) {
                        return y.this.a.onDoubleTap(engineIDWithGestureInfo2, motionEvent);
                    }
                    y.this.o = false;
                    return true;
                } else {
                    y.this.o = true;
                    float y = this.a - motionEvent.getY();
                    if (Math.abs(y) >= 20.0f) {
                        this.e.mGestureState = 2;
                        this.e.mGestureType = 9;
                        this.e.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                        y.this.a.addGestureMapMessage(y.this.a.getEngineIDWithGestureInfo(this.e), ScaleGestureMapMessage.obtain(101, (y * 4.0f) / y.this.a.getMapHeight(), 0, 0));
                        this.a = motionEvent.getY();
                        return true;
                    }
                }
            } else {
                z = false;
            }
            return z;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            y.this.o = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (y.this.d != null) {
                y.this.d.onFling(f, f2);
            }
            try {
                if (y.this.a.getUiSettings().isScrollGesturesEnabled() && y.this.m <= 0 && y.this.k <= 0 && y.this.l == 0 && !y.this.q) {
                    this.e.mGestureState = 3;
                    this.e.mGestureType = 3;
                    this.e.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int engineIDWithGestureInfo = y.this.a.getEngineIDWithGestureInfo(this.e);
                    y.this.a.onFling();
                    y.this.a.getGLMapEngine().startMapSlidAnim(engineIDWithGestureInfo, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f, f2);
                    return true;
                }
                return true;
            } catch (Throwable th) {
                iw.c(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
                return true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            if (y.this.n == 1) {
                this.e.mGestureState = 3;
                this.e.mGestureType = 7;
                this.e.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                y.this.a.onLongPress(y.this.a.getEngineIDWithGestureInfo(this.e), motionEvent);
                if (y.this.d != null) {
                    y.this.d.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (y.this.d != null) {
                y.this.d.onScroll(f, f2);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onShowPress(MotionEvent motionEvent) {
            try {
                this.e.mGestureState = 3;
                this.e.mGestureType = 7;
                this.e.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                y.this.a.getGLMapEngine().clearAnimations(y.this.a.getEngineIDWithGestureInfo(this.e), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (y.this.n == 1) {
                this.e.mGestureState = 3;
                this.e.mGestureType = 8;
                this.e.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo = y.this.a.getEngineIDWithGestureInfo(this.e);
                if (y.this.d != null) {
                    try {
                        y.this.d.onSingleTap(motionEvent.getX(), motionEvent.getY());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return y.this.a.onSingleTapConfirmed(engineIDWithGestureInfo, motionEvent);
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* renamed from: com.amap.api.col.3sl.y$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/y$b.class */
    final class b implements ao.a {
        private EAMapPlatformGestureInfo b;

        private b() {
            this.b = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ b(y yVar, byte b) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x00da, code lost:
            if (r0.y < (-10.0f)) goto L19;
         */
        @Override // com.amap.api.col.p0003sl.ao.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean a(com.amap.api.col.p0003sl.ao r7) {
            /*
                Method dump skipped, instructions count: 336
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.y.b.a(com.amap.api.col.3sl.ao):boolean");
        }

        @Override // com.amap.api.col.p0003sl.ao.a
        public final boolean b(ao aoVar) {
            this.b.mGestureState = 1;
            this.b.mGestureType = 6;
            this.b.mLocation = new float[]{aoVar.c().getX(), aoVar.c().getY()};
            try {
                if (y.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = y.this.a.getEngineIDWithGestureInfo(this.b);
                    if (y.this.a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return false;
                    }
                    y.this.a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(100, y.this.a.getCameraDegree(engineIDWithGestureInfo)));
                    return true;
                }
                return true;
            } catch (Throwable th) {
                iw.c(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.p0003sl.ao.a
        public final void c(ao aoVar) {
            this.b.mGestureState = 3;
            this.b.mGestureType = 6;
            this.b.mLocation = new float[]{aoVar.c().getX(), aoVar.c().getY()};
            try {
                if (y.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = y.this.a.getEngineIDWithGestureInfo(this.b);
                    if (y.this.a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return;
                    }
                    if (y.this.a.getCameraDegree(engineIDWithGestureInfo) >= 0.0f && y.this.m > 0) {
                        y.this.a.setGestureStatus(engineIDWithGestureInfo, 7);
                    }
                    y.this.i = false;
                    y.this.a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(102, y.this.a.getCameraDegree(engineIDWithGestureInfo)));
                }
            } catch (Throwable th) {
                iw.c(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.col.3sl.y$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/y$c.class */
    final class c implements ap.a {
        private EAMapPlatformGestureInfo b;

        private c() {
            this.b = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ c(y yVar, byte b) {
            this();
        }

        @Override // com.amap.api.col.p0003sl.ap.a
        public final boolean a(ap apVar) {
            if (y.this.i) {
                return true;
            }
            try {
                if (y.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    if (y.this.p) {
                        return true;
                    }
                    this.b.mGestureState = 2;
                    this.b.mGestureType = 3;
                    this.b.mLocation = new float[]{apVar.c().getX(), apVar.c().getY()};
                    int engineIDWithGestureInfo = y.this.a.getEngineIDWithGestureInfo(this.b);
                    PointF d = apVar.d();
                    float f = 1.0f;
                    if (y.this.j == 0) {
                        f = 4.0f;
                    }
                    if (Math.abs(d.x) > f || Math.abs(d.y) > f) {
                        if (y.this.j == 0) {
                            y.this.a.getGLMapEngine().clearAnimations(engineIDWithGestureInfo, false);
                        }
                        y.this.a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(101, d.x, d.y, apVar.c().getX(), apVar.c().getY()));
                        y.l(y.this);
                        return true;
                    }
                    return false;
                }
                return true;
            } catch (Throwable th) {
                iw.c(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.p0003sl.ap.a
        public final boolean b(ap apVar) {
            try {
                if (y.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    this.b.mGestureState = 1;
                    this.b.mGestureType = 3;
                    this.b.mLocation = new float[]{apVar.c().getX(), apVar.c().getY()};
                    y.this.a.addGestureMapMessage(y.this.a.getEngineIDWithGestureInfo(this.b), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f, apVar.c().getX(), apVar.c().getY()));
                    return true;
                }
                return true;
            } catch (Throwable th) {
                iw.c(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.p0003sl.ap.a
        public final void c(ap apVar) {
            try {
                if (y.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    this.b.mGestureState = 3;
                    this.b.mGestureType = 3;
                    this.b.mLocation = new float[]{apVar.c().getX(), apVar.c().getY()};
                    int engineIDWithGestureInfo = y.this.a.getEngineIDWithGestureInfo(this.b);
                    if (y.this.j > 0) {
                        y.this.a.setGestureStatus(engineIDWithGestureInfo, 5);
                    }
                    y.this.a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f, apVar.c().getX(), apVar.c().getY()));
                }
            } catch (Throwable th) {
                iw.c(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.col.3sl.y$d */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/y$d.class */
    final class d extends ar.a {
        private boolean b;
        private boolean c;
        private boolean d;
        private Point e;
        private float[] f;
        private float g;
        private float[] h;
        private float i;
        private EAMapPlatformGestureInfo j;

        private d() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = new Point();
            this.f = new float[10];
            this.g = 0.0f;
            this.h = new float[10];
            this.i = 0.0f;
            this.j = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ d(y yVar, byte b) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x016f A[Catch: all -> 0x0199, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0199, blocks: (B:32:0x0123, B:35:0x016f, B:37:0x0184, B:24:0x0107), top: B:90:0x0107 }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0184 A[Catch: all -> 0x0199, TRY_ENTER, TryCatch #2 {all -> 0x0199, blocks: (B:32:0x0123, B:35:0x016f, B:37:0x0184, B:24:0x0107), top: B:90:0x0107 }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x01ce A[Catch: all -> 0x0295, TryCatch #0 {all -> 0x0295, blocks: (B:46:0x01ba, B:48:0x01ce, B:50:0x01df, B:52:0x01e6, B:54:0x01f3, B:56:0x01fe, B:58:0x0204, B:60:0x020a, B:73:0x0238, B:67:0x0223), top: B:86:0x01ba }] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0238 A[Catch: all -> 0x0295, TRY_ENTER, TryCatch #0 {all -> 0x0295, blocks: (B:46:0x01ba, B:48:0x01ce, B:50:0x01df, B:52:0x01e6, B:54:0x01f3, B:56:0x01fe, B:58:0x0204, B:60:0x020a, B:73:0x0238, B:67:0x0223), top: B:86:0x01ba }] */
        @Override // com.amap.api.col.p0003sl.ar.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean a(com.amap.api.col.p0003sl.ar r8) {
            /*
                Method dump skipped, instructions count: 689
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.y.d.a(com.amap.api.col.3sl.ar):boolean");
        }

        @Override // com.amap.api.col.p0003sl.ar.a
        public final boolean b(ar arVar) {
            this.j.mGestureState = 1;
            this.j.mGestureType = 4;
            this.j.mLocation = new float[]{arVar.a().getX(), arVar.a().getY()};
            int engineIDWithGestureInfo = y.this.a.getEngineIDWithGestureInfo(this.j);
            int b = (int) arVar.b();
            int c = (int) arVar.c();
            this.d = false;
            this.e.x = b;
            this.e.y = c;
            this.b = false;
            this.c = false;
            y.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, b, c));
            try {
                if (!y.this.a.getUiSettings().isRotateGesturesEnabled() || y.this.a.isLockMapAngle(engineIDWithGestureInfo)) {
                    return true;
                }
                y.this.a.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(100, y.this.a.getMapAngle(engineIDWithGestureInfo), b, c));
                return true;
            } catch (Throwable th) {
                iw.c(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
                return true;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x0227, code lost:
            if (r9 != (-9999.0f)) goto L34;
         */
        @Override // com.amap.api.col.p0003sl.ar.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void c(com.amap.api.col.p0003sl.ar r8) {
            /*
                Method dump skipped, instructions count: 590
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.y.d.c(com.amap.api.col.3sl.ar):void");
        }
    }

    /* renamed from: com.amap.api.col.3sl.y$e */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/y$e.class */
    final class e extends as.b {
        EAMapPlatformGestureInfo a;

        private e() {
            this.a = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ e(y yVar, byte b) {
            this();
        }

        @Override // com.amap.api.col.p0003sl.as.b, com.amap.api.col.p0003sl.as.a
        public final void a(as asVar) {
            try {
                if (y.this.a.getUiSettings().isZoomGesturesEnabled() && Math.abs(asVar.d()) <= 10.0f && Math.abs(asVar.e()) <= 10.0f && asVar.b() < 200) {
                    y.n(y.this);
                    this.a.mGestureState = 2;
                    this.a.mGestureType = 2;
                    this.a.mLocation = new float[]{asVar.c().getX(), asVar.c().getY()};
                    int engineIDWithGestureInfo = y.this.a.getEngineIDWithGestureInfo(this.a);
                    y.this.a.setGestureStatus(engineIDWithGestureInfo, 4);
                    y.this.a.zoomOut(engineIDWithGestureInfo);
                }
            } catch (Throwable th) {
                iw.c(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }
    }

    public y(IAMapDelegate iAMapDelegate) {
        this.b = iAMapDelegate.getContext();
        this.a = iAMapDelegate;
        a aVar = new a(this, (byte) 0);
        GestureDetector gestureDetector = new GestureDetector(this.b, aVar, this.t);
        this.c = gestureDetector;
        gestureDetector.setOnDoubleTapListener(aVar);
        this.e = new ar(this.b, new d(this, (byte) 0));
        this.f = new ap(this.b, new c(this, (byte) 0));
        this.g = new ao(this.b, new b(this, (byte) 0));
        this.h = new as(this.b, new e(this, (byte) 0));
    }

    static /* synthetic */ int g(y yVar) {
        int i = yVar.k;
        yVar.k = i + 1;
        return i;
    }

    static /* synthetic */ int h(y yVar) {
        int i = yVar.l;
        yVar.l = i + 1;
        return i;
    }

    static /* synthetic */ int l(y yVar) {
        int i = yVar.j;
        yVar.j = i + 1;
        return i;
    }

    static /* synthetic */ int m(y yVar) {
        int i = yVar.m;
        yVar.m = i + 1;
        return i;
    }

    static /* synthetic */ boolean n(y yVar) {
        yVar.q = true;
        return true;
    }

    public final void a() {
        this.j = 0;
        this.l = 0;
        this.k = 0;
        this.m = 0;
        this.n = 0;
    }

    public final void a(int i, int i2) {
        this.r = i;
        this.s = i2;
        ar arVar = this.e;
        if (arVar != null) {
            arVar.a(i, i2);
        }
        ap apVar = this.f;
        if (apVar != null) {
            apVar.a(i, i2);
        }
        ao aoVar = this.g;
        if (aoVar != null) {
            aoVar.a(i, i2);
        }
        as asVar = this.h;
        if (asVar != null) {
            asVar.a(i, i2);
        }
    }

    public final void a(AMapGestureListener aMapGestureListener) {
        this.d = aMapGestureListener;
    }

    public final boolean a(MotionEvent motionEvent) {
        if (this.n < motionEvent.getPointerCount()) {
            this.n = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.p = false;
            this.q = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.p = true;
        }
        if (this.o && this.n >= 2) {
            this.o = false;
        }
        try {
            int[] iArr = new int[2];
            iArr[0] = 0;
            iArr[1] = 0;
            if (this.a != null && this.a.getGLMapView() != null) {
                this.a.getGLMapView().getLocationOnScreen(iArr);
            }
            if (this.d != null) {
                if (motionEvent.getAction() == 0) {
                    this.d.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.d.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.c.onTouchEvent(motionEvent);
            this.g.b(motionEvent, iArr[0], iArr[1]);
            if (!this.i || this.m <= 0) {
                this.h.b(motionEvent, iArr[0], iArr[1]);
                if (this.o) {
                    return true;
                }
                this.e.a(motionEvent);
                this.f.b(motionEvent, iArr[0], iArr[1]);
                return true;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final int b() {
        return this.r;
    }

    public final int c() {
        return this.s;
    }
}
