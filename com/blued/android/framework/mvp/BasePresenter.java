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
    protected T a;
    protected Context b;
    protected IRequestHost c;

    /* renamed from: com.blued.android.framework.mvp.BasePresenter$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/mvp/BasePresenter$1.class */
    class AnonymousClass1 implements LifecycleObserver {
        final /* synthetic */ BasePresenter a;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onOwnerDestroy() {
            LogUtils.b("onOwnerDestroy");
            this.a.a = null;
            this.a.b = null;
            this.a.c = null;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onOwnerStart() {
            LogUtils.b("onOwnerStart");
        }
    }
}
