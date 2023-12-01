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
    private static final GLThreadManager a = new GLThreadManager();
    private final WeakReference<GLTextureView> b;
    private GLThread c;
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
        protected int[] a;

        public BaseConfigChooser(int[] iArr) {
            this.a = a(iArr);
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

        abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$ComponentSizeChooser.class */
    public class ComponentSizeChooser extends BaseConfigChooser {
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        private int[] j;

        public ComponentSizeChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{EGL10.EGL_RED_SIZE, i, EGL10.EGL_GREEN_SIZE, i2, EGL10.EGL_BLUE_SIZE, i3, EGL10.EGL_ALPHA_SIZE, i4, EGL10.EGL_DEPTH_SIZE, i5, EGL10.EGL_STENCIL_SIZE, i6, EGL10.EGL_NONE});
            this.j = new int[1];
            this.c = i;
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
                int a = a(egl10, eGLDisplay, eGLConfig, EGL10.EGL_DEPTH_SIZE, 0);
                int a2 = a(egl10, eGLDisplay, eGLConfig, EGL10.EGL_STENCIL_SIZE, 0);
                if (a >= this.g && a2 >= this.h) {
                    int a3 = a(egl10, eGLDisplay, eGLConfig, EGL10.EGL_RED_SIZE, 0);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, EGL10.EGL_GREEN_SIZE, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, EGL10.EGL_BLUE_SIZE, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, EGL10.EGL_ALPHA_SIZE, 0);
                    if (a3 == this.c && a4 == this.d && a5 == this.e && a6 == this.f) {
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
            int[] iArr = {this.b, GLTextureView.this.k, EGL10.EGL_NONE};
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
        EGL10 a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<GLTextureView> f;

        public EglHelper(WeakReference<GLTextureView> weakReference) {
            this.f = weakReference;
        }

        private void a(String str) {
            a(str, this.a.eglGetError());
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
            EGLSurface eGLSurface = this.c;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            GLTextureView gLTextureView = this.f.get();
            if (gLTextureView != null) {
                gLTextureView.h.a(this.a, this.b, this.c);
            }
            this.c = null;
        }

        public void a() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
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
            GLTextureView gLTextureView = this.f.get();
            if (gLTextureView == null) {
                this.d = null;
                this.e = null;
            } else {
                this.d = gLTextureView.f.a(this.a, this.b);
                this.e = gLTextureView.g.a(this.a, this.b, this.d);
            }
            EGLContext eGLContext = this.e;
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                this.e = null;
                a("createContext");
            }
            Log.w("EglHelper", "createContext " + this.e + " tid=" + Thread.currentThread().getId());
            this.c = null;
        }

        public boolean b() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.a != null) {
                if (this.b != null) {
                    if (this.d != null) {
                        g();
                        GLTextureView gLTextureView = this.f.get();
                        if (gLTextureView != null) {
                            this.c = gLTextureView.h.a(this.a, this.b, this.d, gLTextureView.getSurfaceTexture());
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
            if (this.a.eglSwapBuffers(this.b, this.c)) {
                return 12288;
            }
            return this.a.eglGetError();
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
                    gLTextureView.g.a(this.a, this.b, this.e);
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
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$GLThread.class */
    public static class GLThread extends Thread {
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
                GLTextureView.a.c(this);
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
            synchronized (GLTextureView.a) {
                this.m = i;
                GLTextureView.a.notifyAll();
            }
        }

        public void a(int i, int i2) {
            synchronized (GLTextureView.a) {
                this.k = i;
                this.l = i2;
                this.q = true;
                this.n = true;
                this.o = false;
                GLTextureView.a.notifyAll();
                while (!this.b && !this.d && !this.o && a()) {
                    Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + getId());
                    try {
                        GLTextureView.a.wait();
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
            synchronized (GLTextureView.a) {
                i = this.m;
            }
            return i;
        }

        public void c() {
            synchronized (GLTextureView.a) {
                this.n = true;
                GLTextureView.a.notifyAll();
            }
        }

        public void d() {
            synchronized (GLTextureView.a) {
                Log.i("GLThread", "surfaceCreated tid=" + getId());
                this.e = true;
                GLTextureView.a.notifyAll();
                while (this.g && !this.b) {
                    try {
                        GLTextureView.a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (GLTextureView.a) {
                Log.i("GLThread", "surfaceDestroyed tid=" + getId());
                this.e = false;
                GLTextureView.a.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        GLTextureView.a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (GLTextureView.a) {
                Log.i("GLThread", "onPause tid=" + getId());
                this.c = true;
                GLTextureView.a.notifyAll();
                while (!this.b && !this.d) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        GLTextureView.a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (GLTextureView.a) {
                Log.i("GLThread", "onResume tid=" + getId());
                this.c = false;
                this.n = true;
                this.o = false;
                GLTextureView.a.notifyAll();
                while (!this.b && this.d && !this.o) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        GLTextureView.a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (GLTextureView.a) {
                this.a = true;
                GLTextureView.a.notifyAll();
                while (!this.b) {
                    try {
                        GLTextureView.a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void i() {
            this.j = true;
            GLTextureView.a.notifyAll();
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
                GLTextureView.a.a(this);
                throw th;
            }
            GLTextureView.a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/GLTextureView$GLThreadManager.class */
    public static class GLThreadManager {
        private static String a = "GLThreadManager";
        private boolean b;
        private int c;
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
                    Log.w(a, "checkGLDriver renderer = \"" + glGetString + "\" multipleContextsAllowed = " + this.e + " mLimitedGLESContexts = " + this.f);
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
        private StringBuilder a = new StringBuilder();

        LogWriter() {
        }

        private void a() {
            if (this.a.length() > 0) {
                Log.v("GLTextureView", this.a.toString());
                StringBuilder sb = this.a;
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
        if (this.c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void a() {
        this.c.g();
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser(new ComponentSizeChooser(i, i2, i3, i4, i5, i6));
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.c.e();
    }

    public void a(SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        this.c.a(i2, i3);
    }

    public void b() {
        this.c.f();
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.c.d();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.c != null) {
                this.c.h();
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
        return this.c.b();
    }

    public void j() {
        this.c.c();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("GLTextureView", "onAttachedToWindow reattach =" + this.e);
        if (this.e && this.d != null) {
            GLThread gLThread = this.c;
            int b = gLThread != null ? gLThread.b() : 1;
            GLThread gLThread2 = new GLThread(this.b);
            this.c = gLThread2;
            if (b != 1) {
                gLThread2.a(b);
            }
            this.c.start();
        }
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        Log.d("GLTextureView", "onDetachedFromWindow");
        GLThread gLThread = this.c;
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
        this.c.a(i);
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
        this.c = gLThread;
        gLThread.start();
    }
}
