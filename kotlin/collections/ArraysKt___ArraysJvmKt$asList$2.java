package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysJvmKt$asList$2.class */
public final class ArraysKt___ArraysJvmKt$asList$2 extends AbstractList<Short> implements RandomAccess {
    final /* synthetic */ short[] a;

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: a */
    public Short get(int i) {
        return Short.valueOf(this.a[i]);
    }

    public boolean a(short s) {
        return ArraysKt.a(this.a, s);
    }

    public int b(short s) {
        return ArraysKt.b(this.a, s);
    }

    public int c(short s) {
        return ArraysKt.c(this.a, s);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Short) {
            return a(((Number) obj).shortValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Short) {
            return b(((Number) obj).shortValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.a.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Short) {
            return c(((Number) obj).shortValue());
        }
        return -1;
    }
}
