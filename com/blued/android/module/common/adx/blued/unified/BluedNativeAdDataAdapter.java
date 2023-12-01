package com.blued.android.module.common.adx.blued.unified;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
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
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/blued/unified/BluedNativeAdDataAdapter.class */
public final class BluedNativeAdDataAdapter implements NativeUnifiedADData {
    private BluedADExtra a;

    public BluedNativeAdDataAdapter(Context context, BluedADExtra adExtra) {
        Intrinsics.e(context, "context");
        Intrinsics.e(adExtra, "adExtra");
        this.a = adExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ViewGroup viewGroup, View view) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.callOnClick();
    }

    private final void a(List<? extends ImageView> list) {
        List<? extends ImageView> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        ImageLoader.a((IRequestHost) null, String.valueOf(getImgUrl())).a(list.get(0));
    }

    private final boolean a() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ViewGroup viewGroup, View view) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.callOnClick();
    }

    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
    }

    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        Log.v("adx", "bindAdToView");
        bindAdToView(context, nativeAdContainer, layoutParams, list, null);
    }

    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        ViewParent parent = nativeAdContainer == null ? null : nativeAdContainer.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        final ViewGroup viewGroup = (ViewGroup) parent;
        if (list != null) {
            for (View view : list) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.adx.blued.unified.-$$Lambda$BluedNativeAdDataAdapter$KTATwNK99q6ttMrMlxkmfP9BaFg
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        BluedNativeAdDataAdapter.a(ViewGroup.this, view2);
                    }
                });
            }
        }
        nativeAdContainer.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.adx.blued.unified.-$$Lambda$BluedNativeAdDataAdapter$YpWY5akLxZyLtRnNjFJULYP6rgo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BluedNativeAdDataAdapter.b(ViewGroup.this, view2);
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
    }

    public void destroy() {
    }

    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return false;
    }

    public int getAdPatternType() {
        return a() ? 2 : 1;
    }

    public String getApkInfoUrl() {
        return "";
    }

    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public double getAppPrice() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public int getAppScore() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public int getAppStatus() {
        return 0;
    }

    public String getButtonText() {
        return "";
    }

    public String getCTAText() {
        return "";
    }

    public CustomizeVideo getCustomizeVideo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public String getDesc() {
        if (this.a.nativeModel != null) {
            String str = this.a.nativeModel.description;
            Intrinsics.c(str, "{\n            adExtra.na…del.description\n        }");
            return str;
        }
        return "";
    }

    public long getDownloadCount() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public int getECPM() {
        try {
            return (int) this.a.price;
        } catch (Exception e) {
            Log.v("adx", Intrinsics.a("直客自渲染广告获取价格异常：", (Object) e));
            return -1;
        }
    }

    public String getECPMLevel() {
        return "";
    }

    public Map<String, Object> getExtraInfo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public String getIconUrl() {
        if (this.a.nativeModel != null) {
            String str = this.a.nativeModel.avatar;
            Intrinsics.c(str, "{\n            adExtra.nativeModel.avatar\n        }");
            return str;
        }
        return "";
    }

    public List<String> getImgList() {
        String str = this.a.style_material;
        Intrinsics.c(str, "adExtra.style_material");
        return CollectionsKt.c(str);
    }

    public String getImgUrl() {
        return this.a.nativeModel != null ? !TextUtils.isEmpty(this.a.nativeModel.style_material) ? this.a.nativeModel.style_material : this.a.nativeModel.ads_pics : "";
    }

    public int getPictureHeight() {
        return 0;
    }

    public int getPictureWidth() {
        return 0;
    }

    public int getProgress() {
        return 0;
    }

    public String getTitle() {
        if (this.a.nativeModel != null) {
            String str = this.a.nativeModel.name;
            Intrinsics.c(str, "{\n            adExtra.nativeModel.name\n        }");
            return str;
        }
        return "";
    }

    public int getVideoCurrentPosition() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public int getVideoDuration() {
        return 0;
    }

    public boolean isAppAd() {
        return false;
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
    }

    public void resume() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void resumeAppDownload() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void resumeVideo() {
    }

    public void sendLossNotification(int i, int i2, String str) {
    }

    public void sendLossNotification(Map<String, Object> map) {
        Intrinsics.e(map, "map");
    }

    public void sendWinNotification(int i) {
    }

    public void sendWinNotification(Map<String, Object> map) {
        Intrinsics.e(map, "map");
    }

    public void setBidECPM(int i) {
    }

    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
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
    }

    public void stopVideo() {
    }
}
