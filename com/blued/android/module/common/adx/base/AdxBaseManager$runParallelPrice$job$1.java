package com.blued.android.module.common.adx.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "AdxBaseManager.kt", c = {217, 1416}, d = "invokeSuspend", e = "com.blued.android.module.common.adx.base.AdxBaseManager$runParallelPrice$job$1")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$runParallelPrice$job$1.class */
public final class AdxBaseManager$runParallelPrice$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    Object f10518a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AdxBaseManager f10519c;
    final /* synthetic */ CoroutineScope d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxBaseManager$runParallelPrice$job$1(AdxBaseManager adxBaseManager, CoroutineScope coroutineScope, Continuation<? super AdxBaseManager$runParallelPrice$job$1> continuation) {
        super(2, continuation);
        this.f10519c = adxBaseManager;
        this.d = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdxBaseManager$runParallelPrice$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdxBaseManager$runParallelPrice$job$1(this.f10519c, this.d, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0209  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.base.AdxBaseManager$runParallelPrice$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
