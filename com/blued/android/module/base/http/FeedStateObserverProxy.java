package com.blued.android.module.base.http;

import com.blued.android.module.base.base.BaseProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/http/FeedStateObserverProxy.class */
public class FeedStateObserverProxy extends BaseProxy<IFeedStateObserver> implements IFeedStateObserver {
    private static FeedStateObserverProxy b;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/http/FeedStateObserverProxy$IFeedStateListener.class */
    public interface IFeedStateListener {
        void Y_();
    }

    private FeedStateObserverProxy() {
    }

    public static FeedStateObserverProxy a() {
        if (b == null) {
            synchronized (FeedStateObserverProxy.class) {
                try {
                    if (b == null) {
                        b = new FeedStateObserverProxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // com.blued.android.module.base.http.IFeedStateObserver
    public void a(IFeedStateListener iFeedStateListener) {
        if (this.f10426a != 0) {
            ((IFeedStateObserver) this.f10426a).a(iFeedStateListener);
        }
    }

    @Override // com.blued.android.module.base.http.IFeedStateObserver
    public void b(IFeedStateListener iFeedStateListener) {
        if (this.f10426a != 0) {
            ((IFeedStateObserver) this.f10426a).b(iFeedStateListener);
        }
    }
}
