package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/BroadcastCoroutine.class */
class BroadcastCoroutine<E> extends AbstractCoroutine<Unit> implements BroadcastChannel<E>, ProducerScope<E> {
    private final BroadcastChannel<E> b;

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object a(E e, Continuation<? super Unit> continuation) {
        return this.b.a(e, continuation);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void a(Throwable th, boolean z) {
        if (this.b.b_(th) || z) {
            return;
        }
        CoroutineExceptionHandlerKt.a(getContext(), th);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void a(CancellationException cancellationException) {
        JobCancellationException jobCancellationException = cancellationException;
        if (cancellationException == null) {
            BroadcastCoroutine<E> broadcastCoroutine = this;
            jobCancellationException = new JobCancellationException(broadcastCoroutine.b(), null, broadcastCoroutine);
        }
        b((Throwable) jobCancellationException);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractCoroutine
    public void a(Unit unit) {
        SendChannel.DefaultImpls.a(this.b, null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void a(Function1<? super Throwable, Unit> function1) {
        this.b.a(function1);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean a() {
        return super.a();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object a_(E e) {
        return this.b.a_(e);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> az_() {
        return this.b.az_();
    }

    @Override // kotlinx.coroutines.JobSupport
    public void b(Throwable th) {
        CancellationException a = JobSupport.a(this, th, null, 1, null);
        this.b.a(a);
        d((Throwable) a);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean b_(Throwable th) {
        boolean b_ = this.b.b_(th);
        ay_();
        return b_;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BroadcastChannel<E> q() {
        return this.b;
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public SendChannel<E> r() {
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
