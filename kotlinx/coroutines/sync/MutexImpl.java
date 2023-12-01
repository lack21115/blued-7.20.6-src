package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/MutexImpl.class */
public final class MutexImpl implements SelectClause2<Object, Mutex>, Mutex {
    static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    volatile /* synthetic */ Object _state;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/MutexImpl$LockCont.class */
    public final class LockCont extends LockWaiter {
        public final CancellableContinuation<Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(Object obj, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(obj);
            this.a = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public Object a() {
            CancellableContinuation<Unit> cancellableContinuation = this.a;
            Unit unit = Unit.a;
            final MutexImpl mutexImpl = MutexImpl.this;
            return cancellableContinuation.a(unit, null, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$LockCont$tryResumeLockWaiter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void a(Throwable th) {
                    MutexImpl.this.a(this.d);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(Throwable th) {
                    a(th);
                    return Unit.a;
                }
            });
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public void a(Object obj) {
            this.a.a(obj);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockCont[" + this.d + ", " + this.a + "] for " + MutexImpl.this;
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/MutexImpl$LockSelect.class */
    final class LockSelect<R> extends LockWaiter {
        public final SelectInstance<R> a;
        public final Function2<Mutex, Continuation<? super R>, Object> b;

        /* JADX WARN: Multi-variable type inference failed */
        public LockSelect(Object obj, SelectInstance<? super R> selectInstance, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
            super(obj);
            this.a = selectInstance;
            this.b = function2;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public Object a() {
            Symbol symbol;
            if (this.a.g()) {
                symbol = MutexKt.c;
                return symbol;
            }
            return null;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public void a(Object obj) {
            Symbol symbol;
            if (DebugKt.a()) {
                symbol = MutexKt.c;
                if (!(obj == symbol)) {
                    throw new AssertionError();
                }
            }
            Function2<Mutex, Continuation<? super R>, Object> function2 = this.b;
            MutexImpl mutexImpl = MutexImpl.this;
            Continuation<R> a = this.a.a();
            final MutexImpl mutexImpl2 = MutexImpl.this;
            CancellableKt.a(function2, mutexImpl, a, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$LockSelect$completeResumeLockWaiter$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void a(Throwable th) {
                    MutexImpl.this.a(this.d);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(Throwable th) {
                    a(th);
                    return Unit.a;
                }
            });
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockSelect[" + this.d + ", " + this.a + "] for " + MutexImpl.this;
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/MutexImpl$LockWaiter.class */
    abstract class LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {
        public final Object d;

        public LockWaiter(Object obj) {
            this.d = obj;
        }

        public abstract Object a();

        public abstract void a(Object obj);

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            aB_();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/MutexImpl$LockedQueue.class */
    public static final class LockedQueue extends LockFreeLinkedListHead {
        public Object a;

        public LockedQueue(Object obj) {
            this.a = obj;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockedQueue[" + this.a + ']';
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/MutexImpl$TryLockDesc.class */
    static final class TryLockDesc extends AtomicDesc {
        public final MutexImpl a;
        public final Object c;

        @Metadata
        /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/MutexImpl$TryLockDesc$PrepareOp.class */
        final class PrepareOp extends OpDescriptor {
            private final AtomicOp<?> b;

            public PrepareOp(AtomicOp<?> atomicOp) {
                this.b = atomicOp;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v12, types: [kotlinx.coroutines.sync.Empty] */
            @Override // kotlinx.coroutines.internal.OpDescriptor
            public Object c(Object obj) {
                AtomicOp<?> d;
                ?? r0;
                if (d().b()) {
                    r0 = MutexKt.g;
                    d = r0;
                } else {
                    d = d();
                }
                if (obj != null) {
                    MutexImpl.a.compareAndSet((MutexImpl) obj, this, d);
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            public AtomicOp<?> d() {
                return this.b;
            }
        }

        public TryLockDesc(MutexImpl mutexImpl, Object obj) {
            this.a = mutexImpl;
            this.c = obj;
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public void a(AtomicOp<?> atomicOp, Object obj) {
            Empty empty;
            Empty empty2;
            Empty empty3;
            if (obj != null) {
                empty3 = MutexKt.g;
                empty = empty3;
            } else {
                Object obj2 = this.c;
                if (obj2 == null) {
                    empty2 = MutexKt.f;
                    empty = empty2;
                } else {
                    empty = new Empty(obj2);
                }
            }
            MutexImpl.a.compareAndSet(this.a, atomicOp, empty);
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public Object b(AtomicOp<?> atomicOp) {
            Empty empty;
            Symbol symbol;
            PrepareOp prepareOp = new PrepareOp(atomicOp);
            MutexImpl mutexImpl = this.a;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.a;
            empty = MutexKt.g;
            if (atomicReferenceFieldUpdater.compareAndSet(mutexImpl, empty, prepareOp)) {
                return prepareOp.c(this.a);
            }
            symbol = MutexKt.a;
            return symbol;
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/MutexImpl$UnlockOp.class */
    static final class UnlockOp extends AtomicOp<MutexImpl> {
        public final LockedQueue a;

        public UnlockOp(LockedQueue lockedQueue) {
            this.a = lockedQueue;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public Object a(MutexImpl mutexImpl) {
            Symbol symbol;
            if (this.a.c()) {
                return null;
            }
            symbol = MutexKt.b;
            return symbol;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [kotlinx.coroutines.sync.Empty] */
        @Override // kotlinx.coroutines.internal.AtomicOp
        public void a(MutexImpl mutexImpl, Object obj) {
            LockedQueue lockedQueue;
            ?? r0;
            if (obj == null) {
                r0 = MutexKt.g;
                lockedQueue = r0;
            } else {
                lockedQueue = this.a;
            }
            MutexImpl.a.compareAndSet(mutexImpl, this, lockedQueue);
        }
    }

    public MutexImpl(boolean z) {
        Empty empty;
        Empty empty2;
        Empty empty3;
        if (z) {
            empty3 = MutexKt.f;
            empty2 = empty3;
        } else {
            empty = MutexKt.g;
            empty2 = empty;
        }
        this._state = empty2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0107, code lost:
        r0 = r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0111, code lost:
        if (r0 != kotlin.coroutines.intrinsics.IntrinsicsKt.a()) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0114, code lost:
        kotlin.coroutines.jvm.internal.DebugProbesKt.c(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x011c, code lost:
        if (r0 != kotlin.coroutines.intrinsics.IntrinsicsKt.a()) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0120, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0124, code lost:
        return kotlin.Unit.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object b(final java.lang.Object r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexImpl.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public Object a(Object obj, Continuation<? super Unit> continuation) {
        Object b;
        if (!b(obj) && (b = b(obj, continuation)) == IntrinsicsKt.a()) {
            return b;
        }
        return Unit.a;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void a(Object obj) {
        Empty empty;
        Empty empty2;
        Symbol symbol;
        Symbol symbol2;
        LockedQueue lockedQueue;
        while (true) {
            Object obj2 = this._state;
            boolean z = true;
            if (obj2 instanceof Empty) {
                if (obj == null) {
                    Object obj3 = ((Empty) obj2).a;
                    symbol = MutexKt.e;
                    if (obj3 == symbol) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    if (!(((Empty) obj2).a == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + empty.a + " but expected " + obj).toString());
                    }
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
                empty2 = MutexKt.g;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, empty2)) {
                    return;
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).c(this);
            } else if (!(obj2 instanceof LockedQueue)) {
                throw new IllegalStateException(Intrinsics.a("Illegal state ", obj2).toString());
            } else {
                if (obj != null) {
                    if (!(((LockedQueue) obj2).a == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + lockedQueue.a + " but expected " + obj).toString());
                    }
                }
                LockedQueue lockedQueue2 = (LockedQueue) obj2;
                LockFreeLinkedListNode o = lockedQueue2.o();
                if (o == null) {
                    UnlockOp unlockOp = new UnlockOp(lockedQueue2);
                    if (a.compareAndSet(this, obj2, unlockOp) && unlockOp.c(this) == null) {
                        return;
                    }
                } else {
                    LockWaiter lockWaiter = (LockWaiter) o;
                    Object a2 = lockWaiter.a();
                    if (a2 != null) {
                        Object obj4 = lockWaiter.d;
                        Symbol symbol3 = obj4;
                        if (obj4 == null) {
                            symbol2 = MutexKt.d;
                            symbol3 = symbol2;
                        }
                        lockedQueue2.a = symbol3;
                        lockWaiter.a(a2);
                        return;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public <R> void a(SelectInstance<? super R> selectInstance, Object obj, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
        Symbol symbol;
        Symbol symbol2;
        boolean z;
        while (!selectInstance.f()) {
            final Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty = (Empty) obj2;
                Object obj3 = empty.a;
                symbol = MutexKt.e;
                if (obj3 != symbol) {
                    a.compareAndSet(this, obj2, new LockedQueue(empty.a));
                } else {
                    Object a2 = selectInstance.a(new TryLockDesc(this, obj));
                    if (a2 == null) {
                        UndispatchedKt.a((Function2<? super MutexImpl, ? super Continuation<? super T>, ? extends Object>) function2, this, (Continuation) selectInstance.a());
                        return;
                    } else if (a2 == SelectKt.b()) {
                        return;
                    } else {
                        symbol2 = MutexKt.a;
                        if (a2 != symbol2 && a2 != AtomicKt.b) {
                            throw new IllegalStateException(Intrinsics.a("performAtomicTrySelect(TryLockDesc) returned ", a2).toString());
                        }
                    }
                }
            } else if (obj2 instanceof LockedQueue) {
                if (!(((LockedQueue) obj2).a != obj)) {
                    throw new IllegalStateException(Intrinsics.a("Already locked by ", obj).toString());
                }
                LockSelect lockSelect = new LockSelect(obj, selectInstance, function2);
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj2;
                final LockSelect lockSelect2 = lockSelect;
                LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(this, obj2) { // from class: kotlinx.coroutines.sync.MutexImpl$registerSelectClause2$$inlined$addLastIf$1
                    final /* synthetic */ MutexImpl b;
                    final /* synthetic */ Object c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(LockFreeLinkedListNode.this);
                        this.b = this;
                        this.c = obj2;
                    }

                    @Override // kotlinx.coroutines.internal.AtomicOp
                    public Object a(LockFreeLinkedListNode lockFreeLinkedListNode2) {
                        if (this.b._state == this.c) {
                            return null;
                        }
                        return LockFreeLinkedListKt.a();
                    }
                };
                while (true) {
                    int a3 = lockFreeLinkedListNode.k().a(lockSelect2, lockFreeLinkedListNode, condAddOp);
                    if (a3 == 1) {
                        z = true;
                        break;
                    }
                    z = false;
                    if (a3 == 2) {
                        break;
                    }
                }
                if (z) {
                    selectInstance.a(lockSelect);
                    return;
                }
            } else if (!(obj2 instanceof OpDescriptor)) {
                throw new IllegalStateException(Intrinsics.a("Illegal state ", obj2).toString());
            } else {
                ((OpDescriptor) obj2).c(this);
            }
        }
    }

    public boolean b(Object obj) {
        Symbol symbol;
        Empty empty;
        Empty empty2;
        while (true) {
            Object obj2 = this._state;
            boolean z = true;
            if (obj2 instanceof Empty) {
                Object obj3 = ((Empty) obj2).a;
                symbol = MutexKt.e;
                if (obj3 != symbol) {
                    return false;
                }
                if (obj == null) {
                    empty2 = MutexKt.f;
                    empty = empty2;
                } else {
                    empty = new Empty(obj);
                }
                if (a.compareAndSet(this, obj2, empty)) {
                    return true;
                }
            } else if (obj2 instanceof LockedQueue) {
                if (((LockedQueue) obj2).a == obj) {
                    z = false;
                }
                if (z) {
                    return false;
                }
                throw new IllegalStateException(Intrinsics.a("Already locked by ", obj).toString());
            } else if (!(obj2 instanceof OpDescriptor)) {
                throw new IllegalStateException(Intrinsics.a("Illegal state ", obj2).toString());
            } else {
                ((OpDescriptor) obj2).c(this);
            }
        }
    }

    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                return "Mutex[" + ((Empty) obj).a + ']';
            } else if (!(obj instanceof OpDescriptor)) {
                if (obj instanceof LockedQueue) {
                    return "Mutex[" + ((LockedQueue) obj).a + ']';
                }
                throw new IllegalStateException(Intrinsics.a("Illegal state ", obj).toString());
            } else {
                ((OpDescriptor) obj).c(this);
            }
        }
    }
}
