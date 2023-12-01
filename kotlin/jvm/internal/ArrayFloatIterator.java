package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.FloatIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ArrayFloatIterator.class */
final class ArrayFloatIterator extends FloatIterator {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f42519a;
    private int b;

    public ArrayFloatIterator(float[] array) {
        Intrinsics.e(array, "array");
        this.f42519a = array;
    }

    @Override // kotlin.collections.FloatIterator
    public float a() {
        try {
            float[] fArr = this.f42519a;
            int i = this.b;
            this.b = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f42519a.length;
    }
}
