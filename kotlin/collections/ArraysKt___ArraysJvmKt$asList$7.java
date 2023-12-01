package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysJvmKt$asList$7.class */
public final class ArraysKt___ArraysJvmKt$asList$7 extends AbstractList<Boolean> implements RandomAccess {
    final /* synthetic */ boolean[] a;

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: a */
    public Boolean get(int i) {
        return Boolean.valueOf(this.a[i]);
    }

    public boolean a(boolean z) {
        return ArraysKt.a(this.a, z);
    }

    public int b(boolean z) {
        return ArraysKt.b(this.a, z);
    }

    public int c(boolean z) {
        return ArraysKt.c(this.a, z);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Boolean) {
            return a(((Boolean) obj).booleanValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            return b(((Boolean) obj).booleanValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.a.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Boolean) {
            return c(((Boolean) obj).booleanValue());
        }
        return -1;
    }
}
