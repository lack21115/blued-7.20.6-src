package kotlin.jvm.internal;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ArrayIteratorKt.class */
public final class ArrayIteratorKt {
    public static final <T> Iterator<T> a(T[] array) {
        Intrinsics.e(array, "array");
        return new ArrayIterator(array);
    }
}
