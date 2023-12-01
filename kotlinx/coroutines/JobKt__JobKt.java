package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/JobKt__JobKt.class */
public final /* synthetic */ class JobKt__JobKt {
    public static final CompletableJob a(Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob a(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return JobKt.a(job);
    }

    public static final DisposableHandle a(Job job, DisposableHandle disposableHandle) {
        return job.a_(new DisposeOnCompletion(disposableHandle));
    }

    public static final void a(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.C_);
        if (job == null) {
            return;
        }
        JobKt.b(job);
    }

    public static final void a(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.C_);
        if (job == null) {
            return;
        }
        job.a(cancellationException);
    }

    public static /* synthetic */ void a(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.a(coroutineContext, cancellationException);
    }

    public static final Job b(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.C_);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(Intrinsics.a("Current context doesn't contain Job in it: ", (Object) coroutineContext).toString());
    }

    public static final void b(Job job) {
        if (!job.a()) {
            throw job.i();
        }
    }
}
