package com.blued.android.module.common.adx.gdt.p002native;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.adx.base.BaseNativeExpressAd;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
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
/* renamed from: com.blued.android.module.common.adx.gdt.native.TXNativeExpressAdAdapter  reason: invalid package */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/gdt/native/TXNativeExpressAdAdapter.class */
public final class TXNativeExpressAdAdapter extends BaseNativeExpressAd {
    private BluedADExtra a;
    private ADSize b;
    private ADListener c;
    private final Context d;
    private int e;
    private NativeExpressADView f;
    private NativeExpressAD g;

    public TXNativeExpressAdAdapter(Context context, BluedADExtra adExtra, ADSize adSize, ADListener listener) {
        Intrinsics.e(context, "context");
        Intrinsics.e(adExtra, "adExtra");
        Intrinsics.e(adSize, "adSize");
        Intrinsics.e(listener, "listener");
        this.a = adExtra;
        this.b = adSize;
        this.c = listener;
        this.d = context;
        this.e = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ADListener aDListener) {
        NativeExpressAD nativeExpressAD;
        if (this.a.gdt_bid == null || TextUtils.isEmpty(this.a.gdt_bid.gdt_token)) {
            nativeExpressAD = new NativeExpressAD(this.d, this.b, this.a.third_id, b(aDListener));
        } else {
            Log.v("adx", Intrinsics.a("「广点通信息流」广告 本次请求为服务端bidding，token:", (Object) this.a.gdt_bid.gdt_token));
            nativeExpressAD = new NativeExpressAD(this.d, this.b, this.a.third_id, b(aDListener), this.a.gdt_bid.gdt_token);
        }
        this.g = nativeExpressAD;
        VideoOption build = new VideoOption.Builder().setAutoPlayMuted(true).build();
        NativeExpressAD nativeExpressAD2 = this.g;
        if (nativeExpressAD2 != null) {
            nativeExpressAD2.setVideoOption(build);
        }
        NativeExpressAD nativeExpressAD3 = this.g;
        if (nativeExpressAD3 == null) {
            return;
        }
        nativeExpressAD3.loadAD(1);
    }

    private final NativeExpressAD.NativeExpressADListener b(final ADListener aDListener) {
        return new NativeExpressAD.NativeExpressADListener() { // from class: com.blued.android.module.common.adx.gdt.native.TXNativeExpressAdAdapter$getNativeExpressADListener$1
            public void onADClicked(NativeExpressADView nativeExpressADView) {
                ADListener aDListener2;
                Log.v("adx", "广点通SDK信息流 点击回调");
                aDListener2 = TXNativeExpressAdAdapter.this.c;
                if (aDListener2 == null) {
                    return;
                }
                aDListener2.onADEvent(new ADEvent(105, TXNativeExpressAdAdapter.this.e()));
            }

            public void onADClosed(NativeExpressADView nativeExpressADView) {
                ADListener aDListener2;
                Log.v("adx", "广点通SDK信息流 关闭回调");
                aDListener2 = TXNativeExpressAdAdapter.this.c;
                if (aDListener2 == null) {
                    return;
                }
                aDListener2.onADEvent(new ADEvent(106, TXNativeExpressAdAdapter.this.e()));
            }

            public void onADExposure(NativeExpressADView nativeExpressADView) {
                ADListener aDListener2;
                Log.v("adx", "广点通SDK信息流 曝光回调");
                aDListener2 = TXNativeExpressAdAdapter.this.c;
                if (aDListener2 == null) {
                    return;
                }
                aDListener2.onADEvent(new ADEvent(103, TXNativeExpressAdAdapter.this.e()));
            }

            public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            }

            public void onADLoaded(List<NativeExpressADView> list) {
                String str;
                int i;
                List<NativeExpressADView> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    Log.v("adx", Intrinsics.a("「广点通信息流」广告「获取失败」 广告位id:", (Object) TXNativeExpressAdAdapter.this.e().third_id));
                    aDListener.onADEvent(new ADEvent(101, TXNativeExpressAdAdapter.this));
                    return;
                }
                NativeExpressADView nativeExpressADView = list.get(0);
                TXNativeExpressAdAdapter.this.f = nativeExpressADView;
                TXNativeExpressAdAdapter tXNativeExpressAdAdapter = TXNativeExpressAdAdapter.this;
                tXNativeExpressAdAdapter.e = tXNativeExpressAdAdapter.e().isServerBidding() ? (int) TXNativeExpressAdAdapter.this.e().price : nativeExpressADView.getBoundData().getECPM();
                aDListener.onADEvent(new ADEvent(100, TXNativeExpressAdAdapter.this));
                if (TXNativeExpressAdAdapter.this.e().is_bidding()) {
                    i = TXNativeExpressAdAdapter.this.e;
                    str = Intrinsics.a("价格为：", (Object) Integer.valueOf(i));
                } else {
                    str = "";
                }
                Log.v("adx", "「广点通信息流」广告「获取成功」 广告位id:" + ((Object) TXNativeExpressAdAdapter.this.e().third_id) + ' ' + str);
            }

            public void onNoAD(AdError adError) {
                BluedADExtra e = TXNativeExpressAdAdapter.this.e();
                StringBuilder sb = new StringBuilder();
                sb.append(adError == null ? null : Integer.valueOf(adError.getErrorCode()));
                sb.append(" -- ");
                sb.append((Object) (adError == null ? null : adError.getErrorMsg()));
                e.errorMsg = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("「广点通信息流」广告「获取失败」 广告位id:");
                sb2.append((Object) TXNativeExpressAdAdapter.this.e().third_id);
                sb2.append(' ');
                sb2.append(adError == null ? null : Integer.valueOf(adError.getErrorCode()));
                sb2.append(" -- ");
                sb2.append((Object) (adError == null ? null : adError.getErrorMsg()));
                Log.v("adx", sb2.toString());
                aDListener.onADEvent(new ADEvent(101, TXNativeExpressAdAdapter.this));
            }

            public void onRenderFail(NativeExpressADView nativeExpressADView) {
                ADListener aDListener2;
                aDListener2 = TXNativeExpressAdAdapter.this.c;
                if (aDListener2 == null) {
                    return;
                }
                aDListener2.onADEvent(new ADEvent(110, TXNativeExpressAdAdapter.this.e()));
            }

            public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
                ADListener aDListener2;
                aDListener2 = TXNativeExpressAdAdapter.this.c;
                if (aDListener2 == null) {
                    return;
                }
                aDListener2.onADEvent(new ADEvent(109, TXNativeExpressAdAdapter.this.e()));
            }
        };
    }

    @Override // com.blued.android.module.common.adx.base.BaseNativeExpressAd
    public NativeExpressADView a() {
        return this.f;
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public Object a(Continuation<? super ADEvent> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        BuildersKt__Builders_commonKt.a(CoroutineScopeKt.a(), null, null, new TXNativeExpressAdAdapter$loadAD$2$1(this, cancellableContinuationImpl, null), 3, null);
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
