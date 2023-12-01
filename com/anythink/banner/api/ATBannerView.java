package com.anythink.banner.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.banner.a.d;
import com.anythink.banner.a.e;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.a;
import com.anythink.core.common.b.b;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.a.c;
import com.anythink.core.common.k.a.f;
import com.anythink.core.common.k.s;
import com.anythink.core.common.v;
import com.anythink.core.common.w;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/banner/api/ATBannerView.class */
public class ATBannerView extends FrameLayout implements d {
    private final String TAG;
    a adLoadListener;
    private boolean canRenderBanner;
    boolean hasTouchWindow;
    c impressionTracker;
    private com.anythink.banner.a.a mAdLoadManager;
    b mAdSourceEventListener;
    private com.anythink.banner.b.a mBannerRefreshTimer;
    CustomBannerAdapter mCustomBannerAd;
    ATAdSourceStatusListener mDeveloperStatusListener;
    ATEventInterface mDownloadListener;
    private e mInnerBannerListener;
    boolean mIsRefresh;
    private ATBannerListener mListener;
    private String mPlacementId;
    private String mScenario;
    Map<String, Object> mTKExtraMap;
    f.b visibilityChecker;

    public ATBannerView(Context context) {
        super(context);
        this.TAG = ATBannerView.class.getSimpleName();
        this.mScenario = "";
        this.hasTouchWindow = false;
        this.mIsRefresh = false;
        this.mInnerBannerListener = new e() { // from class: com.anythink.banner.api.ATBannerView.1
            @Override // com.anythink.banner.a.e
            public void onBannerClicked(final CustomBannerAdapter customBannerAdapter) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClicked(j.a(customBannerAdapter));
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onBannerClose(final CustomBannerAdapter customBannerAdapter) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClose(j.a(customBannerAdapter));
                        }
                    }
                });
                ATBannerView.this.canRenderBanner = true;
                ATBannerView.this.loadAd(1);
            }

            @Override // com.anythink.banner.a.e
            public void onBannerShow(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            if (customBannerAdapter == null || !z) {
                                ATBannerView.this.mListener.onBannerShow(j.a(customBannerAdapter));
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(j.a(customBannerAdapter));
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onDeeplinkCallback(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDeeplinkCallback(ATBannerView.this.mIsRefresh, j.a(customBannerAdapter), z);
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onDownloadConfirm(final Context context2, final CustomBannerAdapter customBannerAdapter, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDownloadConfirm(context2, j.a(customBannerAdapter), aTNetworkConfirmInfo);
                    }
                });
            }
        };
        this.adLoadListener = new a() { // from class: com.anythink.banner.api.ATBannerView.2
            @Override // com.anythink.core.common.b.a
            public void onAdLoadFail(final AdError adError) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !ATBannerView.this.canRenderBanner) {
                            return;
                        }
                        if (ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerAutoRefreshFail(adError);
                        } else {
                            ATBannerView.this.mListener.onBannerFailed(adError);
                        }
                    }
                });
                if (ATBannerView.this.mAdLoadManager == null || !ATBannerView.this.isInView() || ATBannerView.this.mBannerRefreshTimer.a()) {
                    return;
                }
                String unused = ATBannerView.this.TAG;
                ATBannerView.this.mBannerRefreshTimer.b();
            }

            @Override // com.anythink.core.common.b.a
            public void onAdLoaded() {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null && !ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerLoaded();
                        }
                        ATBannerView.this.controlShow();
                    }
                });
            }
        };
        this.mBannerRefreshTimer = new com.anythink.banner.b.a(this);
    }

    public ATBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = ATBannerView.class.getSimpleName();
        this.mScenario = "";
        this.hasTouchWindow = false;
        this.mIsRefresh = false;
        this.mInnerBannerListener = new e() { // from class: com.anythink.banner.api.ATBannerView.1
            @Override // com.anythink.banner.a.e
            public void onBannerClicked(final CustomBannerAdapter customBannerAdapter) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClicked(j.a(customBannerAdapter));
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onBannerClose(final CustomBannerAdapter customBannerAdapter) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClose(j.a(customBannerAdapter));
                        }
                    }
                });
                ATBannerView.this.canRenderBanner = true;
                ATBannerView.this.loadAd(1);
            }

            @Override // com.anythink.banner.a.e
            public void onBannerShow(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            if (customBannerAdapter == null || !z) {
                                ATBannerView.this.mListener.onBannerShow(j.a(customBannerAdapter));
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(j.a(customBannerAdapter));
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onDeeplinkCallback(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDeeplinkCallback(ATBannerView.this.mIsRefresh, j.a(customBannerAdapter), z);
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onDownloadConfirm(final Context context2, final CustomBannerAdapter customBannerAdapter, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDownloadConfirm(context2, j.a(customBannerAdapter), aTNetworkConfirmInfo);
                    }
                });
            }
        };
        this.adLoadListener = new a() { // from class: com.anythink.banner.api.ATBannerView.2
            @Override // com.anythink.core.common.b.a
            public void onAdLoadFail(final AdError adError) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !ATBannerView.this.canRenderBanner) {
                            return;
                        }
                        if (ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerAutoRefreshFail(adError);
                        } else {
                            ATBannerView.this.mListener.onBannerFailed(adError);
                        }
                    }
                });
                if (ATBannerView.this.mAdLoadManager == null || !ATBannerView.this.isInView() || ATBannerView.this.mBannerRefreshTimer.a()) {
                    return;
                }
                String unused = ATBannerView.this.TAG;
                ATBannerView.this.mBannerRefreshTimer.b();
            }

            @Override // com.anythink.core.common.b.a
            public void onAdLoaded() {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null && !ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerLoaded();
                        }
                        ATBannerView.this.controlShow();
                    }
                });
            }
        };
        this.mBannerRefreshTimer = new com.anythink.banner.b.a(this);
    }

    public ATBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = ATBannerView.class.getSimpleName();
        this.mScenario = "";
        this.hasTouchWindow = false;
        this.mIsRefresh = false;
        this.mInnerBannerListener = new e() { // from class: com.anythink.banner.api.ATBannerView.1
            @Override // com.anythink.banner.a.e
            public void onBannerClicked(final CustomBannerAdapter customBannerAdapter) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClicked(j.a(customBannerAdapter));
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onBannerClose(final CustomBannerAdapter customBannerAdapter) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            ATBannerView.this.mListener.onBannerClose(j.a(customBannerAdapter));
                        }
                    }
                });
                ATBannerView.this.canRenderBanner = true;
                ATBannerView.this.loadAd(1);
            }

            @Override // com.anythink.banner.a.e
            public void onBannerShow(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            if (customBannerAdapter == null || !z) {
                                ATBannerView.this.mListener.onBannerShow(j.a(customBannerAdapter));
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(j.a(customBannerAdapter));
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onDeeplinkCallback(final CustomBannerAdapter customBannerAdapter, final boolean z) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDeeplinkCallback(ATBannerView.this.mIsRefresh, j.a(customBannerAdapter), z);
                    }
                });
            }

            @Override // com.anythink.banner.a.e
            public void onDownloadConfirm(final Context context2, final CustomBannerAdapter customBannerAdapter, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !(ATBannerView.this.mListener instanceof ATBannerExListener)) {
                            return;
                        }
                        ((ATBannerExListener) ATBannerView.this.mListener).onDownloadConfirm(context2, j.a(customBannerAdapter), aTNetworkConfirmInfo);
                    }
                });
            }
        };
        this.adLoadListener = new a() { // from class: com.anythink.banner.api.ATBannerView.2
            @Override // com.anythink.core.common.b.a
            public void onAdLoadFail(final AdError adError) {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener == null || !ATBannerView.this.canRenderBanner) {
                            return;
                        }
                        if (ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerAutoRefreshFail(adError);
                        } else {
                            ATBannerView.this.mListener.onBannerFailed(adError);
                        }
                    }
                });
                if (ATBannerView.this.mAdLoadManager == null || !ATBannerView.this.isInView() || ATBannerView.this.mBannerRefreshTimer.a()) {
                    return;
                }
                String unused = ATBannerView.this.TAG;
                ATBannerView.this.mBannerRefreshTimer.b();
            }

            @Override // com.anythink.core.common.b.a
            public void onAdLoaded() {
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null && !ATBannerView.this.mIsRefresh) {
                            ATBannerView.this.mListener.onBannerLoaded();
                        }
                        ATBannerView.this.controlShow();
                    }
                });
            }
        };
        this.mBannerRefreshTimer = new com.anythink.banner.b.a(this);
    }

    private boolean checkVisibilityPercent() {
        if (this.visibilityChecker == null) {
            this.visibilityChecker = new f.b();
        }
        if (getParent() != null) {
            return this.visibilityChecker.a((View) getParent(), this, 80, 0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.anythink.core.common.e.b getBannerCache() {
        return com.anythink.core.common.a.a().a(getContext(), this.mPlacementId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInView() {
        if (this.hasTouchWindow && isShown()) {
            return this.mCustomBannerAd == null || checkVisibilityPercent();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRefreshOpen() {
        com.anythink.core.c.d a = com.anythink.core.c.e.a(getContext().getApplicationContext()).a(this.mPlacementId);
        return a != null && a.V() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(int i) {
        com.anythink.core.common.k.n.a(this.mPlacementId, g.i.i, g.i.q, g.i.h, "", true);
        this.mIsRefresh = i == 1;
        if (i == 0) {
            this.canRenderBanner = true;
        }
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.a(getContext(), i, this.adLoadListener, this.mAdSourceEventListener, this.mTKExtraMap);
        } else {
            this.adLoadListener.onAdLoadFail(ErrorCode.getErrorCode(ErrorCode.placeStrategyError, "", ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBannerImpression(final Context context, final ATBaseAdAdapter aTBaseAdAdapter, final boolean z) {
        final com.anythink.core.common.e.e trackingInfo = aTBaseAdAdapter.getTrackingInfo();
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.6
            @Override // java.lang.Runnable
            public void run() {
                com.anythink.core.common.k.g.a(trackingInfo, g.i.c, g.i.f, "");
                com.anythink.core.common.j.a.a(context).a(4, trackingInfo, aTBaseAdAdapter.getUnitGroupInfo());
                n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.6.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATBannerView.this.mListener != null) {
                            if (aTBaseAdAdapter == null || !z) {
                                ATBannerView.this.mListener.onBannerShow(j.a(aTBaseAdAdapter));
                            } else {
                                ATBannerView.this.mListener.onBannerAutoRefreshed(j.a(aTBaseAdAdapter));
                            }
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBannerShow(final Context context, final com.anythink.core.common.e.b bVar, final boolean z) {
        final ATBaseAdAdapter e = bVar.e();
        final com.anythink.core.common.e.e trackingInfo = e.getTrackingInfo();
        trackingInfo.v = w.a().b(trackingInfo.W());
        final long currentTimeMillis = System.currentTimeMillis();
        if (trackingInfo != null && TextUtils.isEmpty(trackingInfo.l())) {
            trackingInfo.h(com.anythink.core.common.k.g.a(trackingInfo.X(), trackingInfo.x(), currentTimeMillis));
        }
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.5
            @Override // java.lang.Runnable
            public final void run() {
                if (trackingInfo != null) {
                    s.a(ATBannerView.this.getContext(), trackingInfo);
                    com.anythink.core.common.a.a().a(context.getApplicationContext(), bVar);
                    com.anythink.core.common.j.a.a(context).a(13, trackingInfo, e.getUnitGroupInfo(), currentTimeMillis);
                    if (e.supportImpressionCallback()) {
                        return;
                    }
                    ATBannerView.this.notifyBannerImpression(context, e, z);
                }
            }
        });
    }

    private void registerDelayShow(final Context context, final com.anythink.core.common.e.b bVar, CustomBannerAdapter customBannerAdapter, final boolean z) {
        View bannerView = customBannerAdapter.getBannerView();
        View view = bannerView;
        if (bannerView == null) {
            view = this;
        }
        c cVar = this.impressionTracker;
        if (cVar != null) {
            cVar.a(view, new com.anythink.core.common.k.a.a() { // from class: com.anythink.banner.api.ATBannerView.3
                @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
                public final int getImpressionMinPercentageViewed() {
                    return 50;
                }

                @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
                public final int getImpressionMinTimeViewed() {
                    return 0;
                }

                @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
                public final void recordImpression(View view2) {
                    ATBannerView.this.notifyBannerShow(context, bVar, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderBannerView(com.anythink.core.common.e.b bVar, boolean z) {
        CustomBannerAdapter customBannerAdapter = (bVar == null || !(bVar.e() instanceof CustomBannerAdapter)) ? null : (CustomBannerAdapter) bVar.e();
        if (customBannerAdapter != null) {
            CustomBannerAdapter customBannerAdapter2 = this.mCustomBannerAd;
            if (customBannerAdapter2 != null) {
                customBannerAdapter2.destory();
            }
            View bannerView = customBannerAdapter.getBannerView();
            if (bannerView != null && bannerView.getParent() != null && bannerView.getParent() != this) {
                ((ViewGroup) bannerView.getParent()).removeView(bannerView);
            }
            this.mCustomBannerAd = customBannerAdapter;
            if (bannerView != null) {
                com.anythink.core.common.e.e trackingInfo = customBannerAdapter.getTrackingInfo();
                trackingInfo.C = this.mScenario;
                s.a(this.mTKExtraMap, trackingInfo);
                customBannerAdapter.setAdEventListener(new com.anythink.banner.a.b(this.mInnerBannerListener, customBannerAdapter, z));
                if (isInView()) {
                    notifyBannerShow(getContext().getApplicationContext(), bVar, z);
                } else {
                    registerDelayShow(getContext().getApplicationContext(), bVar, customBannerAdapter, z);
                }
                IExHandler b = n.a().b();
                if (b != null) {
                    customBannerAdapter.setAdDownloadListener(b.createDownloadListener(customBannerAdapter, null, this.mDownloadListener));
                }
                removeAllViews();
                int i = bannerView.getLayoutParams() != null ? bannerView.getLayoutParams().width : 0;
                int i2 = i;
                if (i == 0) {
                    i2 = -2;
                }
                int i3 = 0;
                if (bannerView.getLayoutParams() != null) {
                    i3 = bannerView.getLayoutParams().height;
                }
                if (i3 <= 0) {
                    i3 = -2;
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i3);
                layoutParams.gravity = 17;
                bannerView.setLayoutParams(layoutParams);
                if (bannerView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) bannerView.getParent()).removeView(bannerView);
                }
                addView(bannerView, layoutParams);
            } else {
                Log.e(this.TAG, "Network's banner view = null. Did you call destroy()?");
            }
            this.mAdLoadManager.a(bVar);
            this.mBannerRefreshTimer.b();
            if (isRefreshOpen()) {
                loadAd(1);
            }
        }
    }

    public ATAdStatusInfo checkAdStatus() {
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            Log.e(this.TAG, "SDK init error!");
            return new ATAdStatusInfo(false, false, null);
        }
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar == null) {
            Log.e(this.TAG, "PlacementId is empty!");
            return new ATAdStatusInfo(false, false, null);
        }
        ATAdStatusInfo a = aVar.a(getContext(), this.mTKExtraMap);
        com.anythink.core.common.k.n.b(this.mPlacementId, g.i.i, g.i.u, a.toString(), "");
        return a;
    }

    public List<ATAdInfo> checkValidAdCaches() {
        com.anythink.banner.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            return aVar.a(getContext());
        }
        return null;
    }

    protected void controlShow() {
        if (this.mAdLoadManager == null) {
            return;
        }
        final boolean z = this.mIsRefresh;
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ATBannerView.this.mAdLoadManager) {
                    if (!ATBannerView.this.canRenderBanner) {
                        String unused = ATBannerView.this.TAG;
                        return;
                    }
                    final com.anythink.core.common.e.b bannerCache = ATBannerView.this.getBannerCache();
                    boolean z2 = false;
                    if (bannerCache == null) {
                        z2 = false;
                        if (ATBannerView.this.isRefreshOpen()) {
                            z2 = false;
                            if (ATBannerView.this.mAdLoadManager != null) {
                                z2 = false;
                                if (!ATBannerView.this.mAdLoadManager.e()) {
                                    ATBannerView.this.loadAd(1);
                                    z2 = false;
                                    if (ATBannerView.this.hasTouchWindow) {
                                        z2 = false;
                                        if (ATBannerView.this.isShown()) {
                                            z2 = true;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (ATBannerView.this.isInView()) {
                        bannerCache.a(bannerCache.d() + 1);
                        ATBannerView.this.canRenderBanner = false;
                        n.a().a(new Runnable() { // from class: com.anythink.banner.api.ATBannerView.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ATBannerView.this.renderBannerView(bannerCache, z);
                            }
                        });
                        z2 = false;
                    } else {
                        if (ATBannerView.this.hasTouchWindow && ATBannerView.this.isShown()) {
                            z2 = true;
                            String unused2 = ATBannerView.this.TAG;
                        }
                        ATBannerView.this.mBannerRefreshTimer.d();
                        String unused22 = ATBannerView.this.TAG;
                    }
                    if (z2 && ATBannerView.this.mBannerRefreshTimer != null && ATBannerView.this.mBannerRefreshTimer.c()) {
                        ATBannerView.this.mBannerRefreshTimer.b();
                    }
                }
            }
        });
    }

    public void destroy() {
        removeAllViews();
        CustomBannerAdapter customBannerAdapter = this.mCustomBannerAd;
        if (customBannerAdapter != null) {
            customBannerAdapter.destory();
        }
        com.anythink.banner.b.a aVar = this.mBannerRefreshTimer;
        if (aVar != null) {
            aVar.d();
        }
        c cVar = this.impressionTracker;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void loadAd() {
        loadAd(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.hasTouchWindow = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hasTouchWindow = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            controlShow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            controlShow();
        }
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        IExHandler b;
        this.mDownloadListener = aTEventInterface;
        if (this.mCustomBannerAd == null || (b = n.a().b()) == null) {
            return;
        }
        CustomBannerAdapter customBannerAdapter = this.mCustomBannerAd;
        customBannerAdapter.setAdDownloadListener(b.createDownloadListener(customBannerAdapter, null, this.mDownloadListener));
    }

    public void setAdSourceStatusListener(ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (this.mAdSourceEventListener == null) {
            this.mAdSourceEventListener = new b();
        }
        this.mDeveloperStatusListener = aTAdSourceStatusListener;
        this.mAdSourceEventListener.a(aTAdSourceStatusListener);
    }

    public void setBannerAdListener(ATBannerListener aTBannerListener) {
        this.mListener = aTBannerListener;
    }

    public void setLocalExtra(Map<String, Object> map) {
        if (TextUtils.isEmpty(this.mPlacementId)) {
            Log.e(this.TAG, "You must set unit Id first.");
        } else {
            v.a().a(this.mPlacementId, map);
        }
    }

    public void setPlacementId(String str) {
        this.mAdLoadManager = com.anythink.banner.a.a.a(getContext(), str);
        this.mPlacementId = str;
        this.mBannerRefreshTimer.a(str);
        if (this.impressionTracker == null) {
            getContext();
            this.impressionTracker = new c(50);
        }
    }

    public void setScenario(String str) {
        if (com.anythink.core.common.k.g.c(str)) {
            this.mScenario = str;
        }
    }

    public void setTKExtra(Map<String, Object> map) {
        if (this.mTKExtraMap == null) {
            this.mTKExtraMap = new ConcurrentHashMap();
        }
        this.mTKExtraMap.clear();
        this.mTKExtraMap.putAll(map);
    }

    @Override // com.anythink.banner.a.d
    public void timeUpRefreshView() {
        this.canRenderBanner = true;
        controlShow();
    }
}
