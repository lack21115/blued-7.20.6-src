package com.blued.android.module.common.adx.gdt.p002native;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "TXNativeServerAdAdapter.kt", c = {32}, d = "loadExpressAd", e = "com.blued.android.module.common.adx.gdt.native.TXNativeServerAdAdapter")
/* renamed from: com.blued.android.module.common.adx.gdt.native.TXNativeServerAdAdapter$loadExpressAd$1  reason: invalid package */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/gdt/native/TXNativeServerAdAdapter$loadExpressAd$1.class */
public final class TXNativeServerAdAdapter$loadExpressAd$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f10561a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    /* synthetic */ Object f10562c;
    final /* synthetic */ TXNativeServerAdAdapter d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TXNativeServerAdAdapter$loadExpressAd$1(TXNativeServerAdAdapter tXNativeServerAdAdapter, Continuation<? super TXNativeServerAdAdapter$loadExpressAd$1> continuation) {
        super(continuation);
        this.d = tXNativeServerAdAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2;
        this.f10562c = obj;
        this.e |= Integer.MIN_VALUE;
        a2 = this.d.a(null, this);
        return a2;
    }
}
