package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysJvmKt$asList$7.class */
public final class ArraysKt___ArraysJvmKt$asList$7 extends AbstractList<Boolean> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean[] f42342a;

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: a */
    public Boolean get(int i) {
        return Boolean.valueOf(this.f42342a[i]);
    }

    public boolean a(boolean z) {
        return ArraysKt.a(this.f42342a, z);
    }

    public int b(boolean z) {
        return ArraysKt.b(this.f42342a, z);
    }

    public int c(boolean z) {
        return ArraysKt.c(this.f42342a, z);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Boolean) {
            return a(((Boolean) obj).booleanValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f42342a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            return b(((Boolean) obj).booleanValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f42342a.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Boolean) {
            return c(((Boolean) obj).booleanValue());
        }
        return -1;
    }
}
