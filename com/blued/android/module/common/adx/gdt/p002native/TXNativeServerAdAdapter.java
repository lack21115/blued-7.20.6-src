package com.blued.android.module.common.adx.gdt.p002native;

import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.BaseNativeExpressAd;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.qq.e.ads.nativ.NativeExpressADView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
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
/* renamed from: com.blued.android.module.common.adx.gdt.native.TXNativeServerAdAdapter  reason: invalid package */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/gdt/native/TXNativeServerAdAdapter.class */
public final class TXNativeServerAdAdapter extends BaseNativeExpressAd {

    /* renamed from: a  reason: collision with root package name */
    private BluedADExtra f10556a;
    private int b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.blued.android.module.common.adx.base.ADListener r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.gdt.p002native.TXNativeServerAdAdapter.a(com.blued.android.module.common.adx.base.ADListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.blued.android.module.common.adx.base.BaseNativeExpressAd
    public NativeExpressADView a() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public Object a(Continuation<? super ADEvent> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        BuildersKt__Builders_commonKt.a(CoroutineScopeKt.a(), null, null, new TXNativeServerAdAdapter$loadAD$2$1(this, cancellableContinuationImpl, null), 3, null);
        Object h = cancellableContinuationImpl.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h;
    }

    @Override // com.blued.android.module.common.adx.base.BaseNativeExpressAd
    public void a(Map<String, ? extends Object> map) {
        Intrinsics.e(map, "map");
        Object obj = map.get("win_data");
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.login.model.BluedADExtra");
        }
        BluedADExtra bluedADExtra = (BluedADExtra) obj;
        Object obj2 = map.get("loss_data");
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.login.model.BluedADExtra");
        }
        BluedADExtra bluedADExtra2 = (BluedADExtra) obj2;
    }

    @Override // com.blued.android.module.common.adx.base.BaseNativeExpressAd
    public void b(Map<String, ? extends Object> map) {
        Intrinsics.e(map, "map");
        Object obj = map.get("win_data");
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.login.model.BluedADExtra");
        }
        BluedADExtra bluedADExtra = (BluedADExtra) obj;
        Object obj2 = map.get("loss_data");
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.login.model.BluedADExtra");
        }
        BluedADExtra bluedADExtra2 = (BluedADExtra) obj2;
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public int c() {
        return this.b;
    }

    @Override // com.blued.android.module.common.adx.base.IBaseAd
    public Map<String, Object> d() {
        return MapsKt.a(TuplesKt.a("original_ad", this.f10556a));
    }

    public final BluedADExtra e() {
        return this.f10556a;
    }
}
