package com.blued.android.module.common.adx.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "AdxBaseManager.kt", c = {455, 1410, 547, 1435, 638}, d = "runParallel", e = "com.blued.android.module.common.adx.base.AdxBaseManager")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$runParallel$1.class */
public final class AdxBaseManager$runParallel$1 extends ContinuationImpl {
    Object a;
    Object b;
    /* synthetic */ Object c;
    final /* synthetic */ AdxBaseManager d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxBaseManager$runParallel$1(AdxBaseManager adxBaseManager, Continuation<? super AdxBaseManager$runParallel$1> continuation) {
        super(continuation);
        this.d = adxBaseManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a;
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        a = this.d.a(this);
        return a;
    }
}
