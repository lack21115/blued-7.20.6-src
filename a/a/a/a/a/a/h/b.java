package a.a.a.a.a.a.h;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/h/b.class */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f1233a;
    public EGLContext b;

    /* renamed from: c  reason: collision with root package name */
    public EGLConfig f1234c;

    public b(Object obj, int i) {
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f1233a = eGLDisplay;
        this.b = EGL14.EGL_NO_CONTEXT;
        this.f1234c = null;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        EGLContext eGLContext = obj == null ? EGL14.EGL_NO_CONTEXT : obj;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f1233a = eglGetDisplay;
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = {0, 1};
        if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            this.f1233a = null;
            throw new RuntimeException("unable to initialize EGL14");
        } else if (this.b == EGL14.EGL_NO_CONTEXT) {
            EGLConfig b = b(i, 2);
            if (b == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.f1233a, b, (EGLContext) eGLContext, new int[]{12440, 2, 12344}, 0);
            a("eglCreateContext");
            this.f1234c = b;
            this.b = eglCreateContext;
        }
    }

    public static Object a() {
        return EGL14.eglGetCurrentContext();
    }

    @Override // a.a.a.a.a.a.h.c
    public int a(Object obj, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f1233a, (EGLSurface) obj, i, iArr, 0);
        return iArr[0];
    }

    @Override // a.a.a.a.a.a.h.c
    public Object a(int i, int i2) {
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f1233a, this.f1234c, new int[]{12375, i, 12374, i2, 12344}, 0);
        a("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new RuntimeException("surface was null");
    }

    @Override // a.a.a.a.a.a.h.c
    public void a(Object obj) {
        EGL14.eglDestroySurface(this.f1233a, (EGLSurface) obj);
    }

    @Override // a.a.a.a.a.a.h.c
    public void a(Object obj, long j) {
        EGLExt.eglPresentationTimeANDROID(this.f1233a, (EGLSurface) obj, j);
    }

    public final void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    public final EGLConfig b(int i, int i2) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f1233a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f1361c;
        eVar.d("EGL14", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    @Override // a.a.a.a.a.a.h.c
    public Object b(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f1233a, this.f1234c, obj, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    @Override // a.a.a.a.a.a.h.c
    public void b() {
        EGLDisplay eGLDisplay = this.f1233a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f1233a, this.b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f1233a);
        }
        this.f1233a = EGL14.EGL_NO_DISPLAY;
        this.b = EGL14.EGL_NO_CONTEXT;
        this.f1234c = null;
    }

    @Override // a.a.a.a.a.a.h.c
    public void c(Object obj) {
        if (this.f1233a == EGL14.EGL_NO_DISPLAY) {
            a.a.a.a.a.e.e.f1361c.b("EGL14", "NOTE: makeCurrent w/o display");
        }
        EGLSurface eGLSurface = (EGLSurface) obj;
        if (!EGL14.eglMakeCurrent(this.f1233a, eGLSurface, eGLSurface, this.b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    @Override // a.a.a.a.a.a.h.c
    public boolean d(Object obj) {
        return EGL14.eglSwapBuffers(this.f1233a, (EGLSurface) obj);
    }

    @Override // a.a.a.a.a.a.h.c
    public boolean e(Object obj) {
        return this.b.equals(EGL14.eglGetCurrentContext()) && obj.equals(EGL14.eglGetCurrentSurface(12377));
    }

    @Override // a.a.a.a.a.a.h.c
    public void finalize() {
        if (this.f1233a != EGL14.EGL_NO_DISPLAY) {
            a.a.a.a.a.e.e.f1361c.d("EGL14", "WARNING: EglCore was not explicitly released -- state may be leaked");
            b();
        }
    }
}
