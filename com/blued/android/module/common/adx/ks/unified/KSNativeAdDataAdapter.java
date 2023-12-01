package com.blued.android.module.common.adx.ks.unified;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/ks/unified/KSNativeAdDataAdapter.class */
public final class KSNativeAdDataAdapter implements ADEventListener, NativeUnifiedADData {

    /* renamed from: a  reason: collision with root package name */
    private BluedADExtra f10590a;
    private ADListener b;

    /* renamed from: c  reason: collision with root package name */
    private final KsNativeAd f10591c;
    private NativeAdContainer d;
    private String e;

    public KSNativeAdDataAdapter(Context context, KsNativeAd data, BluedADExtra adExtra) {
        Intrinsics.e(context, "context");
        Intrinsics.e(data, "data");
        Intrinsics.e(adExtra, "adExtra");
        this.f10590a = adExtra;
        this.f10591c = data;
    }

    private final void a(List<? extends ImageView> list) {
        List<? extends ImageView> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        List<KsImage> imageList = this.f10591c.getImageList();
        boolean z = true;
        if (imageList != null) {
            z = imageList.isEmpty();
        }
        if (z) {
            return;
        }
        List<KsImage> imageList2 = this.f10591c.getImageList();
        Intrinsics.a(imageList2);
        ImageLoader.a((IRequestHost) null, imageList2.get(0).getImageUrl()).a(list.get(0));
    }

    public final BluedADExtra a() {
        return this.f10590a;
    }

    public void a(ADListener aDListener) {
        this.b = aDListener;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        bindAdToView(context, nativeAdContainer, layoutParams, list, null);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.d = nativeAdContainer;
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (View view : list) {
                hashMap.put(view, Integer.valueOf(view.getId()));
            }
        }
        Log.v("adx", "bindAdToView 快手注册原生");
        KsNativeAd ksNativeAd = this.f10591c;
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
        Intrinsics.a(nativeAdContainer);
        ksNativeAd.registerViewForInteraction((Activity) context, nativeAdContainer, hashMap, new KsNativeAd.AdInteractionListener() { // from class: com.blued.android.module.common.adx.ks.unified.KSNativeAdDataAdapter$bindAdToView$2
            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view2, KsNativeAd ksNativeAd2) {
                ADListener aDListener;
                Log.v("adx", "快手自渲染 点击回调");
                aDListener = KSNativeAdDataAdapter.this.b;
                if (aDListener == null) {
                    return;
                }
                aDListener.onADEvent(new ADEvent(105, KSNativeAdDataAdapter.this.a()));
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd2) {
                ADListener aDListener;
                Log.v("adx", "快手自渲染 曝光回调");
                aDListener = KSNativeAdDataAdapter.this.b;
                if (aDListener == null) {
                    return;
                }
                aDListener.onADEvent(new ADEvent(103, KSNativeAdDataAdapter.this.a()));
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        });
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
        View videoView = this.f10591c.getVideoView(mediaView == null ? null : mediaView.getContext(), new KsAdVideoPlayConfig.Builder().videoAutoPlayType(2).build());
        int a2 = AppInfo.l - DensityUtil.a(95.0f);
        int i = (a2 / 16) * 9;
        int[] a3 = ImageUtils.a(this.f10591c.getVideoWidth(), this.f10591c.getVideoHeight(), a2, i, a2, i);
        if (videoView == null || videoView.getParent() != null) {
            return;
        }
        if (mediaView != null) {
            mediaView.removeAllViews();
        }
        if (mediaView == null) {
            return;
        }
        mediaView.addView(videoView, new ViewGroup.LayoutParams(a3[0], a3[1]));
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return false;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        int materialType = this.f10591c.getMaterialType();
        int i = 3;
        if (materialType == 1) {
            i = 2;
        } else if (materialType == 2 || materialType != 3) {
            return 1;
        }
        return i;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        return new NativeUnifiedADAppMiitInfo() { // from class: com.blued.android.module.common.adx.ks.unified.KSNativeAdDataAdapter$getAppMiitInfo$1
            @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
            public String getAppName() {
                KsNativeAd ksNativeAd;
                ksNativeAd = KSNativeAdDataAdapter.this.f10591c;
                return String.valueOf(ksNativeAd.getAppName());
            }

            @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
            public String getAuthorName() {
                KsNativeAd ksNativeAd;
                ksNativeAd = KSNativeAdDataAdapter.this.f10591c;
                return String.valueOf(ksNativeAd.getCorporationName());
            }

            @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
            public long getPackageSizeBytes() {
                KsNativeAd ksNativeAd;
                ksNativeAd = KSNativeAdDataAdapter.this.f10591c;
                return ksNativeAd.getAppPackageSize();
            }

            @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
            public String getPermissionsUrl() {
                KsNativeAd ksNativeAd;
                ksNativeAd = KSNativeAdDataAdapter.this.f10591c;
                return String.valueOf(ksNativeAd.getPermissionInfo());
            }

            @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
            public String getPrivacyAgreement() {
                KsNativeAd ksNativeAd;
                ksNativeAd = KSNativeAdDataAdapter.this.f10591c;
                return String.valueOf(ksNativeAd.getAppPrivacyUrl());
            }

            @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
            public String getVersionName() {
                KsNativeAd ksNativeAd;
                ksNativeAd = KSNativeAdDataAdapter.this.f10591c;
                return String.valueOf(ksNativeAd.getAppVersion());
            }
        };
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return 0.0d;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return 0;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return 0;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        String actionDescription = this.f10591c.getActionDescription();
        Intrinsics.c(actionDescription, "data.actionDescription");
        return actionDescription;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return "";
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public CustomizeVideo getCustomizeVideo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.f10591c.getAdDescription().toString();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return 0L;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.f10591c.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return this.e;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.f10591c.getInteractionType() == 1 ? String.valueOf(this.f10591c.getAppIconUrl()) : "";
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        if (this.f10591c.getImageList() != null) {
            List<KsImage> imageList = this.f10591c.getImageList();
            Intrinsics.a(imageList);
            Intrinsics.c(imageList, "data.imageList!!");
            if (!imageList.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                List<KsImage> imageList2 = this.f10591c.getImageList();
                Intrinsics.a(imageList2);
                for (KsImage ksImage : imageList2) {
                    if (ksImage != null) {
                        String imageUrl = ksImage.getImageUrl();
                        Intrinsics.c(imageUrl, "image.imageUrl");
                        arrayList.add(imageUrl);
                    }
                }
                return arrayList;
            }
        }
        return new ArrayList();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        if (this.f10591c.getImageList() != null) {
            List<KsImage> imageList = this.f10591c.getImageList();
            Intrinsics.a(imageList);
            Intrinsics.c(imageList, "data.imageList!!");
            if (!imageList.isEmpty()) {
                List<KsImage> imageList2 = this.f10591c.getImageList();
                KsImage ksImage = imageList2 == null ? null : imageList2.get(0);
                if (ksImage == null || !ksImage.isValid()) {
                    return "";
                }
                String imageUrl = ksImage.getImageUrl();
                Intrinsics.c(imageUrl, "image.imageUrl");
                return imageUrl;
            }
            return "";
        }
        return "";
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        if (this.f10591c.getVideoCoverImage() != null) {
            KsImage videoCoverImage = this.f10591c.getVideoCoverImage();
            Intrinsics.a(videoCoverImage);
            return videoCoverImage.getHeight();
        }
        return 0;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        if (this.f10591c.getVideoCoverImage() != null) {
            KsImage videoCoverImage = this.f10591c.getVideoCoverImage();
            Intrinsics.a(videoCoverImage);
            return videoCoverImage.getWidth();
        }
        return 0;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return 0;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.f10591c.getInteractionType() == 1 ? String.valueOf(this.f10591c.getAppName()) : this.f10591c.getProductName().toString();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.f10591c.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.f10591c.getInteractionType() == 1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        return false;
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
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
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
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01ef  */
    @Override // com.qq.e.comm.pi.IBidding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendLossNotification(java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            Method dump skipped, instructions count: 621
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.ks.unified.KSNativeAdDataAdapter.sendLossNotification(java.util.Map):void");
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        Intrinsics.e(map, "map");
        Object obj = map.get("win_data");
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.login.model.BluedADExtra");
        }
        BluedADExtra bluedADExtra = (BluedADExtra) obj;
        Object obj2 = map.get("loss_data");
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.login.model.BluedADExtra");
        }
        BluedADExtra bluedADExtra2 = (BluedADExtra) obj2;
        float f = bluedADExtra.price;
        float f2 = 100;
        long j = f * f2;
        long j2 = bluedADExtra2.price * f2;
        Log.v("adx", "「测试日志」回传给快手竞胜的价格 元：" + bluedADExtra.price + " 分：" + j);
        if (this.f10590a.settlement_price != 1) {
            this.f10591c.setBidEcpm(j, j2);
            return;
        }
        Log.v("adx", Intrinsics.a("快手后台配置为一价结算，回传给第三方竞败⽅的最⾼价格为（单位分）：", (Object) Long.valueOf(j)));
        this.f10591c.setBidEcpm(j, j);
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
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
