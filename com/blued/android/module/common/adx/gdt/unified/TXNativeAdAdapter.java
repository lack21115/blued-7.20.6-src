package com.blued.android.module.common.adx.gdt.unified;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.adx.base.BaseNativeExpressAd;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
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
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/gdt/unified/TXNativeAdAdapter.class */
public final class TXNativeAdAdapter extends BaseNativeExpressAd {
    private BluedADExtra a;
    private NativeUnifiedAD b;
    private ADListener c;
    private final Context d;
    private int e;
    private TXNativeAdDataAdapter f;

    public TXNativeAdAdapter(Context context, BluedADExtra adExtra, ADListener listener) {
        Intrinsics.e(context, "context");
        Intrinsics.e(adExtra, "adExtra");
        Intrinsics.e(listener, "listener");
        this.a = adExtra;
        this.c = listener;
        this.d = context;
        this.e = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ADListener aDListener) {
        NativeUnifiedAD nativeUnifiedAD;
        if (this.a.gdt_bid == null || TextUtils.isEmpty(this.a.gdt_bid.gdt_token)) {
            nativeUnifiedAD = new NativeUnifiedAD(this.d, this.a.third_id, b(aDListener));
        } else {
            Log.v("adx", Intrinsics.a("「广点通自渲染」广告 本次请求为服务端bidding，token:", (Object) this.a.gdt_bid.gdt_token));
            nativeUnifiedAD = new NativeUnifiedAD(this.d, this.a.third_id, b(aDListener), this.a.gdt_bid.gdt_token);
        }
        this.b = nativeUnifiedAD;
        if (nativeUnifiedAD == null) {
            return;
        }
        nativeUnifiedAD.loadData(1);
    }

    private final NativeADUnifiedListener b(final ADListener aDListener) {
        return new NativeADUnifiedListener() { // from class: com.blued.android.module.common.adx.gdt.unified.TXNativeAdAdapter$getNativeADListener$1
            public void onADLoaded(List<NativeUnifiedADData> list) {
                Context context;
                String str;
                TXNativeAdDataAdapter tXNativeAdDataAdapter;
                int i;
                List<NativeUnifiedADData> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    Log.v("adx", Intrinsics.a("「广点通自渲染」广告「获取失败」 广告位id:", (Object) TXNativeAdAdapter.this.e().third_id));
                    aDListener.onADEvent(new ADEvent(101, TXNativeAdAdapter.this));
                    return;
                }
                NativeUnifiedADData nativeUnifiedADData = list.get(0);
                context = TXNativeAdAdapter.this.d;
                TXNativeAdAdapter.this.f = new TXNativeAdDataAdapter(context, nativeUnifiedADData, TXNativeAdAdapter.this.e());
                TXNativeAdAdapter tXNativeAdAdapter = TXNativeAdAdapter.this;
                tXNativeAdAdapter.e = tXNativeAdAdapter.e().isServerBidding() ? (int) TXNativeAdAdapter.this.e().price : nativeUnifiedADData.getECPM();
                aDListener.onADEvent(new ADEvent(100, TXNativeAdAdapter.this));
                if (TXNativeAdAdapter.this.e().is_bidding()) {
                    i = TXNativeAdAdapter.this.e;
                    str = Intrinsics.a("价格为：", (Object) Integer.valueOf(i));
                } else {
                    str = "";
                }
                Log.v("adx", "「广点通自渲染」广告「获取成功」 广告位id:" + ((Object) TXNativeAdAdapter.this.e().third_id) + ' ' + str);
                tXNativeAdDataAdapter = TXNativeAdAdapter.this.f;
                if (tXNativeAdDataAdapter == null) {
                    return;
                }
                final TXNativeAdAdapter tXNativeAdAdapter2 = TXNativeAdAdapter.this;
                final ADListener aDListener2 = aDListener;
                tXNativeAdDataAdapter.setNativeAdEventListener(new NativeADEventListener() { // from class: com.blued.android.module.common.adx.gdt.unified.TXNativeAdAdapter$getNativeADListener$1$onADLoaded$1
                    public void onADClicked() {
                        ADListener aDListener3;
                        Log.v("adx", "「广点通自渲染」 点击回调");
                        aDListener3 = TXNativeAdAdapter.this.c;
                        if (aDListener3 == null) {
                            return;
                        }
                        aDListener3.onADEvent(new ADEvent(105, TXNativeAdAdapter.this.e()));
                    }

                    public void onADError(AdError adError) {
                        BluedADExtra e = TXNativeAdAdapter.this.e();
                        StringBuilder sb = new StringBuilder();
                        sb.append(adError == null ? null : Integer.valueOf(adError.getErrorCode()));
                        sb.append(" -- ");
                        sb.append((Object) (adError == null ? null : adError.getErrorMsg()));
                        e.errorMsg = sb.toString();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("「广点通自渲染」广告「获取失败」 广告位id:");
                        sb2.append((Object) TXNativeAdAdapter.this.e().third_id);
                        sb2.append(' ');
                        sb2.append(adError == null ? null : Integer.valueOf(adError.getErrorCode()));
                        sb2.append(" -- ");
                        sb2.append((Object) (adError == null ? null : adError.getErrorMsg()));
                        Log.v("adx", sb2.toString());
                        aDListener2.onADEvent(new ADEvent(101, TXNativeAdAdapter.this));
                    }

                    public void onADExposed() {
                        ADListener aDListener3;
                        Log.v("adx", "「广点通自渲染」 曝光回调");
                        aDListener3 = TXNativeAdAdapter.this.c;
                        if (aDListener3 == null) {
                            return;
                        }
                        aDListener3.onADEvent(new ADEvent(103, TXNativeAdAdapter.this.e()));
                    }

                    public void onADStatusChanged() {
                    }
                });
            }

            public void onNoAD(AdError adError) {
                BluedADExtra e = TXNativeAdAdapter.this.e();
                StringBuilder sb = new StringBuilder();
                sb.append(adError == null ? null : Integer.valueOf(adError.getErrorCode()));
                sb.append(" -- ");
                sb.append((Object) (adError == null ? null : adError.getErrorMsg()));
                e.errorMsg = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("「广点通自渲染」广告「获取失败」 广告位id:");
                sb2.append((Object) TXNativeAdAdapter.this.e().third_id);
                sb2.append(' ');
                sb2.append(adError == null ? null : Integer.valueOf(adError.getErrorCode()));
                sb2.append(" -- ");
                sb2.append((Object) (adError == null ? null : adError.getErrorMsg()));
                Log.v("adx", sb2.toString());
                aDListener.onADEvent(new ADEvent(101, TXNativeAdAdapter.this));
            }
        };
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public Object a(Continuation<? super ADEvent> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        BuildersKt__Builders_commonKt.a(CoroutineScopeKt.a(), null, null, new TXNativeAdAdapter$loadAD$2$1(this, cancellableContinuationImpl, null), 3, null);
        Object h = cancellableContinuationImpl.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h;
    }

    @Override // com.blued.android.module.common.adx.base.BaseNativeExpressAd
    public void a(Map<String, ? extends Object> map) {
        Intrinsics.e(map, "map");
        TXNativeAdDataAdapter tXNativeAdDataAdapter = this.f;
        if (tXNativeAdDataAdapter == null) {
            return;
        }
        tXNativeAdDataAdapter.sendWinNotification(map);
    }

    @Override // com.blued.android.module.common.adx.base.BaseNativeExpressAd
    public NativeUnifiedADData b() {
        return this.f;
    }

    @Override // com.blued.android.module.common.adx.base.BaseNativeExpressAd
    public void b(Map<String, ? extends Object> map) {
        Intrinsics.e(map, "map");
        TXNativeAdDataAdapter tXNativeAdDataAdapter = this.f;
        if (tXNativeAdDataAdapter == null) {
            return;
        }
        tXNativeAdDataAdapter.sendLossNotification(map);
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public int c() {
        return this.e;
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public Map<String, Object> d() {
        return MapsKt.a(TuplesKt.a("original_ad", this.a));
    }

    public final BluedADExtra e() {
        return this.a;
    }
}
