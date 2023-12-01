package com.tencent.liteav.videoproducer.capture;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Looper;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import javax.microedition.khronos.egl.EGL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/au.class */
public class au {

    /* renamed from: a  reason: collision with root package name */
    private static volatile au f36885a;
    private Object b;

    /* renamed from: c  reason: collision with root package name */
    private com.tencent.liteav.videobase.b.e f36886c;

    private au() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            d();
        } else {
            new com.tencent.liteav.base.util.b(Looper.getMainLooper()).a(av.a(this));
        }
    }

    public static au a() {
        if (f36885a == null) {
            synchronized (au.class) {
                try {
                    if (f36885a == null) {
                        f36885a = new au();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f36885a;
    }

    private void c() {
        com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
        this.f36886c = eVar;
        try {
            eVar.a(null, null, 128, 128);
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e("GlobalContextManager", "initializeEGL failed.", e);
            this.f36886c = null;
        }
        com.tencent.liteav.videobase.b.e eVar2 = this.f36886c;
        if (eVar2 != null) {
            this.b = eVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.b != null) {
            return;
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
            EGLDisplay eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay();
            EGLSurface eglGetCurrentSurface = EGL14.eglGetCurrentSurface(12379);
            EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
            c();
            EGL14.eglMakeCurrent(eglGetCurrentDisplay, eglGetCurrentSurface, eglGetCurrentSurface, eglGetCurrentContext);
        } else {
            EGL10 egl10 = (EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();
            javax.microedition.khronos.egl.EGLDisplay eglGetCurrentDisplay2 = egl10.eglGetCurrentDisplay();
            javax.microedition.khronos.egl.EGLSurface eglGetCurrentSurface2 = egl10.eglGetCurrentSurface(12379);
            javax.microedition.khronos.egl.EGLContext eglGetCurrentContext2 = egl10.eglGetCurrentContext();
            c();
            egl10.eglMakeCurrent(eglGetCurrentDisplay2, eglGetCurrentSurface2, eglGetCurrentSurface2, eglGetCurrentContext2);
        }
        LiteavLog.i("GlobalContextManager", "global context: " + this.b);
    }

    public final Object b() {
        Object obj;
        synchronized (this) {
            obj = this.b;
        }
        return obj;
    }
}
