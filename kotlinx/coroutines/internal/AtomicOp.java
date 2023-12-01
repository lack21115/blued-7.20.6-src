package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/AtomicOp.class */
public abstract class AtomicOp<T> extends OpDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f43518a = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = AtomicKt.f43517a;

    public final Object a() {
        return this._consensus;
    }

    public abstract Object a(T t);

    public abstract void a(T t, Object obj);

    public final Object b(Object obj) {
        if (DebugKt.a()) {
            if (!(obj != AtomicKt.f43517a)) {
                throw new AssertionError();
            }
        }
        Object obj2 = this._consensus;
        return obj2 != AtomicKt.f43517a ? obj2 : f43518a.compareAndSet(this, AtomicKt.f43517a, obj) ? obj : this._consensus;
    }

    public final boolean b() {
        return this._consensus != AtomicKt.f43517a;
    }

    public long c() {
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    public final Object c(Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = obj2;
        if (obj2 == AtomicKt.f43517a) {
            obj3 = b(a((AtomicOp<T>) obj));
        }
        a(obj, obj3);
        return obj3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    public AtomicOp<?> d() {
        return this;
    }
}
