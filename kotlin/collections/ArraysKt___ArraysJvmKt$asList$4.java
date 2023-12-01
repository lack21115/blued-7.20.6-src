package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysJvmKt$asList$4.class */
public final class ArraysKt___ArraysJvmKt$asList$4 extends AbstractList<Long> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long[] f42339a;

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: a */
    public Long get(int i) {
        return Long.valueOf(this.f42339a[i]);
    }

    public boolean a(long j) {
        return ArraysKt.a(this.f42339a, j);
    }

    public int b(long j) {
        return ArraysKt.b(this.f42339a, j);
    }

    public int c(long j) {
        return ArraysKt.c(this.f42339a, j);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Long) {
            return a(((Number) obj).longValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f42339a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Long) {
            return b(((Number) obj).longValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f42339a.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Long) {
            return c(((Number) obj).longValue());
        }
        return -1;
    }
}
