package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/AtomicDesc.class */
public abstract class AtomicDesc {
    public AtomicOp<?> b;

    public final AtomicOp<?> a() {
        AtomicOp<?> atomicOp = this.b;
        if (atomicOp != null) {
            return atomicOp;
        }
        Intrinsics.c("atomicOp");
        throw null;
    }

    public final void a(AtomicOp<?> atomicOp) {
        this.b = atomicOp;
    }

    public abstract void a(AtomicOp<?> atomicOp, Object obj);

    public abstract Object b(AtomicOp<?> atomicOp);
}
