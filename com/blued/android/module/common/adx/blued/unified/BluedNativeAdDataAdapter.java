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

    /* renamed from: a  reason: collision with root package name */
    private BluedADExtra f10546a;

    public BluedNativeAdDataAdapter(Context context, BluedADExtra adExtra) {
        Intrinsics.e(context, "context");
        Intrinsics.e(adExtra, "adExtra");
        this.f10546a = adExtra;
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
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return false;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return a() ? 2 : 1;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return "";
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
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
        return 0;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        return "";
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
        if (this.f10546a.nativeModel != null) {
            String str = this.f10546a.nativeModel.description;
            Intrinsics.c(str, "{\n            adExtra.na…del.description\n        }");
            return str;
        }
        return "";
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        try {
            return (int) this.f10546a.price;
        } catch (Exception e) {
            Log.v("adx", Intrinsics.a("直客自渲染广告获取价格异常：", (Object) e));
            return -1;
        }
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return "";
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        if (this.f10546a.nativeModel != null) {
            String str = this.f10546a.nativeModel.avatar;
            Intrinsics.c(str, "{\n            adExtra.nativeModel.avatar\n        }");
            return str;
        }
        return "";
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        String str = this.f10546a.style_material;
        Intrinsics.c(str, "adExtra.style_material");
        return CollectionsKt.c(str);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.f10546a.nativeModel != null ? !TextUtils.isEmpty(this.f10546a.nativeModel.style_material) ? this.f10546a.nativeModel.style_material : this.f10546a.nativeModel.ads_pics : "";
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return 0;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return 0;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return 0;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        if (this.f10546a.nativeModel != null) {
            String str = this.f10546a.nativeModel.name;
            Intrinsics.c(str, "{\n            adExtra.nativeModel.name\n        }");
            return str;
        }
        return "";
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return 0;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return false;
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
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        Intrinsics.e(map, "map");
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        Intrinsics.e(map, "map");
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
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
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
    }
}
