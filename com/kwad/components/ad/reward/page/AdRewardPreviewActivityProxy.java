package com.kwad.components.ad.reward.page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.model.RewardCallBackRespInfo;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.l.d;
import com.kwad.components.core.r.b;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.a;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bh;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/page/AdRewardPreviewActivityProxy.class */
public class AdRewardPreviewActivityProxy extends d {
    public static final String KEY_TEMPLATE = "key_template_json";
    private static final String KEY_URL = "key_langingpage_url";
    private static final String TAG = "AdRewardPreviewActivityProxy";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    public k mCloseDialog;
    private int mCount;
    private View mCountDownLayout;
    private TextView mCountDownTips;
    private long mLastDown;
    protected KsLogoView mLogoView;
    private int mSkipCount;
    private View mSkipCountDownBtn;
    private View mSkipCountDownDiv;
    private long mStartPlayTime;
    private bh mTimerHelper;
    private String mUrl;
    private ImageView mWebCloseBtn;
    private AdBaseFrameLayout mWebContainer;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mEnableSkip = false;
    private boolean counterPaused = false;
    private boolean mCheckExposureResult = true;

    static /* synthetic */ int access$410(AdRewardPreviewActivityProxy adRewardPreviewActivityProxy) {
        int i = adRewardPreviewActivityProxy.mCount;
        adRewardPreviewActivityProxy.mCount = i - 1;
        return i;
    }

    static /* synthetic */ int access$710(AdRewardPreviewActivityProxy adRewardPreviewActivityProxy) {
        int i = adRewardPreviewActivityProxy.mSkipCount;
        adRewardPreviewActivityProxy.mSkipCount = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRequest(final int i) {
        new m<com.kwad.components.core.n.d, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.7
            private static RewardCallBackRespInfo R(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: gq */
            public com.kwad.components.core.n.d createRequest() {
                return new com.kwad.components.core.n.d(i, AdRewardPreviewActivityProxy.this.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.m
            public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
                return R(str);
            }
        }.request(exposureRequest());
    }

    private p<com.kwad.components.core.n.d, RewardCallBackRespInfo> exposureRequest() {
        return new p<com.kwad.components.core.n.d, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.8
            private void a(RewardCallBackRespInfo rewardCallBackRespInfo) {
                AdRewardPreviewActivityProxy adRewardPreviewActivityProxy = AdRewardPreviewActivityProxy.this;
                boolean z = true;
                if (rewardCallBackRespInfo.result != 1) {
                    z = false;
                }
                adRewardPreviewActivityProxy.mCheckExposureResult = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(com.kwad.components.core.n.d dVar, int i, String str) {
                super.onError(dVar, i, str);
                AdRewardPreviewActivityProxy.this.mCheckExposureResult = false;
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* bridge */ /* synthetic */ void onStartRequest(g gVar) {
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(g gVar, BaseResultData baseResultData) {
                a((RewardCallBackRespInfo) baseResultData);
            }
        };
    }

    private y.b getClientParams() {
        y.b bVar = new y.b();
        bVar.akv = 0;
        return bVar;
    }

    private KsAdWebView.d getWebErrorListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.5
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
                if (!AdRewardPreviewActivityProxy.this.mAdTemplate.mPvReported) {
                    AdRewardPreviewActivityProxy.this.checkExposure();
                }
                b.pK().a(AdRewardPreviewActivityProxy.this.mAdTemplate, null, null);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str, String str2) {
            }
        };
    }

    public static void launch(Activity activity, AdTemplate adTemplate, String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        mInteractionListener = rewardAdInteractionListener;
        a.a(AdWebViewActivity.class, AdRewardPreviewActivityProxy.class);
        Intent intent = new Intent(activity, AdWebViewActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_URL, str);
        try {
            activity.startActivity(intent);
            activity.overridePendingTransition(0, 0);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            com.kwad.sdk.crash.b.g(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCloseDialog() {
        k kVar = this.mCloseDialog;
        if (kVar == null || !kVar.isShowing()) {
            int i = this.mCount;
            this.mCloseDialog = k.a(getActivity(), this.mAdTemplate, k.M("还差" + (i + 1) + "秒就可以获取奖励"), new k.b() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.9
                @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
                public final void J(boolean z) {
                    AdRewardPreviewActivityProxy.this.counterPaused = false;
                    if (AdRewardPreviewActivityProxy.mInteractionListener != null) {
                        try {
                            AdRewardPreviewActivityProxy.mInteractionListener.onVideoSkipToEnd(System.currentTimeMillis() - AdRewardPreviewActivityProxy.this.mStartPlayTime);
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                    AdRewardPreviewActivityProxy.this.finish();
                }

                @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
                public final void fZ() {
                    AdRewardPreviewActivityProxy.this.counterPaused = true;
                }

                @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
                public final void gh() {
                    AdRewardPreviewActivityProxy.this.counterPaused = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void skipToEnd() {
        this.mCountDownLayout.setVisibility(8);
        this.mWebCloseBtn.setVisibility(0);
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener == null || !this.mCheckExposureResult) {
            return;
        }
        rewardAdInteractionListener.onRewardVerify();
        try {
            mInteractionListener.onRewardStepVerify(0, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    public void checkExposure() {
        long j = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate).adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j <= 0 || com.kwad.sdk.core.response.a.a.X(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) <= 5000) {
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.6
            @Override // java.lang.Runnable
            public final void run() {
                AdRewardPreviewActivityProxy.this.checkRequest(1);
            }
        }, j);
    }

    @Override // com.kwad.components.core.l.d
    public boolean checkIntentData(Intent intent) {
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
        if (this.mAdTemplate == null) {
            com.kwad.sdk.g.a.V("reward", "show");
            return false;
        }
        return true;
    }

    @Override // com.kwad.components.core.l.d
    public int getLayoutId() {
        return R.layout.ksad_activity_reward_preview;
    }

    @Override // com.kwad.components.core.l.d
    public String getPageName() {
        return TAG;
    }

    public bh getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bh();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.components.core.l.d
    public void initData() {
        this.mUrl = getIntent().getStringExtra(KEY_URL);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        int i = cb.adStyleInfo.adBrowseInfo.adBrowseDuration;
        int V = com.kwad.sdk.core.response.a.a.V(cb);
        this.mCount = i;
        this.mSkipCount = Math.min(V, i);
        this.mStartPlayTime = System.currentTimeMillis();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            try {
                rewardAdInteractionListener.onVideoPlayStart();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
    }

    @Override // com.kwad.components.core.l.d
    public void initView() {
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().b(getClientParams()).ct(this.mAdTemplate).bc(false).be(true).b(getWebErrorListener()));
        this.mAdWebView.onActivityCreate();
        this.mWebCloseBtn = (ImageView) findViewById(R.id.ksad_web_close_btn);
        this.mWebContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_landing_page_root);
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.ksad_reward_preview_logo);
        this.mLogoView = ksLogoView;
        ksLogoView.S(this.mAdTemplate);
        this.mWebCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (AdRewardPreviewActivityProxy.mInteractionListener != null) {
                    try {
                        AdRewardPreviewActivityProxy.mInteractionListener.onVideoPlayEnd();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
                com.kwad.sdk.core.report.a.a(AdRewardPreviewActivityProxy.this.mAdTemplate, 1, AdRewardPreviewActivityProxy.this.getTimerHelper().getTime(), (JSONObject) null);
                AdRewardPreviewActivityProxy.this.finish();
            }
        });
        this.mCountDownLayout = findViewById(R.id.ksad_reward_preview_skip_layout);
        this.mSkipCountDownDiv = findViewById(R.id.ksad_reward_preview_skip_div);
        this.mSkipCountDownBtn = findViewById(R.id.ksad_reward_preview_skip_btn);
        this.mCountDownTips = (TextView) findViewById(R.id.ksad_reward_preview_skip_time);
        if (this.mSkipCount <= 0) {
            this.mSkipCountDownBtn.setVisibility(0);
            this.mSkipCountDownDiv.setVisibility(0);
        } else {
            this.mSkipCountDownBtn.setVisibility(8);
            this.mSkipCountDownDiv.setVisibility(8);
        }
        this.mSkipCountDownBtn.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                AdRewardPreviewActivityProxy.this.showCloseDialog();
            }
        });
        TextView textView = this.mCountDownTips;
        textView.setText("激励领取视频还有" + this.mCount + "秒");
        this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.3
            @Override // java.lang.Runnable
            public final void run() {
                if (AdRewardPreviewActivityProxy.this.counterPaused) {
                    AdRewardPreviewActivityProxy.this.mHandler.postDelayed(this, 400L);
                    return;
                }
                if (AdRewardPreviewActivityProxy.this.mCount <= 0) {
                    AdRewardPreviewActivityProxy.this.mEnableSkip = true;
                    AdRewardPreviewActivityProxy.this.skipToEnd();
                } else {
                    if (AdRewardPreviewActivityProxy.this.mSkipCount <= 0) {
                        AdRewardPreviewActivityProxy.this.mSkipCountDownBtn.setVisibility(0);
                        AdRewardPreviewActivityProxy.this.mSkipCountDownDiv.setVisibility(0);
                    }
                    TextView textView2 = AdRewardPreviewActivityProxy.this.mCountDownTips;
                    textView2.setText("激励领取视频还有" + AdRewardPreviewActivityProxy.this.mCount + "秒");
                    AdRewardPreviewActivityProxy.this.mHandler.postDelayed(this, 1000L);
                }
                AdRewardPreviewActivityProxy.access$710(AdRewardPreviewActivityProxy.this);
                AdRewardPreviewActivityProxy.access$410(AdRewardPreviewActivityProxy.this);
            }
        }, 1000L);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        if (this.mUrl != null) {
            c cVar = new c(this.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.ax(cb) && com.kwad.sdk.core.config.d.um() && ag.isWifiConnected(getActivity())) {
                cVar.m(new a.C0349a(getActivity()).ao(false).ap(false).I(this.mAdTemplate).ar(false));
            }
        }
        this.mAdWebView.loadUrl(!TextUtils.isEmpty(this.mUrl) ? this.mUrl : com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)));
        getTimerHelper().startTiming();
        this.mWebContainer.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getX() > AdRewardPreviewActivityProxy.this.mWebCloseBtn.getX() && motionEvent.getX() - AdRewardPreviewActivityProxy.this.mWebCloseBtn.getX() < AdRewardPreviewActivityProxy.this.mWebCloseBtn.getWidth() && motionEvent.getY() > AdRewardPreviewActivityProxy.this.mWebCloseBtn.getY() && motionEvent.getY() - AdRewardPreviewActivityProxy.this.mWebCloseBtn.getY() < AdRewardPreviewActivityProxy.this.mWebCloseBtn.getHeight()) {
                    com.kwad.sdk.core.d.b.d(AdRewardPreviewActivityProxy.TAG, "onClick backIcon");
                    return false;
                } else if (motionEvent.getAction() == 0) {
                    AdRewardPreviewActivityProxy.this.mLastDown = SystemClock.elapsedRealtime();
                    return false;
                } else if (motionEvent.getAction() == 1) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - AdRewardPreviewActivityProxy.this.mLastDown;
                    if (AdRewardPreviewActivityProxy.this.mLastDown > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                        com.kwad.sdk.core.report.a.a(AdRewardPreviewActivityProxy.this.mAdTemplate, 72, AdRewardPreviewActivityProxy.this.mWebContainer.getTouchCoords());
                        if (AdRewardPreviewActivityProxy.mInteractionListener != null) {
                            AdRewardPreviewActivityProxy.mInteractionListener.onAdClicked();
                        }
                    }
                    AdRewardPreviewActivityProxy.this.mLastDown = 0L;
                    return false;
                } else {
                    return false;
                }
            }
        });
    }

    @Override // com.kwad.components.core.l.d
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.g.a.V("reward", "show");
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.mAdWebView.goBack();
            com.kwad.sdk.core.report.a.aw(this.mAdTemplate);
        } else if (!this.mEnableSkip) {
            showCloseDialog();
        } else {
            super.onBackPressed();
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, 11, getTimerHelper().getTime(), (JSONObject) null);
        }
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_REWARD, "adShowSuccess").report();
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onPageDismiss();
        }
        mInteractionListener = null;
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
        getTimerHelper().EY();
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        getTimerHelper().EX();
    }
}
