package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.DoubleIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ArrayDoubleIterator.class */
final class ArrayDoubleIterator extends DoubleIterator {
    private final double[] a;
    private int b;

    public ArrayDoubleIterator(double[] array) {
        Intrinsics.e(array, "array");
        this.a = array;
    }

    @Override // kotlin.collections.DoubleIterator
    public double a() {
        try {
            double[] dArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }
}
