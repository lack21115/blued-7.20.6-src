package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ArrayLongIterator.class */
final class ArrayLongIterator extends LongIterator {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f42522a;
    private int b;

    public ArrayLongIterator(long[] array) {
        Intrinsics.e(array, "array");
        this.f42522a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f42522a.length;
    }

    @Override // kotlin.collections.LongIterator
    public long nextLong() {
        try {
            long[] jArr = this.f42522a;
            int i = this.b;
            this.b = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
