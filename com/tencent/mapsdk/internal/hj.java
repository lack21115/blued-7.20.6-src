package com.tencent.mapsdk.internal;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj.class */
public class hj extends SurfaceView implements SurfaceHolder.Callback {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 60;
    private static final k F = new k();
    public static final String r = "tms-gl";
    private static final String s = "GLSurfaceView";
    private static final boolean t = false;
    private static final boolean u = false;
    private static final boolean v = false;
    private static final boolean w = false;
    private static final boolean x = false;
    private static final boolean y = true;
    private static final boolean z = false;
    private final WeakReference<hj> g;
    private j h;
    private n i;
    private boolean j;
    private f k;
    private g l;
    private h m;
    private l n;
    private int o;
    private int p;
    private boolean q;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$b.class */
    public abstract class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public int[] f37531a;

        public b(int[] iArr) {
            this.f37531a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (hj.this.p != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, i);
            iArr2[i] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        @Override // com.tencent.mapsdk.internal.hj.f
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f37531a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f37531a, eGLConfigArr, i, iArr)) {
                        EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a2 != null) {
                            return a2;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$c.class */
    public class c extends b {

        /* renamed from: c  reason: collision with root package name */
        private int[] f37532c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;

        public c(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.f37532c = new int[1];
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = i6;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f37532c) ? this.f37532c[0] : i2;
        }

        @Override // com.tencent.mapsdk.internal.hj.b
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            int length = eGLConfigArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                EGLConfig eGLConfig = eGLConfigArr[i2];
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a2 >= this.h && a3 >= this.i) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a4 == this.d && a5 == this.e && a6 == this.f && a7 == this.g) {
                        return eGLConfig;
                    }
                }
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$d.class */
    public class d implements g {

        /* renamed from: a  reason: collision with root package name */
        private int f37533a;

        private d() {
            this.f37533a = 12440;
        }

        @Override // com.tencent.mapsdk.internal.hj.g
        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f37533a, hj.this.p, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (hj.this.p == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.tencent.mapsdk.internal.hj.g
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            i.b("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$e.class */
    public static class e implements h {
        private e() {
        }

        @Override // com.tencent.mapsdk.internal.hj.h
        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e(hj.s, "eglCreateWindowSurface", e);
                return null;
            } catch (OutOfMemoryError e2) {
                return null;
            }
        }

        @Override // com.tencent.mapsdk.internal.hj.h
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$f.class */
    public interface f {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$g.class */
    public interface g {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$h.class */
    public interface h {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$i.class */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<hj> f37534a;
        public EGL10 b;

        /* renamed from: c  reason: collision with root package name */
        public EGLDisplay f37535c;
        public EGLSurface d;
        public EGLConfig e;
        public EGLContext f;

        public i(WeakReference<hj> weakReference) {
            this.f37534a = weakReference;
        }

        public static String a(String str, int i) {
            return str + " failed: ";
        }

        private void a(String str) {
            b(str, this.b.eglGetError());
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, a(str2, i));
        }

        public static void b(String str, int i) {
            throw new RuntimeException(a(str, i));
        }

        private void d() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.b.eglMakeCurrent(this.f37535c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            hj hjVar = this.f37534a.get();
            if (hjVar != null) {
                hjVar.m.a(this.b, this.f37535c, this.d);
            }
            this.d = null;
        }

        public GL a() {
            GL gl = this.f.getGL();
            hj hjVar = this.f37534a.get();
            GL gl2 = gl;
            if (hjVar != null) {
                GL gl3 = gl;
                if (hjVar.n != null) {
                    gl3 = hjVar.n.a(gl);
                }
                gl2 = gl3;
                if ((hjVar.o & 3) != 0) {
                    int i = 0;
                    m mVar = null;
                    if ((hjVar.o & 1) != 0) {
                        i = 1;
                    }
                    if ((hjVar.o & 2) != 0) {
                        mVar = new m();
                    }
                    gl2 = GLDebugHelper.wrap(gl3, i, mVar);
                }
            }
            return gl2;
        }

        public boolean b() {
            if (this.b != null) {
                if (this.f37535c != null) {
                    if (this.e != null) {
                        d();
                        hj hjVar = this.f37534a.get();
                        if (hjVar != null) {
                            this.d = hjVar.m.a(this.b, this.f37535c, this.e, hjVar.getHolder());
                        } else {
                            this.d = null;
                        }
                        EGLSurface eGLSurface = this.d;
                        if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                            if (this.b.eglGetError() == 12299) {
                                Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                                return false;
                            }
                            return false;
                        } else if (this.b.eglMakeCurrent(this.f37535c, eGLSurface, eGLSurface, this.f)) {
                            return true;
                        } else {
                            a("EGLHelper", "eglMakeCurrent", this.b.eglGetError());
                            return false;
                        }
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public void c() {
            d();
        }

        public void e() {
            if (this.f != null) {
                hj hjVar = this.f37534a.get();
                if (hjVar != null) {
                    hjVar.l.a(this.b, this.f37535c, this.f);
                }
                this.f = null;
            }
            EGLDisplay eGLDisplay = this.f37535c;
            if (eGLDisplay != null) {
                this.b.eglTerminate(eGLDisplay);
                this.f37535c = null;
            }
        }

        public void f() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.b = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f37535c = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.b.eglInitialize(eglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            hj hjVar = this.f37534a.get();
            if (hjVar == null) {
                this.e = null;
                this.f = null;
            } else {
                this.e = hjVar.k.a(this.b, this.f37535c);
                this.f = hjVar.l.a(this.b, this.f37535c, this.e);
            }
            EGLContext eGLContext = this.f;
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                this.f = null;
                a("createContext");
            }
            this.d = null;
        }

        public int g() {
            if (this.b.eglSwapBuffers(this.f37535c, this.d)) {
                return 12288;
            }
            return this.b.eglGetError();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$j.class */
    public static class j extends Thread {
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f37536c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;
        private boolean r;
        private i v;
        private WeakReference<hj> w;
        private ArrayList<Runnable> s = new ArrayList<>();
        private boolean t = true;
        private float u = 60.0f;
        private int n = 0;
        private int o = 0;
        private boolean q = true;
        private int p = 1;

        public j(WeakReference<hj> weakReference) {
            this.w = weakReference;
            setName(hj.c("SV"));
        }

        private void c() throws InterruptedException {
            boolean z;
            boolean z2;
            int i;
            boolean z3;
            this.v = new i(this.w);
            this.j = false;
            this.k = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            GL10 gl10 = null;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            int i2 = 0;
            int i3 = 0;
            Runnable runnable = null;
            boolean z11 = false;
            loop0: while (true) {
                try {
                    try {
                        synchronized (hj.F) {
                            boolean z12 = z11;
                            boolean z13 = z7;
                            boolean z14 = z6;
                            boolean z15 = z4;
                            while (!this.f37536c) {
                                if (this.s.isEmpty()) {
                                    boolean z16 = this.f;
                                    boolean z17 = this.e;
                                    if (z16 != z17) {
                                        this.f = z17;
                                        hj.F.notifyAll();
                                    } else {
                                        z17 = false;
                                    }
                                    boolean z18 = z14;
                                    if (this.m) {
                                        k();
                                        j();
                                        this.m = false;
                                        z18 = true;
                                    }
                                    boolean z19 = z15;
                                    if (z15) {
                                        k();
                                        j();
                                        z19 = false;
                                    }
                                    if (z17 && this.k) {
                                        k();
                                    }
                                    if (z17 && this.j) {
                                        hj hjVar = this.w.get();
                                        if (!(hjVar != null && hjVar.q) || hj.F.b()) {
                                            j();
                                        }
                                    }
                                    if (z17 && hj.F.c()) {
                                        this.v.e();
                                    }
                                    if (!this.g && !this.i) {
                                        if (this.k) {
                                            k();
                                        }
                                        this.i = true;
                                        this.h = false;
                                        hj.F.notifyAll();
                                    }
                                    if (this.g && this.i) {
                                        this.i = false;
                                        hj.F.notifyAll();
                                    }
                                    boolean z20 = z5;
                                    if (z5) {
                                        this.r = true;
                                        hj.F.notifyAll();
                                        z20 = false;
                                        z12 = false;
                                    }
                                    boolean z21 = z18;
                                    boolean z22 = z13;
                                    boolean z23 = z8;
                                    boolean z24 = z9;
                                    boolean z25 = z10;
                                    if (f()) {
                                        boolean z26 = z18;
                                        z7 = z13;
                                        if (!this.j) {
                                            if (z18) {
                                                z26 = false;
                                                z7 = z13;
                                            } else {
                                                z26 = z18;
                                                z7 = z13;
                                                if (hj.F.c(this)) {
                                                    try {
                                                        this.v.f();
                                                    } catch (RuntimeException e) {
                                                        hj.F.a(this);
                                                    }
                                                    this.j = true;
                                                    hj.F.notifyAll();
                                                    z7 = true;
                                                    z26 = z18;
                                                }
                                            }
                                        }
                                        boolean z27 = z8;
                                        boolean z28 = z9;
                                        boolean z29 = z10;
                                        if (this.j) {
                                            z27 = z8;
                                            z28 = z9;
                                            z29 = z10;
                                            if (!this.k) {
                                                this.k = true;
                                                z27 = true;
                                                z28 = true;
                                                z29 = true;
                                            }
                                        }
                                        z21 = z26;
                                        z22 = z7;
                                        z23 = z27;
                                        z24 = z28;
                                        z25 = z29;
                                        if (this.k) {
                                            if (this.t) {
                                                i2 = this.n;
                                                i3 = this.o;
                                                this.t = false;
                                                z3 = true;
                                                z8 = true;
                                                z11 = true;
                                            } else {
                                                z3 = false;
                                                z8 = z27;
                                                z11 = z12;
                                            }
                                            this.q = false;
                                            hj.F.notifyAll();
                                            i = i3;
                                            z9 = z28;
                                            z6 = z26;
                                            z5 = z20;
                                            z2 = z19;
                                            z = z3;
                                        }
                                    }
                                    hj.F.wait();
                                    z15 = z19;
                                    z5 = z20;
                                    z14 = z21;
                                    z13 = z22;
                                    z8 = z23;
                                    z9 = z24;
                                    z10 = z25;
                                } else {
                                    runnable = this.s.remove(0);
                                    z = z10;
                                    z2 = z15;
                                    z6 = z14;
                                    z7 = z13;
                                    i = i3;
                                    z11 = z12;
                                }
                            }
                            break loop0;
                        }
                        if (runnable != null) {
                            runnable.run();
                            boolean z30 = z;
                            runnable = null;
                            z4 = z2;
                            z10 = z30;
                            i3 = i;
                        } else {
                            boolean z31 = z8;
                            if (z8) {
                                if (this.v.b()) {
                                    synchronized (hj.F) {
                                        this.l = true;
                                        hj.F.notifyAll();
                                    }
                                    z31 = false;
                                } else {
                                    synchronized (hj.F) {
                                        this.l = true;
                                        this.h = true;
                                        hj.F.notifyAll();
                                    }
                                    z31 = z8;
                                    boolean z32 = z;
                                    z4 = z2;
                                    z8 = z31;
                                    z10 = z32;
                                    i3 = i;
                                }
                            }
                            boolean z33 = z9;
                            if (z9) {
                                gl10 = (GL10) this.v.a();
                                hj.F.a(gl10);
                                z33 = false;
                            }
                            boolean z34 = z7;
                            if (z7) {
                                hj hjVar2 = this.w.get();
                                if (hjVar2 != null) {
                                    hjVar2.i.a(gl10, this.v.e);
                                }
                                z34 = false;
                            }
                            if (z) {
                                hj hjVar3 = this.w.get();
                                if (hjVar3 != null) {
                                    hjVar3.i.a(gl10, i2, i);
                                }
                                z = false;
                            }
                            if (this.b != 0) {
                                System.currentTimeMillis();
                            }
                            this.b = System.currentTimeMillis();
                            long currentTimeMillis = System.currentTimeMillis();
                            hj hjVar4 = this.w.get();
                            boolean a2 = hjVar4 != null ? hjVar4.i.a(gl10) : false;
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (a2) {
                                int g = this.v.g();
                                if (g != 12288) {
                                    if (g != 12302) {
                                        i.a(hj.r, "eglSwapBuffers", g);
                                        synchronized (hj.F) {
                                            this.h = true;
                                            hj.F.notifyAll();
                                        }
                                    } else {
                                        z2 = true;
                                    }
                                }
                            }
                            if (z11) {
                                z5 = true;
                            }
                            int i4 = (int) ((1000.0f / this.u) - ((float) (currentTimeMillis2 - currentTimeMillis)));
                            if (i4 > 0) {
                                synchronized (this) {
                                    try {
                                        wait(i4);
                                    } catch (InterruptedException e2) {
                                    }
                                }
                            }
                            z7 = z34;
                            z9 = z33;
                            boolean z322 = z;
                            z4 = z2;
                            z8 = z31;
                            z10 = z322;
                            i3 = i;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        synchronized (hj.F) {
                            k();
                            j();
                            return;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (hj.F) {
                        k();
                        j();
                        throw th;
                    }
                }
            }
            hj hjVar5 = this.w.get();
            if (hjVar5 != null) {
                hjVar5.i.x();
            }
            synchronized (hj.F) {
                k();
                j();
            }
        }

        private boolean f() {
            boolean z = true;
            if (!this.f && this.g && !this.h && this.n > 0 && this.o > 0) {
                if (!this.q) {
                    if (this.p == 1) {
                        return true;
                    }
                }
                return z;
            }
            z = false;
            return z;
        }

        private void j() {
            if (this.j) {
                this.v.e();
                this.j = false;
                hj.F.a(this);
            }
        }

        private void k() {
            if (this.k) {
                this.k = false;
                this.v.c();
            }
        }

        public void a(float f) {
            if (f <= 1.0f) {
                na.b(ma.l, "帧率设置不在有效值范围内");
            } else {
                this.u = f;
            }
        }

        public void a(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (hj.F) {
                this.p = i;
                hj.F.notifyAll();
            }
        }

        public void a(int i, int i2) {
            synchronized (hj.F) {
                if (this.n == i && this.o == i2) {
                    this.t = false;
                    hj.F.notifyAll();
                    return;
                }
                this.n = i;
                this.o = i2;
                this.t = true;
                this.q = true;
                this.r = false;
                hj.F.notifyAll();
                while (!this.d && !this.f && !this.r && a()) {
                    try {
                        hj.F.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (hj.F) {
                this.s.add(runnable);
                hj.F.notifyAll();
            }
        }

        public boolean a() {
            return this.j && this.k && f();
        }

        public int b() {
            int i;
            synchronized (hj.F) {
                i = this.p;
            }
            return i;
        }

        public void d() {
            synchronized (hj.F) {
                this.e = true;
                hj.F.notifyAll();
                while (!this.d && !this.f) {
                    try {
                        hj.F.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (hj.F) {
                this.e = false;
                this.q = true;
                this.r = false;
                hj.F.notifyAll();
                while (!this.d && this.f && !this.r) {
                    try {
                        hj.F.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (hj.F) {
                this.f37536c = true;
                hj.F.notifyAll();
                while (!this.d) {
                    try {
                        hj.F.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (hj.F) {
                this.m = true;
                hj.F.notifyAll();
            }
        }

        public void i() {
            synchronized (hj.F) {
                this.q = true;
                hj.F.notifyAll();
            }
        }

        public void l() {
            synchronized (hj.F) {
                this.g = true;
                this.l = false;
                hj.F.notifyAll();
                while (this.i && !this.l && !this.d) {
                    try {
                        hj.F.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void m() {
            synchronized (hj.F) {
                this.g = false;
                hj.F.notifyAll();
                while (!this.i && !this.d) {
                    try {
                        hj.F.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                try {
                    c();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                hj.F.b(this);
            } catch (Throwable th) {
                hj.F.b(this);
                throw th;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$k.class */
    public static class k {
        private static String g = "GLThreadManager";
        private static final int h = 131072;
        private static final String i = "Q3Dimension MSM7500 ";

        /* renamed from: a  reason: collision with root package name */
        private boolean f37537a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f37538c;
        private boolean d;
        private boolean e;
        private j f;

        private k() {
        }

        private void a() {
            if (this.f37537a) {
                return;
            }
            this.b = 131072;
            this.d = true;
            this.f37537a = true;
        }

        public void a(j jVar) {
            synchronized (this) {
                if (this.f == jVar) {
                    this.f = null;
                }
                notifyAll();
            }
        }

        public void a(GL10 gl10) {
            synchronized (this) {
                if (!this.f37538c) {
                    a();
                    String glGetString = gl10.glGetString(7937);
                    if (this.b < 131072) {
                        this.d = !glGetString.startsWith(i);
                        notifyAll();
                    }
                    this.e = !this.d;
                    this.f37538c = true;
                }
            }
        }

        public void b(j jVar) {
            synchronized (this) {
                jVar.d = true;
                if (this.f == jVar) {
                    this.f = null;
                }
                notifyAll();
            }
        }

        public boolean b() {
            boolean z;
            synchronized (this) {
                z = this.e;
            }
            return z;
        }

        public boolean c() {
            boolean z;
            synchronized (this) {
                a();
                z = this.d;
            }
            return !z;
        }

        public boolean c(j jVar) {
            synchronized (this) {
                j jVar2 = this.f;
                if (jVar2 == jVar || jVar2 == null) {
                    this.f = jVar;
                    notifyAll();
                    return true;
                }
                a();
                if (this.d) {
                    return true;
                }
                j jVar3 = this.f;
                if (jVar3 != null) {
                    jVar3.h();
                }
                return false;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$l.class */
    public interface l {
        GL a(GL gl);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$m.class */
    public static class m extends Writer {
        private StringBuilder b = new StringBuilder();

        private void a() {
            if (this.b.length() > 0) {
                Log.v(hj.s, this.b.toString());
                StringBuilder sb = this.b;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i2) {
                    return;
                }
                char c2 = cArr[i + i4];
                if (c2 == '\n') {
                    a();
                } else {
                    this.b.append(c2);
                }
                i3 = i4 + 1;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$n.class */
    public interface n {
        void a(GL10 gl10, int i, int i2);

        void a(GL10 gl10, EGLConfig eGLConfig);

        boolean a(GL10 gl10);

        void x();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hj$o.class */
    public class o extends c {
        public o(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public hj(Context context) {
        super(context);
        this.g = new WeakReference<>(this);
        R();
    }

    public hj(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new WeakReference<>(this);
        R();
    }

    private void Q() {
        if (this.h != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void R() {
        getHolder().addCallback(this);
    }

    public static String c(String str) {
        return "tms-gl." + str + ".1fb4e69";
    }

    public void a() {
        this.h.i();
    }

    public void a(float f2) {
        j jVar = this.h;
        if (jVar != null) {
            jVar.a(f2);
            this.h.i();
        }
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new c(i2, i3, i4, i5, i6, i7));
    }

    public void a(n nVar, float f2) {
        Q();
        if (this.k == null) {
            this.k = new o(true);
        }
        if (this.l == null) {
            this.l = new d();
        }
        if (this.m == null) {
            this.m = new e();
        }
        this.i = nVar;
        j jVar = new j(this.g);
        this.h = jVar;
        jVar.a(f2);
        this.h.start();
    }

    public void a(Runnable runnable) {
        this.h.a(runnable);
    }

    public void finalize() throws Throwable {
        try {
            j jVar = this.h;
            if (jVar != null) {
                jVar.g();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.o;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.q;
    }

    public int getRenderMode() {
        return this.h.b();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.j) {
            this.h.e();
        }
        this.j = false;
    }

    public void onDestroy() {
        j jVar = this.h;
        if (jVar != null) {
            jVar.g();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        j jVar = this.h;
        if (jVar != null) {
            jVar.d();
        }
        this.j = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        this.h.d();
    }

    public void onResume() {
        this.h.e();
    }

    public void setDebugFlags(int i2) {
        this.o = i2;
    }

    public void setEGLConfigChooser(f fVar) {
        Q();
        this.k = fVar;
    }

    public void setEGLConfigChooser(boolean z2) {
        setEGLConfigChooser(new o(z2));
    }

    public void setEGLContextClientVersion(int i2) {
        Q();
        this.p = i2;
    }

    public void setEGLContextFactory(g gVar) {
        Q();
        this.l = gVar;
    }

    public void setEGLWindowSurfaceFactory(h hVar) {
        Q();
        this.m = hVar;
    }

    public void setGLWrapper(l lVar) {
        this.n = lVar;
    }

    public void setPreserveEGLContextOnPause(boolean z2) {
        this.q = z2;
    }

    public void setRenderMode(int i2) {
        this.h.a(i2);
    }

    public void setRenderer(n nVar) {
        a(nVar, 60.0f);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.h.a(i3, i4);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.h.l();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.h.m();
    }
}
