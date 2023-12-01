package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.igexin.assist.sdk.AssistPushConsts;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATBannerAdapter.class */
public class TTATBannerAdapter extends CustomBannerAdapter {
    Context b;

    /* renamed from: c  reason: collision with root package name */
    View f6247c;
    int d;
    int e;
    int f;
    String g;
    boolean h;
    private TTNativeExpressAd n;
    private Map<String, Object> o;
    private final String m = getClass().getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f6246a = "";
    boolean i = false;
    TTAdNative.NativeExpressAdListener j = new TTAdNative.NativeExpressAdListener() { // from class: com.anythink.network.toutiao.TTATBannerAdapter.1
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public final void onError(int i, String str) {
            TTATBannerAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public final void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list == null || list.size() <= 0) {
                TTATBannerAdapter.this.notifyATLoadFail("", "Return Ad list is empty.");
                return;
            }
            TTATBannerAdapter.this.n = list.get(0);
            if (TTATBannerAdapter.this.f > 0) {
                TTATBannerAdapter.this.n.setSlideIntervalTime(TTATBannerAdapter.this.f);
            } else {
                TTATBannerAdapter.this.n.setSlideIntervalTime(0);
            }
            TTATBannerAdapter.b(TTATBannerAdapter.this);
            TTATBannerAdapter.this.n.render();
        }
    };
    TTNativeExpressAd.ExpressAdInteractionListener k = new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATBannerAdapter.2
        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdClicked(View view, int i) {
            if (TTATBannerAdapter.this.mImpressionEventListener != null) {
                TTATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdShow(View view, int i) {
            try {
                ViewParent parent = TTATBannerAdapter.this.f6247c.getParent();
                while (!(parent instanceof ViewGroup) && parent != null) {
                    parent = parent.getParent();
                }
                if (parent != null) {
                    Context context = ((ViewGroup) parent).getContext();
                    if (context instanceof Activity) {
                        TTATBannerAdapter.a(TTATBannerAdapter.this, (Activity) context, TTATBannerAdapter.this.n);
                    } else {
                        Log.d(TTATBannerAdapter.this.m, "bindDislike fail：ATBannerView is not instanceof Activity");
                    }
                } else if (TTATBannerAdapter.this.b instanceof Activity) {
                    TTATBannerAdapter.a(TTATBannerAdapter.this, (Activity) TTATBannerAdapter.this.b, TTATBannerAdapter.this.n);
                } else {
                    Log.d(TTATBannerAdapter.this.m, "bindDislike fail：mActivity is not instanceof Activity");
                }
            } catch (Throwable th) {
                String str = TTATBannerAdapter.this.m;
                Log.e(str, "bindDislike fail：" + th.getMessage());
            }
            try {
                TTATInitManager.getInstance().a(TTATBannerAdapter.this.getTrackingInfo().l(), new WeakReference(TTATBannerAdapter.this.n));
            } catch (Throwable th2) {
            }
            if (TTATBannerAdapter.this.mImpressionEventListener == null || TTATBannerAdapter.this.h) {
                return;
            }
            TTATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
            TTATBannerAdapter.this.h = true;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderFail(View view, String str, int i) {
            TTATBannerAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderSuccess(View view, float f, float f2) {
            TTATBannerAdapter.this.f6247c = view;
            try {
                Map<String, Object> mediaExtraInfo = TTATBannerAdapter.this.n.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (TTATBannerAdapter.this.o == null) {
                        TTATBannerAdapter.this.o = new HashMap(3);
                    }
                    TTATBannerAdapter.this.o.putAll(mediaExtraInfo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            TTATBannerAdapter.this.h = false;
            if (TTATBannerAdapter.this.i) {
                try {
                    TTATInitManager.getInstance().a(TTATBannerAdapter.this.o, TTATBannerAdapter.this.n, TTATBannerAdapter.this.mBiddingListener);
                } catch (Throwable th2) {
                }
            } else if (TTATBannerAdapter.this.mLoadListener != null) {
                TTATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }
    };
    private boolean p = false;
    TTAppDownloadListener l = new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATBannerAdapter.6
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, String str, String str2) {
            if (TTATBannerAdapter.this.p) {
                if (TTATBannerAdapter.this.mDownloadListener == null || !(TTATBannerAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                TTATBannerAdapter.this.mDownloadListener.onDownloadUpdate(j, j2, str, str2);
                return;
            }
            TTATBannerAdapter.p(TTATBannerAdapter.this);
            if (TTATBannerAdapter.this.mDownloadListener == null || !(TTATBannerAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATBannerAdapter.this.mDownloadListener.onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, String str, String str2) {
            if (TTATBannerAdapter.this.mDownloadListener == null || !(TTATBannerAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATBannerAdapter.this.mDownloadListener.onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, String str, String str2) {
            if (TTATBannerAdapter.this.mDownloadListener == null || !(TTATBannerAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATBannerAdapter.this.mDownloadListener.onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, String str, String str2) {
            if (TTATBannerAdapter.this.mDownloadListener == null || !(TTATBannerAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATBannerAdapter.this.mDownloadListener.onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(String str, String str2) {
            if (TTATBannerAdapter.this.mDownloadListener == null || !(TTATBannerAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            TTATBannerAdapter.this.mDownloadListener.onInstalled(str, str2);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.toutiao.TTATBannerAdapter$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATBannerAdapter$3.class */
    public final class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f6250a;
        final /* synthetic */ Map b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f6251c;

        AnonymousClass3(Map map, Map map2, Context context) {
            this.f6250a = map;
            this.b = map2;
            this.f6251c = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0187  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x01f0  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01f9  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x020d  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 557
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.toutiao.TTATBannerAdapter.AnonymousClass3.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.toutiao.TTATBannerAdapter$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATBannerAdapter$4.class */
    public final class AnonymousClass4 implements TTAdDislike.DislikeInteractionCallback {
        AnonymousClass4() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onCancel() {
        }

        @Deprecated
        public final void onRefuse() {
        }

        @Deprecated
        public final void onSelected(int i, String str) {
            if (TTATBannerAdapter.this.mImpressionEventListener != null) {
                TTATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onSelected(int i, String str, boolean z) {
            if (TTATBannerAdapter.this.mImpressionEventListener != null) {
                TTATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onShow() {
        }
    }

    private void a() {
        TTNativeExpressAd tTNativeExpressAd = this.n;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener(this.k);
            this.n.setDownloadListener(this.l);
        }
    }

    private void a(Activity activity, TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setDislikeCallback(activity, new AnonymousClass4());
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        runOnNetworkRequestThread(new AnonymousClass3(map, map2, context.getApplicationContext()));
    }

    static /* synthetic */ void a(TTATBannerAdapter tTATBannerAdapter, Activity activity, TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setDislikeCallback(activity, new AnonymousClass4());
    }

    static /* synthetic */ void a(TTATBannerAdapter tTATBannerAdapter, Context context, Map map, Map map2) {
        tTATBannerAdapter.runOnNetworkRequestThread(new AnonymousClass3(map, map2, context.getApplicationContext()));
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.f6246a = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.f6246a)) {
            return false;
        }
        this.f = ATInitMediation.getIntFromMap(map, "nw_rft", 0);
        this.g = ATInitMediation.getStringFromMap(map, AssistPushConsts.MSG_TYPE_PAYLOAD);
        return true;
    }

    static /* synthetic */ void b(TTATBannerAdapter tTATBannerAdapter) {
        TTNativeExpressAd tTNativeExpressAd = tTATBannerAdapter.n;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener(tTATBannerAdapter.k);
            tTATBannerAdapter.n.setDownloadListener(tTATBannerAdapter.l);
        }
    }

    static /* synthetic */ boolean p(TTATBannerAdapter tTATBannerAdapter) {
        tTATBannerAdapter.p = true;
        return true;
    }

    public void destory() {
        this.f6247c = null;
        TTNativeExpressAd tTNativeExpressAd = this.n;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
            this.n.destroy();
            this.n = null;
        }
        this.k = null;
        this.j = null;
        this.b = null;
    }

    public View getBannerView() {
        return this.f6247c;
    }

    public Map<String, Object> getNetworkInfoMap() {
        return this.o;
    }

    public String getNetworkName() {
        return TTATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.f6246a;
    }

    public String getNetworkSDKVersion() {
        return TTATInitManager.getInstance().getNetworkVersion();
    }

    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.f6246a = ATInitMediation.getStringFromMap(map, "slot_id");
        boolean z = false;
        if (!TextUtils.isEmpty(stringFromMap)) {
            if (TextUtils.isEmpty(this.f6246a)) {
                z = false;
            } else {
                this.f = ATInitMediation.getIntFromMap(map, "nw_rft", 0);
                this.g = ATInitMediation.getStringFromMap(map, AssistPushConsts.MSG_TYPE_PAYLOAD);
                z = true;
            }
        }
        if (!z) {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        } else if (!(context instanceof Activity)) {
            notifyATLoadFail("", "Context must be activity.");
        } else {
            this.b = context;
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATBannerAdapter.5
                public final void onFail(String str) {
                    TTATBannerAdapter.this.notifyATLoadFail("", str);
                }

                public final void onSuccess() {
                    try {
                        TTATBannerAdapter.a(TTATBannerAdapter.this, context, map, map2);
                    } catch (Throwable th) {
                        TTATBannerAdapter.this.notifyATLoadFail("", th.getMessage());
                    }
                }
            });
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.i = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
