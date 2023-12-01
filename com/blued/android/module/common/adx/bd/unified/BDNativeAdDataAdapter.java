package com.blued.android.module.common.adx.bd.unified;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADEventListener;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.CustomizeVideo;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/bd/unified/BDNativeAdDataAdapter.class */
public final class BDNativeAdDataAdapter implements ADEventListener, NativeUnifiedADData {

    /* renamed from: a  reason: collision with root package name */
    private BluedADExtra f10542a;
    private ADListener b;

    /* renamed from: c  reason: collision with root package name */
    private NativeResponse f10543c;
    private NativeAdContainer d;
    private List<View> e;
    private List<? extends View> f;
    private XNativeView g;
    private String h;

    public BDNativeAdDataAdapter(Context context, NativeResponse data, BluedADExtra adExtra) {
        Intrinsics.e(context, "context");
        Intrinsics.e(data, "data");
        Intrinsics.e(adExtra, "adExtra");
        this.f10542a = adExtra;
        this.f10543c = data;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BDNativeAdDataAdapter this$0, XNativeView xNativeView) {
        Intrinsics.e(this$0, "this$0");
        ADListener aDListener = this$0.b;
        if (aDListener == null) {
            return;
        }
        aDListener.onADEvent(new ADEvent(105, this$0.f10542a));
    }

    private final void a(final NativeAdContainer nativeAdContainer, List<View> list, List<? extends View> list2, MediaView mediaView) {
        if (mediaView != null && list != null) {
            list.add(mediaView);
        }
        Log.v("adx", "注册百度事件");
        this.f10543c.registerViewForInteraction(nativeAdContainer, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.blued.android.module.common.adx.bd.unified.BDNativeAdDataAdapter$registerViewForInteraction$1
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                NativeResponse nativeResponse;
                ADListener aDListener;
                Log.v("adx", "百度自渲染 曝光回调");
                nativeResponse = BDNativeAdDataAdapter.this.f10543c;
                nativeResponse.recordImpression(nativeAdContainer);
                aDListener = BDNativeAdDataAdapter.this.b;
                if (aDListener == null) {
                    return;
                }
                aDListener.onADEvent(new ADEvent(103, BDNativeAdDataAdapter.this.a()));
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                ADListener aDListener;
                Log.v("adx", "百度自渲染 点击回调");
                aDListener = BDNativeAdDataAdapter.this.b;
                if (aDListener == null) {
                    return;
                }
                aDListener.onADEvent(new ADEvent(105, BDNativeAdDataAdapter.this.a()));
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
            }
        });
    }

    private final void a(List<? extends ImageView> list) {
        List<? extends ImageView> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        ImageLoader.a((IRequestHost) null, this.f10543c.getImageUrl()).a(list.get(0));
    }

    private final boolean b() {
        return this.f10543c.getMaterialType() == NativeResponse.MaterialType.VIDEO;
    }

    public final BluedADExtra a() {
        return this.f10542a;
    }

    public void a(ADListener aDListener) {
        this.b = aDListener;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        Log.v("adx", "bindAdToView");
        bindAdToView(context, nativeAdContainer, layoutParams, list, null);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.d = nativeAdContainer;
        if (!b()) {
            Log.v("adx", "bindAdToView 百度注册原生大图");
            a(nativeAdContainer, list, list2, null);
            return;
        }
        this.d = nativeAdContainer;
        this.e = list;
        this.f = list2;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, int i) {
        a(list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, byte[] bArr) {
        a(list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        if (!b() || mediaView == null) {
            return;
        }
        this.g = new XNativeView(mediaView.getContext());
        int a2 = (AppInfo.l - DensityUtil.a(95.0f)) / 16;
        XNativeView xNativeView = this.g;
        if (xNativeView == null) {
            return;
        }
        xNativeView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        xNativeView.setNativeViewClickListener(new XNativeView.INativeViewClickListener() { // from class: com.blued.android.module.common.adx.bd.unified.-$$Lambda$BDNativeAdDataAdapter$Xg1o9bJufr1YblggHPHowXiWqYo
            @Override // com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener
            public final void onNativeViewClick(XNativeView xNativeView2) {
                BDNativeAdDataAdapter.a(BDNativeAdDataAdapter.this, xNativeView2);
            }
        });
        mediaView.addView(this.g);
        List<View> list = this.e;
        if (list != null) {
            list.add(xNativeView);
        }
        Log.v("adx", "bindAdToView 百度注册原生视频");
        a(this.d, this.e, this.f, mediaView);
        xNativeView.setNativeItem(this.f10543c);
        xNativeView.setVideoMute(true);
        xNativeView.render();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        XNativeView xNativeView = this.g;
        if (xNativeView == null) {
            return;
        }
        xNativeView.stop();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData instanceof BDNativeAdDataAdapter) {
            return Intrinsics.a(this.f10543c, ((BDNativeAdDataAdapter) nativeUnifiedADData).f10543c);
        }
        return false;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return b() ? 2 : 1;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        return new NativeUnifiedADAppMiitInfo() { // from class: com.blued.android.module.common.adx.bd.unified.BDNativeAdDataAdapter$getAppMiitInfo$1
            @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
            public String getAppName() {
                NativeResponse nativeResponse;
                nativeResponse = BDNativeAdDataAdapter.this.f10543c;
                return nativeResponse.getBrandName().toString();
            }

            @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
            public String getAuthorName() {
                NativeResponse nativeResponse;
                nativeResponse = BDNativeAdDataAdapter.this.f10543c;
                return nativeResponse.getPublisher().toString();
            }

            @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
            public long getPackageSizeBytes() {
                NativeResponse nativeResponse;
                nativeResponse = BDNativeAdDataAdapter.this.f10543c;
                return nativeResponse.getAppSize();
            }

            @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
            public String getPermissionsUrl() {
                NativeResponse nativeResponse;
                nativeResponse = BDNativeAdDataAdapter.this.f10543c;
                return nativeResponse.getAppPermissionLink().toString();
            }

            @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
            public String getPrivacyAgreement() {
                NativeResponse nativeResponse;
                nativeResponse = BDNativeAdDataAdapter.this.f10543c;
                return nativeResponse.getAppPrivacyLink().toString();
            }

            @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
            public String getVersionName() {
                NativeResponse nativeResponse;
                nativeResponse = BDNativeAdDataAdapter.this.f10543c;
                return nativeResponse.getAppVersion().toString();
            }
        };
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        return "";
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.f10543c.getActButtonString();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public CustomizeVideo getCustomizeVideo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        String desc = this.f10543c.getDesc();
        Intrinsics.c(desc, "data.desc");
        return desc;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        try {
            String eCPMLevel = this.f10543c.getECPMLevel();
            Intrinsics.c(eCPMLevel, "data.ecpmLevel");
            return Integer.parseInt(eCPMLevel);
        } catch (Exception e) {
            Log.v("adx", Intrinsics.a("百度自渲染广告获取价格异常：", (Object) e));
            return -1;
        }
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        String str = this.h;
        Intrinsics.a((Object) str);
        return str;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        String iconUrl = this.f10543c.getIconUrl();
        Intrinsics.c(iconUrl, "data.iconUrl");
        return iconUrl;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        List<String> multiPicUrls = this.f10543c.getMultiPicUrls();
        Intrinsics.c(multiPicUrls, "data.multiPicUrls");
        return multiPicUrls;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        String imageUrl = this.f10543c.getImageUrl();
        Intrinsics.c(imageUrl, "data.imageUrl");
        return imageUrl;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.f10543c.getMainPicHeight();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.f10543c.getMainPicWidth();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        String title = this.f10543c.getTitle();
        Intrinsics.c(title, "data.title");
        return title;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.f10543c.getDuration();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.f10543c.getAdActionType() == 2;
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        XNativeView xNativeView = this.g;
        if (xNativeView == null) {
            return;
        }
        xNativeView.pause();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        XNativeView xNativeView = this.g;
        if (xNativeView == null) {
            return;
        }
        xNativeView.resume();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0132  */
    @Override // com.qq.e.comm.pi.IBidding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendLossNotification(java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.bd.unified.BDNativeAdDataAdapter.sendLossNotification(java.util.Map):void");
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        Intrinsics.e(map, "map");
        this.f10543c.biddingSuccess(String.valueOf(map.get("highest_loss_price")));
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        XNativeView xNativeView = this.g;
        if (xNativeView == null) {
            return;
        }
        xNativeView.render();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        XNativeView xNativeView = this.g;
        if (xNativeView == null) {
            return;
        }
        xNativeView.stop();
    }
}
