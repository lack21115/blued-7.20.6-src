package com.blued.android.modules;

import com.blued.android.module.base.http.FeedStateObserverProxy;
import com.blued.android.module.base.http.IFeedStateObserver;
import com.blued.community.ui.send.observer.FeedRefreshObserver;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/FeedStateObserverModule.class */
public class FeedStateObserverModule {
    private static ArrayList<FeedStateObserverProxy.IFeedStateListener> c = new ArrayList<>();
    static IFeedStateObserver a = new IFeedStateObserver() { // from class: com.blued.android.modules.FeedStateObserverModule.1
        @Override // com.blued.android.module.base.http.IFeedStateObserver
        public void a(FeedStateObserverProxy.IFeedStateListener iFeedStateListener) {
            if (FeedStateObserverModule.c == null || iFeedStateListener == null || FeedStateObserverModule.c.contains(iFeedStateListener)) {
                return;
            }
            FeedStateObserverModule.c.add(iFeedStateListener);
        }

        @Override // com.blued.android.module.base.http.IFeedStateObserver
        public void b(FeedStateObserverProxy.IFeedStateListener iFeedStateListener) {
            if (FeedStateObserverModule.c == null || iFeedStateListener == null || !FeedStateObserverModule.c.contains(iFeedStateListener)) {
                return;
            }
            FeedStateObserverModule.c.remove(iFeedStateListener);
        }
    };
    static FeedRefreshObserver.IFeedRefreshObserver b = new FeedRefreshObserver.IFeedRefreshObserver() { // from class: com.blued.android.modules.FeedStateObserverModule.2
        @Override // com.blued.community.ui.send.observer.FeedRefreshObserver.IFeedRefreshObserver
        public void a(Object obj, int i) {
            Iterator it = FeedStateObserverModule.c.iterator();
            while (it.hasNext()) {
                FeedStateObserverProxy.IFeedStateListener iFeedStateListener = (FeedStateObserverProxy.IFeedStateListener) it.next();
                if (iFeedStateListener != null && i == 3) {
                    iFeedStateListener.Y_();
                }
            }
        }
    };

    public static void a() {
        FeedRefreshObserver.a().a(b);
        FeedStateObserverProxy.a().a((FeedStateObserverProxy) a);
    }
}
