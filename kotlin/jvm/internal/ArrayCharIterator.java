package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ArrayCharIterator.class */
final class ArrayCharIterator extends CharIterator {

    /* renamed from: a  reason: collision with root package name */
    private final char[] f42517a;
    private int b;

    public ArrayCharIterator(char[] array) {
        Intrinsics.e(array, "array");
        this.f42517a = array;
    }

    @Override // kotlin.collections.CharIterator
    public char a() {
        try {
            char[] cArr = this.f42517a;
            int i = this.b;
            this.b = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f42517a.length;
    }
}
