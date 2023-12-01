package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;

@Metadata
@JvmInline
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/SegmentOrClosed.class */
public final class SegmentOrClosed<S extends Segment<S>> {
    private final Object a;

    public static final boolean a(Object obj) {
        Symbol symbol;
        symbol = ConcurrentLinkedListKt.a;
        return obj == symbol;
    }

    public static boolean a(Object obj, Object obj2) {
        return (obj2 instanceof SegmentOrClosed) && Intrinsics.a(obj, ((SegmentOrClosed) obj2).a());
    }

    public static final S b(Object obj) {
        Symbol symbol;
        symbol = ConcurrentLinkedListKt.a;
        if (obj != symbol) {
            if (obj != null) {
                return (S) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static String c(Object obj) {
        return "SegmentOrClosed(value=" + obj + ')';
    }

    public static int d(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static <S extends Segment<S>> Object e(Object obj) {
        return obj;
    }

    public final /* synthetic */ Object a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return a(a(), obj);
    }

    public int hashCode() {
        return d(a());
    }

    public String toString() {
        return c(a());
    }
}
