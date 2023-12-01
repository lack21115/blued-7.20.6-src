package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProducerCoroutine;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/FlowProduceCoroutine.class */
public final class FlowProduceCoroutine<T> extends ProducerCoroutine<T> {
    public FlowProduceCoroutine(CoroutineContext coroutineContext, Channel<T> channel) {
        super(coroutineContext, channel);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean c(Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return e((Object) th);
    }
}
