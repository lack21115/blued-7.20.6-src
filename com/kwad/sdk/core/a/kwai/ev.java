package com.kwad.sdk.core.a.kwai;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.imageloader.ImageLoaderInfo;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.response.model.TemplateConfig;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ev.class */
public final class ev {
    public static Map<Class<? extends com.kwad.sdk.core.response.kwai.a>, com.kwad.sdk.core.d> afN;

    static {
        HashMap hashMap = new HashMap();
        afN = hashMap;
        hashMap.put(AdMatrixInfo.AdInteractionInfo.class, new t());
        afN.put(com.kwad.sdk.core.request.model.f.class, new io());
        afN.put(TemplateConfig.class, new iq());
        afN.put(AdStyleInfo.PlayEndInfo.class, new gl());
        afN.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new ff());
        afN.put(AdStyleInfo.PlayDetailInfo.DrawAdInfo.class, new cq());
        afN.put(AdInfo.class, new r());
        afN.put(TKAdLiveShopItemInfo.class, new im());
        afN.put(VideoPlayerStatus.class, new jf());
        afN.put(AdStyleInfo.ExtraDisplayInfo.class, new cy());
        afN.put(SDKInitMsg.class, new hh());
        afN.put(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo.class, new ci());
        afN.put(AdMatrixInfo.EndCardInfo.class, new cs());
        afN.put(com.kwad.sdk.core.threads.d.class, new iu());
        afN.put(AdInfo.AdConversionInfo.DeeplinkItemInfo.class, new cg());
        afN.put(AdInfo.AdInsertScreenInfo.class, new s());
        afN.put(AdMatrixInfo.ActionBarInfoNew.class, new d());
        afN.put(AdStyleInfo.PlayDetailInfo.PatchAdInfo.class, new gf());
        afN.put(AdTemplate.class, new ai());
        afN.put(PhotoInfo.BaseInfo.class, new az());
        afN.put(AdMatrixInfo.RewardVideoInteractInfo.class, new hb());
        afN.put(AdMatrixInfo.FullScreenInfo.class, new dl());
        afN.put(AdStyleInfo.PlayDetailInfo.class, new gj());
        afN.put(WebViewCommercialMsg.class, new jk());
        afN.put(AdInfo.NativeAdShakeInfo.class, new fp());
        afN.put(AdInfo.AdConversionInfo.class, new l());
        afN.put(AdStyleInfo.PlayDetailInfo.DetailCommonInfo.class, new ch());
        afN.put(com.kwad.sdk.f.kwai.b.class, new ga());
        afN.put(StatusInfo.SplashStyleControl.class, new ie());
        afN.put(AdInfo.NativeAdInfo.class, new fn());
        afN.put(com.kwad.sdk.utils.a.a.class, new ey());
        afN.put(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo.class, new ct());
        afN.put(com.kwad.sdk.internal.api.a.class, new u());
        afN.put(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo.class, new fa());
        afN.put(AdInfo.FullScreenVideoInfo.class, new dm());
        afN.put(AdInfo.MaterialSize.class, new fg());
        afN.put(AdInfo.AdTrackInfo.class, new aj());
        afN.put(AdInfo.AdSplashInfo.class, new ae());
        afN.put(PhotoInfo.class, new gh());
        afN.put(NativeAdExtraDataImpl.class, new fm());
        afN.put(StatusInfo.NativeAdRequestInfo.class, new fo());
        afN.put(AdMatrixInfo.FeedInfo.class, new db());
        afN.put(com.kwad.sdk.core.request.model.b.class, new ck());
        afN.put(AdMatrixInfo.BaseMatrixTemplate.class, new ba());
        afN.put(AdInfo.AdAggregateInfo.class, new h());
        afN.put(PhotoInfo.VideoInfo.class, new jd());
        afN.put(com.kwad.sdk.core.report.l.class, new cu());
        afN.put(AdStyleInfo.PlayDetailInfo.ActionBarInfo.class, new c());
        afN.put(AdStyleInfo.class, new ah());
        afN.put(AdInfo.AdRewardInfo.class, new ac());
        afN.put(AdInfo.AdStyleConfInfo.class, new ag());
        afN.put(ImageLoaderInfo.class, new ef());
        afN.put(com.kwad.sdk.core.threads.b.class, new it());
        afN.put(AdInfo.CutRuleInfo.class, new cd());
        afN.put(AdInfo.UnDownloadRegionConf.class, new iz());
        afN.put(AdInfo.AdFeedInfo.class, new o());
        afN.put(AdMatrixInfo.RotateInfo.class, new hg());
        afN.put(FeedSlideConf.class, new dd());
        afN.put(AdInfo.AdvertiserInfo.class, new al());
        afN.put(HttpDnsInfo.class, new eb());
        afN.put(AdMatrixInfo.MerchantLiveReservationInfo.class, new fj());
        afN.put(AdMatrixInfo.SplashActionBarInfo.class, new ht());
        afN.put(AdMatrixInfo.ActivityMiddlePageInfo.class, new g());
        afN.put(AdInfo.UnDownloadConf.class, new iy());
        afN.put(AdInfo.AdShowVideoH5Info.class, new ad());
        afN.put(AdMatrixInfo.SplashEndCardTKInfo.class, new hv());
        afN.put(AdMatrixInfo.TemplateData.class, new is());
        afN.put(com.kwad.sdk.f.kwai.a.class, new fz());
        afN.put(AdMatrixInfo.RewardWebTaskCloseInfo.class, new hd());
        afN.put(AdInfo.H5Config.class, new dv());
        afN.put(AdInfo.CallBackStrategyInfo.class, new bg());
        afN.put(AdInfo.AdMaterialInfo.class, new y());
        afN.put(AdStyleInfo.PlayEndInfo.AdWebCardInfo.class, new ak());
        afN.put(AdMatrixInfo.CycleAggregateInfo.class, new ce());
        afN.put(AdStyleInfo.ExposeTagInfo.class, new cw());
        afN.put(com.kwad.sdk.core.network.k.class, new fu());
        afN.put(AdStyleInfo.PlayDetailInfo.PatchEcInfo.class, new gg());
        afN.put(AdInfo.PlayableStyleInfo.class, new gp());
        afN.put(HttpDnsInfo.IpInfo.class, new eq());
        afN.put(AdProductInfo.SpikeInfo.class, new hs());
        afN.put(AdInfo.ComplianceInfo.class, new bq());
        afN.put(AdMatrixInfo.RewardVideoTaskInfo.class, new hc());
        afN.put(AdInfo.DownloadSafeInfo.class, new cn());
        afN.put(AdStyleInfo.PlayDetailInfo.WidgetAdInfo.class, new jm());
        afN.put(WebViewLoadMsg.class, new jl());
        afN.put(CouponInfo.class, new ca());
        afN.put(AdMatrixInfo.BottomBannerInfo.class, new be());
        afN.put(HybridLoadMsg.class, new ec());
        afN.put(StatusInfo.NativeAdStyleControl.class, new fq());
        afN.put(AdMatrixInfo.StyleInfo.class, new ik());
        afN.put(URLPackage.class, new ix());
        afN.put(WebCloseStatus.class, new jj());
        afN.put(AdInfo.AdPreloadInfo.class, new aa());
        afN.put(AdMatrixInfo.ShakeInfo.class, new hl());
        afN.put(AdMatrixInfo.class, new z());
        afN.put(AdMatrixInfo.SplashSlideInfo.class, new id());
        afN.put(AdProductInfo.class, new ab());
        afN.put(AdStyleInfo.FeedAdInfo.class, new da());
        afN.put(SceneImpl.class, new hk());
        afN.put(AdMatrixInfo.DownloadTexts.class, new cp());
        afN.put(AdMatrixInfo.AdDataV2.class, new n());
        afN.put(com.kwad.sdk.internal.api.b.class, new hw());
        afN.put(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo.class, new cj());
        afN.put(com.kwad.sdk.core.network.j.class, new ft());
        afN.put(AdMatrixInfo.InterstitialCardInfo.class, new en());
        afN.put(PageInfo.class, new gc());
        afN.put(AdMatrixInfo.SplashInfo.class, new hx());
        afN.put(AdStatusInfo.class, new af());
        afN.put(StatusInfo.class, new ii());
        afN.put(AdMatrixInfo.NeoVideoInfo.class, new fs());
        afN.put(StatusInfo.SplashAdInfo.class, new hu());
        afN.put(AdMatrixInfo.MatrixTemplate.class, new fi());
        afN.put(AdStyleInfo.AdBrowseInfo.class, new k());
        afN.put(AdMatrixInfo.Styles.class, new il());
        afN.put(AdMatrixInfo.RotateDegreeInfo.class, new hf());
        afN.put(AdMatrixInfo.MatrixTag.class, new fh());
        afN.put(AdMatrixInfo.PreLandingPageTKInfo.class, new gr());
        afN.put(AdMatrixInfo.AggregationCardInfo.class, new am());
        afN.put(ABParams.class, new a());
        afN.put(AdInfo.SmallAppJumpInfo.class, new hr());
        afN.put(AdInfo.AdBaseInfo.class, new i());
        vO();
    }

    public static com.kwad.sdk.core.d getHolder(Class<? extends com.kwad.sdk.core.response.kwai.a> cls) {
        return afN.get(cls);
    }

    @ForInvoker(methodId = "registerHolder")
    private static void vO() {
        br.vO();
        bs.vO();
        bt.vO();
        bu.vO();
        bv.vO();
        bw.vO();
        bx.vO();
        by.vO();
        df.vO();
        dg.vO();
        dh.vO();
        di.vO();
        dj.vO();
        dk.vO();
    }

    public static Map<Class<? extends com.kwad.sdk.core.response.kwai.a>, com.kwad.sdk.core.d> vP() {
        return afN;
    }
}
