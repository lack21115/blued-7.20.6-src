package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.ExceptionsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ActorCoroutine.class */
class ActorCoroutine<E> extends ChannelCoroutine<E> implements ActorScope<E> {
    @Override // kotlinx.coroutines.JobSupport
    public void e(Throwable th) {
        Channel<E> q = q();
        CancellationException cancellationException = null;
        CancellationException cancellationException2 = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException2 = (CancellationException) th;
            }
            cancellationException = cancellationException2;
            if (cancellationException2 == null) {
                cancellationException = ExceptionsKt.a(Intrinsics.a(DebugStringsKt.b(this), (Object) " was cancelled"), th);
            }
        }
        q.a(cancellationException);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean f(Throwable th) {
        CoroutineExceptionHandlerKt.a(getContext(), th);
        return true;
    }
}
