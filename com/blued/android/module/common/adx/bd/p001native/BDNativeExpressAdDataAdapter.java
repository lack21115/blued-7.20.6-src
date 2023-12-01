package com.blued.android.module.common.adx.bd.p001native;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.baidu.mobads.sdk.api.ExpressAdData;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.blued.android.module.common.adx.base.ADEvent;
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
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* renamed from: com.blued.android.module.common.adx.bd.native.BDNativeExpressAdDataAdapter  reason: invalid package */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/bd/native/BDNativeExpressAdDataAdapter.class */
public final class BDNativeExpressAdDataAdapter extends NativeExpressADView implements ADEventListener {
    public static final Companion a = new Companion(null);
    private BluedADExtra b;
    private WeakReference<Context> c;
    private ExpressResponse d;
    private AdData e;
    private ADListener f;
    private String g;

    @Metadata
    /* renamed from: com.blued.android.module.common.adx.bd.native.BDNativeExpressAdDataAdapter$Companion */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/bd/native/BDNativeExpressAdDataAdapter$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDNativeExpressAdDataAdapter(Context context, ExpressResponse data, BluedADExtra adExtra) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(data, "data");
        Intrinsics.e(adExtra, "adExtra");
        this.b = adExtra;
        this.c = new WeakReference<>(context);
        this.d = data;
        this.e = getAdData();
        b();
        a();
        c();
    }

    private final void a() {
        this.d.setInteractionListener(new BDNativeExpressAdDataAdapter$tryBindInteractionAdListener$1(this));
    }

    private final void b() {
        this.d.setAdDislikeListener(new ExpressResponse.ExpressDislikeListener() { // from class: com.blued.android.module.common.adx.bd.native.BDNativeExpressAdDataAdapter$bindDislike$1
            public void onDislikeItemClick(String reason) {
                ADListener aDListener;
                Intrinsics.e(reason, "reason");
                Log.v("adx", "百度SDK信息流 负反馈选项点击 onDislikeItemClick，暂用这个回调当做是广告关闭回调");
                Log.v("adx", "自测过程中发现，百度信息流广告关闭偶现会失效");
                aDListener = BDNativeExpressAdDataAdapter.this.f;
                if (aDListener == null) {
                    return;
                }
                aDListener.onADEvent(new ADEvent(106, BDNativeExpressAdDataAdapter.this.getAdExtra()));
            }

            public void onDislikeWindowClose() {
                Log.v("adx", "百度 onDislikeWindowClose");
            }

            public void onDislikeWindowShow() {
            }
        });
    }

    private final void c() {
        this.d.setAdPrivacyListener(new ExpressResponse.ExpressAdDownloadWindowListener() { // from class: com.blued.android.module.common.adx.bd.native.BDNativeExpressAdDataAdapter$tryBindAdPrivacyListener$1
            public void adDownloadWindowClose() {
            }

            public void adDownloadWindowShow() {
            }

            public void onADPermissionClose() {
            }

            public void onADPermissionShow() {
            }

            public void onADPrivacyClick() {
            }
        });
    }

    private final AdData getAdData() {
        return new AdData() { // from class: com.blued.android.module.common.adx.bd.native.BDNativeExpressAdDataAdapter$getAdData$1
            public boolean equalsAdData(AdData adData) {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            public int getAdPatternType() {
                ExpressResponse expressResponse;
                expressResponse = BDNativeExpressAdDataAdapter.this.d;
                switch (expressResponse.getStyleType()) {
                    case 28:
                    case 29:
                    case 30:
                    case 33:
                    case 34:
                        return 1;
                    case 31:
                    case 32:
                    default:
                        return 4;
                    case 35:
                    case 36:
                        return 3;
                    case 37:
                        return 2;
                }
            }

            public String getDesc() {
                return "";
            }

            public int getECPM() {
                return BDNativeExpressAdDataAdapter.this.getECPM();
            }

            public String getECPMLevel() {
                ExpressResponse expressResponse;
                expressResponse = BDNativeExpressAdDataAdapter.this.d;
                return expressResponse.getECPMLevel();
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
                ExpressResponse expressResponse;
                expressResponse = BDNativeExpressAdDataAdapter.this.d;
                ExpressAdData adData = expressResponse.getAdData();
                if (adData == null) {
                    return null;
                }
                return adData.getTitle();
            }

            public int getVideoDuration() {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            public void setECPMLevel(String str) {
                BDNativeExpressAdDataAdapter.this.g = str;
            }
        };
    }

    public void destroy() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final BluedADExtra getAdExtra() {
        return this.b;
    }

    public String getApkInfoUrl() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public AdData getBoundData() {
        return this.e;
    }

    public int getECPM() {
        try {
            String eCPMLevel = this.d.getECPMLevel();
            Intrinsics.c(eCPMLevel, "mExpressResponse.ecpmLevel");
            return Integer.parseInt(eCPMLevel);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String getECPMLevel() {
        return this.e.getECPMLevel();
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
        this.d.render();
    }

    public void sendLossNotification(int i, int i2, String str) {
        this.d.biddingFail(String.valueOf(i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendLossNotification(java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.bd.p001native.BDNativeExpressAdDataAdapter.sendLossNotification(java.util.Map):void");
    }

    public void sendWinNotification(int i) {
        this.d.biddingSuccess(String.valueOf(i));
    }

    public void sendWinNotification(Map<String, Object> map) {
        Intrinsics.e(map, "map");
        this.d.biddingSuccess(String.valueOf(map.get("highest_loss_price")));
    }

    public final void setAdExtra(BluedADExtra bluedADExtra) {
        Intrinsics.e(bluedADExtra, "<set-?>");
        this.b = bluedADExtra;
    }

    public void setAdListener(ADListener aDListener) {
        this.f = aDListener;
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
