package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata
@JvmInline
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/InlineList.class */
public final class InlineList<E> {
    private final Object a;

    public static /* synthetic */ Object a(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return c(obj);
    }

    public static final Object a(Object obj, E e) {
        if (!DebugKt.a() || (!(e instanceof List))) {
            if (obj == null) {
                return c(e);
            }
            if (obj instanceof ArrayList) {
                if (obj != null) {
                    ((ArrayList) obj).add(e);
                    return c(obj);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(e);
            return c(arrayList);
        }
        throw new AssertionError();
    }

    public static String a(Object obj) {
        return "InlineList(holder=" + obj + ')';
    }

    public static int b(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static boolean b(Object obj, Object obj2) {
        return (obj2 instanceof InlineList) && Intrinsics.a(obj, ((InlineList) obj2).a());
    }

    public static <E> Object c(Object obj) {
        return obj;
    }

    public final /* synthetic */ Object a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return b(a(), obj);
    }

    public int hashCode() {
        return b(a());
    }

    public String toString() {
        return a(a());
    }
}
