package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/activity/contextaware/ContextAwareKt.class */
public final class ContextAwareKt {
    /* JADX WARN: Type inference failed for: r0v7, types: [androidx.activity.contextaware.ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1] */
    public static final <R> Object withContextAvailable(final ContextAware contextAware, final Function1<? super Context, ? extends R> function1, Continuation<? super R> continuation) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return function1.invoke(peekAvailableContext);
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final ?? r0 = new OnContextAvailableListener() { // from class: androidx.activity.contextaware.ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1
            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public void onContextAvailable(Context context) {
                Object f;
                Intrinsics.e(context, "context");
                CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                try {
                    Result.Companion companion = Result.f42293a;
                    ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 = this;
                    f = Result.f(function1.invoke(context));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.f42293a;
                    f = Result.f(ResultKt.a(th));
                }
                cancellableContinuation.resumeWith(f);
            }
        };
        contextAware.addOnContextAvailableListener((OnContextAvailableListener) r0);
        cancellableContinuationImpl2.a((Function1<? super Throwable, Unit>) new Function1<Throwable, Unit>() { // from class: androidx.activity.contextaware.ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f42314a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                contextAware.removeOnContextAvailableListener(ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1.this);
            }
        });
        Object h = cancellableContinuationImpl.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h;
    }
}
