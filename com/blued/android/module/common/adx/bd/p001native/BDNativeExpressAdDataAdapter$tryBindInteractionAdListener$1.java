package com.blued.android.module.common.adx.bd.p001native;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.framework.utils.DelayRepeatTaskUtils;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* renamed from: com.blued.android.module.common.adx.bd.native.BDNativeExpressAdDataAdapter$tryBindInteractionAdListener$1  reason: invalid package */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/bd/native/BDNativeExpressAdDataAdapter$tryBindInteractionAdListener$1.class */
public final class BDNativeExpressAdDataAdapter$tryBindInteractionAdListener$1 implements ExpressResponse.ExpressInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BDNativeExpressAdDataAdapter f10534a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDNativeExpressAdDataAdapter$tryBindInteractionAdListener$1(BDNativeExpressAdDataAdapter bDNativeExpressAdDataAdapter) {
        this.f10534a = bDNativeExpressAdDataAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BDNativeExpressAdDataAdapter this$0) {
        ADListener aDListener;
        Intrinsics.e(this$0, "this$0");
        Log.v("adx", "百度SDK信息流 点击回调 会多次触发，用代码限制多次触发时只上报一次埋点");
        aDListener = this$0.f;
        if (aDListener == null) {
            return;
        }
        aDListener.onADEvent(new ADEvent(105, this$0.getAdExtra()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(BDNativeExpressAdDataAdapter this$0) {
        WeakReference weakReference;
        ExpressResponse expressResponse;
        ExpressResponse expressResponse2;
        WeakReference weakReference2;
        ExpressResponse expressResponse3;
        WeakReference weakReference3;
        Intrinsics.e(this$0, "this$0");
        weakReference = this$0.f10531c;
        if (weakReference.get() != 0) {
            weakReference2 = this$0.f10531c;
            if (weakReference2.get() instanceof Activity) {
                expressResponse3 = this$0.d;
                weakReference3 = this$0.f10531c;
                expressResponse3.bindInteractionActivity((Activity) weakReference3.get());
            }
        }
        expressResponse = this$0.d;
        if (expressResponse.getExpressAdView().getParent() == null) {
            expressResponse2 = this$0.d;
            this$0.addView(expressResponse2.getExpressAdView());
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdClick() {
        Log.v("adx", "百度SDK信息流 点击回调 onAdClick");
        final BDNativeExpressAdDataAdapter bDNativeExpressAdDataAdapter = this.f10534a;
        DelayRepeatTaskUtils.a(IAdInterListener.AdCommandType.AD_CLICK, new Runnable() { // from class: com.blued.android.module.common.adx.bd.native.-$$Lambda$BDNativeExpressAdDataAdapter$tryBindInteractionAdListener$1$G2Nkmz3IC7GuXA5Ymy1vk4PC4aU
            @Override // java.lang.Runnable
            public final void run() {
                BDNativeExpressAdDataAdapter$tryBindInteractionAdListener$1.a(BDNativeExpressAdDataAdapter.this);
            }
        }, 500);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdExposed() {
        ADListener aDListener;
        Log.v("adx", "百度SDK信息流 曝光回调");
        aDListener = this.f10534a.f;
        if (aDListener == null) {
            return;
        }
        aDListener.onADEvent(new ADEvent(103, this.f10534a.getAdExtra()));
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdRenderFail(View view, String s, int i) {
        ADListener aDListener;
        Intrinsics.e(view, "view");
        Intrinsics.e(s, "s");
        aDListener = this.f10534a.f;
        if (aDListener == null) {
            return;
        }
        aDListener.onADEvent(new ADEvent(110, this.f10534a.getAdExtra()));
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdRenderSuccess(View view, float f, float f2) {
        ADListener aDListener;
        Intrinsics.e(view, "view");
        aDListener = this.f10534a.f;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(109, this.f10534a.getAdExtra()));
        }
        final BDNativeExpressAdDataAdapter bDNativeExpressAdDataAdapter = this.f10534a;
        bDNativeExpressAdDataAdapter.post(new Runnable() { // from class: com.blued.android.module.common.adx.bd.native.-$$Lambda$BDNativeExpressAdDataAdapter$tryBindInteractionAdListener$1$BWdCZq-FyzvU1fLixnyjRGO4gvI
            @Override // java.lang.Runnable
            public final void run() {
                BDNativeExpressAdDataAdapter$tryBindInteractionAdListener$1.b(BDNativeExpressAdDataAdapter.this);
            }
        });
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdUnionClick() {
        ADListener aDListener;
        Log.v("adx", "百度SDK信息流 点击回调 onAdUnionClick");
        aDListener = this.f10534a.f;
        if (aDListener == null) {
            return;
        }
        aDListener.onADEvent(new ADEvent(105, this.f10534a.getAdExtra()));
    }
}
