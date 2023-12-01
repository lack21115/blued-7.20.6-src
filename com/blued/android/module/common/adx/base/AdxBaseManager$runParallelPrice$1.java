package com.blued.android.module.common.adx.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "AdxBaseManager.kt", c = {245, 246, 348, 412}, d = "runParallelPrice", e = "com.blued.android.module.common.adx.base.AdxBaseManager")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$runParallelPrice$1.class */
public final class AdxBaseManager$runParallelPrice$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f10513a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    /* synthetic */ Object f10514c;
    final /* synthetic */ AdxBaseManager d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxBaseManager$runParallelPrice$1(AdxBaseManager adxBaseManager, Continuation<? super AdxBaseManager$runParallelPrice$1> continuation) {
        super(continuation);
        this.d = adxBaseManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2;
        this.f10514c = obj;
        this.e |= Integer.MIN_VALUE;
        a2 = this.d.a((CoroutineScope) null, this);
        return a2;
    }
}
