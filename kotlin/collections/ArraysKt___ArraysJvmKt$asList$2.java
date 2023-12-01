package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysJvmKt$asList$2.class */
public final class ArraysKt___ArraysJvmKt$asList$2 extends AbstractList<Short> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ short[] f42337a;

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: a */
    public Short get(int i) {
        return Short.valueOf(this.f42337a[i]);
    }

    public boolean a(short s) {
        return ArraysKt.a(this.f42337a, s);
    }

    public int b(short s) {
        return ArraysKt.b(this.f42337a, s);
    }

    public int c(short s) {
        return ArraysKt.c(this.f42337a, s);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Short) {
            return a(((Number) obj).shortValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f42337a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Short) {
            return b(((Number) obj).shortValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f42337a.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Short) {
            return c(((Number) obj).shortValue());
        }
        return -1;
    }
}
