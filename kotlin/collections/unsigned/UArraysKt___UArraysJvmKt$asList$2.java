package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$2.class */
public final class UArraysKt___UArraysJvmKt$asList$2 extends AbstractList<ULong> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long[] f42418a;

    public long a(int i) {
        return ULongArray.a(this.f42418a, i);
    }

    public boolean a(long j) {
        return ULongArray.a(this.f42418a, j);
    }

    public int b(long j) {
        return ArraysKt.b(this.f42418a, j);
    }

    public int c(long j) {
        return ArraysKt.c(this.f42418a, j);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return a(((ULong) obj).a());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* synthetic */ Object get(int i) {
        return ULong.d(a(i));
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return ULongArray.a(this.f42418a);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof ULong) {
            return b(((ULong) obj).a());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return ULongArray.c(this.f42418a);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof ULong) {
            return c(((ULong) obj).a());
        }
        return -1;
    }
}
