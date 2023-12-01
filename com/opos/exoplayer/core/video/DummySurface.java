package com.opos.exoplayer.core.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/video/DummySurface.class */
public final class DummySurface extends Surface {
    private static int b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f11873c;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f11874a;
    private final a d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/video/DummySurface$a.class */
    public static class a extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f11875a;
        private EGLDisplay b;

        /* renamed from: c  reason: collision with root package name */
        private EGLContext f11876c;
        private EGLSurface d;
        private Handler e;
        private SurfaceTexture f;
        private Error g;
        private RuntimeException h;
        private DummySurface i;

        public a() {
            super("dummySurface");
            this.f11875a = new int[1];
        }

        private void b() {
            try {
                if (this.f != null) {
                    this.f.release();
                    GLES20.glDeleteTextures(1, this.f11875a, 0);
                }
            } finally {
                EGLSurface eGLSurface = this.d;
                if (eGLSurface != null) {
                    EGL14.eglDestroySurface(this.b, eGLSurface);
                }
                EGLContext eGLContext = this.f11876c;
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(this.b, eGLContext);
                }
                this.d = null;
                this.f11876c = null;
                this.b = null;
                this.i = null;
                this.f = null;
            }
        }

        private void b(int i) {
            EGLSurface eGLSurface;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.b = eglGetDisplay;
            com.opos.exoplayer.core.i.a.b(eglGetDisplay != null, "eglGetDisplay failed");
            int[] iArr = new int[2];
            com.opos.exoplayer.core.i.a.b(EGL14.eglInitialize(this.b, iArr, 0, iArr, 1), "eglInitialize failed");
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            com.opos.exoplayer.core.i.a.b(EGL14.eglChooseConfig(this.b, new int[]{EGL14.EGL_RENDERABLE_TYPE, 4, EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_ALPHA_SIZE, 8, EGL14.EGL_DEPTH_SIZE, 0, EGL14.EGL_CONFIG_CAVEAT, EGL14.EGL_NONE, EGL14.EGL_SURFACE_TYPE, 4, EGL14.EGL_NONE}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.b, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, EGL14.EGL_NONE} : new int[]{12440, 2, 12992, 1, EGL14.EGL_NONE}, 0);
            this.f11876c = eglCreateContext;
            com.opos.exoplayer.core.i.a.b(eglCreateContext != null, "eglCreateContext failed");
            if (i == 1) {
                eGLSurface = EGL14.EGL_NO_SURFACE;
            } else {
                EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.b, eGLConfig, i == 2 ? new int[]{EGL14.EGL_WIDTH, 1, EGL14.EGL_HEIGHT, 1, 12992, 1, EGL14.EGL_NONE} : new int[]{EGL14.EGL_WIDTH, 1, EGL14.EGL_HEIGHT, 1, EGL14.EGL_NONE}, 0);
                this.d = eglCreatePbufferSurface;
                com.opos.exoplayer.core.i.a.b(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                eGLSurface = this.d;
            }
            com.opos.exoplayer.core.i.a.b(EGL14.eglMakeCurrent(this.b, eGLSurface, eGLSurface, this.f11876c), "eglMakeCurrent failed");
            GLES20.glGenTextures(1, this.f11875a, 0);
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.f11875a[0]);
            this.f = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            SurfaceTexture surfaceTexture2 = this.f;
            boolean z = false;
            if (i != 0) {
                z = true;
            }
            this.i = new DummySurface(this, surfaceTexture2, z);
        }

        public DummySurface a(int i) {
            boolean z;
            start();
            this.e = new Handler(getLooper(), this);
            synchronized (this) {
                this.e.obtainMessage(1, i, 0).sendToTarget();
                z = false;
                while (this.i == null && this.h == null && this.g == null) {
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
            RuntimeException runtimeException = this.h;
            if (runtimeException == null) {
                Error error = this.g;
                if (error == null) {
                    return this.i;
                }
                throw error;
            }
            throw runtimeException;
        }

        public void a() {
            this.e.sendEmptyMessage(3);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i == 2) {
                        this.f.updateTexImage();
                        return true;
                    } else if (i != 3) {
                        return true;
                    } else {
                        try {
                            b();
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
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                    return true;
                } catch (Error e) {
                    com.opos.cmn.an.f.a.d("DummySurface", "Failed to initialize dummy surface", e);
                    this.g = e;
                    synchronized (this) {
                        notify();
                        return true;
                    }
                } catch (RuntimeException e2) {
                    com.opos.cmn.an.f.a.d("DummySurface", "Failed to initialize dummy surface", e2);
                    this.h = e2;
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

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.e.sendEmptyMessage(2);
        }
    }

    private DummySurface(a aVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.d = aVar;
        this.f11874a = z;
    }

    public static DummySurface a(Context context, boolean z) {
        a();
        int i = 0;
        com.opos.exoplayer.core.i.a.b(!z || a(context));
        a aVar = new a();
        if (z) {
            i = b;
        }
        return aVar.a(i);
    }

    private static void a() {
        if (u.f11822a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    public static boolean a(Context context) {
        boolean z;
        synchronized (DummySurface.class) {
            try {
                z = false;
                if (!f11873c) {
                    b = u.f11822a < 24 ? 0 : b(context);
                    f11873c = true;
                }
                if (b != 0) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r3.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance") != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int b(android.content.Context r3) {
        /*
            int r0 = com.opos.exoplayer.core.i.u.f11822a
            r4 = r0
            r0 = 0
            r5 = r0
            r0 = r4
            r1 = 26
            if (r0 >= r1) goto L26
            r0 = r5
            r4 = r0
            java.lang.String r0 = "samsung"
            java.lang.String r1 = com.opos.exoplayer.core.i.u.f11823c
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L65
            java.lang.String r0 = "XT1650"
            java.lang.String r1 = com.opos.exoplayer.core.i.u.d
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L26
            r0 = 0
            return r0
        L26:
            int r0 = com.opos.exoplayer.core.i.u.f11822a
            r1 = 26
            if (r0 >= r1) goto L3c
            r0 = r5
            r4 = r0
            r0 = r3
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String r1 = "android.hardware.vr.high_performance"
            boolean r0 = r0.hasSystemFeature(r1)
            if (r0 == 0) goto L65
        L3c:
            r0 = 0
            android.opengl.EGLDisplay r0 = android.opengl.EGL14.eglGetDisplay(r0)
            r1 = 12373(0x3055, float:1.7338E-41)
            java.lang.String r0 = android.opengl.EGL14.eglQueryString(r0, r1)
            r3 = r0
            r0 = r5
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L65
            r0 = r5
            r4 = r0
            r0 = r3
            java.lang.String r1 = "EGL_EXT_protected_content"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L65
            r0 = r3
            java.lang.String r1 = "EGL_KHR_surfaceless_context"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L63
            r0 = 1
            return r0
        L63:
            r0 = 2
            r4 = r0
        L65:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.video.DummySurface.b(android.content.Context):int");
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.d) {
            if (!this.e) {
                this.d.a();
                this.e = true;
            }
        }
    }
}
