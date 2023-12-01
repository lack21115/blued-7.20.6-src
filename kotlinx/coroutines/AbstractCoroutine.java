package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/AbstractCoroutine.class */
public abstract class AbstractCoroutine<T> extends JobSupport implements Continuation<T>, CoroutineScope, Job {
    private final CoroutineContext b;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z, boolean z2) {
        super(z2);
        if (z) {
            a((Job) coroutineContext.get(Job.C_));
        }
        this.b = coroutineContext.plus(this);
    }

    protected void a(T t) {
    }

    protected void a(Throwable th, boolean z) {
    }

    public final <R> void a(CoroutineStart coroutineStart, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        coroutineStart.a(function2, r, this);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean a() {
        return super.a();
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void a_(Throwable th) {
        CoroutineExceptionHandlerKt.a(this.b, th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public String b() {
        return Intrinsics.a(DebugStringsKt.b(this), (Object) " was cancelled");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    protected final void b(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            a((AbstractCoroutine<T>) obj);
            return;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
        a(completedExceptionally.a, completedExceptionally.b());
    }

    @Override // kotlinx.coroutines.JobSupport
    public String c() {
        String a = CoroutineContextKt.a(this.b);
        if (a == null) {
            return super.c();
        }
        return '\"' + a + "\":" + super.c();
    }

    protected void c(Object obj) {
        d(obj);
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.b;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.b;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object g = g(CompletionStateKt.a(obj, null, 1, null));
        if (g == JobSupportKt.a) {
            return;
        }
        c(g);
    }
}
