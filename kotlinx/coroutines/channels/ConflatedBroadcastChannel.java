package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ConflatedBroadcastChannel.class */
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater b;

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f42991c;
    private static final /* synthetic */ AtomicReferenceFieldUpdater d;
    @Deprecated
    private static final Symbol f;
    @Deprecated
    private static final State<Object> g;
    private volatile /* synthetic */ Object _state = g;
    private volatile /* synthetic */ int _updating = 0;
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* renamed from: a  reason: collision with root package name */
    private static final Companion f42990a = new Companion(null);
    @Deprecated
    private static final Closed e = new Closed(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed.class */
    public static final class Closed {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f42992a;

        public Closed(Throwable th) {
            this.f42992a = th;
        }

        public final Throwable a() {
            Throwable th = this.f42992a;
            ClosedSendChannelException closedSendChannelException = th;
            if (th == null) {
                closedSendChannelException = new ClosedSendChannelException("Channel was closed");
            }
            return closedSendChannelException;
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ConflatedBroadcastChannel$Companion.class */
    static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ConflatedBroadcastChannel$State.class */
    public static final class State<E> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f42993a;
        public final Subscriber<E>[] b;

        public State(Object obj, Subscriber<E>[] subscriberArr) {
            this.f42993a = obj;
            this.b = subscriberArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber.class */
    public static final class Subscriber<E> extends ConflatedChannel<E> implements ReceiveChannel<E> {
        private final ConflatedBroadcastChannel<E> b;

        public Subscriber(ConflatedBroadcastChannel<E> conflatedBroadcastChannel) {
            super(null);
            this.b = conflatedBroadcastChannel;
        }

        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractSendChannel
        public Object a(E e) {
            return super.a((Subscriber<E>) e);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractChannel
        public void a(boolean z) {
            if (z) {
                this.b.a((Subscriber) this);
            }
        }
    }

    static {
        Symbol symbol = new Symbol("UNDEFINED");
        f = symbol;
        g = new State<>(symbol, null);
        b = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "_state");
        f42991c = AtomicIntegerFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, "_updating");
        d = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "onCloseHandler");
    }

    private final Closed a(E e2) {
        Object obj;
        if (f42991c.compareAndSet(this, 0, 1)) {
            do {
                try {
                    obj = this._state;
                    if (obj instanceof Closed) {
                        return (Closed) obj;
                    }
                    if (!(obj instanceof State)) {
                        throw new IllegalStateException(Intrinsics.a("Invalid state ", obj).toString());
                    }
                } finally {
                    this._updating = 0;
                }
            } while (!b.compareAndSet(this, obj, new State(e2, ((State) obj).b)));
            Subscriber<E>[] subscriberArr = ((State) obj).b;
            if (subscriberArr != null) {
                int length = subscriberArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    subscriberArr[i2].a((Subscriber<E>) e2);
                    i = i2 + 1;
                }
            }
            this._updating = 0;
            return null;
        }
        return null;
    }

    private final void a(Throwable th) {
        Object obj = this.onCloseHandler;
        if (obj == null || obj == AbstractChannelKt.f || !d.compareAndSet(this, obj, AbstractChannelKt.f)) {
            return;
        }
        ((Function1) TypeIntrinsics.b(obj, 1)).invoke(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Subscriber<E> subscriber) {
        Object obj;
        Object obj2;
        Subscriber<E>[] subscriberArr;
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                return;
            }
            if (!(obj instanceof State)) {
                throw new IllegalStateException(Intrinsics.a("Invalid state ", obj).toString());
            }
            State state = (State) obj;
            obj2 = state.f42993a;
            subscriberArr = state.b;
            Intrinsics.a(subscriberArr);
        } while (!b.compareAndSet(this, obj, new State(obj2, b(subscriberArr, subscriber))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void a(SelectInstance<? super R> selectInstance, E e2, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        if (selectInstance.g()) {
            Closed a2 = a((ConflatedBroadcastChannel<E>) e2);
            if (a2 == null) {
                UndispatchedKt.a((Function2<? super ConflatedBroadcastChannel<E>, ? super Continuation<? super T>, ? extends Object>) function2, this, (Continuation) selectInstance.a());
            } else {
                selectInstance.a(a2.a());
            }
        }
    }

    private final Subscriber<E>[] a(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        if (subscriberArr == null) {
            Subscriber<E>[] subscriberArr2 = new Subscriber[1];
            for (int i = 0; i < 1; i++) {
                subscriberArr2[i] = subscriber;
            }
            return subscriberArr2;
        }
        return (Subscriber[]) ArraysKt.a(subscriberArr, subscriber);
    }

    private final Subscriber<E>[] b(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        int length = subscriberArr.length;
        int c2 = ArraysKt.c(subscriberArr, subscriber);
        if (DebugKt.a()) {
            if (!(c2 >= 0)) {
                throw new AssertionError();
            }
        }
        if (length == 1) {
            return null;
        }
        Subscriber<E>[] subscriberArr2 = new Subscriber[length - 1];
        ArraysKt.a(subscriberArr, subscriberArr2, 0, 0, c2, 6, (Object) null);
        ArraysKt.a(subscriberArr, subscriberArr2, c2, c2 + 1, 0, 8, (Object) null);
        return subscriberArr2;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object a(E e2, Continuation<? super Unit> continuation) {
        Closed a2 = a((ConflatedBroadcastChannel<E>) e2);
        if (a2 == null) {
            if (IntrinsicsKt.a() == null) {
                return null;
            }
            return Unit.f42314a;
        }
        throw a2.a();
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void a(CancellationException cancellationException) {
        b_(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void a(Function1<? super Throwable, Unit> function1) {
        if (!d.compareAndSet(this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj != AbstractChannelKt.f) {
                throw new IllegalStateException(Intrinsics.a("Another handler was already registered: ", obj));
            }
            throw new IllegalStateException("Another handler was already registered and successfully invoked");
        }
        Object obj2 = this._state;
        if ((obj2 instanceof Closed) && d.compareAndSet(this, function1, AbstractChannelKt.f)) {
            function1.invoke(((Closed) obj2).f42992a);
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object a_(E e2) {
        Closed a2 = a((ConflatedBroadcastChannel<E>) e2);
        return a2 == null ? ChannelResult.f42903a.a((ChannelResult.Companion) Unit.f42314a) : ChannelResult.f42903a.a(a2.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> az_() {
        Object obj;
        State state;
        Subscriber subscriber = new Subscriber(this);
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                subscriber.b_(((Closed) obj).f42992a);
                return subscriber;
            } else if (!(obj instanceof State)) {
                throw new IllegalStateException(Intrinsics.a("Invalid state ", obj).toString());
            } else {
                state = (State) obj;
                if (state.f42993a != f) {
                    subscriber.a((Subscriber) state.f42993a);
                }
            }
        } while (!b.compareAndSet(this, obj, new State(state.f42993a, a(state.b, subscriber))));
        return subscriber;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean b_(Throwable th) {
        Object obj;
        int i;
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                return false;
            }
            if (!(obj instanceof State)) {
                throw new IllegalStateException(Intrinsics.a("Invalid state ", obj).toString());
            }
        } while (!b.compareAndSet(this, obj, th == null ? e : new Closed(th)));
        Subscriber<E>[] subscriberArr = ((State) obj).b;
        if (subscriberArr != null) {
            for (Subscriber<E> subscriber : subscriberArr) {
                subscriber.b_(th);
            }
        }
        a(th);
        return true;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean u() {
        return this._state instanceof Closed;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> v() {
        return (SelectClause2) ((SelectClause2<E, SendChannel<? super E>>) new SelectClause2<E, SendChannel<? super E>>(this) { // from class: kotlinx.coroutines.channels.ConflatedBroadcastChannel$onSend$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ConflatedBroadcastChannel<E> f42994a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f42994a = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause2
            public <R> void a(SelectInstance<? super R> selectInstance, E e2, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
                this.f42994a.a(selectInstance, e2, function2);
            }
        });
    }
}
