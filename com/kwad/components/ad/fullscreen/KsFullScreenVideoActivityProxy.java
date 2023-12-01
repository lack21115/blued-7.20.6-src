package com.kwad.components.ad.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.t;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/fullscreen/KsFullScreenVideoActivityProxy.class */
public class KsFullScreenVideoActivityProxy extends com.kwad.components.core.j.b<j> implements OnAdLiveResumeInterceptor {
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    private static final String TAG = "FullScreenVideo";
    private static final HashMap<String, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener> sHashMap = new HashMap<>();
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private DetailVideoView mDetailVideoView;
    private com.kwad.components.ad.fullscreen.b.b mFullScreenPresenter;
    private KsFullScreenVideoAd.FullScreenVideoAdInteractionListener mInteractionListener;
    private boolean mIsBackEnable;
    private boolean mPageDismissCalled;
    public long mPageEnterTime;
    private FrameLayout mPlayLayout;
    private JSONObject mReportExtData;
    private AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    private bh mTimerHelper;
    private KsVideoPlayConfig mVideoPlayConfig;
    private f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            KsFullScreenVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private com.kwad.components.ad.reward.d.b mAdOpenInteractionListener = new com.kwad.components.ad.reward.d.c() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.2
        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void bN() {
            if (KsFullScreenVideoActivityProxy.this.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.this.mInteractionListener.onAdClicked();
            }
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void h(boolean z) {
            KsFullScreenVideoActivityProxy.this.notifyPageDismiss();
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onSkippedVideo() {
            if (KsFullScreenVideoActivityProxy.this.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.this.mInteractionListener.onSkippedVideo();
            }
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoPlayEnd() {
            if (KsFullScreenVideoActivityProxy.this.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.this.mInteractionListener.onVideoPlayEnd();
            }
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoPlayError(int i, int i2) {
            if (KsFullScreenVideoActivityProxy.this.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.this.mInteractionListener.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoPlayStart() {
            if (KsFullScreenVideoActivityProxy.this.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.this.mInteractionListener.onVideoPlayStart();
            }
        }
    };

    private static String getListenerKey(AdTemplate adTemplate) {
        return adTemplate == null ? "" : String.valueOf(com.kwad.sdk.core.response.a.d.cb(adTemplate).adBaseInfo.creativeId);
    }

    private bh getTimerHelper() {
        if (this.mTimerHelper == null) {
            bh bhVar = new bh();
            this.mTimerHelper = bhVar;
            bhVar.startTiming();
        }
        return this.mTimerHelper;
    }

    private void initVideoPlayConfig(KsVideoPlayConfig ksVideoPlayConfig) {
        if (TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            return;
        }
        this.mReportExtData = null;
        JSONObject jSONObject = new JSONObject();
        this.mReportExtData = jSONObject;
        t.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
    }

    public static void launch(Context context, AdTemplate adTemplate, KsVideoPlayConfig ksVideoPlayConfig, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Intent intent;
        l.cv(adTemplate);
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.a.a(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
            intent = new Intent(context, KsFullScreenLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.a.a(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
            intent = new Intent(context, FeedDownloadActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        sHashMap.put(getListenerKey(adTemplate), fullScreenVideoAdInteractionListener);
        context.startActivity(intent);
        com.kwad.sdk.kwai.kwai.c.sZ().aU(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPageDismiss() {
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
        com.kwad.sdk.kwai.kwai.c.sZ().tc();
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 6, getTimerHelper().getTime(), this.mReportExtData);
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onPageDismiss();
        }
    }

    public static void register() {
        com.kwad.sdk.service.a.a(KsFullScreenVideoActivity.class, KsFullScreenVideoActivityProxy.class);
        com.kwad.sdk.service.a.a(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
    }

    @Override // com.kwad.components.core.l.d
    public boolean checkIntentData(Intent intent) {
        Serializable serializableExtra = getIntent().getSerializableExtra("key_video_play_config");
        if (serializableExtra instanceof KsVideoPlayConfig) {
            this.mVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
        }
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
        if (this.mVideoPlayConfig == null || this.mAdTemplate == null) {
            com.kwad.sdk.g.a.V("fullscreen", "show");
            return false;
        }
        return true;
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        notifyPageDismiss();
    }

    @Override // com.kwad.components.core.l.d
    public int getLayoutId() {
        return R.layout.ksad_activity_fullscreen_video;
    }

    @Override // com.kwad.components.core.l.d
    public String getPageName() {
        return "KsFullScreenVideoActivityProxy";
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return ((j) this.mCallerContext).fE();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.kwad.components.core.l.d
    public void initData() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.kwad.components.core.l.d
    public void initView() {
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        this.mDetailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.mPlayLayout = (FrameLayout) this.mRootContainer.findViewById(R.id.ksad_reward_play_layout);
        this.mDetailVideoView.f(true, com.kwad.sdk.core.config.d.uV());
        com.kwad.sdk.g.a.V("fullscreen", "show");
    }

    @Override // com.kwad.components.core.l.d
    public boolean needAdaptionScreen() {
        return true;
    }

    @Override // com.kwad.components.core.j.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.ad.fullscreen.b.b bVar = this.mFullScreenPresenter;
        if ((bVar == null || !bVar.bX()) && this.mIsBackEnable) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FULLSCREEN, "adShowSuccess").report();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.j.b
    public j onCreateCallerContext() {
        j jVar = new j(this);
        jVar.mPageEnterTime = this.mPageEnterTime;
        jVar.mAdOpenInteractionListener = this.mAdOpenInteractionListener;
        jVar.mScreenOrientation = this.mScreenOrientation;
        jVar.mVideoPlayConfig = this.mVideoPlayConfig;
        jVar.mReportExtData = this.mReportExtData;
        jVar.mRootContainer = this.mRootContainer;
        jVar.mAdTemplate = this.mAdTemplate;
        com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        jVar.oM = this.mDetailVideoView;
        com.kwad.components.ad.reward.j.a aVar = new com.kwad.components.ad.reward.j.a(jVar, false);
        jVar.oN = new com.kwad.components.ad.reward.j.b(aVar);
        jVar.a(aVar);
        if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
            jVar.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate, this.mReportExtData);
        }
        jVar.oQ = new RewardActionBarControl(jVar, this.mContext, this.mAdTemplate);
        jVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.a.b.be(this.mAdTemplate)) {
            jVar.oR = new com.kwad.components.ad.reward.l(jVar, this.mReportExtData, null);
        }
        if (com.kwad.sdk.core.response.a.a.bv(this.mAdInfo)) {
            jVar.oP = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        if (com.kwad.sdk.core.response.a.a.al(this.mAdInfo)) {
            jVar.oT = new com.kwad.components.ad.i.a().ak(false);
        }
        jVar.pf = false;
        jVar.pA = com.kwad.sdk.core.response.a.a.bv(this.mAdInfo) ? com.kwad.sdk.core.response.a.a.ai(this.mAdInfo) : com.kwad.sdk.core.response.a.a.ad(this.mAdInfo);
        jVar.mTimerHelper = getTimerHelper();
        return jVar;
    }

    @Override // com.kwad.components.core.j.b
    public Presenter onCreatePresenter() {
        b bVar = new b(this.mAdTemplate);
        getActivity();
        com.kwad.components.ad.fullscreen.b.b bVar2 = new com.kwad.components.ad.fullscreen.b.b(this, this.mRootContainer, bVar, (j) this.mCallerContext);
        this.mFullScreenPresenter = bVar2;
        return bVar2;
    }

    @Override // com.kwad.components.core.j.b, com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        notifyPageDismiss();
        AdInfo adInfo = this.mAdInfo;
        if (adInfo != null) {
            String E = com.kwad.sdk.core.response.a.a.E(adInfo);
            if (!TextUtils.isEmpty(E)) {
                com.kwad.sdk.core.videocache.b.a.ba(this.mContext.getApplicationContext()).cV(E);
            }
        }
        if (this.mCallerContext != 0 && ((j) this.mCallerContext).oN.jF()) {
            ((j) this.mCallerContext).oN.jG().removeInterceptor(this);
        }
        sHashMap.remove(getListenerKey(this.mAdTemplate));
        this.mInteractionListener = null;
    }

    @Override // com.kwad.components.core.j.b, com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        getTimerHelper().EY();
        if (this.mCallerContext != 0) {
            ((j) this.mCallerContext).mPageEnterTime = -1L;
        }
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable th) {
        }
    }

    @Override // com.kwad.components.core.j.b, com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        getTimerHelper().EX();
    }
}
