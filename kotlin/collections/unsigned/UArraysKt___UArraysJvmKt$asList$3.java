package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$3.class */
public final class UArraysKt___UArraysJvmKt$asList$3 extends AbstractList<UByte> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ byte[] f42419a;

    public byte a(int i) {
        return UByteArray.a(this.f42419a, i);
    }

    public boolean a(byte b) {
        return UByteArray.a(this.f42419a, b);
    }

    public int b(byte b) {
        return ArraysKt.b(this.f42419a, b);
    }

    public int c(byte b) {
        return ArraysKt.c(this.f42419a, b);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return a(((UByte) obj).a());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* synthetic */ Object get(int i) {
        return UByte.d(a(i));
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UByteArray.a(this.f42419a);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof UByte) {
            return b(((UByte) obj).a());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return UByteArray.c(this.f42419a);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof UByte) {
            return c(((UByte) obj).a());
        }
        return -1;
    }
}
