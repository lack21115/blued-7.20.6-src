package com.blued.android.module.common.adx.ks.unified;

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
@DebugMetadata(b = "KSNativeAdAdapter.kt", c = {}, d = "invokeSuspend", e = "com.blued.android.module.common.adx.ks.unified.KSNativeAdAdapter$loadAD$2$1")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/ks/unified/KSNativeAdAdapter$loadAD$2$1.class */
final class KSNativeAdAdapter$loadAD$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f10585a;
    final /* synthetic */ KSNativeAdAdapter b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ CancellableContinuation<ADEvent> f10586c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public KSNativeAdAdapter$loadAD$2$1(KSNativeAdAdapter kSNativeAdAdapter, CancellableContinuation<? super ADEvent> cancellableContinuation, Continuation<? super KSNativeAdAdapter$loadAD$2$1> continuation) {
        super(2, continuation);
        this.b = kSNativeAdAdapter;
        this.f10586c = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KSNativeAdAdapter$loadAD$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KSNativeAdAdapter$loadAD$2$1(this.b, this.f10586c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f10585a == 0) {
            ResultKt.a(obj);
            KSNativeAdAdapter kSNativeAdAdapter = this.b;
            final CancellableContinuation<ADEvent> cancellableContinuation = this.f10586c;
            kSNativeAdAdapter.a(new ADListener() { // from class: com.blued.android.module.common.adx.ks.unified.KSNativeAdAdapter$loadAD$2$1.1
                @Override // com.blued.android.module.common.adx.base.ADListener
                public void onADEvent(ADEvent aDEvent) {
                    if (aDEvent == null) {
                        return;
                    }
                    CancellableContinuation<ADEvent> cancellableContinuation2 = cancellableContinuation;
                    if (cancellableContinuation2.a()) {
                        cancellableContinuation2.a((CancellableContinuation<ADEvent>) aDEvent, (Function1<? super Throwable, Unit>) new Function1<Throwable, Unit>() { // from class: com.blued.android.module.common.adx.ks.unified.KSNativeAdAdapter$loadAD$2$1$1$onADEvent$1$1
                            public final void a(Throwable it) {
                                Intrinsics.e(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* synthetic */ Unit invoke(Throwable th) {
                                a(th);
                                return Unit.f42314a;
                            }
                        });
                    }
                }
            });
            return Unit.f42314a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
