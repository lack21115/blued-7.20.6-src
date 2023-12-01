package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$1.class */
public final class UArraysKt___UArraysJvmKt$asList$1 extends AbstractList<UInt> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int[] f42417a;

    public boolean a(int i) {
        return UIntArray.b(this.f42417a, i);
    }

    public int b(int i) {
        return UIntArray.a(this.f42417a, i);
    }

    public int c(int i) {
        return ArraysKt.b(this.f42417a, i);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return a(((UInt) obj).a());
        }
        return false;
    }

    public int d(int i) {
        return ArraysKt.c(this.f42417a, i);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* synthetic */ Object get(int i) {
        return UInt.d(b(i));
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UIntArray.a(this.f42417a);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof UInt) {
            return c(((UInt) obj).a());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return UIntArray.c(this.f42417a);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof UInt) {
            return d(((UInt) obj).a());
        }
        return -1;
    }
}
