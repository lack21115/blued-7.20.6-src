package com.kuaishou.pushad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kuaishou.pushad.PushAdView;
import com.kwad.components.core.g.a;
import com.kwad.components.core.g.c;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/pushad/PushAdManager.class */
public class PushAdManager implements PushAdView.PushAdListener, Runnable {
    private static final int MSG_WHAT_AD_EXIT = 1000001;
    private static final int MSG_WHAT_PAGE_OUT = 1000002;
    private static final String TAG = "PushAdManager";
    private static Handler mInnerHandler = new Handler(Looper.getMainLooper());
    private static volatile boolean processingPush;
    private AdTemplate mHostAd;
    private AdTemplate mPushAd;
    private PushAdView mPushAdView;
    private long showPushAdDelayTime;
    private boolean postBuffered = false;
    private boolean hadPostPushAd = false;

    public PushAdManager(AdTemplate adTemplate) {
        this.mHostAd = adTemplate;
        this.showPushAdDelayTime = a.cz(d.cb(adTemplate));
        b.d(TAG, "PushAdManager create adTemplate: " + adTemplate.hashCode() + ", " + this.showPushAdDelayTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPushTK() {
        Context context = ServiceProvider.getContext();
        if (context == null) {
            processingPush = false;
            return;
        }
        PushAdView pushAdView = new PushAdView(context);
        this.mPushAdView = pushAdView;
        pushAdView.bindView(this.mPushAd);
        this.mPushAdView.setListener(this);
    }

    private void performShow() {
        PushAdView pushAdView;
        processingPush = false;
        com.kwad.sdk.core.b.b.vS();
        final Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing() || this.hadPostPushAd || (pushAdView = this.mPushAdView) == null || !pushAdView.isTKLoadSuccess()) {
            return;
        }
        this.hadPostPushAd = true;
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.a(new com.kwad.sdk.core.b.d() { // from class: com.kuaishou.pushad.PushAdManager.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
            public void onActivityDestroyed(Activity activity) {
                super.onActivityDestroyed(activity);
                if (activity.equals(currentActivity)) {
                    PushAdManager.this.mPushAdView.destroy();
                }
            }
        });
        PushAdViewHelper.appendPushAd(currentActivity, this.mPushAdView);
        this.mPushAdView.onShow();
    }

    private static void sendMessageDelay(int i, Runnable runnable, long j) {
        Message obtain = Message.obtain(mInnerHandler, runnable);
        obtain.what = i;
        mInnerHandler.sendMessageDelayed(obtain, j);
    }

    public void onAdExit(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (!adTemplate.equals(this.mHostAd)) {
            b.d(TAG, "onAdExit not current ad");
            return;
        }
        b.d(TAG, "onAdExit showPushAdDelayTime: " + this.showPushAdDelayTime + ", adTemplate: " + adTemplate.hashCode());
        if (aVar.ao()) {
            sendMessageDelay(1000001, this, this.showPushAdDelayTime);
        }
    }

    public void onOutSDKPage() {
        b.d(TAG, "onOutSDKPage: ");
        if (mInnerHandler.hasMessages(1000001)) {
            return;
        }
        b.d(TAG, "onOutSDKPage: sendMessageDelay MSG_WHAT_PAGE_OUT");
        sendMessageDelay(MSG_WHAT_PAGE_OUT, this, 500L);
    }

    @Override // com.kuaishou.pushad.PushAdView.PushAdListener
    public void onPushAdViewClose() {
        b.d(TAG, "onAdClose: ");
        PushAdViewHelper.removePushAd(null);
        PushAdView pushAdView = this.mPushAdView;
        if (pushAdView != null) {
            pushAdView.destroy();
        }
        KsAdGlobalWatcher.getInstance().removePushAdManager(this);
    }

    @Override // com.kuaishou.pushad.PushAdView.PushAdListener
    public void onPushAdViewShow() {
        y.ag(System.currentTimeMillis());
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean preShowPushCheck = KsAdGlobalWatcher.getInstance().preShowPushCheck();
        b.d(TAG, "run preCheckResult: " + preShowPushCheck);
        if (preShowPushCheck) {
            performShow();
            return;
        }
        b.d(TAG, "run postBuffered set true");
        this.postBuffered = true;
    }

    public void startRequestPushAd(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate;
        b.w(TAG, "startRequestPushAd processingPush: " + processingPush);
        if (processingPush || (adTemplate = aVar.getAdTemplate()) == null || adTemplate.mAdScene == null) {
            return;
        }
        processingPush = true;
        com.kwad.components.core.g.a.b(adTemplate.mAdScene, new a.InterfaceC0353a() { // from class: com.kuaishou.pushad.PushAdManager.1
            @Override // com.kwad.components.core.g.a.InterfaceC0353a
            public void onError(int i, String str) {
                b.d(PushAdManager.TAG, "onError: " + str);
                boolean unused = PushAdManager.processingPush = false;
            }

            @Override // com.kwad.components.core.g.a.InterfaceC0353a
            public void onInnerAdLoad(List<c> list) {
                b.d(PushAdManager.TAG, "onInnerAdLoad: " + list);
                if (list == null || list.size() <= 0) {
                    boolean unused = PushAdManager.processingPush = false;
                    return;
                }
                PushAdManager.this.mPushAd = list.get(0).getAdTemplate();
                if (com.kwad.sdk.core.response.a.a.cx(d.cb(PushAdManager.this.mPushAd))) {
                    b.d(PushAdManager.TAG, "loadPushTK");
                    PushAdManager.this.loadPushTK();
                    return;
                }
                boolean unused2 = PushAdManager.processingPush = false;
                b.d(PushAdManager.TAG, "pushAdInfo templateId invalid");
            }

            @Override // com.kwad.components.core.g.a.InterfaceC0353a
            public void onRequestResult(int i) {
            }
        });
    }
}
