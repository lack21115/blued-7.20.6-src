package com.kuaishou.pushad;

import com.kwad.components.core.internal.api.a;
import com.kwad.components.core.internal.api.b;
import com.kwad.components.core.l.d;
import com.kwad.components.core.l.h;
import com.kwad.components.core.l.i;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/pushad/KsAdGlobalWatcher.class */
public class KsAdGlobalWatcher implements b {
    private static final Object PRESENT = new Object();
    private static final String TAG = "KsAdGlobalWatcher";
    private static volatile KsAdGlobalWatcher sInstance;
    private Set<Integer> mTargetAdStyle = new HashSet();
    private List<PushAdManager> mCurrentPushAdManager = new ArrayList();
    private Map<a, Object> mCurrentShowingAd = new WeakHashMap();
    private Map<d, Object> mCurrentActivity = new WeakHashMap();
    private i mLifecycleListener = new i() { // from class: com.kuaishou.pushad.KsAdGlobalWatcher.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwad.components.core.l.i, com.kwad.sdk.core.b.c
        public void onActivityPaused(d dVar) {
            super.onActivityPaused(dVar);
            KsAdGlobalWatcher.this.mCurrentActivity.remove(dVar);
            if (KsAdGlobalWatcher.this.mCurrentActivity.isEmpty()) {
                KsAdGlobalWatcher.this.checkCurrentPage();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwad.components.core.l.i, com.kwad.sdk.core.b.c
        public void onActivityResumed(d dVar) {
            super.onActivityResumed(dVar);
            KsAdGlobalWatcher.this.mCurrentActivity.put(dVar, KsAdGlobalWatcher.PRESENT);
        }
    };

    private KsAdGlobalWatcher() {
        h.oZ().a(this.mLifecycleListener);
        this.mTargetAdStyle.add(2);
        this.mTargetAdStyle.add(3);
        this.mTargetAdStyle.add(13);
        this.mTargetAdStyle.add(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCurrentPage() {
        synchronized (this) {
            boolean preShowPushCheck = preShowPushCheck();
            com.kwad.sdk.core.d.b.d(TAG, "checkCurrentPage noSDKPage: " + preShowPushCheck);
            if (preShowPushCheck) {
                for (PushAdManager pushAdManager : this.mCurrentPushAdManager) {
                    pushAdManager.onOutSDKPage();
                }
            }
        }
    }

    public static KsAdGlobalWatcher getInstance() {
        if (sInstance == null) {
            synchronized (KsAdGlobalWatcher.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new KsAdGlobalWatcher();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    private void innerHandleEnter(a aVar) {
        this.mCurrentShowingAd.put(aVar, PRESENT);
        if (isPushAdEnable(aVar)) {
            PushAdManager pushAdManager = new PushAdManager(aVar.getAdTemplate());
            pushAdManager.startRequestPushAd(aVar);
            this.mCurrentPushAdManager.add(pushAdManager);
        }
    }

    private void innerHandleExit(a aVar) {
        this.mCurrentShowingAd.remove(aVar);
        for (PushAdManager pushAdManager : this.mCurrentPushAdManager) {
            pushAdManager.onAdExit(aVar);
        }
        if (isAdInTargetSet(aVar.getAdTemplate())) {
            checkCurrentPage();
        }
    }

    private boolean isAdInTargetSet(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        return this.mTargetAdStyle.contains(Integer.valueOf(adTemplate.adStyle));
    }

    private boolean isPushAdEnable(a aVar) {
        if (aVar.ao()) {
            return com.kwad.sdk.core.response.a.a.cy(com.kwad.sdk.core.response.a.d.cb(aVar.getAdTemplate()));
        }
        return false;
    }

    @Override // com.kwad.components.core.internal.api.b
    public void onAdEnter(a aVar) {
        innerHandleEnter(aVar);
    }

    @Override // com.kwad.components.core.internal.api.b
    public void onAdExit(a aVar) {
        innerHandleExit(aVar);
        unwatch(aVar);
    }

    public boolean preShowPushCheck() {
        synchronized (this) {
            Iterator<a> it = this.mCurrentShowingAd.keySet().iterator();
            do {
                if (!it.hasNext()) {
                    return this.mCurrentActivity.isEmpty();
                }
            } while (!isAdInTargetSet(it.next().getAdTemplate()));
            return false;
        }
    }

    public void removePushAdManager(PushAdManager pushAdManager) {
        if (pushAdManager != null) {
            this.mCurrentPushAdManager.remove(pushAdManager);
        }
    }

    public void unwatch(a aVar) {
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void watch(a aVar) {
        if (aVar != null) {
            aVar.a(this);
        }
    }
}
