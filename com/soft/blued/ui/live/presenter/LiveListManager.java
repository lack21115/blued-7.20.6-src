package com.soft.blued.ui.live.presenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.soft.blued.ui.live.contract.LiveListContract;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveListManager.class */
public class LiveListManager implements LiveListContract.ServicePresenter {

    /* renamed from: a  reason: collision with root package name */
    private static LiveListManager f17592a;
    private LiveListPresenterHolder b = new LiveListPresenterHolder();

    /* renamed from: c  reason: collision with root package name */
    private LiveListContract.IPresenter f17593c;

    private LiveListManager() {
    }

    public static LiveListManager a() {
        synchronized (LiveListManager.class) {
            try {
                if (f17592a == null) {
                    synchronized (LiveListManager.class) {
                        if (f17592a == null) {
                            f17592a = new LiveListManager();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f17592a;
    }

    public BluedLiveState a(String str, int i) {
        LiveListPresenterHolder liveListPresenterHolder = this.b;
        if (liveListPresenterHolder != null) {
            LiveListContract.IPresenter a2 = liveListPresenterHolder.a(str, i);
            this.f17593c = a2;
            if (a2 != null) {
                return a2.a();
            }
            return null;
        }
        return null;
    }

    public void a(final LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.soft.blued.ui.live.presenter.LiveListManager.1
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public void onOwnerDestroy() {
                    LogUtils.b("onOwnerDestroy");
                    if (LiveListManager.this.b != null) {
                        LiveListManager.this.b.a();
                    }
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }

                @OnLifecycleEvent(Lifecycle.Event.ON_START)
                public void onOwnerStart() {
                    LogUtils.b("onOwnerStart");
                }
            });
        }
    }

    public void a(LiveListContract.IView iView, String str, int i) {
        LiveListPresenterHolder liveListPresenterHolder = this.b;
        if (liveListPresenterHolder != null) {
            LiveListContract.IPresenter a2 = liveListPresenterHolder.a(str, i);
            this.f17593c = a2;
            if (a2 != null) {
                a2.a(iView);
            }
        }
    }

    public void a(boolean z, String str, int i) {
        LiveListPresenterHolder liveListPresenterHolder = this.b;
        if (liveListPresenterHolder != null) {
            LiveListContract.IPresenter a2 = liveListPresenterHolder.a(str, i);
            this.f17593c = a2;
            if (a2 != null) {
                a2.a(z);
            }
        }
    }

    public void b(String str, int i) {
        LiveListPresenterHolder liveListPresenterHolder = this.b;
        if (liveListPresenterHolder != null) {
            LiveListContract.IPresenter a2 = liveListPresenterHolder.a(str, i);
            this.f17593c = a2;
            if (a2 != null) {
                a2.b();
            }
        }
    }

    public int c(String str, int i) {
        LiveListPresenterHolder liveListPresenterHolder = this.b;
        if (liveListPresenterHolder != null) {
            LiveListContract.IPresenter a2 = liveListPresenterHolder.a(str, i);
            this.f17593c = a2;
            if (a2 != null) {
                return a2.d();
            }
            return 0;
        }
        return 0;
    }

    public void d(String str, int i) {
        LiveListPresenterHolder liveListPresenterHolder = this.b;
        if (liveListPresenterHolder != null) {
            liveListPresenterHolder.b(str, i);
        }
    }

    public void e(String str, int i) {
        LiveListPresenterHolder liveListPresenterHolder = this.b;
        if (liveListPresenterHolder != null) {
            LiveListContract.IPresenter a2 = liveListPresenterHolder.a(str, i);
            this.f17593c = a2;
            if (a2 != null) {
                a2.f();
            }
        }
    }
}
