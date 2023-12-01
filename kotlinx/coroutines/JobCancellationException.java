package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/JobCancellationException.class */
public final class JobCancellationException extends CancellationException implements CopyableThrowable<JobCancellationException> {

    /* renamed from: a  reason: collision with root package name */
    public final Job f42836a;

    public JobCancellationException(String str, Throwable th, Job job) {
        super(str);
        this.f42836a = job;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    /* renamed from: b */
    public JobCancellationException a() {
        if (DebugKt.b()) {
            String message = getMessage();
            Intrinsics.a((Object) message);
            return new JobCancellationException(message, this, this.f42836a);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                return Intrinsics.a((Object) jobCancellationException.getMessage(), (Object) getMessage()) && Intrinsics.a(jobCancellationException.f42836a, this.f42836a) && Intrinsics.a(jobCancellationException.getCause(), getCause());
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (DebugKt.b()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        Intrinsics.a((Object) message);
        int hashCode = message.hashCode();
        int hashCode2 = this.f42836a.hashCode();
        Throwable cause = getCause();
        return (((hashCode * 31) + hashCode2) * 31) + (cause == null ? 0 : cause.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f42836a;
    }
}
