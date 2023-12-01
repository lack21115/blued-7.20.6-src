package com.tencent.turingface.sdk.mfa;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/FP21m.class */
public final class FP21m implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Window f26182a;
    public final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ww1Z6 f26183c;

    public FP21m(Window window, String str, Ww1Z6 ww1Z6) {
        this.f26182a = window;
        this.b = str;
        this.f26183c = ww1Z6;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        Object obj;
        Object a2;
        try {
            View decorView = this.f26182a.getDecorView();
            decorView.getViewTreeObserver().removeOnPreDrawListener(this);
            try {
                Method declaredMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                declaredMethod.setAccessible(true);
                obj = declaredMethod.invoke(decorView, new Object[0]);
            } catch (Throwable th) {
                obj = null;
            }
            if (obj == null) {
                return true;
            }
            Class<?> cls = obj.getClass();
            HashMap<Class<?>, HashMap<String, Field>> hashMap = JF943.f26196a;
            Method a3 = JF943.a(cls);
            Object invoke = a3 == null ? null : a3.invoke(obj, null);
            if (invoke == null || (a2 = JF943.a(invoke.getClass(), "mHandler", invoke)) == null) {
                return true;
            }
            Field declaredField = Handler.class.getDeclaredField("mCallback");
            declaredField.setAccessible(true);
            Handler.Callback callback = (Handler.Callback) declaredField.get(a2);
            if (callback instanceof IyjbE) {
                return true;
            }
            declaredField.set(a2, new IyjbE(callback, this.f26183c, this.b));
            return true;
        } catch (Throwable th2) {
            return true;
        }
    }
}
