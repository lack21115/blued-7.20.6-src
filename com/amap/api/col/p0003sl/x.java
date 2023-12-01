package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;
import android.view.TextureView;
import com.amap.api.maps.MapsInitializer;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.amap.api.col.3sl.x  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x.class */
public class x extends TextureView implements TextureView.SurfaceTextureListener {
    private static final j a = new j((byte) 0);
    private final WeakReference<x> b;
    private i c;
    private GLSurfaceView.Renderer d;
    private boolean e;
    private e f;
    private f g;
    private g h;
    private k i;
    private int j;
    private int k;
    private boolean l;

    /* renamed from: com.amap.api.col.3sl.x$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x$a.class */
    abstract class a implements e {
        protected int[] a;

        public a(int[] iArr) {
            this.a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (x.this.k == 2 || x.this.k == 3) {
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                int i = length - 1;
                System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, i);
                iArr2[i] = 12352;
                if (x.this.k == 2) {
                    iArr2[length] = 4;
                } else {
                    iArr2[length] = 64;
                }
                iArr2[length + 1] = 12344;
                return iArr2;
            }
            return iArr;
        }

        abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // com.amap.api.col.p0003sl.x.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.a, eGLConfigArr, i, iArr)) {
                        EGLConfig a = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a != null) {
                            return a;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    /* renamed from: com.amap.api.col.3sl.x$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x$b.class */
    class b extends a {
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        private int[] j;

        public b() {
            super(new int[]{EGL10.EGL_RED_SIZE, 8, EGL10.EGL_GREEN_SIZE, 8, EGL10.EGL_BLUE_SIZE, 8, EGL10.EGL_ALPHA_SIZE, 0, EGL10.EGL_DEPTH_SIZE, 16, EGL10.EGL_STENCIL_SIZE, 0, EGL10.EGL_NONE});
            this.j = new int[1];
            this.c = 8;
            this.d = 8;
            this.e = 8;
            this.f = 0;
            this.g = 16;
            this.h = 0;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.j)) {
                return this.j[0];
            }
            return 0;
        }

        @Override // com.amap.api.col.p0003sl.x.a
        public final EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            int length = eGLConfigArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                EGLConfig eGLConfig = eGLConfigArr[i2];
                int a = a(egl10, eGLDisplay, eGLConfig, EGL10.EGL_DEPTH_SIZE);
                int a2 = a(egl10, eGLDisplay, eGLConfig, EGL10.EGL_STENCIL_SIZE);
                if (a >= this.g && a2 >= this.h) {
                    int a3 = a(egl10, eGLDisplay, eGLConfig, EGL10.EGL_RED_SIZE);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, EGL10.EGL_GREEN_SIZE);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, EGL10.EGL_BLUE_SIZE);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, EGL10.EGL_ALPHA_SIZE);
                    if (a3 == this.c && a4 == this.d && a5 == this.e && a6 == this.f) {
                        return eGLConfig;
                    }
                }
                i = i2 + 1;
            }
        }
    }

    /* renamed from: com.amap.api.col.3sl.x$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x$c.class */
    final class c implements f {
        private c() {
        }

        /* synthetic */ c(x xVar, byte b) {
            this();
        }

        @Override // com.amap.api.col.p0003sl.x.f
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, x.this.k, EGL10.EGL_NONE};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (x.this.k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.amap.api.col.p0003sl.x.f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            h.a("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* renamed from: com.amap.api.col.3sl.x$d */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x$d.class */
    static final class d implements g {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.amap.api.col.p0003sl.x.g
        public final EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.amap.api.col.p0003sl.x.g
        public final void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* renamed from: com.amap.api.col.3sl.x$e */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x$e.class */
    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* renamed from: com.amap.api.col.3sl.x$f */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x$f.class */
    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* renamed from: com.amap.api.col.3sl.x$g */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x$g.class */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.x$h */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x$h.class */
    public static final class h {
        EGL10 a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<x> f;

        public h(WeakReference<x> weakReference) {
            this.f = weakReference;
        }

        private void a(String str) {
            a(str, this.a.eglGetError());
        }

        public static void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, b(str2, i));
        }

        private static String b(String str, int i) {
            return str + " failed: " + i;
        }

        private void g() {
            EGLSurface eGLSurface = this.c;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                return;
            }
            EGL10 egl10 = this.a;
            EGLDisplay eGLDisplay = this.b;
            EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
            x xVar = this.f.get();
            if (xVar != null) {
                xVar.h.a(this.a, this.b, this.c);
            }
            this.c = null;
        }

        public final void a() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.a = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.b = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.a.eglInitialize(this.b, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            x xVar = this.f.get();
            if (xVar == null) {
                this.d = null;
                this.e = null;
            } else {
                this.d = xVar.f.chooseConfig(this.a, this.b);
                this.e = xVar.g.createContext(this.a, this.b, this.d);
            }
            EGLContext eGLContext = this.e;
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                this.e = null;
                a("createContext");
            }
            this.c = null;
        }

        public final boolean b() {
            if (this.a != null) {
                if (this.b != null) {
                    if (this.d != null) {
                        g();
                        x xVar = this.f.get();
                        if (xVar != null) {
                            this.c = xVar.h.a(this.a, this.b, this.d, xVar.getSurfaceTexture());
                        } else {
                            this.c = null;
                        }
                        EGLSurface eGLSurface = this.c;
                        if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                            if (this.a.eglGetError() == 12299) {
                                Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                                return false;
                            }
                            return false;
                        }
                        EGL10 egl10 = this.a;
                        EGLDisplay eGLDisplay = this.b;
                        EGLSurface eGLSurface2 = this.c;
                        if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.e)) {
                            return true;
                        }
                        a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        final GL c() {
            GL gl = this.e.getGL();
            x xVar = this.f.get();
            GL gl2 = gl;
            if (xVar != null) {
                if (xVar.i != null) {
                    gl = xVar.i.a();
                }
                gl2 = gl;
                if ((xVar.j & 3) != 0) {
                    int i = 0;
                    l lVar = null;
                    if ((xVar.j & 1) != 0) {
                        i = 1;
                    }
                    if ((xVar.j & 2) != 0) {
                        lVar = new l();
                    }
                    gl2 = GLDebugHelper.wrap(gl, i, lVar);
                }
            }
            return gl2;
        }

        public final int d() {
            if (this.a.eglSwapBuffers(this.b, this.c)) {
                return 12288;
            }
            return this.a.eglGetError();
        }

        public final void e() {
            g();
        }

        public final void f() {
            if (this.e != null) {
                x xVar = this.f.get();
                if (xVar != null) {
                    xVar.g.destroyContext(this.a, this.b, this.e);
                }
                this.e = null;
            }
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay != null) {
                this.a.eglTerminate(eGLDisplay);
                this.b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.x$i */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x$i.class */
    public static final class i extends Thread {
        private boolean a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean p;
        private h s;
        private WeakReference<x> t;
        private ArrayList<Runnable> q = new ArrayList<>();
        private boolean r = true;
        private int l = 0;
        private int m = 0;
        private boolean o = true;
        private int n = 1;

        i(WeakReference<x> weakReference) {
            this.t = weakReference;
        }

        static /* synthetic */ boolean a(i iVar) {
            iVar.b = true;
            return true;
        }

        private void k() {
            if (this.i) {
                this.i = false;
                this.s.e();
            }
        }

        private void l() {
            if (this.h) {
                this.s.f();
                this.h = false;
                x.a.c(this);
            }
        }

        private void m() throws InterruptedException {
            boolean z;
            this.s = new h(this.t);
            this.h = false;
            this.i = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            GL10 gl10 = null;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            int i = 0;
            int i2 = 0;
            boolean z9 = false;
            while (true) {
                Runnable runnable = null;
                while (true) {
                    try {
                        synchronized (x.a) {
                            boolean z10 = z9;
                            boolean z11 = z5;
                            boolean z12 = z2;
                            while (!this.a) {
                                if (this.q.isEmpty()) {
                                    if (this.d != this.c) {
                                        z = this.c;
                                        this.d = this.c;
                                        x.a.notifyAll();
                                    } else {
                                        z = false;
                                    }
                                    boolean z13 = z4;
                                    if (this.k) {
                                        k();
                                        l();
                                        this.k = false;
                                        z13 = true;
                                    }
                                    boolean z14 = z12;
                                    if (z12) {
                                        k();
                                        l();
                                        z14 = false;
                                    }
                                    if (z && this.i) {
                                        k();
                                    }
                                    if (z && this.h) {
                                        x xVar = this.t.get();
                                        if (!(xVar == null ? false : xVar.l) || x.a.a()) {
                                            l();
                                        }
                                    }
                                    if (z && x.a.b()) {
                                        this.s.f();
                                    }
                                    if (!this.e && !this.g) {
                                        if (this.i) {
                                            k();
                                        }
                                        this.g = true;
                                        this.f = false;
                                        x.a.notifyAll();
                                    }
                                    if (this.e && this.g) {
                                        this.g = false;
                                        x.a.notifyAll();
                                    }
                                    boolean z15 = z3;
                                    if (z3) {
                                        this.p = true;
                                        x.a.notifyAll();
                                        z15 = false;
                                        z10 = false;
                                    }
                                    boolean z16 = z13;
                                    boolean z17 = z11;
                                    boolean z18 = z6;
                                    boolean z19 = z7;
                                    boolean z20 = z8;
                                    if (o()) {
                                        boolean z21 = z13;
                                        z5 = z11;
                                        if (!this.h) {
                                            if (z13) {
                                                z21 = false;
                                                z5 = z11;
                                            } else {
                                                z21 = z13;
                                                z5 = z11;
                                                if (x.a.b(this)) {
                                                    try {
                                                        this.s.a();
                                                        this.h = true;
                                                        x.a.notifyAll();
                                                        z5 = true;
                                                        z21 = z13;
                                                    } catch (RuntimeException e) {
                                                        x.a.c(this);
                                                        throw e;
                                                    }
                                                }
                                            }
                                        }
                                        boolean z22 = z6;
                                        boolean z23 = z7;
                                        boolean z24 = z8;
                                        if (this.h) {
                                            z22 = z6;
                                            z23 = z7;
                                            z24 = z8;
                                            if (!this.i) {
                                                this.i = true;
                                                z22 = true;
                                                z23 = true;
                                                z24 = true;
                                            }
                                        }
                                        z16 = z21;
                                        z17 = z5;
                                        z18 = z22;
                                        z19 = z23;
                                        z20 = z24;
                                        if (this.i) {
                                            if (this.r) {
                                                i = this.l;
                                                i2 = this.m;
                                                this.r = false;
                                                z6 = true;
                                                z8 = true;
                                                z9 = true;
                                            } else {
                                                z6 = z22;
                                                z8 = z24;
                                                z9 = z10;
                                            }
                                            this.o = false;
                                            x.a.notifyAll();
                                            z7 = z23;
                                            z4 = z21;
                                            z3 = z15;
                                            z2 = z14;
                                        }
                                    }
                                    x.a.wait();
                                    z12 = z14;
                                    z3 = z15;
                                    z4 = z16;
                                    z11 = z17;
                                    z6 = z18;
                                    z7 = z19;
                                    z8 = z20;
                                } else {
                                    runnable = this.q.remove(0);
                                    z2 = z12;
                                    z5 = z11;
                                    z9 = z10;
                                }
                            }
                            synchronized (x.a) {
                                k();
                                l();
                            }
                            return;
                        }
                        if (runnable != null) {
                            break;
                        }
                        boolean z25 = z6;
                        if (z6) {
                            if (this.s.b()) {
                                synchronized (x.a) {
                                    this.j = true;
                                    x.a.notifyAll();
                                }
                                z25 = false;
                            } else {
                                synchronized (x.a) {
                                    this.j = true;
                                    this.f = true;
                                    x.a.notifyAll();
                                }
                            }
                        }
                        boolean z26 = z7;
                        if (z7) {
                            gl10 = (GL10) this.s.c();
                            x.a.a(gl10);
                            z26 = false;
                        }
                        boolean z27 = z5;
                        if (z5) {
                            x xVar2 = this.t.get();
                            if (xVar2 != null) {
                                xVar2.d.onSurfaceCreated(gl10, this.s.d);
                            }
                            z27 = false;
                        }
                        boolean z28 = z8;
                        if (z8) {
                            x xVar3 = this.t.get();
                            if (xVar3 != null) {
                                xVar3.d.onSurfaceChanged(gl10, i, i2);
                            }
                            z28 = false;
                        }
                        x xVar4 = this.t.get();
                        if (xVar4 != null) {
                            xVar4.d.onDrawFrame(gl10);
                        }
                        int d = this.s.d();
                        if (d != 12288) {
                            if (d != 12302) {
                                h.a("GLThread", "eglSwapBuffers", d);
                                synchronized (x.a) {
                                    this.f = true;
                                    x.a.notifyAll();
                                }
                            } else {
                                z2 = true;
                            }
                        }
                        if (z9) {
                            z3 = true;
                        }
                        z5 = z27;
                        z6 = z25;
                        z7 = z26;
                        z8 = z28;
                    } catch (Throwable th) {
                        synchronized (x.a) {
                            k();
                            l();
                            throw th;
                        }
                    }
                }
                runnable.run();
            }
        }

        private boolean n() {
            return this.h && this.i && o();
        }

        private boolean o() {
            if (this.d || !this.e || this.f || this.l <= 0 || this.m <= 0) {
                return false;
            }
            return this.o || this.n == 1;
        }

        public final int a() {
            int i;
            synchronized (x.a) {
                i = this.n;
            }
            return i;
        }

        public final void a(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (x.a) {
                this.n = i;
                x.a.notifyAll();
            }
        }

        public final void a(int i, int i2) {
            synchronized (x.a) {
                this.l = i;
                this.m = i2;
                this.r = true;
                this.o = true;
                this.p = false;
                x.a.notifyAll();
                while (!this.b && !this.d && !this.p && n()) {
                    try {
                        x.a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void a(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (x.a) {
                this.q.add(runnable);
                x.a.notifyAll();
            }
        }

        public final void b() {
            synchronized (x.a) {
                this.o = true;
                x.a.notifyAll();
            }
        }

        public final void c() {
            synchronized (x.a) {
                this.e = true;
                this.j = false;
                x.a.notifyAll();
                while (this.g && !this.j && !this.b) {
                    try {
                        x.a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void d() {
            synchronized (x.a) {
                this.e = false;
                x.a.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            x.a.wait();
                        } else {
                            x.a.wait(2000L);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void e() {
            synchronized (x.a) {
                this.c = true;
                x.a.notifyAll();
                while (!this.b && !this.d) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            x.a.wait();
                        } else {
                            x.a.wait(2000L);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void f() {
            synchronized (x.a) {
                this.c = false;
                this.o = true;
                this.p = false;
                x.a.notifyAll();
                while (!this.b && this.d && !this.p) {
                    try {
                        x.a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void g() {
            synchronized (x.a) {
                this.a = true;
                x.a.notifyAll();
                while (!this.b) {
                    try {
                        x.a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void h() {
            this.k = true;
            x.a.notifyAll();
        }

        public final int i() {
            int i;
            synchronized (x.a) {
                i = this.l;
            }
            return i;
        }

        public final int j() {
            int i;
            synchronized (x.a) {
                i = this.m;
            }
            return i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            setName("GLThread " + getId());
            try {
                m();
                x.a.a(this);
            } catch (InterruptedException e) {
                x.a.a(this);
            } catch (Throwable th) {
                x.a.a(this);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.x$j */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x$j.class */
    public static final class j {
        private static String a = "GLThreadManager";
        private boolean b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;
        private i g;

        private j() {
        }

        /* synthetic */ j(byte b) {
            this();
        }

        private void c() {
            if (this.b) {
                return;
            }
            this.c = 131072;
            this.e = true;
            this.b = true;
        }

        public final void a(i iVar) {
            synchronized (this) {
                i.a(iVar);
                if (this.g == iVar) {
                    this.g = null;
                }
                notifyAll();
            }
        }

        public final void a(GL10 gl10) {
            synchronized (this) {
                if (!this.d && gl10 != null) {
                    c();
                    String glGetString = gl10.glGetString(GL10.GL_RENDERER);
                    if (this.c < 131072) {
                        this.e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    boolean z = false;
                    if (!this.e) {
                        z = true;
                    }
                    this.f = z;
                    this.d = true;
                }
            }
        }

        public final boolean a() {
            boolean z;
            synchronized (this) {
                z = this.f;
            }
            return z;
        }

        public final boolean b() {
            boolean z;
            synchronized (this) {
                c();
                z = !this.e;
            }
            return z;
        }

        public final boolean b(i iVar) {
            i iVar2 = this.g;
            if (iVar2 == iVar || iVar2 == null) {
                this.g = iVar;
                notifyAll();
                return true;
            }
            c();
            if (this.e) {
                return true;
            }
            i iVar3 = this.g;
            if (iVar3 != null) {
                iVar3.h();
                return false;
            }
            return false;
        }

        public final void c(i iVar) {
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
        }
    }

    /* renamed from: com.amap.api.col.3sl.x$k */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x$k.class */
    public interface k {
        GL a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.x$l */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x$l.class */
    public static final class l extends Writer {
        private StringBuilder a = new StringBuilder();

        l() {
        }

        private void a() {
            if (this.a.length() > 0) {
                Log.v("GLSurfaceView", this.a.toString());
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            a();
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i, int i2) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i2) {
                    return;
                }
                char c = cArr[i + i4];
                if (c == '\n') {
                    a();
                } else {
                    this.a.append(c);
                }
                i3 = i4 + 1;
            }
        }
    }

    /* renamed from: com.amap.api.col.3sl.x$m */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/x$m.class */
    final class m extends b {
        public m() {
            super();
        }
    }

    public x(Context context) {
        super(context, null);
        this.b = new WeakReference<>(this);
        a();
    }

    private void a() {
        setSurfaceTextureListener(this);
    }

    private void e() {
        if (this.c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static boolean f() {
        return Build.VERSION.SDK_INT < 23;
    }

    public final void a(e eVar) {
        e();
        this.f = eVar;
    }

    public final void a(f fVar) {
        e();
        this.g = fVar;
    }

    public void b() {
        this.c.e();
    }

    public void c() {
        this.c.f();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.c != null) {
                this.c.g();
            }
        } finally {
            super.finalize();
        }
    }

    public int getRenderMode() {
        return this.c.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e && this.d != null) {
            i iVar = this.c;
            int a2 = iVar != null ? iVar.a() : 1;
            i iVar2 = new i(this.b);
            this.c = iVar2;
            if (a2 != 1) {
                iVar2.a(a2);
            }
            this.c.start();
        }
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        i iVar = this.c;
        if (iVar != null) {
            iVar.g();
        }
        this.e = true;
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i4 - i2, i5 - i3);
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.c.c();
        if (f() || MapsInitializer.getTextureSizeChangedInvoked()) {
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        } else if (this.c.i() == i2 && this.c.j() == i3) {
        } else {
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.c.d();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.c.a(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        this.c.a(runnable);
    }

    public void requestRender() {
        this.c.b();
    }

    public void setRenderMode(int i2) {
        this.c.a(i2);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        e();
        if (this.f == null) {
            this.f = new m();
        }
        if (this.g == null) {
            this.g = new c(this, (byte) 0);
        }
        if (this.h == null) {
            this.h = new d((byte) 0);
        }
        this.d = renderer;
        i iVar = new i(this.b);
        this.c = iVar;
        iVar.start();
    }
}
