package kotlin.coroutines;

import com.alipay.sdk.util.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/SafeContinuation.class */
public final class SafeContinuation<T> implements Continuation<T>, CoroutineStackFrame {
    private static final Companion a = new Companion(null);
    @Deprecated
    private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> c = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, l.c);
    private final Continuation<T> b;
    private volatile Object result;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/SafeContinuation$Companion.class */
    static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SafeContinuation(Continuation<? super T> delegate) {
        this(delegate, CoroutineSingletons.UNDECIDED);
        Intrinsics.e(delegate, "delegate");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeContinuation(Continuation<? super T> delegate, Object obj) {
        Intrinsics.e(delegate, "delegate");
        this.b = delegate;
        this.result = obj;
    }

    public final Object a() {
        Object obj = this.result;
        Object obj2 = obj;
        if (obj == CoroutineSingletons.UNDECIDED) {
            if (c.compareAndSet(this, CoroutineSingletons.UNDECIDED, IntrinsicsKt.a())) {
                return IntrinsicsKt.a();
            }
            obj2 = this.result;
        }
        if (obj2 == CoroutineSingletons.RESUMED) {
            return IntrinsicsKt.a();
        }
        if (obj2 instanceof Result.Failure) {
            throw ((Result.Failure) obj2).a;
        }
        return obj2;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.b;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.b.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            if (obj2 == CoroutineSingletons.UNDECIDED) {
                if (c.compareAndSet(this, CoroutineSingletons.UNDECIDED, obj)) {
                    return;
                }
            } else if (obj2 != IntrinsicsKt.a()) {
                throw new IllegalStateException("Already resumed");
            } else {
                if (c.compareAndSet(this, IntrinsicsKt.a(), CoroutineSingletons.RESUMED)) {
                    this.b.resumeWith(obj);
                    return;
                }
            }
        }
    }

    public String toString() {
        return "SafeContinuation for " + this.b;
    }
}
