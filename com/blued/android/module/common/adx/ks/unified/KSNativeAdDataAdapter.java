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
    private BluedADExtra a;
    private ADListener b;
    private final KsNativeAd c;
    private NativeAdContainer d;
    private String e;

    public KSNativeAdDataAdapter(Context context, KsNativeAd data, BluedADExtra adExtra) {
        Intrinsics.e(context, "context");
        Intrinsics.e(data, "data");
        Intrinsics.e(adExtra, "adExtra");
        this.a = adExtra;
        this.c = data;
    }

    private final void a(List<? extends ImageView> list) {
        List<? extends ImageView> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        List imageList = this.c.getImageList();
        boolean z = true;
        if (imageList != null) {
            z = imageList.isEmpty();
        }
        if (z) {
            return;
        }
        List imageList2 = this.c.getImageList();
        Intrinsics.a(imageList2);
        ImageLoader.a((IRequestHost) null, ((KsImage) imageList2.get(0)).getImageUrl()).a(list.get(0));
    }

    public final BluedADExtra a() {
        return this.a;
    }

    public void a(ADListener aDListener) {
        this.b = aDListener;
    }

    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        bindAdToView(context, nativeAdContainer, layoutParams, list, null);
    }

    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.d = nativeAdContainer;
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (View view : list) {
                hashMap.put(view, Integer.valueOf(view.getId()));
            }
        }
        Log.v("adx", "bindAdToView 快手注册原生");
        KsNativeAd ksNativeAd = this.c;
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
        Intrinsics.a(nativeAdContainer);
        ksNativeAd.registerViewForInteraction((Activity) context, (ViewGroup) nativeAdContainer, hashMap, new KsNativeAd.AdInteractionListener() { // from class: com.blued.android.module.common.adx.ks.unified.KSNativeAdDataAdapter$bindAdToView$2
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            public void onAdClicked(View view2, KsNativeAd ksNativeAd2) {
                ADListener aDListener;
                Log.v("adx", "快手自渲染 点击回调");
                aDListener = KSNativeAdDataAdapter.this.b;
                if (aDListener == null) {
                    return;
                }
                aDListener.onADEvent(new ADEvent(105, KSNativeAdDataAdapter.this.a()));
            }

            public void onAdShow(KsNativeAd ksNativeAd2) {
                ADListener aDListener;
                Log.v("adx", "快手自渲染 曝光回调");
                aDListener = KSNativeAdDataAdapter.this.b;
                if (aDListener == null) {
                    return;
                }
                aDListener.onADEvent(new ADEvent(103, KSNativeAdDataAdapter.this.a()));
            }

            public void onDownloadTipsDialogDismiss() {
            }

            public void onDownloadTipsDialogShow() {
            }
        });
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
        View videoView = this.c.getVideoView(mediaView == null ? null : mediaView.getContext(), new KsAdVideoPlayConfig.Builder().videoAutoPlayType(2).build());
        int a = AppInfo.l - DensityUtil.a(95.0f);
        int i = (a / 16) * 9;
        int[] a2 = ImageUtils.a(this.c.getVideoWidth(), this.c.getVideoHeight(), a, i, a, i);
        if (videoView == null || videoView.getParent() != null) {
            return;
        }
        if (mediaView != null) {
            mediaView.removeAllViews();
        }
        if (mediaView == null) {
            return;
        }
        mediaView.addView(videoView, new ViewGroup.LayoutParams(a2[0], a2[1]));
    }

    public void destroy() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return false;
    }

    public int getAdPatternType() {
        int materialType = this.c.getMaterialType();
        int i = 3;
        if (materialType == 1) {
            i = 2;
        } else if (materialType == 2 || materialType != 3) {
            return 1;
        }
        return i;
    }

    public String getApkInfoUrl() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        return new NativeUnifiedADAppMiitInfo() { // from class: com.blued.android.module.common.adx.ks.unified.KSNativeAdDataAdapter$getAppMiitInfo$1
            public String getAppName() {
                KsNativeAd ksNativeAd;
                ksNativeAd = KSNativeAdDataAdapter.this.c;
                return String.valueOf(ksNativeAd.getAppName());
            }

            public String getAuthorName() {
                KsNativeAd ksNativeAd;
                ksNativeAd = KSNativeAdDataAdapter.this.c;
                return String.valueOf(ksNativeAd.getCorporationName());
            }

            public long getPackageSizeBytes() {
                KsNativeAd ksNativeAd;
                ksNativeAd = KSNativeAdDataAdapter.this.c;
                return ksNativeAd.getAppPackageSize();
            }

            public String getPermissionsUrl() {
                KsNativeAd ksNativeAd;
                ksNativeAd = KSNativeAdDataAdapter.this.c;
                return String.valueOf(ksNativeAd.getPermissionInfo());
            }

            public String getPrivacyAgreement() {
                KsNativeAd ksNativeAd;
                ksNativeAd = KSNativeAdDataAdapter.this.c;
                return String.valueOf(ksNativeAd.getAppPrivacyUrl());
            }

            public String getVersionName() {
                KsNativeAd ksNativeAd;
                ksNativeAd = KSNativeAdDataAdapter.this.c;
                return String.valueOf(ksNativeAd.getAppVersion());
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
        String actionDescription = this.c.getActionDescription();
        Intrinsics.c(actionDescription, "data.actionDescription");
        return actionDescription;
    }

    public String getCTAText() {
        return "";
    }

    public CustomizeVideo getCustomizeVideo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public String getDesc() {
        return this.c.getAdDescription().toString();
    }

    public long getDownloadCount() {
        return 0L;
    }

    public int getECPM() {
        return this.c.getECPM();
    }

    public String getECPMLevel() {
        return this.e;
    }

    public Map<String, Object> getExtraInfo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public String getIconUrl() {
        return this.c.getInteractionType() == 1 ? String.valueOf(this.c.getAppIconUrl()) : "";
    }

    public List<String> getImgList() {
        if (this.c.getImageList() != null) {
            List imageList = this.c.getImageList();
            Intrinsics.a(imageList);
            Intrinsics.c(imageList, "data.imageList!!");
            if (!imageList.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                List<KsImage> imageList2 = this.c.getImageList();
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

    public String getImgUrl() {
        if (this.c.getImageList() != null) {
            List imageList = this.c.getImageList();
            Intrinsics.a(imageList);
            Intrinsics.c(imageList, "data.imageList!!");
            if (!imageList.isEmpty()) {
                List imageList2 = this.c.getImageList();
                KsImage ksImage = imageList2 == null ? null : (KsImage) imageList2.get(0);
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

    public int getPictureHeight() {
        if (this.c.getVideoCoverImage() != null) {
            KsImage videoCoverImage = this.c.getVideoCoverImage();
            Intrinsics.a(videoCoverImage);
            return videoCoverImage.getHeight();
        }
        return 0;
    }

    public int getPictureWidth() {
        if (this.c.getVideoCoverImage() != null) {
            KsImage videoCoverImage = this.c.getVideoCoverImage();
            Intrinsics.a(videoCoverImage);
            return videoCoverImage.getWidth();
        }
        return 0;
    }

    public int getProgress() {
        return 0;
    }

    public String getTitle() {
        return this.c.getInteractionType() == 1 ? String.valueOf(this.c.getAppName()) : this.c.getProductName().toString();
    }

    public int getVideoCurrentPosition() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public int getVideoDuration() {
        return this.c.getVideoDuration();
    }

    public boolean isAppAd() {
        return this.c.getInteractionType() == 1;
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
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01ef  */
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

    public void sendWinNotification(int i) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

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
        if (this.a.settlement_price != 1) {
            this.c.setBidEcpm(j, j2);
            return;
        }
        Log.v("adx", Intrinsics.a("快手后台配置为一价结算，回传给第三方竞败⽅的最⾼价格为（单位分）：", (Object) Long.valueOf(j)));
        this.c.setBidEcpm(j, j);
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
