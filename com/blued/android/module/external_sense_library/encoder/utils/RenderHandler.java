package com.blued.android.module.external_sense_library.encoder.utils;

import android.opengl.EGLContext;
import android.opengl.Matrix;
import com.blued.android.module.external_sense_library.encoder.utils.EGLBase;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/encoder/utils/RenderHandler.class */
public final class RenderHandler implements Runnable {
    private EGLContext b;
    private boolean c;
    private Object d;
    private boolean g;
    private boolean h;
    private int i;
    private EGLBase j;
    private EGLBase.EglSurface k;
    private GLDrawer2D l;
    private final Object a = new Object();
    private int e = -1;
    private float[] f = new float[32];

    private final void b() {
        c();
        EGLBase eGLBase = new EGLBase(this.b, false, this.c);
        this.j = eGLBase;
        EGLBase.EglSurface a = eGLBase.a(this.d);
        this.k = a;
        a.a();
        this.l = new GLDrawer2D();
        this.d = null;
        this.a.notifyAll();
    }

    private final void c() {
        EGLBase.EglSurface eglSurface = this.k;
        if (eglSurface != null) {
            eglSurface.c();
            this.k = null;
        }
        GLDrawer2D gLDrawer2D = this.l;
        if (gLDrawer2D != null) {
            gLDrawer2D.a();
            this.l = null;
        }
        EGLBase eGLBase = this.j;
        if (eGLBase != null) {
            eGLBase.a();
            this.j = null;
        }
    }

    public final void a() {
        synchronized (this.a) {
            if (this.h) {
                return;
            }
            this.h = true;
            this.a.notifyAll();
            try {
                this.a.wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public final void a(int i, float[] fArr, float[] fArr2) {
        synchronized (this.a) {
            if (this.h) {
                return;
            }
            this.e = i;
            if (fArr == null || fArr.length < 16) {
                Matrix.setIdentityM(this.f, 0);
            } else {
                System.arraycopy((Object) fArr, 0, (Object) this.f, 0, 16);
            }
            if (fArr2 == null || fArr2.length < 16) {
                Matrix.setIdentityM(this.f, 16);
            } else {
                System.arraycopy((Object) fArr2, 0, (Object) this.f, 16, 16);
            }
            this.i++;
            this.a.notifyAll();
        }
    }

    public final void a(float[] fArr) {
        a(this.e, fArr, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
        if (r6 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0066, code lost:
        if (r5.j == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
        if (r5.e < 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0070, code lost:
        r5.k.a();
        android.opengl.GLES20.glClearColor(1.0f, 1.0f, 0.0f, 1.0f);
        android.opengl.GLES20.glClear(16384);
        r5.l.a(r5.f, 16);
        r5.l.a(r5.e, r5.f);
        r5.k.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00aa, code lost:
        r0 = r5.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b0, code lost:
        monitor-enter(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b1, code lost:
        r5.a.wait();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b9, code lost:
        monitor-exit(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.external_sense_library.encoder.utils.RenderHandler.run():void");
    }
}
