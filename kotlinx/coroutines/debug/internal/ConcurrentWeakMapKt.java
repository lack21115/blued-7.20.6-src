package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/ConcurrentWeakMapKt.class */
public final class ConcurrentWeakMapKt {

    /* renamed from: a */
    private static final Symbol f43025a = new Symbol("REHASH");
    private static final Marked b = new Marked(null);

    /* renamed from: c */
    private static final Marked f43026c = new Marked(true);

    public static final Marked b(Object obj) {
        return obj == null ? b : Intrinsics.a(obj, (Object) true) ? f43026c : new Marked(obj);
    }

    public static final Void c() {
        throw new UnsupportedOperationException("not implemented");
    }
}
