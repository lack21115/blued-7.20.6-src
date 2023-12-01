package com.amap.api.col.p0003sl;

import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* renamed from: com.amap.api.col.3sl.di  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/di.class */
public final class di {

    /* renamed from: com.amap.api.col.3sl.di$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/di$a.class */
    public static final class a extends dg {
        private static int g = 4;
        private int[] h = new int[1];

        /* renamed from: a  reason: collision with root package name */
        protected int f4851a = 5;
        protected int b = 6;

        /* renamed from: c  reason: collision with root package name */
        protected int f4852c = 5;
        protected int d = 0;
        protected int e = 16;
        protected int f = 8;

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.h)) {
                return this.h[0];
            }
            return 0;
        }

        private c a(EGL10 egl10, EGLDisplay eGLDisplay) {
            c cVar = new c((byte) 0);
            cVar.f4853a = a(true);
            egl10.eglChooseConfig(eGLDisplay, cVar.f4853a, null, 0, cVar.b);
            if (cVar.b[0] <= 0) {
                cVar.f4853a = a(false);
                egl10.eglChooseConfig(eGLDisplay, cVar.f4853a, null, 0, cVar.b);
                if (cVar.b[0] <= 0) {
                    return null;
                }
            }
            return cVar;
        }

        private EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            int length = eGLConfigArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                EGLConfig eGLConfig = eGLConfigArr[i2];
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a2 >= this.e && a3 >= this.f) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a4 == this.f4851a && a5 == this.b && a6 == this.f4852c && a7 == this.d) {
                        return eGLConfig;
                    }
                }
                i = i2 + 1;
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        private int[] a(boolean z) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        @Override // com.amap.api.col.p0003sl.dg, android.opengl.GLSurfaceView.EGLConfigChooser
        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            c a2 = a(egl10, eGLDisplay);
            if (a2 == null || a2.f4853a == null) {
                return null;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[a2.b[0]];
            egl10.eglChooseConfig(eGLDisplay, a2.f4853a, eGLConfigArr, a2.b[0], a2.b);
            EGLConfig a3 = a(egl10, eGLDisplay, eGLConfigArr);
            EGLConfig eGLConfig = a3;
            if (a3 == null) {
                this.f4851a = 8;
                this.b = 8;
                this.f4852c = 8;
                c a4 = a(egl10, eGLDisplay);
                eGLConfig = a3;
                if (a4 != null) {
                    eGLConfig = a3;
                    if (a4.f4853a != null) {
                        EGLConfig[] eGLConfigArr2 = new EGLConfig[a4.b[0]];
                        egl10.eglChooseConfig(eGLDisplay, a4.f4853a, eGLConfigArr2, a4.b[0], a4.b);
                        eGLConfig = a(egl10, eGLDisplay, eGLConfigArr2);
                    }
                }
            }
            return eGLConfig;
        }
    }

    /* renamed from: com.amap.api.col.3sl.di$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/di$b.class */
    public static final class b extends dh {
        @Override // com.amap.api.col.p0003sl.dh, android.opengl.GLSurfaceView.EGLContextFactory
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            try {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        @Override // com.amap.api.col.p0003sl.dh, android.opengl.GLSurfaceView.EGLContextFactory
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.di$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/di$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public int[] f4853a;
        public int[] b;

        private c() {
            this.f4853a = null;
            this.b = new int[1];
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    public static void a(IGLSurfaceView iGLSurfaceView) {
        iGLSurfaceView.setEGLContextFactory(new b());
        iGLSurfaceView.setEGLConfigChooser(new a());
    }
}
