package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ShortIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ArrayShortIterator.class */
final class ArrayShortIterator extends ShortIterator {

    /* renamed from: a  reason: collision with root package name */
    private final short[] f42523a;
    private int b;

    public ArrayShortIterator(short[] array) {
        Intrinsics.e(array, "array");
        this.f42523a = array;
    }

    @Override // kotlin.collections.ShortIterator
    public short a() {
        try {
            short[] sArr = this.f42523a;
            int i = this.b;
            this.b = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f42523a.length;
    }
}
