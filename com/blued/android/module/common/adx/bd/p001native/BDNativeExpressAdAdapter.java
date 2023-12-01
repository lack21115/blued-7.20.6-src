package com.blued.android.module.common.adx.bd.p001native;

import android.content.Context;
import android.util.Log;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.adx.base.BaseNativeExpressAd;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata
/* renamed from: com.blued.android.module.common.adx.bd.native.BDNativeExpressAdAdapter  reason: invalid package */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/bd/native/BDNativeExpressAdAdapter.class */
public final class BDNativeExpressAdAdapter extends BaseNativeExpressAd {
    private BluedADExtra a;
    private ADSize b;
    private ADListener c;
    private final Context d;
    private BDNativeExpressAdDataAdapter e;
    private int f;

    public BDNativeExpressAdAdapter(Context context, BluedADExtra adExtra, ADSize adSize, ADListener listener) {
        Intrinsics.e(context, "context");
        Intrinsics.e(adExtra, "adExtra");
        Intrinsics.e(adSize, "adSize");
        Intrinsics.e(listener, "listener");
        this.a = adExtra;
        this.b = adSize;
        this.c = listener;
        this.d = context;
        this.f = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final ADListener aDListener) {
        new BaiduNativeManager(this.d, this.a.third_id).loadExpressAd(new RequestParameters.Builder().setWidth(this.b.getWidth()).setHeight(this.b.getHeight()).build(), new BaiduNativeManager.ExpressAdListener() { // from class: com.blued.android.module.common.adx.bd.native.BDNativeExpressAdAdapter$loadExpressAd$1
            public void onLpClosed() {
            }

            public void onNativeFail(int i, String msg) {
                Intrinsics.e(msg, "msg");
                BluedADExtra e = BDNativeExpressAdAdapter.this.e();
                e.errorMsg = i + " -- " + msg;
                Log.v("adx", "「百度信息流」广告获取失败 广告位id:" + ((Object) BDNativeExpressAdAdapter.this.e().third_id) + ' ' + i + " -- " + msg);
                aDListener.onADEvent(new ADEvent(101, BDNativeExpressAdAdapter.this));
            }

            public void onNativeLoad(List<? extends ExpressResponse> list) {
                Context context;
                ADListener aDListener2;
                String str;
                int i;
                List<? extends ExpressResponse> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    Log.v("adx", Intrinsics.a("「百度信息流」广告「获取失败」 广告位id:", (Object) BDNativeExpressAdAdapter.this.e().third_id));
                    aDListener.onADEvent(new ADEvent(101, BDNativeExpressAdAdapter.this));
                    return;
                }
                ExpressResponse expressResponse = list.get(0);
                context = BDNativeExpressAdAdapter.this.d;
                BDNativeExpressAdDataAdapter bDNativeExpressAdDataAdapter = new BDNativeExpressAdDataAdapter(context, expressResponse, BDNativeExpressAdAdapter.this.e());
                BDNativeExpressAdAdapter.this.e = bDNativeExpressAdDataAdapter;
                aDListener2 = BDNativeExpressAdAdapter.this.c;
                bDNativeExpressAdDataAdapter.setAdListener(aDListener2);
                try {
                    BDNativeExpressAdAdapter bDNativeExpressAdAdapter = BDNativeExpressAdAdapter.this;
                    String eCPMLevel = expressResponse.getECPMLevel();
                    Intrinsics.c(eCPMLevel, "ad.ecpmLevel");
                    bDNativeExpressAdAdapter.f = Integer.parseInt(eCPMLevel);
                } catch (Exception e) {
                }
                aDListener.onADEvent(new ADEvent(100, BDNativeExpressAdAdapter.this));
                if (BDNativeExpressAdAdapter.this.e().is_bidding()) {
                    i = BDNativeExpressAdAdapter.this.f;
                    str = Intrinsics.a("价格为：", (Object) Integer.valueOf(i));
                } else {
                    str = "";
                }
                Log.v("adx", "「百度信息流」广告「获取成功」 广告位id:" + ((Object) BDNativeExpressAdAdapter.this.e().third_id) + ' ' + str);
            }

            public void onNoAd(int i, String msg) {
                Intrinsics.e(msg, "msg");
                BluedADExtra e = BDNativeExpressAdAdapter.this.e();
                e.errorMsg = i + " -- " + msg;
                Log.v("adx", "「百度信息流」广告「获取失败」 广告位id:" + ((Object) BDNativeExpressAdAdapter.this.e().third_id) + "  " + i + " -- " + msg);
                aDListener.onADEvent(new ADEvent(101, BDNativeExpressAdAdapter.this));
            }

            public void onVideoDownloadFailed() {
            }

            public void onVideoDownloadSuccess() {
                aDListener.onADEvent(new ADEvent(201, new Object[0]));
            }
        });
    }

    @Override // com.blued.android.module.common.adx.base.BaseNativeExpressAd
    public NativeExpressADView a() {
        return this.e;
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public Object a(Continuation<? super ADEvent> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        BuildersKt__Builders_commonKt.a(CoroutineScopeKt.a(), null, null, new BDNativeExpressAdAdapter$loadAD$2$1(this, cancellableContinuationImpl, null), 3, null);
        Object h = cancellableContinuationImpl.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h;
    }

    @Override // com.blued.android.module.common.adx.base.BaseNativeExpressAd
    public void a(Map<String, ? extends Object> map) {
        Intrinsics.e(map, "map");
        NativeExpressADView a = a();
        if (a == null) {
            return;
        }
        a.sendWinNotification(map);
    }

    @Override // com.blued.android.module.common.adx.base.BaseNativeExpressAd
    public void b(Map<String, ? extends Object> map) {
        Intrinsics.e(map, "map");
        NativeExpressADView a = a();
        if (a == null) {
            return;
        }
        a.sendLossNotification(map);
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public int c() {
        return this.f;
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public Map<String, Object> d() {
        return MapsKt.a(TuplesKt.a("original_ad", this.a));
    }

    public final BluedADExtra e() {
        return this.a;
    }
}
