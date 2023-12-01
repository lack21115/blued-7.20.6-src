package com.blued.android.module.common.adx.ks.p003native;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADEventListener;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.kwad.sdk.api.KsFeedAd;
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
/* renamed from: com.blued.android.module.common.adx.ks.native.KSNativeExpressAdDataAdapter  reason: invalid package */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/ks/native/KSNativeExpressAdDataAdapter.class */
public final class KSNativeExpressAdDataAdapter extends NativeExpressADView implements ADEventListener {

    /* renamed from: a  reason: collision with root package name */
    private final ADSize f10579a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private BluedADExtra f10580c;
    private final KsFeedAd d;
    private final AdData e;
    private ADListener f;
    private final Context g;
    private String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSNativeExpressAdDataAdapter(Context context, KsFeedAd data, ADSize adSize, View view, BluedADExtra adExtra) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(data, "data");
        Intrinsics.e(adSize, "adSize");
        Intrinsics.e(adExtra, "adExtra");
        this.f10579a = adSize;
        this.b = view;
        this.f10580c = adExtra;
        this.d = data;
        this.e = getAdData();
        a();
    }

    private final void a() {
        this.d.setAdInteractionListener(new KsFeedAd.AdInteractionListener() { // from class: com.blued.android.module.common.adx.ks.native.KSNativeExpressAdDataAdapter$tryBindInteractionAdListener$1
            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdClicked() {
                ADListener aDListener;
                Log.v("adx", "快手SDK信息流 点击回调");
                aDListener = KSNativeExpressAdDataAdapter.this.f;
                if (aDListener == null) {
                    return;
                }
                aDListener.onADEvent(new ADEvent(105, KSNativeExpressAdDataAdapter.this.getAdExtra()));
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdShow() {
                ADListener aDListener;
                Log.v("adx", "快手SDK信息流 曝光回调");
                aDListener = KSNativeExpressAdDataAdapter.this.f;
                if (aDListener == null) {
                    return;
                }
                aDListener.onADEvent(new ADEvent(103, KSNativeExpressAdDataAdapter.this.getAdExtra()));
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDislikeClicked() {
                ADListener aDListener;
                Log.v("adx", "快手SDK信息流 关闭回调");
                aDListener = KSNativeExpressAdDataAdapter.this.f;
                if (aDListener == null) {
                    return;
                }
                aDListener.onADEvent(new ADEvent(106, KSNativeExpressAdDataAdapter.this.getAdExtra()));
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(KSNativeExpressAdDataAdapter this$0) {
        Intrinsics.e(this$0, "this$0");
        View feedView = this$0.d.getFeedView(this$0.g);
        View view = feedView;
        if (feedView == null) {
            view = this$0.b;
        }
        ViewGroup.LayoutParams layoutParams = view == null ? null : view.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = new ViewGroup.LayoutParams(this$0.f10579a.getWidth(), this$0.f10579a.getHeight());
        }
        if (view != null) {
            this$0.addView(view, layoutParams2);
        } else {
            Log.v("adx", "测试过程中发现「快手信息流」广告 获取到的view是空的，此时会出现快手竞价成功，但是没有广告绘制到UI");
        }
    }

    private final AdData getAdData() {
        return new AdData() { // from class: com.blued.android.module.common.adx.ks.native.KSNativeExpressAdDataAdapter$getAdData$1
            @Override // com.qq.e.comm.pi.AdData
            public boolean equalsAdData(AdData adData) {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.qq.e.comm.pi.AdData
            public int getAdPatternType() {
                KsFeedAd ksFeedAd;
                ksFeedAd = KSNativeExpressAdDataAdapter.this.d;
                int materialType = ksFeedAd.getMaterialType();
                int i = 3;
                if (materialType == 1) {
                    i = 2;
                } else if (materialType == 2) {
                    return 1;
                } else {
                    if (materialType != 3) {
                        return 4;
                    }
                }
                return i;
            }

            @Override // com.qq.e.comm.pi.AdData
            public String getDesc() {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.qq.e.comm.pi.AdData
            public int getECPM() {
                return KSNativeExpressAdDataAdapter.this.getECPM();
            }

            @Override // com.qq.e.comm.pi.AdData
            public String getECPMLevel() {
                String str;
                str = KSNativeExpressAdDataAdapter.this.h;
                Intrinsics.a((Object) str);
                return str;
            }

            @Override // com.qq.e.comm.pi.AdData
            public Map<String, Object> getExtraInfo() {
                return new HashMap();
            }

            @Override // com.qq.e.comm.pi.AdData
            public <T> T getProperty(Class<T> cls) {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.qq.e.comm.pi.AdData
            public String getProperty(String str) {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.qq.e.comm.pi.AdData
            public String getTitle() {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.qq.e.comm.pi.AdData
            public int getVideoDuration() {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.qq.e.comm.pi.AdData
            public void setECPMLevel(String str) {
                KSNativeExpressAdDataAdapter.this.h = str;
            }
        };
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void destroy() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final BluedADExtra getAdExtra() {
        return this.f10580c;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public AdData getBoundData() {
        return this.e;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.d.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        String eCPMLevel = this.e.getECPMLevel();
        Intrinsics.c(eCPMLevel, "mAdData.ecpmLevel");
        return eCPMLevel;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        Map<String, Object> extraInfo = this.e.getExtraInfo();
        Intrinsics.c(extraInfo, "mAdData.extraInfo");
        return extraInfo;
    }

    public final View getMFeedView() {
        return this.b;
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void negativeFeedback() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void preloadVideo() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void render() {
        ADListener aDListener = this.f;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(109, this.f10580c));
        }
        post(new Runnable() { // from class: com.blued.android.module.common.adx.ks.native.-$$Lambda$KSNativeExpressAdDataAdapter$2-pUo75bf22QLGqPuACppu_zEAI
            @Override // java.lang.Runnable
            public final void run() {
                KSNativeExpressAdDataAdapter.d(KSNativeExpressAdDataAdapter.this);
            }
        });
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01e4  */
    @Override // com.qq.e.comm.pi.IBidding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendLossNotification(java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.ks.p003native.KSNativeExpressAdDataAdapter.sendLossNotification(java.util.Map):void");
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        this.d.setBidEcpm(i);
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
        if (this.f10580c.settlement_price != 1) {
            this.d.setBidEcpm(j, j2);
            return;
        }
        Log.v("adx", Intrinsics.a("快手后台配置为一价结算，回传给第三方竞败⽅的最⾼价格为（单位分）：", (Object) Long.valueOf(j)));
        this.d.setBidEcpm(j, j);
    }

    public final void setAdExtra(BluedADExtra bluedADExtra) {
        Intrinsics.e(bluedADExtra, "<set-?>");
        this.f10580c = bluedADExtra;
    }

    public void setAdListener(ADListener aDListener) {
        this.f = aDListener;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setAdSize(ADSize aDSize) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final void setMFeedView(View view) {
        this.b = view;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setViewBindStatusListener(NativeExpressADView.ViewBindStatusListener viewBindStatusListener) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
