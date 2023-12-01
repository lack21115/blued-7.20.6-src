package com.blued.android.module.common.adx.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "AdxBaseManager.kt", c = {1047}, d = "doParallelPriceTask", e = "com.blued.android.module.common.adx.base.AdxBaseManager")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$doParallelPriceTask$1.class */
public final class AdxBaseManager$doParallelPriceTask$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f10501a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AdxBaseManager f10502c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxBaseManager$doParallelPriceTask$1(AdxBaseManager adxBaseManager, Continuation<? super AdxBaseManager$doParallelPriceTask$1> continuation) {
        super(continuation);
        this.f10502c = adxBaseManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d;
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        d = this.f10502c.d(this);
        return d;
    }
}
