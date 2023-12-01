package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.lang.ref.WeakReference;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATNativeExpressAd.class */
public class TTATNativeExpressAd extends CustomNativeAd {
    private static final String h = TTATNativeExpressAd.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    TTNativeExpressAd f9124a;
    Context b;

    /* renamed from: c  reason: collision with root package name */
    String f9125c;
    double d;
    double e;
    boolean f = false;
    View g;

    /* renamed from: com.anythink.network.toutiao.TTATNativeExpressAd$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATNativeExpressAd$3.class */
    final class AnonymousClass3 implements TTAdDislike.DislikeInteractionCallback {
        AnonymousClass3() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onCancel() {
        }

        @Deprecated
        public final void onRefuse() {
        }

        @Deprecated
        public final void onSelected(int i, String str) {
            TTATNativeExpressAd.this.notifyAdDislikeClick();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onSelected(int i, String str, boolean z) {
            TTATNativeExpressAd.this.notifyAdDislikeClick();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onShow() {
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATNativeExpressAd$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATNativeExpressAd$4.class */
    final class AnonymousClass4 implements TTNativeExpressAd.ExpressAdInteractionListener {
        AnonymousClass4() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdClicked(View view, int i) {
            TTATNativeExpressAd.this.notifyAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdShow(View view, int i) {
            Log.i(TTATNativeExpressAd.h, "onAdShow()");
            TTATInitManager.getInstance().a(TTATNativeExpressAd.this.getShowId(), new WeakReference(TTATNativeExpressAd.this.f9124a));
            TTATNativeExpressAd.this.notifyAdImpression();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderFail(View view, String str, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderSuccess(View view, float f, float f2) {
        }
    }

    public TTATNativeExpressAd(Context context, String str, TTNativeExpressAd tTNativeExpressAd, boolean z, boolean z2) {
        this.b = context.getApplicationContext();
        this.f9125c = str;
        this.f9124a = tTNativeExpressAd;
        setNetworkInfoMap(tTNativeExpressAd.getMediaExtraInfo());
        setAdData(z);
        TTNativeExpressAd tTNativeExpressAd2 = this.f9124a;
        if (tTNativeExpressAd2 != null) {
            tTNativeExpressAd2.setExpressInteractionListener(new AnonymousClass4());
        }
    }

    private void a(Activity activity) {
        TTNativeExpressAd tTNativeExpressAd = this.f9124a;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setDislikeCallback(activity, new AnonymousClass3());
    }

    private void b() {
        TTNativeExpressAd tTNativeExpressAd = this.f9124a;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setExpressInteractionListener(new AnonymousClass4());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        Log.i(h, "destroy()");
        this.g = null;
        TTNativeExpressAd tTNativeExpressAd = this.f9124a;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
            this.f9124a.destroy();
            this.f9124a = null;
        }
        this.b = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        try {
            if (this.g == null && this.f9124a != null) {
                this.g = this.f9124a.getExpressAdView();
            }
            return this.g;
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        return this.d;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (view == null || !(view.getContext() instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) view.getContext();
        TTNativeExpressAd tTNativeExpressAd = this.f9124a;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setDislikeCallback(activity, new AnonymousClass3());
        }
    }

    public void setAdData(boolean z) {
        this.f9124a.setCanInterruptVideoPlay(z);
        int i = this.f9124a.getInteractionType() == 4 ? 1 : 0;
        if (this.f9124a.getInteractionType() == 3) {
            i = 3;
        }
        if (this.f9124a.getInteractionType() == 2) {
            i = 2;
        }
        setNativeInteractionType(i);
        this.f9124a.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.anythink.network.toutiao.TTATNativeExpressAd.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onClickRetry() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onProgressUpdate(long j, long j2) {
                if (TTATNativeExpressAd.this.getVideoDuration() == 0.0d) {
                    TTATNativeExpressAd.this.setVideoDuration(j2 / 1000.0d);
                }
                TTATNativeExpressAd.this.d = j / 1000.0d;
                TTATNativeExpressAd tTATNativeExpressAd = TTATNativeExpressAd.this;
                tTATNativeExpressAd.notifyAdVideoPlayProgress((int) tTATNativeExpressAd.d);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoAdComplete() {
                TTATNativeExpressAd.this.notifyAdVideoEnd();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoAdContinuePlay() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoAdPaused() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoAdStartPlay() {
                TTATNativeExpressAd.this.notifyAdVideoStart();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoError(int i2, int i3) {
                Log.i(TTATNativeExpressAd.h, String.format("onVideoError, errorCode: %d, errorMsg: %s", Integer.valueOf(i2), String.valueOf(i3)));
                TTATNativeExpressAd.this.notifyAdVideoVideoPlayFail(String.valueOf(i2), String.valueOf(i3));
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoLoad() {
            }
        });
        this.f9124a.setDownloadListener(new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATNativeExpressAd.2
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadActive(long j, long j2, String str, String str2) {
                if (TTATNativeExpressAd.this.f) {
                    if (TTATNativeExpressAd.this.mDownloadListener == null || !(TTATNativeExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                        return;
                    }
                    ((CustomAdapterDownloadListener) TTATNativeExpressAd.this.mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                    return;
                }
                TTATNativeExpressAd.this.f = true;
                if (TTATNativeExpressAd.this.mDownloadListener == null || !(TTATNativeExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeExpressAd.this.mDownloadListener).onDownloadStart(j, j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadFailed(long j, long j2, String str, String str2) {
                if (TTATNativeExpressAd.this.mDownloadListener == null || !(TTATNativeExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeExpressAd.this.mDownloadListener).onDownloadFail(j, j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadFinished(long j, String str, String str2) {
                if (TTATNativeExpressAd.this.mDownloadListener == null || !(TTATNativeExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeExpressAd.this.mDownloadListener).onDownloadFinish(j, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadPaused(long j, long j2, String str, String str2) {
                if (TTATNativeExpressAd.this.mDownloadListener == null || !(TTATNativeExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeExpressAd.this.mDownloadListener).onDownloadPause(j, j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onInstalled(String str, String str2) {
                if (TTATNativeExpressAd.this.mDownloadListener == null || !(TTATNativeExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeExpressAd.this.mDownloadListener).onInstalled(str, str2);
            }
        });
        int imageMode = this.f9124a.getImageMode();
        if (imageMode != 2 && imageMode != 3 && imageMode != 4) {
            if (imageMode == 5 || imageMode == 15) {
                this.mAdSourceType = "1";
                return;
            } else if (imageMode != 16) {
                return;
            }
        }
        this.mAdSourceType = "2";
    }
}
