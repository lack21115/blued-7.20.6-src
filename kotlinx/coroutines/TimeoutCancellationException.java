package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/TimeoutCancellationException.class */
public final class TimeoutCancellationException extends CancellationException implements CopyableThrowable<TimeoutCancellationException> {

    /* renamed from: a  reason: collision with root package name */
    public final Job f42858a;

    public TimeoutCancellationException(String str, Job job) {
        super(str);
        this.f42858a = job;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    /* renamed from: b */
    public TimeoutCancellationException a() {
        String message = getMessage();
        String str = message;
        if (message == null) {
            str = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(str, this.f42858a);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }
}
