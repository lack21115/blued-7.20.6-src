package com.blued.android.module.common.adx.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "AdxBaseManager.kt", c = {759, 1407}, d = "onlyRunBidding", e = "com.blued.android.module.common.adx.base.AdxBaseManager")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$onlyRunBidding$1.class */
public final class AdxBaseManager$onlyRunBidding$1 extends ContinuationImpl {
    Object a;
    /* synthetic */ Object b;
    final /* synthetic */ AdxBaseManager c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxBaseManager$onlyRunBidding$1(AdxBaseManager adxBaseManager, Continuation<? super AdxBaseManager$onlyRunBidding$1> continuation) {
        super(continuation);
        this.c = adxBaseManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c;
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        c = this.c.c(this);
        return c;
    }
}
