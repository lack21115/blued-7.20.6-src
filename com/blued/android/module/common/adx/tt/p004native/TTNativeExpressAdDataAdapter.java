package com.blued.android.module.common.adx.tt.p004native;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.blued.android.module.common.adx.base.ADEventListener;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.AdData;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* renamed from: com.blued.android.module.common.adx.tt.native.TTNativeExpressAdDataAdapter  reason: invalid package */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/tt/native/TTNativeExpressAdDataAdapter.class */
public final class TTNativeExpressAdDataAdapter extends NativeExpressADView implements ADEventListener {
    private BluedADExtra a;
    private TTNativeExpressAd b;
    private AdData c;
    private ADListener d;
    private String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTNativeExpressAdDataAdapter(Context context, TTNativeExpressAd data, BluedADExtra adExtra) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(data, "data");
        Intrinsics.e(adExtra, "adExtra");
        this.a = adExtra;
        this.b = data;
        this.c = getAdData();
        b();
        a();
    }

    private final void a() {
        this.b.setExpressInteractionListener(new TTNativeExpressAdDataAdapter$tryBindInteractionAdListener$1(this));
    }

    private final void b() {
        this.b.setDislikeCallback((Activity) getContext(), new TTAdDislike.DislikeInteractionCallback() { // from class: com.blued.android.module.common.adx.tt.native.TTNativeExpressAdDataAdapter$bindDislike$1
            public void onCancel() {
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
                r0 = r9.a.d;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onSelected(int r10, java.lang.String r11, boolean r12) {
                /*
                    r9 = this;
                    r0 = r11
                    java.lang.String r1 = "value"
                    kotlin.jvm.internal.Intrinsics.e(r0, r1)
                    java.lang.String r0 = "adx"
                    java.lang.String r1 = "穿山甲SDK信息流 移除广告"
                    int r0 = android.util.Log.v(r0, r1)
                    r0 = r9
                    com.blued.android.module.common.adx.tt.native.TTNativeExpressAdDataAdapter r0 = com.blued.android.module.common.adx.tt.p004native.TTNativeExpressAdDataAdapter.this
                    com.blued.android.module.common.adx.base.ADListener r0 = com.blued.android.module.common.adx.tt.p004native.TTNativeExpressAdDataAdapter.c(r0)
                    if (r0 == 0) goto L44
                    r0 = r9
                    com.blued.android.module.common.adx.tt.native.TTNativeExpressAdDataAdapter r0 = com.blued.android.module.common.adx.tt.p004native.TTNativeExpressAdDataAdapter.this
                    com.blued.android.module.common.adx.base.ADListener r0 = com.blued.android.module.common.adx.tt.p004native.TTNativeExpressAdDataAdapter.c(r0)
                    r11 = r0
                    r0 = r11
                    if (r0 != 0) goto L27
                    goto L44
                L27:
                    r0 = r11
                    com.blued.android.module.common.adx.base.ADEvent r1 = new com.blued.android.module.common.adx.base.ADEvent
                    r2 = r1
                    r3 = 106(0x6a, float:1.49E-43)
                    r4 = 1
                    java.lang.Object[] r4 = new java.lang.Object[r4]
                    r5 = r4
                    r6 = 0
                    r7 = r9
                    com.blued.android.module.common.adx.tt.native.TTNativeExpressAdDataAdapter r7 = com.blued.android.module.common.adx.tt.p004native.TTNativeExpressAdDataAdapter.this
                    com.blued.android.module.common.login.model.BluedADExtra r7 = r7.getAdExtra()
                    r5[r6] = r7
                    r2.<init>(r3, r4)
                    r0.onADEvent(r1)
                L44:
                    r0 = r9
                    com.blued.android.module.common.adx.tt.native.TTNativeExpressAdDataAdapter r0 = com.blued.android.module.common.adx.tt.p004native.TTNativeExpressAdDataAdapter.this
                    r11 = r0
                    r0 = r11
                    r1 = r11
                    com.bytedance.sdk.openadsdk.TTNativeExpressAd r1 = com.blued.android.module.common.adx.tt.p004native.TTNativeExpressAdDataAdapter.a(r1)
                    android.view.View r1 = r1.getExpressAdView()
                    r0.removeView(r1)
                    r0 = r12
                    if (r0 == 0) goto L62
                    java.lang.String r0 = "adx"
                    java.lang.String r1 = "穿山甲SDK信息流 强制移除广告"
                    int r0 = android.util.Log.v(r0, r1)
                L62:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.tt.p004native.TTNativeExpressAdDataAdapter$bindDislike$1.onSelected(int, java.lang.String, boolean):void");
            }

            public void onShow() {
                Log.v("adx", "穿山甲SDK信息流 弹出不感兴趣对话框");
            }
        });
    }

    private final AdData getAdData() {
        return new AdData() { // from class: com.blued.android.module.common.adx.tt.native.TTNativeExpressAdDataAdapter$getAdData$1
            public boolean equalsAdData(AdData adData) {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            public int getAdPatternType() {
                TTNativeExpressAd tTNativeExpressAd;
                tTNativeExpressAd = TTNativeExpressAdDataAdapter.this.b;
                int imageMode = tTNativeExpressAd.getImageMode();
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

            public String getDesc() {
                return "";
            }

            public int getECPM() {
                return TTNativeExpressAdDataAdapter.this.getECPM();
            }

            public String getECPMLevel() {
                String str;
                str = TTNativeExpressAdDataAdapter.this.e;
                return str;
            }

            public Map<String, Object> getExtraInfo() {
                return new HashMap();
            }

            public <T> T getProperty(Class<T> cls) {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            public String getProperty(String str) {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            public String getTitle() {
                return "";
            }

            public int getVideoDuration() {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            public void setECPMLevel(String str) {
                TTNativeExpressAdDataAdapter.this.e = str;
            }
        };
    }

    public void destroy() {
        this.b.destroy();
    }

    public final BluedADExtra getAdExtra() {
        return this.a;
    }

    public String getApkInfoUrl() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public AdData getBoundData() {
        return this.c;
    }

    public int getECPM() {
        return -1;
    }

    public String getECPMLevel() {
        return this.c.getECPMLevel();
    }

    public Map<String, Object> getExtraInfo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public boolean isValid() {
        return true;
    }

    public void negativeFeedback() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void preloadVideo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void render() {
        this.b.render();
    }

    public void sendLossNotification(int i, int i2, String str) {
        this.b.loss(Double.valueOf(i), String.valueOf(i2), str);
    }

    public void sendLossNotification(Map<String, Object> map) {
        Intrinsics.e(map, "map");
    }

    public void sendWinNotification(int i) {
        this.b.win(Double.valueOf(i));
    }

    public void sendWinNotification(Map<String, Object> map) {
        Intrinsics.e(map, "map");
    }

    public final void setAdExtra(BluedADExtra bluedADExtra) {
        Intrinsics.e(bluedADExtra, "<set-?>");
        this.a = bluedADExtra;
    }

    public void setAdListener(ADListener aDListener) {
        this.d = aDListener;
    }

    public void setAdSize(ADSize aDSize) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void setBidECPM(int i) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void setViewBindStatusListener(NativeExpressADView.ViewBindStatusListener viewBindStatusListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
