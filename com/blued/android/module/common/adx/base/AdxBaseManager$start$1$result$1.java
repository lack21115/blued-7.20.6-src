package com.blued.android.module.common.adx.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "AdxBaseManager.kt", c = {105, 110, 124, 127}, d = "invokeSuspend", e = "com.blued.android.module.common.adx.base.AdxBaseManager$start$1$result$1")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$start$1$result$1.class */
final class AdxBaseManager$start$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int a;
    final /* synthetic */ AdxBaseManager b;
    private /* synthetic */ Object c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxBaseManager$start$1$result$1(AdxBaseManager adxBaseManager, Continuation<? super AdxBaseManager$start$1$result$1> continuation) {
        super(2, continuation);
        this.b = adxBaseManager;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdxBaseManager$start$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AdxBaseManager$start$1$result$1 adxBaseManager$start$1$result$1 = new AdxBaseManager$start$1$result$1(this.b, continuation);
        adxBaseManager$start$1$result$1.c = obj;
        return adxBaseManager$start$1$result$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0123  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.base.AdxBaseManager$start$1$result$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
