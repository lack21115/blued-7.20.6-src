package com.blued.android.module.common.adx.gdt.unified;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.adx.base.ADEventListener;
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
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/gdt/unified/TXNativeAdDataAdapter.class */
public final class TXNativeAdDataAdapter implements ADEventListener, NativeUnifiedADData {
    private BluedADExtra a;
    private final NativeUnifiedADData b;

    public TXNativeAdDataAdapter(Context context, NativeUnifiedADData data, BluedADExtra adExtra) {
        Intrinsics.e(context, "context");
        Intrinsics.e(data, "data");
        Intrinsics.e(adExtra, "adExtra");
        this.a = adExtra;
        this.b = data;
    }

    private final void a(List<? extends ImageView> list) {
        List<? extends ImageView> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        String imgUrl = this.b.getImgUrl();
        boolean z = true;
        if (imgUrl != null) {
            z = imgUrl.length() == 0;
        }
        if (z) {
            return;
        }
        ImageLoader.a((IRequestHost) null, this.b.getImgUrl()).a(list.get(0));
    }

    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
        this.b.bindAdToCustomVideo(viewGroup, context, list, list2);
    }

    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        Log.v("adx", "bindAdToView 广点通注册原生大图");
        this.b.bindAdToView(context, nativeAdContainer, new FrameLayout.LayoutParams(1, 1), list);
    }

    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.b.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
    }

    public void bindCTAViews(List<View> list) {
        this.b.bindCTAViews(list);
    }

    public void bindImageViews(List<ImageView> list, int i) {
        a(list);
    }

    public void bindImageViews(List<ImageView> list, byte[] bArr) {
        a(list);
    }

    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        Log.v("adx", "bindAdToView 广点通注册原生视频");
        this.b.bindMediaView(mediaView, videoOption, nativeADMediaListener);
    }

    public void destroy() {
        this.b.destroy();
    }

    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return this.b.equalsAdData(nativeUnifiedADData);
    }

    public int getAdPatternType() {
        return this.b.getAdPatternType();
    }

    public String getApkInfoUrl() {
        String apkInfoUrl = this.b.getApkInfoUrl();
        Intrinsics.c(apkInfoUrl, "data.apkInfoUrl");
        return apkInfoUrl;
    }

    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        NativeUnifiedADAppMiitInfo appMiitInfo = this.b.getAppMiitInfo();
        Intrinsics.c(appMiitInfo, "data.appMiitInfo");
        return appMiitInfo;
    }

    public double getAppPrice() {
        return this.b.getAppPrice();
    }

    public int getAppScore() {
        return this.b.getAppScore();
    }

    public int getAppStatus() {
        return this.b.getAppStatus();
    }

    public String getButtonText() {
        String buttonText = this.b.getButtonText();
        Intrinsics.c(buttonText, "data.buttonText");
        return buttonText;
    }

    public String getCTAText() {
        String cTAText = this.b.getCTAText();
        Intrinsics.c(cTAText, "data.ctaText");
        return cTAText;
    }

    public CustomizeVideo getCustomizeVideo() {
        CustomizeVideo customizeVideo = this.b.getCustomizeVideo();
        Intrinsics.c(customizeVideo, "data.customizeVideo");
        return customizeVideo;
    }

    public String getDesc() {
        String desc = this.b.getDesc();
        Intrinsics.c(desc, "data.desc");
        return desc;
    }

    public long getDownloadCount() {
        return this.b.getDownloadCount();
    }

    public int getECPM() {
        return this.b.getECPM();
    }

    public String getECPMLevel() {
        String eCPMLevel = this.b.getECPMLevel();
        Intrinsics.c(eCPMLevel, "data.ecpmLevel");
        return eCPMLevel;
    }

    public Map<String, Object> getExtraInfo() {
        Map<String, Object> extraInfo = this.b.getExtraInfo();
        Intrinsics.c(extraInfo, "data.extraInfo");
        return extraInfo;
    }

    public String getIconUrl() {
        String iconUrl = this.b.getIconUrl();
        Intrinsics.c(iconUrl, "data.iconUrl");
        return iconUrl;
    }

    public List<String> getImgList() {
        List<String> imgList = this.b.getImgList();
        Intrinsics.c(imgList, "data.imgList");
        return imgList;
    }

    public String getImgUrl() {
        String imgUrl = this.b.getImgUrl();
        Intrinsics.c(imgUrl, "data.imgUrl");
        return imgUrl;
    }

    public int getPictureHeight() {
        return this.b.getPictureHeight();
    }

    public int getPictureWidth() {
        return this.b.getPictureWidth();
    }

    public int getProgress() {
        return this.b.getProgress();
    }

    public String getTitle() {
        String title = this.b.getTitle();
        Intrinsics.c(title, "data.title");
        return title;
    }

    public int getVideoCurrentPosition() {
        return this.b.getVideoCurrentPosition();
    }

    public int getVideoDuration() {
        return this.b.getVideoDuration();
    }

    public boolean isAppAd() {
        return this.b.isAppAd();
    }

    public boolean isValid() {
        return this.b.isValid();
    }

    public boolean isWeChatCanvasAd() {
        return this.b.isWeChatCanvasAd();
    }

    public void negativeFeedback() {
        this.b.negativeFeedback();
    }

    public void pauseAppDownload() {
        this.b.pauseAppDownload();
    }

    public void pauseVideo() {
        this.b.pauseVideo();
    }

    public void resume() {
        this.b.resume();
    }

    public void resumeAppDownload() {
        this.b.resumeAppDownload();
    }

    public void resumeVideo() {
        this.b.resumeVideo();
    }

    public void sendLossNotification(int i, int i2, String str) {
        this.b.sendLossNotification(i, i2, str);
    }

    public void sendLossNotification(Map<String, ? extends Object> p0) {
        Intrinsics.e(p0, "p0");
        this.b.sendLossNotification(p0);
    }

    public void sendWinNotification(int i) {
        this.b.sendWinNotification(i);
    }

    public void sendWinNotification(Map<String, ? extends Object> map) {
        this.b.sendWinNotification(map);
    }

    public void setBidECPM(int i) {
        this.b.setBidECPM(i);
    }

    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
    }

    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.b.setNativeAdEventListener(nativeADEventListener);
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
    }

    public void setVideoMute(boolean z) {
        this.b.setVideoMute(z);
    }

    public void startVideo() {
        this.b.startVideo();
    }

    public void stopVideo() {
        this.b.stopVideo();
    }
}
