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

    /* renamed from: a  reason: collision with root package name */
    Object f10507a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AdxBaseManager f10508c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxBaseManager$onlyRunBidding$1(AdxBaseManager adxBaseManager, Continuation<? super AdxBaseManager$onlyRunBidding$1> continuation) {
        super(continuation);
        this.f10508c = adxBaseManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c2;
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        c2 = this.f10508c.c(this);
        return c2;
    }
}
