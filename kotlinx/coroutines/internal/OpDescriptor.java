package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.DebugStringsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/OpDescriptor.class */
public abstract class OpDescriptor {
    public final boolean a(OpDescriptor opDescriptor) {
        AtomicOp<?> d;
        AtomicOp<?> d2 = d();
        boolean z = false;
        if (d2 == null || (d = opDescriptor.d()) == null) {
            return false;
        }
        if (d2.c() < d.c()) {
            z = true;
        }
        return z;
    }

    public abstract Object c(Object obj);

    public abstract AtomicOp<?> d();

    public String toString() {
        return DebugStringsKt.b(this) + '@' + DebugStringsKt.a(this);
    }
}
