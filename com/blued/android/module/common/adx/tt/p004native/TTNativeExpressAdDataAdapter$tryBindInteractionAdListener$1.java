package com.blued.android.module.common.adx.tt.p004native;

import android.util.Log;
import android.view.View;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* renamed from: com.blued.android.module.common.adx.tt.native.TTNativeExpressAdDataAdapter$tryBindInteractionAdListener$1  reason: invalid package */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/tt/native/TTNativeExpressAdDataAdapter$tryBindInteractionAdListener$1.class */
public final class TTNativeExpressAdDataAdapter$tryBindInteractionAdListener$1 implements TTNativeExpressAd.AdInteractionListener {
    final /* synthetic */ TTNativeExpressAdDataAdapter a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TTNativeExpressAdDataAdapter$tryBindInteractionAdListener$1(TTNativeExpressAdDataAdapter tTNativeExpressAdDataAdapter) {
        this.a = tTNativeExpressAdDataAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TTNativeExpressAdDataAdapter this$0) {
        TTNativeExpressAd tTNativeExpressAd;
        Intrinsics.e(this$0, "this$0");
        tTNativeExpressAd = this$0.b;
        this$0.addView(tTNativeExpressAd.getExpressAdView());
    }

    public void onAdClicked(View view, int i) {
        ADListener aDListener;
        Log.v("adx", "穿山甲SDK信息流 点击回调 onAdClick");
        aDListener = this.a.d;
        if (aDListener == null) {
            return;
        }
        aDListener.onADEvent(new ADEvent(105, this.a.getAdExtra()));
    }

    public void onAdDismiss() {
    }

    public void onAdShow(View view, int i) {
        ADListener aDListener;
        Log.v("adx", "穿山甲SDK信息流 曝光回调 onAdShow");
        if (this.a.getAdExtra().ttAdxShowSet.contains(this.a.getAdExtra().ads_id_sub)) {
            return;
        }
        this.a.getAdExtra().ttAdxShowSet.add(this.a.getAdExtra().ads_id_sub);
        aDListener = this.a.d;
        if (aDListener == null) {
            return;
        }
        aDListener.onADEvent(new ADEvent(103, this.a.getAdExtra()));
    }

    public void onRenderFail(View view, String str, int i) {
        ADListener aDListener;
        Log.v("adx", "穿山甲SDK信息流 曝光回调 onAdShow");
        aDListener = this.a.d;
        if (aDListener == null) {
            return;
        }
        aDListener.onADEvent(new ADEvent(110, this.a.getAdExtra()));
    }

    public void onRenderSuccess(View view, float f, float f2) {
        ADListener aDListener;
        aDListener = this.a.d;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(109, this.a.getAdExtra()));
        }
        final TTNativeExpressAdDataAdapter tTNativeExpressAdDataAdapter = this.a;
        tTNativeExpressAdDataAdapter.post(new Runnable() { // from class: com.blued.android.module.common.adx.tt.native.-$$Lambda$TTNativeExpressAdDataAdapter$tryBindInteractionAdListener$1$Wh7Rzq5dJT7a2KcmrbsiRCdCUUU
            @Override // java.lang.Runnable
            public final void run() {
                TTNativeExpressAdDataAdapter$tryBindInteractionAdListener$1.a(TTNativeExpressAdDataAdapter.this);
            }
        });
    }
}
