package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelCoroutine.class */
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {
    private final Channel<E> b;

    public ChannelCoroutine(CoroutineContext coroutineContext, Channel<E> channel, boolean z, boolean z2) {
        super(coroutineContext, z, z2);
        this.b = channel;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object a(E e, Continuation<? super Unit> continuation) {
        return this.b.a(e, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object a(Continuation<? super ChannelResult<? extends E>> continuation) {
        Object a = this.b.a(continuation);
        IntrinsicsKt.a();
        return a;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void a(CancellationException cancellationException) {
        if (h()) {
            return;
        }
        JobCancellationException jobCancellationException = cancellationException;
        if (cancellationException == null) {
            ChannelCoroutine<E> channelCoroutine = this;
            jobCancellationException = new JobCancellationException(channelCoroutine.b(), null, channelCoroutine);
        }
        b((Throwable) jobCancellationException);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void a(Function1<? super Throwable, Unit> function1) {
        this.b.a(function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object a_(E e) {
        return this.b.a_(e);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> av_() {
        return this.b.av_();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object aw_() {
        return this.b.aw_();
    }

    @Override // kotlinx.coroutines.JobSupport
    public void b(Throwable th) {
        CancellationException a = JobSupport.a(this, th, null, 1, null);
        this.b.a(a);
        d((Throwable) a);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean b_(Throwable th) {
        return this.b.b_(th);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> j() {
        return this.b.j();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ChannelResult<E>> k() {
        return this.b.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Channel<E> q() {
        return this.b;
    }

    public final Channel<E> s() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean u() {
        return this.b.u();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> v() {
        return this.b.v();
    }
}
