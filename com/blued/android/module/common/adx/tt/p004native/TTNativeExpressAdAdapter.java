package com.blued.android.module.common.adx.tt.p004native;

import android.content.Context;
import android.util.Log;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.adx.base.BaseNativeExpressAd;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
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
/* renamed from: com.blued.android.module.common.adx.tt.native.TTNativeExpressAdAdapter  reason: invalid package */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/tt/native/TTNativeExpressAdAdapter.class */
public final class TTNativeExpressAdAdapter extends BaseNativeExpressAd {
    private BluedADExtra a;
    private ADSize b;
    private ADListener c;
    private final Context d;
    private TTNativeExpressAdDataAdapter e;
    private final TTAdNative f;
    private int g;

    public TTNativeExpressAdAdapter(Context context, BluedADExtra adExtra, ADSize adSize, ADListener listener) {
        Intrinsics.e(context, "context");
        Intrinsics.e(adExtra, "adExtra");
        Intrinsics.e(adSize, "adSize");
        Intrinsics.e(listener, "listener");
        this.a = adExtra;
        this.b = adSize;
        this.c = listener;
        this.d = context;
        TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(context);
        Intrinsics.c(createAdNative, "getAdManager().createAdNative(context)");
        this.f = createAdNative;
        this.g = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final ADListener aDListener) {
        this.f.loadNativeExpressAd(new AdSlot.Builder().setCodeId(this.a.third_id).setAdCount(1).setExpressViewAcceptedSize(this.b.getWidth(), 0.0f).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.blued.android.module.common.adx.tt.native.TTNativeExpressAdAdapter$loadExpressAd$1
            public void onError(int i, String str) {
                BluedADExtra e = TTNativeExpressAdAdapter.this.e();
                e.errorMsg = i + " -- " + ((Object) str);
                Log.v("adx", "「穿山甲信息流」广告「获取失败」 广告位id:" + ((Object) TTNativeExpressAdAdapter.this.e().third_id) + "  " + i + " -- " + ((Object) str));
                aDListener.onADEvent(new ADEvent(101, TTNativeExpressAdAdapter.this));
            }

            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                Context context;
                ADListener aDListener2;
                String str;
                int i;
                TTNativeExpressAdAdapter tTNativeExpressAdAdapter;
                Object obj;
                List<TTNativeExpressAd> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    Log.v("adx", Intrinsics.a("「穿山甲信息流」广告「获取失败」 广告位id:", (Object) TTNativeExpressAdAdapter.this.e().third_id));
                    aDListener.onADEvent(new ADEvent(101, TTNativeExpressAdAdapter.this));
                    return;
                }
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                context = TTNativeExpressAdAdapter.this.d;
                TTNativeExpressAdDataAdapter tTNativeExpressAdDataAdapter = new TTNativeExpressAdDataAdapter(context, tTNativeExpressAd, TTNativeExpressAdAdapter.this.e());
                TTNativeExpressAdAdapter.this.e = tTNativeExpressAdDataAdapter;
                aDListener2 = TTNativeExpressAdAdapter.this.c;
                tTNativeExpressAdDataAdapter.setAdListener(aDListener2);
                try {
                    tTNativeExpressAdAdapter = TTNativeExpressAdAdapter.this;
                    obj = tTNativeExpressAd.getMediaExtraInfo().get("price");
                } catch (Exception e) {
                }
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                tTNativeExpressAdAdapter.g = ((Integer) obj).intValue();
                aDListener.onADEvent(new ADEvent(100, TTNativeExpressAdAdapter.this));
                if (TTNativeExpressAdAdapter.this.e().is_bidding()) {
                    i = TTNativeExpressAdAdapter.this.g;
                    str = Intrinsics.a("价格为：", (Object) Integer.valueOf(i));
                } else {
                    str = "";
                }
                Log.v("adx", "「穿山甲信息流」广告「获取成功」 广告位id:" + ((Object) TTNativeExpressAdAdapter.this.e().third_id) + ' ' + str);
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
        BuildersKt__Builders_commonKt.a(CoroutineScopeKt.a(), null, null, new TTNativeExpressAdAdapter$loadAD$2$1(this, cancellableContinuationImpl, null), 3, null);
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
        return this.g;
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public Map<String, Object> d() {
        return MapsKt.a(TuplesKt.a("original_ad", this.a));
    }

    public final BluedADExtra e() {
        return this.a;
    }
}
