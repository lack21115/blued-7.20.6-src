package com.soft.blued.base.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/base/mvp/MVPBasePresent.class */
public abstract class MVPBasePresent<T> {

    /* renamed from: a  reason: collision with root package name */
    protected WeakReference<T> f28296a;

    public abstract void a(Activity activity, int i, int i2, Intent intent);

    public abstract void a(Bundle bundle);

    public void a(T t) {
        this.f28296a = new WeakReference<>(t);
    }

    public T ao_() {
        WeakReference<T> weakReference = this.f28296a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void b() {
        WeakReference<T> weakReference = this.f28296a;
        if (weakReference != null) {
            weakReference.clear();
            this.f28296a = null;
        }
        c();
    }

    public abstract void b(Bundle bundle);

    public abstract void c();
}
