package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ArrayIntIterator.class */
final class ArrayIntIterator extends IntIterator {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f42520a;
    private int b;

    public ArrayIntIterator(int[] array) {
        Intrinsics.e(array, "array");
        this.f42520a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f42520a.length;
    }

    @Override // kotlin.collections.IntIterator
    public int nextInt() {
        try {
            int[] iArr = this.f42520a;
            int i = this.b;
            this.b = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
