package a.a.a.a.a.a.h;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/h/a.class */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f1231a;
    public EGLContext b;

    /* renamed from: c  reason: collision with root package name */
    public EGLConfig f1232c;
    public EGL10 d = (EGL10) EGLContext.getEGL();

    public a(Object obj, int i) {
        this.f1231a = EGL10.EGL_NO_DISPLAY;
        this.b = EGL10.EGL_NO_CONTEXT;
        this.f1232c = null;
        if (this.f1231a != EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        EGLContext eGLContext = obj == null ? EGL10.EGL_NO_CONTEXT : obj;
        EGLDisplay eglGetDisplay = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f1231a = eglGetDisplay;
        if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL10 display");
        }
        if (!this.d.eglInitialize(eglGetDisplay, new int[2])) {
            this.f1231a = null;
            throw new RuntimeException("unable to initialize EGL10");
        } else if (this.b == EGL10.EGL_NO_CONTEXT) {
            EGLConfig b = b(i, 2);
            if (b == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eglCreateContext = this.d.eglCreateContext(this.f1231a, b, (EGLContext) eGLContext, new int[]{12440, 2, 12344});
            a("eglCreateContext");
            this.f1232c = b;
            this.b = eglCreateContext;
        }
    }

    public static Object a() {
        return ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
    }

    @Override // a.a.a.a.a.a.h.c
    public int a(Object obj, int i) {
        int[] iArr = new int[1];
        this.d.eglQuerySurface(this.f1231a, (EGLSurface) obj, i, iArr);
        return iArr[0];
    }

    @Override // a.a.a.a.a.a.h.c
    public Object a(int i, int i2) {
        EGLSurface eglCreatePbufferSurface = this.d.eglCreatePbufferSurface(this.f1231a, this.f1232c, new int[]{12375, i, 12374, i2, 12344});
        a("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new RuntimeException("surface was null");
    }

    @Override // a.a.a.a.a.a.h.c
    public void a(Object obj) {
        this.d.eglDestroySurface(this.f1231a, (EGLSurface) obj);
    }

    @Override // a.a.a.a.a.a.h.c
    public void a(Object obj, long j) {
    }

    public final void a(String str) {
        int eglGetError = this.d.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    @Override // a.a.a.a.a.a.h.c
    public Object b(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eglCreateWindowSurface = this.d.eglCreateWindowSurface(this.f1231a, this.f1232c, obj, new int[]{12344});
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public final EGLConfig b(int i, int i2) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[8] = 12610;
            iArr[9] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (this.d.eglChooseConfig(this.f1231a, iArr, eGLConfigArr, 1, new int[1])) {
            return eGLConfigArr[0];
        }
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f1361c;
        eVar.d("EGL10", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    @Override // a.a.a.a.a.a.h.c
    public void b() {
        EGLDisplay eGLDisplay = this.f1231a;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            EGL10 egl10 = this.d;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.d.eglDestroyContext(this.f1231a, this.b);
            this.d.eglTerminate(this.f1231a);
        }
        this.f1231a = EGL10.EGL_NO_DISPLAY;
        this.b = EGL10.EGL_NO_CONTEXT;
        this.f1232c = null;
    }

    @Override // a.a.a.a.a.a.h.c
    public void c(Object obj) {
        if (this.f1231a == EGL10.EGL_NO_DISPLAY) {
            a.a.a.a.a.e.e.f1361c.b("EGL10", "NOTE: makeCurrent w/o display");
        }
        EGLSurface eGLSurface = (EGLSurface) obj;
        if (!this.d.eglMakeCurrent(this.f1231a, eGLSurface, eGLSurface, this.b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    @Override // a.a.a.a.a.a.h.c
    public boolean d(Object obj) {
        return this.d.eglSwapBuffers(this.f1231a, (EGLSurface) obj);
    }

    @Override // a.a.a.a.a.a.h.c
    public boolean e(Object obj) {
        return this.b.equals(this.d.eglGetCurrentContext()) && obj.equals(this.d.eglGetCurrentSurface(12377));
    }

    @Override // a.a.a.a.a.a.h.c
    public void finalize() {
        if (this.f1231a != EGL10.EGL_NO_DISPLAY) {
            a.a.a.a.a.e.e.f1361c.d("EGL10", "WARNING: EglCore was not explicitly released -- state may be leaked");
            b();
        }
    }
}
