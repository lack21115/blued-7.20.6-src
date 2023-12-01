package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/TimeoutCancellationException.class */
public final class TimeoutCancellationException extends CancellationException implements CopyableThrowable<TimeoutCancellationException> {
    public final Job a;

    public TimeoutCancellationException(String str, Job job) {
        super(str);
        this.a = job;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    /* renamed from: b */
    public TimeoutCancellationException a() {
        String message = getMessage();
        String str = message;
        if (message == null) {
            str = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(str, this.a);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }
}
