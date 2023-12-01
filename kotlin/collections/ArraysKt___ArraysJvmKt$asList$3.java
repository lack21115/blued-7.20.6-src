package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysJvmKt$asList$3.class */
public final class ArraysKt___ArraysJvmKt$asList$3 extends AbstractList<Integer> implements RandomAccess {
    final /* synthetic */ int[] a;

    public boolean a(int i) {
        return ArraysKt.a(this.a, i);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: b */
    public Integer get(int i) {
        return Integer.valueOf(this.a[i]);
    }

    public int c(int i) {
        return ArraysKt.b(this.a, i);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return a(((Number) obj).intValue());
        }
        return false;
    }

    public int d(int i) {
        return ArraysKt.c(this.a, i);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            return c(((Number) obj).intValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.a.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            return d(((Number) obj).intValue());
        }
        return -1;
    }
}
