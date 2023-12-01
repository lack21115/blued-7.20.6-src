package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.intrinsics.CancellableKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/LazyBroadcastCoroutine.class */
final class LazyBroadcastCoroutine<E> extends BroadcastCoroutine<E> {
    private final Continuation<Unit> b;

    @Override // kotlinx.coroutines.channels.BroadcastCoroutine, kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> az_() {
        ReceiveChannel<E> az_ = q().az_();
        ay_();
        return az_;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void m() {
        CancellableKt.a(this.b, this);
    }
}
