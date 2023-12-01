package com.blued.android.framework.mvp;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.mvp.BaseView;
import com.blued.android.framework.utils.LogUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/mvp/BasePresenter.class */
public abstract class BasePresenter<T extends BaseView> implements IPresenter {

    /* renamed from: a  reason: collision with root package name */
    protected T f9818a;
    protected Context b;

    /* renamed from: c  reason: collision with root package name */
    protected IRequestHost f9819c;

    /* renamed from: com.blued.android.framework.mvp.BasePresenter$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/mvp/BasePresenter$1.class */
    class AnonymousClass1 implements LifecycleObserver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BasePresenter f9820a;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onOwnerDestroy() {
            LogUtils.b("onOwnerDestroy");
            this.f9820a.f9818a = null;
            this.f9820a.b = null;
            this.f9820a.f9819c = null;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onOwnerStart() {
            LogUtils.b("onOwnerStart");
        }
    }
}
