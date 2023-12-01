package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ArrayBooleanIterator.class */
final class ArrayBooleanIterator extends BooleanIterator {

    /* renamed from: a  reason: collision with root package name */
    private final boolean[] f42515a;
    private int b;

    public ArrayBooleanIterator(boolean[] array) {
        Intrinsics.e(array, "array");
        this.f42515a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f42515a.length;
    }

    @Override // kotlin.collections.BooleanIterator
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f42515a;
            int i = this.b;
            this.b = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
