package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt.class */
public class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> a(Continuation<? super T> continuation) {
        Intrinsics.e(continuation, "<this>");
        ContinuationImpl continuationImpl = continuation instanceof ContinuationImpl ? (ContinuationImpl) continuation : null;
        Continuation<T> continuation2 = continuation;
        if (continuationImpl != null) {
            continuation2 = continuationImpl.intercepted();
            if (continuation2 == null) {
                return continuation;
            }
        }
        return continuation2;
    }

    public static final <T> Continuation<Unit> a(final Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> completion) {
        Intrinsics.e(function1, "<this>");
        Intrinsics.e(completion, "completion");
        final Continuation<?> a = DebugProbesKt.a(completion);
        if (function1 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function1).create(a);
        }
        final CoroutineContext context = a.getContext();
        return context == EmptyCoroutineContext.a ? new RestrictedContinuationImpl(a) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
            private int b;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object obj) {
                int i = this.b;
                if (i == 0) {
                    this.b = 1;
                    ResultKt.a(obj);
                    return ((Function1) TypeIntrinsics.b(function1, 1)).invoke(this);
                } else if (i == 1) {
                    this.b = 2;
                    ResultKt.a(obj);
                    return obj;
                } else {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
            }
        } : new ContinuationImpl(a, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
            private int b;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object obj) {
                int i = this.b;
                if (i == 0) {
                    this.b = 1;
                    ResultKt.a(obj);
                    return ((Function1) TypeIntrinsics.b(function1, 1)).invoke(this);
                } else if (i == 1) {
                    this.b = 2;
                    ResultKt.a(obj);
                    return obj;
                } else {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
            }
        };
    }

    public static final <R, T> Continuation<Unit> a(final Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, final R r, Continuation<? super T> completion) {
        Intrinsics.e(function2, "<this>");
        Intrinsics.e(completion, "completion");
        final Continuation<?> a = DebugProbesKt.a(completion);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(r, a);
        }
        final CoroutineContext context = a.getContext();
        return context == EmptyCoroutineContext.a ? new RestrictedContinuationImpl(a) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
            private int c;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object obj) {
                int i = this.c;
                if (i != 0) {
                    if (i == 1) {
                        this.c = 2;
                        ResultKt.a(obj);
                        return obj;
                    }
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.c = 1;
                ResultKt.a(obj);
                return ((Function2) TypeIntrinsics.b(function2, 2)).invoke(r, this);
            }
        } : new ContinuationImpl(a, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            private int c;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object obj) {
                int i = this.c;
                if (i != 0) {
                    if (i == 1) {
                        this.c = 2;
                        ResultKt.a(obj);
                        return obj;
                    }
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.c = 1;
                ResultKt.a(obj);
                return ((Function2) TypeIntrinsics.b(function2, 2)).invoke(r, this);
            }
        };
    }
}
