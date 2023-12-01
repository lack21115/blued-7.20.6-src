package com.blued.android.module.common.adx.gdt.p002native;

import com.blued.android.module.common.adx.base.ADEvent;
import com.blued.android.module.common.adx.base.ADListener;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "TXNativeServerAdAdapter.kt", c = {61}, d = "invokeSuspend", e = "com.blued.android.module.common.adx.gdt.native.TXNativeServerAdAdapter$loadAD$2$1")
/* renamed from: com.blued.android.module.common.adx.gdt.native.TXNativeServerAdAdapter$loadAD$2$1  reason: invalid package */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/gdt/native/TXNativeServerAdAdapter$loadAD$2$1.class */
final class TXNativeServerAdAdapter$loadAD$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int a;
    final /* synthetic */ TXNativeServerAdAdapter b;
    final /* synthetic */ CancellableContinuation<ADEvent> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TXNativeServerAdAdapter$loadAD$2$1(TXNativeServerAdAdapter tXNativeServerAdAdapter, CancellableContinuation<? super ADEvent> cancellableContinuation, Continuation<? super TXNativeServerAdAdapter$loadAD$2$1> continuation) {
        super(2, continuation);
        this.b = tXNativeServerAdAdapter;
        this.c = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TXNativeServerAdAdapter$loadAD$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TXNativeServerAdAdapter$loadAD$2$1(this.b, this.c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a;
        Object a2 = IntrinsicsKt.a();
        int i = this.a;
        if (i == 0) {
            ResultKt.a(obj);
            TXNativeServerAdAdapter tXNativeServerAdAdapter = this.b;
            final CancellableContinuation<ADEvent> cancellableContinuation = this.c;
            this.a = 1;
            a = tXNativeServerAdAdapter.a(new ADListener() { // from class: com.blued.android.module.common.adx.gdt.native.TXNativeServerAdAdapter$loadAD$2$1.1
                @Override // com.blued.android.module.common.adx.base.ADListener
                public void onADEvent(ADEvent aDEvent) {
                    if (aDEvent == null) {
                        return;
                    }
                    CancellableContinuation<ADEvent> cancellableContinuation2 = cancellableContinuation;
                    if (cancellableContinuation2.a()) {
                        cancellableContinuation2.a((CancellableContinuation<ADEvent>) aDEvent, (Function1<? super Throwable, Unit>) new Function1<Throwable, Unit>() { // from class: com.blued.android.module.common.adx.gdt.native.TXNativeServerAdAdapter$loadAD$2$1$1$onADEvent$1$1
                            public final void a(Throwable it) {
                                Intrinsics.e(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* synthetic */ Unit invoke(Throwable th) {
                                a(th);
                                return Unit.a;
                            }
                        });
                    }
                }
            }, this);
            if (a == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        return Unit.a;
    }
}
