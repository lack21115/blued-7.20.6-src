package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/SetsKt__SetsJVMKt.class */
public class SetsKt__SetsJVMKt {
    public static final <E> Set<E> a(int i) {
        return new SetBuilder(i);
    }

    public static final <T> Set<T> a(T t) {
        Set<T> singleton = Collections.singleton(t);
        Intrinsics.c(singleton, "singleton(element)");
        return singleton;
    }

    public static final <E> Set<E> a(Set<E> builder) {
        Intrinsics.e(builder, "builder");
        return ((SetBuilder) builder).b();
    }
}
