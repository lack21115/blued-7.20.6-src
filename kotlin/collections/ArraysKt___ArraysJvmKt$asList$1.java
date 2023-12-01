package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysJvmKt$asList$1.class */
public final class ArraysKt___ArraysJvmKt$asList$1 extends AbstractList<Byte> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ byte[] f42336a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArraysKt___ArraysJvmKt$asList$1(byte[] bArr) {
        this.f42336a = bArr;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: a */
    public Byte get(int i) {
        return Byte.valueOf(this.f42336a[i]);
    }

    public boolean a(byte b) {
        return ArraysKt.a(this.f42336a, b);
    }

    public int b(byte b) {
        return ArraysKt.b(this.f42336a, b);
    }

    public int c(byte b) {
        return ArraysKt.c(this.f42336a, b);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Byte) {
            return a(((Number) obj).byteValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f42336a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Byte) {
            return b(((Number) obj).byteValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f42336a.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Byte) {
            return c(((Number) obj).byteValue());
        }
        return -1;
    }
}
