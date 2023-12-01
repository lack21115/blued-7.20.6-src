package com.blued.android.module.media.selector.present;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/present/MediaBasePresent.class */
public abstract class MediaBasePresent<T> {
    protected WeakReference<T> b;

    public abstract void a(Activity activity, int i, int i2, Intent intent);

    public abstract void a(Bundle bundle);

    public void a(T t) {
        this.b = new WeakReference<>(t);
    }

    public abstract void b(Bundle bundle);

    public abstract void h();

    public T n() {
        WeakReference<T> weakReference = this.b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void o() {
        WeakReference<T> weakReference = this.b;
        if (weakReference != null) {
            weakReference.clear();
            this.b = null;
        }
        h();
    }
}
