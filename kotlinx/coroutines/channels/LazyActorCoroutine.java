package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/LazyActorCoroutine.class */
final class LazyActorCoroutine<E> extends ActorCoroutine<E> implements SelectClause2<E, SendChannel<? super E>> {
    private Continuation<? super Unit> b;

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public Object a(E e, Continuation<? super Unit> continuation) {
        ay_();
        Object a = super.a((LazyActorCoroutine<E>) e, continuation);
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectClause2
    public <R> void a(SelectInstance<? super R> selectInstance, E e, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        ay_();
        super.v().a(selectInstance, e, function2);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public Object a_(E e) {
        ay_();
        return super.a_((LazyActorCoroutine<E>) e);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public boolean b_(Throwable th) {
        boolean b_ = super.b_(th);
        ay_();
        return b_;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void m() {
        CancellableKt.a(this.b, this);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> v() {
        return this;
    }
}
