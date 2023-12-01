package a.a.a.a.a.a.h;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/h/a.class */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f1183a;
    public EGLContext b;

    /* renamed from: c  reason: collision with root package name */
    public EGLConfig f1184c;
    public EGL10 d = (EGL10) EGLContext.getEGL();

    public a(Object obj, int i) {
        this.f1183a = EGL10.EGL_NO_DISPLAY;
        this.b = EGL10.EGL_NO_CONTEXT;
        this.f1184c = null;
        if (this.f1183a != EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        EGLContext eGLContext = obj == null ? EGL10.EGL_NO_CONTEXT : obj;
        EGLDisplay eglGetDisplay = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f1183a = eglGetDisplay;
        if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL10 display");
        }
        if (!this.d.eglInitialize(eglGetDisplay, new int[2])) {
            this.f1183a = null;
            throw new RuntimeException("unable to initialize EGL10");
        } else if (this.b == EGL10.EGL_NO_CONTEXT) {
            EGLConfig b = b(i, 2);
            if (b == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eglCreateContext = this.d.eglCreateContext(this.f1183a, b, (EGLContext) eGLContext, new int[]{12440, 2, EGL14.EGL_NONE});
            a("eglCreateContext");
            this.f1184c = b;
            this.b = eglCreateContext;
        }
    }

    public static Object a() {
        return ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
    }

    @Override // a.a.a.a.a.a.h.c
    public int a(Object obj, int i) {
        int[] iArr = new int[1];
        this.d.eglQuerySurface(this.f1183a, (EGLSurface) obj, i, iArr);
        return iArr[0];
    }

    @Override // a.a.a.a.a.a.h.c
    public Object a(int i, int i2) {
        EGLSurface eglCreatePbufferSurface = this.d.eglCreatePbufferSurface(this.f1183a, this.f1184c, new int[]{EGL14.EGL_WIDTH, i, EGL14.EGL_HEIGHT, i2, EGL14.EGL_NONE});
        a("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new RuntimeException("surface was null");
    }

    @Override // a.a.a.a.a.a.h.c
    public void a(Object obj) {
        this.d.eglDestroySurface(this.f1183a, (EGLSurface) obj);
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
        EGLSurface eglCreateWindowSurface = this.d.eglCreateWindowSurface(this.f1183a, this.f1184c, obj, new int[]{EGL14.EGL_NONE});
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public final EGLConfig b(int i, int i2) {
        int[] iArr = {EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_RENDERABLE_TYPE, 4, EGL14.EGL_NONE, 0, EGL14.EGL_NONE};
        if ((i & 1) != 0) {
            iArr[8] = 12610;
            iArr[9] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (this.d.eglChooseConfig(this.f1183a, iArr, eGLConfigArr, 1, new int[1])) {
            return eGLConfigArr[0];
        }
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f1313c;
        eVar.d("EGL10", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    @Override // a.a.a.a.a.a.h.c
    public void b() {
        EGLDisplay eGLDisplay = this.f1183a;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            EGL10 egl10 = this.d;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.d.eglDestroyContext(this.f1183a, this.b);
            this.d.eglTerminate(this.f1183a);
        }
        this.f1183a = EGL10.EGL_NO_DISPLAY;
        this.b = EGL10.EGL_NO_CONTEXT;
        this.f1184c = null;
    }

    @Override // a.a.a.a.a.a.h.c
    public void c(Object obj) {
        if (this.f1183a == EGL10.EGL_NO_DISPLAY) {
            a.a.a.a.a.e.e.f1313c.b("EGL10", "NOTE: makeCurrent w/o display");
        }
        EGLSurface eGLSurface = (EGLSurface) obj;
        if (!this.d.eglMakeCurrent(this.f1183a, eGLSurface, eGLSurface, this.b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    @Override // a.a.a.a.a.a.h.c
    public boolean d(Object obj) {
        return this.d.eglSwapBuffers(this.f1183a, (EGLSurface) obj);
    }

    @Override // a.a.a.a.a.a.h.c
    public boolean e(Object obj) {
        return this.b.equals(this.d.eglGetCurrentContext()) && obj.equals(this.d.eglGetCurrentSurface(EGL14.EGL_DRAW));
    }

    @Override // a.a.a.a.a.a.h.c
    public void finalize() {
        if (this.f1183a != EGL10.EGL_NO_DISPLAY) {
            a.a.a.a.a.e.e.f1313c.d("EGL10", "WARNING: EglCore was not explicitly released -- state may be leaked");
            b();
        }
    }
}
