package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.blued.android.module.shortvideo.contract.SysNetworkListener;
import com.blued.android.module.shortvideo.manager.NetWorkObserverManager;
import com.blued.android.module.shortvideo.utils.StvThreadPoolHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/presenter/ShortVideoBasePresent.class */
public abstract class ShortVideoBasePresent<T> implements SysNetworkListener {
    protected WeakReference<T> g;
    protected List<StvThreadPoolHelper.StvThread> h = new ArrayList();

    public T D() {
        WeakReference<T> weakReference = this.g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void E() {
        b();
        WeakReference<T> weakReference = this.g;
        if (weakReference != null) {
            weakReference.clear();
            this.g = null;
        }
        List<StvThreadPoolHelper.StvThread> list = this.h;
        if (list != null) {
            for (StvThreadPoolHelper.StvThread stvThread : list) {
                StvThreadPoolHelper.a().a(stvThread);
            }
        }
        NetWorkObserverManager.a().b(this);
    }

    public abstract void a();

    public abstract void a(Activity activity, int i, int i2, Intent intent);

    public abstract void a(Bundle bundle);

    public void a(T t) {
        NetWorkObserverManager.a().a(this);
        this.g = new WeakReference<>(t);
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract boolean g();
}
