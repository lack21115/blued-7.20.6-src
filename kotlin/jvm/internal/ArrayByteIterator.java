package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ArrayByteIterator.class */
final class ArrayByteIterator extends ByteIterator {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f42516a;
    private int b;

    public ArrayByteIterator(byte[] array) {
        Intrinsics.e(array, "array");
        this.f42516a = array;
    }

    @Override // kotlin.collections.ByteIterator
    public byte a() {
        try {
            byte[] bArr = this.f42516a;
            int i = this.b;
            this.b = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f42516a.length;
    }
}
