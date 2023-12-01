package com.blued.android.framework.ui.mvp;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.framework.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/mvp/MvpPresenterManager.class */
public class MvpPresenterManager {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, MvpPresenter> f9932a = new HashMap();

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/mvp/MvpPresenterManager$SingletonCreator.class */
    static class SingletonCreator {

        /* renamed from: a  reason: collision with root package name */
        public static final MvpPresenterManager f9935a = new MvpPresenterManager();

        private SingletonCreator() {
        }
    }

    public static MvpPresenterManager a() {
        return SingletonCreator.f9935a;
    }

    public MvpPresenter a(String str) {
        return this.f9932a.get(str);
    }

    public void a(MvpPresenter mvpPresenter, final Lifecycle lifecycle) {
        LogUtils.b("onSave, add mvpPresenter:" + mvpPresenter + ", for key:" + mvpPresenter.f9927a);
        final String str = mvpPresenter.f9927a;
        this.f9932a.put(str, mvpPresenter);
        lifecycle.addObserver(new LifecycleObserver() { // from class: com.blued.android.framework.ui.mvp.MvpPresenterManager.1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy() {
                MvpPresenter mvpPresenter2 = (MvpPresenter) MvpPresenterManager.this.f9932a.remove(str);
                LogUtils.b("onDestroy, remove mvpPresenter:" + mvpPresenter2 + ", for key:" + str);
                lifecycle.removeObserver(this);
            }
        });
    }
}
