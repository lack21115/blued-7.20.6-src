package com.blued.android.module.common.adx.ks.unified;

import android.content.Context;
import android.util.Log;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.adx.base.BaseNativeExpressAd;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.qq.e.ads.nativ.NativeUnifiedADData;
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
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/ks/unified/KSNativeAdAdapter.class */
public final class KSNativeAdAdapter extends BaseNativeExpressAd {

    /* renamed from: a  reason: collision with root package name */
    private BluedADExtra f10583a;
    private ADListener b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f10584c;
    private KSNativeAdDataAdapter d;
    private int e;

    public KSNativeAdAdapter(Context context, BluedADExtra adExtra, ADListener listener) {
        Intrinsics.e(context, "context");
        Intrinsics.e(adExtra, "adExtra");
        Intrinsics.e(listener, "listener");
        this.f10583a = adExtra;
        this.b = listener;
        this.f10584c = context;
        this.e = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final ADListener aDListener) {
        String str = this.f10583a.third_id;
        Intrinsics.c(str, "adExtra.third_id");
        KsScene build = new KsScene.Builder(Long.parseLong(str)).build();
        build.setAdNum(1);
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            return;
        }
        loadManager.loadNativeAd(build, new KsLoadManager.NativeAdListener() { // from class: com.blued.android.module.common.adx.ks.unified.KSNativeAdAdapter$loadExpressAd$1
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i, String msg) {
                Intrinsics.e(msg, "msg");
                BluedADExtra e = KSNativeAdAdapter.this.e();
                e.errorMsg = i + " -- " + msg;
                Log.v("adx", "「快手自渲染」广告「获取失败」 广告位id:" + ((Object) KSNativeAdAdapter.this.e().third_id) + ' ' + i + " -- " + msg);
                aDListener.onADEvent(new ADEvent(101, KSNativeAdAdapter.this));
            }

            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(List<? extends KsNativeAd> list) {
                Context context;
                ADListener aDListener2;
                String str2;
                int i;
                List<? extends KsNativeAd> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    Log.v("adx", Intrinsics.a("「快手自渲染」广告「获取失败」 广告位id:", (Object) KSNativeAdAdapter.this.e().third_id));
                    aDListener.onADEvent(new ADEvent(101, KSNativeAdAdapter.this));
                    return;
                }
                KsNativeAd ksNativeAd = list.get(0);
                context = KSNativeAdAdapter.this.f10584c;
                KSNativeAdDataAdapter kSNativeAdDataAdapter = new KSNativeAdDataAdapter(context, ksNativeAd, KSNativeAdAdapter.this.e());
                KSNativeAdAdapter.this.d = kSNativeAdDataAdapter;
                aDListener2 = KSNativeAdAdapter.this.b;
                kSNativeAdDataAdapter.a(aDListener2);
                KSNativeAdAdapter.this.e = ksNativeAd.getECPM();
                aDListener.onADEvent(new ADEvent(100, KSNativeAdAdapter.this));
                if (KSNativeAdAdapter.this.e().is_bidding()) {
                    i = KSNativeAdAdapter.this.e;
                    str2 = Intrinsics.a("价格为：", (Object) Integer.valueOf(i));
                } else {
                    str2 = "";
                }
                Log.v("adx", "「快手自渲染」广告「获取成功」 广告位id:" + ((Object) KSNativeAdAdapter.this.e().third_id) + ' ' + str2);
            }
        });
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public Object a(Continuation<? super ADEvent> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        BuildersKt__Builders_commonKt.a(CoroutineScopeKt.a(), null, null, new KSNativeAdAdapter$loadAD$2$1(this, cancellableContinuationImpl, null), 3, null);
        Object h = cancellableContinuationImpl.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h;
    }

    @Override // com.blued.android.module.common.adx.base.BaseNativeExpressAd
    public void a(Map<String, ? extends Object> map) {
        Intrinsics.e(map, "map");
        NativeUnifiedADData b = b();
        if (b == null) {
            return;
        }
        b.sendWinNotification(map);
    }

    @Override // com.blued.android.module.common.adx.base.BaseNativeExpressAd
    public NativeUnifiedADData b() {
        return this.d;
    }

    @Override // com.blued.android.module.common.adx.base.BaseNativeExpressAd
    public void b(Map<String, ? extends Object> map) {
        Intrinsics.e(map, "map");
        NativeUnifiedADData b = b();
        if (b == null) {
            return;
        }
        b.sendLossNotification(map);
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public int c() {
        return this.e;
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public Map<String, Object> d() {
        return MapsKt.a(TuplesKt.a("original_ad", this.f10583a));
    }

    public final BluedADExtra e() {
        return this.f10583a;
    }
}
