package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/SafeCollector.class */
public final class SafeCollector<T> extends ContinuationImpl implements CoroutineStackFrame, FlowCollector<T> {
    public final FlowCollector<T> a;
    public final CoroutineContext b;
    public final int c;
    private CoroutineContext d;
    private Continuation<? super Unit> e;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        super(NoOpContinuation.a, EmptyCoroutineContext.a);
        this.a = flowCollector;
        this.b = coroutineContext;
        this.c = ((Number) coroutineContext.fold(0, new Function2<Integer, CoroutineContext.Element, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector$collectContextSize$1
            public final int a(int i, CoroutineContext.Element element) {
                return i + 1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Integer invoke(Integer num, CoroutineContext.Element element) {
                return Integer.valueOf(a(num.intValue(), element));
            }
        })).intValue();
    }

    private final Object a(Continuation<? super Unit> continuation, T t) {
        CoroutineContext context = continuation.getContext();
        JobKt.a(context);
        CoroutineContext coroutineContext = this.d;
        if (coroutineContext != context) {
            a(context, coroutineContext, t);
        }
        this.e = continuation;
        return SafeCollectorKt.a().a(this.a, t, this);
    }

    private final void a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t) {
        if (coroutineContext2 instanceof DownstreamExceptionElement) {
            a((DownstreamExceptionElement) coroutineContext2, t);
        }
        SafeCollector_commonKt.a((SafeCollector<?>) this, coroutineContext);
        this.d = coroutineContext;
    }

    private final void a(DownstreamExceptionElement downstreamExceptionElement, Object obj) {
        throw new IllegalStateException(StringsKt.a("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + downstreamExceptionElement.b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        try {
            Object a = a(continuation, (Continuation<? super Unit>) t);
            if (a == IntrinsicsKt.a()) {
                DebugProbesKt.c(continuation);
            }
            return a == IntrinsicsKt.a() ? a : Unit.a;
        } catch (Throwable th) {
            this.d = new DownstreamExceptionElement(th);
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<? super Unit> continuation = this.e;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        Continuation<? super Unit> continuation = this.e;
        CoroutineContext context = continuation == null ? null : continuation.getContext();
        EmptyCoroutineContext emptyCoroutineContext = context;
        if (context == null) {
            emptyCoroutineContext = EmptyCoroutineContext.a;
        }
        return emptyCoroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object obj) {
        Throwable c = Result.c(obj);
        if (c != null) {
            this.d = new DownstreamExceptionElement(c);
        }
        Continuation<? super Unit> continuation = this.e;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return IntrinsicsKt.a();
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
