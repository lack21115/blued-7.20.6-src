package com.blued.android.module.common.adx.ks.p003native;

import android.content.Context;
import android.util.Log;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.adx.base.BaseNativeExpressAd;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
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
/* renamed from: com.blued.android.module.common.adx.ks.native.KSNativeExpressAdAdapter  reason: invalid package */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/ks/native/KSNativeExpressAdAdapter.class */
public final class KSNativeExpressAdAdapter extends BaseNativeExpressAd {
    private BluedADExtra a;
    private ADSize b;
    private ADListener c;
    private final Context d;
    private KSNativeExpressAdDataAdapter e;
    private int f;

    public KSNativeExpressAdAdapter(Context context, BluedADExtra adExtra, ADSize adSize, ADListener listener) {
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
        String str = this.a.third_id;
        Intrinsics.c(str, "adExtra.third_id");
        KsScene build = new KsScene.Builder(Long.parseLong(str)).width(this.b.getWidth()).adNum(1).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            return;
        }
        loadManager.loadConfigFeedAd(build, new KsLoadManager.FeedAdListener() { // from class: com.blued.android.module.common.adx.ks.native.KSNativeExpressAdAdapter$loadExpressAd$1
            public void onError(int i, String msg) {
                Intrinsics.e(msg, "msg");
                BluedADExtra e = KSNativeExpressAdAdapter.this.e();
                e.errorMsg = i + " -- " + msg;
                Log.v("adx", "「快手信息流」广告「获取失败」 广告位id:" + ((Object) KSNativeExpressAdAdapter.this.e().third_id) + ' ' + i + " -- " + msg);
                aDListener.onADEvent(new ADEvent(101, KSNativeExpressAdAdapter.this));
            }

            public void onFeedAdLoad(List<? extends KsFeedAd> list) {
                Context context;
                Context context2;
                ADListener aDListener2;
                String str2;
                int i;
                List<? extends KsFeedAd> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    Log.v("adx", Intrinsics.a("「快手信息流」广告「获取失败」 广告位id:", (Object) KSNativeExpressAdAdapter.this.e().third_id));
                    aDListener.onADEvent(new ADEvent(101, KSNativeExpressAdAdapter.this));
                    return;
                }
                KsFeedAd ksFeedAd = list.get(0);
                ksFeedAd.setVideoPlayConfig(new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).build());
                context = KSNativeExpressAdAdapter.this.d;
                ADSize f = KSNativeExpressAdAdapter.this.f();
                context2 = KSNativeExpressAdAdapter.this.d;
                KSNativeExpressAdDataAdapter kSNativeExpressAdDataAdapter = new KSNativeExpressAdDataAdapter(context, ksFeedAd, f, ksFeedAd.getFeedView(context2), KSNativeExpressAdAdapter.this.e());
                KSNativeExpressAdAdapter.this.e = kSNativeExpressAdDataAdapter;
                aDListener2 = KSNativeExpressAdAdapter.this.c;
                kSNativeExpressAdDataAdapter.setAdListener(aDListener2);
                KSNativeExpressAdAdapter.this.f = ksFeedAd.getECPM();
                aDListener.onADEvent(new ADEvent(100, KSNativeExpressAdAdapter.this));
                if (KSNativeExpressAdAdapter.this.e().is_bidding()) {
                    i = KSNativeExpressAdAdapter.this.f;
                    str2 = Intrinsics.a("价格为：", (Object) Integer.valueOf(i));
                } else {
                    str2 = "";
                }
                Log.v("adx", "「快手信息流」广告「获取成功」 广告位id:" + ((Object) KSNativeExpressAdAdapter.this.e().third_id) + ' ' + str2);
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
        BuildersKt__Builders_commonKt.a(CoroutineScopeKt.a(), null, null, new KSNativeExpressAdAdapter$loadAD$2$1(this, cancellableContinuationImpl, null), 3, null);
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

    public final ADSize f() {
        return this.b;
    }
}
