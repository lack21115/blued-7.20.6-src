package com.blued.android.module.live_china.zegoVideoCapture.ve_gl;

import android.view.Surface;
import com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase10;
import com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase14;
import javax.microedition.khronos.egl.EGL10;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/zegoVideoCapture/ve_gl/EglBase.class */
public abstract class EglBase {
    protected static final String a = EglBase.class.getSimpleName();
    public static final Object c = new Object();
    public static final int[] d = {EGL10.EGL_RED_SIZE, 8, EGL10.EGL_GREEN_SIZE, 8, EGL10.EGL_BLUE_SIZE, 8, EGL10.EGL_RENDERABLE_TYPE, 4, EGL10.EGL_NONE};
    public static final int[] e = {EGL10.EGL_RED_SIZE, 8, EGL10.EGL_GREEN_SIZE, 8, EGL10.EGL_BLUE_SIZE, 8, EGL10.EGL_ALPHA_SIZE, 8, EGL10.EGL_RENDERABLE_TYPE, 4, EGL10.EGL_NONE};
    public static final int[] f = {EGL10.EGL_RED_SIZE, 8, EGL10.EGL_GREEN_SIZE, 8, EGL10.EGL_BLUE_SIZE, 8, EGL10.EGL_RENDERABLE_TYPE, 4, EGL10.EGL_SURFACE_TYPE, 1, EGL10.EGL_NONE};
    public static final int[] g = {EGL10.EGL_RED_SIZE, 8, EGL10.EGL_GREEN_SIZE, 8, EGL10.EGL_BLUE_SIZE, 8, EGL10.EGL_ALPHA_SIZE, 8, EGL10.EGL_RENDERABLE_TYPE, 4, EGL10.EGL_SURFACE_TYPE, 1, EGL10.EGL_NONE};
    public static final int[] h = {EGL10.EGL_RED_SIZE, 8, EGL10.EGL_GREEN_SIZE, 8, EGL10.EGL_BLUE_SIZE, 8, EGL10.EGL_RENDERABLE_TYPE, 4, 12610, 1, EGL10.EGL_NONE};
    protected boolean b = false;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/zegoVideoCapture/ve_gl/EglBase$Context.class */
    public static class Context {
    }

    public static EglBase a(Context context, int[] iArr) {
        return (EglBase14.i() && (context == null || (context instanceof EglBase14.Context))) ? new EglBase14((EglBase14.Context) context, iArr) : new EglBase10((EglBase10.Context) context, iArr);
    }

    public abstract void a();

    public abstract void a(Surface surface);

    public abstract Context b();

    public abstract boolean c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();
}
