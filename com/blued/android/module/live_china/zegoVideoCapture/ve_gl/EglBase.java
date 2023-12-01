package com.blued.android.module.live_china.zegoVideoCapture.ve_gl;

import android.view.Surface;
import com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase10;
import com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase14;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/zegoVideoCapture/ve_gl/EglBase.class */
public abstract class EglBase {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f15496a = EglBase.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public static final Object f15497c = new Object();
    public static final int[] d = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344};
    public static final int[] e = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
    public static final int[] f = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12339, 1, 12344};
    public static final int[] g = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344};
    public static final int[] h = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344};
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
