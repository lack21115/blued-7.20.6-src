package com.blued.android.module.common.adx.gdt.p002native;

import android.app.Activity;
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

    /* renamed from: a  reason: collision with root package name */
    private BluedADExtra f10554a;
    private NativeExpressADView b;

    /* renamed from: c  reason: collision with root package name */
    private ADListener f10555c;

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void destroy() {
        this.b.destroy();
    }

    public final BluedADExtra getAdExtra() {
        return this.f10554a;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        String apkInfoUrl = this.b.getApkInfoUrl();
        Intrinsics.c(apkInfoUrl, "mNativeExpressADView.apkInfoUrl");
        return apkInfoUrl;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public AdData getBoundData() {
        AdData boundData = this.b.getBoundData();
        Intrinsics.c(boundData, "mNativeExpressADView.boundData");
        return boundData;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.b.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        String eCPMLevel = this.b.getECPMLevel();
        Intrinsics.c(eCPMLevel, "mNativeExpressADView.ecpmLevel");
        return eCPMLevel;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        Map<String, Object> extraInfo = this.b.getExtraInfo();
        Intrinsics.c(extraInfo, "mNativeExpressADView.extraInfo");
        return extraInfo;
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return this.b.isValid();
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void negativeFeedback() {
        this.b.negativeFeedback();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        this.b.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void preloadVideo() {
        this.b.preloadVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void render() {
        addView(this.b);
        this.b.render();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        this.b.sendLossNotification(i, i2, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        this.b.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        this.b.sendWinNotification(i);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.b.sendWinNotification(map);
    }

    public final void setAdExtra(BluedADExtra bluedADExtra) {
        Intrinsics.e(bluedADExtra, "<set-?>");
        this.f10554a = bluedADExtra;
    }

    public void setAdListener(ADListener aDListener) {
        this.f10555c = aDListener;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setAdSize(ADSize aDSize) {
        this.b.setAdSize(aDSize);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        this.b.setBidECPM(i);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.b.setDownloadConfirmListener(downloadConfirmListener);
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        this.b.setMediaListener(nativeExpressMediaListener);
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.b.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setViewBindStatusListener(NativeExpressADView.ViewBindStatusListener viewBindStatusListener) {
        this.b.setViewBindStatusListener(viewBindStatusListener);
    }
}
