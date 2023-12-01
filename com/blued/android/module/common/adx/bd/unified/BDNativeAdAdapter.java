package com.blued.android.module.common.adx.bd.unified;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.adx.base.BaseNativeExpressAd;
import com.blued.android.module.common.login.model.BluedADExtra;
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
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/bd/unified/BDNativeAdAdapter.class */
public final class BDNativeAdAdapter extends BaseNativeExpressAd {

    /* renamed from: a  reason: collision with root package name */
    private BluedADExtra f10535a;
    private ADListener b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f10536c;
    private BDNativeAdDataAdapter d;
    private int e;
    private Handler f;

    public BDNativeAdAdapter(Context context, BluedADExtra adExtra, ADListener listener) {
        Intrinsics.e(context, "context");
        Intrinsics.e(adExtra, "adExtra");
        Intrinsics.e(listener, "listener");
        this.f10535a = adExtra;
        this.b = listener;
        this.f10536c = context;
        this.e = -1;
        this.f = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final ADListener aDListener) {
        new BaiduNativeManager(this.f10536c, this.f10535a.third_id).loadFeedAd(new RequestParameters.Builder().downloadAppConfirmPolicy(1).build(), new BaiduNativeManager.FeedAdListener() { // from class: com.blued.android.module.common.adx.bd.unified.BDNativeAdAdapter$loadExpressAd$1
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeFail(int i, String str) {
                BluedADExtra e = BDNativeAdAdapter.this.e();
                e.errorMsg = i + " -- " + ((Object) str);
                Log.v("adx", "「百度自渲染」广告「获取失败」 广告位id:" + ((Object) BDNativeAdAdapter.this.e().third_id) + "  " + i + " -- " + ((Object) str));
                aDListener.onADEvent(new ADEvent(101, BDNativeAdAdapter.this));
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeLoad(List<NativeResponse> list) {
                Context context;
                ADListener aDListener2;
                String str;
                int i;
                List<NativeResponse> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    BDNativeAdAdapter.this.e().errorMsg = "自定义异常：广告载入成功但是无数据返回";
                    Log.v("adx", "「百度自渲染」广告「获取失败」 广告位id:" + ((Object) BDNativeAdAdapter.this.e().third_id) + "  自定义异常：广告载入成功但是无数据返回");
                    aDListener.onADEvent(new ADEvent(101, BDNativeAdAdapter.this));
                } else if (!list2.isEmpty()) {
                    NativeResponse nativeResponse = list.get(0);
                    context = BDNativeAdAdapter.this.f10536c;
                    BDNativeAdDataAdapter bDNativeAdDataAdapter = new BDNativeAdDataAdapter(context, nativeResponse, BDNativeAdAdapter.this.e());
                    BDNativeAdAdapter.this.d = bDNativeAdDataAdapter;
                    aDListener2 = BDNativeAdAdapter.this.b;
                    bDNativeAdDataAdapter.a(aDListener2);
                    try {
                        BDNativeAdAdapter bDNativeAdAdapter = BDNativeAdAdapter.this;
                        String eCPMLevel = nativeResponse.getECPMLevel();
                        Intrinsics.c(eCPMLevel, "ad.ecpmLevel");
                        bDNativeAdAdapter.e = Integer.parseInt(eCPMLevel);
                    } catch (Exception e) {
                    }
                    aDListener.onADEvent(new ADEvent(100, BDNativeAdAdapter.this));
                    if (BDNativeAdAdapter.this.e().is_bidding()) {
                        i = BDNativeAdAdapter.this.e;
                        str = Intrinsics.a("价格为：", (Object) Integer.valueOf(i));
                    } else {
                        str = "";
                    }
                    Log.v("adx", "「百度自渲染」广告「获取成功」 广告位id:" + ((Object) BDNativeAdAdapter.this.e().third_id) + ' ' + str);
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNoAd(int i, String str) {
                BluedADExtra e = BDNativeAdAdapter.this.e();
                e.errorMsg = i + " -- " + ((Object) str);
                Log.v("adx", "「百度自渲染」广告「获取失败」 广告位id:" + ((Object) BDNativeAdAdapter.this.e().third_id) + "  " + i + " -- " + ((Object) str));
                aDListener.onADEvent(new ADEvent(101, BDNativeAdAdapter.this));
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadSuccess() {
            }
        });
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public Object a(Continuation<? super ADEvent> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        BuildersKt__Builders_commonKt.a(CoroutineScopeKt.a(), null, null, new BDNativeAdAdapter$loadAD$2$1(this, cancellableContinuationImpl, null), 3, null);
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
        return MapsKt.a(TuplesKt.a("original_ad", this.f10535a));
    }

    public final BluedADExtra e() {
        return this.f10535a;
    }
}
