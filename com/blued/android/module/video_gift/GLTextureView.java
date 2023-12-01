package com.blued.android.module.video_gift;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView.class */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private static final GLThreadManager f16085a = new GLThreadManager();
    private final WeakReference<GLTextureView> b;

    /* renamed from: c  reason: collision with root package name */
    private GLThread f16086c;
    private Renderer d;
    private boolean e;
    private EGLConfigChooser f;
    private EGLContextFactory g;
    private EGLWindowSurfaceFactory h;
    private GLWrapper i;
    private int j;
    private int k;
    private boolean l;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$BaseConfigChooser.class */
    abstract class BaseConfigChooser implements EGLConfigChooser {

        /* renamed from: a  reason: collision with root package name */
        protected int[] f16087a;

        public BaseConfigChooser(int[] iArr) {
            this.f16087a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (GLTextureView.this.k != 2) {
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

        @Override // com.blued.android.module.video_gift.GLTextureView.EGLConfigChooser
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f16087a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f16087a, eGLConfigArr, i, iArr)) {
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

        abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$ComponentSizeChooser.class */
    public class ComponentSizeChooser extends BaseConfigChooser {

        /* renamed from: c  reason: collision with root package name */
        protected int f16088c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        private int[] j;

        public ComponentSizeChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.j = new int[1];
            this.f16088c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.j) ? this.j[0] : i2;
        }

        @Override // com.blued.android.module.video_gift.GLTextureView.BaseConfigChooser
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
                if (a2 >= this.g && a3 >= this.h) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a4 == this.f16088c && a5 == this.d && a6 == this.e && a7 == this.f) {
                        return eGLConfig;
                    }
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$DefaultContextFactory.class */
    public class DefaultContextFactory implements EGLContextFactory {
        private int b;

        private DefaultContextFactory() {
            this.b = 12440;
        }

        @Override // com.blued.android.module.video_gift.GLTextureView.EGLContextFactory
        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.b, GLTextureView.this.k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.blued.android.module.video_gift.GLTextureView.EGLContextFactory
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            StringBuilder sb = new StringBuilder();
            sb.append("tid=");
            sb.append(Thread.currentThread().getId());
            Log.i("DefaultContextFactory", sb.toString());
            EglHelper.a("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$DefaultWindowSurfaceFactory.class */
    public static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        @Override // com.blued.android.module.video_gift.GLTextureView.EGLWindowSurfaceFactory
        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.blued.android.module.video_gift.GLTextureView.EGLWindowSurfaceFactory
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$EGLConfigChooser.class */
    public interface EGLConfigChooser {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$EGLContextFactory.class */
    public interface EGLContextFactory {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$EGLWindowSurfaceFactory.class */
    public interface EGLWindowSurfaceFactory {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$EglHelper.class */
    public static class EglHelper {

        /* renamed from: a  reason: collision with root package name */
        EGL10 f16090a;
        EGLDisplay b;

        /* renamed from: c  reason: collision with root package name */
        EGLSurface f16091c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<GLTextureView> f;

        public EglHelper(WeakReference<GLTextureView> weakReference) {
            this.f = weakReference;
        }

        private void a(String str) {
            a(str, this.f16090a.eglGetError());
        }

        public static void a(String str, int i) {
            String b = b(str, i);
            Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + b);
            throw new RuntimeException(b);
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, b(str2, i));
        }

        public static String b(String str, int i) {
            return str + " failed: " + i;
        }

        private void g() {
            EGLSurface eGLSurface = this.f16091c;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.f16090a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            GLTextureView gLTextureView = this.f.get();
            if (gLTextureView != null) {
                gLTextureView.h.a(this.f16090a, this.b, this.f16091c);
            }
            this.f16091c = null;
        }

        public void a() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f16090a = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.b = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.f16090a.eglInitialize(this.b, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            GLTextureView gLTextureView = this.f.get();
            if (gLTextureView == null) {
                this.d = null;
                this.e = null;
            } else {
                this.d = gLTextureView.f.a(this.f16090a, this.b);
                this.e = gLTextureView.g.a(this.f16090a, this.b, this.d);
            }
            EGLContext eGLContext = this.e;
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                this.e = null;
                a("createContext");
            }
            Log.w("EglHelper", "createContext " + this.e + " tid=" + Thread.currentThread().getId());
            this.f16091c = null;
        }

        public boolean b() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.f16090a != null) {
                if (this.b != null) {
                    if (this.d != null) {
                        g();
                        GLTextureView gLTextureView = this.f.get();
                        if (gLTextureView != null) {
                            this.f16091c = gLTextureView.h.a(this.f16090a, this.b, this.d, gLTextureView.getSurfaceTexture());
                        } else {
                            this.f16091c = null;
                        }
                        EGLSurface eGLSurface = this.f16091c;
                        if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                            if (this.f16090a.eglGetError() == 12299) {
                                Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                                return false;
                            }
                            return false;
                        }
                        EGL10 egl10 = this.f16090a;
                        EGLDisplay eGLDisplay = this.b;
                        EGLSurface eGLSurface2 = this.f16091c;
                        if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.e)) {
                            return true;
                        }
                        a("EGLHelper", "eglMakeCurrent", this.f16090a.eglGetError());
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        GL c() {
            GL gl = this.e.getGL();
            GLTextureView gLTextureView = this.f.get();
            GL gl2 = gl;
            if (gLTextureView != null) {
                GL gl3 = gl;
                if (gLTextureView.i != null) {
                    gl3 = gLTextureView.i.a(gl);
                }
                gl2 = gl3;
                if ((gLTextureView.j & 3) != 0) {
                    int i = 0;
                    LogWriter logWriter = null;
                    if ((gLTextureView.j & 1) != 0) {
                        i = 1;
                    }
                    if ((gLTextureView.j & 2) != 0) {
                        logWriter = new LogWriter();
                    }
                    gl2 = GLDebugHelper.wrap(gl3, i, logWriter);
                }
            }
            return gl2;
        }

        public int d() {
            if (this.f16090a.eglSwapBuffers(this.b, this.f16091c)) {
                return 12288;
            }
            return this.f16090a.eglGetError();
        }

        public void e() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            g();
        }

        public void f() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.e != null) {
                GLTextureView gLTextureView = this.f.get();
                if (gLTextureView != null) {
                    gLTextureView.g.a(this.f16090a, this.b, this.e);
                }
                this.e = null;
            }
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay != null) {
                this.f16090a.eglTerminate(eGLDisplay);
                this.b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$GLThread.class */
    public static class GLThread extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private boolean f16092a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f16093c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean o;
        private EglHelper r;
        private WeakReference<GLTextureView> s;
        private ArrayList<Runnable> p = new ArrayList<>();
        private boolean q = true;
        private int k = 0;
        private int l = 0;
        private boolean n = true;
        private int m = 1;

        GLThread(WeakReference<GLTextureView> weakReference) {
            this.s = weakReference;
        }

        private void j() {
            if (this.i) {
                this.i = false;
                this.r.e();
            }
        }

        private void k() {
            if (this.h) {
                this.r.f();
                this.h = false;
                GLTextureView.f16085a.c(this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:263:0x0762 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:243:0x0753 -> B:237:0x0748). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void l() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 1938
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.video_gift.GLTextureView.GLThread.l():void");
        }

        private boolean m() {
            boolean z = true;
            if (!this.d && this.e && !this.f && this.k > 0 && this.l > 0) {
                if (!this.n) {
                    if (this.m == 1) {
                        return true;
                    }
                }
                return z;
            }
            z = false;
            return z;
        }

        public void a(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (GLTextureView.f16085a) {
                this.m = i;
                GLTextureView.f16085a.notifyAll();
            }
        }

        public void a(int i, int i2) {
            synchronized (GLTextureView.f16085a) {
                this.k = i;
                this.l = i2;
                this.q = true;
                this.n = true;
                this.o = false;
                GLTextureView.f16085a.notifyAll();
                while (!this.b && !this.d && !this.o && a()) {
                    Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + getId());
                    try {
                        GLTextureView.f16085a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public boolean a() {
            return this.h && this.i && m();
        }

        public int b() {
            int i;
            synchronized (GLTextureView.f16085a) {
                i = this.m;
            }
            return i;
        }

        public void c() {
            synchronized (GLTextureView.f16085a) {
                this.n = true;
                GLTextureView.f16085a.notifyAll();
            }
        }

        public void d() {
            synchronized (GLTextureView.f16085a) {
                Log.i("GLThread", "surfaceCreated tid=" + getId());
                this.e = true;
                GLTextureView.f16085a.notifyAll();
                while (this.g && !this.b) {
                    try {
                        GLTextureView.f16085a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (GLTextureView.f16085a) {
                Log.i("GLThread", "surfaceDestroyed tid=" + getId());
                this.e = false;
                GLTextureView.f16085a.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        GLTextureView.f16085a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (GLTextureView.f16085a) {
                Log.i("GLThread", "onPause tid=" + getId());
                this.f16093c = true;
                GLTextureView.f16085a.notifyAll();
                while (!this.b && !this.d) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        GLTextureView.f16085a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (GLTextureView.f16085a) {
                Log.i("GLThread", "onResume tid=" + getId());
                this.f16093c = false;
                this.n = true;
                this.o = false;
                GLTextureView.f16085a.notifyAll();
                while (!this.b && this.d && !this.o) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        GLTextureView.f16085a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (GLTextureView.f16085a) {
                this.f16092a = true;
                GLTextureView.f16085a.notifyAll();
                while (!this.b) {
                    try {
                        GLTextureView.f16085a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void i() {
            this.j = true;
            GLTextureView.f16085a.notifyAll();
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x005a -> B:4:0x0048). Please submit an issue!!! */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            Log.i("GLThread", "starting tid=" + getId());
            try {
                l();
            } catch (InterruptedException e) {
            } catch (Throwable th) {
                GLTextureView.f16085a.a(this);
                throw th;
            }
            GLTextureView.f16085a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$GLThreadManager.class */
    public static class GLThreadManager {

        /* renamed from: a  reason: collision with root package name */
        private static String f16094a = "GLThreadManager";
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private int f16095c;
        private boolean d;
        private boolean e;
        private boolean f;
        private GLThread g;

        private GLThreadManager() {
        }

        private void c() {
            if (this.b) {
                return;
            }
            this.b = true;
        }

        public void a(GLThread gLThread) {
            synchronized (this) {
                Log.i("GLThread", "exiting tid=" + gLThread.getId());
                gLThread.b = true;
                if (this.g == gLThread) {
                    this.g = null;
                }
                notifyAll();
            }
        }

        public void a(GL10 gl10) {
            synchronized (this) {
                if (!this.d) {
                    c();
                    String glGetString = gl10.glGetString(7937);
                    if (this.f16095c < 131072) {
                        this.e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    boolean z = false;
                    if (!this.e) {
                        z = true;
                    }
                    this.f = z;
                    Log.w(f16094a, "checkGLDriver renderer = \"" + glGetString + "\" multipleContextsAllowed = " + this.e + " mLimitedGLESContexts = " + this.f);
                    this.d = true;
                }
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this) {
                z = this.f;
            }
            return z;
        }

        public boolean b() {
            boolean z;
            synchronized (this) {
                c();
                z = this.e;
            }
            return !z;
        }

        public boolean b(GLThread gLThread) {
            GLThread gLThread2 = this.g;
            if (gLThread2 == gLThread || gLThread2 == null) {
                this.g = gLThread;
                notifyAll();
                return true;
            }
            c();
            if (this.e) {
                return true;
            }
            GLThread gLThread3 = this.g;
            if (gLThread3 != null) {
                gLThread3.i();
                return false;
            }
            return false;
        }

        public void c(GLThread gLThread) {
            if (this.g == gLThread) {
                this.g = null;
            }
            notifyAll();
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$GLWrapper.class */
    public interface GLWrapper {
        GL a(GL gl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$LogWriter.class */
    public static class LogWriter extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private StringBuilder f16096a = new StringBuilder();

        LogWriter() {
        }

        private void a() {
            if (this.f16096a.length() > 0) {
                Log.v("GLTextureView", this.f16096a.toString());
                StringBuilder sb = this.f16096a;
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
                    this.f16096a.append(c2);
                }
                i3 = i4 + 1;
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$Renderer.class */
    public interface Renderer {
        void a(GL10 gl10);

        void a(GL10 gl10, int i, int i2);

        void a(GL10 gl10, EGLConfig eGLConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$SimpleEGLConfigChooser.class */
    public class SimpleEGLConfigChooser extends ComponentSizeChooser {
        public SimpleEGLConfigChooser(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new WeakReference<>(this);
        c();
    }

    private void c() {
        setSurfaceTextureListener(this);
    }

    private void d() {
        if (this.f16086c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void a() {
        this.f16086c.g();
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser(new ComponentSizeChooser(i, i2, i3, i4, i5, i6));
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.f16086c.e();
    }

    public void a(SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        this.f16086c.a(i2, i3);
    }

    public void b() {
        this.f16086c.f();
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.f16086c.d();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.f16086c != null) {
                this.f16086c.h();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.j;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.l;
    }

    public int getRenderMode() {
        return this.f16086c.b();
    }

    public void j() {
        this.f16086c.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("GLTextureView", "onAttachedToWindow reattach =" + this.e);
        if (this.e && this.d != null) {
            GLThread gLThread = this.f16086c;
            int b = gLThread != null ? gLThread.b() : 1;
            GLThread gLThread2 = new GLThread(this.b);
            this.f16086c = gLThread2;
            if (b != 1) {
                gLThread2.a(b);
            }
            this.f16086c.start();
        }
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        Log.d("GLTextureView", "onDetachedFromWindow");
        GLThread gLThread = this.f16086c;
        if (gLThread != null) {
            gLThread.h();
        }
        this.e = true;
        super.onDetachedFromWindow();
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        a(getSurfaceTexture(), 0, i3 - i, i4 - i2);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        b(surfaceTexture);
        a(surfaceTexture, 0, i, i2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        a(surfaceTexture);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        a(surfaceTexture, 0, i, i2);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        j();
    }

    public void setDebugFlags(int i) {
        this.j = i;
    }

    public void setEGLConfigChooser(EGLConfigChooser eGLConfigChooser) {
        d();
        this.f = eGLConfigChooser;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new SimpleEGLConfigChooser(z));
    }

    public void setEGLContextClientVersion(int i) {
        d();
        this.k = i;
    }

    public void setEGLContextFactory(EGLContextFactory eGLContextFactory) {
        d();
        this.g = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        d();
        this.h = eGLWindowSurfaceFactory;
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.i = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.l = z;
    }

    public void setRenderMode(int i) {
        this.f16086c.a(i);
    }

    public void setRenderer(Renderer renderer) {
        d();
        if (this.f == null) {
            this.f = new SimpleEGLConfigChooser(true);
        }
        if (this.g == null) {
            this.g = new DefaultContextFactory();
        }
        if (this.h == null) {
            this.h = new DefaultWindowSurfaceFactory();
        }
        this.d = renderer;
        GLThread gLThread = new GLThread(this.b);
        this.f16086c = gLThread;
        gLThread.start();
    }
}
