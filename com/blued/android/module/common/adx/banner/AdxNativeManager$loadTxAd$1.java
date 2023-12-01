package com.blued.android.module.common.adx.banner;

import android.content.Context;
import com.android.internal.R;
import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.BaseNativeExpressAd;
import com.blued.android.module.common.adx.gdt.p002native.TXNativeExpressAdAdapter;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.qq.e.ads.nativ.ADSize;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "AdxNativeManager.kt", c = {R.styleable.Theme_lightZ}, d = "invokeSuspend", e = "com.blued.android.module.common.adx.banner.AdxNativeManager$loadTxAd$1")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/banner/AdxNativeManager$loadTxAd$1.class */
final class AdxNativeManager$loadTxAd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int a;
    final /* synthetic */ AdxNativeManager b;
    final /* synthetic */ BluedADExtra c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdxNativeManager$loadTxAd$1(AdxNativeManager adxNativeManager, BluedADExtra bluedADExtra, Continuation<? super AdxNativeManager$loadTxAd$1> continuation) {
        super(2, continuation);
        this.b = adxNativeManager;
        this.c = bluedADExtra;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdxNativeManager$loadTxAd$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdxNativeManager$loadTxAd$1(this.b, this.c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context context;
        Object a = IntrinsicsKt.a();
        int i = this.a;
        if (i == 0) {
            ResultKt.a(obj);
            context = this.b.g;
            this.a = 1;
            Object a2 = new TXNativeExpressAdAdapter(context, this.c, new ADSize(-1, -2), this.b.d()).a(this);
            obj = a2;
            if (a2 == a) {
                return a;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        ADEvent aDEvent = (ADEvent) obj;
        int type = aDEvent.getType();
        if (type == 100) {
            this.b.a("「广点通服务端bidding」物料获取成功");
            this.c.baseNativeExpressAd = (BaseNativeExpressAd) aDEvent.a(BaseNativeExpressAd.class);
            this.b.d().onADEvent(new ADEvent(100, this.c));
        } else if (type == 101) {
            this.b.a("「广点通服务端bidding」物料获取失败，此时将不会有广告进行展示。");
            this.b.d().onADEvent(new ADEvent(107, new BluedADExtra()));
        }
        this.c.baseNativeExpressAd = (BaseNativeExpressAd) aDEvent.a(BaseNativeExpressAd.class);
        this.b.d().onADEvent(new ADEvent(100, this.c));
        return Unit.a;
    }
}
