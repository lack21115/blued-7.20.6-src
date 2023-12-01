package com.blued.android.module.common.adx.gdt.p002native;

import android.app.Activity;
import android.view.View;
import com.blued.android.module.common.adx.base.ADEventListener;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.AdData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* renamed from: com.blued.android.module.common.adx.gdt.native.TXNativeExpressAdDataAdapter  reason: invalid package */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/gdt/native/TXNativeExpressAdDataAdapter.class */
public final class TXNativeExpressAdDataAdapter extends NativeExpressADView implements ADEventListener {
    private BluedADExtra a;
    private NativeExpressADView b;
    private ADListener c;

    public void destroy() {
        this.b.destroy();
    }

    public final BluedADExtra getAdExtra() {
        return this.a;
    }

    public String getApkInfoUrl() {
        String apkInfoUrl = this.b.getApkInfoUrl();
        Intrinsics.c(apkInfoUrl, "mNativeExpressADView.apkInfoUrl");
        return apkInfoUrl;
    }

    public AdData getBoundData() {
        AdData boundData = this.b.getBoundData();
        Intrinsics.c(boundData, "mNativeExpressADView.boundData");
        return boundData;
    }

    public int getECPM() {
        return this.b.getECPM();
    }

    public String getECPMLevel() {
        String eCPMLevel = this.b.getECPMLevel();
        Intrinsics.c(eCPMLevel, "mNativeExpressADView.ecpmLevel");
        return eCPMLevel;
    }

    public Map<String, Object> getExtraInfo() {
        Map<String, Object> extraInfo = this.b.getExtraInfo();
        Intrinsics.c(extraInfo, "mNativeExpressADView.extraInfo");
        return extraInfo;
    }

    public boolean isValid() {
        return this.b.isValid();
    }

    public void negativeFeedback() {
        this.b.negativeFeedback();
    }

    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        this.b.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
    }

    public void preloadVideo() {
        this.b.preloadVideo();
    }

    public void render() {
        addView((View) this.b);
        this.b.render();
    }

    public void sendLossNotification(int i, int i2, String str) {
        this.b.sendLossNotification(i, i2, str);
    }

    public void sendLossNotification(Map<String, Object> map) {
        this.b.sendLossNotification(map);
    }

    public void sendWinNotification(int i) {
        this.b.sendWinNotification(i);
    }

    public void sendWinNotification(Map<String, Object> map) {
        this.b.sendWinNotification(map);
    }

    public final void setAdExtra(BluedADExtra bluedADExtra) {
        Intrinsics.e(bluedADExtra, "<set-?>");
        this.a = bluedADExtra;
    }

    public void setAdListener(ADListener aDListener) {
        this.c = aDListener;
    }

    public void setAdSize(ADSize aDSize) {
        this.b.setAdSize(aDSize);
    }

    public void setBidECPM(int i) {
        this.b.setBidECPM(i);
    }

    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.b.setDownloadConfirmListener(downloadConfirmListener);
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        this.b.setMediaListener(nativeExpressMediaListener);
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.b.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    public void setViewBindStatusListener(NativeExpressADView.ViewBindStatusListener viewBindStatusListener) {
        this.b.setViewBindStatusListener(viewBindStatusListener);
    }
}
