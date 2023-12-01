package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/ConcurrentLinkedListNode.class */
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f43521a = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next");
    private static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev");
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ Object _prev;

    public ConcurrentLinkedListNode(N n) {
        this._prev = n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g() {
        return this._next;
    }

    private final N h() {
        N n;
        N c2 = c();
        while (true) {
            n = c2;
            if (n == null || !n.e()) {
                break;
            }
            c2 = (N) n._prev;
        }
        return n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    private final N i() {
        if (!DebugKt.a() || (!b())) {
            N a2 = a();
            Intrinsics.a(a2);
            while (a2.e()) {
                a2 = a2.a();
                Intrinsics.a(a2);
            }
            return a2;
        }
        throw new AssertionError();
    }

    public final N a() {
        Symbol symbol;
        Object g = g();
        symbol = ConcurrentLinkedListKt.f43520a;
        if (g == symbol) {
            return null;
        }
        return (N) g;
    }

    public final boolean a(N n) {
        return f43521a.compareAndSet(this, null, n);
    }

    public final boolean b() {
        return a() == null;
    }

    public final N c() {
        return (N) this._prev;
    }

    public final void d() {
        b.lazySet(this, null);
    }

    public abstract boolean e();

    public final void f() {
        if (DebugKt.a() && !e()) {
            throw new AssertionError();
        }
        if (DebugKt.a() && !(!b())) {
            throw new AssertionError();
        }
        while (true) {
            N h = h();
            N i = i();
            i._prev = h;
            if (h != null) {
                h._next = i;
            }
            if (!i.e() && (h == null || !h.e())) {
                return;
            }
        }
    }
}
