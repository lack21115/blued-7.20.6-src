package com.blued.android.module.common.adx.tt.unified;

import android.content.Context;
import android.util.Log;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.adx.base.BaseNativeExpressAd;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.cdo.oaps.ad.OapsKey;
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
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/tt/unified/TTNativeAdAdapter.class */
public final class TTNativeAdAdapter extends BaseNativeExpressAd {

    /* renamed from: a  reason: collision with root package name */
    private BluedADExtra f10606a;
    private ADListener b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f10607c;
    private TTNativeAdDataAdapter d;
    private int e;

    public TTNativeAdAdapter(Context context, BluedADExtra adExtra, ADListener listener) {
        Intrinsics.e(context, "context");
        Intrinsics.e(adExtra, "adExtra");
        Intrinsics.e(listener, "listener");
        this.f10606a = adExtra;
        this.b = listener;
        this.f10607c = context;
        this.e = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final ADListener aDListener) {
        TTAdSdk.getAdManager().createAdNative(this.f10607c).loadFeedAd(new AdSlot.Builder().setCodeId(this.f10606a.third_id).setSupportDeepLink(true).setImageAcceptedSize(228, 150).setAdCount(1).build(), new TTAdNative.FeedAdListener() { // from class: com.blued.android.module.common.adx.tt.unified.TTNativeAdAdapter$loadExpressAd$1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i, String msg) {
                Intrinsics.e(msg, "msg");
                BluedADExtra e = TTNativeAdAdapter.this.e();
                e.errorMsg = i + " -- " + msg;
                Log.v("adx", "「穿山甲自渲染」广告「获取失败」 广告位id:" + ((Object) TTNativeAdAdapter.this.e().third_id) + ' ' + i + " -- " + msg);
                aDListener.onADEvent(new ADEvent(101, TTNativeAdAdapter.this));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<? extends TTFeedAd> adList) {
                Context context;
                ADListener aDListener2;
                String str;
                int i;
                TTNativeAdAdapter tTNativeAdAdapter;
                Object obj;
                Intrinsics.e(adList, "adList");
                if (adList.isEmpty()) {
                    Log.v("adx", Intrinsics.a("「穿山甲自渲染」广告「获取失败」 广告位id:", (Object) TTNativeAdAdapter.this.e().third_id));
                    aDListener.onADEvent(new ADEvent(101, TTNativeAdAdapter.this));
                    return;
                }
                TTFeedAd tTFeedAd = adList.get(0);
                context = TTNativeAdAdapter.this.f10607c;
                TTNativeAdDataAdapter tTNativeAdDataAdapter = new TTNativeAdDataAdapter(context, tTFeedAd, TTNativeAdAdapter.this.e());
                TTNativeAdAdapter.this.d = tTNativeAdDataAdapter;
                aDListener2 = TTNativeAdAdapter.this.b;
                tTNativeAdDataAdapter.a(aDListener2);
                try {
                    tTNativeAdAdapter = TTNativeAdAdapter.this;
                    obj = tTFeedAd.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                } catch (Exception e) {
                }
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                tTNativeAdAdapter.e = ((Integer) obj).intValue();
                aDListener.onADEvent(new ADEvent(100, TTNativeAdAdapter.this));
                if (TTNativeAdAdapter.this.e().is_bidding()) {
                    i = TTNativeAdAdapter.this.e;
                    str = Intrinsics.a("价格为：", (Object) Integer.valueOf(i));
                } else {
                    str = "";
                }
                Log.v("adx", "「穿山甲自渲染」广告「获取成功」 广告位id:" + ((Object) TTNativeAdAdapter.this.e().third_id) + ' ' + str);
            }
        });
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public Object a(Continuation<? super ADEvent> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        BuildersKt__Builders_commonKt.a(CoroutineScopeKt.a(), null, null, new TTNativeAdAdapter$loadAD$2$1(this, cancellableContinuationImpl, null), 3, null);
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
        return MapsKt.a(TuplesKt.a("original_ad", this.f10606a));
    }

    public final BluedADExtra e() {
        return this.f10606a;
    }
}
