package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.BooleanIterator;
import kotlin.collections.ByteIterator;
import kotlin.collections.CharIterator;
import kotlin.collections.DoubleIterator;
import kotlin.collections.FloatIterator;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.ShortIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ArrayIteratorsKt.class */
public final class ArrayIteratorsKt {
    public static final BooleanIterator a(boolean[] array) {
        Intrinsics.e(array, "array");
        return new ArrayBooleanIterator(array);
    }

    public static final ByteIterator a(byte[] array) {
        Intrinsics.e(array, "array");
        return new ArrayByteIterator(array);
    }

    public static final CharIterator a(char[] array) {
        Intrinsics.e(array, "array");
        return new ArrayCharIterator(array);
    }

    public static final DoubleIterator a(double[] array) {
        Intrinsics.e(array, "array");
        return new ArrayDoubleIterator(array);
    }

    public static final FloatIterator a(float[] array) {
        Intrinsics.e(array, "array");
        return new ArrayFloatIterator(array);
    }

    public static final IntIterator a(int[] array) {
        Intrinsics.e(array, "array");
        return new ArrayIntIterator(array);
    }

    public static final LongIterator a(long[] array) {
        Intrinsics.e(array, "array");
        return new ArrayLongIterator(array);
    }

    public static final ShortIterator a(short[] array) {
        Intrinsics.e(array, "array");
        return new ArrayShortIterator(array);
    }
}
