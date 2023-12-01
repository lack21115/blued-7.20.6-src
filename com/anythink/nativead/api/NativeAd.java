package com.anythink.nativead.api;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomVideo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.l;
import com.anythink.core.common.e.b;
import com.anythink.core.common.e.e;
import com.anythink.core.common.f;
import com.anythink.core.common.k.n;
import com.anythink.core.common.k.s;
import com.anythink.core.common.v;
import com.anythink.core.common.w;
import com.anythink.nativead.unitgroup.a;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/api/NativeAd.class */
public class NativeAd {
    private boolean hasSetShowTkDetail;
    private b mAdCacheInfo;
    protected a mBaseNativeAd;
    DownloadConfirmListener mConfirmListener;
    private Context mContext;
    private ATNativeDislikeListener mDislikeListener;
    ATEventInterface mEventInterface;
    private boolean mIsDestroyed;
    private ATNativeEventListener mNativeEventListener;
    ATNativeAdView mNativeView;
    private String mPlacementId;
    private boolean mRecordedImpression;
    private boolean mRecordedShow;
    ATNativeMaterial nativeMaterial;
    private final String TAG = getClass().getSimpleName();
    View.OnClickListener mDefaultCloseViewListener = new View.OnClickListener() { // from class: com.anythink.nativead.api.NativeAd.4
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            if (NativeAd.this.mBaseNativeAd != null) {
                NativeAd.this.mBaseNativeAd.notifyAdDislikeClick();
            }
        }
    };
    boolean isManualImpressionTrack = false;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/api/NativeAd$DownloadConfirmListener.class */
    public interface DownloadConfirmListener {
        void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/api/NativeAd$ImpressionEventListener.class */
    public interface ImpressionEventListener {
        void onImpression();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NativeAd(Context context, String str, b bVar) {
        this.mContext = context.getApplicationContext();
        this.mPlacementId = str;
        this.mAdCacheInfo = bVar;
        a aVar = (a) bVar.f();
        this.mBaseNativeAd = aVar;
        aVar.setNativeEventListener(new l() { // from class: com.anythink.nativead.api.NativeAd.1
            public final void onAdClicked(View view) {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleClick(nativeAd.mNativeView, view);
            }

            public final void onAdDislikeButtonClick() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleAdDislikeButtonClick(nativeAd.mNativeView);
            }

            public final void onAdImpressed() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleImpression(nativeAd.mNativeView);
            }

            public final void onAdVideoEnd() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleVideoEnd(nativeAd.mNativeView);
            }

            public final void onAdVideoProgress(int i) {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleVideoProgress(nativeAd.mNativeView, i);
            }

            public final void onAdVideoStart() {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleVideoStart(nativeAd.mNativeView);
            }

            public final void onDeeplinkCallback(boolean z) {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.handleDeeplinkCallback(nativeAd.mNativeView, z);
            }

            public final void onDownloadConfirmCallback(Context context2, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                NativeAd.this.handleDownloadConfirm(context2, view, aTNetworkConfirmInfo);
            }
        });
        a aVar2 = this.mBaseNativeAd;
        if (aVar2 instanceof CustomNativeAd) {
            this.nativeMaterial = new com.anythink.nativead.a.b((CustomNativeAd) aVar2);
        }
    }

    private void bindListener() {
        ATNativePrepareInfo nativePrepareInfo;
        View closeView;
        a aVar = this.mBaseNativeAd;
        if (aVar instanceof CustomNativeAd) {
            CustomNativeAd customNativeAd = (CustomNativeAd) aVar;
            if (customNativeAd.checkHasCloseViewListener() || (nativePrepareInfo = customNativeAd.getNativePrepareInfo()) == null || (closeView = nativePrepareInfo.getCloseView()) == null) {
                return;
            }
            closeView.setOnClickListener(this.mDefaultCloseViewListener);
        }
    }

    private void checkBindView(ATNativePrepareInfo aTNativePrepareInfo) {
        if (aTNativePrepareInfo == null) {
            return;
        }
        if (aTNativePrepareInfo.getTitleView() == null) {
            printNotSetViewLog("titleView");
        }
        if (aTNativePrepareInfo.getCtaView() == null) {
            printNotSetViewLog("ctaView");
        }
        if (aTNativePrepareInfo.getDescView() == null) {
            printNotSetViewLog("descView");
        }
        if (aTNativePrepareInfo.getIconView() == null) {
            printNotSetViewLog("iconView");
        }
        if (aTNativePrepareInfo.getMainImageView() == null) {
            printNotSetViewLog("mainImageView");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillShowTrackingInfo(e eVar) {
        synchronized (this) {
            if (!this.hasSetShowTkDetail) {
                String b = w.a().b(this.mPlacementId);
                this.hasSetShowTkDetail = true;
                if (eVar != null) {
                    eVar.v = b;
                    s.a(this.mContext, eVar);
                }
            }
        }
    }

    private void printNotSetViewLog(String str) {
        String str2 = this.TAG;
        Log.w(str2, "The " + str + " is not set, it may cause the ad to not be clicked normally.");
    }

    private void renderViewToWindow(View view) {
        n.b(this.mPlacementId, g.i.l, g.i.s, g.i.h, "");
        ViewGroup customAdContainer = this.mBaseNativeAd.getCustomAdContainer();
        int hashCode = hashCode();
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (customAdContainer != null) {
            if (customAdContainer.getParent() != null) {
                ((ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
            }
            customAdContainer.addView(view);
        }
        if (customAdContainer != null) {
            view = customAdContainer;
        }
        this.mNativeView.renderView(hashCode, view, new ImpressionEventListener() { // from class: com.anythink.nativead.api.NativeAd.3
            @Override // com.anythink.nativead.api.NativeAd.ImpressionEventListener
            public final void onImpression() {
                long currentTimeMillis = System.currentTimeMillis();
                e detail = NativeAd.this.mBaseNativeAd != null ? NativeAd.this.mBaseNativeAd.getDetail() : null;
                if (detail != null && TextUtils.isEmpty(detail.l())) {
                    detail.h(com.anythink.core.common.k.g.a(detail.X(), detail.x(), currentTimeMillis));
                }
                if (NativeAd.this.mBaseNativeAd instanceof CustomNativeAd) {
                    ((CustomNativeAd) NativeAd.this.mBaseNativeAd).setShowId(detail.l());
                }
                NativeAd nativeAd = NativeAd.this;
                nativeAd.recordShow(nativeAd.mNativeView);
            }
        });
    }

    public void clear(ATNativeAdView aTNativeAdView) {
        synchronized (this) {
            if (this.mIsDestroyed) {
                return;
            }
            try {
                if (this.mBaseNativeAd != null) {
                    this.mBaseNativeAd.clear(this.mNativeView);
                }
            } catch (Throwable th) {
            }
            if (this.mNativeView != null) {
                this.mNativeView.clearImpressionListener(hashCode());
                this.mNativeView = null;
            }
        }
    }

    public void destory() {
        synchronized (this) {
            if (this.mIsDestroyed) {
                return;
            }
            clear(this.mNativeView);
            this.mIsDestroyed = true;
            this.mNativeEventListener = null;
            this.mDislikeListener = null;
            this.mDefaultCloseViewListener = null;
            this.mNativeView = null;
            if (this.mBaseNativeAd != null) {
                this.mBaseNativeAd.destroy();
            }
        }
    }

    public ATAdInfo getAdInfo() {
        return j.a(this.mBaseNativeAd);
    }

    public int getAdInteractionType() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return 0;
        }
        return ((CustomNativeAd) aVar).getNativeAdInteractionType();
    }

    public ATNativeMaterial getAdMaterial() {
        return this.nativeMaterial;
    }

    @Deprecated
    public ATCustomVideo getCustomVideo() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return null;
        }
        return ((CustomNativeAd) aVar).getNativeCustomVideo();
    }

    public int getNativeType() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return 0;
        }
        return ((CustomNativeAd) aVar).getNativeType();
    }

    public double getVideoDuration() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return 0.0d;
        }
        return ((CustomNativeAd) aVar).getVideoDuration();
    }

    public double getVideoProgress() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return 0.0d;
        }
        return ((CustomNativeAd) aVar).getVideoProgress();
    }

    void handleAdDislikeButtonClick(final ATNativeAdView aTNativeAdView) {
        synchronized (this) {
            if (this.mIsDestroyed) {
                return;
            }
            com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.9
                @Override // java.lang.Runnable
                public final void run() {
                    if (NativeAd.this.mDislikeListener != null) {
                        NativeAd.this.mDislikeListener.onAdCloseButtonClick(aTNativeAdView, j.a(NativeAd.this.mBaseNativeAd));
                    }
                }
            });
        }
    }

    void handleClick(final ATNativeAdView aTNativeAdView, View view) {
        synchronized (this) {
            if (this.mIsDestroyed) {
                return;
            }
            if (this.mBaseNativeAd != null) {
                e detail = this.mBaseNativeAd.getDetail();
                com.anythink.core.common.k.g.a(detail, g.i.d, g.i.f, "");
                com.anythink.core.common.j.a.a(this.mContext.getApplicationContext()).a(6, detail);
            }
            com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.7
                @Override // java.lang.Runnable
                public final void run() {
                    if (NativeAd.this.mNativeEventListener != null) {
                        NativeAd.this.mNativeEventListener.onAdClicked(aTNativeAdView, j.a(NativeAd.this.mBaseNativeAd));
                    }
                }
            });
        }
    }

    void handleDeeplinkCallback(ATNativeAdView aTNativeAdView, boolean z) {
        synchronized (this) {
            if (this.mIsDestroyed) {
                return;
            }
            if (this.mNativeEventListener != null && (this.mNativeEventListener instanceof ATNativeEventExListener)) {
                ((ATNativeEventExListener) this.mNativeEventListener).onDeeplinkCallback(aTNativeAdView, j.a(this.mBaseNativeAd), z);
            }
        }
    }

    void handleDownloadConfirm(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        synchronized (this) {
            if (this.mIsDestroyed) {
                return;
            }
            if (this.mConfirmListener != null && this.mBaseNativeAd != null) {
                DownloadConfirmListener downloadConfirmListener = this.mConfirmListener;
                if (context == null) {
                    context = this.mContext;
                }
                downloadConfirmListener.onDownloadConfirm(context, j.a(this.mBaseNativeAd), view, aTNetworkConfirmInfo);
            }
        }
    }

    void handleImpression(final ATNativeAdView aTNativeAdView) {
        synchronized (this) {
            if (!this.mRecordedImpression && !this.mIsDestroyed) {
                this.mRecordedImpression = true;
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeAd.this.mIsDestroyed) {
                            return;
                        }
                        try {
                            if (NativeAd.this.mBaseNativeAd != null) {
                                e detail = NativeAd.this.mBaseNativeAd.getDetail();
                                com.anythink.core.common.k.g.a(detail, g.i.c, g.i.f, "");
                                NativeAd.this.fillShowTrackingInfo(detail);
                                com.anythink.core.common.j.a.a(NativeAd.this.mContext.getApplicationContext()).a(4, detail, NativeAd.this.mAdCacheInfo.e().getUnitGroupInfo());
                                com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.6.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        if (NativeAd.this.mNativeEventListener != null) {
                                            NativeAd.this.mNativeEventListener.onAdImpressed(aTNativeAdView, j.a(NativeAd.this.mBaseNativeAd));
                                        }
                                    }
                                });
                            }
                        } catch (Exception e) {
                            Log.e(com.heytap.msp.mobad.api.ad.NativeAd.TAG, "BaseNativeAd has been destotyed.");
                        }
                    }
                });
            }
        }
    }

    void handleVideoEnd(final ATNativeAdView aTNativeAdView) {
        synchronized (this) {
            if (this.mIsDestroyed) {
                return;
            }
            if (this.mBaseNativeAd != null) {
                e detail = this.mBaseNativeAd.getDetail();
                detail.t = 100;
                com.anythink.core.common.j.a.a(this.mContext.getApplicationContext()).a(9, detail);
            }
            com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.10
                @Override // java.lang.Runnable
                public final void run() {
                    if (NativeAd.this.mNativeEventListener != null) {
                        NativeAd.this.mNativeEventListener.onAdVideoEnd(aTNativeAdView);
                    }
                }
            });
        }
    }

    void handleVideoProgress(final ATNativeAdView aTNativeAdView, final int i) {
        synchronized (this) {
            if (this.mIsDestroyed) {
                return;
            }
            com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (NativeAd.this.mNativeEventListener != null) {
                        NativeAd.this.mNativeEventListener.onAdVideoProgress(aTNativeAdView, i);
                    }
                }
            });
        }
    }

    void handleVideoStart(final ATNativeAdView aTNativeAdView) {
        synchronized (this) {
            if (this.mIsDestroyed) {
                return;
            }
            if (this.mBaseNativeAd != null) {
                e detail = this.mBaseNativeAd.getDetail();
                detail.t = 0;
                com.anythink.core.common.j.a.a(this.mContext.getApplicationContext()).a(8, detail);
            }
            com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.8
                @Override // java.lang.Runnable
                public final void run() {
                    if (NativeAd.this.mNativeEventListener != null) {
                        NativeAd.this.mNativeEventListener.onAdVideoStart(aTNativeAdView);
                    }
                }
            });
        }
    }

    public boolean isNativeExpress() {
        a aVar = this.mBaseNativeAd;
        if (aVar == null || !(aVar instanceof CustomNativeAd)) {
            return false;
        }
        return ((CustomNativeAd) aVar).isNativeExpress();
    }

    public void manualImpressionTrack() {
        if (this.mIsDestroyed) {
            Log.e(this.TAG, "NativeAd had been destroyed.");
        } else if (!this.isManualImpressionTrack) {
            if (com.anythink.core.common.b.n.a().A()) {
                Log.e(this.TAG, "Must call \"setManualImpressionTrack(true);\" first.");
            }
        } else {
            ATNativeAdView aTNativeAdView = this.mNativeView;
            b bVar = this.mAdCacheInfo;
            ATBaseAdAdapter e = bVar != null ? bVar.e() : null;
            if (e != null && e.supportImpressionCallback()) {
                if (com.anythink.core.common.b.n.a().A()) {
                    Log.e(this.TAG, "This NativeAd don't support tracking impressions manually.");
                }
            } else if (aTNativeAdView == null) {
                if (com.anythink.core.common.b.n.a().A()) {
                    Log.e(this.TAG, "NativeAd don't call render.");
                }
            } else if (!aTNativeAdView.isShown()) {
                if (com.anythink.core.common.b.n.a().A()) {
                    Log.e(this.TAG, "ATNativeAdView isn't visible.");
                }
            } else {
                if (Build.VERSION.SDK_INT >= 19) {
                    if (!aTNativeAdView.isAttachedToWindow()) {
                        if (com.anythink.core.common.b.n.a().A()) {
                            Log.e(this.TAG, "ATNativeAdView don't attach window.");
                            return;
                        }
                        return;
                    }
                } else if (!aTNativeAdView.isAttachInWindow()) {
                    if (com.anythink.core.common.b.n.a().A()) {
                        Log.e(this.TAG, "ATNativeAdView don't attach window.");
                        return;
                    }
                    return;
                }
                if (com.anythink.core.common.b.n.a().A()) {
                    Log.i(this.TAG, "try to track impression manually.");
                }
                a aVar = this.mBaseNativeAd;
                if (aVar instanceof CustomNativeAd) {
                    ((CustomNativeAd) aVar).impressionTrack(aTNativeAdView);
                }
            }
        }
    }

    public void onPause() {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.onPause();
    }

    public void onResume() {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.onResume();
    }

    public void pauseVideo() {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.pauseVideo();
    }

    public void prepare(ATNativeAdView aTNativeAdView, ATNativePrepareInfo aTNativePrepareInfo) {
        synchronized (this) {
            if (this.mIsDestroyed) {
                return;
            }
            if (aTNativeAdView != null) {
                ATNativePrepareInfo aTNativePrepareInfo2 = aTNativePrepareInfo;
                if (aTNativePrepareInfo == null) {
                    aTNativePrepareInfo2 = new ATNativePrepareInfo();
                }
                this.mBaseNativeAd.setNativePrepareInfo(aTNativePrepareInfo2);
                this.mBaseNativeAd.prepare(aTNativeAdView, aTNativePrepareInfo2);
                bindListener();
                if (!this.mBaseNativeAd.isNativeExpress()) {
                    checkBindView(aTNativePrepareInfo2);
                }
            }
        }
    }

    void recordShow(ATNativeAdView aTNativeAdView) {
        synchronized (this) {
            if (!this.mRecordedShow) {
                final e detail = this.mBaseNativeAd.getDetail();
                this.mRecordedShow = true;
                if (this.mAdCacheInfo != null) {
                    this.mAdCacheInfo.a(this.mAdCacheInfo.d() + 1);
                    f b = v.a().b(this.mPlacementId);
                    if (b != null) {
                        b.a(this.mAdCacheInfo);
                        b.f();
                    }
                }
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.nativead.api.NativeAd.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (NativeAd.this.mIsDestroyed || NativeAd.this.mAdCacheInfo == null) {
                            return;
                        }
                        NativeAd.this.fillShowTrackingInfo(detail);
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            String[] split = detail.l().split("_");
                            currentTimeMillis = Long.parseLong(split[split.length - 1]);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (NativeAd.this.mBaseNativeAd != null && (NativeAd.this.mBaseNativeAd instanceof CustomNativeAd)) {
                            ((CustomNativeAd) NativeAd.this.mBaseNativeAd).setShowId(detail.l());
                        }
                        com.anythink.core.common.a.a().a(NativeAd.this.mContext.getApplicationContext(), NativeAd.this.mAdCacheInfo);
                        com.anythink.core.common.j.a.a(NativeAd.this.mContext).a(13, detail, NativeAd.this.mAdCacheInfo.e().getUnitGroupInfo(), currentTimeMillis);
                    }
                });
            }
        }
    }

    public void renderAdContainer(ATNativeAdView aTNativeAdView, View view) {
        View view2;
        synchronized (this) {
            if (this.mIsDestroyed) {
                return;
            }
            if (aTNativeAdView != null) {
                aTNativeAdView.clear();
            }
            if (!isNativeExpress()) {
                view2 = view;
                if (view == null) {
                    Log.e(com.anythink.expressad.d.b.f4297c, "renderAdContainer: selfRenderView cannot be null for self-rendering ads!");
                    return;
                }
            } else if (this.mBaseNativeAd == null) {
                view2 = null;
            } else if (aTNativeAdView == null) {
                Log.e(com.anythink.expressad.d.b.f4297c, "renderAdContainer: ATNativeAdView cannot be null for template-rendering ads!");
                return;
            } else {
                View adMediaView = this.mBaseNativeAd.getAdMediaView(aTNativeAdView, Integer.valueOf(aTNativeAdView.getWidth()));
                view2 = adMediaView;
                if (adMediaView == null) {
                    Log.e(com.anythink.expressad.d.b.f4297c, "renderAdContainer: getAdMediaView() cannot be null for template-rendering ads!");
                    return;
                }
            }
            this.mNativeView = aTNativeAdView;
            if (aTNativeAdView != null) {
                aTNativeAdView.attachNativeAd(this);
            }
            if (view2 != null) {
                view2.setVisibility(0);
                renderViewToWindow(view2);
            }
        }
    }

    public void resumeVideo() {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.resumeVideo();
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        this.mEventInterface = aTEventInterface;
        IExHandler b = com.anythink.core.common.b.n.a().b();
        if (b == null) {
            this.mBaseNativeAd.setDownloadListener(null);
            Log.e(this.TAG, "This method is not supported in this version");
        } else if (aTEventInterface != null) {
            this.mBaseNativeAd.setDownloadListener(b.createDownloadListener(this.mAdCacheInfo.e(), this.mBaseNativeAd, aTEventInterface));
        } else {
            this.mBaseNativeAd.setDownloadListener(null);
        }
    }

    public void setDislikeCallbackListener(ATNativeDislikeListener aTNativeDislikeListener) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mDislikeListener = aTNativeDislikeListener;
    }

    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        if (downloadConfirmListener != null) {
            a aVar = this.mBaseNativeAd;
            if (aVar instanceof CustomNativeAd) {
                ((CustomNativeAd) aVar).registerDownloadConfirmListener();
            }
        } else {
            a aVar2 = this.mBaseNativeAd;
            if (aVar2 instanceof CustomNativeAd) {
                ((CustomNativeAd) aVar2).unregeisterDownloadConfirmListener();
            }
        }
        this.mConfirmListener = downloadConfirmListener;
    }

    public void setManualImpressionTrack(boolean z) {
        this.isManualImpressionTrack = z;
    }

    public void setNativeEventListener(ATNativeEventListener aTNativeEventListener) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mNativeEventListener = aTNativeEventListener;
    }

    public void setVideoMute(boolean z) {
        a aVar;
        if (this.mIsDestroyed || (aVar = this.mBaseNativeAd) == null) {
            return;
        }
        aVar.setVideoMute(z);
    }
}
