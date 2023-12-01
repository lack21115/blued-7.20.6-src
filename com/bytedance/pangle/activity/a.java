package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/activity/a.class */
public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f7749a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7750c;
    private Method d;

    public a(Activity activity, int i, String str) {
        this.f7749a = activity;
        this.b = str;
        this.f7750c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (this.d == null) {
            try {
                Method method = this.f7749a.getClass().getMethod(this.b, View.class);
                if (method != null) {
                    this.d = method;
                }
            } catch (NoSuchMethodException e) {
            }
            throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f7750c);
        }
        try {
            this.d.invoke(this.f7749a, view);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
        } catch (InvocationTargetException e3) {
            throw new IllegalStateException("Could not execute method for android:onClick", e3);
        }
    }
}
