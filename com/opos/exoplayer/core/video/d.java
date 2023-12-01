package com.opos.exoplayer.core.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/video/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final WindowManager f11884a;
    private final b b;

    /* renamed from: c  reason: collision with root package name */
    private final a f11885c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private boolean i;
    private long j;
    private long k;
    private long l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/video/d$a.class */
    public final class a implements DisplayManager.DisplayListener {
        private final DisplayManager b;

        public a(DisplayManager displayManager) {
            this.b = displayManager;
        }

        public void a() {
            this.b.registerDisplayListener(this, null);
        }

        public void b() {
            this.b.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i == 0) {
                d.this.c();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/video/d$b.class */
    static final class b implements Handler.Callback, Choreographer.FrameCallback {
        private static final b b = new b();

        /* renamed from: a  reason: collision with root package name */
        public volatile long f11887a = com.anythink.expressad.exoplayer.b.b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f11888c;
        private final HandlerThread d;
        private Choreographer e;
        private int f;

        private b() {
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.d = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.d.getLooper(), this);
            this.f11888c = handler;
            handler.sendEmptyMessage(0);
        }

        public static b a() {
            return b;
        }

        private void d() {
            this.e = Choreographer.getInstance();
        }

        private void e() {
            int i = this.f + 1;
            this.f = i;
            if (i == 1) {
                this.e.postFrameCallback(this);
            }
        }

        private void f() {
            int i = this.f - 1;
            this.f = i;
            if (i == 0) {
                this.e.removeFrameCallback(this);
                this.f11887a = com.anythink.expressad.exoplayer.b.b;
            }
        }

        public void b() {
            this.f11888c.sendEmptyMessage(1);
        }

        public void c() {
            this.f11888c.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.f11887a = j;
            this.e.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                d();
                return true;
            } else if (i == 1) {
                e();
                return true;
            } else if (i != 2) {
                return false;
            } else {
                f();
                return true;
            }
        }
    }

    public d() {
        this(null);
    }

    public d(Context context) {
        WindowManager windowManager = context == null ? null : (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        this.f11884a = windowManager;
        if (windowManager != null) {
            this.f11885c = u.f11822a >= 17 ? a(context) : null;
            this.b = b.a();
        } else {
            this.f11885c = null;
            this.b = null;
        }
        this.d = com.anythink.expressad.exoplayer.b.b;
        this.e = com.anythink.expressad.exoplayer.b.b;
    }

    private static long a(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            long j6 = j3 + j5;
            j4 = j5;
            j5 = j6;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    private a a(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new a(displayManager);
    }

    private boolean b(long j, long j2) {
        return Math.abs((j2 - this.j) - (j - this.k)) > 20000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Display defaultDisplay = this.f11884a.getDefaultDisplay();
        if (defaultDisplay != null) {
            long refreshRate = (long) (1.0E9d / defaultDisplay.getRefreshRate());
            this.d = refreshRate;
            this.e = (refreshRate * 80) / 100;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0077, code lost:
        if (b(r0, r10) != false) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(long r8, long r10) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.video.d.a(long, long):long");
    }

    public void a() {
        this.i = false;
        if (this.f11884a != null) {
            this.b.b();
            a aVar = this.f11885c;
            if (aVar != null) {
                aVar.a();
            }
            c();
        }
    }

    public void b() {
        if (this.f11884a != null) {
            a aVar = this.f11885c;
            if (aVar != null) {
                aVar.b();
            }
            this.b.c();
        }
    }
}
