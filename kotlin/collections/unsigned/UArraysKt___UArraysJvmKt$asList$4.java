package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$4.class */
public final class UArraysKt___UArraysJvmKt$asList$4 extends AbstractList<UShort> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ short[] f42420a;

    public short a(int i) {
        return UShortArray.a(this.f42420a, i);
    }

    public boolean a(short s) {
        return UShortArray.a(this.f42420a, s);
    }

    public int b(short s) {
        return ArraysKt.b(this.f42420a, s);
    }

    public int c(short s) {
        return ArraysKt.c(this.f42420a, s);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return a(((UShort) obj).a());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* synthetic */ Object get(int i) {
        return UShort.d(a(i));
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UShortArray.a(this.f42420a);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof UShort) {
            return b(((UShort) obj).a());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return UShortArray.c(this.f42420a);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof UShort) {
            return c(((UShort) obj).a());
        }
        return -1;
    }
}
