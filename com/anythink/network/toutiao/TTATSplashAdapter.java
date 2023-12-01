package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.api.ATSplashEyeAdListener;
import com.anythink.splashad.api.IATSplashEyeAd;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATSplashAdapter.class */
public class TTATSplashAdapter extends CustomSplashAdapter implements CSJSplashAd.SplashAdListener {
    CSJSplashAd d;
    boolean e;
    TTATSplashEyeAd f;
    View g;
    private Map<String, Object> m;
    private final String k = getClass().getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f9145a = "";
    String b = "";

    /* renamed from: c  reason: collision with root package name */
    String f9146c = "";
    private boolean l = false;
    String h = "";
    boolean i = false;
    private boolean n = false;
    TTAppDownloadListener j = new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATSplashAdapter.4
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, String str, String str2) {
            if (TTATSplashAdapter.this.n) {
                if (TTATSplashAdapter.this.mDownloadListener == null || !(TTATSplashAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATSplashAdapter.this.mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                return;
            }
            TTATSplashAdapter.h(TTATSplashAdapter.this);
            if (TTATSplashAdapter.this.mDownloadListener == null || !(TTATSplashAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATSplashAdapter.this.mDownloadListener).onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, String str, String str2) {
            if (TTATSplashAdapter.this.mDownloadListener == null || !(TTATSplashAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATSplashAdapter.this.mDownloadListener).onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, String str, String str2) {
            if (TTATSplashAdapter.this.mDownloadListener == null || !(TTATSplashAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATSplashAdapter.this.mDownloadListener).onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, String str, String str2) {
            if (TTATSplashAdapter.this.mDownloadListener == null || !(TTATSplashAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATSplashAdapter.this.mDownloadListener).onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(String str, String str2) {
            if (TTATSplashAdapter.this.mDownloadListener == null || !(TTATSplashAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATSplashAdapter.this.mDownloadListener).onInstalled(str, str2);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.toutiao.TTATSplashAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATSplashAdapter$2.class */
    public final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AdSlot.Builder f9149a;
        final /* synthetic */ TTAdNative b;

        AnonymousClass2(AdSlot.Builder builder, TTAdNative tTAdNative) {
            this.f9149a = builder;
            this.b = tTAdNative;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.b.loadSplashAd(this.f9149a.build(), new TTAdNative.CSJSplashAdListener() { // from class: com.anythink.network.toutiao.TTATSplashAdapter.2.1
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                    public final void onSplashLoadFail(CSJAdError cSJAdError) {
                        TTATSplashAdapter tTATSplashAdapter = TTATSplashAdapter.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(cSJAdError.getCode());
                        tTATSplashAdapter.notifyATLoadFail(sb.toString(), cSJAdError.getMsg());
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                    public final void onSplashLoadSuccess() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                    public final void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                        TTATSplashAdapter tTATSplashAdapter = TTATSplashAdapter.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(cSJAdError.getCode());
                        tTATSplashAdapter.notifyATLoadFail(sb.toString(), cSJAdError.getMsg());
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                    public final void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                        TTATSplashAdapter.this.d = cSJSplashAd;
                        try {
                            Map<String, Object> mediaExtraInfo = TTATSplashAdapter.this.d.getMediaExtraInfo();
                            if (mediaExtraInfo != null) {
                                if (TTATSplashAdapter.this.m == null) {
                                    TTATSplashAdapter.this.m = new HashMap(3);
                                }
                                TTATSplashAdapter.this.m.putAll(mediaExtraInfo);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (TTATSplashAdapter.this.i) {
                            try {
                                TTATInitManager.getInstance().a(TTATSplashAdapter.this.m, TTATSplashAdapter.this.d, TTATSplashAdapter.this.mBiddingListener);
                            } catch (Throwable th2) {
                            }
                        } else if (TTATSplashAdapter.this.mLoadListener != null) {
                            TTATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                        }
                    }
                }, TTATSplashAdapter.this.mFetchAdTimeout);
            } catch (Exception e) {
                TTATSplashAdapter.this.notifyATLoadFail("", e.getMessage());
            }
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATSplashAdapter$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATSplashAdapter$3.class */
    final class AnonymousClass3 implements CSJSplashAd.SplashClickEyeListener {
        AnonymousClass3() {
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public final void onSplashClickEyeClick() {
            if (TTATSplashAdapter.this.mImpressionListener != null) {
                TTATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public final void onSplashClickEyeClose() {
            ATSplashEyeAdListener splashEyeAdListener;
            if (!TTATSplashAdapter.this.e || TTATSplashAdapter.this.f == null || (splashEyeAdListener = TTATSplashAdapter.this.f.getSplashEyeAdListener()) == null) {
                return;
            }
            splashEyeAdListener.onAdDismiss(true, "");
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public final void onSplashClickEyeReadyToShow(CSJSplashAd cSJSplashAd) {
            TTATSplashAdapter.this.e = true;
            TTATSplashAdapter tTATSplashAdapter = TTATSplashAdapter.this;
            tTATSplashAdapter.f = new TTATSplashEyeAd(tTATSplashAdapter, tTATSplashAdapter.d);
            TTATSplashAdapter.this.f.setSplashView(TTATSplashAdapter.this.g);
        }
    }

    private static int a(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = f2;
        if (f2 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f / f3) + 0.5f);
    }

    private void a() {
        if (this.l) {
            this.d.setSplashClickEyeListener(new AnonymousClass3());
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:1|(2:2|3)|(20:5|6|7|8|(1:10)|12|(1:14)|15|(1:17)|18|19|20|(1:22)|24|25|26|(1:28)|30|31|32)|39|6|7|8|(0)|12|(0)|15|(0)|18|19|20|(0)|24|25|26|(0)|30|31|32) */
    /* JADX WARN: Can't wrap try/catch for region: R(24:1|2|3|(20:5|6|7|8|(1:10)|12|(1:14)|15|(1:17)|18|19|20|(1:22)|24|25|26|(1:28)|30|31|32)|39|6|7|8|(0)|12|(0)|15|(0)|18|19|20|(0)|24|25|26|(0)|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0077, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0078, code lost:
        r10.printStackTrace();
        r12 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0064 A[Catch: all -> 0x0077, TRY_LEAVE, TryCatch #0 {all -> 0x0077, blocks: (B:10:0x0059, B:12:0x0064), top: B:36:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d9 A[Catch: Exception -> 0x0111, TryCatch #3 {Exception -> 0x0111, blocks: (B:22:0x00ce, B:24:0x00d9), top: B:42:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f8 A[Catch: Exception -> 0x0115, TryCatch #1 {Exception -> 0x0115, blocks: (B:26:0x00ee, B:28:0x00f8), top: B:38:0x00ee }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r8, java.util.Map<java.lang.String, java.lang.Object> r9, java.util.Map<java.lang.String, java.lang.Object> r10) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.toutiao.TTATSplashAdapter.a(android.content.Context, java.util.Map, java.util.Map):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:1|(2:2|3)|(20:5|6|7|8|(1:10)|12|(1:14)|15|(1:17)|18|19|20|(1:22)|24|25|26|(1:28)|30|31|32)|39|6|7|8|(0)|12|(0)|15|(0)|18|19|20|(0)|24|25|26|(0)|30|31|32) */
    /* JADX WARN: Can't wrap try/catch for region: R(24:1|2|3|(20:5|6|7|8|(1:10)|12|(1:14)|15|(1:17)|18|19|20|(1:22)|24|25|26|(1:28)|30|31|32)|39|6|7|8|(0)|12|(0)|15|(0)|18|19|20|(0)|24|25|26|(0)|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0077, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0078, code lost:
        r10.printStackTrace();
        r12 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0064 A[Catch: all -> 0x0077, TRY_LEAVE, TryCatch #0 {all -> 0x0077, blocks: (B:10:0x0059, B:12:0x0064), top: B:36:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d9 A[Catch: Exception -> 0x0111, TryCatch #3 {Exception -> 0x0111, blocks: (B:22:0x00ce, B:24:0x00d9), top: B:42:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f8 A[Catch: Exception -> 0x0115, TryCatch #1 {Exception -> 0x0115, blocks: (B:26:0x00ee, B:28:0x00f8), top: B:38:0x00ee }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(com.anythink.network.toutiao.TTATSplashAdapter r7, android.content.Context r8, java.util.Map r9, java.util.Map r10) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.toutiao.TTATSplashAdapter.a(com.anythink.network.toutiao.TTATSplashAdapter, android.content.Context, java.util.Map, java.util.Map):void");
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.b)) {
            return false;
        }
        this.h = ATInitMediation.getStringFromMap(map, "payload");
        this.f9146c = ATInitMediation.getStringFromMap(map, "personalized_template", "0");
        return true;
    }

    static /* synthetic */ boolean h(TTATSplashAdapter tTATSplashAdapter) {
        tTATSplashAdapter.n = true;
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.m;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return TTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return TTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public IATSplashEyeAd getSplashEyeAd() {
        return this.f;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        return this.d != null;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        boolean z;
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.b)) {
            z = false;
        } else {
            this.h = ATInitMediation.getStringFromMap(map, "payload");
            this.f9146c = ATInitMediation.getStringFromMap(map, "personalized_template", "0");
            z = true;
        }
        if (z) {
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATSplashAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TTATSplashAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        if (TTATSplashAdapter.this.getMixedFormatAdType() == 0) {
                            TTATSplashAdapter.this.thirdPartyLoad(new TTATAdapter(), context, map, map2);
                        } else {
                            TTATSplashAdapter.a(TTATSplashAdapter.this, context, map, map2);
                        }
                    } catch (Throwable th) {
                        TTATSplashAdapter.this.notifyATLoadFail("", th.getMessage());
                    }
                }
            });
        } else {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClick(CSJSplashAd cSJSplashAd) {
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClose(CSJSplashAd cSJSplashAd, int i) {
        if (i == 1) {
            this.mDismissType = 2;
            if (this.l && cSJSplashAd != null) {
                cSJSplashAd.startClickEye();
            }
        } else if (i == 2) {
            this.mDismissType = 3;
        } else if (i == 3) {
            this.mDismissType = 4;
        }
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdShow(CSJSplashAd cSJSplashAd) {
        try {
            TTATInitManager.getInstance().a(getTrackingInfo().l(), new WeakReference(this.d));
        } catch (Throwable th) {
        }
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdShow();
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (this.d != null) {
            if (isCustomSkipView()) {
                this.d.hideSkipButton();
            }
            this.d.setDownloadListener(this.j);
            if (this.l) {
                this.d.setSplashClickEyeListener(new AnonymousClass3());
            }
            this.d.setSplashAdListener(this);
            View splashView = this.d.getSplashView();
            if (splashView != null) {
                if (!this.l) {
                    viewGroup.addView(splashView, new ViewGroup.LayoutParams(-1, -1));
                    return;
                }
                this.g = splashView;
                viewGroup.addView(splashView, new ViewGroup.LayoutParams(-1, -1));
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.i = true;
        if (getMixedFormatAdType() == 0) {
            return false;
        }
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void startSplashCustomSkipViewClickEye() {
        CSJSplashAd cSJSplashAd = this.d;
        if (cSJSplashAd != null) {
            cSJSplashAd.startClickEye();
        }
    }
}
