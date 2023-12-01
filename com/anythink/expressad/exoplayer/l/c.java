package com.anythink.expressad.exoplayer.l;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.anythink.expressad.exoplayer.k.af;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l/c.class */
public final class c extends Surface {
    private static final String b = "DummySurface";

    /* renamed from: c  reason: collision with root package name */
    private static final String f7695c = "EGL_EXT_protected_content";
    private static final String d = "EGL_KHR_surfaceless_context";
    private static int e;
    private static boolean f;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f7696a;
    private final a g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l/c$a.class */
    public static final class a extends HandlerThread implements Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        private static final int f7697a = 1;
        private static final int b = 2;

        /* renamed from: c  reason: collision with root package name */
        private com.anythink.expressad.exoplayer.k.g f7698c;
        private Handler d;
        private Error e;
        private RuntimeException f;
        private c g;

        public a() {
            super("dummySurface");
        }

        private void b() {
            com.anythink.expressad.exoplayer.k.a.a(this.f7698c);
            this.f7698c.a();
        }

        private void b(int i) {
            com.anythink.expressad.exoplayer.k.a.a(this.f7698c);
            this.f7698c.a(i);
            this.g = new c(this, this.f7698c.b(), i != 0, (byte) 0);
        }

        public final c a(int i) {
            boolean z;
            start();
            Handler handler = new Handler(getLooper(), this);
            this.d = handler;
            this.f7698c = new com.anythink.expressad.exoplayer.k.g(handler);
            synchronized (this) {
                this.d.obtainMessage(1, i, 0).sendToTarget();
                z = false;
                while (this.g == null && this.f == null && this.e == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f;
            if (runtimeException == null) {
                Error error = this.e;
                if (error == null) {
                    return (c) com.anythink.expressad.exoplayer.k.a.a(this.g);
                }
                throw error;
            }
            throw runtimeException;
        }

        public final void a() {
            com.anythink.expressad.exoplayer.k.a.a(this.d);
            this.d.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        com.anythink.expressad.exoplayer.k.a.a(this.f7698c);
                        this.f7698c.a();
                    } finally {
                        try {
                            quit();
                            return true;
                        } catch (Throwable th) {
                        }
                    }
                    quit();
                    return true;
                }
                try {
                    try {
                        int i2 = message.arg1;
                        com.anythink.expressad.exoplayer.k.a.a(this.f7698c);
                        this.f7698c.a(i2);
                        this.g = new c(this, this.f7698c.b(), i2 != 0, (byte) 0);
                        synchronized (this) {
                            notify();
                        }
                        return true;
                    } catch (Error e) {
                        Log.e(c.b, "Failed to initialize dummy surface", e);
                        this.e = e;
                        synchronized (this) {
                            notify();
                            return true;
                        }
                    }
                } catch (RuntimeException e2) {
                    Log.e(c.b, "Failed to initialize dummy surface", e2);
                    this.f = e2;
                    synchronized (this) {
                        notify();
                        return true;
                    }
                }
            } catch (Throwable th2) {
                synchronized (this) {
                    notify();
                    throw th2;
                }
            }
        }
    }

    private c(a aVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.g = aVar;
        this.f7696a = z;
    }

    /* synthetic */ c(a aVar, SurfaceTexture surfaceTexture, boolean z, byte b2) {
        this(aVar, surfaceTexture, z);
    }

    public static c a(Context context, boolean z) {
        if (af.f7632a >= 17) {
            int i = 0;
            com.anythink.expressad.exoplayer.k.a.b(!z || a(context));
            a aVar = new a();
            if (z) {
                i = e;
            }
            return aVar.a(i);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }

    private static void a() {
        if (af.f7632a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    public static boolean a(Context context) {
        int i;
        String eglQueryString;
        int i2;
        synchronized (c.class) {
            try {
                if (!f) {
                    if (af.f7632a >= 24 && ((af.f7632a >= 26 || (!"samsung".equals(af.f7633c) && !"XT1650".equals(af.d))) && ((af.f7632a >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains(f7695c)))) {
                        i2 = eglQueryString.contains(d) ? 1 : 2;
                        e = i2;
                        f = true;
                    }
                    i2 = 0;
                    e = i2;
                    f = true;
                }
                i = e;
            } finally {
            }
        }
        return i != 0;
    }

    private static int b(Context context) {
        String eglQueryString;
        if (af.f7632a >= 26 || !("samsung".equals(af.f7633c) || "XT1650".equals(af.d))) {
            if ((af.f7632a >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains(f7695c)) {
                return eglQueryString.contains(d) ? 1 : 2;
            }
            return 0;
        }
        return 0;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.g) {
            if (!this.h) {
                this.g.a();
                this.h = true;
            }
        }
    }
}
