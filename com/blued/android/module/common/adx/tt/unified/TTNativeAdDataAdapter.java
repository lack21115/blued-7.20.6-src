package com.blued.android.module.common.adx.tt.unified;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADEventListener;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.utils.ImageUtils;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/tt/unified/TTNativeAdDataAdapter.class */
public final class TTNativeAdDataAdapter implements ADEventListener, NativeUnifiedADData {
    private BluedADExtra a;
    private ADListener b;
    private MediaView c;
    private final TTFeedAd d;
    private NativeAdContainer e;
    private String f;
    private List<View> g;
    private List<? extends View> h;
    private boolean i;

    public TTNativeAdDataAdapter(Context context, TTFeedAd data, BluedADExtra adExtra) {
        Intrinsics.e(context, "context");
        Intrinsics.e(data, "data");
        Intrinsics.e(adExtra, "adExtra");
        this.a = adExtra;
        this.d = data;
    }

    private final void a(List<? extends ImageView> list) {
        List<? extends ImageView> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        List imageList = this.d.getImageList();
        boolean z = true;
        if (imageList != null) {
            z = imageList.isEmpty();
        }
        if (z) {
            return;
        }
        List imageList2 = this.d.getImageList();
        Intrinsics.a(imageList2);
        ImageLoader.a((IRequestHost) null, ((TTImage) imageList2.get(0)).getImageUrl()).a(list.get(0));
    }

    private final TTNativeAd.AdInteractionListener b() {
        return new TTNativeAd.AdInteractionListener() { // from class: com.blued.android.module.common.adx.tt.unified.TTNativeAdDataAdapter$getInteractionListener$1
            public void onAdClicked(View view, TTNativeAd ttNativeAd) {
                ADListener aDListener;
                Intrinsics.e(view, "view");
                Intrinsics.e(ttNativeAd, "ttNativeAd");
                Log.v("adx", "穿山甲自渲染 点击回调");
                aDListener = TTNativeAdDataAdapter.this.b;
                if (aDListener == null) {
                    return;
                }
                aDListener.onADEvent(new ADEvent(105, TTNativeAdDataAdapter.this.a()));
            }

            public void onAdCreativeClick(View view, TTNativeAd ttNativeAd) {
                ADListener aDListener;
                Intrinsics.e(view, "view");
                Intrinsics.e(ttNativeAd, "ttNativeAd");
                Log.v("adx", "穿山甲自渲染 点击回调，穿山甲有两个点击回调");
                aDListener = TTNativeAdDataAdapter.this.b;
                if (aDListener == null) {
                    return;
                }
                aDListener.onADEvent(new ADEvent(105, TTNativeAdDataAdapter.this.a()));
            }

            public void onAdShow(TTNativeAd ttNativeAd) {
                boolean z;
                ADListener aDListener;
                Intrinsics.e(ttNativeAd, "ttNativeAd");
                z = TTNativeAdDataAdapter.this.i;
                if (z) {
                    return;
                }
                TTNativeAdDataAdapter.this.i = true;
                Log.v("adx", "穿山甲自渲染 曝光回调");
                aDListener = TTNativeAdDataAdapter.this.b;
                if (aDListener == null) {
                    return;
                }
                aDListener.onADEvent(new ADEvent(103, TTNativeAdDataAdapter.this.a()));
            }
        };
    }

    private final boolean c() {
        int imageMode = this.d.getImageMode();
        Log.v("adx", Intrinsics.a("穿山甲原生广告类型：", (Object) Integer.valueOf(imageMode)));
        return imageMode == 5 || imageMode == 15;
    }

    public final BluedADExtra a() {
        return this.a;
    }

    public void a(ADListener aDListener) {
        this.b = aDListener;
    }

    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
    }

    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        bindAdToView(context, nativeAdContainer, layoutParams, list, list);
    }

    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.e = nativeAdContainer;
        this.g = list;
        this.h = list2;
        if (c()) {
            return;
        }
        Log.v("adx", "bindAdToView 穿山甲注册原生大图");
        this.d.registerViewForInteraction((ViewGroup) nativeAdContainer, list, list, b());
        this.d.render();
    }

    public void bindCTAViews(List<View> list) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void bindImageViews(List<ImageView> list, int i) {
        a(list);
    }

    public void bindImageViews(List<ImageView> list, byte[] bArr) {
        a(list);
    }

    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.c = mediaView;
        View adView = this.d.getAdView();
        int a = AppInfo.l - DensityUtil.a(95.0f);
        int i = (a / 16) * 9;
        int[] a2 = ImageUtils.a(this.d.getAdViewWidth(), this.d.getAdViewHeight(), a, i, a, i);
        if (adView != null && adView.getParent() == null) {
            MediaView mediaView2 = this.c;
            if (mediaView2 != null) {
                mediaView2.removeAllViews();
            }
            MediaView mediaView3 = this.c;
            if (mediaView3 != null) {
                mediaView3.addView(adView, new ViewGroup.LayoutParams(a2[0], a2[1]));
            }
        }
        Log.v("adx", "绑定穿山甲视频，用于点击跳转 素材宽：" + a2[0] + " + 素材高：" + a2[1]);
        Log.v("adx", "bindAdToView 穿山甲注册原生视频");
        this.d.registerViewForInteraction(this.e, this.g, this.h, b());
        this.d.render();
    }

    public void destroy() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return false;
    }

    public int getAdPatternType() {
        int imageMode = this.d.getImageMode();
        int i = 3;
        if (imageMode != 2) {
            if (imageMode != 3) {
                if (imageMode != 4) {
                    if (imageMode == 5 || imageMode == 15) {
                        return 2;
                    }
                }
                return i;
            }
            return 1;
        }
        i = 4;
        return i;
    }

    public String getApkInfoUrl() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        return new NativeUnifiedADAppMiitInfo() { // from class: com.blued.android.module.common.adx.tt.unified.TTNativeAdDataAdapter$getAppMiitInfo$1
            public String getAppName() {
                TTFeedAd tTFeedAd;
                tTFeedAd = TTNativeAdDataAdapter.this.d;
                String appName = tTFeedAd.getComplianceInfo().getAppName();
                Intrinsics.c(appName, "data.complianceInfo.appName");
                return appName;
            }

            public String getAuthorName() {
                TTFeedAd tTFeedAd;
                tTFeedAd = TTNativeAdDataAdapter.this.d;
                String developerName = tTFeedAd.getComplianceInfo().getDeveloperName();
                Intrinsics.c(developerName, "data.complianceInfo.developerName");
                return developerName;
            }

            public long getPackageSizeBytes() {
                return 0L;
            }

            public String getPermissionsUrl() {
                TTFeedAd tTFeedAd;
                tTFeedAd = TTNativeAdDataAdapter.this.d;
                String permissionUrl = tTFeedAd.getComplianceInfo().getPermissionUrl();
                Intrinsics.c(permissionUrl, "data.complianceInfo.permissionUrl");
                return permissionUrl;
            }

            public String getPrivacyAgreement() {
                TTFeedAd tTFeedAd;
                tTFeedAd = TTNativeAdDataAdapter.this.d;
                String privacyUrl = tTFeedAd.getComplianceInfo().getPrivacyUrl();
                Intrinsics.c(privacyUrl, "data.complianceInfo.privacyUrl");
                return privacyUrl;
            }

            public String getVersionName() {
                TTFeedAd tTFeedAd;
                tTFeedAd = TTNativeAdDataAdapter.this.d;
                String appVersion = tTFeedAd.getComplianceInfo().getAppVersion();
                Intrinsics.c(appVersion, "data.complianceInfo.appVersion");
                return appVersion;
            }
        };
    }

    public double getAppPrice() {
        return 0.0d;
    }

    public int getAppScore() {
        return 0;
    }

    public int getAppStatus() {
        return 0;
    }

    public String getButtonText() {
        String buttonText = this.d.getButtonText();
        Intrinsics.c(buttonText, "data.buttonText");
        return buttonText;
    }

    public String getCTAText() {
        return "";
    }

    public CustomizeVideo getCustomizeVideo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public String getDesc() {
        String description = this.d.getDescription();
        Intrinsics.c(description, "data.description");
        return description;
    }

    public long getDownloadCount() {
        return 0L;
    }

    public int getECPM() {
        try {
            Object obj = this.d.getMediaExtraInfo().get("price");
            if (obj != null) {
                return ((Integer) obj).intValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        } catch (Exception e) {
            return -1;
        }
    }

    public String getECPMLevel() {
        return this.f;
    }

    public Map<String, Object> getExtraInfo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public String getIconUrl() {
        List imageList = this.d.getImageList();
        Intrinsics.c(imageList, "data.imageList");
        if (!imageList.isEmpty()) {
            String imageUrl = ((TTImage) this.d.getImageList().get(0)).getImageUrl();
            Intrinsics.c(imageUrl, "{\n            data.imageList[0].imageUrl\n        }");
            return imageUrl;
        }
        return "";
    }

    public List<String> getImgList() {
        ArrayList arrayList = new ArrayList();
        List<TTImage> imageList = this.d.getImageList();
        if (imageList != null && (!imageList.isEmpty())) {
            for (TTImage tTImage : imageList) {
                arrayList.add(tTImage.getImageUrl());
            }
        }
        return arrayList;
    }

    public String getImgUrl() {
        List imageList = this.d.getImageList();
        Intrinsics.c(imageList, "data.imageList");
        if (!imageList.isEmpty()) {
            String imageUrl = ((TTImage) this.d.getImageList().get(0)).getImageUrl();
            Intrinsics.c(imageUrl, "{\n            data.imageList[0].imageUrl\n        }");
            return imageUrl;
        }
        return "";
    }

    public int getPictureHeight() {
        List imageList;
        Intrinsics.c(this.d.getImageList(), "data.imageList");
        int i = 0;
        if (!imageList.isEmpty()) {
            i = ((TTImage) this.d.getImageList().get(0)).getHeight();
        }
        return i;
    }

    public int getPictureWidth() {
        List imageList;
        Intrinsics.c(this.d.getImageList(), "data.imageList");
        int i = 0;
        if (!imageList.isEmpty()) {
            i = ((TTImage) this.d.getImageList().get(0)).getWidth();
        }
        return i;
    }

    public int getProgress() {
        return 0;
    }

    public String getTitle() {
        String title = this.d.getTitle();
        Intrinsics.c(title, "data.title");
        return title;
    }

    public int getVideoCurrentPosition() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public int getVideoDuration() {
        return 0;
    }

    public boolean isAppAd() {
        return this.d.getInteractionType() == 4;
    }

    public boolean isValid() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public boolean isWeChatCanvasAd() {
        return false;
    }

    public void negativeFeedback() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void pauseAppDownload() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void pauseVideo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void resume() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void resumeAppDownload() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void resumeVideo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void sendLossNotification(int i, int i2, String str) {
    }

    public void sendLossNotification(Map<String, Object> map) {
    }

    public void sendWinNotification(int i) {
    }

    public void sendWinNotification(Map<String, Object> map) {
    }

    public void setBidECPM(int i) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void setVideoMute(boolean z) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void startVideo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void stopVideo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
