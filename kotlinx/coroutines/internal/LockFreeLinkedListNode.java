package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeLinkedListNode.class */
public class LockFreeLinkedListNode {
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;
    static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
    static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f43538a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc.class */
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        public Object a(PrepareOp prepareOp) {
            b(prepareOp);
            return null;
        }

        protected Object a(LockFreeLinkedListNode lockFreeLinkedListNode) {
            return null;
        }

        protected LockFreeLinkedListNode a(OpDescriptor opDescriptor) {
            LockFreeLinkedListNode b = b();
            Intrinsics.a(b);
            return b;
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final void a(AtomicOp<?> atomicOp, Object obj) {
            boolean z = obj == null;
            LockFreeLinkedListNode b = b();
            if (b == null) {
                if (DebugKt.a() && !(!z)) {
                    throw new AssertionError();
                }
                return;
            }
            LockFreeLinkedListNode c2 = c();
            if (c2 == null) {
                if (DebugKt.a() && !(!z)) {
                    throw new AssertionError();
                }
                return;
            }
            if (LockFreeLinkedListNode.e.compareAndSet(b, atomicOp, z ? b(b, c2) : c2) && z) {
                a(b, c2);
            }
        }

        protected abstract void a(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        protected boolean a(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x009e, code lost:
            if (kotlinx.coroutines.DebugKt.a() == false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00a3, code lost:
            if (r0 != null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b2, code lost:
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00b3, code lost:
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00c4, code lost:
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00c7, code lost:
            if (r8 == false) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00ca, code lost:
            return null;
         */
        @Override // kotlinx.coroutines.internal.AtomicDesc
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object b(kotlinx.coroutines.internal.AtomicOp<?> r7) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc.b(kotlinx.coroutines.internal.AtomicOp):java.lang.Object");
        }

        public abstract Object b(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        protected abstract LockFreeLinkedListNode b();

        public abstract void b(PrepareOp prepareOp);

        public void b(LockFreeLinkedListNode lockFreeLinkedListNode) {
        }

        protected abstract LockFreeLinkedListNode c();
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc.class */
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {
        private static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        private volatile /* synthetic */ Object _affectedNode;

        /* renamed from: a  reason: collision with root package name */
        public final LockFreeLinkedListNode f43539a;

        /* renamed from: c  reason: collision with root package name */
        public final T f43540c;

        public AddLastDesc(LockFreeLinkedListNode lockFreeLinkedListNode, T t) {
            this.f43539a = lockFreeLinkedListNode;
            this.f43540c = t;
            if (DebugKt.a()) {
                Object obj = this.f43540c._next;
                T t2 = this.f43540c;
                if (!(obj == t2 && t2._prev == this.f43540c)) {
                    throw new AssertionError();
                }
            }
            this._affectedNode = null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode a(OpDescriptor opDescriptor) {
            return this.f43539a.a(opDescriptor);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected void a(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            this.f43540c.e(this.f43539a);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected boolean a(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            return obj != this.f43539a;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object b(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            LockFreeLinkedListNode.f.compareAndSet(this.f43540c, this.f43540c, lockFreeLinkedListNode);
            LockFreeLinkedListNode.e.compareAndSet(this.f43540c, this.f43540c, this.f43539a);
            return this.f43540c;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode b() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void b(PrepareOp prepareOp) {
            d.compareAndSet(this, null, prepareOp.f43541a);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode c() {
            return this.f43539a;
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp.class */
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        public final LockFreeLinkedListNode d;
        public LockFreeLinkedListNode e;

        public CondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.d = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void a(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            boolean z = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = z ? this.d : this.e;
            if (lockFreeLinkedListNode2 != null && LockFreeLinkedListNode.e.compareAndSet(lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.d;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.e;
                Intrinsics.a(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.e(lockFreeLinkedListNode4);
            }
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp.class */
    public static final class PrepareOp extends OpDescriptor {

        /* renamed from: a  reason: collision with root package name */
        public final LockFreeLinkedListNode f43541a;
        public final LockFreeLinkedListNode b;

        /* renamed from: c  reason: collision with root package name */
        public final AbstractAtomicDesc f43542c;

        public PrepareOp(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, AbstractAtomicDesc abstractAtomicDesc) {
            this.f43541a = lockFreeLinkedListNode;
            this.b = lockFreeLinkedListNode2;
            this.f43542c = abstractAtomicDesc;
        }

        public final void a() {
            this.f43542c.b(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v16, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
        @Override // kotlinx.coroutines.internal.OpDescriptor
        public Object c(Object obj) {
            if (DebugKt.a()) {
                if (!(obj == this.f43541a)) {
                    throw new AssertionError();
                }
            }
            if (obj != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                Object a2 = this.f43542c.a(this);
                if (a2 != LockFreeLinkedList_commonKt.f43546a) {
                    Object b = a2 != null ? d().b(a2) : d().a();
                    LockFreeLinkedListNode.e.compareAndSet(lockFreeLinkedListNode, this, b == AtomicKt.f43517a ? d() : b == null ? this.f43542c.b(lockFreeLinkedListNode, this.b) : this.b);
                    return null;
                }
                LockFreeLinkedListNode lockFreeLinkedListNode2 = this.b;
                if (LockFreeLinkedListNode.e.compareAndSet(lockFreeLinkedListNode, this, lockFreeLinkedListNode2.c())) {
                    this.f43542c.b(lockFreeLinkedListNode);
                    lockFreeLinkedListNode2.a((OpDescriptor) null);
                }
                return LockFreeLinkedList_commonKt.f43546a;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public AtomicOp<?> d() {
            return this.f43542c.a();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public String toString() {
            return "PrepareOp(op=" + d() + ')';
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc.class */
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {

        /* renamed from: a  reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f43543a = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");
        private static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");
        private volatile /* synthetic */ Object _affectedNode = null;
        private volatile /* synthetic */ Object _originalNext = null;

        /* renamed from: c  reason: collision with root package name */
        public final LockFreeLinkedListNode f43544c;

        public RemoveFirstDesc(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f43544c = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object a(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode == this.f43544c) {
                return LockFreeLinkedListKt.b();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode a(OpDescriptor opDescriptor) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.f43544c;
            while (true) {
                Object obj = lockFreeLinkedListNode._next;
                if (!(obj instanceof OpDescriptor)) {
                    return (LockFreeLinkedListNode) obj;
                }
                OpDescriptor opDescriptor2 = (OpDescriptor) obj;
                if (opDescriptor.a(opDescriptor2)) {
                    return null;
                }
                opDescriptor2.c(this.f43544c);
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final void a(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            lockFreeLinkedListNode2.a((OpDescriptor) null);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final boolean a(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            if (obj instanceof Removed) {
                ((Removed) obj).f43558a.n();
                return true;
            }
            return false;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object b(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            return lockFreeLinkedListNode2.c();
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode b() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void b(PrepareOp prepareOp) {
            f43543a.compareAndSet(this, null, prepareOp.f43541a);
            d.compareAndSet(this, null, prepareOp.b);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode c() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        public final T d() {
            T t = (T) b();
            Intrinsics.a(t);
            return t;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        if (kotlinx.coroutines.internal.LockFreeLinkedListNode.e.compareAndSet(r8, r7, ((kotlinx.coroutines.internal.Removed) r0).f43558a) != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode a(kotlinx.coroutines.internal.OpDescriptor r6) {
        /*
            r5 = this;
        L0:
            r0 = r5
            java.lang.Object r0 = r0._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r9 = r0
            r0 = r9
            r7 = r0
        Lc:
            r0 = 0
            r8 = r0
        Le:
            r0 = r7
            java.lang.Object r0 = r0._next
            r10 = r0
            r0 = r10
            r1 = r5
            if (r0 != r1) goto L34
            r0 = r9
            r1 = r7
            if (r0 != r1) goto L22
            r0 = r7
            return r0
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f
            r1 = r5
            r2 = r9
            r3 = r7
            boolean r0 = r0.compareAndSet(r1, r2, r3)
            if (r0 != 0) goto L32
            goto L0
        L32:
            r0 = r7
            return r0
        L34:
            r0 = r5
            boolean r0 = r0.aA_()
            if (r0 == 0) goto L3d
            r0 = 0
            return r0
        L3d:
            r0 = r10
            r1 = r6
            if (r0 != r1) goto L45
            r0 = r7
            return r0
        L45:
            r0 = r10
            boolean r0 = r0 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r0 == 0) goto L6c
            r0 = r6
            if (r0 == 0) goto L5f
            r0 = r6
            r1 = r10
            kotlinx.coroutines.internal.OpDescriptor r1 = (kotlinx.coroutines.internal.OpDescriptor) r1
            boolean r0 = r0.a(r1)
            if (r0 == 0) goto L5f
            r0 = 0
            return r0
        L5f:
            r0 = r10
            kotlinx.coroutines.internal.OpDescriptor r0 = (kotlinx.coroutines.internal.OpDescriptor) r0
            r1 = r7
            java.lang.Object r0 = r0.c(r1)
            goto L0
        L6c:
            r0 = r10
            boolean r0 = r0 instanceof kotlinx.coroutines.internal.Removed
            if (r0 == 0) goto L9e
            r0 = r8
            if (r0 == 0) goto L93
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.internal.LockFreeLinkedListNode.e
            r1 = r8
            r2 = r7
            r3 = r10
            kotlinx.coroutines.internal.Removed r3 = (kotlinx.coroutines.internal.Removed) r3
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = r3.f43558a
            boolean r0 = r0.compareAndSet(r1, r2, r3)
            if (r0 != 0) goto L8e
            goto L0
        L8e:
            r0 = r8
            r7 = r0
            goto Lc
        L93:
            r0 = r7
            java.lang.Object r0 = r0._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r7 = r0
            goto Le
        L9e:
            r0 = r10
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r10 = r0
            r0 = r7
            r8 = r0
            r0 = r10
            r7 = r0
            goto Le
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.a(kotlinx.coroutines.internal.OpDescriptor):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Removed c() {
        Removed removed = (Removed) this._removedRef;
        Removed removed2 = removed;
        if (removed == null) {
            removed2 = new Removed(this);
            f43538a.lazySet(this, removed2);
        }
        return removed2;
    }

    private final LockFreeLinkedListNode d(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.aA_()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListNode._prev;
        }
        return lockFreeLinkedListNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) lockFreeLinkedListNode._prev;
            if (i() != lockFreeLinkedListNode) {
                return;
            }
        } while (!f.compareAndSet(lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (aA_()) {
            lockFreeLinkedListNode.a((OpDescriptor) null);
        }
    }

    public final int a(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, CondAddOp condAddOp) {
        f.lazySet(lockFreeLinkedListNode, this);
        e.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        condAddOp.e = lockFreeLinkedListNode2;
        if (e.compareAndSet(this, lockFreeLinkedListNode2, condAddOp)) {
            return condAddOp.c(this) == null ? 1 : 2;
        }
        return 0;
    }

    public final boolean a(LockFreeLinkedListNode lockFreeLinkedListNode) {
        f.lazySet(lockFreeLinkedListNode, this);
        e.lazySet(lockFreeLinkedListNode, this);
        while (i() == this) {
            if (e.compareAndSet(this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.e(this);
                return true;
            }
        }
        return false;
    }

    public final boolean a(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        f.lazySet(lockFreeLinkedListNode, this);
        e.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (e.compareAndSet(this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            lockFreeLinkedListNode.e(lockFreeLinkedListNode2);
            return true;
        }
        return false;
    }

    public boolean aA_() {
        return i() instanceof Removed;
    }

    public boolean aB_() {
        return l() == null;
    }

    public final void b(LockFreeLinkedListNode lockFreeLinkedListNode) {
        do {
        } while (!k().a(lockFreeLinkedListNode, this));
    }

    public final Object i() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).c(this);
        }
    }

    public final LockFreeLinkedListNode j() {
        return LockFreeLinkedListKt.a(i());
    }

    public final LockFreeLinkedListNode k() {
        LockFreeLinkedListNode a2 = a((OpDescriptor) null);
        LockFreeLinkedListNode lockFreeLinkedListNode = a2;
        if (a2 == null) {
            lockFreeLinkedListNode = d((LockFreeLinkedListNode) this._prev);
        }
        return lockFreeLinkedListNode;
    }

    public final LockFreeLinkedListNode l() {
        Object i;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            i = i();
            if (i instanceof Removed) {
                return ((Removed) i).f43558a;
            }
            if (i == this) {
                return (LockFreeLinkedListNode) i;
            }
            lockFreeLinkedListNode = (LockFreeLinkedListNode) i;
        } while (!e.compareAndSet(this, i, lockFreeLinkedListNode.c()));
        lockFreeLinkedListNode.a((OpDescriptor) null);
        return null;
    }

    public final void m() {
        ((Removed) i()).f43558a.a((OpDescriptor) null);
    }

    public final void n() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            Object i = lockFreeLinkedListNode2.i();
            if (!(i instanceof Removed)) {
                lockFreeLinkedListNode2.a((OpDescriptor) null);
                return;
            }
            lockFreeLinkedListNode = ((Removed) i).f43558a;
        }
    }

    public final LockFreeLinkedListNode o() {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) i();
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            if (lockFreeLinkedListNode.aB_()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.m();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) getClass().getSimpleName());
        sb.append('@');
        sb.append((Object) Integer.toHexString(System.identityHashCode(this)));
        return sb.toString();
    }
}
