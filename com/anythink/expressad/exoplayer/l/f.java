package com.anythink.expressad.exoplayer.l;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.anythink.expressad.exoplayer.k.af;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final long f4864a = 500;
    private static final long b = 20000000;

    /* renamed from: c  reason: collision with root package name */
    private static final long f4865c = 80;
    private static final int d = 6;
    private final WindowManager e;
    private final b f;
    private final a g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private boolean m;
    private long n;
    private long o;
    private long p;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l/f$a.class */
    final class a implements DisplayManager.DisplayListener {
        private final DisplayManager b;

        public a(DisplayManager displayManager) {
            this.b = displayManager;
        }

        public final void a() {
            this.b.registerDisplayListener(this, null);
        }

        public final void b() {
            this.b.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int i) {
            if (i == 0) {
                f.this.c();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i) {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l/f$b.class */
    static final class b implements Handler.Callback, Choreographer.FrameCallback {
        private static final int b = 0;

        /* renamed from: c  reason: collision with root package name */
        private static final int f4867c = 1;
        private static final int d = 2;
        private static final b e = new b();

        /* renamed from: a  reason: collision with root package name */
        public volatile long f4868a = com.anythink.expressad.exoplayer.b.b;
        private final Handler f;
        private final HandlerThread g;
        private Choreographer h;
        private int i;

        private b() {
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.g = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.g.getLooper(), this);
            this.f = handler;
            handler.sendEmptyMessage(0);
        }

        public static b a() {
            return e;
        }

        private void d() {
            this.h = Choreographer.getInstance();
        }

        private void e() {
            int i = this.i + 1;
            this.i = i;
            if (i == 1) {
                this.h.postFrameCallback(this);
            }
        }

        private void f() {
            int i = this.i - 1;
            this.i = i;
            if (i == 0) {
                this.h.removeFrameCallback(this);
                this.f4868a = com.anythink.expressad.exoplayer.b.b;
            }
        }

        public final void b() {
            this.f.sendEmptyMessage(1);
        }

        public final void c() {
            this.f.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j) {
            this.f4868a = j;
            this.h.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.h = Choreographer.getInstance();
                return true;
            } else if (i == 1) {
                int i2 = this.i + 1;
                this.i = i2;
                if (i2 == 1) {
                    this.h.postFrameCallback(this);
                    return true;
                }
                return true;
            } else if (i != 2) {
                return false;
            } else {
                int i3 = this.i - 1;
                this.i = i3;
                if (i3 == 0) {
                    this.h.removeFrameCallback(this);
                    this.f4868a = com.anythink.expressad.exoplayer.b.b;
                    return true;
                }
                return true;
            }
        }
    }

    public f() {
        this(null);
    }

    public f(Context context) {
        Context context2;
        if (context != null) {
            context2 = context.getApplicationContext();
            this.e = (WindowManager) context2.getSystemService(Context.WINDOW_SERVICE);
        } else {
            this.e = null;
            context2 = context;
        }
        if (this.e != null) {
            a aVar = null;
            if (af.f4793a >= 17) {
                DisplayManager displayManager = (DisplayManager) context2.getSystemService("display");
                aVar = null;
                if (displayManager != null) {
                    aVar = new a(displayManager);
                }
            }
            this.g = aVar;
            this.f = b.a();
        } else {
            this.g = null;
            this.f = null;
        }
        this.h = com.anythink.expressad.exoplayer.b.b;
        this.i = com.anythink.expressad.exoplayer.b.b;
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
        return Math.abs((j2 - this.n) - (j - this.o)) > b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            Display defaultDisplay = this.e.getDefaultDisplay();
            if (defaultDisplay != null) {
                long refreshRate = (long) (1.0E9d / defaultDisplay.getRefreshRate());
                this.h = refreshRate;
                this.i = (refreshRate * f4865c) / 100;
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(long r8, long r10) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.l.f.a(long, long):long");
    }

    public final void a() {
        this.m = false;
        if (this.e != null) {
            this.f.b();
            a aVar = this.g;
            if (aVar != null) {
                aVar.a();
            }
            c();
        }
    }

    public final void b() {
        if (this.e != null) {
            a aVar = this.g;
            if (aVar != null) {
                aVar.b();
            }
            this.f.c();
        }
    }
}
